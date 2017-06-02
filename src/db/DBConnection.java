package db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import stu.FieldMeta;

public class DBConnection {
	
	public  static  Connection getConnection(String className) {
	 String URL  =  "jdbc:mysql://127.0.0.1:3306/"+className+"system" ;
	 String USER  = "root";
	 String PASSWORD  =  "123456";
	Connection conn  = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL,USER,PASSWORD);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return conn;
	}

		public static void printStudent(String className) throws Exception  {
			String URL  =  "jdbc:mysql://127.0.0.1:3306/"+className+"system" ;
			 String USER  = "root";
			 String PASSWORD  =  "123456";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement stmt = conn.createStatement();
			String target ="stu."+ className;
			Class  clazz= Class.forName(target);
			Object inst =clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields() ;
			String sql = "select ";
			for( int i = 0 ; i < fields.length ; i++) {
				if(i < fields.length - 1)
					sql+=fields[i].getName()+",";
				else
					sql += fields[i].getName()+" from "+className+"system";
			}
			ResultSet rs = stmt.executeQuery(sql);
			
			for( int i = 0 ; i < fields.length ; i++) {
				FieldMeta meta = fields[i].getAnnotation(FieldMeta.class);  
				System.out.print(meta.name()+"                    ");
		
			}
			System.out.println();
			while(rs.next()){
				for( int i = 0 ; i < fields.length ; i++) {
					String sqlValue = fields[i].getName();
				//	System.out.print(sqlValue +" is "+rs.getString(sqlValue)+"  ");
					System.out.print(rs.getString(sqlValue)+"                         ");
				}
				System.out.println();
			}
			
		}
			
	}

