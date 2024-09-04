package com.org.entity_annotation;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JavaTrainer implements Trainer {
	
	private String name;
	private List<String> modules;
	
	public JavaTrainer() {
		System.out.println("Default constructor of Javatrainer called.");
	}
	
	public JavaTrainer(String name, List<String> modules) {
		this.name = name;
		this.modules = modules;
		System.out.println("Parameterized constructor of Javatrainer called.");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}

	@Override
	public void train() {
		System.out.println(name+" is teaching "+modules);
	}

	@Override
	public String toString() {
		return "JavaTrainer [name=" + name + ", modules=" + modules + "]";
	}
	
}
