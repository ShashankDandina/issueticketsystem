package com.htc.Issuetrackingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.Issuetrackingsystem.handler.TaskException;

import com.htc.Issuetrackingsystem.model.ServicePersons;

import com.htc.Issuetrackingsystem.service.ServicePersonService;

@CrossOrigin(origins = "*")
@RestController
public class ServicePersonController {

	@Autowired
	private ServicePersonService servicePersonService;

	@PostMapping(value = "/serviceperson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String registerServicePerson(@RequestBody ServicePersons servicePersonObject) {

		if (servicePersonObject != null) {

			if (servicePersonObject.getServicePersonName() != null && servicePersonObject.getStatus() != null
					&& servicePersonObject.getPhoneNumber() > 0) {
				if (servicePersonService.registerServicePerson(servicePersonObject)) {
					return "status:success";
				}

				else {
					throw new TaskException("Id already exist", HttpStatus.BAD_REQUEST);
				}
			}
			throw new TaskException("Please enter valid data", HttpStatus.BAD_REQUEST);
		}
		throw new TaskException("Object is null", HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/serviceperson", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ServicePersons> getServicePersons() {

		List<ServicePersons> serviceData = servicePersonService.getServicePersons();

		if (serviceData != null)
			return serviceData;

		throw new TaskException("Data does not exist", HttpStatus.BAD_REQUEST);

	}

	@PutMapping(value = "/serviceperson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateBatch(@RequestBody ServicePersons servicePersonObject) {

		if (servicePersonObject != null) {
			if (servicePersonObject.getServicePersonName() != null && servicePersonObject.getStatus() != null
					&& servicePersonObject.getPhoneNumber() > 0) {
				if (servicePersonService.updateServicePerson(servicePersonObject)) {
					return "status:success";
				}

				throw new TaskException("Id does not exist", HttpStatus.NOT_FOUND);
			}
			throw new TaskException("Please enter valid data", HttpStatus.NOT_ACCEPTABLE);
		}
		throw new TaskException("Object is null", HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/serviceperson/{servicePersonsId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteServicePerson(@PathVariable("servicePersonsId") int servicePersonsId) {

		if (servicePersonsId != 0) {

			if (servicePersonService.deleteServicePerson(servicePersonsId)) {
				return "status:success";
			}

			else

			{
				throw new TaskException("Id does not exist", HttpStatus.BAD_REQUEST);
			}

		}

		throw new TaskException("Please enter valid data", HttpStatus.NOT_ACCEPTABLE);
	}

}
