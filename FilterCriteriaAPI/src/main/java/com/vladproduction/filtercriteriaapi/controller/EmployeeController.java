package com.vladproduction.filtercriteriaapi.controller;


import com.vladproduction.filtercriteriaapi.model.Employee;
import com.vladproduction.filtercriteriaapi.model.SpecificationInput;
import com.vladproduction.filtercriteriaapi.model.SpecificationInputSort;
import com.vladproduction.filtercriteriaapi.model.SpecificationInputSortPaging;
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
    List<Employee> getByBetweenDates(@RequestBody SpecificationInput specificationInput) throws ParseException {
        return employeeService
                .getEmployeesBetweenDates(specificationInput);
    }

    @GetMapping("/byBetweenDatesSorted")
    List<Employee> getByBetweenDatesSorted(@RequestBody SpecificationInputSort specificationInputSort) throws ParseException {
        return employeeService
                .getEmployeesBetweenDatesSorted(specificationInputSort);
    }

    @GetMapping("/byBetweenDatesSortedPaging")
    List<Employee> getByBetweenDatesSortedPaging(@RequestBody SpecificationInputSortPaging specificationInputSortPaging)
            throws ParseException {
        return employeeService
                .getEmployeesBetweenDatesSortedPaging(specificationInputSortPaging);
    }

    @GetMapping("/byLike")
    List<Employee> getByLikeOperation(@RequestBody SpecificationInput specificationInput){
        return employeeService
                .getEmployeeByLike(specificationInput);
    }

    @GetMapping("/byGreaterThanOrEqualTo")
    List<Employee> getByGreaterThanOrEqualTo(@RequestBody SpecificationInput specificationInput){
        return employeeService
                .getGreaterThan(specificationInput);
    }



}
