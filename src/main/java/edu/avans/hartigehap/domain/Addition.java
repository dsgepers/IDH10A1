package edu.avans.hartigehap.domain;

import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Addition extends IRoom {

	private static final long serialVersionUID = 1L;
	
	public Addition(){
		
	}
	
	public Addition(IRoom iroom){
		super(iroom.getId() + "#", iroom.getPrice() );
		setIroom(iroom);
	}
	
	@OneToOne
	public IRoom iroom;
}
