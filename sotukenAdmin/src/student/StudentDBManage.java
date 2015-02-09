package student;

import kyotu.SuperClass;

public class StudentDBManage extends SuperClass{

	private String selectKigyoAllSql ="select * from kigyo";

	public StudentDBManage() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
		setSelectKigyoAllSql(selectKigyoAllSql);
	}



}

