package edu.avans.hartigehap.domain;

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class PeriodFactory {

	public CalendarPeriod buildPeriod(DateTime start, DateTime end) {

		Duration duration =  new Duration(start, end);
		long hours = duration.getStandardHours();

		return null;
	}
}
