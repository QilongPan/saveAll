package impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.DBConnection;
import stu.Student;

public class UpdateImpl {
	public void updateStudent(Student student) {
	/*	Connection conn = DBConnection.getConnection();
		String sql = " "+"update studentsystem  set  name=?,password=?,profession=? where studentNumber = ?";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,student.getName());
			ptmt.setString(2,student.getPassword());
			ptmt.setString(3,student.getProfession());
			ptmt.setString(4,student.getStudentNumber());
			ptmt.execute();
		} catch (SQLException e)  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
