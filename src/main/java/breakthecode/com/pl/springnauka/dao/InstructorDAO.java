package breakthecode.com.pl.springnauka.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import breakthecode.com.pl.springnauka.entity.Instructor;

@Repository
public class InstructorDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public InstructorDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Instructor> getListOfAllInstructors(){
		Session session = entityManager.unwrap(Session.class);
		List<Instructor> listOfAllInstructors = session.createQuery("from Instructor", Instructor.class).getResultList();
		return listOfAllInstructors;
	}
	
	public Instructor findInstructorByID(int theID) {
		Session session = entityManager.unwrap(Session.class);
		Instructor instructor = session.get(Instructor.class, theID);
		return instructor;
	}
	
	public Instructor addAloneInstructor(Instructor instructor) {
		Session session = entityManager.unwrap(Session.class);
		session.save(instructor);
		return instructor;
	}
}
