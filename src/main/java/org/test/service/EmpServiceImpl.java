package org.test.service;

import java.util.List;

import org.test.model.EmpModel;
import org.test.repository.EmpRepository;
import org.test.repository.EmpRepositoryImpl;

public class EmpServiceImpl implements EmpService {
	EmpRepository emprepo = new EmpRepositoryImpl();

	@Override
	public boolean addNewEmployee(EmpModel model) {
		
		return emprepo.addNewEmployee(model);
		
	}

	@Override
	public List<EmpModel> getAllEmployee() {
		return emprepo.getAllEmployee();
	}

	@Override
	public boolean updateNameById(int id, String name) {
		// TODO Auto-generated method stub
		return emprepo.updateNameById(id, name);
	}

	@Override
	public boolean updateEmailById(int eid, String nemail) {
		// TODO Auto-generated method stub
		return emprepo.updateEmailById(eid, nemail);
	}

	@Override
	public boolean updateSalaryById(int eid, int esalary) {
		// TODO Auto-generated method stub
		return emprepo.updateSalaryById(eid, esalary);
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return emprepo.deleteEmployeeById(id);
	}

	@Override
	public boolean addEmployeeByCSV() {
		// TODO Auto-generated method stub
		return emprepo.addEmployeeByCSV();
	}
	

}
