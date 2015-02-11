package student;

import java.util.ArrayList;

import juken.JukenInfo;
import kyotu.SuperClass;

public class StudentDBManage extends SuperClass{

	private String selectKigyoAllSql ="select * from kigyo";
	private String jukenKigyoAllSql = "select juId,syuNum,sex,name,DATE_FORMAT(teiDate, '%Y/%m/%d %H:%i:%s') teiDate,sotuDate,juken.id,kigyoName,nanji from users join juken on users.gakuseki=juken.gakuseki join kigyo on juken.id=kigyo.id where users.gakuseki=? order by teiDate desc limit 30";


	public StudentDBManage() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
		setSelectKigyoAllSql(selectKigyoAllSql);
	}

	//受験報告全部
	public void jukenKigyoAllSelect(int gakuseki) throws Exception{

		resultMsg = "";
		ArrayList<JukenInfo> ji = new ArrayList<JukenInfo>();
		//接続
		connect();
		//ステートメント
		createStatement(jukenKigyoAllSql);

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

}

