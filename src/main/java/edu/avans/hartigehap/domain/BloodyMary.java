package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

@Entity
public class BloodyMary extends Cocktail {

	private static final long serialVersionUID = 1L;
	
	private double cost;
	
	
	public BloodyMary() {
		super.setDescription("Bloody Mary");
	}
	
	@Override
	public double cost() {
		return cost;
	}

}
