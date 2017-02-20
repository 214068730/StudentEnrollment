package com.enrollment.repository;

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
public class TestLecturerRepository extends AbstractTestNGSpringContextTests {

	@Autowired
	LecturerRepository repo;

	@Test
	public void testCreateLecturer() throws Exception {

		Lecturer lecturer = new Lecturer();

		lecturer.setId(1L);
		lecturer.setName("Willem");
		lecturer.setSurname("Wessels");

		Lecturer result = repo.save(lecturer);
		Assert.assertNotNull(result);
	}

	@Test(dependsOnMethods = "testCreateLecturer")
	public void testUpdateLecturer() throws Exception {

		Lecturer lecturer = repo.findOne(1L);

		if (lecturer != null) {
			lecturer.setName("Paul");
			lecturer.setSurname("Williams");

			Lecturer updatedLecturer = repo.save(lecturer);
			Assert.assertEquals(updatedLecturer.getName(), "Paul");
			Assert.assertEquals(updatedLecturer.getSurname(), "Williams");
		}
	}

	@Test(dependsOnMethods = "testUpdateLecturer")
	public void testReadAllLecturers() throws Exception {

		Iterable<Lecturer> lecturers = repo.findAll();
		Assert.assertNotNull(lecturers);
	}
	


	@Test(dependsOnMethods = "testReadAllLecturers")
	public void testDeleteLecturer() throws Exception{
		
		Lecturer lecturer = repo.findOne(1L);
		
		if (lecturer != null)
		{
			repo.delete(lecturer);
			Lecturer deletedLecturer = repo.findOne(1L);
			Assert.assertNull(deletedLecturer);
		}
	}
	
}
