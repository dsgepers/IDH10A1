package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.IPeriod;
import edu.avans.hartigehap.domain.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeriodRepository extends PagingAndSortingRepository<IPeriod, String> {
}