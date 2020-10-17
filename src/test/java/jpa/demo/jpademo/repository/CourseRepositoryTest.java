package jpa.demo.jpademo.repository;

import jpa.demo.jpademo.JpaDemoApplication;
import jpa.demo.jpademo.entity.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = JpaDemoApplication.class)
class CourseRepositoryTest {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CourseRepository courseRepository;

  @Test
  void shouldTestFindCourseById() {
    logger.info("Test is running.");
    Course course = courseRepository.findById(10001L);
    Assertions.assertEquals("JPA1", course.getName());
  }

  @Test
  @DirtiesContext
  void shouldTestDeleteCourseById() {
    logger.info("Test is running.");
    courseRepository.deleteById(10002L);
    Course course = courseRepository.findById(10002L);
    Assertions.assertNull(course);
  }

  @Test
  @DirtiesContext
  void shouldTestSaveCourseById() {
    Course course = courseRepository.findById(10001L);
    Assertions.assertEquals("JPA1", course.getName());

    course.setName("HIBERNATE1");
    courseRepository.save(course);

    Course course1 = courseRepository.findById(10001L);
    Assertions.assertEquals("HIBERNATE1", course1.getName());
  }

  @Test
  @DirtiesContext
  void shouldPlayWithEntityManager() {
    courseRepository.playWithEntityManager();
  }

}