package com.vladproduction.springtransactions.controllers;

import com.vladproduction.springtransactions.models.Sale;
import com.vladproduction.springtransactions.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 14-Mar-24
 */

@RestController
@RequestMapping("api/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/save")
    public Sale saveSale(@RequestBody Sale sale) {
        return saleService.saveSale(sale);
    }

    @GetMapping("/{id}")
    public Optional<Sale> findSaleById(@PathVariable Long id) {
        return saleService.findSaleById(id);
    }

    @GetMapping("/all")
    public List<Sale> findAllSales() {
        return saleService.findAllSales();
    }

    @PatchMapping("/{id}/update")
    public int updateSaleById(@PathVariable Long id, @RequestBody Sale sale) {
        return saleService.updateSaleById(id, sale);
    }

    @DeleteMapping("/{id}/delete")
    public int deleteSaleById(@PathVariable Long id) {
        return saleService.deleteSaleById(id);
    }

}
