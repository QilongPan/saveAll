package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;

import stu.Student;

public class QueryMoreUser {
	public ArrayList<Student> queryMoreUser(String name,String objectName){
		ArrayList<Student> students = new ArrayList<Student> ();
		Connection conn = DBConnection.getConnection(objectName);
		String sql = " "+"select * from studentsystem  where name like ?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,"%"+name+"%");
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				Student g=new Student();
				g.setStudentNumber(rs.getString("studentNumber"));
				g.setName(rs.getString("name"));
				g.setPassword(rs.getString("password"));
				g.setProfession(rs.getString("profession"));
				students.add(g);
			}
		return students;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return students;
}

}
