package control;

import impl.DeleteImpl;
import impl.QueryStudent;
import impl.UpdateImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import impl.UserImpl;
import java.lang.reflect.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnection;

import stu.FieldMeta;
import stu.Student;

public class ControlStudent {
	
	public static int getPrompt() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您的选择(1-5): ");
		System.out.println("1:增加");
		System.out.println("2:删除");
		System.out.println("3:修改");
		System.out.println("4:查找");
		System.out.println("5:退出");
		int choose = input.nextInt();
		return choose;
	}
	
	public static Student getStudent() {
		Scanner input = new Scanner(System.in);
		Student student = new Student();
		System.out.println("请输入学号: ");
		student.setStudentNumber(input.next());
		System.out.println("请输入姓名: ");
		student.setName(input.next());
		System.out.println("请输入密码: ");
		student.setPassword(input.next());
		System.out.println("请输入专业: ");
		student.setProfession(input.next());
		return student;
	}
	
	public static void addStudent(String className) throws SQLException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException, IntrospectionException, InvocationTargetException {
		Scanner input = new Scanner(System.in);
		String target ="stu."+ className;
		Class<?>  clazz= Class.forName(target);
		
		Object inst =clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields() ;
		for(Field field : fields) {
			FieldMeta meta = field.getAnnotation(FieldMeta.class);  
			System.out.println("请您输入"+meta.name());
			String value = input.next();
			field.setAccessible(true) ;
			field.set(inst, value) ;
		}
		UserImpl saveStu = new UserImpl();
		saveStu.saveStudent(inst,clazz,className);
	}
	
	public static void deleStudent(String objectName) {
		Scanner input = new Scanner(System.in);
		DeleteImpl deleStudent = new DeleteImpl();
		System.out.println("请输入号数: ");
		deleStudent.deleteStudent(input.next(),objectName);
	}

	public static void printStudent(String objectName) throws Exception {
		DBConnection.printStudent(objectName);
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入要修改号数: ");
		String id = input.next() ;
		DeleteImpl deleStudent = new DeleteImpl();
		deleStudent.deleteStudent(id,objectName);
		String target ="stu."+ objectName;
		Class  clazz= Class.forName(target);
		Object inst =clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields() ;
		for(Field field : fields) {
			FieldMeta meta = field.getAnnotation(FieldMeta.class);  
			System.out.println("请您重新输入"+meta.name());
			String value = input.next();
			field.setAccessible(true) ;
			field.set(inst, value) ;
		}
		UserImpl saveStu = new UserImpl();
		saveStu.saveStudent(inst,clazz, objectName);
	}
	
	public static void updateStudent(String className) throws Exception {
		UserImpl saveStu = new UserImpl();
		printStudent(className);
	}
	
	public static void controlStudent() throws Exception {
		System.out.println("您要操作什么对象: ");
		Scanner input = new Scanner(System.in);
		String objectName = input.next();
		
		int choose = getPrompt();
		while(true) {
			switch(choose){
				case 1: addStudent(objectName);
						break;
				case 2:deleStudent(objectName);
						break;
				case 3:updateStudent(objectName);
					break;
			case 4:DBConnection.printStudent(objectName);
					break;
				case 5:System.exit(0);
						break;
			}
			choose = getPrompt();
		}
	}
	
	public static void main(String[] args) throws Exception {
		controlStudent();
	}
	
}
