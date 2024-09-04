package com.org.entity;

public class MetInfotech implements TrainingCompany {
	
	private Trainer trainer;
	
	public MetInfotech() {
		System.out.println("Default constructor of MetInfotech is called");
	}
	
	public MetInfotech(Trainer trainer) {
		this.trainer = trainer;
		System.out.println("Parameterized constructor of MetInfotech is called");
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	@Override
	public void conductTraining() {
		System.out.println("MetInfotech is conducting training.");
		trainer.train();
	}

	@Override
	public String toString() {
		return "MetInfotech [trainer=" + trainer + "]";
	}

}
