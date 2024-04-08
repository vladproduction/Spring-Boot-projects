package com.vladproduction.springtransactions.controllers;

import com.vladproduction.springtransactions.models.Account;
import com.vladproduction.springtransactions.models.Customer;
import com.vladproduction.springtransactions.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 30-Mar-24
 */

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/save")
    public Account saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }

    @GetMapping("/{id}")
    public Optional<Account> findAccountById(@PathVariable Long id){
        return accountService.findAccountById(id);
    }

    @GetMapping("/all")
    public List<Account> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @PatchMapping("/{id}/update")
    public int updateAccountById(@PathVariable Long id, @RequestBody Account account) {
        return accountService.updateAccountById(id, account);
    }

    @DeleteMapping("/{id}/delete")
    public int deleteAccountById(@PathVariable Long id) {
        return accountService.deleteAccountById(id);
    }


}
