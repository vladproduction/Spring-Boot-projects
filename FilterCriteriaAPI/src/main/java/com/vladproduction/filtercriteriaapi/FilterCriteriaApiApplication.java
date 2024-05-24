package com.vladproduction.filtercriteriaapi;

import com.vladproduction.filtercriteriaapi.model.Employee;
import com.vladproduction.filtercriteriaapi.model.Subject;
import com.vladproduction.filtercriteriaapi.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class FilterCriteriaApiApplication implements CommandLineRunner {

	private final EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(FilterCriteriaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		Employee employee1 = new Employee();
		employee1.setName("Arny");
		employee1.setSalary(25000);
		employee1.setSkill(Subject.ENGLISH);
		employee1.setDoh(sdf.parse("2023/01/01"));
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setName("Silvester");
		employee2.setSalary(35000);
		employee2.setSkill(Subject.MATHS);
		employee2.setDoh(sdf.parse("2022/01/01"));
		employeeRepository.save(employee2);

		Employee employee3 = new Employee();
		employee3.setName("Norris");
		employee3.setSalary(55000);
		employee3.setSkill(Subject.SOCIAL);
		employee3.setDoh(sdf.parse("2021/01/01"));
		employeeRepository.save(employee3);

		Employee employee4 = new Employee();
		employee4.setName("Jason");
		employee4.setSalary(45000);
		employee4.setSkill(Subject.PROGRAMMING);
		employee4.setDoh(sdf.parse("2020/01/01"));
		employeeRepository.save(employee4);

		Employee employee5 = new Employee();
		employee5.setName("Dolf");
		employee5.setSalary(28000);
		employee5.setSkill(Subject.SCIENCE);
		employee5.setDoh(sdf.parse("2019/01/01"));
		employeeRepository.save(employee5);

		Employee employee6 = new Employee();
		employee6.setName("Bruis");
		employee6.setSalary(55000);
		employee6.setSkill(Subject.SOCIAL);
		employee6.setDoh(sdf.parse("2018/01/01"));
		employeeRepository.save(employee6);

	}
}
