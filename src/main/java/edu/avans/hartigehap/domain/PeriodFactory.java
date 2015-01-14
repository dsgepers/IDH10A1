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
		DateTime reservationDate = start;
		for ( int i = reservedDays; i >= 0; i--) {
			if (i == 0) 
				lastDay = true;
			
			if (firstDay) {
				boolean oneDayReservation = start.dayOfYear() == end.dayOfYear() && start.year() == end.year();
				firstDay = false;
				
				if (isMorning(startHour)) {
					periods.add(new Morning(reservationDate));
					if (oneDayReservation) {
						if (isEvening(endHour)) {
							periods.add(new Afternoon(reservationDate));
							periods.add(new Evening(reservationDate));
						} else if (isAfternoon(endHour)) {
							periods.add(new Afternoon(reservationDate));
						}
					}
				} else if (isAfternoon(startHour)) {
					periods.add(new Afternoon(reservationDate));
					if (oneDayReservation) {
						if (isEvening(endHour)) {
							periods.add(new Evening(reservationDate));
						}
					}
				} else if (isEvening(startHour)) {
					periods.add(new Evening(reservationDate));
				}
			}
			else if (lastDay) {
				if (isMorning(endHour)) {
					periods.add(new Morning(reservationDate));
				} else if (isAfternoon(endHour)) {
					periods.add(new Morning(reservationDate));
					periods.add(new Afternoon(reservationDate));
				} else if (isEvening(endHour)) {
					periods.add(new Morning(reservationDate));
					periods.add(new Afternoon(reservationDate));
					periods.add(new Evening(reservationDate));
				}
				
			} else {
				//normal days
				periods.add(new Morning(reservationDate));
				periods.add(new Afternoon(reservationDate));
				periods.add(new Evening(reservationDate));
			}
			reservationDate = reservationDate.plusDays(1);
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
