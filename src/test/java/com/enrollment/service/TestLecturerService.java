package com.enrollment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.enrollment.App;
import com.enrollment.domain.Lecturer;
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestLecturerService extends AbstractTestNGSpringContextTests{
	
	@Autowired
	LecturerService service;
	
	@Test
    public void testCreateLecturer() throws Exception {
		Lecturer lecturer = new Lecturer();
		
		lecturer.setId(32L);
		lecturer.setName("Liam");
		lecturer.setSurname("Gutsa");
		
		Lecturer result = service.create(lecturer);
		Assert.assertNotNull(result);
    }
	
	@Test(dependsOnMethods = "testCreateLecturer")
	public void testUpdateLecturer() throws Exception{
		Lecturer lecturer = service.readById(1L);
		
		if (lecturer != null)
		{
			lecturer.setSurname("Mosese");
			Lecturer updatedLecturer = service.create(lecturer);
			Assert.assertNotNull(updatedLecturer);
		}
	}
	
	@Test(dependsOnMethods = "testUpdateLecturer")
	public void testReadAllLecturers() throws Exception{
		Iterable<Lecturer> lecturer = service.readAll();
		Assert.assertNotNull(lecturer);
	}
	
	@Test(dependsOnMethods = "testReadAllLecturers")
	public void testDeleteLecturer() throws Exception{
		Lecturer lecturer = service.readById(1L);
		
		if (lecturer != null)
		{
			service.delete(lecturer);
			Lecturer deletedLecturer = service.readById(1L);
			Assert.assertNull(deletedLecturer);
		}
	}
}
