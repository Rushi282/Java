package com.org.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.entity.JavaWorkshop;

public class SpringTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		 JavaWorkshop javaWorkshop = context.getBean(JavaWorkshop.class);
		 javaWorkshop.conductWorkshop();
	}

}
