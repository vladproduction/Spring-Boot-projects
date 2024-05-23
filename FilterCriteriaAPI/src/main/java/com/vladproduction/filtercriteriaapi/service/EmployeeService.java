package com.vladproduction.filtercriteriaapi.service;

import com.vladproduction.filtercriteriaapi.exception.NoValuesFoundForDatesException;
import com.vladproduction.filtercriteriaapi.model.Employee;
import com.vladproduction.filtercriteriaapi.model.SpecificationInput;
import com.vladproduction.filtercriteriaapi.model.Subject;
import com.vladproduction.filtercriteriaapi.repository.EmployeeRepository;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    /** ////////////////////simple approach/////////////////////*/
    /** equal */
    public List<Employee> getEmployeeByName(){
        Specification<Employee> specification = getSpecification();
        return employeeRepository.findAll(specification);
    }

    private Specification<Employee> getSpecification(){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("name"), "Arny"); //hard coded value
        };
    }



    /** ////////////////////dynamic approach/////////////////////*/
    /** equal */
    public List<Employee> getEmployeeData(SpecificationInput specificationInput){
        Specification<Employee> specification = getSpecification(specificationInput);
        return employeeRepository.findAll(specification);
    }
    private Specification<Employee> getSpecification(SpecificationInput specificationInput){
        String columnName = specificationInput.getColumnName();
        String value = specificationInput.getValue();
        if(isDateColumn(columnName)){
            LocalDate localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Date date = java.sql.Date.valueOf(localDate);
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(columnName), date);
        }
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(columnName), value);
        };
    }
    //reflection approach (check the entity field.getType is same as Data.class):
    private boolean isDateColumn(String columnName) {
        try {
            Class<?> entityClass = Employee.class; // entity class
            Field field = entityClass.getDeclaredField(columnName);
            return field.getType().equals(java.util.Date.class) // java.sql.Date depending on field type
                    || field.isAnnotationPresent(Temporal.class); // Check for @Temporal annotation
        } catch (NoSuchFieldException | SecurityException e) {
            log.debug("NoSuchFieldException catch");
            return false;
        }
    }



    /** between */
    public List<Employee> getEmployeesBetweenDates(SpecificationInput input) throws NoValuesFoundForDatesException {

        Specification<Employee> specificationBetweenDates = getEmployeesSpecificationBetweenDates(input);

        //added fields sortColumn & sortOrder in SpecificationInput
        //now we have sortable data in cases: ASC, DESC
        String sortColumn = input.getSortColumn(); //after added in class we pass in Postman as well
        String sortOrder = input.getSortOrder();

        //in case we add Pagination logic we have to create objects for that
        //we define default value in case we number of page is '0';
        int pageNumber = 0;
        int pageSize = 2;
        pageNumber = input.getPageNumber() >= 0 ? input.getPageNumber():pageNumber;
        pageSize = input.getPageSize() >= 0 ? input.getPageSize():pageSize;

        boolean sortFlag = sortOrder.equalsIgnoreCase("ASC");

        Sort sort = Sort.by(sortFlag?Sort.Direction.ASC: Sort.Direction.DESC, sortColumn);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

//        return employeeRepository.findAll(specificationBetweenDates, sort);
        Page<Employee> employeePage = employeeRepository.findAll(specificationBetweenDates, pageable);

        return employeePage.getContent();
    }
    private Specification<Employee> getEmployeesSpecificationBetweenDates(SpecificationInput input)
            throws NoValuesFoundForDatesException {

        String columnName = input.getColumnName();
        String value = input.getValue();
        String[] values = value.split(";"); //splitter symbol in array we pass in Postman for "value"
        if(isDateColumn(columnName)){
            LocalDate localDateStart = LocalDate.parse(values[0], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Date dateStart = java.sql.Date.valueOf(localDateStart);
            LocalDate localDateEnd = LocalDate.parse(values[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Date dateEnd = java.sql.Date.valueOf(localDateEnd);
            return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(columnName), dateStart, dateEnd);
        }else {
            throw new NoValuesFoundForDatesException("No values found between dates for column: " + columnName);
        }
    }


    //todo: byLike_doh, byLike_salary
    /** like */
    public List<Employee> getEmployeeByLike(SpecificationInput specificationInput){
        Specification<Employee> employeeSpecification = getEmployeeSpecificationByLike(specificationInput);
        return employeeRepository.findAll(employeeSpecification);
    }
    private Specification<Employee> getEmployeeSpecificationByLike(SpecificationInput input){
        String columnName = input.getColumnName();
        String value = input.getValue();
        if(isDateColumn(columnName)){
            if (isDate(value)){
                LocalDate localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Date date = java.sql.Date.valueOf(localDate);
            return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(columnName), "%" + date + "%");
            }
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(columnName),"%"+ value +"%");
    }
    private boolean isDate(String value) {
        String regex = "^(\\d{4})-(\\d{2})-(\\d{2})$"; // YYYY-MM-DD format
        return value.matches(regex);
    }


    /** greaterThanOrEqualTo, lessThanOrEqualTo */
    public List<Employee> getGreaterThan(SpecificationInput specificationInput){
        Specification<Employee> specificationByGreaterThan = getSpecificationByGreaterThan(specificationInput);
        return employeeRepository.findAll(specificationByGreaterThan);
    }
    private Specification<Employee> getSpecificationByGreaterThan(SpecificationInput input){
        return (root, query, criteriaBuilder) -> criteriaBuilder
                .greaterThanOrEqualTo(root.get(input.getColumnName()), input.getValue());
    }





}
