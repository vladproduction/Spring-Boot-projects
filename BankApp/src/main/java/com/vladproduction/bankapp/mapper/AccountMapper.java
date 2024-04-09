package com.vladproduction.bankapp.mapper;

import com.vladproduction.bankapp.dto.AccountDto;
import com.vladproduction.bankapp.entity.Account;

/**
 * Created by vladproduction on 08-Apr-24
 */

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        //creating account by using dto data and return it
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }

}
