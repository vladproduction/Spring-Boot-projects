package com.vladproduction.globaltransaction2db.repository;

import com.vladproduction.globaltransaction2db.entity.person.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 09-Apr-24
 */

@Repository
public class PersonRepository {

    @Autowired
    private EntityManagerFactory personEntityManager;

    public void save(Person person){
//        personEntityManager.persist(person);
    }
}
