package juken;

import java.io.Serializable;

public class JukenInfo implements Serializable {

	private int juId;
	private String syuNum;
	private String sex;
	private String name;
	private String teiDate;
	private int sotuDate;
	private int id;
	private String kigyoName;
	private int nanji;
	private int gakuseki;

	public JukenInfo() {}

	public JukenInfo(int juId, String syuNum, String sex, String name,
			String teiDate,int sotuDate, int id, String kigyoName,int nanji,int gakuseki) {
		super();
		this.juId = juId;
		this.syuNum = syuNum;
		this.sex = sex;
		this.name = name;
		this.teiDate = teiDate;
		this.sotuDate = sotuDate;
		this.id = id;
		this.kigyoName = kigyoName;
		this.nanji = nanji;
		this.gakuseki = gakuseki;
	}

	public JukenInfo(int juId, String syuNum, String sex, String name,
			String teiDate,int sotuDate, int id, String kigyoName,int nanji) {
		super();
		this.juId = juId;
		this.syuNum = syuNum;
		this.sex = sex;
		this.name = name;
		this.teiDate = teiDate;
		this.sotuDate = sotuDate;
		this.id = id;
		this.kigyoName = kigyoName;
		this.nanji = nanji;
	}

	public int getJuId() {
		return juId;
	}

	public void setJuId(int juId) {
		this.juId = juId;
	}

	public int getSotuDate() {
		return sotuDate;
	}

	public void setSotuDate(int sotuDate) {
		this.sotuDate = sotuDate;
	}

	public String getSyuNum() {
		return syuNum;
	}

	public void setSyuNum(String syuNum) {
		this.syuNum = syuNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeiDate() {
		return teiDate;
	}

	public void setTeiDate(String teiDate) {
		this.teiDate = teiDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKigyoName() {
		return kigyoName;
	}

	public void setKigyoName(String kigyoName) {
		this.kigyoName = kigyoName;
	}

	public int getNanji() {
		return nanji;
	}

	public void setNanji(int nanji) {
		this.nanji = nanji;
	}

	public int getGakuseki() {
		return gakuseki;
	}

	public void setGakuseki(int gakuseki) {
		this.gakuseki = gakuseki;
	}

	@Override
	public String toString() {
		return "JukenInfo [juId=" + juId + ", syuNum=" + syuNum + ", sex="
				+ sex + ", name=" + name + ", updateDate=" + teiDate
				+ ", sotuDate=" + sotuDate + ", id=" + id + ", kigyoName="
				+ kigyoName + ", nanji=" + nanji + ", gakuseki=" + gakuseki
				+ "]";
	}






}
