package jp.ac.kic.st.s15018;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BookBean bookBean = new BookBean();
		ServletContext application = this.getServletContext();
		String path = application.getRealPath("/WEB-INF/BookData.csv");

		bookBean.setName(request.getParameter("book_name"));
		bookBean.setAuthor(request.getParameter("author"));
		bookBean.setIsbn(request.getParameter("isbn_13"));
		bookBean.setPublishYear(Integer.parseInt(request.getParameter("publised_year")));

		BookListBean listBean = new BookListBean();

		/*List<BookBean> list =  */listBean.readDataFromCSV(path);
		if("".equals(request.getParameter("book_name"))){
			listBean = listBean.selectAll();
		}else{
			listBean = listBean.selectData(bookBean);
		}

		request.setAttribute("bookBean", bookBean);
		request.setAttribute("listBean", listBean);//nullが入っている可能性あり

		RequestDispatcher dispatcher = request.getRequestDispatcher("pub_search.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
