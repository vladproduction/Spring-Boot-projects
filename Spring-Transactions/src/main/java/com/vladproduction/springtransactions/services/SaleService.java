package com.vladproduction.springtransactions.services;

import com.vladproduction.springtransactions.dao.SaleDao;
import com.vladproduction.springtransactions.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 14-Mar-24
 */

@Service
public class SaleService {

    @Autowired
    private SaleDao saleDao;

    public Sale saveSale(Sale sale){
        return saleDao.save(sale);
    }

    public Optional<Sale> findSaleById(Long id){
        return saleDao.findById(id);
    }

    public List<Sale> findAllSales(){
        return new ArrayList<>(saleDao.findAll());
    }

    public int updateSaleById(Long id, Sale saleCandidate){
        Optional<Sale> sale = findSaleById(id);
        if(sale.isPresent()){
            if(saleCandidate.getSale_info() != null ){
                sale.get().setSale_info(saleCandidate.getSale_info());
            }
            if (saleCandidate.getPrice() != 0.0){
                sale.get().setPrice(saleCandidate.getPrice());
            }
            saleDao.save(sale.get());
            return 1;
        }else {
            System.out.println("Sale not found with ID: " + id);
            return 0;
        }
    }


    public int deleteSaleById(Long id) {
        Optional<Sale> sale = findSaleById(id);
        if (sale.isPresent()) {
            saleDao.deleteById(id); // method in DAO
            return 1; // Deleting success
        } else {
            System.out.println("Sale not found with ID: " + id + ". Deleting fail");
            return 0; // Deleting fail
        }
    }

}
