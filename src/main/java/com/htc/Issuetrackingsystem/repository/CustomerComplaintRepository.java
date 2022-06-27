package com.htc.Issuetrackingsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.Issuetrackingsystem.model.CustomerComplaint;

@Repository
public interface CustomerComplaintRepository extends CrudRepository<CustomerComplaint,Integer> {

}
