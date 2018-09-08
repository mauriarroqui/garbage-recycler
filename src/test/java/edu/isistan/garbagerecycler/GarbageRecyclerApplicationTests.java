package edu.isistan.garbagerecycler;

import java.time.LocalDate;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import edu.isistan.garbagerecycler.model.Address;
import edu.isistan.garbagerecycler.model.User;
import edu.isistan.garbagerecycler.model.UserRecycling;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GarbageRecyclerApplicationTests {

	
	@Autowired
	private TestRestTemplate template;
  
	@Before
	public void setup() throws Exception {
		
	}
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test 
	public void testUserShouldBeRegistered() {
		String department = "-";
		int number=874;
	    String streetAddress="Alberdi";
	    String city="Tandil";
	    String state="Bueno Aires";
	    String zipCode="7000";
	    
	    Address _address = new Address();
	    _address.setCity(city);
	    _address.setDepartment(department);
	    _address.setNumber(number);
	    _address.setState(state);
	    _address.setStreetAddress(streetAddress);
	    _address.setZipCode(zipCode);
	    
	    String firstName = "Mauricio";
		String lastName= "Arroqui";
		String mail= "marroqui@exa.unicen.edu.ar";
		String username="marroqui";
	    
		User _user = new User();
		_user.setAddress(_address);
		_user.setFirstName(firstName);
		_user.setLastName(lastName);
		_user.setMail(mail);
		_user.setUsername(username);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> userhttpentity = new HttpEntity<User>(_user, headers);
	
			    
		ResponseEntity<User> response = template.postForEntity("/api/users", userhttpentity, User.class);
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		User u = response.getBody();
		Assert.assertNotNull(u);
			
	}
	
	@Test 
	public void testAddRecyclingToUser() {
		
		UserRecycling ur = new UserRecycling();
		ur.setBottles(1);
		ur.setCans(2);
		ur.setDate(LocalDate.now());
		ur.setGlass(3);
		ur.setPaperboard(4);
		ur.setTetrabriks(5);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserRecycling> httpentity = new HttpEntity<UserRecycling>(ur, headers);

		String username = "cmateo";
		HashMap<String, Object> params = new HashMap<>();
		params.put("username", username);
		
		ResponseEntity<UserRecycling> response = template.postForEntity("/api/users/{username}/recycling/", httpentity, UserRecycling.class,params);
		UserRecycling ur_response = response.getBody();
		Assert.assertNotNull(ur_response);
		Assert.assertEquals(ur_response.getUser().getUsername(), username);
		
		
	}
	
	
	
}
