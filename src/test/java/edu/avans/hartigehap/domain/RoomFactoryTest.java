package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RoomFactoryTest {
	
	RoomFactory roomFactory = new RoomFactory();
	List<String> additions = new ArrayList<String>();
	IRoom room;
	Reservation reservation = new Reservation();
	
	@Test
	public void test1additions(){
		additions.add("WIFI");
		room = roomFactory.buildRoom(1L, additions);
	}
	
	@Test
	public void test3additions(){
		
	}
}
