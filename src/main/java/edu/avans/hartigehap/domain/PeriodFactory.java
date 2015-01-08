package edu.avans.hartigehap.domain;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class PeriodFactory {

	public List<CalendarPeriod> buildPeriod(DateTime start, DateTime end) {

		Interval interval = new Interval(start, end);
		
		

		return null;
	}
}
