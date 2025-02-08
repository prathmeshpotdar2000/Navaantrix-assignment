package org.test.model;

public class EmpModel {
	private int id;
	private String name;
	private String email;
	private int salary;

	public EmpModel() {
		
	}
	public EmpModel(String name, String email, int salary) {
		super();
//		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public EmpModel(int id,String name, String email, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return "EmpModel [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
	
	
}
