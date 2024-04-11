package com.vladproduction.springbootmultidatasource.accountdb.controller;

import com.vladproduction.springbootmultidatasource.accountdb.entity.Account;
import com.vladproduction.springbootmultidatasource.accountdb.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vladproduction on 11-Apr-24
 */

@RestController
@RequestMapping("api/account_db")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/saveAccount")
    public Account saveAccount(@RequestBody Account account){

        return accountRepository.save(account);
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts(){

        return accountRepository.findAll();
    }
}
