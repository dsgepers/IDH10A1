package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public abstract class Cocktail extends Drink {
	private static final long serialVersionUID = 1L;

	public Cocktail() {
		
	}
	
	private String description;
	
	
	public abstract double cost();
}
