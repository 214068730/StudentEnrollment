package com.enrollment.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAddress.class,
        TestStudentCourse.class,
        TestDepartment.class,
        TestLecturer.class,
        TestStudent.class,
        TestSubject.class
})
public class AppSuite {

}
