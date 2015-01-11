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
	
	public Room(String id, int cost){
		
	}
	
	@Override
	public int cost() {

		return 0;
	}

	@Override
	public String description() {

		return null;
	}

}
