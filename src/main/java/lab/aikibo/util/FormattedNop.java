package lab.aikibo.util;

public class FormattedNop {
	
	private String kdPropinsi;
	private String kdDati2;
	private String kdKecamatan;
	private String kdKelurahan;
	private String kdBlok;
	private String noUrut;
	private String kdJnsOp;
	
	public FormattedNop(String formattedNop) {
		setFormattedNop(formattedNop);
	}
	
	public void setFormattedNop(String formattedNop) {
		setKdPropinsi(formattedNop.substring(0,2));
		setKdDati2(formattedNop.substring(3,5));
		setKdKecamatan(formattedNop.substring(6,9));
		setKdKelurahan(formattedNop.substring(10,13));
		setKdBlok(formattedNop.substring(14,17));
		setNoUrut(formattedNop.substring(18,22));
		setKdJnsOp(formattedNop.substring(23,24));
	}

	public String getKdPropinsi() {
		return kdPropinsi;
	}

	public void setKdPropinsi(String kdPropinsi) {
		this.kdPropinsi = kdPropinsi;
	}

	public String getKdDati2() {
		return kdDati2;
	}

	public void setKdDati2(String kdDati2) {
		this.kdDati2 = kdDati2;
	}

	public String getKdKecamatan() {
		return kdKecamatan;
	}

	public void setKdKecamatan(String kdKecamatan) {
		this.kdKecamatan = kdKecamatan;
	}

	public String getKdKelurahan() {
		return kdKelurahan;
	}

	public void setKdKelurahan(String kdKelurahan) {
		this.kdKelurahan = kdKelurahan;
	}

	public String getKdBlok() {
		return kdBlok;
	}

	public void setKdBlok(String kdBlok) {
		this.kdBlok = kdBlok;
	}

	public String getNoUrut() {
		return noUrut;
	}

	public void setNoUrut(String noUrut) {
		this.noUrut = noUrut;
	}

	public String getKdJnsOp() {
		return kdJnsOp;
	}

	public void setKdJnsOp(String kdJnsOp) {
		this.kdJnsOp = kdJnsOp;
	}
	
}
