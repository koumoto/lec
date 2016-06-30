package jp.ac.kic.st.s15018;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDAOTest {

	@Test
	public void test() {
		UserDAO dao = new UserDAO();
		try{
			assertEquals(dao.checkLogin("admin", "admin"), true);
		}catch (Exception e){
			fail("まだ実装されていません");
		}
	}
	
	public void test01() {
		UserDAO dao = new UserDAO();
		try{
			assertEquals(dao.checkLogin("koumoto", "koumoto"), true);
		}catch (Exception e){
			fail("まだ実装されていません");
		}
	}
	
	public void test02() {
		UserDAO dao = new UserDAO();
		try{
			assertEquals(dao.checkLogin("koumoto", "koumotoa"), false);
		}catch (Exception e){
			fail("まだ実装されていません");
		}
	}
	
	public void test03() {
		UserDAO dao = new UserDAO();
		try{
			assertEquals(dao.checkLogin("koumotoa", "koumotoa"), false);
		}catch (Exception e){
			fail("まだ実装されていません");
		}
	}

}
