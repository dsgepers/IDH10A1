package edu.avans.hartigehap.domain;

import java.util.Iterator;
import java.util.List;

public class RoomFactory {
	
	public IRoom buildRoom(List<String> additions) {
		IRoom room = new Room("testRoom", 5);
		
		for (Iterator<String> i = additions.iterator(); i.hasNext(); ) {
			switch(i.next()) {
			case "WIFI":
				room = new Wifi(room, 3);
				break;
			case "BEAMER":
				room = new Beamer(room, 3);
				break;
			case "MENU":
				room = new MenuConference(room, 3);
				break;
			case "DECORATION":
				room = new Decoration(room, 3);
				break;				
			}
		}
		
		
		return room;
		
	}

}
