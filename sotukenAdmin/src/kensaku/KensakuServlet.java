package kensaku;

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
import toNull.ToNull;
import error.ErrorManager;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/KensakuServlet")
public class KensakuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KigyoDBManage km;
    private ToNull tn;
    private JukenHoukokuInfo jhi;
    private HttpSession session;
    private String page;
    private ErrorManager em;

	/**
     * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
     */
    public KensakuServlet(){

        km = new KigyoDBManage();
        jhi = new JukenHoukokuInfo();
        tn = new ToNull();
        em = new ErrorManager();

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

		page = "/kensaku/kensaku.jsp";

		String pageF = request.getParameter("page");

		//pageからnull以外がきたら
		if(pageF != null){

			switch(pageF){

				case "all":
					if(request.getParameter("id") == null){
						page = "kensaku/kensaku.jsp";
						try {
							km.kigyoDBSelect();
						} catch (Exception e1) {
							// TODO 自動生成された catch ブロック

							e1.printStackTrace();
						}
					}else{

						//検索結果表示JSP
						page = "/kensaku/houkokuAll.jsp";

						//検索実行
						try {
							km.jukenKigyoSelect(Integer.parseInt(request.getParameter("id")));
							km.kigyoDBSelect(Integer.parseInt(request.getParameter("id")));

						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
				break;

				case "syosai":
					//検索結果表示JSP
					page = "/kensaku/houkokuSyosai.jsp";

					//検索実行
					try {
						km.jukenSelect(Integer.parseInt(request.getParameter("juId")));

						jhi = km.getJhi();

						tn.toNull(jhi);

						km.userDBSelect(jhi.getGakuseki());
						km.kigyoDBSelect(jhi.getId());

					} catch (Exception e) {
						// TODO 自動生成された catch ブロック

						page = "/ErroPage/error.jsp";
						em.error(pageF);
						request.setAttribute("em", em);

					}
					request.setAttribute("tn",tn);
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

			page = "/sotukenAdmin/login/login.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(page);
			disp.forward(request, response);
		}

		page = "/kensaku/kensaku.jsp";

		/*－－－－－－－－－－－－－－－－－検索－－－－－－－－－－－－－－－－－－－－*/
		//企業検索で曖昧か一致か
		if( request.getParameter("select") != null ){

			try {
				km.jukenKensakuDBSelect(request.getParameter("name"), Integer.parseInt(request.getParameter("select")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//Attributeに値をセット
		request.setAttribute("km",km);

		RequestDispatcher disp =request.getRequestDispatcher(page);
		disp.forward(request, response);

	}

}