package edu.avans.hartigehap.domain;

import java.util.List;

public class RoomFactory {
	
	public IRoom buildRoom(List<String> additions) {
		IRoom room = new Room("testRoom", 5);
		
		
		return room;
		
	}

}
