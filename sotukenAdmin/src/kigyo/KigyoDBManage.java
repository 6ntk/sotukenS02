package kigyo;

import java.util.ArrayList;

import juken.JukenInfo;
import kyotu.SuperClass;

public class KigyoDBManage extends SuperClass{

	/*企業編集更新*/
	private String kigyoUpdateSql = "update kigyo set kigyoName=?,kigyoFuri=?,address=? where id=?";
	/*企業登録*/
	private String insertKigyoSql = "insert into kigyo(kigyoName,kigyoFuri,address) value (?,?,?)";
	/*企業登録*/
	private String deleteKigyoSql = "delete from kigyo where id=?";

	private String jukenKigyoAllSql = "select juId,syuNum,sex,name,DATE_FORMAT(teiDate, '%Y/%m/%d %H:%i:%s') teiDate,sotuDate,juken.id,kigyoName,nanji from users join juken on users.gakuseki=juken.gakuseki join kigyo on juken.id=kigyo.id order by teiDate desc limit 30";


	public KigyoDBManage() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	//企業登録
	public void kigyoTouroku(KigyoInfo ki) throws Exception{

		String strType="企業を登録";
		this.resultMsg ="";

		//接続
		connect();
		//ステートメント
		createStatement(insertKigyoSql);
		getPstmt().setString(1, ki.getKigyoName());
		getPstmt().setString(2, ki.getKigyoFuri());
		getPstmt().setString(3, ki.getAddress());
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

	//企業編集
	public void kigyoDBUpdate(KigyoInfo ki) throws Exception{

		String strType="企業を更新";
		this.resultMsg ="";
		//接続
		connect();
		//ステートメント
		createStatement(kigyoUpdateSql);
		getPstmt().setString(1, ki.getKigyoName());
		getPstmt().setString(2, ki.getKigyoFuri());
		getPstmt().setString(3, ki.getAddress());
		getPstmt().setInt(4, ki.getId());

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

	//企業削除
	public void kigyoDBDelete(int id) throws Exception{

		String strType="企業を削除";
		this.resultMsg ="";

		//接続
		connect();
		//ステートメント
		createStatement(deleteKigyoSql);
		getPstmt().setInt(1, id);
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

	//受験報告全部
	public void jukenKigyoAllSelect() throws Exception{

		resultMsg = "";
		ArrayList<JukenInfo> ji = new ArrayList<JukenInfo>();
		//接続
		connect();
		//ステートメント
		createStatement(jukenKigyoAllSql);

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
