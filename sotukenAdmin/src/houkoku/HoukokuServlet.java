package houkoku;

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
@WebServlet("/HoukokuServlet")
public class HoukokuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KigyoDBManage km;
    private JukenHoukokuInfo jhi;
    private HttpSession session;
    private ToJhi tojhi;
    private ToNull tn;
    private String page;
    private ErrorManager em;
    private TempDBManage tm;

	/**
     * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
     */
    public HoukokuServlet(){

    	tm = new TempDBManage();
        km = new KigyoDBManage();
        tn = new ToNull();
        jhi = new JukenHoukokuInfo();
        tojhi = new ToJhi();
        em = new ErrorManager();
        tm.setResultMsg("");

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 *
		 *ーーーーーーーーーー 検索ーーーーーーーーーーー
		 */

		session = request.getSession(false);
		if(session == null){

			page = "/sotukenAdmin/AdminLogin/login.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(page);
			disp.forward(request, response);
		}

		page = "/kensaku/kensaku.jsp";

		String pageF = request.getParameter("page");

		//pageからnull以外がきたら
		if(pageF != null){

			switch(pageF){

				case "all":

					//全表示が押されたとき
					if(request.getParameter("id") == null){

						page = "/houkoku/houkoku.jsp";
						try {
							km.kigyoDBSelect();
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

					}else{
						/*ユーザー一覧*/
						page = "/houkoku/user/userSelect.jsp";

						/*idセット*/
						jhi.setId(Integer.parseInt(request.getParameter("id")));

						/*sessionにJukenHoukokuInfoをセット*/
						session = request.getSession(false);
						session.setAttribute("JukenHoukokuInfo", jhi);

						try {
							km.userDBSelect();
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
				break;

				case "gakuseki":

					page = "/houkoku/houkokuSyoShin.jsp";

					/*sessionからとってくる*/
					session = request.getSession(false);

					JukenHoukokuInfo jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");
					jhi.setGakuseki(request.getParameter("gakuseki"));

					try {
						km.kigyoDBSelect(jhi.getId());
						km.userDBSelect(jhi.getGakuseki());
					} catch (Exception e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

					session.setAttribute("JukenHoukokuInfo", jhi);

				break;

				default:
					break;
			}

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

			page = "/sotukenAdmin/AdminLogin/login.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(page);
			disp.forward(request, response);
		}

		page = "/kensaku/kensaku.jsp";

		//企業検索で曖昧か一致か
		if( request.getParameter("select") != null ){

			page = "/houkoku/houkoku.jsp";

			try {
				km.jukenKensakuDBSelect(request.getParameter("name"), Integer.parseInt(request.getParameter("select")));
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("km",km);
		}


		//報告書提出確認
		if( request.getParameter("insertKakunin") != null ){

			page = "/houkoku/houkokuKakunin.jsp";

			session = request.getSession(false);
			jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

			//jhiがとってこれなかったら
			if(jhi == null){
				page = "/ErroPage/error.jsp";

				em.error("insertKakunin");

				request.setAttribute("em", em);

				RequestDispatcher disp =request.getRequestDispatcher(page);
				disp.forward(request, response);
			}

			tojhi.toJhi(request, response,jhi);

			session.setAttribute("JukenHoukokuInfo",tojhi.getJhi());
			tn.toNull(tojhi.getJhi());

			request.setAttribute("tn",tn);
			request.setAttribute("km",km);

		}

		//報告書登録
		if( request.getParameter("insertBtn") != null ){

			page = "/menu/Menu.jsp";

			session = request.getSession(false);
			jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

			//SQL実行
			try {
				km.jukenHoukokuInsert(jhi);
			} catch (Exception e) {
				e.printStackTrace();
			}

			session.removeAttribute("JukenHoukokuInfo");
			request.setAttribute("km", km);
		}

		RequestDispatcher disp =request.getRequestDispatcher(page);
		disp.forward(request, response);

	}

}
