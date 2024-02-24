package com.vladproduction.springbootcinemabookingservice.service;


import com.vladproduction.springbootcinemabookingservice.model.impl.UserAccount;

public interface UserAccountService extends CrudService<UserAccount> {

    Double refillAccount(UserAccount account, Double amount);
}
