package dev.carlvs.dsmeta.endpoint;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.carlvs.dsmeta.domain.Sale;
import dev.carlvs.dsmeta.services.SaleService;
import dev.carlvs.dsmeta.utils.SaleCreator;

@ExtendWith(SpringExtension.class)
public class SaleControllerTest {

    @InjectMocks
    private SaleController saleController;
    @Mock
    private SaleService saleServiceMock;

    @BeforeEach
    void setUp(){
        PageImpl<Sale> salePage = new PageImpl<>(List.of(SaleCreator.saleCreator()));

        BDDMockito.when(saleServiceMock.findSales(ArgumentMatchers.anyString(), 
        ArgumentMatchers.anyString(), ArgumentMatchers.any(Pageable.class)))
        .thenReturn(salePage);
    }

    @Test
    @DisplayName("findSales returns list of sales inside page object when sucessful")
    void findSales_ReturnsListOfSalesInsidePageObect_WhenSucessful() {
        String expectedSellerName = SaleCreator.saleCreator().getSellerName();
        ResponseEntity<Page<Sale>> salePage = saleController.findSales("", "", PageRequest.of(1, 1));

        Assertions.assertNotNull(salePage);

        Assertions.assertFalse(salePage.getBody().isEmpty());

        Assertions.assertEquals(1, salePage.getBody().getSize());

        Assertions.assertEquals(HttpStatus.OK, salePage.getStatusCode());

        Assertions.assertEquals(expectedSellerName, salePage.getBody().getContent()
        .get(0).getSellerName());
    }
}
