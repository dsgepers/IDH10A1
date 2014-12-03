package edu.avans.hartigehap.domain;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ExtraRum extends CocktailDecorator {

	private static final long serialVersionUID = 1L;
	
	@Transient
	private Cocktail cocktail;
	
	//private String description;
	
	private double cost;
	
	
	public ExtraRum(Cocktail cocktail) {
		this.cocktail = cocktail;
	}
	
	@Override
	public double cost() {
		return cocktail.cost() + cost;
	}
}
