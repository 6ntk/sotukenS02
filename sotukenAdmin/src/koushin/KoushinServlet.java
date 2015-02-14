package koushin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import juken.JukenHoukokuInfo;
import kigyo.KigyoDBManage;
import temp.TempDBManage;
import toJhi.ToJhi;
import toNull.ToNull;
import error.ErrorManager;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/KoushinServlet")
public class KoushinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TempDBManage tm;
    private KigyoDBManage km;
    private JukenHoukokuInfo jhi;
    private HttpSession session;
    private ToJhi tojhi;
    private String page;
    private ToNull tn;
    private ErrorManager em;

	/**
     * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
     */
    public KoushinServlet(){

    	tm = new TempDBManage();
        km = new KigyoDBManage();
        jhi = new JukenHoukokuInfo();
        tojhi = new ToJhi();
        tn = new ToNull();
        em = new ErrorManager();

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

		//pageからnull以外がきたら
		if(pageF != null){

			switch(pageF){

				case "zen":

					page = "/koushin/henkou/kigyoHenkou.jsp";
					try {
						km.kigyoDBSelect();
					} catch (Exception e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

				break;

				case "userHenkou":

					/*学籍番号が入ってなかったら*/
					if (request.getParameter("gakuseki") == null) {

						page = "/koushin/henkou/userHenkou.jsp";
						try {
							km.userDBSelect();
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}else{
						page = "/koushin/houkokuKousin.jsp";

						jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

						jhi.setGakuseki(request.getParameter("gakuseki"));

						try {
							km.userDBSelect(jhi.getGakuseki());
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

						session.setAttribute("JukenHoukokuInfo", jhi);
					}
				break;

				case "kigyoHenkou":

					/*企業IDが入ってなかったら*/
					if (request.getParameter("id") == null) {
						page = "/koushin/henkou/kigyoHenkou.jsp";
						try {
							km.kigyoDBSelect();
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

					/*企業IDが入ってたら*/
					}else{

						page = "/koushin/houkokuKousin.jsp";

						jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

						jhi.setId(Integer.parseInt(request.getParameter("id")));

						try {
							km.kigyoDBSelect(Integer.parseInt(request.getParameter("id")));
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

						session.setAttribute("JukenHoukokuInfo", jhi);
					}
				break;

				default:
					break;
			}

		}

		//Attributeに値をセット
		request.setAttribute("km",km);

		RequestDispatcher disp =request.getRequestDispatcher(page);
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


		//検索
		if( request.getParameter("select") != null ){

			page = "/koushin/henkou/kigyoHenkou.jsp";

			try {
				km.jukenKensakuDBSelect(request.getParameter("name"), Integer.parseInt(request.getParameter("select")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//Attributeに値をセット
			request.setAttribute("km",km);

		}

		//報告書削除
		if( request.getParameter("deleteBtn") != null ){

			page = "/menu/msg.jsp";

			try {
				km.jukenDelete(Integer.parseInt(request.getParameter("juId")));
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();

			}
			//Attributeに値をセット
			request.setAttribute("km",km);

		}

		//報告書更新
		if( request.getParameter("updateBtn") != null ){

			page = "/koushin/houkokuKousin.jsp";

			/*sessionからとってくる*/
			session = request.getSession(false);

			try {
				km.jukenSelect(Integer.parseInt(request.getParameter("juId")));
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			jhi = km.getJhi();
			tn.toNull(jhi);

			try {
				km.kigyoDBSelect(jhi.getId());
				km.userDBSelect(jhi.getGakuseki());
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			session.setAttribute("JukenHoukokuInfo", jhi);
			//Attributeに値をセット
			request.setAttribute("km",km);
			request.setAttribute("tn",tn);
		}

		//報告書更新確認
		if( request.getParameter("updateKakunin") != null ){

			page = "/koushin/houkokuKakunin.jsp";

			session = request.getSession(false);

			jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

			//jhiがnullだったら
			if(jhi==null){
				page = "/ErroPage/error.jsp";

				em.error("updateKakunin");
				//Attributeに値をセット
				request.setAttribute("em",em);

				RequestDispatcher disp =request.getRequestDispatcher(page);
				disp.forward(request, response);
			}

			String error = tojhi.toJhi(request, response,jhi);
			if(error != "1"){
				page = error;
			}
			tn.toNull(jhi);

			session.setAttribute("JukenHoukokuInfo", jhi);

			try {
				km.userDBSelect(jhi.getGakuseki());
				km.kigyoDBSelect(jhi.getId());
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			//Attributeに値をセット
			request.setAttribute("km",km);
		}

		//報告書更新確認
		if( request.getParameter("updateKettei") != null ){

			page = "/menu/msg.jsp";
			/*sessionからとってくる*/
			session = request.getSession(false);
			jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

			try {
				km.jukenHoukokuUpdate(jhi);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			session.removeAttribute("JukenHoukokuInfo");
			//Attributeに値をセット
			request.setAttribute("km",km);

		}

		RequestDispatcher disp =request.getRequestDispatcher(page);
		disp.forward(request, response);

	}

}
