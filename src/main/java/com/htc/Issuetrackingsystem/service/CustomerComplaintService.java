package com.htc.Issuetrackingsystem.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.htc.Issuetrackingsystem.handler.TaskException;
import com.htc.Issuetrackingsystem.model.CustomerComplaint;
import com.htc.Issuetrackingsystem.model.Ticket;
import com.htc.Issuetrackingsystem.repository.CustomerComplaintRepository;
import com.htc.Issuetrackingsystem.repository.TicketRepository;

@Service
public class CustomerComplaintService {

	@Autowired
	private CustomerComplaintRepository customerComplaintRepository;

	@Autowired
	private TicketRepository ticketRepository;

	public boolean registerCustomerComplaint(CustomerComplaint customerComplaint) {

		Optional<CustomerComplaint> optcus = customerComplaintRepository
				.findById(customerComplaint.getCustomerComplaintId());
		if (optcus.isEmpty()) {
			customerComplaintRepository.save(customerComplaint);
			registerTicket(customerComplaint);
			return true;

		}

		throw new TaskException("data already exist", HttpStatus.CONFLICT);
	}

	public boolean registerTicket(CustomerComplaint customerComplaintObject) {

		Optional<CustomerComplaint> optcus = customerComplaintRepository
				.findById(customerComplaintObject.getCustomerComplaintId());
		if (optcus.isPresent()) {
			Ticket ticketObject = new Ticket();
			ticketObject.setStatus("yet to be processed");
			ticketObject.setDate(new Date());
			ticketObject.setCustomerComplaint(customerComplaintObject);
			ticketObject.setServicePersons(null);
			ticketRepository.save(ticketObject);
			return true;

		}

		throw new TaskException("data already exist", HttpStatus.CONFLICT);
	}

	public List<CustomerComplaint> getCustomerComplaints() {

		if ((List<CustomerComplaint>) customerComplaintRepository.findAll() != null) {
			return (List<CustomerComplaint>) customerComplaintRepository.findAll();
		}

		throw new TaskException("data does not exist", HttpStatus.NOT_FOUND);
	}

}
