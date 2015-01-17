package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.IReservationStatus;
import edu.avans.hartigehap.domain.Reservation;

import java.util.List;

public interface ReservationStatusService {
	List<IReservationStatus> findAll();
	IReservationStatus save(IReservationStatus status);
}