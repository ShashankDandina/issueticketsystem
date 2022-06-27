package com.htc.Issuetrackingsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.Issuetrackingsystem.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Integer> {

}
