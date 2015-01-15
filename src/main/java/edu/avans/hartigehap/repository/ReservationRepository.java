package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.List;

public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {

}
