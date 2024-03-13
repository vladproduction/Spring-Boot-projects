package com.vladproduction.logginglevelsspring.service;

import com.vladproduction.logginglevelsspring.model.Product;

/**
 * Created by vladproduction on 13-Mar-24
 */

public interface ProductService {

    Product findById(long id);


}
