package temp;

import java.util.ArrayList;

import juken.JukenInfo;
import kyotu.SuperClass;

public class TempDBManage extends SuperClass{

	private String jukenDeleteSql = "delete from temp where juId=?";
	private String jukenSelectSql = "select juId,DATE_FORMAT(teiDate, '%Y/%m/%d %H:%i:%s') teiDate,gakuseki,id,nanji,DATE_FORMAT(dateFrom, '%Y/%m/%d %H:%i') dateFrom,DATE_FORMAT(dateTo, '%Y/%m/%d %H:%i') dateTo,testSyu,DATE_FORMAT(tutiDate, '%Y/%m/%d %H:%i') tutiDate,toGa,ippanKamoku,ippanTime,senmonKamoku,senmonTime,sonota,sonoTime,sikenComment,theme,bunTime,bunRyo,kanseido,kensaSyu,kensaTime,kensaComment,menNin1,menNin2,menKatati,menTime,sitsuComment,hanseiComment,kenComment,jogen from temp where juId=?";
	private String jukenAllSql = "select juId,syuNum,sex,name,DATE_FORMAT(teiDate, '%Y/%m/%d %H:%i:%s') teiDate,sotuDate,temp.id,kigyoName,nanji from users join temp on users.gakuseki=temp.gakuseki join kigyo on temp.id=kigyo.id";
	private String selectKigyoAllSql ="select * from kigyo";
	private String jukenMaeSql = "select * from kigyo where kigyoName like ?";
	private String jukenZenbuSql = "select * from kigyo where kigyoName=?";
	private String insertSql = "insert into temp(gakuseki,id,nanji,dateFrom,dateTo,testSyu,tutiDate,toGa,ippanKamoku,ippanTime,senmonKamoku,senmonTime,sonota,sonoTime,sikenComment,theme,bunTime,bunRyo,kanseido,kensaSyu,kensaTime,kensaComment,menNin1,menNin2,menKatati,menTime,sitsuComment,hanseiComment,kenComment,jogen) value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String selectUserAllSql	= "select distinct users.gakuseki,users.syuNum,users.sex,users.name from temp join users on users.gakuseki=temp.gakuseki";
	private String jukenKigyoSql = "select juId,syuNum,sex,name,DATE_FORMAT(teiDate, '%Y/%m/%d %H:%i:%s') teiDate,sotuDate,temp.id,kigyoName,nanji from users join temp on users.gakuseki=temp.gakuseki join kigyo on temp.id=kigyo.id where users.gakuseki=?";

	public TempDBManage() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
		setJukenDeleteSql(jukenDeleteSql);
		setJukenSelectSql(jukenSelectSql);
		setSelectKigyoAllSql(selectKigyoAllSql);
		setJukenMaeSql(jukenMaeSql);
		setJukenZenbuSql(jukenZenbuSql);
		setInsertSql(insertSql);
		setSelectUserAllSql(selectUserAllSql);

	}

	//企業ごとの受験報告表示
		public void jukenKigyoSelect(int gakuseki) throws Exception{

			resultMsg = "";
			ArrayList<JukenInfo> ji = new ArrayList<JukenInfo>();
			//接続
			connect();
			//ステートメント
			createStatement(jukenKigyoSql);
			getPstmt().setInt(1, gakuseki);

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
					getRsResult().getInt("temp.id"),
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
}

