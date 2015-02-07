package toJhi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import juken.JukenHoukokuInfo;

public class ToJhi extends HttpServlet {

	private JukenHoukokuInfo jhi;

	public ToJhi() {
		super();
		jhi = new JukenHoukokuInfo();
	}

	public JukenHoukokuInfo getJhi() {
		return jhi;
	}

	public void toJhi(HttpServletRequest request, HttpServletResponse response,JukenHoukokuInfo jhi){

		//StringJoinの区切り文字
		String separator = ",";

		try {
			//何次試験、その他
			jhi.setNanji(request.getParameter("nanji"));

			if(request.getParameter("nanjiEtc") != null){
				jhi.setNanji(request.getParameter("nanjiEtc"));
			}

			jhi.setDateFrom(request.getParameter("dateFrom"));
			jhi.setDateTo(request.getParameter("dateTo"));

			String testSyu[] = request.getParameterValues("testSyu");

			int i = testSyu.length - 1;


			while(i >= 0){
				switch (testSyu[i]) {
				case "1":
					testSyu[i] = "筆記";
					break;
				case "2":
					testSyu[i] = "作文";
					break;
				case "3":
					testSyu[i] = "適性";
					break;
				case "4":
					testSyu[i] = "面接";
					break;
				case "5":
					testSyu[i] = request.getParameter("testSyuEtc");
					break;

				default:
					break;
				}

				i--;
			}

			jhi.setTestSyu(String.join(separator, testSyu));

			String tutiDate = request.getParameter("tutiDate");

			if(tutiDate.isEmpty()){
				jhi.setTutiDate(null);
			}else{
				jhi.setTutiDate(tutiDate);
			}

			if(request.getParameter("toGa") != null){
				switch (request.getParameter("toGa")) {
				case "1":
					jhi.setToGa("学校宛　郵送");
					break;
				case "2":
					jhi.setToGa("学校宛　TEL");
					break;
				case "3":
					jhi.setToGa("本人宛　郵送");
					break;
				case "4":
					jhi.setToGa("本人宛　TEL");
					break;

				default:
					break;
				}
			}else{
				jhi.setToGa("");
			}

			//筆記試験
			if(request.getParameter("ippanKamoku") != null){

				String ippanKamoku[] = request.getParameterValues("ippanKamoku");

				i = ippanKamoku.length - 1;

				while(i >= 0){

					switch (ippanKamoku[i]) {
					case "1":
						ippanKamoku[i] = "国語";
						break;
					case "2":
						ippanKamoku[i] = "数学";
						break;
					case "3":
						ippanKamoku[i] = "社会";
						break;
					case "4":
						ippanKamoku[i] = "英語";
						break;
					case "5":
						ippanKamoku[i] = request.getParameter("ippanKamokuEtc");
						break;

					default:
						break;
					}

					i--;
				}

				jhi.setIppanKamoku(String.join(separator, ippanKamoku));
			}

			if(request.getParameter("ippanTime") != ""){
				jhi.setIppanTime(Integer.parseInt(request.getParameter("ippanTime")));
			}

			//筆記試験
			if(request.getParameter("senmonKamoku") != null){

				String senmonKamoku[] = request.getParameterValues("senmonKamoku");

				i = senmonKamoku.length - 1;

				while(i >= 0){
					switch (senmonKamoku[i]){
					case "1":
						senmonKamoku[i] = "情報基礎";
						break;
					case "2":
						senmonKamoku[i] = "流れ図";
						break;
					case "3":
						senmonKamoku[i] = "コーディング";
						break;
					case "4":
						senmonKamoku[i] = request.getParameter("senmonKamoku");
						break;

					default:
						break;
					}

					i--;
				}

				jhi.setSenmonKamoku(String.join(separator, senmonKamoku));
			}

			if(request.getParameter("senmonTime") != ""){
				jhi.setSenmonTime(Integer.parseInt(request.getParameter("senmonTime")));
			}

			jhi.setSonota(request.getParameter("sonota"));

			if(request.getParameter("sonoTime") != ""){
				jhi.setSonoTime(Integer.parseInt(request.getParameter("sonoTime")));
			}

			jhi.setSikenComment(request.getParameter("sikenComment"));

			//作文
			jhi.setTheme(request.getParameter("theme"));
			if(request.getParameter("bunTime") != ""){
				jhi.setBunTime(Integer.parseInt(request.getParameter("bunTime")));
			}

			if(request.getParameter("bunRyo") != ""){
				jhi.setBunRyo(Integer.parseInt(request.getParameter("bunRyo")));
			}
			if(request.getParameter("kanseido") != ""){
				jhi.setKanseido(Integer.parseInt(request.getParameter("kanseido")));
			}

			//適性試験
			if(request.getParameter("kensaSyu") != null){

				String kensaSyu[] = request.getParameterValues("kensaSyu");

				i = kensaSyu.length - 1;
				while(i >= 0){
					switch (kensaSyu[i]){
					case "1":
						kensaSyu[i] = "能力適性";
						break;
					case "2":
						kensaSyu[i] = "職業適性";
						break;
					case "3":
						kensaSyu[i] = "性格検査";
						break;
					case "4":
						kensaSyu[i] = request.getParameter("kensaSyuEtc");
						break;

					default:
						break;
					}

					i--;
				}

				jhi.setKensaSyu(String.join(separator, kensaSyu));
			}

			if(request.getParameter("kensaTime") != ""){
				jhi.setKensaTime(Integer.parseInt(request.getParameter("kensaTime")));
			}

			jhi.setKensaComment(request.getParameter("kensaComment"));

			//面接試験
			if(request.getParameter("menNin1") != ""){
				jhi.setMenNin1(Integer.parseInt(request.getParameter("menNin1")));
			}

			if(request.getParameter("menNin2") != ""){
				jhi.setMenNin2(Integer.parseInt(request.getParameter("menNin2")));
			}

			if(request.getParameter("menKatati") != null){

				String menKatati[] = request.getParameterValues("menKatati");

				i = menKatati.length - 1;

				while(i >= 0){
					switch (menKatati[i]){
					case "1":
						menKatati[i] = "個人面接";
						break;
					case "2":
						menKatati[i] = "集団面接";
						break;
					case "3":
						menKatati[i] = "グループ討議";
						break;
					case "4":
						menKatati[i] = request.getParameter("menKatati");
						break;

					default:
						break;
					}

					i--;
				}
				jhi.setMenKatati(String.join(separator, menKatati));
			}

			if(request.getParameter("kensaTime") != ""){
				jhi.setMenTime(Integer.parseInt(request.getParameter("kensaTime")));
			}

			jhi.setSitsuComment(request.getParameter("sitsuComment"));
			jhi.setHanseiComment(request.getParameter("hanseiComment"));

			//健康診断
			jhi.setKenComment(request.getParameter("kenComment"));

			//助言
			jhi.setJogen(request.getParameter("jogen"));
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		this.jhi = jhi;
	}

}
