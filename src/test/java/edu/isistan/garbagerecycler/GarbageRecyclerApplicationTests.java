package edu.isistan.garbagerecycler;

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
	    
//	    String address = "{\"department\": \"" + department
//				+ "\", \"streetAddress\":\"" + streetAddress + "\""
//				+ "\", \"city\":\"" + city + "\""
//				+ "\", \"state\":\"" + state + "\""
//				+ "\", \"zipCode\":\"" + zipCode + "\""
//				+ "\", \"number\":\"" + number + "\""
//						+ "}";
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
	
		
//		HttpEntity<Object> user = getHttpEntity("{\"address\": \"" + address
//				+ "\", \"firstName\":\"" + firstName + "\""
//				+ "\", \"lastName\":\"" +lastName + "\""
//				+ "\", \"mail\":\"" + mail + "\""
//				+ "\", \"username\":\"" + username + "\""
//						+ "}");
	    
		ResponseEntity<User> response = template.postForEntity("/api/users", userhttpentity, User.class);
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		User u = response.getBody();
		Assert.assertNotNull(u);
		
		
	}
	
	private HttpEntity<Object> getHttpEntity(Object body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<Object>(body, headers);
	}

}
