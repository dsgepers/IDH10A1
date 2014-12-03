package edu.avans.hartigehap.domain;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class Cocktail extends Drink {
	private static final long serialVersionUID = 1L;

	private String description;
	
	
	public abstract double cost();
}
