package breakthecode.com.pl.springnauka.rest;

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
import breakthecode.com.pl.springnauka.entity.InstructorDetail;
import breakthecode.com.pl.springnauka.interfaces.View;
import breakthecode.com.pl.springnauka.service.InstructorDetailService;
import breakthecode.com.pl.springnauka.testresponse.UserResponse;

@RestController
@RequestMapping("/api")
public class InstructorDetailRESTController {

	private InstructorDetailService instructorDetailService;
	
	@Autowired
	public InstructorDetailRESTController(InstructorDetailService instructorDetailService) {
		this.instructorDetailService = instructorDetailService;
	}
	
	@GetMapping("/instructor_detail/{theID}")
	public String findInstructorDetailByID(@PathVariable int theID) {
		InstructorDetail instructorDetail = instructorDetailService.findInstructorDetailByID(theID);
		String result = "";
		if(instructorDetail != null) {
			try {
				Instructor instructor = instructorDetail.getInstructor();
				if(instructor != null) {
					result = JsonViewSerializeUtils.serializeObjectToString(instructor, View.Instructor.class);
				} else {
					result = JsonViewSerializeUtils.serializeObjectToString(instructorDetail, View.InstructorDetail.class);
				}
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		} else {
			throw new RuntimeException("InstructorDetail was not found");
		}
	}
	
	@PostMapping("/instructor_detail/add")
	public InstructorDetail addInstructor(@RequestBody InstructorDetail instructorDetail) {
		instructorDetail.setId(0);
		return instructorDetailService.addInstructorDetail(instructorDetail);
	}
	
	@GetMapping("/instructor_detail/fullinfo/{theID}")
	public UserResponse findInstructorThroughInstructorDetailsByID(@PathVariable int theID) {
		UserResponse userResponse = instructorDetailService.findInstructorThroughInstructorDetailsByID(theID);
		if(userResponse != null) {
			return userResponse;
		} else {
			throw new RuntimeException("No response");
		}
	}

}
