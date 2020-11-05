package breakthecode.com.pl.springnauka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import breakthecode.com.pl.springnauka.dao.InstructorDetailDAO;
import breakthecode.com.pl.springnauka.entity.InstructorDetail;
import breakthecode.com.pl.springnauka.testresponse.UserResponse;

@Service
public class InstructorDetailService {

	private InstructorDetailDAO instructorDetailDAO;
	
	@Autowired
	public InstructorDetailService(InstructorDetailDAO instructorDetailDAO) {
		this.instructorDetailDAO = instructorDetailDAO;
	}
	
	@Transactional
	public InstructorDetail findInstructorDetailByID(int theID) {
		return instructorDetailDAO.findInstructorDetailByID(theID);
	}

	@Transactional
	public InstructorDetail addInstructorDetail(InstructorDetail instructorDetail) {
		return instructorDetailDAO.addInstructorDetail(instructorDetail);
	}
	
	@Transactional
	public UserResponse findInstructorThroughInstructorDetailsByID(int theID) {
		return instructorDetailDAO.findInstructorThroughInstructorDetailsByID(theID);
	}
}
