package com.vladproduction.jpabasic.controller;

import com.vladproduction.jpabasic.dto.DepartmentDto;
import com.vladproduction.jpabasic.dto.InstructorDto;
import com.vladproduction.jpabasic.entity.Department;
import com.vladproduction.jpabasic.entity.Instructor;
import com.vladproduction.jpabasic.mapper.InstructorMapper;
import com.vladproduction.jpabasic.service.DepartmentService;
import com.vladproduction.jpabasic.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 16-Apr-24
 */

@RestController
@RequestMapping("api/jpa-basic")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveInstructor")
    public ResponseEntity<InstructorDto> saveInstructor(
            @RequestBody InstructorDto instructorDto){

        Instructor instructor = InstructorMapper.mapToInstructor(instructorDto);
        DepartmentDto departmentDto = instructorDto.getDepartmentDto();
        if(departmentDto != null){
            String departmentName = departmentDto.getDepartmentName();
            if (departmentName != null){
                Optional<Department> department = departmentService.findByDepartmentName(departmentName);
                department.ifPresent(instructor::setDepartment);
            }
        }
        Instructor savedInstructor = instructorService.saveInstructor(instructor);
        InstructorDto savedInstructorDto = InstructorMapper.mapToInstructorDto(savedInstructor);
        return ResponseEntity.ok(savedInstructorDto);
    }

    @GetMapping("/findAllInstructors")
    public ResponseEntity<List<InstructorDto>> findAllInstructors(){
        List<Instructor> allInstructors = instructorService.findAllInstructors();
        List<InstructorDto> instructorDtoList = InstructorMapper.mapToInstructorsDto(allInstructors);
        return ResponseEntity.ok(instructorDtoList);
    }

    @GetMapping("/findInstructorById/{instructorId}")
    public ResponseEntity<Optional<InstructorDto>> findInstructorById(
            @PathVariable Long instructorId){
        Optional<Instructor> instructorById = instructorService.findInstructorById(instructorId);
        if(instructorById.isPresent()){
            Instructor instructor = instructorById.get();
            InstructorDto instructorDto = InstructorMapper.mapToInstructorDto(instructor);
            return ResponseEntity.ok(Optional.of(instructorDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findByExperience/{experience}")
    public ResponseEntity<Optional<List<InstructorDto>>> findByExperience(
            @PathVariable Integer experience){
        Optional<List<Instructor>> instructorList = instructorService.findByExperience(experience);
        if(instructorList.isPresent()){
            List<Instructor> instructors = instructorList.get();
            List<InstructorDto> instructorDtoList = InstructorMapper.mapToInstructorsDto(instructors);
            return ResponseEntity.ok(Optional.of(instructorDtoList));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findByFirstNameAndLastName")
    public ResponseEntity<Optional<InstructorDto>> findByFirstNameAndLastName(
            @RequestParam String firstName, @RequestParam String lastName){
        Optional<Instructor> optionalInstructor = instructorService.findByFirstNameAndLastName(firstName, lastName);
        if(optionalInstructor.isPresent()){
            Instructor instructor = optionalInstructor.get();
            InstructorDto instructorDto = InstructorMapper.mapToInstructorDto(instructor);
            return ResponseEntity.ok(Optional.of(instructorDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findByInstructorPhone")
    public ResponseEntity<Optional<InstructorDto>> findByInstructorPhone(
            @RequestParam String instructorPhone){
        Optional<Instructor> optionalInstructor = instructorService.findByInstructorPhone(instructorPhone);
        if(optionalInstructor.isPresent()){
            Instructor instructor = optionalInstructor.get();
            InstructorDto instructorDto = InstructorMapper.mapToInstructorDto(instructor);
            return ResponseEntity.ok(Optional.of(instructorDto));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findInstructorByDepartmentName")
    public ResponseEntity<Optional<InstructorDto>> findInstructorByDepartmentDepartmentName(
            @RequestParam String departmentName){
        Optional<Instructor> instructorOptional = instructorService.findInstructorByDepartmentDepartmentName(departmentName);
        if (instructorOptional.isPresent()){
            Instructor instructor = instructorOptional.get();
            InstructorDto instructorDto = InstructorMapper.mapToInstructorDto(instructor);
            return ResponseEntity.ok(Optional.of(instructorDto));
        }
        return ResponseEntity.notFound().build();
    }


}
