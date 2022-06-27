package com.htc.Issuetrackingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.htc.Issuetrackingsystem.handler.TaskException;
import com.htc.Issuetrackingsystem.model.ServicePersons;
import com.htc.Issuetrackingsystem.model.Ticket;
import com.htc.Issuetrackingsystem.repository.ServicePersonsRepository;
import com.htc.Issuetrackingsystem.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private ServicePersonsRepository sevicePersonRepository;

	public boolean updateTicket(Ticket ticketObject, int servicePersonId) {

		Optional<Ticket> ticket = ticketRepository.findById(ticketObject.getTicketId());
		Optional<ServicePersons> service = sevicePersonRepository.findById(servicePersonId);

		if (ticket.isPresent() && service.isPresent()) {
			Ticket ticketObj = ticket.get();

			ticketObj.setServicePersons(service.get());
			ticketObj.setStatus(ticketObject.getStatus());

			ticketRepository.save(ticketObj);
			return true;
		}

		throw new TaskException("Id does not exist", HttpStatus.NOT_FOUND);
	}

	public List<Ticket> getTickets() {

		if ((List<Ticket>) ticketRepository.findAll() != null) {

			return (List<Ticket>) ticketRepository.findAll();
		}

		throw new TaskException("data does not exist", HttpStatus.NOT_FOUND);
	}

}
