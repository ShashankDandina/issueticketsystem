package com.htc.Issuetrackingsystem.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_complaint")
public class CustomerComplaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerComplaintId;
	private String customerName;
	private long mobileNumber;
	private String address;
	private int pinCode;
	private String computerBrand;
	private String problemDescription;

	public CustomerComplaint() {
		super();

	}

	public CustomerComplaint(int customerComplaintId, String customerName, long mobileNumber, String address,
			int pinCode, String computerBrand, String problemDescription) {
		super();
		this.customerComplaintId = customerComplaintId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.pinCode = pinCode;
		this.computerBrand = computerBrand;
		this.problemDescription = problemDescription;
	}

	public int getCustomerComplaintId() {
		return customerComplaintId;
	}

	public void setCustomerComplaintId(int customerComplaintId) {
		this.customerComplaintId = customerComplaintId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getComputerBrand() {
		return computerBrand;
	}

	public void setComputerBrand(String computerBrand) {
		this.computerBrand = computerBrand;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerComplaintId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerComplaint other = (CustomerComplaint) obj;
		return customerComplaintId == other.customerComplaintId;
	}

	@Override
	public String toString() {
		return "CustomerComplaint [customerComplaintId=" + customerComplaintId + ", customerName=" + customerName
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + ", pinCode=" + pinCode
				+ ", computerBrand=" + computerBrand + ", problemDescription=" + problemDescription + "]";
	}

}
