package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter
public class Beamer extends Addition {

	private static final long serialVersionUID = 1L;

	public Beamer(){
		
	}

	public Beamer(IRoom iroom, int price){
		super(iroom);
		iroom.setPrice(price);
		
	}
	
	public int cost() {
		return getPrice() + getIroom().cost();
	}


	public String description() {
		return getIroom().description() + ", " + "Beamer";
	}

}
