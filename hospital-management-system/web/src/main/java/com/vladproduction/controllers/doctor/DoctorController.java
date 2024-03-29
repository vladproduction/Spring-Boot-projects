package com.vladproduction.controllers.doctor;

import com.vladproduction.model.doctor.Doctor;
import com.vladproduction.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vladproduction on 29-Mar-24
 */

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

}
