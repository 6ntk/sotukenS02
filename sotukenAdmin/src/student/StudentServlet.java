package student;

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
import user.UserInfo;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KigyoDBManage km;
    private JukenHoukokuInfo jhi;
    private TempDBManage tm;
    private UserInfo ui;
    private HttpSession session;
    private ToJhi tojhi;
    private ToNull tn;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        km = new KigyoDBManage();
        jhi = new JukenHoukokuInfo();
        tm = new TempDBManage();
        ui = new UserInfo();
        tojhi = new ToJhi();
        tn = new ToNull();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 *
		 *ーーーーーーーーーー 検索ーーーーーーーーーーー
		 */
		String page = "/StudentServlet?page=all";

		String pageF = request.getParameter("page");

		//pageからnull以外がきたら
		if(pageF != null){

			switch(pageF){

				case "syosai":
					//検索結果表示JSP
					page = "/Student/kensaku/houkokuSyosai.jsp";

					//検索実行
					try {
						km.jukenSelect(Integer.parseInt(request.getParameter("juId")));

						jhi = km.getJhi();

						tn.toNull(jhi);

						km.userDBSelect(jhi.getGakuseki());
						km.kigyoDBSelect(jhi.getId());

					} catch (Exception e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

				break;

				case "all":
					if(request.getParameter("id") == null){
						page = "/Student/kensaku/kensaku.jsp";
						try {
							km.kigyoDBSelect();
						} catch (Exception e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}
					}else{
						//検索結果表示JSP
						page = "/Student/kensaku/houkokuAll.jsp";

						//検索実行
						try {
							km.jukenKigyoSelect(Integer.parseInt(request.getParameter("id")));

						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
					break;


				case "allhou":
					if(request.getParameter("id") == null){
						page = "/Student/houkoku/houkoku.jsp";
						try {
							km.kigyoDBSelect();
						} catch (Exception e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}
					}else{
						//検索結果表示JSP
						page = "/Student/houkoku/houkokuSyoShin.jsp";

						session = request.getSession(false);

						ui = (UserInfo) session.getAttribute("loginInfo");

						jhi.setGakuseki(ui.getGakuseki());
						jhi.setId(Integer.parseInt(request.getParameter("id")));

						//検索実行
						try {
							km.kigyoDBSelect(Integer.parseInt(request.getParameter("id")));
							km.userDBSelect(ui.getGakuseki());

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

		RequestDispatcher disp =
				request.getRequestDispatcher(page);
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		request.setCharacterEncoding("utf-8");
		String page = "/Student/kensaku/kensaku.jsp";

		//検索
		if( request.getParameter("select") != null ){

			int select = Integer.parseInt(request.getParameter("select"));
			try {
				km.jukenKensakuDBSelect(request.getParameter("name"),select);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("km",km);
		}

		//データベースに登録
		if( request.getParameter("insertBtn") != null ){

			page = "/menu/StudentTopMenu.jsp";
			jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

			try {
				tm.jukenHoukokuInsert(jhi);
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("tm",tm);
		}

		//報告書提出確認
		if( request.getParameter("insertKakunin") != null ){

			page = "/Student/houkoku/houkokuKakunin.jsp";

			session = request.getSession(false);
			jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

			tojhi.toJhi(request, response,jhi);

			tn.toNull(tojhi.getJhi());

			session.setAttribute("JukenhoukokuInfo", tojhi.getJhi());
			request.setAttribute("tn",tn);
			request.setAttribute("km",km);

		}

		RequestDispatcher disp =request.getRequestDispatcher(page);
		disp.forward(request, response);

	}



}
