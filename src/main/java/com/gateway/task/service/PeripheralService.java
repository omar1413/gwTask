package com.gateway.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gateway.task.entity.Gateway;
import com.gateway.task.entity.Peripheral;
import com.gateway.task.exception.CustomException;
import com.gateway.task.repository.GatewayRepository;
import com.gateway.task.repository.PeripheralRepository;

@Service
public class PeripheralService {
	
	private static final String GATE_WAY_NOT_FOUND = "GATEWAY NOT FOUND";
	
	private static final String REACH_MAX_DEVICES = "MAXIMUM DEVICES TO ADD IS 10";
	
	@Autowired
	private PeripheralRepository peripheralRepository;
	
	@Autowired
	private GatewayRepository gatewayRepository;
	
	public Peripheral add(Long gatewayId, Peripheral peripheral) {
		if(gatewayId == null) {
			throw new CustomException(CustomException.BAD_REQUEST_MSG);
		}
		
		if(peripheral.getId() != null) {
			throw new CustomException(CustomException.BAD_REQUEST_MSG);
		}
		peripheral.setGateWayId(gatewayId);
		Optional<Gateway> gw = gatewayRepository.findById(gatewayId);
		if(gw.isEmpty()) {
			throw new CustomException(GATE_WAY_NOT_FOUND);
		}
		if(gw.get().getPeripherals() != null && gw.get().getPeripherals().size() >= 10) {
			throw new CustomException(REACH_MAX_DEVICES);
		}
		return peripheralRepository.save(peripheral);
	}
	
	
	public void remove(Long id) {
		try {
		peripheralRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new CustomException(CustomException.NOT_FOUND);
		}
	}

	
	public Peripheral get(Long id) {
		Optional<Peripheral> peOptional =  peripheralRepository.findById(id);
		if(peOptional.isEmpty()) {
			throw new CustomException(CustomException.NOT_FOUND);
		}
		return peOptional.get();
	}
}
