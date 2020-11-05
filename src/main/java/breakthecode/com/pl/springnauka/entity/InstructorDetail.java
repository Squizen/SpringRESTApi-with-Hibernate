package breakthecode.com.pl.springnauka.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import breakthecode.com.pl.springnauka.interfaces.View;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView({View.InstructorDetail.class, View.Instructor.class, View.Course.class})
	private int id;
	
	@Column(name="youtube_channel")
	@JsonView({View.InstructorDetail.class, View.Instructor.class, View.Course.class})
	private String youtubeChannel;
	
	@Column(name="hobby")
	@JsonView({View.InstructorDetail.class, View.Instructor.class, View.Course.class})
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail", cascade= {CascadeType.DETACH,
			 CascadeType.MERGE,
			 CascadeType.PERSIST,
			 CascadeType.REFRESH })
	
//	@JsonProperty(access=Access.WRITE_ONLY)
	@JsonView({View.InstructorDetail.class})
	private Instructor instructor;
	
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
