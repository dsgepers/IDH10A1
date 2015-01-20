package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.avans.hartigehap.service.RoomService;

public class RoomFactoryTest {
	
	@Autowired
	private RoomService roomService;
	
	RoomFactory roomFactory = RoomFactory.getInstance();
	List<String> additions = new ArrayList<String>();
	
	Reservation reservation = new Reservation();

	public void test1additions(){
		additions.add("WIFI");
		additions.add("MENU");
		additions.add("DECORATION");
		additions.add("WIFI");
		IRoom room = new Room("test", 1);
		
		room = roomFactory.buildRoom(room, additions);
	}
	
	@Test
	public void test3additions(){
		
	}
}
