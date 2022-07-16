package dev.carlvs.dsmeta.repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.carlvs.dsmeta.domain.Sale;
import dev.carlvs.dsmeta.utils.SaleCreator;

@DataJpaTest
@DisplayName("Tests for Sale Repository")
public class SaleRepositoryTest {

    @Autowired
    private SaleRepository saleRepository;

    @Test
    @DisplayName("FindSale returns list page of Sales when Sucessful")
    void findAll_ReturnsPageOfSales_WhenSucessful(){
        Sale saleToBeSaved = SaleCreator.saleCreator();
        
        this.saleRepository.save(saleToBeSaved);

        Pageable pageable = Pageable.ofSize(5);
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        Page<Sale> sales = this.saleRepository.findSales(today.minusDays(365), today, pageable);

        Assertions.assertFalse(sales.isEmpty());
    }
}
