package top;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kigyo.KigyoDBManage;
import temp.TempDBManage;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KigyoDBManage km;
    private HttpSession session;
    private String page;
    private TempDBManage tm;

	/**
     * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
     */
    public TopServlet(){

    	tm = new TempDBManage();
        km = new KigyoDBManage();
        tm.setResultMsg("");

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		session = request.getSession(false);
		if(session == null){

			page = "/sotukenAdmin/AdminLogin/login.jsp";

			RequestDispatcher disp = request.getRequestDispatcher(page);
			disp.forward(request, response);
		}

		page = "/menu/top/houkokuAll.jsp";

		try {
			km.jukenKigyoAllSelect();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//Attributeに値をセット
		request.setAttribute("km",km);

		RequestDispatcher disp = request.getRequestDispatcher(page);
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		request.setCharacterEncoding("utf-8");

		session = request.getSession(false);
		if(session == null){

			page = "/sotukenAdmin/login/login.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(page);
			disp.forward(request, response);
		}

		page = "/kensaku/kensaku.jsp";

		//Attributeに値をセット
		request.setAttribute("km",km);

		RequestDispatcher disp =request.getRequestDispatcher(page);
		disp.forward(request, response);

	}

}