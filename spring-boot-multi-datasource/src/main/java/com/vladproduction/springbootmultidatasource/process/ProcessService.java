package com.vladproduction.springbootmultidatasource.process;

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
public class ProcessService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public void process(){
        Account account = new Account();
        account.setName("account2");
        account.setWebsite("www.account2.com");
        accountRepository.save(account);

        User user = new User();
        user.setFirstName("Sammy");
        user.setLastName("Mainy");
        user.setEmail("SammyMainy@gmail.com");
        userRepository.save(user);
    }




}
