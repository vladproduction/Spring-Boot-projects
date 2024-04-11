package com.vladproduction.springbootmultidatasource.accountdb.repository;

import com.vladproduction.springbootmultidatasource.accountdb.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
