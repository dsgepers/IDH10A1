package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

@Entity
public class ExtraRum extends CocktailDecorator {

	private static final long serialVersionUID = 1L;
	
	private double cost;
	
	
	public ExtraRum(Cocktail cocktail) {
		setCocktail(cocktail);
	}
	
	@Override
	public double cost() {
		return getCocktail().cost() + cost;
	}
}
