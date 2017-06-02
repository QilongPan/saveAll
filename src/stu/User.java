package stu;

public class User {
	@FieldMeta(name="ÓÃ»§ÕËºÅ")
	private String studentNumber;
	@FieldMeta(name="ĞÕÃû")
	private String name;
	@FieldMeta(name="ÃÜÂë")
	private String password;
	
	public User(){
		
	}
	
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
	
}
