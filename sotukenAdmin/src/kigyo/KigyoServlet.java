package kigyo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import temp.TempDBManage;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/KigyoServlet")
public class KigyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TempDBManage tm;
    private KigyoDBManage km;
    private KigyoInfo ki;
    private HttpSession session;
    private String page;

	/**
     * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
     */
    public KigyoServlet(){

    	tm = new TempDBManage();
        km = new KigyoDBManage();
        ki = new KigyoInfo();
        tm.setResultMsg("");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(false);
		if(session == null){

			page = "/sotukenAdmin/login/login.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(page);
			disp.forward(request, response);
		}

		page = "/kensaku/kensaku.jsp";

		String pageF = request.getParameter("page");

		switch(pageF){
			case "all":

				page = "/kigyoHenkou/kigyoHenkou.jsp";
				try {
					km.kigyoDBSelect();
				} catch (Exception e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
				break;

			case "kigyoHensyu":

				page = "/kigyoHenkou/kigyoSyousai.jsp";
				try {
					km.kigyoDBSelect(Integer.parseInt(request.getParameter("id")));
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				break;
			default:
				break;
		}

		//Attributeに値をセット
				request.setAttribute("km",km);

				RequestDispatcher disp =
						request.getRequestDispatcher(page);
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

		/*－－－－－－－－－－－－－－－－－検索－－－－－－－－－－－－－－－－－－－－*/
		//企業検索で曖昧か一致か
		if( request.getParameter("select") != null ){

			page = "kigyoHenkou/kigyoHenkou.jsp";

			try {
				km.jukenKensakuDBSelect(request.getParameter("name"), Integer.parseInt(request.getParameter("select")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/*ーーーーーーーーーーーーーーーー企業編集ーーーーーーーーーーーーーーーーーーー*/
		if(request.getParameter("kigyoHensyu") != null){
			try {
				km.kigyoDBSelect(Integer.parseInt(request.getParameter("id")));
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			session = request.getSession(false);
			session.setAttribute("KigyoInfo", km.getKi());

			page = "/kigyoHenkou/kigyoHensyu.jsp";
		}

		if(request.getParameter("kigyoKakunin") != null){

			session = request.getSession(false);
			KigyoInfo kInfo = (KigyoInfo) session.getAttribute("KigyoInfo");

			ki = new KigyoInfo(
					kInfo.getId(),
					request.getParameter("kigyoName"),
					request.getParameter("kigyoFuri"),
					request.getParameter("address")
					);
			session.setAttribute("KigyoInfo",ki);
			page = "/kigyoHenkou/kigyoKakunin.jsp";
		}

		/*企業編集確認*/
		if(request.getParameter("kigyoHensyuKakunin") != null){

			session = request.getSession(false);
			ki = (KigyoInfo) session.getAttribute("KigyoInfo");

			try {
				km.kigyoDBUpdate(ki);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		/*ーーーーーーーーーーーーーーーー企業新規登録ーーーーーーーーーーーーーーーーーー*/
		//企業登録確認
		if( request.getParameter("insertKigyoKakunin") != null ){

			page = "/menu/Menu.jsp";

			/*sessionからとってくる*/
			session = request.getSession(false);

			/*sessionに登録*/
			ki.setKigyoName(request.getParameter("kigyoName"));
			ki.setKigyoFuri(request.getParameter("kigyoFuri"));
			ki.setAddress(request.getParameter("address"));

			session.setAttribute("KigyoInfo",ki);
			page = "/kigyoTouroku/kigyoTourokuKakunin.jsp";
		}

		//企業登録
		if( request.getParameter("insertKigyo") != null ){

			/*sessionからとってくる*/
			session = request.getSession(false);

			ki = (KigyoInfo) session.getAttribute("KigyoInfo");

			try {
				km.kigyoTouroku(ki);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			page = "/menu/Menu.jsp";
		}

		//企業削除
		if( request.getParameter("kigyoDelete") != null ){

			page = "/menu/Menu.jsp";
			try {
				km.kigyoDBDelete(Integer.parseInt(request.getParameter("id")));
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

		//Attributeに値をセット
		request.setAttribute("km",km);

		RequestDispatcher disp =request.getRequestDispatcher(page);
		disp.forward(request, response);

	}
}
