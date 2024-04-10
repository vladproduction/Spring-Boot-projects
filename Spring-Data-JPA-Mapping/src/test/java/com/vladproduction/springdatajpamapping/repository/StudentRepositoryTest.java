package com.vladproduction.springdatajpamapping.repository;

import com.vladproduction.springdatajpamapping.entity.Guardian;
import com.vladproduction.springdatajpamapping.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

//    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("DowJohn@gmail.com")
                .firstName("John")
                .lastName("Dow")
//                .guardianName("Mark Dow")
//                .guardianEmail("DowMark@gmail.com")
//                .guardianMobile("11112222")
                .build();

        studentRepository.save(student);
    }

//    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Mark Dow")
                .email("DowMark@gmail.com")
                .mobile("11112222")
                .build();

        Student student = Student.builder()
                .emailId("DowBob@gmail.com")
                .firstName("Bob")
                .lastName("Dow")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findAllStudents(){

        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentByFirstName(){

        List<Student> students = studentRepository.findByFirstName("Bob");

        System.out.println("students = " + students);

    }

    @Test
    public void findStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findByFirstNameContaining("hn");

        System.out.println("students = " + students);

    }

    @Test
    public void findByLastNameNotNull(){

        List<Student> students = studentRepository.findByLastNameNotNull();

        System.out.println("students = " + students);
    }

    @Test
    public void findStudentBasedOnGuardianName(){

        List<Student> students = studentRepository.findByGuardianName("Mark Dow");

        System.out.println("students = " + students);

    }

    @Test
    public void findByFirstNameAndLastName(){

        Student student = studentRepository.findByFirstNameAndLastName("Bob", "Dow");

        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddress(){

        Student student = studentRepository.getStudentByEmailAddress("DowJohn@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){

        String student = studentRepository.getStudentFirstNameByEmailAddress("DowJohn@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNative(){

        Student student = studentRepository.getStudentByEmailAddressNative("DowJohn@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeParam(){

        Student student = studentRepository.getStudentByEmailAddressNativeParam("DowJohn@gmail.com");

        System.out.println("student = " + student);
    }

}