package com.htc.Issuetrackingsystem.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_persons")
public class ServicePersons {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int servicePersonsId;
	private String servicePersonName;
	private long phoneNumber;
	private String status;

	public ServicePersons() {
		super();

	}

	public ServicePersons(int servicePersonsId, String servicePersonName, long phoneNumber, String status) {
		super();
		this.servicePersonsId = servicePersonsId;
		this.servicePersonName = servicePersonName;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public int getServicePersonsId() {
		return servicePersonsId;
	}

	public void setServicePersonsId(int servicePersonsId) {
		this.servicePersonsId = servicePersonsId;
	}

	public String getServicePersonName() {
		return servicePersonName;
	}

	public void setServicePersonName(String servicePersonName) {
		this.servicePersonName = servicePersonName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(servicePersonsId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicePersons other = (ServicePersons) obj;
		return servicePersonsId == other.servicePersonsId;
	}

	@Override
	public String toString() {
		return "ServicePersons [servicePersonsId=" + servicePersonsId + ", servicePersonName=" + servicePersonName
				+ ", phoneNumber=" + phoneNumber + ", status=" + status + "]";
	}

}
