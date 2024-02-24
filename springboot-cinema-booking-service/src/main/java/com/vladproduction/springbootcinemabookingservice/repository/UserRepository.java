package com.vladproduction.springbootcinemabookingservice.repository;

import com.vladproduction.springbootcinemabookingservice.model.impl.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {

    Optional<User> getUserByEmail(String email);

    List<User> getUsersByName(String name);


}
