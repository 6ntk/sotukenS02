package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.LoadProperty;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDBManager udbm;
	private LoadProperty lp;
	private HttpSession session;
	private String page;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        udbm = new UserDBManager();
        try {
			lp = new LoadProperty("/res/msg.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		page = "/sotukenAdmin/AdminLogin/login.jsp";

		if(request.getParameter("state")!= null){
			if(request.getParameter("state").equals("logout")){
				if(session != null){
					session.removeAttribute("loginInfo");
					session.removeAttribute("errMsg");
				}

				//response.sendRedirect("/sotukenAdmin/AdminLogin/logout.jsp");
				page = "/sotukenAdmin/AdminLogin/logout.jsp";

			}

			if(request.getParameter("state").equals("student")){
				if(session != null){
					session.removeAttribute("loginInfo");
					session.removeAttribute("errMsg");
				}

				//response.sendRedirect("/sotukenAdmin/StudentLogin/logout.jsp");
				page = "/sotukenAdmin/StudentLogin/logout.jsp";

			}

		}

		response.sendRedirect(page);
		/*RequestDispatcher disp =request.getRequestDispatcher(page);
		disp.forward(request, response);*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errPath = "/sotukenAdmin/AdminLogin/login.jsp";
		String path = "/sotukenAdmin/KensakuServlet";

		session = request.getSession(true);

		UserInfo userInfo = new UserInfo(
				request.getParameter("user"),
				request.getParameter("passwd"));
		//DB問い合わせ

		UserInfo searchUser;
		try {

			if(request.getParameter("page") != null){
				errPath = "/sotukenAdmin/StudentLogin/login.jsp";
				path = "/sotukenAdmin/StudentServlet";
				searchUser =
						udbm.userDBSearch(userInfo, UserDBManager.USER_STUDENT);
			}else{
				searchUser =
						udbm.userDBSearch(userInfo, UserDBManager.USER_ADMIN);
			}

			if( searchUser != null ){
				//User認証用セッション
				session.setAttribute("loginInfo", searchUser);
				response.sendRedirect(path);
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		session.setAttribute("errMsg", lp.getProperty("login.errMsg"));
		response.sendRedirect(errPath);

	}

}
