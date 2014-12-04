package edu.avans.hartigehap.service;

import java.util.List;

import edu.avans.hartigehap.domain.*;

public interface OwnerService {
	List<Owner> findAll();
	Owner findById(Long id);
	Owner findByName(String name);
	Owner save(Owner owner);
	void delete (Owner owner);
}
