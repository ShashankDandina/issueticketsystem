package com.htc.Issuetrackingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.Issuetrackingsystem.handler.TaskException;
import com.htc.Issuetrackingsystem.model.CustomerComplaint;
import com.htc.Issuetrackingsystem.service.CustomerComplaintService;

@CrossOrigin(origins = "*")
@RestController
public class CustomerComplaintController {

	@Autowired
	private CustomerComplaintService customerComplaintService;

	@PostMapping(value = "/customercomplaint", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String registerCustomerComplaint(@RequestBody CustomerComplaint customerComplaintObject) {

		if (customerComplaintObject != null) {

			if (customerComplaintObject.getCustomerName() != null && customerComplaintObject.getMobileNumber() > 0
					&& customerComplaintObject.getAddress() != null
					&& customerComplaintObject.getComputerBrand() != null
					&& customerComplaintObject.getProblemDescription() != null
					&& customerComplaintObject.getPinCode() > 0) {

				if (customerComplaintService.registerCustomerComplaint(customerComplaintObject)) {
					return "status:success";

				}

				else {
					throw new TaskException("Id already exist", HttpStatus.CONFLICT);
				}

			}
			throw new TaskException("Please enter valid data", HttpStatus.NOT_ACCEPTABLE);

		}

		throw new TaskException("Object is null", HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/customercomplaint")
	public List<CustomerComplaint> getCustomerComplaints() {

		List<CustomerComplaint> customerData = customerComplaintService.getCustomerComplaints();

		if (customerData != null) {
			return customerData;
		}
		throw new TaskException("Data does not exist", HttpStatus.NOT_FOUND);
	}

}
