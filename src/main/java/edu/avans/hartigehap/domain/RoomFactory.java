package edu.avans.hartigehap.domain;

import java.util.Iterator;
import java.util.List;

public class RoomFactory {
	
    private static RoomFactory _instance;

    private RoomFactory () {}

    public static RoomFactory getInstance () {
        if (_instance == null) {
        	_instance = new RoomFactory();
        }
    	return _instance;
    }
	
	public IRoom buildRoom(IRoom room, List<String> additions) {		
		for (Iterator<String> i = additions.iterator(); i.hasNext(); ) {
			switch(i.next()) {
			case "WIFI":
				room = new Wifi(room, 10);
				break;
			case "BEAMER":
				room = new Beamer(room, 20);
				break;
			case "MENU":
				room = new MenuConference(room, 30);
				break;
			case "DECORATION":
				room = new Decoration(room, 40);
				break;				
			}
		}

		return room;
		
	}

}
