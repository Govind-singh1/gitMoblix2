package com.moglix.studentmanagementsystem.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {
	@Autowired
	DataSource mysqlDataSource;
	public Connection getConnection() {
		Connection connection;
		try {
			 connection =mysqlDataSource.getConnection();
			 return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
