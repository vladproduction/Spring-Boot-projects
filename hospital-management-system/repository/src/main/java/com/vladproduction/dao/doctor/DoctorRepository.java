package com.vladproduction.dao.doctor;

import com.vladproduction.model.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vladproduction on 29-Mar-24
 */

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
