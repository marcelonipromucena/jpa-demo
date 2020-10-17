package jpa.demo.jpademo;

import jpa.demo.jpademo.entity.Course;
import jpa.demo.jpademo.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaDemoApplicationTests {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CourseRepository courseRepository;


  @Test
  void shouldTestFindCourseById() {
    logger.info("Test is running.");
    Course course = courseRepository.findById(10001L);
    Assertions.assertEquals("JPA IN 50 STEPS", course.getName());
  }

  @Test
  void shouldTestDeleteCourseById() {
    logger.info("Test is running.");
    courseRepository.deleteById(10002L);
    Course course = courseRepository.findById(10002L);
    Assertions.assertNull(course);

  }


}
