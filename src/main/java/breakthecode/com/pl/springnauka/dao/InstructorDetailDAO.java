package breakthecode.com.pl.springnauka.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import breakthecode.com.pl.springnauka.entity.Instructor;
import breakthecode.com.pl.springnauka.entity.InstructorDetail;
import breakthecode.com.pl.springnauka.testresponse.UserResponse;

@Repository
public class InstructorDetailDAO {
	
	private EntityManager entityManager;

	@Autowired
	public InstructorDetailDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public InstructorDetail findInstructorDetailByID(int theID) {
		Session session = entityManager.unwrap(Session.class);
		InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);
		return instructorDetail;
	}
	
	public InstructorDetail addInstructorDetail(InstructorDetail instructorDetail) {
		Session session = entityManager.unwrap(Session.class);
		session.save(instructorDetail);
		return instructorDetail;
	}
	public UserResponse findInstructorThroughInstructorDetailsByID(int theID) {
		Session session = entityManager.unwrap(Session.class);
		InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);
		UserResponse userResponse = new UserResponse();
		if(instructorDetail == null) {
			userResponse.setSuccessful(false);
			userResponse.setMsg("Instructor Details with ID = " + theID + " not found");
		} else {
			userResponse.setSuccessful(true);
			userResponse.setMsg("Instructor Details found");
			userResponse.setInstructorDetails(instructorDetail);
			Instructor instructor = instructorDetail.getInstructor();
			if(instructor == null) {
				userResponse.setUserFound(false);
			} else {
				userResponse.setUserFound(true);
				userResponse.setId(instructor.getId());
				userResponse.setFirstName(instructor.getFirstName());
				userResponse.setLastName(instructor.getLastName());
				userResponse.setEmail(instructor.getEmail());
			}
		}
		return userResponse;
	}
}
