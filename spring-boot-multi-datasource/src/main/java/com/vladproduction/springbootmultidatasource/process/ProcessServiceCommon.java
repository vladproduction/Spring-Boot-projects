package com.vladproduction.springbootmultidatasource.process;

import com.vladproduction.springbootmultidatasource.accountdb.entity.Account;
import com.vladproduction.springbootmultidatasource.accountdb.service.AccountService;
import com.vladproduction.springbootmultidatasource.userdb.entity.User;
import com.vladproduction.springbootmultidatasource.userdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vladproduction on 11-Apr-24
 */

@Service
@Transactional
public class ProcessServiceCommon {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    public void processCommon(){
        Account account = new Account();
        account.setName("commonAcc-1");
        account.setWebsite("www.commonAcc1.com");
        accountService.save(account);

        User user = new User();
        user.setFirstName("Sammy");
        user.setLastName("Mainy");
        user.setEmail("SammyMainy@gmail.com");
        userService.save(user);
    }
}
