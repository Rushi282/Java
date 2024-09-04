package com.org.entity;

public class JavaWorkshop implements Workshop {
	
	private TrainingCompany company;
	
	public JavaWorkshop() {
		System.out.println("Default constructor of JavaWorkshop is called");
	}

	public JavaWorkshop(TrainingCompany company) {
		this.company = company;
		System.out.println("Parameterized constructor of JavaWorkshop is called");
	}

	@Override
	public void conductWorkshop() {
		System.out.println("Java Workshop is started");
		company.conductTraining();
	}

	@Override
	public String toString() {
		return "JavaWorkshop [company=" + company + "]";
	}

}
