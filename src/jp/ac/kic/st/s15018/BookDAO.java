package jp.ac.kic.st.s15018;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

	public BookListBean findBook(String name, String author, String isbn, int publishYear, boolean isSelectPublish){
		Connection conn = null;
		try{
			conn = DBManager.getConnection();
			BookListBean bookListBean = new BookListBean();
			String sql = "SELECT * FROM book WHERE book_name LIKE ? AND author LIKE ? AND isbn LIKE ? ";
			if(isSelectPublish){
				sql += " AND publish_year = ?";
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ name +"%");
			pstmt.setString(2, "%"+ author +"%");
			pstmt.setString(3, "%" + isbn + "%");
			if(isSelectPublish){
				pstmt.setInt(4, publishYear);
			}
			//	System.out.println(sql);
			ResultSet rs = null;
			try{
				rs = pstmt.executeQuery();
			}catch(Exception e){
				System.err.println(e);
				System.err.println("SQL構文エラー ");
			}
			while(rs.next()){
				 String getName = rs.getString("book_name");
				 String getAuthor = rs.getString("author");
				 String getIsbn = rs.getString("isbn");
				 int getPublishYear = rs.getInt("publish_year");
				 boolean getKashidashi = rs.getBoolean("kashidashi");
				 BookBean bookBean = new BookBean(getName, getAuthor, getIsbn, getPublishYear, getKashidashi);
				 bookListBean.add(bookBean);
			}
			return bookListBean;

		}catch (Exception e){
			System.err.println(e);
			return null;
		}
	}

}