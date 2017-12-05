package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {

	
	
	public static void main(String[] args) {
		
	}
	
	public void createStatement(Connection conn, int a) throws SQLException{
		Statement s = conn.createStatement(a,3);
		//the first parameter is the type, second parameter is the concurrency mode
		s = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		
		CallableStatement cs; //this is for stored procedures
		PreparedStatement ps; //this is used to call the same SQL query many times
		//PreparedStatement has specific methods for additional SQL column type such as setBlob(int parameterIndex, Blob x) and setClob(int parameterIndex, Clob x).
	}
	
	
}
