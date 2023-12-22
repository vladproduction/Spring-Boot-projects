package com.example.webdemochinook2308.repositories;

import com.example.webdemochinook2308.data.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("select i from Invoice i where i.total = (select min(i2.total) from Invoice i2)")
    List<Invoice> findByMinTotal();

}