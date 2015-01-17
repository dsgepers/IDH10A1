package edu.avans.hartigehap.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Rooms") 
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter

public abstract class IRoom extends DomainObject {
	private static final long serialVersionUID = 1L;
	
	// JPA is case sensitive: the corresponding column name will be in small
	// caps "price"
	private int price;
	
	private String description;
	
	@OneToMany(mappedBy="room")
	private List<Reservation> reservations;

	
	public IRoom(){
		
	}
	
	public IRoom(String description, int price)
	{
		this.price = price;
		this.description = description;
		
	}
	
	public abstract int cost();
	public abstract String description();
	
}