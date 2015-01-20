package edu.avans.hartigehap.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public abstract class Addition extends IRoom {

	private static final long serialVersionUID = 1L;
	
	public Addition(){
		
	}
	
	public Addition(IRoom iroom, int price, Vat vat){
		super(iroom.getDescription(), price, vat);
		setIroom(iroom);
	}
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name="decorating")
	public IRoom iroom;
}
