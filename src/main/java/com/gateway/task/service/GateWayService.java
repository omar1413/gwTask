package com.gateway.task.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gateway.task.entity.Gateway;
import com.gateway.task.exception.CustomException;
import com.gateway.task.model.FlatGateway;
import com.gateway.task.repository.GatewayRepository;

@Service
public class GateWayService {

	@Autowired
	private GatewayRepository repo;
	
	
	
	
	public Page<Gateway> getAllGateWays(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	
	public Gateway addGateway(Gateway gateway)  {
		if(gateway.getId() != null) {
			throw new CustomException(CustomException.BAD_REQUEST_MSG);
		}
		return repo.save(gateway);
	}
	
	
	public FlatGateway getGatewayDetail(Long id) {
		Optional<Gateway> op= repo.findById(id);
		if(op.isEmpty()) {
			throw new CustomException(CustomException.NOT_FOUND);
		}
		Gateway gw = op.get();
		FlatGateway fGy = new FlatGateway(gw);
		return fGy;
	}
	
}
