package Entity;

import java.util.Date;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String chungMinhNhanDan;
	private String diaChi;
	private String soDienThoai;
	private Date ngaySinh;
	private boolean gioiTinh;
	private BigDecimal tienLuong;
	private CaLam caLam;
	
	

	public NhanVien() {

	}
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String chungMinhNhanDan, String diaChi, String soDienThoai,
			Date ngaySinh, boolean gioiTinh, BigDecimal tienLuong, CaLam caLam) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.chungMinhNhanDan = chungMinhNhanDan;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.tienLuong = tienLuong;
		this.caLam = caLam;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getChungMinhNhanDan() {
		return chungMinhNhanDan;
	}

	public void setChungMinhNhanDan(String chungMinhNhanDan) {
		this.chungMinhNhanDan = chungMinhNhanDan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public BigDecimal getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(BigDecimal tienLuong) {
		this.tienLuong = tienLuong;
	}

	public CaLam getCaLam() {
		return caLam;
	}

	public void setCaLam(CaLam caLam) {
		this.caLam = caLam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", chungMinhNhanDan="
				+ chungMinhNhanDan + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", tienLuong=" + tienLuong + ", caLam=" + caLam + "]";
	}
	
	
	
	}