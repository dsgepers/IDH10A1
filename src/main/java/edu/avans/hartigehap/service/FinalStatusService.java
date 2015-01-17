package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.FinalStatus;
import edu.avans.hartigehap.domain.IReservationStatus;

import java.util.List;

public interface FinalStatusService {
	List<FinalStatus> findAll();
	IReservationStatus save(FinalStatus status);
}
