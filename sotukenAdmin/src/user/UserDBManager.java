package user;

import db.DBAccess;

public class UserDBManager extends DBAccess {

	public final static int USER_ADMIN = 0;
	public final static int USER_STUDENT = 1;

	private String userSearchSql=
			"select gakuseki,syuNum, name, sex,passwd from users where gakuseki=? and passwd=?";
	private String userSearchAdminSql=
			"select gakuseki,syuNum, name, sex,passwd from admin_users where gakuseki=? and passwd=?";


	public UserDBManager() {
		//super("java:comp/env/jdbc/sotuken");
		//super("java:comp/env/jdbc/MySqlCon");
		super("java:comp/env/jdbc/sotukenDB");

		// TODO 自動生成されたコンストラクター・スタブ
	}

	public UserInfo userDBSearch( UserInfo user, int searchType) throws Exception{
		UserInfo userInfo = null ;
		connect();
		if( searchType == USER_ADMIN){
			createStatement(userSearchAdminSql);
			getPstmt().setString(1, user.getGakuseki());
			getPstmt().setString(2, user.getPasswd());
		}

		if( searchType == USER_STUDENT){
			createStatement(userSearchSql);
			getPstmt().setString(1, user.getGakuseki());
			getPstmt().setString(2, user.getPasswd());
		}
		//SQL実行
		selectExe();
		if( getRsResult().next()){
			userInfo = new UserInfo();
			userInfo.setGakuseki(getRsResult().getString("gakuseki"));
			userInfo.setPasswd(getRsResult().getString("passwd"));
			userInfo.setName(getRsResult().getString("name"));
		}
		//DB切断
		disConnect();
		return userInfo;
	}



}
