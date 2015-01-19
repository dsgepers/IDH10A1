package edu.avans.hartigehap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import edu.avans.hartigehap.domain.IRoom;
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
	public IRoom findById(Long id) {
		return roomRepository.findOne(id);
	}

	@Override
	public List<IRoom> findAll() {
		return Lists.newArrayList(roomRepository.findAll());
	}

	@Override
	public IRoom save(IRoom room) {
		return this.roomRepository.save(room);
	}

	@Override
	public List<IRoom> findByType(String type) {
		return Lists.newArrayList(roomRepository.findBytype(type));
	}

}
