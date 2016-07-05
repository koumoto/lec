package jp.ac.kic.st.s15018;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminBookAddServlet
 */
public class AdminBookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBookAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin_registered.html");
		BookBean bookBean = new BookBean();
		BookDAO dao = new BookDAO();
		bookBean.setName(request.getParameter("book_name"));
		bookBean.setAuthor(request.getParameter("author"));
		bookBean.setIsbn(request.getParameter("isbn_13"));
		if(request.getParameter("publised_year") != null){
			bookBean.setPublishYear(Integer.parseInt(request.getParameter("publised_year")));
		}else{
			bookBean.setPublishYear(2016);
		}
		int result = dao.add(bookBean);
		if(result == 1){
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("error.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin_registered.jsp");
		BookBean bookBean = new BookBean();
		BookDAO dao = new BookDAO();
		bookBean.setName(request.getParameter("book_name"));
		bookBean.setAuthor(request.getParameter("author"));
		bookBean.setIsbn(request.getParameter("isbn_13"));

		try{
			bookBean.setPublishYear(Integer.parseInt(request.getParameter("publised_year")));
		}catch (Exception e){
			response.sendRedirect("error.html");//出版年度のチェックだけする。
			return;
		}

		int result = dao.add(bookBean);
		if(result == 1){
			request.setAttribute("bean", bookBean);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("error.html");
		}
	}

}
