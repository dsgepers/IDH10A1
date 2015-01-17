package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.ConceptStatus;
import edu.avans.hartigehap.domain.IReservationStatus;

import java.util.List;

public interface FinalStatusService {
	List<ConceptStatus> findAll();
	IReservationStatus save(ConceptStatus status);
}
