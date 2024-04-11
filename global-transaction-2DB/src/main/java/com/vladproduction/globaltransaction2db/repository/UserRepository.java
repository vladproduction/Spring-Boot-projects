package com.vladproduction.globaltransaction2db.repository;

import com.vladproduction.globaltransaction2db.entity.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 09-Apr-24
 */

@Repository
public class UserRepository {

    @Autowired
    @Qualifier("userEntityManagerFactory")
    private EntityManagerFactory userEntityManagerFactory;

    public void save(User user){
        EntityManager entityManager = userEntityManagerFactory.createEntityManager();
        entityManager.persist(user);
        entityManager.flush();
        entityManager.close();
    }
}
