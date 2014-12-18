package edu.avans.hartigehap.domain;

import javax.persistence.*;

import org.joda.time.DateTime;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class CalendarPeriod {

	@Id
	private Long id;
	
	public abstract void setDate(DateTime date);
	

}
