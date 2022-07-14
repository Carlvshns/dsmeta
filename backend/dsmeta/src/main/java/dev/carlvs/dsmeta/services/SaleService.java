package dev.carlvs.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.carlvs.dsmeta.domain.Sale;
import dev.carlvs.dsmeta.repository.SaleRepository;

@Service
public class SaleService {
    
    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
        
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        
        return saleRepository.findSales(min, max, pageable);
    }
}
