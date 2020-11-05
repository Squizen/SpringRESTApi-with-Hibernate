package breakthecode.com.pl.springnauka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import breakthecode.com.pl.springnauka.dao.CourseDAO;
import breakthecode.com.pl.springnauka.entity.Course;

@Service
public class CourseService {

	private CourseDAO courseDAO;
	
	@Autowired
	public CourseService(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	@Transactional
	public void addCourse(Course course) {
		courseDAO.addCourse(course);
	}
	
	@Transactional
	public void addCourseWithInstructorID(Course course) {
		courseDAO.addCourseWithInstructorID(course);
	}
	
	@Transactional
	public void updateCourse(Course course) {
		courseDAO.updateCourse(course);
	}
	
	@Transactional
	public void deleteCourse(int theID) {
		courseDAO.deleteCourse(theID);
	}
	
	@Transactional
	public Course findCourseByID(int theID) {
		return courseDAO.findCourseByID(theID);
	}
}
