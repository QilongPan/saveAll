package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnection;

public class DeleteImpl {
	public void deleteStudent(String studentNumber,String className) {
		Connection conn = DBConnection.getConnection(className);
		String sql =" "+"delete from "+className+"system where studentNumber = ? ";
		try {
			PreparedStatement ptmt  =  conn.prepareStatement(sql);
			ptmt.setString(1,studentNumber);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
