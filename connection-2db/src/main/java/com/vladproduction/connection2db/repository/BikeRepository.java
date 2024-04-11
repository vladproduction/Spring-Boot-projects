package com.vladproduction.connection2db.repository;

import com.vladproduction.connection2db.entity.bike.Bike;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Repository
public class BikeRepository {

    @Autowired
    @Qualifier("bikeEntityManagerFactory")
    private EntityManagerFactory bikeEntityManagerFactory;

    public void save(Bike bike){
        EntityManager entityManager = bikeEntityManagerFactory.createEntityManager();
        entityManager.persist(bike);
//        entityManager.flush();
        entityManager.close();
    }

}
