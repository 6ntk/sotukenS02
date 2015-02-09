package kyotu;

import java.io.IOException;
import java.util.ArrayList;

import juken.JukenHoukokuInfo;
import juken.JukenInfo;
import kigyo.KigyoInfo;
import tools.LoadProperty;
import user.UserInfo;
import db.DBAccess;

public class SuperClass extends DBAccess {

	private ArrayList<KigyoInfo> kList;
	private ArrayList<JukenInfo> ji;
	private ArrayList<UserInfo> uList;
	private KigyoInfo ki;
	private UserInfo ui;
	private JukenInfo jik;
	private JukenHoukokuInfo jhi;

	/*企業*/
	private String selectKigyoAllSql ="select * from kigyo where id != 0";
	private String selectKigyoSql ="select * from kigyo where id=?";

	/*検索*/
	private String jukenMaeSql = "select * from kigyo where kigyoName like ? and id != 0";
	private String jukenZenbuSql = "select * from kigyo where kigyoName=? and id != 0";

	/*ユーザー*/
	private String selectUserSql	= "select sotuDate,syuNum,sex,name from users where gakuseki=?";
	private String selectUserAllSql	= "select gakuseki,syuNum,sex,name from users";

	/*報告書*/
	private String jukenSelectSql = "select juId,DATE_FORMAT(teiDate, '%Y/%m/%d %H:%i:%s') teiDate,gakuseki,id,nanji,DATE_FORMAT(dateFrom, '%Y/%m/%d %H:%i') dateFrom,DATE_FORMAT(dateTo, '%Y/%m/%d %H:%i') dateTo,testSyu,DATE_FORMAT(tutiDate, '%Y/%m/%d %H:%i') tutiDate,toGa,ippanKamoku,ippanTime,senmonKamoku,senmonTime,sonota,sonoTime,sikenComment,theme,bunTime,bunRyo,kanseido,kensaSyu,kensaTime,kensaComment,menNin1,menNin2,menKatati,menTime,sitsuComment,hanseiComment,kenComment,jogen from juken where juId=?";
	private String jukenKigyoSql = "select juId,syuNum,sex,name,DATE_FORMAT(teiDate, '%Y/%m/%d %H:%i:%s') teiDate,sotuDate,juken.id,kigyoName,nanji from users join juken on users.gakuseki=juken.gakuseki join kigyo on juken.id=kigyo.id where kigyo.id=?";
	private String insertSql = "insert into juken(gakuseki,id,nanji,dateFrom,dateTo,testSyu,tutiDate,toGa,ippanKamoku,ippanTime,senmonKamoku,senmonTime,sonota,sonoTime,sikenComment,theme,bunTime,bunRyo,kanseido,kensaSyu,kensaTime,kensaComment,menNin1,menNin2,menKatati,menTime,sitsuComment,hanseiComment,kenComment,jogen) value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update juken set gakuseki=?,id=?,nanji=?,dateFrom=?,dateTo=?,testSyu=?,tutiDate=?,toGa=?,ippanKamoku=?,ippanTime=?,senmonKamoku=?,senmonTime=?,sonota=?,sonoTime=?,sikenComment=?,theme=?,bunTime=?,bunRyo=?,kanseido=?,kensaSyu=?,kensaTime=?,kensaComment=?,menNin1=?,menNin2=?,menKatati=?,menTime=?,sitsuComment=?,hanseiComment=?,kenComment=?,jogen=? where juId=?";

	/*削除*/
	private String jukenDeleteSql = "delete from juken where juId=?";

	protected LoadProperty lp;
	protected String resultMsg;

	public SuperClass(){

		super("java:comp/env/jdbc/sotukenDB");
		try {
			lp = new LoadProperty("/res/msg.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultMsg = "";
	}


	public void setSelectKigyoAllSql(String selectKigyoAllSql) {
		this.selectKigyoAllSql = selectKigyoAllSql;
	}


	public void setJukenMaeSql(String jukenMaeSql) {
		this.jukenMaeSql = jukenMaeSql;
	}

	public void setJukenZenbuSql(String jukenZenbuSql) {
		this.jukenZenbuSql = jukenZenbuSql;
	}


	public void setJukenSelectSql(String jukenSelectSql) {
		this.jukenSelectSql = jukenSelectSql;
	}

	public void setJukenDeleteSql(String jukenDeleteSql) {
		this.jukenDeleteSql = jukenDeleteSql;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public ArrayList<KigyoInfo> getList() {
		return kList;
	}

	public ArrayList<JukenInfo> getJi() {
		return ji;
	}

	public ArrayList<UserInfo> getuList() {
		return uList;
	}

	public KigyoInfo getKi() {
		return ki;
	}

	public UserInfo getUi() {
		return ui;
	}

	public JukenInfo getJik() {
		return jik;
	}

	public JukenHoukokuInfo getJhi() {
		return jhi;
	}


	//企業名を全部表示
	public void kigyoDBSelect() throws Exception{

		resultMsg = "";
		ArrayList<KigyoInfo> list
		= new ArrayList<KigyoInfo>();

 		//接続
		connect();
		//ステートメント
		createStatement(selectKigyoAllSql);
		//実行
		selectExe();

		while( getRsResult().next()){
			KigyoInfo ki =
				new KigyoInfo(
					getRsResult().getInt("id"),
					getRsResult().getString("kigyoName"),
					getRsResult().getString("kigyoFuri"),
					getRsResult().getString("address")
			);

			list.add(ki);
		}
		this.kList = list;

		//DB切断
		disConnect();

		if( this.kList.size() == 0 ){
			this.resultMsg = lp.getProperty("super.kigyoDBSelect");
		}//if

	}

	//企業idから企業情報を取得、一件だけ
	public void kigyoDBSelect(int id) throws Exception{

 		//接続
		connect();
		//ステートメント
		createStatement(selectKigyoSql);
		getPstmt().setInt(1, id);
		//実行
		selectExe();

		//next()が必須
		getRsResult().next();

		KigyoInfo ki =
				new KigyoInfo(
			getRsResult().getInt("id"),
			getRsResult().getString("kigyoName"),
			getRsResult().getString("kigyoFuri"),
			getRsResult().getString("address"));

		this.ki = ki;

		//DB切断
		disConnect();

	}

	//企業ごとの受験報告表示
	public void jukenKigyoSelect(int id) throws Exception{

		resultMsg = "";
		ArrayList<JukenInfo> ji = new ArrayList<JukenInfo>();
		//接続
		connect();
		//ステートメント
		createStatement(jukenKigyoSql);
		getPstmt().setInt(1, id);

		//実行
		selectExe();
		while( getRsResult().next()){
			JukenInfo jki =
					new JukenInfo(
				getRsResult().getInt("juId"),
				getRsResult().getString("syuNum"),
				getRsResult().getString("sex"),
				getRsResult().getString("name"),
				getRsResult().getString("teiDate"),
				getRsResult().getInt("sotuDate"),
				getRsResult().getInt("juken.id"),
				getRsResult().getString("kigyoName"),
				getRsResult().getInt("nanji")
			);
			ji.add(jki);
		}

		this.ji = ji;
		//DB切断
		disConnect();

		if( this.ji.size() == 0 ){

			this.resultMsg = lp.getProperty("super.jukenKigyoSelect");
		}
	}

	//受験報告詳細をだすところ
	public void jukenSelect(int juId) throws Exception{
	 		//接続
			connect();
			//ステートメント
			createStatement(jukenSelectSql);
			getPstmt().setInt(1, juId);
			//実行
			selectExe();

			getRsResult().next();
			JukenHoukokuInfo jhi = new JukenHoukokuInfo(
				//提出者情報
				getRsResult().getInt("juId"),
				getRsResult().getString("teiDate"),
				getRsResult().getString("gakuseki"),
				getRsResult().getInt("id"),
				//何次試験
				getRsResult().getString("nanji"),
				getRsResult().getString("dateFrom"),
				getRsResult().getString("dateTo"),
				getRsResult().getString("testSyu"),
				getRsResult().getString("tutiDate"),
				getRsResult().getString("toGa"),
				//筆記試験
				getRsResult().getString("ippanKamoku"),
				getRsResult().getInt("ippanTime"),
				getRsResult().getString("senmonKamoku"),
				getRsResult().getInt("senmonTime"),
				getRsResult().getString("sonota"),
				getRsResult().getInt("sonoTime"),
				getRsResult().getString("sikenComment"),
				//作文
				getRsResult().getString("theme"),
				getRsResult().getInt("bunTime"),
				getRsResult().getInt("bunRyo"),
				getRsResult().getInt("kanseido"),
				//適性試験
				getRsResult().getString("kensaSyu"),
				getRsResult().getInt("kensaTime"),
				getRsResult().getString("kensaComment"),
				//面接試験
				getRsResult().getInt("menNin1"),
				getRsResult().getInt("menNin2"),
				getRsResult().getString("menKatati"),
				getRsResult().getInt("menTime"),
				getRsResult().getString("sitsuComment"),
				getRsResult().getString("hanseiComment"),
				//健康診断
				getRsResult().getString("kenComment"),
				//助言
				getRsResult().getString("jogen")
			);

			this.jhi = jhi;
			//DB切断
			disConnect();

			if( this.jhi == null ){
				this.resultMsg = lp.getProperty("super.jukenSelect");
			}
		}

	//ユーザー情報全部
	public void userDBSelect() throws Exception{
		ArrayList<UserInfo> uList
		= new ArrayList<UserInfo>();

 		//接続
		connect();
		//ステートメント
		createStatement(selectUserAllSql);
		//実行
		selectExe();

		while( getRsResult().next()){

			UserInfo ui =new UserInfo();
			ui.setGakuseki(getRsResult().getString("gakuseki"));
			ui.setName(getRsResult().getString("name"));

			uList.add(ui);
		}//while
		this.uList = uList;
		//DB切断
		disConnect();

		if( this.uList.size() == 0 ){
			this.resultMsg = lp.getProperty("super.userDBSelect");
		}

	}

	//ユーザー情報一件
	public void userDBSelect(String gakuseki) throws Exception{
		//接続
		connect();
		//ステートメント
		createStatement(selectUserSql);

		getPstmt().setString(1, gakuseki);
		//実行
		selectExe();

		//next()が必須
		getRsResult().next();
		UserInfo ui = new UserInfo(getRsResult().getInt("sotuDate"),getRsResult().getString("syuNum"),getRsResult().getString("name"),getRsResult().getString("sex"));

		this.ui = ui;
		//DB切断
		disConnect();

		if( this.ui == null ){
			this.resultMsg = lp.getProperty("super.userDBSelect");
		}

	}

	//報告書登録
	public void jukenHoukokuInsert(JukenHoukokuInfo jhi) throws Exception{

		String strType = "登録";
		//接続
		connect();
		//ステートメント
		createStatement(insertSql);

		//提出者情報
		getPstmt().setString(1, jhi.getGakuseki());
		getPstmt().setInt(2, jhi.getId());
		//何次試験
		getPstmt().setString(3, jhi.getNanji());
		getPstmt().setString(4, jhi.getDateFrom());
		getPstmt().setString(5,jhi.getDateTo());
		getPstmt().setString(6,jhi.getTestSyu());
		getPstmt().setString(7,jhi.getTutiDate());
		getPstmt().setString(8,jhi.getToGa());
		//筆記試験
		getPstmt().setString(9,jhi.getIppanKamoku());
		getPstmt().setInt(10,jhi.getIppanTime());
		getPstmt().setString(11,jhi.getSenmonKamoku());
		getPstmt().setInt(12,jhi.getSenmonTime());
		getPstmt().setString(13,jhi.getSonota());
		getPstmt().setInt(14,jhi.getSonoTime());
		getPstmt().setString(15,jhi.getSikenComment());
		//作文
		getPstmt().setString(16,jhi.getTheme());
		getPstmt().setInt(17,jhi.getBunTime());
		getPstmt().setInt(18,jhi.getBunRyo());
		getPstmt().setInt(19,jhi.getKanseido());
		//適性試験
		getPstmt().setString(20,jhi.getKensaSyu());
		getPstmt().setInt(21,jhi.getKensaTime());
		getPstmt().setString(22,jhi.getKensaComment());
		//面接試験
		getPstmt().setInt(23,jhi.getMenNin1());
		getPstmt().setInt(24,jhi.getMenNin2());
		getPstmt().setString(25,jhi.getMenKatati());
		getPstmt().setInt(26,jhi.getMenTime());
		getPstmt().setString(27,jhi.getSitsuComment());
		getPstmt().setString(28,jhi.getHanseiComment());
		//健康診断
		getPstmt().setString(29,jhi.getKenComment());
		//助言
		getPstmt().setString(30,jhi.getJogen());

		//実行
		updateExe();

		//DB切断
		disConnect();

		//メッセージ設定
				if( getIntResult() > 0){
					this.resultMsg =strType +"しました";
				}else{
					this.resultMsg = strType +"できませんでした";
				}
	}

	//報告書更新
	public void jukenHoukokuUpdate(JukenHoukokuInfo jhi) throws Exception{

		String strType="更新";

		//接続
		connect();
		//ステートメント
		createStatement(updateSql);

		//提出者情報
		getPstmt().setString(1, jhi.getGakuseki());
		getPstmt().setInt(2, jhi.getId());
		//何次試験
		getPstmt().setString(3, jhi.getNanji());
		getPstmt().setString(4, jhi.getDateFrom());
		getPstmt().setString(5,jhi.getDateTo());
		getPstmt().setString(6,jhi.getTestSyu());
		getPstmt().setString(7,jhi.getTutiDate());
		getPstmt().setString(8,jhi.getToGa());
		//筆記試験
		getPstmt().setString(9,jhi.getIppanKamoku());
		getPstmt().setInt(10,jhi.getIppanTime());
		getPstmt().setString(11,jhi.getSenmonKamoku());
		getPstmt().setInt(12,jhi.getSenmonTime());
		getPstmt().setString(13,jhi.getSonota());
		getPstmt().setInt(14,jhi.getSonoTime());
		getPstmt().setString(15,jhi.getSikenComment());
		//作文
		getPstmt().setString(16,jhi.getTheme());
		getPstmt().setInt(17,jhi.getBunTime());
		getPstmt().setInt(18,jhi.getBunRyo());
		getPstmt().setInt(19,jhi.getKanseido());
		//適性試験
		getPstmt().setString(20,jhi.getKensaSyu());
		getPstmt().setInt(21,jhi.getKensaTime());
		getPstmt().setString(22,jhi.getKensaComment());
		//面接試験
		getPstmt().setInt(23,jhi.getMenNin1());
		getPstmt().setInt(24,jhi.getMenNin2());
		getPstmt().setString(25,jhi.getMenKatati());
		getPstmt().setInt(26,jhi.getMenTime());
		getPstmt().setString(27,jhi.getSitsuComment());
		getPstmt().setString(28,jhi.getHanseiComment());
		//健康診断
		getPstmt().setString(29,jhi.getKenComment());
		//助言
		getPstmt().setString(30,jhi.getJogen());

		getPstmt().setInt(31,jhi.getJuId());

		//実行
		updateExe();

		//DB切断
		disConnect();


		//メッセージ設定
		if( getIntResult() > 0){
			this.resultMsg =strType +"しました";
		}else{
			this.resultMsg = strType +"できませんでした";
		}
	}

	//報告書削除
	public void jukenDelete(int juId) throws Exception{

		String strType = "削除";
		resultMsg = "";

 		//接続
		connect();
		//ステートメント
		createStatement(jukenDeleteSql);
		getPstmt().setInt(1, juId);

		//実行
		updateExe();

		//DB切断
		disConnect();

		//メッセージ設定
				if( getIntResult() > 0){
					this.resultMsg =strType +"しました";
				}else{
					this.resultMsg = strType +"できませんでした";
				}
	}

	//検索
	public void jukenKensakuDBSelect(String ken,int kensaku) throws Exception{

		resultMsg = "";
		ArrayList<KigyoInfo> list = new ArrayList<KigyoInfo>();
		this.kList = null;
 		//接続
		connect();
		//ステートメント
		switch(kensaku){
			case 1:
				createStatement(jukenMaeSql);
				getPstmt().setString(1, "%" + ken + "%");
				break;

			case 2:
				createStatement(jukenZenbuSql);
				getPstmt().setString(1,ken);
				break;
		}

		//実行
		selectExe();
		while( getRsResult().next()){
			KigyoInfo jki =
					new KigyoInfo(
							getRsResult().getInt("id"),
							getRsResult().getString("kigyoName"),
							getRsResult().getString("kigyoFuri"),
							getRsResult().getString("address")
						);
			list.add(jki);
		}

		this.kList = list;
		//DB切断
		disConnect();

		if(kList.size() == 0){

			this.resultMsg = lp.getProperty("super.jukenKensakuDBSelect");

		}

	}
}

