package edu.avans.hartigehap.domain;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.avans.hartigehap.service.RoomService;

public class RoomFactory {
	@Autowired
	private RoomService roomService;
	
	public IRoom buildRoom(IRoom room, List<String> additions) {
		//TODO: change code to controller
		//IRoom room = roomService.findById(roomID);
		//IRoom room = new Room("test", 100);
		
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
