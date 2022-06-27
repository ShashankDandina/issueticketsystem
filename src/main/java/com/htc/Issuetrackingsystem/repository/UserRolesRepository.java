package com.htc.Issuetrackingsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.Issuetrackingsystem.model.User;


@Repository
public interface UserRolesRepository extends CrudRepository<User,Integer> {
	
	 User findByUserName(String username);

}
