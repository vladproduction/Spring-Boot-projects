package com.vladproduction.springbootmultidatasource.accountdb.service;

import com.vladproduction.springbootmultidatasource.accountdb.entity.Account;
import com.vladproduction.springbootmultidatasource.accountdb.repository.AccountRepository;
import com.vladproduction.springbootmultidatasource.userdb.entity.User;
import com.vladproduction.springbootmultidatasource.userdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vladproduction on 11-Apr-24
 */

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void save(Account account){
        accountRepository.save(account);
    }


}
