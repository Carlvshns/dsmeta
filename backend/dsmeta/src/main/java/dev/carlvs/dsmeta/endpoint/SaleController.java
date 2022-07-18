package dev.carlvs.dsmeta.endpoint;

import dev.carlvs.dsmeta.domain.Sale;
import dev.carlvs.dsmeta.services.SaleService;
import dev.carlvs.dsmeta.services.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/sales")
@Api(value = "Endpoints to manage Sales")
public class SaleController {
    
    private SaleService saleService;

    private SmsService smsService;

    public SaleController(SaleService saleService, SmsService smsService) {
        this.saleService = saleService;
        this.smsService = smsService;
    }

    @ApiOperation(value = "List all available Sales in Page with betwen minimal and maximum Date and order by Amount desc")
    @ApiResponse(code = 200, message = "OK", response = Sale[].class)
    @GetMapping(produces = "application/xml")
    public ResponseEntity<Page<Sale>> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate, 
        @RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable){
        return new ResponseEntity<>(saleService.findSales(minDate, maxDate, pageable), HttpStatus.OK);
    }

    @ApiOperation(value = "Send SMS to notify one phone about Seller")
    @ApiResponse(code = 204, message = "No Content", response = Void.class)
    @GetMapping(path = "/{id}/notification")
    public ResponseEntity<Void> notifySms(@PathVariable("id") Long id){
        smsService.sendSms(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
