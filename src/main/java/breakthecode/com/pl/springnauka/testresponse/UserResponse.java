package breakthecode.com.pl.springnauka.testresponse;

import breakthecode.com.pl.springnauka.entity.InstructorDetail;

public class UserResponse extends Response {

	private boolean isUserFound;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	private InstructorDetail instructorDetails;
	
	public UserResponse() {
		super();
	}
	
	public UserResponse(boolean isUserFound, int id, String firstName, String lastName, String email, InstructorDetail instructorDetails) {
		super();
		this.isUserFound = isUserFound;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetails = instructorDetails;
	}
	
	public UserResponse(boolean succesful, String msg, boolean isUserFound, String firstName, String lastName, String email, InstructorDetail instructorDetails) {
		super(succesful, msg);
		this.isUserFound = isUserFound;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetails = instructorDetails;
	}
	

	public boolean isUserFound() {
		return isUserFound;
	}

	public void setUserFound(boolean isUserFound) {
		this.isUserFound = isUserFound;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public InstructorDetail getInstructorDetails() {
		return instructorDetails;
	}

	public void setInstructorDetails(InstructorDetail instructorDetails) {
		this.instructorDetails = instructorDetails;
	}
	
}
