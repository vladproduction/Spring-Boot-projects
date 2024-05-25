package com.vladproduction.filtercriteriaapi.controller;


import com.vladproduction.filtercriteriaapi.model.*;
import com.vladproduction.filtercriteriaapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/byName")
    public List<Employee> getByName(){
        return employeeService
                .getEmployeeByNameHardCoded();
    }

    @GetMapping("/byEquals")
    public List<Employee> getByEquals(@RequestBody SpecificationInput specificationInput) throws ParseException {
        return employeeService
                .getEmployeeData(specificationInput);
    }

    @GetMapping("/byBetweenDates")
    public List<Employee> getByBetweenDates(@RequestBody SpecificationInput specificationInput) throws ParseException {
        return employeeService
                .getEmployeesBetweenDates(specificationInput);
    }

    @GetMapping("/byBetweenDatesSorted")
    public List<Employee> getByBetweenDatesSorted(@RequestBody SpecificationInputSort specificationInputSort) throws ParseException {
        return employeeService
                .getEmployeesBetweenDatesSorted(specificationInputSort);
    }

    @GetMapping("/byBetweenDatesSortedPaging")
    public List<Employee> getByBetweenDatesSortedPaging(@RequestBody SpecificationInputSortPaging specificationInputSortPaging)
            throws ParseException {
        return employeeService
                .getEmployeesBetweenDatesSortedPaging(specificationInputSortPaging);
    }

    @GetMapping("/byLike")
    public List<Employee> getByLikeOperation(@RequestBody SpecificationInput specificationInput){
        return employeeService
                .getEmployeeByLike(specificationInput);
    }

    @GetMapping("/byGreaterThanOrEqualTo")
    public List<Employee> getByGreaterThanOrEqualTo(@RequestBody SpecificationInput specificationInput){
        return employeeService
                .getGreaterThan(specificationInput);
    }

    @GetMapping("/byLessThanOrEqualTo")
    public List<Employee> getByLessThanOrEqualTo(@RequestBody SpecificationInput specificationInput){
        return employeeService
                .getLessThan(specificationInput);
    }

    @GetMapping("/byGraterThanToAndDelete")
    public Long getOperationsGraterThanToAndDelete(@RequestBody SpecificationInput specificationInput){
        return employeeService
                .getOperationsGraterThanToAndDelete(specificationInput);
    }

    @GetMapping("/byDetailsFromList")
    public List<Employee> getDetailsFromList(@RequestBody RequestDTO input){
        return employeeService
                .getDetailsFromList(input.getSpecificationList());
    }

    @GetMapping("/getDetailsFromListGenerally")
    public List<Employee> getDetailsFromListGenerally(@RequestBody RequestDTOGenerally input){
        return employeeService
                .getDetailsFromListGenerally(input.getSpecificationListGenerally(), input.getOverallOperation());
    }






}
