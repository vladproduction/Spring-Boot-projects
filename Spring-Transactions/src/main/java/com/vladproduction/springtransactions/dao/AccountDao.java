package com.vladproduction.springtransactions.dao;

import com.vladproduction.springtransactions.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vladproduction on 30-Mar-24
 */

public interface AccountDao extends JpaRepository<Account, Long> {
}
