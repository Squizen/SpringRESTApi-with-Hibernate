package breakthecode.com.pl.springnauka.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import breakthecode.com.pl.springnauka.classes.CourseAddSupport;
import breakthecode.com.pl.springnauka.classes.JsonViewSerializeUtils;
import breakthecode.com.pl.springnauka.entity.Course;
import breakthecode.com.pl.springnauka.entity.Instructor;
import breakthecode.com.pl.springnauka.interfaces.View;
import breakthecode.com.pl.springnauka.service.CourseService;
import breakthecode.com.pl.springnauka.service.InstructorService;

@RestController
@RequestMapping("/api")
public class CourseRESTController {

	private CourseService courseService;
	private InstructorService instructorService;
	
	@Autowired
	public CourseRESTController(CourseService courseService, InstructorService instructorService) {
		this.courseService = courseService;
		this.instructorService = instructorService;
	}
	
	@PostMapping("/course/add")
	public void addCourse(@RequestBody Course course) {
		course.setId(0);
		Instructor instructor = course.getInstructor();
		instructor.addCourse(course);
		instructorService.addInstructor(instructor);
		courseService.addCourse(course);
	}
	
	@PostMapping("/course/addById")
	public void addCourseWithInstructorID(@RequestBody CourseAddSupport courseAddSupport) {
		Instructor instructor = instructorService.findInstructorByID(courseAddSupport.getInstructor_id());
		if(instructor != null) {
			Course course = new Course(courseAddSupport.getTitle());
			instructor.addCourse(course);
			courseService.addCourseWithInstructorID(course);
		} else {
			throw new RuntimeException("There is no instructor with ID = " + courseAddSupport.getInstructor_id() + " |end ");
		}
	}
	
	@PutMapping("/course/update")
	public void updateCourse(@RequestBody CourseAddSupport courseAddSupport) {
		Instructor instructor = instructorService.findInstructorByID(courseAddSupport.getInstructor_id());
		if(instructor != null) {
			Course course = new Course(courseAddSupport.getTitle());
			course.setId(courseAddSupport.getId());
			course.setInstructor(instructor);
			courseService.updateCourse(course);
		} else {
			throw new RuntimeException("There is no full data");
		}
	}
	
	@DeleteMapping("/course/delete/{theID}")
	public void deleteCourseById(@PathVariable int theID) {
		courseService.deleteCourse(theID);
	}
	
	@GetMapping("/course/{theID}")
	public String findCourseByID(@PathVariable int theID) {
		Course course = courseService.findCourseByID(theID);
		if(course != null) {
			try {
				return JsonViewSerializeUtils.serializeObjectToString(course, View.Course.class);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("No course found");
			}
		} else {
			throw new RuntimeException("No course found");
		}
	}
}
