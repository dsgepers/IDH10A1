package edu.avans.hartigehap.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter @Setter
public abstract class CocktailDecorator extends Cocktail {
	private static final long serialVersionUID = 1L;

	public CocktailDecorator () {
		
	}
	
	@OneToOne
	private Cocktail cocktail;
	
}
