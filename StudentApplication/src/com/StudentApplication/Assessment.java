package com.StudentApplication;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Assessment {
//  public static void run() {
//    try {
//      // connect to the database
//      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/studentdb?useSSL=false", "root", "root");
//
//      // create a statement
//      Statement stmt = conn.createStatement();
//
//      // select data from student and course tables
//      ResultSet rs = stmt.executeQuery("SELECT s.id, s.name, c.courseId, c.name as cname FROM student s INNER JOIN course c ON s.courseId = c.courseId;");
//
//      // prompt the user to input values for each student's marks
//      Scanner scanner = new Scanner(System.in);
//      while (rs.next()) {
//        int studentId = rs.getInt("id");
//        String studentName = rs.getString("name");
//        int courseId = rs.getInt("courseId");
//        String courseName = rs.getString("cname");
//        double tutorial1, tutorial2, exam;
//
//        do {
//          System.out.print("Enter a value for tutorial1 (0-20) for student " + studentName + " in " + courseName + ": ");
//          tutorial1 = scanner.nextDouble();
//        } while (tutorial1 < 0 || tutorial1 > 20);
//
//        do {
//          System.out.print("Enter a value for tutorial2 (0-20) for student " + studentName + " in " + courseName + ": ");
//          tutorial2 = scanner.nextDouble();
//        } while (tutorial2 < 0 || tutorial2 > 20);
//
//        do {
//          System.out.print("Enter a value for exam (0-20) for student " + studentName + " in " + courseName + ": ");
//          exam = scanner.nextDouble();
//        } while (exam < 0 || exam > 20);
//
//        // calculate the average of tutorial1, tutorial2, and exam
//        double internal = (tutorial1 + tutorial2 + exam) / 3.0;
//
//        // check if the row already exists
//        PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*) AS count FROM assessment WHERE id = ? AND courseId = ?");
//        checkStmt.setInt(1, studentId);
//        checkStmt.setInt(2, courseId);
//        ResultSet checkRs = checkStmt.executeQuery();
//        checkRs.next();
//        int count = checkRs.getInt("count");
//
//        if (count == 0) {
//          // insert values into the assessment table
//          String sql = "INSERT INTO assessment (id, name, courseId, cname, tutorial1, tutorial2, exam, internal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//          PreparedStatement pstmt = conn.prepareStatement(sql);
//          pstmt.setInt(1, studentId);
//          pstmt.setString(2, studentName);
//          pstmt.setInt(3, courseId);
//          pstmt.setString(4, courseName);
//          pstmt.setDouble(5, tutorial1);
//          pstmt.setDouble(6, tutorial2);
//          pstmt.setDouble(7, exam);
//          pstmt.setDouble(8, internal);
//          pstmt.executeUpdate();
//          pstmt.close();
//        } else {
//          System.out.println("Assessment for student " + studentName + " in " + courseName + " already exists. Skipping...");
//        }
//      }
//
//      // close the resources
//      rs.close();
//      stmt.close();
//      conn.close();
//    } catch (SQLException e) {
//      System.out.println("Error: " + e.getMessage());
//    }
//  }
	public static void run() {
	  try {
		    // connect to the database
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/studentdb?useSSL=false", "root", "root");

		    // create a statement
		    Statement stmt = conn.createStatement();

		    // prompt the user to input values for each student's marks for specific IDs
		    Scanner scanner = new Scanner(System.in);
		    System.out.print("Enter comma-separated student IDs to enter marks for: ");
		    String inputIds = scanner.nextLine();
		    String[] ids = inputIds.split(",");
		    for (String id : ids) {
		      // select data from student and course tables for specific IDs
		      ResultSet rs = stmt.executeQuery("SELECT s.id, s.name, c.courseId, c.name as cname FROM student s INNER JOIN course c ON s.courseId = c.courseId WHERE s.id = " + id.trim());

		      if (rs.next()) {
		        int studentId = rs.getInt("id");
		        String studentName = rs.getString("name");
		        int courseId = rs.getInt("courseId");
		        String courseName = rs.getString("cname");
		        double tutorial1, tutorial2, exam;

		        do {
		          System.out.print("Enter a value for tutorial1 (0-20) for student " + studentName + " in " + courseName + ": ");
		          tutorial1 = scanner.nextDouble();
		        } while (tutorial1 < 0 || tutorial1 > 20);

		        do {
		          System.out.print("Enter a value for tutorial2 (0-20) for student " + studentName + " in " + courseName + ": ");
		          tutorial2 = scanner.nextDouble();
		        } while (tutorial2 < 0 || tutorial2 > 20);

		        do {
		          System.out.print("Enter a value for exam (0-20) for student " + studentName + " in " + courseName + ": ");
		          exam = scanner.nextDouble();
		        } while (exam < 0 || exam > 20);

		        // calculate the average of tutorial1, tutorial2, and exam
		        double internal = (tutorial1 + tutorial2 + exam) / 3.0;

		        // check if the row already exists
		        PreparedStatement checkStmt = conn.prepareStatement("SELECT COUNT(*) AS count FROM assessment WHERE id = ? AND courseId = ?");
		        checkStmt.setInt(1, studentId);
		        checkStmt.setInt(2, courseId);
		        ResultSet checkRs = checkStmt.executeQuery();
		        checkRs.next();
		        int count = checkRs.getInt("count");

		        if (count == 0) {
		          // insert values into the assessment table
		          String sql = "INSERT INTO assessment (id, name, courseId, cname, tutorial1, tutorial2, exam, internal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		          PreparedStatement pstmt = conn.prepareStatement(sql);
		          pstmt.setInt(1, studentId);
		          pstmt.setString(2, studentName);
		          pstmt.setInt(3, courseId);
		          pstmt.setString(4, courseName);
		          pstmt.setDouble(5, tutorial1);
		          pstmt.setDouble(6, tutorial2);
		          pstmt.setDouble(7, exam);
		          pstmt.setDouble(8, internal);
		          pstmt.executeUpdate();
		          pstmt.close();
		        } else {
		          System.out.println("Assessment for student " + studentName + " in " + courseName + " already exists. Skipping...");
		        }
		      } else {
		        System.out.println("Student with ID " + id.trim() );
		        // close the resources
		        rs.close();
		        stmt.close();
		        conn.close();
		        } 
		     
		    }} catch (SQLException e) {
		        System.out.println("Error: " + e.getMessage());
		      }}
		        


  public void showAllStudent() {
	    Connection con = DBConnection.createDBConnection();
	    String query = "SELECT * FROM assessment";
	    try {
	        Statement stmt = con.createStatement();
	        ResultSet result = stmt.executeQuery(query);
	        System.out.println("ID    Name                     CourseId                  CName                     Tutorial 1        Tutorial2       Exam     Internal");
	        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
	        while (result.next()) {
	            System.out.printf("%-6d%-25s%-25d%-25s%-18.2f%-16.2f%-9.2f%-9.2f%n",
	                result.getInt("id"),
	                result.getString("name"),
	                result.getInt("courseId"),
	                result.getString("cname"),
	                result.getDouble("tutorial1"),
	                result.getDouble("tutorial2"),
	                result.getDouble("exam"),
	                result.getDouble("internal"));
	        }
	        stmt.close();
	        result.close();
	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	    } finally {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}
  public void deleteCourse(int id) {
		// TODO Auto-generated method stub
	  Connection con = DBConnection.createDBConnection();
		String query="delete from assessment where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1, id);
		int cnt=pstm.executeUpdate();
		if(cnt!=0)
			System.out.println("Successfully deleted");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

                

