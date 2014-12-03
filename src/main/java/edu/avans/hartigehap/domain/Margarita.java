package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

@Entity
public class Margarita extends Cocktail {

	private static final long serialVersionUID = 1L;
	
	private double cost = 3.75;
	
	public Margarita() {
		super.setDescription("Margarita");
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return cost;
	}	

}
