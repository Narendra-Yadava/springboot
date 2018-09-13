package com.yadav.springbootbasic;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBasicApplication {

	public static void main(String[] args) {
		System.out.println("SpringbootBasicApplication initialization start at "+Calendar.getInstance().getTime());
		SpringApplication.run(SpringbootBasicApplication.class, args);
		System.out.println("SpringbootBasicApplication initialization end at "+Calendar.getInstance().getTime());

	}
}
