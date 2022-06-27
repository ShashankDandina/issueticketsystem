package com.htc.Issuetrackingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.Issuetrackingsystem.handler.TaskException;
import com.htc.Issuetrackingsystem.model.Ticket;
import com.htc.Issuetrackingsystem.service.TicketService;

@CrossOrigin(origins = "*")
@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ticket> getTickets() {

		List<Ticket> ticketData = ticketService.getTickets();
		if (ticketData != null)
			return ticketData;

		throw new TaskException("Data does not exist", HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/ticket/{servicePersonId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateTicket(@RequestBody Ticket ticketObject, @PathVariable int servicePersonId) {

		if (ticketObject != null) {

			if (servicePersonId != 0 && ticketObject.getStatus() != null && ticketObject.getTicketId() != 0
					&& ticketObject.getDate() != null) {
				if (ticketService.updateTicket(ticketObject, servicePersonId)) {
					return "status:success";
				}

				throw new TaskException("Ids does not exist", HttpStatus.NOT_FOUND);
			}
			throw new TaskException("Please enter valid data", HttpStatus.NOT_ACCEPTABLE);
		}

		throw new TaskException("Object is null", HttpStatus.NO_CONTENT);

	}
}
