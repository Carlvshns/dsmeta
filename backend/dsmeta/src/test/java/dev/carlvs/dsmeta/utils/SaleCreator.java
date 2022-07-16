package dev.carlvs.dsmeta.utils;

import java.time.LocalDate;
import java.time.ZoneId;

import dev.carlvs.dsmeta.domain.Sale;

public final class SaleCreator {
    
    public static Sale saleCreator(){
        Sale sale = new Sale();
        sale.setId(1L);
        sale.setSellerName("Barry Allen");
        sale.setVisited(10);
        sale.setDeals(8);
        sale.setAmount(2000.00);
        sale.setDate(LocalDate.now(ZoneId.systemDefault()));
        return sale;
    }
}
