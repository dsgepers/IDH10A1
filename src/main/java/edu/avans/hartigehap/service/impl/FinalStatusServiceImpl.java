package edu.avans.hartigehap.service.impl;

import com.google.common.collect.Lists;
import edu.avans.hartigehap.domain.FinalStatus;
import edu.avans.hartigehap.repository.FinalStatusRepository;
import edu.avans.hartigehap.service.FinalStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("finalStatusService")
@Repository
@Transactional
public class FinalStatusServiceImpl implements FinalStatusService {
	final Logger logger = LoggerFactory.getLogger(FinalStatusServiceImpl.class);

	@Autowired
	private FinalStatusRepository statusRepository;

	@Transactional(readOnly=true)
	public List<FinalStatus> findAll() {
		return Lists.newArrayList(statusRepository.findAll());
	}

	@Override
	public FinalStatus save(FinalStatus status) {
		return this.statusRepository.save(status);
	}
}

