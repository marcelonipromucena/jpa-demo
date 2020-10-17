package jpa.demo.jpademo;

import jpa.demo.jpademo.entity.Course;
import jpa.demo.jpademo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CourseRepository courseRepository;

  public static void main(String[] args) {
    SpringApplication.run(JpaDemoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    Course course = courseRepository.findById(10001L);

    logger.info("{}", course);

    logger.info("Deleting Course");

    courseRepository.deleteById(10001L);


  }
}
