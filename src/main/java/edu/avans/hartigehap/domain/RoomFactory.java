package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory {
	
	public List<IRoom> buildRoom(String description, int price, Reservation reservation ){
		
		List<IRoom> rooms = new ArrayList<IRoom>();
		
		
		if (beamer) {
			rooms.add(new beamer(String description, int price));
			
		}
		
		else if (wifi) {
			rooms.add(new wifi(String description, int price));
		}
		return null;
		
	}

}
