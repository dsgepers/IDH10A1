package edu.avans.hartigehap.domain;

import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Addition extends IRoom {

	private static final long serialVersionUID = 1L;
	
	public Addition(){
		
	}
	
	public Addition(IRoom iroom, Vat vat){
		super(iroom.getDescription(), iroom.getPrice(), vat);
		setIroom(iroom);
	}
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	public IRoom iroom;
}
