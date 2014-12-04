package edu.avans.hartigehap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import edu.avans.hartigehap.domain.Customer;
import edu.avans.hartigehap.domain.Owner;
import edu.avans.hartigehap.repository.OwnerRepository;
import edu.avans.hartigehap.service.*;

@Service("ownerService")
@Transactional
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired 
	private OwnerRepository ownerRepository;
	
	
	@Override
	public List<Owner> findAll() {
		return Lists.newArrayList(ownerRepository.findAll());
	}

	@Override
	public Owner findById(Long ownerId) {
		return ownerRepository.findOne(ownerId);
	}

	@Override
	public Owner findByName(String name) {
		Owner owner = null;
		
		List<Owner> owners = ownerRepository.findByName(name);
		if (!owners.isEmpty()) {
			owner = owners.get(0);
		}
		return owner;
	}

	@Override
	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Owner owner) {
		ownerRepository.delete(owner);
	}

}
