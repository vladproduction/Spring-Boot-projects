package com.vladproduction.bankapp.service;

import com.vladproduction.bankapp.dto.AccountDto;

import java.util.List;

/**
 * Created by vladproduction on 08-Apr-24
 */

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);

}
