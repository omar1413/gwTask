package com.gateway.task.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "gateway")
public class Gateway {
	
	
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "serial_number")
	private String serialNumber;
	private String name;
	
	@NotBlank
	@Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$", message = "not an ipv4")
	@Column(name = "ip_address")
	private String ipAddress;
	
	@OneToMany(mappedBy = "gateway")
	@JsonIgnore
	private List<Peripheral> peripherals;
	
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
