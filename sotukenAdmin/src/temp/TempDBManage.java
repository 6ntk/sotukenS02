package temp;

import java.util.ArrayList;

import juken.JukenInfo;
import kyotu.SuperClass;
import tools.LoadProperty;

public class TempDBManage extends SuperClass{

	private String jukenDeleteSql = "delete from temp where juId=?";
	private String jukenSelectSql = "select * from temp where juId=?";
	private String jukenAllSql = "select juId,syuNum,sex,name,DATE_FORMAT(teiDate, '%Y/%m/%d %H:%i:%s') teiDate,sotuDate,temp.id,kigyoName,nanji from users join temp on users.gakuseki=temp.gakuseki join kigyo on temp.id=kigyo.id";
	private String selectKigyoAllSql ="select * from kigyo";
	private String jukenMaeSql = "select * from kigyo where kigyoName like ?";
	private String jukenZenbuSql = "select * from kigyo where kigyoName=?";

	private ArrayList<JukenInfo> ji;
	private String resultMsg;
	private LoadProperty lp;

	public TempDBManage() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
		setJukenDeleteSql(jukenDeleteSql);
		setJukenSelectSql(jukenSelectSql);
		setSelectKigyoAllSql(selectKigyoAllSql);
		setJukenMaeSql(jukenMaeSql);
		setJukenZenbuSql(jukenZenbuSql);

	}

	public String getResultMsg() {
		return resultMsg;
	}

	//全ての受験報告表示
	public void jukenAllSelect() throws Exception{
			ArrayList<JukenInfo> ji = new ArrayList<JukenInfo>();
			//接続
			connect();
			//ステートメント
			createStatement(jukenAllSql);
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

			if( this.ji == null ){
				this.resultMsg = lp.getProperty("super.jukenAllSelect");

			}
		}
}

