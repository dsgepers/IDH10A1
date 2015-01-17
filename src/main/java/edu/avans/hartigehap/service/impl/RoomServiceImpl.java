package edu.avans.hartigehap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.avans.hartigehap.domain.Room;
import edu.avans.hartigehap.repository.RoomRepository;
import edu.avans.hartigehap.service.RoomService;

@Service("roomService")
@Repository
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Room findById(Long id) {
		return roomRepository.findOne(id);
	}

}
