package breakthecode.com.pl.springnauka.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import breakthecode.com.pl.springnauka.entity.Course;

@Repository
public class CourseDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CourseDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void addCourse(Course course) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(course);
	}
	
	public void addCourseWithInstructorID(Course course) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(course);
		session.saveOrUpdate(course.getInstructor());
	}
	
	public void updateCourse(Course course) {
		Session session = entityManager.unwrap(Session.class);
		session.update(course);
		session.update(course.getInstructor());
	}
	
	public void deleteCourse(int theID) {
		Session session = entityManager.unwrap(Session.class);
		Course course = session.get(Course.class, theID);
		session.delete(course);
	}
	
	public Course findCourseByID(int theID) {
		Session session = entityManager.unwrap(Session.class);
		Course course = session.get(Course.class, theID);
		return course;
	}
}
