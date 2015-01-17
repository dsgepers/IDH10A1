package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter
public class MenuConference extends Addition {

	private static final long serialVersionUID = 1L;

	
	public MenuConference(){
		
	}

	public MenuConference(IRoom iroom, int price){
		super(iroom);
		iroom.setPrice(price);
		
	}
	
	public int GetTotal() {
		return getPrice() + getIroom().GetTotal();
	}


	public String description() {
		return getIroom().description() + ", " + "MenuConference";
	}

}
