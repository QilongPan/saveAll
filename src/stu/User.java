package stu;

public class User {
	@FieldMeta(name="�û��˺�")
	private String studentNumber;
	@FieldMeta(name="����")
	private String name;
	@FieldMeta(name="����")
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
