package com.vladproduction.springjmssimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringJmsSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsSimpleApplication.class, args);
	}

}
