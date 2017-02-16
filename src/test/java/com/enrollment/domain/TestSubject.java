package com.enrollment.domain;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestSubject extends TestCase{
	
	final static Subject subject = new Subject();
	final static Lecturer lecturer = new Lecturer();
	
	@Test
	public void testCreateSubject() throws Exception{
		
		subject.setSubjectID(2L);
		subject.setSubjectName("Information Systems III");
		subject.setSubjectCode("INL30DB");
		
		lecturer.setId(67L);
		lecturer.setName("Barry");
		lecturer.setSurname("Kok");
		
		Assert.assertNotNull(subject);
		Assert.assertEquals("Information Systems III", subject.getSubjectName());
		Assert.assertEquals("INL30DB", subject.getSubjectCode());
		
		Assert.assertNotNull(lecturer);
		Assert.assertEquals("Barry", lecturer.getName());
		Assert.assertEquals("Kok", lecturer.getSurname());	
	}
	
	@Test
	public void testUpdateSubject() throws Exception{
		
		Assert.assertEquals("Information Systems III", subject.getSubjectName());
		subject.setSubjectName("Development Software III");
		subject.setSubjectCode("OPG30BB");
		
		lecturer.setName("Kebo");
		lecturer.setSurname("Jansen");
		
		Assert.assertEquals("Development Software III", subject.getSubjectName());
		Assert.assertEquals("OPG30BB", subject.getSubjectCode());
		
		Assert.assertEquals("Kebo", lecturer.getName());
		Assert.assertEquals("Jansen",lecturer.getSurname());
	}
	
}
