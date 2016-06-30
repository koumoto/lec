package jp.ac.kic.st.s15018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheckServlet
 */
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> map = new HashMap<String, String>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CSVファイルの読み込み
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher dispatcher;
		//ServletContext application = this.getServletContext();
		//String path = application.getRealPath("/WEB-INF/user.csv");
		UserDAO dao = new UserDAO();
		//System.out.println(path);//debug用
		if(dao.checkLogin(request.getParameter("user_id"), request.getParameter("passwd"))){
			HttpSession session = request.getSession();
			session.setAttribute("user", request.getParameter("user_id"));
			dispatcher = request.getRequestDispatcher("AdminIndexServlet");
			dispatcher.forward(request,response);
		}else{
			response.sendRedirect("error.html");
		}
	}

	public boolean checkLogin(String inputUser, String inputPasswd, String path) throws IOException{
		String line;
		String[] userData;
		File file = new File(path); // CSVデータファイル
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
			userData = line.split(",");
			String user = userData[0];
			String passwd = userData[1];
			map.put(user, passwd);//マップに格納
		}
		if(br != null){
			br.close();
		}
		if(map.containsKey(inputUser)){//ユーザが存在する場合
			 String filePasswd = map.get(inputUser);
			 if(filePasswd.equals(inputPasswd)){//ユーザが存在し、なおかつパスワードが一致する場合
				 return true;
			 }
		}
		return false;
	}

}
