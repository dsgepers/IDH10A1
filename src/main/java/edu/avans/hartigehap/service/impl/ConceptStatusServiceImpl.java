package edu.avans.hartigehap.service.impl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import edu.avans.hartigehap.domain.ConceptStatus;
import edu.avans.hartigehap.domain.IReservationStatus;
import edu.avans.hartigehap.repository.ConceptStatusRepository;
import edu.avans.hartigehap.service.ConceptStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("conceptStatusService")
@Repository
@Transactional
public class ConceptStatusServiceImpl implements ConceptStatusService {
	final Logger logger = LoggerFactory.getLogger(ConceptStatusServiceImpl.class);

	@Autowired
	private ConceptStatusRepository statusRepository;

	@Transactional(readOnly=true)
	public List<ConceptStatus> findAll() {
		return Lists.newArrayList(statusRepository.findAll());
	}

	@Override
	public ConceptStatus save(ConceptStatus status) {
		return this.statusRepository.save(status);
	}
}

