package edu.avans.hartigehap.service;

import java.util.List;

import edu.avans.hartigehap.domain.IRoom;

public interface RoomService {
	IRoom findById(Long id);
	List<IRoom> findAll();
	List<IRoom> findByType(String type);
	IRoom save(IRoom room);
}
