package juken;

public class JukenHoukokuInfo {

	private int juId;
	private String teiDate;
	private String gakuseki;
	private int id;

	//何次試験その他
	private String nanji;
	private String dateFrom;
	private String dateTo;
	private String testSyu;
	private String tutiDate;
	private String toGa;

	//筆記試験
	private String ippanKamoku;
	private int ippanTime;
	private String senmonKamoku;
	private int senmonTime;
	private String sonota;
	private int sonoTime;
	private String sikenComment;

	//作文
	private String theme;
	private int bunTime;
	private int bunRyo;
	private int kanseido;

	//適正試験
	private String kensaSyu;
	private int kensaTime;
	private String kensaComment;

	//面接試験
	private int menNin1;
	private int menNin2;
	private String menKatati;
	private int menTime;
	private String sitsuComment;
	private String hanseiComment;

	//健康診断
	private String kenComment;

	//助言
	private String jogen;

	public JukenHoukokuInfo(){}

	public JukenHoukokuInfo(int juId, String teiDate, String gakuseki, int id,
			String nanji, String dateFrom, String dateTo, String testSyu,
			String tutiDate, String toGa, String ippanKamoku, int ippanTime,
			String senmonKamoku, int senmonTime, String sonota,int sonoTime,
			String sikenComment, String theme, int bunTime, int bunRyo,
			int kanseido, String kensaSyu, int kensaTime, String kensaComment,
			int menNin1, int menNin2, String menKatati, int menTime,
			String sitsuComment, String hanseiComment, String kenComment,
			String jogen) {
		this.juId = juId;
		this.teiDate = teiDate;
		this.gakuseki = gakuseki;
		this.id = id;
		this.nanji = nanji;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.testSyu = testSyu;
		this.tutiDate = tutiDate;
		this.toGa = toGa;
		this.ippanKamoku = ippanKamoku;
		this.ippanTime = ippanTime;
		this.senmonKamoku = senmonKamoku;
		this.senmonTime = senmonTime;
		this.sonota = sonota;
		this.sonoTime = sonoTime;
		this.sikenComment = sikenComment;
		this.theme = theme;
		this.bunTime = bunTime;
		this.bunRyo = bunRyo;
		this.kanseido = kanseido;
		this.kensaSyu = kensaSyu;
		this.kensaTime = kensaTime;
		this.kensaComment = kensaComment;
		this.menNin1 = menNin1;
		this.menNin2 = menNin2;
		this.menKatati = menKatati;
		this.menTime = menTime;
		this.sitsuComment = sitsuComment;
		this.hanseiComment = hanseiComment;
		this.kenComment = kenComment;
		this.jogen = jogen;
	}

	public int getJuId() {
		return juId;
	}

	public void setJuId(int juId) {
		this.juId = juId;
	}

	public String getTeiDate() {
		return teiDate;
	}

	public void setTeiDate(String teiDate) {
		this.teiDate = teiDate;
	}

	public String getGakuseki() {
		return gakuseki;
	}

	public void setGakuseki(String gakuseki) {
		this.gakuseki = gakuseki;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNanji() {
		return nanji;
	}

	public void setNanji(String nanji) {
		this.nanji = nanji;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getTestSyu() {
		return testSyu;
	}

	public void setTestSyu(String testSyu) {
		this.testSyu = testSyu;
	}

	public String getTutiDate() {
		return tutiDate;
	}

	public void setTutiDate(String tutiDate) {
		this.tutiDate = tutiDate;
	}

	public String getToGa() {
		return toGa;
	}

	public void setToGa(String toGa) {
		this.toGa = toGa;
	}

	public String getIppanKamoku() {
		return ippanKamoku;
	}

	public void setIppanKamoku(String ippanKamoku) {
		this.ippanKamoku = ippanKamoku;
	}

	public int getIppanTime() {
		return ippanTime;
	}

	public void setIppanTime(int ippanTime) {
		this.ippanTime = ippanTime;
	}

	public String getSenmonKamoku() {
		return senmonKamoku;
	}

	public void setSenmonKamoku(String senmonKamoku) {
		this.senmonKamoku = senmonKamoku;
	}

	public int getSenmonTime() {
		return senmonTime;
	}

	public void setSenmonTime(int senmonTime) {
		this.senmonTime = senmonTime;
	}

	public String getSonota() {
		return sonota;
	}

	public void setSonota(String sonota) {
		this.sonota = sonota;
	}

	public int getSonoTime() {
		return sonoTime;
	}

	public void setSonoTime(int sonoTime) {
		this.sonoTime = sonoTime;
	}

	public String getSikenComment() {
		return sikenComment;
	}

	public void setSikenComment(String sikenComment) {
		this.sikenComment = sikenComment;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getBunTime() {
		return bunTime;
	}

	public void setBunTime(int bunTime) {
		this.bunTime = bunTime;
	}

	public int getBunRyo() {
		return bunRyo;
	}

	public void setBunRyo(int bunRyo) {
		this.bunRyo = bunRyo;
	}

	public int getKanseido() {
		return kanseido;
	}

	public void setKanseido(int kanseido) {
		this.kanseido = kanseido;
	}

	public String getKensaSyu() {
		return kensaSyu;
	}

	public void setKensaSyu(String kensaSyu) {
		this.kensaSyu = kensaSyu;
	}

	public int getKensaTime() {
		return kensaTime;
	}

	public void setKensaTime(int kensaTime) {
		this.kensaTime = kensaTime;
	}

	public String getKensaComment() {
		return kensaComment;
	}

	public void setKensaComment(String kensaComment) {
		this.kensaComment = kensaComment;
	}

	public int getMenNin1() {
		return menNin1;
	}

	public void setMenNin1(int menNin1) {
		this.menNin1 = menNin1;
	}

	public int getMenNin2() {
		return menNin2;
	}

	public void setMenNin2(int menNin2) {
		this.menNin2 = menNin2;
	}

	public String getMenKatati() {
		return menKatati;
	}

	public void setMenKatati(String menKatati) {
		this.menKatati = menKatati;
	}

	public int getMenTime() {
		return menTime;
	}

	public void setMenTime(int menTime) {
		this.menTime = menTime;
	}

	public String getSitsuComment() {
		return sitsuComment;
	}

	public void setSitsuComment(String sitsuComment) {
		this.sitsuComment = sitsuComment;
	}

	public String getHanseiComment() {
		return hanseiComment;
	}

	public void setHanseiComment(String hanseiComment) {
		this.hanseiComment = hanseiComment;
	}

	public String getKenComment() {
		return kenComment;
	}

	public void setKenComment(String kenComment) {
		this.kenComment = kenComment;
	}

	public String getJogen() {
		return jogen;
	}

	public void setJogen(String jogen) {
		this.jogen = jogen;
	}

	@Override
	public String toString() {
		return "JukenHoukokuInfo [juId=" + juId + ", teiDate=" + teiDate
				+ ", gakuseki=" + gakuseki + ", id=" + id + ", nanji=" + nanji
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
				+ ", testSyu=" + testSyu + ", tutiDate=" + tutiDate + ", toGa="
				+ toGa + ", ippanKamoku=" + ippanKamoku + ", ippanTime="
				+ ippanTime + ", senmonKamoku=" + senmonKamoku
				+ ", senmonTime=" + senmonTime + ", sonota=" + sonota
				+ ", sonoTime=" + sonoTime + ", sikenComment=" + sikenComment
				+ ", theme=" + theme + ", bunTime=" + bunTime + ", bunRyo="
				+ bunRyo + ", kanseido=" + kanseido + ", kensaSyu=" + kensaSyu
				+ ", kensaTime=" + kensaTime + ", kensaComment=" + kensaComment
				+ ", menNin1=" + menNin1 + ", menNin2=" + menNin2
				+ ", menKatati=" + menKatati + ", menTime=" + menTime
				+ ", sitsuComment=" + sitsuComment + ", hanseiComment="
				+ hanseiComment + ", kenComment=" + kenComment + ", jogen="
				+ jogen + "]";
	}



}
