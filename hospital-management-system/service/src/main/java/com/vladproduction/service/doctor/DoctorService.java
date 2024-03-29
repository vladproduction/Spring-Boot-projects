package com.vladproduction.service.doctor;

import com.vladproduction.dao.doctor.DoctorRepository;
import com.vladproduction.mailservice.EmailService;
import com.vladproduction.model.doctor.Doctor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vladproduction on 29-Mar-24
 */
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EmailService emailService;

    @PostConstruct
    public void initDoctor(){
        doctorRepository.saveAll(Stream.of(
                new Doctor(101, "John", "Cardio"),
                new Doctor(102, "Bob", "Therapeutic"))
                .collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors(){
        emailService.sendEmail();
        return doctorRepository.findAll();
    }

}
