package com.StudentApplication;
import java.sql.*;
import java.util.Date;

public class Enrollment {
    public static void run() {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?useSSL=false", "root", "root");
            
            // Get the current date and time
            Date currentDate = new Date(System.currentTimeMillis());
            
            // Define the SQL statement to insert into the enrollment table
//            String sql = "INSERT INTO enrollment (id, courseId, enrollDate) " +
//                         "SELECT s.id, c.courseId, ? " +
//                         "FROM student s, course c " +
//                         "WHERE s.courseId = c.courseId";
            String sql = "INSERT INTO enrollment (id, courseId, enrollDate) " +
                    "SELECT s.id, c.courseId, ? " +
                    "FROM student s, course c " +
                    "WHERE s.courseId = c.courseId " +
                    "AND NOT EXISTS (SELECT * FROM enrollment e " +
                    "                 WHERE e.id = s.id AND e.courseId = c.courseId)";
            
            // Prepare the statement and set the date value
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(currentDate.getTime()));
            
            // Execute the statement
            int rowsAffected = stmt.executeUpdate();
            
            // Print the number of rows inserted
            System.out.println(rowsAffected + " rows inserted.");
        } catch (SQLException ex) {
            System.out.println("Database error: " + ex.getMessage());
        } finally {
            // Close the database resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing database resources: " + ex.getMessage());
            }
        }
    }
    public void showAllStudent() {
		// TODO Auto-generated method stub
    	Connection con;
		con=DBConnection.createDBConnection();
		String query="select * from enrollment";
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			System.out.println("ID    CourseId      EnrollmentDate");
			System.out.println("------------------------------------------");
			while(result.next()) {
				 int id = result.getInt("id");
				    int courseId = result.getInt("courseId");
				    Date enrollDate = result.getDate("enrollDate");
			    System.out.format("%-5d %-9d %-16s\n", id, courseId, enrollDate);
			}//if we have anything in this result the loop will execute
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

