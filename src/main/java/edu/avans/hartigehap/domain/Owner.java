package edu.avans.hartigehap.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "OWNERS")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter @Setter
public class Owner extends DomainObject {

	private static final long serialVersionUID = 1L;	 
	
	@Column(name = "Name")	
	private String name;
	
	@ManyToMany(cascade=javax.persistence.CascadeType.ALL)
	private List<Restaurant> restaurants;
	
	
	@Override
	public String toString() {
		return "Owner [id=" + super.getId() + ", name=" + name + "]";
	}
}
