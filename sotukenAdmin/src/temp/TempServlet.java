package temp;

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
import toJhi.ToJhi;
import toNull.ToNull;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/TempServlet")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TempDBManage tm;
    private JukenHoukokuInfo jhi;
    private ToJhi tojhi;
    private KigyoDBManage km;
    private HttpSession session;
    private ToNull tn;


	/**
     * @see HttpServlet#HttpServlet()
     */
    public TempServlet() {
        super();
        tm = new TempDBManage();
        km = new KigyoDBManage();
        jhi = new JukenHoukokuInfo();
        tojhi = new ToJhi();
        tn = new ToNull();
        tm.setResultMsg("");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/menu/Menu.jsp";

		String pageF = request.getParameter("page");

		//pageからnull以外がきたら
		if(pageF != null){

			switch(pageF){

				case "all":

					if(request.getParameter("juId") == null && request.getParameter("gakuseki") == null){
						page = "/temp/tempUser.jsp";
						try {
							tm.userDBSelect();
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

					}else if(request.getParameter("gakuseki") != null){
						page = "temp/tempAll.jsp";
						try {
							tm.jukenKigyoSelect(Integer.parseInt(request.getParameter("gakuseki")));
							tm.userDBSelect(request.getParameter("gakuseki"));
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}else if(request.getParameter("juId") != null){
						page = "/temp/tempConf.jsp";
						try {
							tm.jukenSelect(Integer.parseInt(request.getParameter("juId")));
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

						jhi = tm.getJhi();

						tn.toNull(jhi);

						try {
							tm.kigyoDBSelect(jhi.getId());
							tm.userDBSelect(jhi.getGakuseki());
						} catch (Exception e1) {
							// TODO 自動生成された catch ブロック
							e1.printStackTrace();
						}

						request.setAttribute("tn", tn);
					}
					break;

				case "userHenkou":

					/*学籍番号が入ってなかったら*/
					if (request.getParameter("gakuseki") == null) {
						page = "temp/henkou/userHenkou.jsp";
						try {
							tm.userDBSelect();
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					/*学籍番号が入ってたら*/
					}else{

						page = "/temp/tempUpdate.jsp";

						JukenHoukokuInfo jhi = new JukenHoukokuInfo();
						jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

						jhi.setGakuseki(request.getParameter("gakuseki"));

						try {
							tm.userDBSelect(request.getParameter("gakuseki"));
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
					break;

				case "kigyoHenkou":

					/*企業IDが入ってなかったら*/
					if (request.getParameter("id") == null) {
						page = "/temp/henkou/kigyoHenkou.jsp";
						try {
							tm.kigyoDBSelect();
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

					/*企業IDが入ってたら*/
					}else{

						page = "/temp/tempUpdate.jsp";

						jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

						jhi.setId(Integer.parseInt(request.getParameter("id")));

						try {
							tm.kigyoDBSelect(Integer.parseInt(request.getParameter("id")));
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
						session.setAttribute("JukenHoukokuInfo ", jhi);
					}
					break;

				case "zen":

					if(request.getParameter("id") == null){

						page = "/temp/henkou/kigyoHenkou.jsp";
						try {
							tm.kigyoDBSelect();
						} catch (Exception e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
					}
				break;

				default:
					break;
			}

		}

		//Attributeに値をセット
		request.setAttribute("tm",tm);

		RequestDispatcher disp = request.getRequestDispatcher(page);
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		request.setCharacterEncoding("utf-8");
			String page = "/menu/Menu.jsp";

			//削除
			if(request.getParameter("deleteBtn") != null){

				try {
					tm.jukenDelete(Integer.parseInt(request.getParameter("juId")));
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

			//登録
			if(request.getParameter("insertBtn") != null){


				try {
					tm.jukenSelect(Integer.parseInt(request.getParameter("juId")));

					km.jukenHoukokuInsert(tm.getJhi());

					tm.jukenDelete(Integer.parseInt(request.getParameter("juId")));
					tm.setResultMsg("");
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				request.setAttribute("km", km);
			}

			//編集
			if(request.getParameter("updateBtn") != null){

				page = "temp/tempUpdate.jsp";

				session = request.getSession(false);

				try {
					tm.jukenSelect(Integer.parseInt(request.getParameter("juId")));
				} catch (Exception e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}

				session.setAttribute("JukenHoukokuInfo", tm.getJhi());
				tn.toNull(tm.getJhi());

				try {
					tm.kigyoDBSelect(jhi.getId());
					tm.userDBSelect(jhi.getGakuseki());
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				request.setAttribute("tn", tn);
			}

			//一時表更新確認
			if( request.getParameter("updateKakunin") != null ){

				session = request.getSession(false);

				jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

				if(jhi.getId() == 0){
					page = "/temp/tempUpdate.jsp";
					tm.setResultMsg("企業を選択してください");
				}else{
					page = "/temp/tempUpdateConf.jsp";

					tojhi.toJhi(request, response,jhi);

					tn.toNull(jhi);

					session.setAttribute("JukenHoukokuInfo", jhi);

				}




				//Attributeに値をセット
				request.setAttribute("tn",tn);

			}

			//一時表更新確認
			if( request.getParameter("updateKakuninTouroku") != null ){

				page = "/menu/Menu.jsp";

				session = request.getSession(false);

				jhi = (JukenHoukokuInfo) session.getAttribute("JukenHoukokuInfo");

				try {
					km.jukenHoukokuInsert(jhi);

					tm.jukenDelete(jhi.getJuId());
					tm.setResultMsg("");

				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				session.removeAttribute("JukenHoukokuInfo");

				request.setAttribute("km", km);


			}

			//検索
			if( request.getParameter("select") != null ){

				page = "/temp/kigyoHenkou/kigyoHenkou.jsp";

				int select = Integer.parseInt(request.getParameter("select"));
				try {
					tm.jukenKensakuDBSelect(request.getParameter("name"),select);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			//Attributeに値をセット
			request.setAttribute("tm",tm);

			RequestDispatcher disp =request.getRequestDispatcher(page);
			disp.forward(request, response);

	}


}
