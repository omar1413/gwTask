package com.gateway.task.model;

import java.util.List;

import com.gateway.task.entity.Gateway;
import com.gateway.task.entity.Peripheral;

public class FlatGateway {
	
	
	
	
	private Long id;
	
	private String serialNumber;
	private String name;
	
	
	private String ipAddress;
	
	private List<Peripheral> peripherals;
	
	
	
	public FlatGateway() {}
	
	public FlatGateway(Gateway gw) {
		
		this.id = gw.getId();
		this.serialNumber = gw.getSerialNumber();
		this.name = gw.getName();
		this.ipAddress = gw.getIpAddress();
		this.peripherals = gw.getPeripherals();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public List<Peripheral> getPeripherals() {
		return peripherals;
	}
	public void setPeripherals(List<Peripheral> peripherals) {
		this.peripherals = peripherals;
	}
	
	
}
