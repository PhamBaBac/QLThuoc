package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ConnectDB.ConnectDB;
import Entity.CaLam;
import Entity.NhanVien;

public class NhanVien_DAO {
	public  ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String cMND= rs.getString(3);
				String diaChi  = rs.getString(4);
				String soDT  = rs.getString(5);
				Date ngaySinh = rs.getDate(6);
				boolean gioiTinh = rs.getBoolean(7);
				BigDecimal luong = rs.getBigDecimal(8);
				CaLam caL = new CaLam(cMND, tenNV, diaChi, soDT);
				NhanVien nv = new NhanVien(maNV, tenNV, cMND, diaChi, soDT, ngaySinh, gioiTinh, luong, caL);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public boolean craete(NhanVien nv) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps =null;
		int n =0;
		try {
		
			ps = con.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, nv.getMaNhanVien());
			ps.setString(2, nv.getTenNhanVien());
			ps.setString(3, nv.getChungMinhNhanDan());
			ps.setString(4, nv.getDiaChi());
			ps.setString(5, nv.getSoDienThoai());
			ps.setDate(6, nv.getNgaySinh());
			ps.setBoolean(7, nv.isGioiTinh());
			ps.setBigDecimal(8, nv.getTienLuong());
			ps.setString(9,nv.getCaLam().getMaCaLam());
			n = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return n>0;

	}
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps =null;
		int n =0;
		try {
		
			 ps = con.prepareStatement("update NhanVien set tenNhanVien = ?"
			 		+ "chungMinhNhanDan=?, diaChi=?, soDienThoai=?"
			 		+ "ngaySinh=?,gioiTinh=?,tienLuong=?,caLam=?"
			 		+ "where maNhanVien=?");
		
			ps.setString(1, nv.getTenNhanVien());
			ps.setString(2, nv.getChungMinhNhanDan());
			ps.setString(3, nv.getDiaChi());
			ps.setString(4, nv.getSoDienThoai());
			ps.setDate(5, nv.getNgaySinh());
			ps.setBoolean(6, nv.isGioiTinh());
			ps.setBigDecimal(7, nv.getTienLuong());
			ps.setString(8,nv.getCaLam().getMaCaLam());
			ps.setString(9, nv.getMaNhanVien());
			n = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return n>0;
		
	}
}
