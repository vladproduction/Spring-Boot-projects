package com.vladproduction.springbootcinemabookingservice.repository;

import com.vladproduction.springbootcinemabookingservice.model.impl.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Override
    Optional<UserAccount> findById(Long id);
}