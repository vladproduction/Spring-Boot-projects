package com.example.demospringsecurity.service;

import com.example.demospringsecurity.data.Product;
import com.example.demospringsecurity.entity.UserInfo;
import com.example.demospringsecurity.repository.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = null;

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostConstruct
    public void loadProductFromDB(){
        productList = IntStream.range(1, 100)
                .mapToObj(i->Product.builder()
                        .id(i)
                        .name("product " + i)
                        .price(new Random().nextInt(1000))
                        .qty(new Random().nextInt(10)).build()
                        ).toList();
    }

    public List<Product> getProducts(){
        return productList;
    }

    public Product getProduct(int id){
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Product" + id + "not found"));
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system";
    }
}
