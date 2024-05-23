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
	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(FilterCriteriaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("start student entity saving");

		Student student1 = new Student();
		student1.setName("John");
		student1.setAddress("NY");
		student1.setHobby("Hockey");
		studentRepository.save(student1);

		Student student2 = new Student();
		student2.setName("Bob");
		student2.setAddress("CH");
		student2.setHobby("Basketball");
		studentRepository.save(student2);

		Student student3 = new Student();
		student3.setName("Jack");
		student3.setAddress("COL");
		student3.setHobby("Football");
		studentRepository.save(student3);

		Student student4 = new Student();
		student4.setName("Stan");
		student4.setAddress("MIN");
		student4.setHobby("Volleyball");
		studentRepository.save(student4);

		Student student5 = new Student();
		student5.setName("Bobby");
		student5.setAddress("MIA");
		student5.setHobby("Cycling");
		studentRepository.save(student5);

		Student student6 = new Student();
		student6.setName("Tom");
		student6.setAddress("LA");
		student6.setHobby("Running");
		studentRepository.save(student6);

		Student student7 = new Student();
		student7.setName("Lia");
		student7.setAddress("FY");
		student7.setHobby("Jumping");
		studentRepository.save(student7);

		Student student8 = new Student();
		student8.setName("Gerry");
		student8.setAddress("NEI");
		student8.setHobby("Skying");
		studentRepository.save(student8);

		Student student9 = new Student();
		student9.setName("Fill");
		student9.setAddress("VA");
		student9.setHobby("Snowboarding");
		studentRepository.save(student9);

		Student student10 = new Student();
		student10.setName("Nick");
		student10.setAddress("DC");
		student10.setHobby("Swimming");
		studentRepository.save(student10);

		Student student11 = new Student();
		student11.setName("Danny");
		student11.setAddress("TOR");
		student11.setHobby("Workout");
		studentRepository.save(student11);

		Student student12 = new Student();
		student12.setName("Rihanna");
		student12.setAddress("NO");
		student12.setHobby("Singing");
		studentRepository.save(student12);

		log.info("students saved");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Employee employee1 = new Employee();
		employee1.setName("Arny");
		employee1.setSalary(25000);
		employee1.setSkill(Subject.ENGLISH);
		employee1.setDoh(sdf.parse("25/10/2023"));
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setName("Silvester");
		employee2.setSalary(35000);
		employee2.setSkill(Subject.MATHS);
		employee2.setDoh(sdf.parse("07/03/2020"));
		employeeRepository.save(employee2);

		Employee employee3 = new Employee();
		employee3.setName("Norris");
		employee3.setSalary(55000);
		employee3.setSkill(Subject.SOCIAL);
		employee3.setDoh(sdf.parse("14/09/2007"));
		employeeRepository.save(employee3);

		Employee employee4 = new Employee();
		employee4.setName("Jason");
		employee4.setSalary(45000);
		employee4.setSkill(Subject.PROGRAMMING);
		employee4.setDoh(sdf.parse("24/08/2019"));
		employeeRepository.save(employee4);

		Employee employee5 = new Employee();
		employee5.setName("Dolf");
		employee5.setSalary(28000);
		employee5.setSkill(Subject.SCIENCE);
		employee5.setDoh(sdf.parse("10/04/2014"));
		employeeRepository.save(employee5);

		Employee employee6 = new Employee();
		employee6.setName("Bruis");
		employee6.setSalary(55000);
		employee6.setSkill(Subject.SOCIAL);
		employee6.setDoh(sdf.parse("19/01/2003"));
		employeeRepository.save(employee6);


	}
}
