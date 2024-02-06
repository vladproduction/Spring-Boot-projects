package com.vladproduction.inversionofcontrolexample;

import com.vladproduction.inversionofcontrolexample.arithmeticOperations.Division;
import com.vladproduction.inversionofcontrolexample.arithmeticOperations.Multiplication;
import com.vladproduction.inversionofcontrolexample.arithmeticOperations.Subtraction;
import com.vladproduction.inversionofcontrolexample.arithmeticOperations.Sum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InversionOfControlExampleApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(InversionOfControlExampleApplication.class, args);
//		Hello h = new HelloImpl("hi");
//		h.sayHi();

		//xml context from file
//		ApplicationContext contextHello =
//				new ClassPathXmlApplicationContext("helloSpringXMLConfig.xml");
//		Hello h = (Hello)contextHello.getBean("hello");
//		h.sayHi();

//		ApplicationContext contextGift =
//				new ClassPathXmlApplicationContext("giftSpringXMLConfig.xml");
//		NewYearGift newYearGift = (NewYearGift) contextGift.getBean("giftCar");
//		newYearGift.print();
//
//		newYearGift = (NewYearGift) contextGift.getBean("giftTeddyBear");
//		newYearGift.print();

//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("battlesSpringXMLConfig.xml");
//		NapoleonicBattles napoleonicBattles = (NapoleonicBattles) context.getBean("napoleonicBattles");
//		napoleonicBattles.printBattles();

	}

	@Autowired
	ApplicationContext context;
	@Override
	public void run(String... args) throws Exception {
//		Hello bean = (Hello)context.getBean("hello");
//		Hello bean2 = (Hello)context.getBean("hello2");
//		bean.sayHi();
//		bean2.sayHi();
//
//		int hashCode = bean.hashCode();
//		int hashCode2 = bean2.hashCode();
//
//		System.out.println("hashCode = bean" + hashCode);
//		System.out.println("hashCode2 = bean2" + hashCode2);
//		System.out.println("-------------------------");
//		bean = (Hello)context.getBean("hello");
//		bean2 = (Hello)context.getBean("hello2");
//		hashCode = bean.hashCode();
//		hashCode2 = bean2.hashCode();
//
//		System.out.println("hashCode = bean" + hashCode);
//		System.out.println("hashCode2 = bean2" + hashCode2);

//		MySingleton bean = context.getBean("mySingleton", MySingleton.class);
//		bean.doAction();
//		bean = context.getBean("mySingletonExtra", MySingleton.class);
//		bean.doAction();
//
//		bean = context.getBean("mySingletonExtra", MySingleton.class);
//		bean.doAction();

//		context.getBean("printClothes");


		Sum sum = context.getBean(Sum.class);
		System.out.println("sum = " + sum.execute(10, 20));
		System.out.println("---------------------");

		Subtraction subtraction = context.getBean(Subtraction.class);
		System.out.println("subtraction = " + subtraction.execute(10, 20));
		System.out.println("---------------------");

		Multiplication multiplication = context.getBean(Multiplication.class);
		System.out.println("multiplication = " + multiplication.execute(10, 20));
		System.out.println("---------------------");

		Division division = context.getBean(Division.class);
		System.out.println("division = " + (double)division.execute(10, 20));
		System.out.println("---------------------");


	}
}
