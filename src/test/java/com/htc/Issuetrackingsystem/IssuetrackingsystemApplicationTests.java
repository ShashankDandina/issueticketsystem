package com.htc.Issuetrackingsystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.htc.Issuetrackingsystem.model.ServicePersons;
import com.htc.Issuetrackingsystem.service.ServicePersonService;


@SpringBootTest
class IssuetrackingsystemApplicationTests {

	@Autowired
	private ServicePersonService servicePersonService;
	
	
	
	@Test
	void contextLoads() {
		
		
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"shashank",6765654,"status")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"kavin",6765654,"satatus")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"shreyas",6765654,"status")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"harsha",6765654,"satatus")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"shashank",6765654,"status")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"kavin",6765654,"satatus")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"shreyas",6765654,"status")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"harsha",6765654,"satatus")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"shreyas",6765654,"status")));
		Assertions.assertEquals(true,servicePersonService.updateServicePerson(new ServicePersons(1,"harsha",6765654,"satatus")));
		
//		Assertions.assertEquals(true,servicePersonService.deleteServicePerson(10));
//		Assertions.assertEquals(false,servicePersonService.deleteServicePerson((100)));
//		Assertions.assertEquals(false,servicePersonService.deleteServicePerson((200)));
//		Assertions.assertEquals(false,servicePersonService.deleteServicePerson((300)));
//		Assertions.assertEquals(false,servicePersonService.deleteServicePerson((400)));
		
	}
	
	
	
}
