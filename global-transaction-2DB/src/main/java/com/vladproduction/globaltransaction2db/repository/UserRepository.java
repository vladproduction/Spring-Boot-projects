package com.vladproduction.globaltransaction2db.repository;

import com.vladproduction.globaltransaction2db.entity.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 09-Apr-24
 */

//@Repository
public class UserRepository {

//    @Autowired
//    @PersistenceContext()
    private EntityManager userEntityManager;

    public void save(User user){
        userEntityManager.persist(user);
    }
}
