package jp.ac.kic.st.s15018;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	public static Connection getConnection(){

		String url = "jdbc:mysql://localhost/lib";
		String user = "root";
		String password = "kickic";
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
		//return conn;
	}

	public static void main(String[] args) throws Exception{
		Connection cn = getConnection();
		System.out.println("connection = " + cn);
		cn.close();
	}


}
