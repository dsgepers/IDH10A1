package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

@Entity
public class Afternoon extends IPeriod {
	private static final long serialVersionUID = 1L;
	
	public Afternoon() {}

	public Afternoon (DateTime date, Reservation reservation) {
		this.date = date.toLocalDate();
		this.reservation = reservation;
	}
	
	@Override
	public void setDate(DateTime date) {
		this.date = date.toLocalDate();
	}

}
