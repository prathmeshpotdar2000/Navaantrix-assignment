package org.test.service;

import java.util.List;

import org.test.model.EmpModel;

public interface EmpService {
	public boolean addNewEmployee(EmpModel model);
	public List<EmpModel> getAllEmployee();
	public boolean updateNameById(int id,String name);
	public boolean updateEmailById(int eid, String nemail);
	public boolean updateSalaryById(int eid, int esalary);
	public boolean deleteEmployeeById(int id);
	public boolean addEmployeeByCSV();

}
