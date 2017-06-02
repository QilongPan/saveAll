package impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.DBConnection;
import stu.Student;
public class UserImpl {
	public void saveStudent(Object inst,Class clazz,String className) throws SQLException, IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Connection conn = DBConnection.getConnection(className);
		Field[] fields = clazz.getDeclaredFields() ;
		String sql = " "+"insert into "+className+"system (";
		for( int i = 0 ; i < fields.length ; i++) {
			if(i<fields.length-1)
				sql+=fields[i].getName()+",";
			else
				sql+=fields[i].getName()+") values(";
		}
		for( int i = 0 ; i < fields.length ; i++) {
			if(i<fields.length-1)
				sql+="?,";
			else
				sql+="?)";
		}
		PreparedStatement ptmt = conn.prepareStatement(sql);
		for( int i = 0 ; i < fields.length ; i++) {
			PropertyDescriptor pd = new PropertyDescriptor(fields[i].getName(), clazz);
			Method rM = pd.getReadMethod();
			ptmt.setString(i+1, (String) rM.invoke(inst)) ;
		}
		ptmt.execute();
	}
}
