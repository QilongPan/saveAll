package stu;

public class Teacher {
	@FieldMeta(name="������")
	private String studentNumber ;
	@FieldMeta(name="����")
	private String name ;
	@FieldMeta(name="����")
	private String age ;
	@FieldMeta(name="����")
	private String wage ;
	@FieldMeta(name="�Ա�")
	private String sex ;
	
	public Teacher() {
		
	}
	
	public Teacher( String studentNumber , String name , String age , String wage , String sex ) {
		this.studentNumber = studentNumber ;
		this.name = name ;
		this.age = age ;
		this.wage = wage;
		this.sex = sex ;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
