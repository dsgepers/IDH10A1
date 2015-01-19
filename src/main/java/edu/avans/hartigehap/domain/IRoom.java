package edu.avans.hartigehap.domain;

import java.util.List;

import javax.persistence.*;

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
	
	@ManyToOne(cascade = javax.persistence.CascadeType.ALL)
	private Vat vat;

	
	public IRoom(){
		
	}
	
	public IRoom(String description, int price, Vat vat)
	{
		this.price = price;
		this.description = description;
		this.vat = vat;
		
	}
	
	public abstract double getTotal();
	public abstract double getTotalWithVAT();
	public abstract String description();
	
}
