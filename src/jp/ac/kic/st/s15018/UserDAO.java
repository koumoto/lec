package jp.ac.kic.st.s15018;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {


	public boolean checkLogin(String inputUser, String inputPasswd) {
		Connection conn = null;
		try{
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE user_name = ? AND password = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputUser);
			pstmt.setString(2, inputPasswd);
			//System.out.println(pstmt);
			ResultSet rs = null;
			try{
				rs = pstmt.executeQuery();
			}catch(Exception e){
				System.err.println(e);
				System.err.println("SQL構文エラー");
			}
			if(rs.next()){
				return true;
			}
			return false;
		}catch (Exception e){
			System.err.println(e);
			return false;
		}finally{
			if(conn != null) {
				try{
					conn.close();
				}catch (Exception e){
					System.err.println(e);
				}
			}
		}
 	}
}
