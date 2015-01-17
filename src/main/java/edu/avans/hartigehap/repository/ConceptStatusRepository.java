package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.IReservationStatus;
import edu.avans.hartigehap.domain.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ConceptStatusRepository extends PagingAndSortingRepository<IReservationStatus, Long> {

}
