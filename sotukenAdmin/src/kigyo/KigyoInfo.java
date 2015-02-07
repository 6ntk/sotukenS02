package kigyo;

import java.io.Serializable;

public class KigyoInfo implements Serializable {
	private int id;
	private String kigyoName;
	private String kigyoFuri;
	private String address;

	public KigyoInfo() {}

	public KigyoInfo(int id, String kigyoName, String kigyoFuri, String address) {
		super();
		this.id = id;
		this.kigyoName = kigyoName;
		this.kigyoFuri = kigyoFuri;
		this.address = address;
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

	public String getKigyoFuri() {
		return kigyoFuri;
	}

	public void setKigyoFuri(String kigyoFuri) {
		this.kigyoFuri = kigyoFuri;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "KigyoInfo [id=" + id + ", kigyoName=" + kigyoName
				+ ", kigyoFuri=" + kigyoFuri + ", address=" + address + "]";
	}


}
