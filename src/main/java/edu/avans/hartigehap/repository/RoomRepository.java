package edu.avans.hartigehap.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.avans.hartigehap.domain.IRoom;

public interface RoomRepository extends PagingAndSortingRepository<IRoom, Long> {
	List<IRoom> findBytype(String type);
}
