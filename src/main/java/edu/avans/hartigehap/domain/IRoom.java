package edu.avans.hartigehap.domain;

import javax.persistence.Entity;
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
	
	public IRoom(){
		
	}
	
	public IRoom(String id, int cost)
	{
		
	}
	
	public abstract int cost();
	public abstract String description();
	
}