package com.enrollment.service;

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
public class TestAddressService extends AbstractTestNGSpringContextTests{
  
	@Autowired
	AddressService service;
	
	@Test
	public void testCreateAddress() throws Exception {
		Address address = new Address();
		
		address.setAreaCode("7865");
		address.setStreetName("Molemela");
		address.setStreetNumber("12");
		address.setSurbubName("Phase 2");
		
		Address result = service.create(address);
		Assert.assertNotNull(result);
	}
	
	@Test(dependsOnMethods = "testCreateAddress")
	public void testUpdateAddress() throws Exception{
		Address address = service.readById(1L);
		
		if (address != null)
		{
			address.setStreetNumber("23");
			Address updatedAddress = service.create(address);
			Assert.assertEquals(updatedAddress.getStreetNumber(), "23");
		}
	}
	
	@Test(dependsOnMethods = "testUpdateAddress")
	public void testReadAllAddresses() throws Exception{
		Iterable<Address> address = service.readAll();
		Assert.assertNotNull(address);
	}
	
	@Test(dependsOnMethods = "testReadAllAddresses")
	public void testDeleteAddress() throws Exception{
		Address address = service.readById(1L);
		
		if (address != null)
		{
			service.delete(address);
			Address deletedAddress = service.readById(1L);
			Assert.assertNull(deletedAddress);
		}
	}
}
