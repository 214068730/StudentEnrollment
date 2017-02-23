package com.enrollment.api;

import java.util.List;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.enrollment.App;
import com.enrollment.domain.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestAddressController extends AbstractTestNGSpringContextTests{
  
	String BASE_URL = "http://localhost:8080/enrollment/address";
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testCreateAddress() throws Exception{
		String url = BASE_URL + "/create";	
		
		Address address = new Address("15", "Sparrow", "ROCKLANDS", "RCKLDS");
		restTemplate.postForObject(url, address, Address.class);
		Assert.assertNotNull(address);
	}
	
	@Test(dependsOnMethods = "testCreateAddress")
	public void testFindById() throws Exception{
		String url = BASE_URL + "/{id}";
		Address address = restTemplate.getForObject(url, Address.class, "1");
		Assert.assertNotNull(address);
	}
	
	@Test(dependsOnMethods = "testFindById")
	public void testUpdate() throws Exception{
		String url = BASE_URL + "/{id}";
		Address address = restTemplate.getForObject(url, Address.class, "1");
		Assert.assertNotNull(address);
		
		address.setStreetNumber("23");
		restTemplate.put(BASE_URL + "/update", address);
		
		Address updatedAddress = restTemplate.getForObject(url, Address.class, "1" );
		Assert.assertEquals(updatedAddress.getStreetNumber(), "23");
	}
	
	@Test(dependsOnMethods = "testUpdate")
	public void testFindAll() throws Exception{
		String url = BASE_URL + "/findAll";
		List<Address> addresses = restTemplate.getForObject(url, List.class);
		Assert.assertNotNull(addresses.size() > 0);
	}
}
