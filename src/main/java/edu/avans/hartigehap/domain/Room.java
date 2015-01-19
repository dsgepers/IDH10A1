package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter

public class Room extends IRoom {

	private static final long serialVersionUID = 1L;

	public Room() {
		
	}
	
	public Room(String description, int price){
		super(description, price, VatFactory.getInstance().getVat("OTHER"));
		
	}
	

	public double getTotal() {
		return getPrice();
	}


	public String description() {
		return getDescription();
	}
	
	@Override
	public double getTotalWithVAT() {
		double price = getPrice();
		return price + getVat().calculateVat(price);
	}

}
