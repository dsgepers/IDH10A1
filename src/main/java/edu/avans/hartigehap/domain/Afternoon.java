package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

@Entity
public class Afternoon extends IPeriod {
	private static final long serialVersionUID = 1L;

	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate date; 
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	//private DateTime date;
	
	
	public Afternoon (DateTime date, Reservation reservation) {
		this.date = date.toLocalDate();
		this.reservation = reservation;
	}
	
	@Override
	public void setDate(DateTime date) {
		this.date = date.toLocalDate();
	}

}
