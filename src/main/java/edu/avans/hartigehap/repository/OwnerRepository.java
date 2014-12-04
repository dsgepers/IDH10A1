package edu.avans.hartigehap.repository;

import java.util.List;

import edu.avans.hartigehap.domain.*;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OwnerRepository extends PagingAndSortingRepository<Owner, Long> {

	List<Owner> findByName(String Name);

}
