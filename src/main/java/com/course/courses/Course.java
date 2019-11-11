package com.course.courses;

import javax.persistence.Entity;
import javax.persistence.Id; 

@Entity
public class Course {
	
	@Id
	private String courseId;
	private String courseName;
	private String description;
	
	public Course() {
		
	}
	
	public Course(String courseId, String courseName, String description) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
