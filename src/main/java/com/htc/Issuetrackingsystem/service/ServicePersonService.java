package com.htc.Issuetrackingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.htc.Issuetrackingsystem.handler.TaskException;
import com.htc.Issuetrackingsystem.model.ServicePersons;
import com.htc.Issuetrackingsystem.repository.ServicePersonsRepository;

@Service
public class ServicePersonService {

	@Autowired
	private ServicePersonsRepository servicePersonsRepository;

	public boolean registerServicePerson(ServicePersons servicePersonsObject) {

		Optional<ServicePersons> optser = servicePersonsRepository.findById(servicePersonsObject.getServicePersonsId());

		if (optser.isEmpty()) {
			servicePersonsRepository.save(servicePersonsObject);
			return true;
		}

		throw new TaskException("data already exist", HttpStatus.CONFLICT);
	}

	public List<ServicePersons> getServicePersons() {

		if ((List<ServicePersons>) servicePersonsRepository.findAll() != null) {
			return (List<ServicePersons>) servicePersonsRepository.findAll();
		}

		throw new TaskException("data does not exist", HttpStatus.NOT_FOUND);
	}

	public boolean updateServicePerson(ServicePersons servicePersonObject) {

		Optional<ServicePersons> service = servicePersonsRepository.findById(servicePersonObject.getServicePersonsId());

		if (service.isPresent()) {
			
			servicePersonsRepository.save(servicePersonObject);
			return true;
		}
		throw new TaskException("data does not exist", HttpStatus.NOT_FOUND);
	}

	public boolean deleteServicePerson(int servicePersonId) {

		Optional<ServicePersons> opst = servicePersonsRepository.findById(servicePersonId);

		if (opst.isPresent()) {
			servicePersonsRepository.deleteById(servicePersonId);

			return true;

		}

		else
			throw new TaskException("data does not exist", HttpStatus.NOT_FOUND);
	}

}
