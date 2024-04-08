package com.vladproduction.springtransactions.services;

import com.vladproduction.springtransactions.dao.AccountDao;
import com.vladproduction.springtransactions.models.Account;
import com.vladproduction.springtransactions.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 30-Mar-24
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public Account saveAccount(Account account){
        return accountDao.save(account);
    }

    public Optional<Account> findAccountById(Long id){
        return accountDao.findById(id);
    }

    public List<Account> findAllAccounts(){
        return new ArrayList<>(accountDao.findAll());
    }

    public int updateAccountById(Long id, Account accountCandidate){
        Optional<Account> account = findAccountById(id);
        if(account.isPresent()){
            if(accountCandidate.getAcc_number() != 0){
                account.get().setAcc_number(accountCandidate.getAcc_number());
            }
            if(accountCandidate.getBalance() != 0){
                account.get().setBalance(accountCandidate.getBalance());
            }
            accountDao.save(account.get());
            return 1;
        }else {
            System.out.println("Account not found with ID: " + id);
            return 0;
        }
    }

    public int deleteAccountById(Long id) {
        Optional<Account> account = findAccountById(id);
        if (account.isPresent()) {
            accountDao.deleteById(id); // method in DAO
            return 1; // Deleting success
        } else {
            System.out.println("Account not found with ID: " + id + ". Deleting fail");
            return 0; // Deleting fail
        }
    }


}
