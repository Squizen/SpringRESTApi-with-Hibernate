package breakthecode.com.pl.springnauka.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import breakthecode.com.pl.springnauka.entity.Instructor;
import breakthecode.com.pl.springnauka.service.InstructorService;

@RestController
@RequestMapping("/api")
public class InstructorRESTController {

	private InstructorService instructorService;
	
	@Autowired
	public InstructorRESTController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	@GetMapping("/instructors")
	public List<Instructor> getListOfAllInstructors(){
		return instructorService.getListOfAllInstructors();
	}
	
	@GetMapping("/instructor/{theID}")
	public Instructor findInstructorByID(@PathVariable int theID) {
		Instructor instructor = instructorService.findInstructorByID(theID);
		if(instructor != null) {
			return instructor;
		} else {
			throw new RuntimeException("No instructor found");
		}
	}
	
	@PostMapping("/add")
	public Instructor addAloneInstructor(@RequestBody Instructor instructor) {
		instructor.setId(0);
		return instructorService.addAloneInstructor(instructor);
	}
}
