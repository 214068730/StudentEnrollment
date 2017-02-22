package com.enrollment.repository;

import org.testng.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Address;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestAddressRepository extends AbstractTestNGSpringContextTests {
  
	@Autowired
	AddressRepository repo;
	
	@Test
	public void testCreateAddress() throws Exception {
		Address address = new Address();
		
		address.setAreaCode("7530");
		address.setStreetName("5th Avenue");
		address.setStreetNumber("5");
		address.setSurbubName("Boston");
		
		Address result = repo.save(address);
		Assert.assertNotNull(result);
	}
	
	@Test(dependsOnMethods = "testCreateAddress")
	public void testUpdateAddress() throws Exception{
		Address address = repo.findOne(1L);
		
		if (address != null)
		{
			address.setAreaCode("4589");
			Address updatedAddress = repo.save(address);
			Assert.assertEquals(updatedAddress.getAreaCode(), "4589");
		}
	}
	
	@Test(dependsOnMethods = "testUpdateAddress")
	public void testReadAllAddresses() throws Exception{
		Iterable<Address> address = repo.findAll();
		Assert.assertNotNull(address);
	}
	
	@Test(dependsOnMethods = "testReadAllAddresses")
	public void testDeleteAddress() throws Exception{
		Address address = repo.findOne(1L);
		
		if (address != null)
		{
			repo.delete(address);
			Address deletedAddress = repo.findOne(1L);
			Assert.assertNull(deletedAddress);
		}
	}
}
