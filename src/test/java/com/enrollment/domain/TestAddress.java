package com.enrollment.domain;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestAddress extends TestCase{

	final static Address address = new Address();
	
	@Test
	public void testCreateAddress() throws Exception{
		
		Assert.assertNotNull(address);
		
		address.setStreetNumber("45");
		address.setStreetName("Voortrekker");		
		address.setAreaCode("1234");
		address.setSurbubName("Bellville");
		
		Assert.assertEquals("45", address.getStreetNumber());
		Assert.assertEquals("Voortrekker", address.getStreetName());
		Assert.assertEquals("1234", address.getAreaCode());
		Assert.assertEquals("Bellville", address.getSurbubName());
	}
	
	@Test
	public void testUpdateAddress() throws Exception{
		
		address.setStreetNumber("23");
		address.setStreetName("Deborah");		
		address.setAreaCode("2342");
		address.setSurbubName("Boston");
		
		Assert.assertEquals("23", address.getStreetNumber());
		Assert.assertEquals("Deborah", address.getStreetName());
		Assert.assertEquals("2342", address.getAreaCode());
		Assert.assertEquals("Boston", address.getSurbubName());
	}
}
