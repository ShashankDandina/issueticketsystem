package com.htc.Issuetrackingsystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private String status;
	private Date date;

	@ManyToOne
	@JoinColumn(name = "customerComplaintId")
	CustomerComplaint customerComplaint;

	@ManyToOne
	@JoinColumn(name = "servicePersonId")
	ServicePersons servicePersons;

	public Ticket() {
		super();

	}

	public Ticket(int ticketId, String status, Date date) {
		super();
		this.ticketId = ticketId;
		this.status = status;
		this.date = date;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CustomerComplaint getCustomerComplaint() {
		return customerComplaint;
	}

	public void setCustomerComplaint(CustomerComplaint customerComplaint) {
		this.customerComplaint = customerComplaint;
	}

	public ServicePersons getServicePersons() {
		return servicePersons;
	}

	public void setServicePersons(ServicePersons servicePersons) {
		this.servicePersons = servicePersons;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", status=" + status + ", date=" + date + ", customerComplaint="
				+ customerComplaint + ", servicePersons=" + servicePersons + "]";
	}

}
