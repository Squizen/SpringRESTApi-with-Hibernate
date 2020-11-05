package breakthecode.com.pl.springnauka.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import breakthecode.com.pl.springnauka.entity.Instructor;
import breakthecode.com.pl.springnauka.entity.InstructorDetail;

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
	/*
	 *  Odnajdywanie instructora po ID 
	 */
	
	public Instructor findInstructorByID(int theID) {
		Session session = entityManager.unwrap(Session.class);
		Instructor instructor = session.get(Instructor.class, theID);
		return instructor;
	}
	/*
	 * Dodawanie obiektu Instructor 
	 */
	public Instructor addInstructor(Instructor instructor) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(instructor);
		return instructor;
	}
	/*
	 * Modyfikowanie instructora - przypisywanie do niego istniejacego Instructor_detail
	 *
	 */
	public Instructor linkInstructorDetailWithInstructor(int instructorID, int instructorDetailID) {
		Session session = entityManager.unwrap(Session.class);
		Instructor instructor = session.get(Instructor.class, instructorID);
		InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailID);
		instructorDetail.setInstructor(instructor);
		instructor.setInstructorDetail(instructorDetail);
		return instructor;
		
	}
}
