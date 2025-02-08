package org.test.repository;

import org.test.model.EmpModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpRepositoryImpl extends DBTEST implements EmpRepository {

	List<EmpModel> emplist;

	@Override
	public boolean addNewEmployee(EmpModel model) {
		try {
			stmt = conn.prepareStatement("insert into employee values('0',?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setInt(3, model.getSalary());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception e) {
			System.out.println("Error is:" + e);
			return false;
		}
	}

	@Override
	public List<EmpModel> getAllEmployee() {
		emplist = new ArrayList<EmpModel>();
		try {
			stmt = conn.prepareStatement("select * from employee");
			rs = stmt.executeQuery();
			while (rs.next()) {
				EmpModel model = new EmpModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				emplist.add(model);
			}
			return emplist.size() > 0 ? emplist : null;
		} catch (Exception e) {
			System.out.println("Error is:" + e);
			return null;
		}
	}

	@Override
	public boolean updateNameById(int id, String name) {
		try {
			stmt = conn.prepareStatement("update employee set name=? where id=?");
			stmt.setString(1, name);
			stmt.setInt(2, id);
			int val = stmt.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("Error is:" + e);
			return false;
		}
	}

	@Override
	public boolean updateEmailById(int eid, String nemail) {
		try {
			stmt = conn.prepareStatement("update employee set email=? where id=?");
			stmt.setString(1, nemail);
			stmt.setInt(2, eid);
			int val = stmt.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("Error is" + e);
			return false;
		}
	}

	@Override
	public boolean updateSalaryById(int eid, int esalary) {
		try {
			stmt = conn.prepareStatement("update employee set salary=? where id=?");
			stmt.setInt(1, esalary);
			stmt.setInt(2, eid);
			int val = stmt.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("Error is" + e);
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		try {
			stmt = conn.prepareStatement("delete from employee where id=?");
			stmt.setInt(1, id);
			int val = stmt.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("Error is" + e);
			return false;
		}
	}

	@Override
	public boolean addEmployeeByCSV() {
		try {
			FileReader fr = new FileReader("C:\\jan2024\\employee.csv");
			BufferedReader br= new BufferedReader(fr);
			String row;
			int value=0;
			while((row=br.readLine())!=null) {
				String cols[]=row.split(",");
				stmt=conn.prepareStatement("insert into employee values('0',?,?,?)");
//				stmt.setInt(1, Integer.parseInt(cols[0]));
				stmt.setString(1,cols[0]);
				stmt.setString(2,cols[1]);
				stmt.setString(3,cols[2]);
				value=stmt.executeUpdate();
			}
			return value>0?true:false;
		} catch (Exception e) {
			System.out.println("Error is:"+e);
			return false;
		}
	}

}
