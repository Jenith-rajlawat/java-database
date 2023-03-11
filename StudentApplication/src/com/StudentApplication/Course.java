package com.StudentApplication;

public class Course {
	private int courseId;
	private String name;
  	private String Instructor;
  	
  	public Course() {
  		
  	}
  	@Override
  	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", Instructor=" + Instructor + "]";
	}
  	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructor() {
		return Instructor;
	}
	public void setInstructor(String instructor) {
		Instructor = instructor;
	}
	
}
