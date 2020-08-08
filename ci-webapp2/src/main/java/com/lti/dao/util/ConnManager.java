package com.lti.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
	
public static Connection connect() {
	try {
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url="jdbc:derby://localhost:1527/trainingdb";
		String username="raghav";
		String pass="raghav";
		Connection conn=DriverManager.getConnection(url,username,pass);
		
		return conn;
}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		return null;
}
	}
}
