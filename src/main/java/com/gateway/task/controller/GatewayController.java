package com.gateway.task.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.task.entity.Gateway;
import com.gateway.task.entity.Peripheral;
import com.gateway.task.model.FlatGateway;
import com.gateway.task.service.GateWayService;
import com.gateway.task.service.PeripheralService;

@RestController
@RequestMapping("gateway")
public class GatewayController extends BaseController {

	@Autowired
	private GateWayService gatewayService;
	
	@Autowired
	private PeripheralService peripheralService;
	
	@GetMapping
	public Page<Gateway> getGateWays(Pageable pageable) {
		return gatewayService.getAllGateWays(pageable);
	}
	
	@PostMapping
	public Gateway addGateway(@Valid @RequestBody Gateway gateway)  {
		return gatewayService.addGateway(gateway);
	}
	
	@PostMapping("/{id}/peripheral")
	public Peripheral addPeripheral(@PathVariable("id") Long id, @RequestBody Peripheral peripheral) {
		return peripheralService.add(id, peripheral);
	}
	
	

	@GetMapping("/{id}")
	public FlatGateway addGatewayDetails(@PathVariable("id") long id)  {
		return gatewayService.getGatewayDetail(id);
	}
	
	
	

	
}
