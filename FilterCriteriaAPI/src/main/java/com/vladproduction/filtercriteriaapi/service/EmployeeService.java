package com.vladproduction.filtercriteriaapi.service;


import com.vladproduction.filtercriteriaapi.model.*;
import com.vladproduction.filtercriteriaapi.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

import static com.vladproduction.filtercriteriaapi.helpers.HelperConfig.isDateColumn;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    /** simple approach*/

    /** [GET]: /byName */
    public List<Employee> getEmployeeByNameHardCoded(){
        Specification<Employee> specification = getSpecificationHardCodedByName();
        log.info("[GET]: /byName");

        return employeeRepository.findAll(specification);
    }

    private Specification<Employee> getSpecificationHardCodedByName(){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("name"), "Arny"); //hard coded value
        };
    }


    /** dynamic approach*/

    /** [GET]: /byEquals_ */
    public List<Employee> getEmployeeData(SpecificationInput specificationInput) throws ParseException {
        Specification<Employee> specification = getSpecificationByEquals(specificationInput);
        if (specificationInput.getColumnName().equalsIgnoreCase("name")) log.info("[GET]: /byEquals_name");
        if (specificationInput.getColumnName().equalsIgnoreCase("salary")) log.info("[GET]: /byEquals_salary");
        if (specificationInput.getColumnName().equalsIgnoreCase("skill")) log.info("[GET]: /byEquals_skill");
        if (specificationInput.getColumnName().equalsIgnoreCase("doh")) log.info("[GET]: /byEquals_doh");

        return employeeRepository.findAll(specification);
    }

    /**
     * helper method:
     * -define column data type;
     * -return specification in lambda expression;
     * @param input (String columnName; String value)
     */
    private Specification<Employee> getSpecificationByEquals(SpecificationInput input) throws ParseException {
        String columnName = input.getColumnName();
        String value = input.getValue();
        if (isDateColumn(columnName)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse(value);
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(columnName), date);
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(columnName), value);
    }

    /** [GET]: /byBetweenDates */
    public List<Employee> getEmployeesBetweenDates(SpecificationInput input) throws ParseException {
        Specification<Employee> specificationBetweenDates = getEmployeesSpecificationBetweenDates(input);

        return employeeRepository.findAll(specificationBetweenDates);
    }

    /**
     * helper method:
     * -setting two dates;
     * @param input (String columnName; String value);
     * @return value of data by chosen column name in between two dates
     */
    private Specification<Employee> getEmployeesSpecificationBetweenDates(SpecificationInput input) throws ParseException {
        String value = input.getValue();
        String[] values = value.split(";");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dateStart = sdf.parse(values[0]);
        Date dateEnd = sdf.parse(values[1]);

        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(input.getColumnName()), dateStart, dateEnd);
    }

    /** [GET]: /byBetweenDatesSorted */
    public List<Employee> getEmployeesBetweenDatesSorted(SpecificationInputSort specificationInputSort) throws ParseException {
        Specification<Employee> empSorted = getEmployeesSpecificationBetweenDatesSorted(specificationInputSort);
        String sortColumn = specificationInputSort.getSortColumn();
        String sortOrder = specificationInputSort.getSortOrder();
        boolean sortFlag = sortOrder.equalsIgnoreCase("ASC");
        Sort sort = Sort.by(sortFlag?Sort.Direction.ASC: Sort.Direction.DESC, sortColumn);

        return employeeRepository.findAll(empSorted, sort);
    }

    /**
     * helper method:
     * -setting two dates as parameter between for sorting;
     * -setting ASC or DESC sortOrder;
     * @param inputSort (String columnName; String value; String sortColumn; String sortOrder);
     * @return value of data by chosen column name in between two dates and sorted;
     */
    private Specification<Employee> getEmployeesSpecificationBetweenDatesSorted(SpecificationInputSort inputSort)
            throws ParseException {
        String value = inputSort.getValue();
        String[] values = value.split(";");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dateStart = sdf.parse(values[0]);
        Date dateEnd = sdf.parse(values[1]);

        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(inputSort.getColumnName()), dateStart, dateEnd);
    }

    /** [GET]: /byBetweenDatesSortedPaging */
    public List<Employee> getEmployeesBetweenDatesSortedPaging(SpecificationInputSortPaging inputSortPaging) throws ParseException {
        Specification<Employee> empSpecBetweenDatesSortedPaging = getEmployeesSpecificationBetweenDatesSortedPaging(inputSortPaging);
        String sortColumn = inputSortPaging.getSortColumn();
        String sortOrder = inputSortPaging.getSortOrder();
        int pageNumber = 0; //default value
        int pageSize = 2; //default value
        pageNumber = inputSortPaging.getPageNumber() >= 0 ? inputSortPaging.getPageNumber():pageNumber;
        pageSize = inputSortPaging.getPageSize() >= 0 ? inputSortPaging.getPageSize():pageSize;
        boolean sortFlag = sortOrder.equalsIgnoreCase("ASC");
        Sort sort = Sort.by(sortFlag?Sort.Direction.ASC: Sort.Direction.DESC, sortColumn);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Employee> employeePage = employeeRepository.findAll(empSpecBetweenDatesSortedPaging, pageable);

        return employeePage.getContent();
    }

    /**
     * helper method:
     * -setting two dates as parameter between for sorting;
     * -setting ASC or DESC sortOrder;
     * -setting page started and number of units to show by each page;
     * @param inputSortPaging (String columnName; String value; String sortColumn; String sortOrder;
     *                        Integer pageNumber; Integer pageSize;)
     * @return value of data by chosen column name in between two dates and sorted by pages;
     */
    private Specification<Employee> getEmployeesSpecificationBetweenDatesSortedPaging(SpecificationInputSortPaging inputSortPaging)
            throws ParseException {
        String value = inputSortPaging.getValue();
        String[] values = value.split(";");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dateStart = sdf.parse(values[0]);
        Date dateEnd = sdf.parse(values[1]);

        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(inputSortPaging.getColumnName()), dateStart, dateEnd);
    }

    //todo: byLike_salary, byLike_doh
    /** [GET]: /byLike */
    public List<Employee> getEmployeeByLike(SpecificationInput specificationInput){
        Specification<Employee> employeeSpecification = getEmployeeSpecificationByLike(specificationInput);

        return employeeRepository.findAll(employeeSpecification);
    }

    /**
     * helper method:
     * -setting parameters as like operation
     * @param input (String columnName; String value;)
     * @return value of data by chosen column name in cae of matching like;
     */
    private Specification<Employee> getEmployeeSpecificationByLike(SpecificationInput input){

        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(input.getColumnName()),"%" + input.getValue() + "%");
    }

    //todo: /byGreaterThanOrEqualTo_doh
    /** [GET]: /greaterThanOrEqualTo */
    public List<Employee> getGreaterThan(SpecificationInput specificationInput){
        Specification<Employee> specificationByGreaterThan = getSpecificationByGreaterThan(specificationInput);

        return employeeRepository.findAll(specificationByGreaterThan);
    }

    /**
     * helper method:
     * -setting parameters as graterThan
     * @param input (String columnName; String value)
     * @return value of data by chosen column name in cae of graterThan;
     */
    private Specification<Employee> getSpecificationByGreaterThan(SpecificationInput input){

        return (root, query, criteriaBuilder) -> criteriaBuilder
                .greaterThanOrEqualTo(root.get(input.getColumnName()), input.getValue());
    }


    //todo: /byLessThanOrEqualTo_doh
    /** [GET]: /lessThanOrEqualTo */
    public List<Employee> getLessThan(SpecificationInput specificationInput) {
        Specification<Employee> specificationByLessThan = getSpecificationByLessThan(specificationInput);

        return employeeRepository.findAll(specificationByLessThan);
    }

    /**
     * helper method:
     * -setting parameters as lessThan
     * @param input (String columnName; String value)
     * @return value of data by chosen column name in cae of lessThan;
     */
    private Specification<Employee> getSpecificationByLessThan(SpecificationInput input){

        return (root, query, criteriaBuilder) -> criteriaBuilder
                .lessThanOrEqualTo(root.get(input.getColumnName()), input.getValue());
    }

    /** [GET] /byGraterThanToAndDelete */
    /** .count */
    /** .exist */
    /** .delete */
    /**
     * similarly we can do by criteria less than
     * */
    public Long getOperationsGraterThanToAndDelete(SpecificationInput specificationInput){
        log.info("[GET] /byGraterThanToAndDelete REST API");
        Specification<Employee> specOperationsByGreaterThan = getSpecificationOperationsByGreaterThan(specificationInput);
        //count
        long employeesCount = employeeRepository.count(specOperationsByGreaterThan);
        log.info("Employee count is :{}", employeesCount);
        //exist
        boolean employeeExists = employeeRepository.exists(specOperationsByGreaterThan);
        log.info("Employee exist :{}", employeeExists);
        //delete
        long deleteStatus = 0;
        if(employeeExists){
            deleteStatus = employeeRepository.delete(specOperationsByGreaterThan);
        }
        log.info("Employee deleted :{}", deleteStatus);

        return deleteStatus;
    }

    /**
     * helper method:
     * -setting parameters as graterThan for values need to count, check if exist and delete
     * @param input (String columnName; String value)
     * @return value of data by chosen column name in cae of graterThan;
     */
    private Specification<Employee> getSpecificationOperationsByGreaterThan(SpecificationInput input){

        return (root, query, criteriaBuilder) -> criteriaBuilder
                .greaterThanOrEqualTo(root.get(input.getColumnName()), input.getValue());
    }


    /** [GET] /getDetailsFromList */
    public List<Employee> getDetailsFromList(List<SearchSpecification> searchSpecificationList){
        Specification<Employee> specification = getSpecificationForList(searchSpecificationList);

        return employeeRepository.findAll(specification);
    }

    /**
     * helper method to return criteria for:
     * -List<Predicate>,
     *      as example:
     * -/equal:      search1 is for column-'name'
     * -/graterThan: search2 is by column-'salary'
     * */
    private Specification<Employee> getSpecificationForList(List<SearchSpecification> searchSpecificationList){
        SearchSpecification search1 = searchSpecificationList.get(0);
        SearchSpecification search2 = searchSpecificationList.get(1);

        List<Predicate> predicateList = new ArrayList<>();

        return (root, query, criteriaBuilder) -> {
            //first predicate is 'equal' based
            Predicate equal = criteriaBuilder.equal(root.get(search1.getColumnName()), search1.getValue());
            //second predicate is 'greaterThan' based
            Predicate greaterThan = criteriaBuilder.greaterThan(root.get(search2.getColumnName()), search2.getValue());
            //need to add this predicates to list
            predicateList.add(equal);
            predicateList.add(greaterThan);
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }

    /** [GET] /getDetailsFromListGenerally */
    public List<Employee> getDetailsFromListGenerally(
            List<SearchSpecificationGenerally> searchSpecificationGenerally, String overallOperation){
        Specification<Employee> specificationForListGenerally =
                getSpecificationForListGenerally(searchSpecificationGenerally, overallOperation);

        return employeeRepository.findAll(specificationForListGenerally);
    }

    /**
     * helper method:
     * -to return criteria for different cases;
     * -AND; OR; scenarios also available
     * */
    private Specification<Employee> getSpecificationForListGenerally(
            List<SearchSpecificationGenerally> searchSpecificationListGenerally, String overallOperation){

        List<Predicate> predicateList = new ArrayList<>();

        return (root, query, criteriaBuilder) -> {
            for (SearchSpecificationGenerally searchSpecGen: searchSpecificationListGenerally){
                String operation = searchSpecGen.getOperation();
                switch (operation){
                    case "EQUAL" -> {
                        Predicate equal = criteriaBuilder
                                .equal(root.get(searchSpecGen.getColumnName()), searchSpecGen.getValue());
                        predicateList.add(equal);
                    }
                    case "GREATER_THAN" -> {
                        Predicate greaterThan = criteriaBuilder
                                .greaterThan(root.get(searchSpecGen.getColumnName()), searchSpecGen.getValue());
                        predicateList.add(greaterThan);
                    }
                    case "GREATER_THAN_EQUAL" -> {
                        Predicate greaterThanOrEqualTo = criteriaBuilder
                                .greaterThanOrEqualTo(root.get(searchSpecGen.getColumnName()), searchSpecGen.getValue());
                        predicateList.add(greaterThanOrEqualTo);
                    }
                    case "LESS_THAN" -> {
                        Predicate lessThan = criteriaBuilder
                                .lessThan(root.get(searchSpecGen.getColumnName()), searchSpecGen.getValue());
                        predicateList.add(lessThan);
                    }
                    case "LESS_THAN_EQUAL" -> {
                        Predicate lessThanOrEqualTo = criteriaBuilder
                                .lessThanOrEqualTo(root.get(searchSpecGen.getColumnName()), searchSpecGen.getValue());
                        predicateList.add(lessThanOrEqualTo);
                    }
                    case "LIKE" -> {
                        Predicate like = criteriaBuilder
                                .like(root.get(searchSpecGen.getColumnName()), "%" + searchSpecGen.getValue() + "%");
                        predicateList.add(like);
                    }
                    case "IN" -> {
                        String[] searchSG = searchSpecGen.getValue().split(",");
                        //in db is: SELECT * FROM EMPLOYEE where name in ('Arny','Norris');
                        Predicate in = root.get(searchSpecGen.getColumnName()).in(List.of(searchSG));
                        predicateList.add(in);
                    }
                    case "JOIN" ->{
                        Predicate join  = criteriaBuilder
                                .equal(root.join(searchSpecGen.getJoinTable())
                                        .get(searchSpecGen.getColumnName()), searchSpecGen.getValue());
                        predicateList.add(join);
                    }
                }
            }
            if("AND".equalsIgnoreCase(overallOperation)){
                return criteriaBuilder.and(predicateList.toArray(predicateList.toArray(new Predicate[0])));
            } else {
                return criteriaBuilder.or(predicateList.toArray(predicateList.toArray(new Predicate[0])));
            }
        };
    }


    /**Idea: to create one more entity,
     * so it will be possible to modelling scenario of joining tables of this entities */

    //stopped at 08:35
}
