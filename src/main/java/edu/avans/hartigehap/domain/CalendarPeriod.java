package edu.avans.hartigehap.domain;

import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;

@MappedSuperclass
public interface CalendarPeriod {
	
	public abstract void setDate(DateTime date);
	

}
