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
		additions.add("MENU");
		additions.add("DECORATION");
		additions.add("WIFI");
		
		room = roomFactory.buildRoom(room, additions);
	}
	
	@Test
	public void test3additions(){
		
	}
}
