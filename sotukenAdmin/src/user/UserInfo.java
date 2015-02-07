package user;

public class UserInfo {
	private int sotuDate;
	private String gakuseki;
	private String syuNum;
	private String name;
	private String sex;
	private String passwd;

	public UserInfo() {

	}
	public UserInfo(String gakuseki, String passwd) {
		super();
		this.gakuseki = gakuseki;
		this.passwd = passwd;
	}

	public UserInfo(int sotuDate,String syuNum, String name, String sex) {
		super();
		this.sotuDate = sotuDate;
		this.syuNum = syuNum;
		this.name = name;
		this.sex = sex;
	}

	public String getGakuseki() {
		return gakuseki;
	}

	public void setGakuseki(String gakuseki) {
		this.gakuseki = gakuseki;
	}

	public String getSyuNum() {
		return syuNum;
	}

	public void setSyuNum(String syuNum) {
		this.syuNum = syuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getSotuDate() {
		return sotuDate;
	}
	public void setSotuDate(int sotuDate) {
		this.sotuDate = sotuDate;
	}
	@Override
	public String toString() {
		return "UserInfo [sotuDate=" + sotuDate + ", gakuseki=" + gakuseki
				+ ", syuNum=" + syuNum + ", name=" + name + ", sex=" + sex
				+ ", passwd=" + passwd + "]";
	}





}