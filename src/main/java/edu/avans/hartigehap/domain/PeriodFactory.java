package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class PeriodFactory {

	public List<IPeriod> buildPeriod(DateTime start, DateTime end) {

		List<IPeriod> periods = new ArrayList<IPeriod>();
		int reservedDays = Days.daysBetween(start.withTimeAtStartOfDay(), end.withTimeAtStartOfDay() ).getDays();
		int startHour = start.getHourOfDay();
		int endHour = end.getHourOfDay();
		
		boolean firstDay = true;
		boolean lastDay = false;
		for ( int i = reservedDays; i >= 0; i--) {
			if (i == 0) 
				lastDay = true;
			
			if (firstDay) {
				boolean oneDayReservation = start.dayOfYear() == end.dayOfYear() && start.year() == end.year();
				firstDay = false;
				
				if (isMorning(startHour)) {
					periods.add(new Morning(start));
					if (oneDayReservation) {
						if (isEvening(endHour)) {
							periods.add(new Afternoon(start));
							periods.add(new Evening(start));
						} else if (isAfternoon(endHour)) {
							periods.add(new Afternoon(start));
						}
					}
				} else if (isAfternoon(startHour)) {
					periods.add(new Afternoon(start));
					if (oneDayReservation) {
						if (isEvening(endHour)) {
							periods.add(new Evening(start));
						}
					}
				} else if (isEvening(startHour)) {
					periods.add(new Evening(start));
				}
			}
			else if (lastDay) {
				if (isMorning(endHour)) {
					periods.add(new Morning(start));
				} else if (isAfternoon(endHour)) {
					periods.add(new Morning(start));
					periods.add(new Afternoon(start));
				} else if (isEvening(endHour)) {
					periods.add(new Morning(start));
					periods.add(new Afternoon(start));
					periods.add(new Evening(start));
				}
				
			} else {
				//normal days
				//TODO: 'start' datetime veranderen naar juiste datum waarde (in alle new aanroepen!)
				periods.add(new Morning(start));
				periods.add(new Afternoon(start));
				periods.add(new Evening(start));
			}
		}
		
		return periods;
	}
	
	private boolean isMorning (int startHour) {
		return isBetween(startHour, 8, 12);
	}
	
	private boolean isAfternoon (int startHour) {
		return isBetween(startHour, 13, 17);	
	}	
	
	private boolean isEvening (int startHour) {
		return isBetween(startHour, 18, 21);
	}
	
	
	private boolean isBetween(int x, int lower, int upper) {
		  return lower <= x && x <= upper;
	}
}
