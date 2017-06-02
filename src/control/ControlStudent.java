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
		System.out.println("����������ѡ��(1-5): ");
		System.out.println("1:����");
		System.out.println("2:ɾ��");
		System.out.println("3:�޸�");
		System.out.println("4:����");
		System.out.println("5:�˳�");
		int choose = input.nextInt();
		return choose;
	}
	
	public static Student getStudent() {
		Scanner input = new Scanner(System.in);
		Student student = new Student();
		System.out.println("������ѧ��: ");
		student.setStudentNumber(input.next());
		System.out.println("����������: ");
		student.setName(input.next());
		System.out.println("����������: ");
		student.setPassword(input.next());
		System.out.println("������רҵ: ");
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
			System.out.println("��������"+meta.name());
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
		System.out.println("���������: ");
		deleStudent.deleteStudent(input.next(),objectName);
	}

	public static void printStudent(String objectName) throws Exception {
		DBConnection.printStudent(objectName);
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ�޸ĺ���: ");
		String id = input.next() ;
		DeleteImpl deleStudent = new DeleteImpl();
		deleStudent.deleteStudent(id,objectName);
		String target ="stu."+ objectName;
		Class  clazz= Class.forName(target);
		Object inst =clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields() ;
		for(Field field : fields) {
			FieldMeta meta = field.getAnnotation(FieldMeta.class);  
			System.out.println("������������"+meta.name());
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
		System.out.println("��Ҫ����ʲô����: ");
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
