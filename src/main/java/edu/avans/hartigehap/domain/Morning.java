package edu.avans.hartigehap.domain;

import javax.persistence.Entity;

import org.joda.time.DateTime;

@Entity
public class Morning extends IPeriod {

	private DateTime date;
	
	@Override
	public void setDate(DateTime date) {
		this.date = date;
	}

}
