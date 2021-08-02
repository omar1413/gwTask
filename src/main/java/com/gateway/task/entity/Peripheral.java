package com.gateway.task.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "peripheral")
public class Peripheral {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long UID;
	private String vendor;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "online_status")
	private boolean onlineStatus;
	
	@Column(name = "gateway_id")
	private Long gateWayId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gateway_id", insertable = false, updatable = false)
	private Gateway gateway;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUID() {
		return UID;
	}
	public void setUID(Long uID) {
		UID = uID;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isOnlineStatus() {
		return onlineStatus;
	}
	public void setOnlineStatus(boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	public Gateway getGateway() {
		return gateway;
	}
	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}
	public Long getGateWayId() {
		return gateWayId;
	}
	public void setGateWayId(Long gateWayId) {
		this.gateWayId = gateWayId;
	}
	
	

}
