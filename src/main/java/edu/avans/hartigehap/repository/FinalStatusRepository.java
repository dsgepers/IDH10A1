package edu.avans.hartigehap.repository;

import edu.avans.hartigehap.domain.ConceptStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FinalStatusRepository extends PagingAndSortingRepository<ConceptStatus, Long> {

}
