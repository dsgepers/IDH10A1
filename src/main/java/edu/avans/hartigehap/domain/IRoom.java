package edu.avans.hartigehap.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Rooms") 
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter

public abstract class IRoom extends DomainObject {
	private static final long serialVersionUID = 1L;
	
	private int price;
	
	private String description;
	
    @Column(name = "DTYPE", insertable = false, updatable = false)
    private String type;
	
	@OneToMany(mappedBy="room")
	private List<Reservation> reservations;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
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
