package com.vladproduction.connection2db.repository;

import com.vladproduction.connection2db.entity.car.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Repository
public class CarRepository {

    @Autowired
    @Qualifier("carEntityManagerFactory")
    private EntityManagerFactory carEntityManagerFactory;

    public void save(Car car){
        EntityManager entityManager = carEntityManagerFactory.createEntityManager();
        entityManager.persist(car);
//        entityManager.flush();
        entityManager.close();
    }

}
