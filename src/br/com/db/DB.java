package br.com.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import br.com.bdExecption.DBException;

public class DB {
	
	private static Connection conn =  null;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {		
				Properties prop = lerpropriedade();
				String url = prop.getProperty("DBurl");
				conn = DriverManager.getConnection(url, prop);
			}catch (Exception e) {
				throw new DBException(e.getMessage());
			}
			
		}
		
		return conn;
	}
	
	
	
	private static Properties lerpropriedade() {
		try (FileInputStream fs = new FileInputStream("db.propriedade")){
			Properties prop = new Properties();
			prop.load(fs);
			
			return prop;
		}catch(IOException e) {
			throw new DBException(e.getMessage());
		}
	}
	
	public static void closeConnetion() {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
}
