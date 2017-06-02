package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import stu.Student;
import db.DBConnection;

public class QueryStudent {
/*	public Student queryStudent(String name){
	/*	Connection conn = DBConnection.getConnection();
		String sql = " "+"select * from studentsystem  where studentNumber = ?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,studentNumber);
			ResultSet rs = ptmt.executeQuery();
			Student g=new Student();
			g.setStudentNumber(rs.getString("studentNumber"));
			g.setName(rs.getString("name"));
			g.setPassword(rs.getString("password"));
			g.setProfession(rs.getString("profession"));
			return g;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;*/
//	}
}

