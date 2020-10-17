package jpa.demo.jpademo.repository;

import jpa.demo.jpademo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EntityManager entityManager;

  public Course findById(Long id) {
    return entityManager.find(Course.class, id);
  }

  public void deleteById(Long id) {
    Course course = findById(id);
    entityManager.remove(course);
  }

  public Course save(Course course) {
    if (course.getId() == null) {
      entityManager.persist(course);
    } else {
      entityManager.merge(course);
    }

    return course;
  }

  public void playWithEntityManager() {
    logger.info("Playing with EntityManager - start");
    Course course = new Course("Web Services in 100 Steps");
    entityManager.persist(course);
    course.setName("Web Services in 100 Steps - Updated");
  }

}
