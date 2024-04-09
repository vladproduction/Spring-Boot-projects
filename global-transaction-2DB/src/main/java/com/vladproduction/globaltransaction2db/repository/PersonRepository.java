package com.vladproduction.globaltransaction2db.repository;

import com.vladproduction.globaltransaction2db.entity.Person;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 09-Apr-24
 */

@Repository
public class PersonRepository {

    @Autowired
    private EntityManager entityManager;

    public void save(Person person){
        entityManager.persist(person);
    }
}
