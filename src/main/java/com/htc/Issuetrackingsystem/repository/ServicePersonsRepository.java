package com.htc.Issuetrackingsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.Issuetrackingsystem.model.ServicePersons;
@Repository
public interface ServicePersonsRepository extends CrudRepository<ServicePersons,Integer> {

}
