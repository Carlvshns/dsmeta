package dev.carlvs.dsmeta.services;

import java.time.LocalDate;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.carlvs.dsmeta.domain.Sale;
import dev.carlvs.dsmeta.repository.SaleRepository;
import dev.carlvs.dsmeta.utils.SaleCreator;

@ExtendWith(SpringExtension.class)
public class SaleServiceTest {

    @InjectMocks
    private SaleService saleService;
    @Mock
    private SaleRepository saleRepositoryMock;

    @BeforeEach
    void setUp(){
        PageImpl<Sale> salePage = new PageImpl<>(List.of(SaleCreator.saleCreator()));

        BDDMockito.when(saleRepositoryMock.findSales(ArgumentMatchers.any(LocalDate.class), 
        ArgumentMatchers.any(LocalDate.class), ArgumentMatchers.any(PageRequest.class)))
        .thenReturn(salePage);
    }

    @Test
    @DisplayName("findSales returns list of sales inside page object when sucessful")
    void findSales_ReturnsListOfSalesInsidePageObect_WhenSucessful() {
        String expectedSellerName = SaleCreator.saleCreator().getSellerName();
        Page<Sale> salePage = saleService.findSales("", "", PageRequest.of(1, 1));

        Assertions.assertNotNull(salePage);

        Assertions.assertFalse(salePage.toList().isEmpty());

        Assertions.assertEquals(1, salePage.toList().size());

        Assertions.assertEquals(expectedSellerName, salePage.toList().get(0).getSellerName());
    }
}
