package com.vladproduction.logginglevelsspring.service;

import com.vladproduction.logginglevelsspring.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 13-Mar-24
 */

@Service
public class ProductServiceImpl implements ProductService {

    ///////////////////// simple example of method findById(long id) //////////////////////////////
    /*@Override
    public Product findById(long id) {
        List<Product> productList = initProducts();
        for (Product product : productList) {
            if (product.getId() == id){
                Optional<Product> optionalProduct = Optional.of(product);
                return optionalProduct.orElse(null);
            }
        }
        return null;
    }*/

    ///////////////////// stream example of method findById(long id) //////////////////////////////

    @Override
    public Product findById(long id) {
        List<Product> productList = initProducts();
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private static List<Product> initProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L));
        productList.add(new Product(2L));
        productList.add(new Product(3L));
        return productList;
    }
}
