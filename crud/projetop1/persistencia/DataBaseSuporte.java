package com.eib.projetop1.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseSuporte {
	private final static String SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String SQL_URL    = "jdbc:mysql://localhost:3306/db_escola?serverTimezone=UTC&useSSL=false";
	private final static String SQL_USER   = "root";
	private final static String SQL_PASSW  = "root";
	
	//  array com  [] : new Object[]{"zd",122},
    //  Args ...  : "zd",122,Objetos, Objetos,
	public static int executeUpdate(String sql_command, Object... parametros) {
		int r = 0;
		
		Connection cnn = null;
		PreparedStatement pstm = null;
		
		try {
			Class.forName(SQL_DRIVER);
			
			cnn = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSW);
			
			pstm = cnn.prepareStatement(sql_command);
			
			if(parametros != null) {
				for (int i = 0; i < parametros.length; i++) {
					pstm.setObject( i + 1 ,parametros[i] );
				}
			}
		
		    r = pstm.executeUpdate();
			
		} catch (Exception e) {
			try {
				cnn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
		return r;
	}
	
	public static ResultSet executeQuery(String sql_command, Object... parametros) {
		ResultSet r = null;
		
		Connection cnn = null;
		PreparedStatement pstm = null;
		
		try {
			Class.forName(SQL_DRIVER);
			
			cnn = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSW);
			
			pstm = cnn.prepareStatement(sql_command);
			
			if(parametros != null) {
				for (int i = 0; i < parametros.length; i++) {
					pstm.setObject( i + 1 ,parametros[i] );
				}
			}
		
		    r = pstm.executeQuery();
		} catch (Exception e) {
			try {
				cnn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
		return r;
	}
}
