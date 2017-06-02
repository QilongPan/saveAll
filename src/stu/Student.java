package stu;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Student {
	
	@FieldMeta(name="学生号")
	private String studentNumber;
	@FieldMeta(name="姓名")
	private String name;
	@FieldMeta(name="密码")
	private String password;
	@FieldMeta(name="专业")
	private String profession;

	public String getStudentNumber() {
	
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public String toString() {
		return "This is Student";
	}

	public void speak(String message) {
		System.out.println("Speak:    "+message);
	}
	
}

