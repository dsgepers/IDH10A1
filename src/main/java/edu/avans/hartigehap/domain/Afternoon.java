package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

import org.joda.time.DateTime;

@Entity
public class Afternoon extends IPeriod {

	private DateTime date;
	
	public Afternoon (DateTime date) {
		this.date = date.withTime(13, 0, 0, 0);
	}
	
	@Override
	public void setDate(DateTime date) {
		this.date = date;
	}

}
