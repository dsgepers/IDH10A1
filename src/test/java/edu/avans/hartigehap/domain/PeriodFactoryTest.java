package edu.avans.hartigehap.domain;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

public class PeriodFactoryTest {

	PeriodFactory periodFactory = new PeriodFactory();
	List<IPeriod> oneDayPeriod;
	Reservation reservation = new Reservation();
	
	
	DateTime startTime = DateTime.now().minusDays(3);
	DateTime endTime = DateTime.now();
	
	
	@Test
	public void test3Days() {
		List<IPeriod> threeDayPeriod;
		DateTime startTime = DateTime.now().minusDays(3);
		DateTime endTime = DateTime.now();
		
		threeDayPeriod = periodFactory.buildPeriod(startTime, endTime, reservation);
		
		
	}
	
	@Test
	public void test1Day() {
		List<IPeriod> oneDayPeriod;
		DateTime startTime = new DateTime(2015,1,13,8,0);
		DateTime endTime = new DateTime(2015,1,13,12,0);
		
		oneDayPeriod = periodFactory.buildPeriod(startTime, endTime, reservation);
	}

}
