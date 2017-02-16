package com.enrollment.service;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.enrollment.App;


@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestStudentService extends AbstractTestNGSpringContextTests {
  @Test
  public void f() {
  }
}
