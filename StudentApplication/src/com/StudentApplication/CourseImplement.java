package com.StudentApplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class CourseImplement implements CourseInterface {
	Connection con;

	@Override
	public void createCourse(Course co) {
		// TODO Auto-generated method stub
		//first to get the connection to our database we have our db connection class so call it
				con=DBConnection.createDBConnection();
				String query="insert into course values(?,?,?);";
				try {
				PreparedStatement pstm=con.prepareStatement(query);
				pstm.setInt(1, co.getCourseId());
				pstm.setString(2, co.getName());
				pstm.setString(3, co.getInstructor());
				int cnt=pstm.executeUpdate();
				if(cnt!=0)
					System.out.println("Student Registered Successfully!!!");
				}catch(Exception ex) {
					System.out.println("The id is primary and must be unique");
					ex.printStackTrace();
				}
		
	}

	@Override
	public void showAllCourse() {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="select * from course";
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			while(result.next()) {
			    int courseId = result.getInt(1);
			    String name = result.getString(2);
			    String Instructor= result.getString(3);
			    System.out.format("%-14d %-20s %-16s \n", courseId, name, Instructor);
			}}//if we have anything in this result the loop will execute
			catch(Exception ex) {
				ex.printStackTrace();
			}
	}

	@Override
	public void showCourseBasedOnID(int courseId) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="select * from course where courseId="+courseId;
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			while(result.next()) {
			     courseId = result.getInt(1);
			    String name = result.getString(2);
			    String Instructor= result.getString(3);
			    System.out.format("%-14d %-20s %-16s \n", courseId, name, Instructor);
			}}//if we have anything in this result the loop will execute
				catch(Exception ex) {
					System.out.println("The searching id doesnot exits");
		ex.printStackTrace();}
	}

	@Override
	public void updateCourse(int courseId, String name) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="update course set name=? where courseId=?";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setString(1,name);
			pstm.setInt(2, courseId);
		int cnt=pstm.executeUpdate();
		if(cnt!=0)
			System.out.println("Course Updated Successfully !!");
		}
		catch(Exception ex) {
			System.out.println("The searched id doesnot exist");
			ex.printStackTrace();
		}
		
	}

	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="delete from course where courseId=?";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1, courseId);
		int cnt=pstm.executeUpdate();
		if(cnt!=0)
			System.out.println("Successfully deleted");
		}
		catch(Exception ex)
		{
			System.out.println("No such Id");
			ex.printStackTrace();
		}
	}
	
}
