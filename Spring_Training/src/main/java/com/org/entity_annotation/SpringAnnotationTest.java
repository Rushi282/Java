package com.org.entity_annotation;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationTest {
	public static void main(String[] args) {
		Class<SpringConfig> config = SpringConfig.class;
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config);
		JavaTrainer javaTrainer = context.getBean(JavaTrainer.class);
		ArrayList<String> modules = new ArrayList<String>();
		modules.add("oop");
		modules.add("Exception Handling");
		modules.add("Reflection");
		javaTrainer.setModules(modules);
		javaTrainer.setName("Jill");
		JavaWorkshop workshop = context.getBean(JavaWorkshop.class);
		workshop.conductWorkshop();
	}
}
