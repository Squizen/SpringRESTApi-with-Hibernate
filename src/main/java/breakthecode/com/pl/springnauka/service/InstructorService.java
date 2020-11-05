package breakthecode.com.pl.springnauka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import breakthecode.com.pl.springnauka.dao.InstructorDAO;
import breakthecode.com.pl.springnauka.entity.Instructor;

@Service
public class InstructorService {
	
	private InstructorDAO instructorDAO;
	
	@Autowired
	public InstructorService(InstructorDAO instructorDAO) {
		this.instructorDAO = instructorDAO;
	}
	
	@Transactional
	public Instructor findInstructorByID(int theID) {
		return instructorDAO.findInstructorByID(theID);
	}
	
	@Transactional
	public List<Instructor> getListOfAllInstructors(){
		return instructorDAO.getListOfAllInstructors();
	}
	
	@Transactional
	public Instructor addInstructor(Instructor instructor) {
		return instructorDAO.addInstructor(instructor);
	}

	@Transactional
	public Instructor linkInstructorDetailWithInstructor(int instructorID, int instructorDetailID) {
		return instructorDAO.linkInstructorDetailWithInstructor(instructorID, instructorDetailID);
	}
}
