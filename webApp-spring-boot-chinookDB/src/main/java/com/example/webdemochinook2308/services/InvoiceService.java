package com.example.webdemochinook2308.services;


import com.example.webdemochinook2308.data.Invoice;
import com.example.webdemochinook2308.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    public List<Invoice> getCheapestInvoiceList() {
        return invoiceRepository.findByMinTotal();
    }
}
