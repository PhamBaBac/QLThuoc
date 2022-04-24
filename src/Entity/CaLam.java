package Entity;

import java.util.Objects;

public class CaLam {
	private String maCaLam;
	private String tenCaLam;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	
	public CaLam(String maCaLam, String tenCaLam, String thoiGianBatDau, String thoiGianKetThuc) {
		super();
		this.maCaLam = maCaLam;
		this.tenCaLam = tenCaLam;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public CaLam(String maCaLam) {
		super();
		this.maCaLam = maCaLam;
	}

	public CaLam() {
	
	}

	public String getMaCaLam() {
		return maCaLam;
	}

	public void setMaCaLam(String maCaLam) {
		this.maCaLam = maCaLam;
	}

	public String getTenCaLam() {
		return tenCaLam;
	}

	public void setTenCaLam(String tenCaLam) {
		this.tenCaLam = tenCaLam;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCaLam);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaLam other = (CaLam) obj;
		return Objects.equals(maCaLam, other.maCaLam);
	}

	@Override
	public String toString() {
		return "CaLam [maCaLam=" + maCaLam + ", tenCaLam=" + tenCaLam + ", thoiGianBatDau=" + thoiGianBatDau
				+ ", thoiGianKetThuc=" + thoiGianKetThuc + "]";
	}
	
	
}
