package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.Reservation;

import java.util.List;

public interface ReservationService {
	List<Reservation> findAll();
	Reservation save(Reservation reservation);
	Reservation findById(Long id);
}
