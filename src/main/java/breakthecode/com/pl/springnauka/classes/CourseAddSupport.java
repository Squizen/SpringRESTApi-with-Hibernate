package breakthecode.com.pl.springnauka.classes;

public class CourseAddSupport {
	
	private int id;
	private String title;
	private int instructor_id;
	
	public CourseAddSupport() {
		
	}

	public CourseAddSupport(int id, String title, int instructor_id) {
		super();
		this.id = id;
		this.title = title;
		this.instructor_id = instructor_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}
	
	
}
