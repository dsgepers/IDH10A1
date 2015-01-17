package edu.avans.hartigehap.domain;

import java.util.List;

import org.junit.Test;

public class RoomFactoryTest {
	
	RoomFactory roomFactory = new RoomFactory();
	List<String> additions;
	Reservation reservation = new Reservation();
	
	@Test
	public void test1additions(){
		
		additions = roomFactory.buildRoom(WIFI);
	}
	
	@Test
	public void test3additions(){
		
	}
}
