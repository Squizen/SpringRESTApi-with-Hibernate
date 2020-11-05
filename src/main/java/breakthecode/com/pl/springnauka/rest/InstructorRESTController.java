package breakthecode.com.pl.springnauka.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import breakthecode.com.pl.springnauka.classes.JsonViewSerializeUtils;
import breakthecode.com.pl.springnauka.entity.Instructor;
import breakthecode.com.pl.springnauka.interfaces.View;
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
	public String findInstructorByID(@PathVariable int theID) {
		Instructor instructor = instructorService.findInstructorByID(theID);
		String result = "";
		try {
			result = JsonViewSerializeUtils.serializeObjectToString(instructor, View.Instructor.class);
	
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@PostMapping("/instructor/add")
	public Instructor addInstructor(@RequestBody Instructor instructor) {
		instructor.setId(0);
		if(instructor.getInstructorDetail() != null) {
			instructor.getInstructorDetail().setId(0);
		}
		return instructorService.addInstructor(instructor);
	}
	
	@PutMapping("/instructor/link")
	@ResponseBody
	public String linkInstructorDetailWithInstructor(@RequestParam int instructorID, @RequestParam int instructorDetailID) throws JsonProcessingException {
		Instructor instructor = instructorService.linkInstructorDetailWithInstructor(instructorID, instructorDetailID);
		if(instructor != null) {
			String result = JsonViewSerializeUtils.serializeObjectToString(instructor, Instructor.class);
			return result;
		} else {
			throw new RuntimeException("Instructor not found");
		}
	}
}
