package breakthecode.com.pl.springnauka.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import breakthecode.com.pl.springnauka.entity.InstructorDetail;
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
	public InstructorDetail findInstructorDetailByID(@PathVariable int theID) {
		InstructorDetail instructorDetail = instructorDetailService.findInstructorDetailByID(theID);
		if(instructorDetail != null) {
			return instructorDetail;
		} else {
			throw new RuntimeException("InstructorDetail was not found");
		}
	}
	
	@PostMapping("/instructor_detail/add")
	public InstructorDetail addAloneInstructor(@RequestBody InstructorDetail instructorDetail) {
		instructorDetail.setId(0);
		return instructorDetailService.addAloneInstructorDetail(instructorDetail);
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
