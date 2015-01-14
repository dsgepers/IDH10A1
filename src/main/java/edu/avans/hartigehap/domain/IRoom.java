package edu.avans.hartigehap.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by panda on 18-12-14.
 */

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter

public abstract class IRoom extends DomainObject {
	private static final long serialVersionUID = 1L;
	
	// JPA is case sensitive: the corresponding column name will be in small
	// caps "price"
	private int price;
	// natural id (so no auto generation needed)
//	@Id
//	private String id;
	
	public IRoom(){
		
	}
	
	public IRoom(String id, int price)
	{
		this.price = price;
//		this.id = id; 
		
	}
	
	public abstract int cost();
	public abstract String description();
	
}