package org.springframework.samples.jpetstore.initializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;


public class ConnectionManager {

	private static DataSource dataSource = null;

	private ConnectionManager() {
		super();
	}
	
	public static void initialize(DataSource ds){
		dataSource = ds;
	}
	
	public static Connection getConnection() throws SQLException{
		Connection con = dataSource.getConnection();
		return con;
	}
	
	public static void closeStatement(PreparedStatement s){
		try{
			s.close();
		}catch (Exception e){
			
		}
	}
	
	public static void closeConnection(Connection c){
		try{
			c.close();
		}catch (Exception e){
			
		}
	}
	
}
