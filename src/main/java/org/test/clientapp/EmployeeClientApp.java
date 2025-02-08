package org.test.clientapp;

import java.io.*;
import java.util.*;

import org.test.model.EmpModel;
import org.test.service.EmpService;
import org.test.service.EmpServiceImpl;

public class EmployeeClientApp {

	public static void main(String[] args) {
		EmpService empService = new EmpServiceImpl();
		EmpModel model = new EmpModel();
		
		int choice=0;
		do {	
			System.out.println("Enter 1 for add employee");
			System.out.println("Enter 2 for view employee");
			System.out.println("Enter 3 for update employee");
			System.out.println("Enter 4 for delete employee");
			System.out.println("Enter 5 for Add employee using CSV file");
			System.out.println("Enter 6 for exit");
			System.out.println("Enter your choice:");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter name,email and salary of employee...");
//				int id = sc.nextInt();
//				sc.nextLine();
				String name = sc.nextLine();
				String email = sc.nextLine();
				int salary = sc.nextInt();
				sc.nextLine();
				
//				model.setId(id);
				model.setName(name);
				model.setEmail(email);
				model.setSalary(salary);
				boolean b = empService.addNewEmployee(model);
				if (b) {
					System.out.println("Employee added successfully...");
				}
				else {
					System.out.println("Employee not added...");
				}
				break;
			case 2:
				List <EmpModel> emplist = new ArrayList<EmpModel>();
				emplist = empService.getAllEmployee();
				emplist.forEach((e)->System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getEmail()+"\t"+e.getSalary()));
				break;
			case 3:
//				List <EmpModel> emplist = new ArrayList<EmpModel>();
				System.out.println("Employee list before update");
				emplist = empService.getAllEmployee();
				emplist.forEach((e)->System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getEmail()+"\t"+e.getSalary()));
				
				System.out.println("Enter id for update employee");
				int eid = sc.nextInt();
				sc.nextLine();
				int key;
				do {
					System.out.println("Enter 1 for update name");
					System.out.println("Enter 2 for update email");
					System.out.println("Enter 3 for update salary");
					System.out.println("Enter 4 for Exit from updatation..");
					System.out.println("Enter Your choice:");
					 key = sc.nextInt();
					sc.nextLine();
					switch (key) {
					case 1:
						System.out.println("Enter new name for update:");
						String ename = sc.nextLine();
						b = empService.updateNameById(eid, ename);
						if (b) {
							System.out.println("Name updated successfully...");
						}
						else {
							System.out.println("Name not updated...");
						}
						break;
					case 2:
						System.out.println("Enter new email for update:");
						String nemail = sc.nextLine();
						b = empService.updateEmailById(eid, nemail);
						if (b) {
							System.out.println("Email updated successfully...");
						}
						else {
							System.out.println("Email not updated...");
						}
						break;
					case 3:
						System.out.println("Enter new salary for update:");
						int esalary = sc.nextInt();
						b = empService.updateSalaryById(eid, esalary);
						if (b) {
							System.out.println("Salary updated successfully...");
						}
						else {
							System.out.println("Salary not updated...");
						}
						break;
					
					default:
						System.out.println("Invalid selection...");
						break;
					}
				} while (key!=4);
				break;
			case 4:
				System.out.println("Employee list before delete");
				emplist = empService.getAllEmployee();
				emplist.forEach((e)->System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getEmail()+"\t"+e.getSalary()));
				System.out.println("Enter Employee id for delete:");
				int id = sc.nextInt();
				b = empService.deleteEmployeeById(id);
				if (b) {
					System.out.println("Employee deleted successfully...");
				}
				else {
					System.out.println("Employee not deleted...");
				}
				break;
			case 5:
				b = empService.addEmployeeByCSV();
				if (b) {
					System.out.println("Employee Added Succeessfully...");
				}
				else {
					System.out.println("Employee not added...");
				}

				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalide choice...");
				break;
			}
			
		}while(true);
	}

}
