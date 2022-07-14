package dev.carlvs.dsmeta.endpoint;

import dev.carlvs.dsmeta.domain.Sale;
import dev.carlvs.dsmeta.services.SaleService;
import dev.carlvs.dsmeta.services.SmsService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/sales")
public class SaleController {
    
    private SaleService saleService;

    private SmsService smsService;

    public SaleController(dev.carlvs.dsmeta.services.SaleService saleService, SmsService smsService) {
        this.saleService = saleService;
        this.smsService = smsService;
    }

    @GetMapping
    public Page<Sale> findSale(@RequestParam(value = "minDate", defaultValue = "") String minDate, 
        @RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable){
        return saleService.findSales(minDate, maxDate, pageable);
    }

    @GetMapping(path = "/{id}/notification")
    public void notifySms(@PathVariable("id") Long id){
        smsService.sendSms(id);
    }
}
