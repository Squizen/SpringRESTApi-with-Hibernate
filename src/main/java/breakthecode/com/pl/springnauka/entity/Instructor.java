package breakthecode.com.pl.springnauka.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import breakthecode.com.pl.springnauka.interfaces.View;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView({View.Instructor.class, View.InstructorDetail.class, View.Course.class})
	private int id;

	@Column(name="first_name")
	@JsonView({View.Instructor.class, View.InstructorDetail.class, View.Course.class})
	private String firstName;
	
	@Column(name="last_name")
	@JsonView({View.Instructor.class, View.InstructorDetail.class, View.Course.class})
	private String lastName;
	
	@Column(name="email")
	@JsonView({View.Instructor.class, View.InstructorDetail.class, View.Course.class})
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	@JsonView({View.Instructor.class, View.Course.class})
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy="instructor",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					  CascadeType.DETACH, CascadeType.REFRESH})
	@JsonView({View.Instructor.class, View.InstructorDetail.class})
	private List<Course> listOfCourses;
	
	public Instructor() {
		
	}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public List<Course> getListOfCourses() {
		return listOfCourses;
	}

	public void setListOfCourses(List<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}

	public void addCourse (Course tempCourse) {
		if(listOfCourses == null) {
			listOfCourses = new ArrayList<Course>();
		}
		listOfCourses.add(tempCourse);
		tempCourse.setInstructor(this);
	}
}
