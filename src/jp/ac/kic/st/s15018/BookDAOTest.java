package jp.ac.kic.st.s15018;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookDAOTest {

	@Test
	public void test() {
		BookDAO dao = new BookDAO();
		BookListBean check = dao.findBook("html", " ", "1111", 2016, true);
		assertEquals(check == null, true);
	}

}
