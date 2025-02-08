package org.test.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.PropertyConfigurator;
import org.test.repository.DBconfig;

public class DBTEST {
	DBconfig config = DBconfig.getInstance();
	protected Connection conn = config.getConn();
	protected PreparedStatement stmt = config.getStatement();
	protected ResultSet rs = config.getResult();
	protected CallableStatement cstmt = config.getCallStatement();
//	static {
//		PropertyConfigurator.configure("C:\\Users\\admin\\eclipse-workspace\\EmpCURDApp\\src\\main\\resources\\application.properties");
//	}
}
