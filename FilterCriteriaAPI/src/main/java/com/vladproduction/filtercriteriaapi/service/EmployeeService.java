package com.vladproduction.filtercriteriaapi.service;


import com.vladproduction.filtercriteriaapi.model.Employee;
import com.vladproduction.filtercriteriaapi.model.SpecificationInput;
import com.vladproduction.filtercriteriaapi.model.SpecificationInputSort;
import com.vladproduction.filtercriteriaapi.model.SpecificationInputSortPaging;
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
import java.util.Date;
import java.util.List;

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

    /** helper method:
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

    /** helper method:
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

    /** helper method:
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

    /** helper method:
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

    /** helper method:
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

    /** helper method:
     * -setting parameters as graterThan
     * @param input (String columnName; String value)
     * @return value of data by chosen column name in cae of graterThan;
     */
    private Specification<Employee> getSpecificationByGreaterThan(SpecificationInput input){

        return (root, query, criteriaBuilder) -> criteriaBuilder
                .greaterThanOrEqualTo(root.get(input.getColumnName()), input.getValue());
    }

    /** [GET]: /lessThanOrEqualTo */


}
