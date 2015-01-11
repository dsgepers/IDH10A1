package edu.avans.hartigehap.domain;

import java.util.List;

import javax.persistence.*;

import org.joda.time.DateTime;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class IPeriod {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@ManyToOne
	private Reservation RESERVATION;
	
	public abstract void setDate(DateTime date);
	

}
