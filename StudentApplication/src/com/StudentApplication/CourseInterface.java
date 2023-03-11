package com.StudentApplication;

public interface CourseInterface {
	//create Student
	public void createCourse(Course co);
	//show all Student
	public void showAllCourse();
	//show Student based on id
	public void showCourseBasedOnID(int courseid);
	//update the Student
	public void updateCourse(int courseId,String name);
	//delete Student
	public void deleteCourse(int courseId);
}
