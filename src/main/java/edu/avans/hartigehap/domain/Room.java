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
	
	public Room(String id, int price){
		super(id, price);
	}
	

	public int cost() {

		return getPrice();
	}


	public String description() {

		return null;
//				getId();
	}

}
