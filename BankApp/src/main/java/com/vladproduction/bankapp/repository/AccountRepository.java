package com.vladproduction.bankapp.repository;

import com.vladproduction.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vladproduction on 08-Apr-24
 */

public interface AccountRepository extends JpaRepository<Account, Long> {
}
