package Gui_QLNhanVien;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Entity.CaLam;
import Entity.NhanVien;
import ConnectDB.ConnectDB;
import dao.CaLam_Dao;
import dao.NhanVien_DAO;
public class FrmNhanVien extends JFrame implements ActionListener{
	private JTextField txtMaNV;
	private JTextField txtTen;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtNgaySinh;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnSua;
	private JButton btnXoa;
	private DefaultTableModel dataModel;
	private JTable table;
	private JButton btnTimKiem;
	private JTextField lblTimKiem;
	private JTextField txtTimKiem;
	private JComboBox cbCaLam;
	private NhanVien_DAO NhanVien;
	private JLabel lblMauTin;
	private int mauTinHienHanh;
	private int tongSoMauTin;
	private JCheckBox ckGioiTinh;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JTextField txtTienLuong;
	
	private NhanVien_DAO nv_dao;
	private CaLam_Dao cl_dao;

	public FrmNhanVien() {
		// TODO Auto-generated constructor stub
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nv_dao = new NhanVien_DAO();
		cl_dao = new CaLam_Dao();

		setTitle("Thông tin nhan vien");
		setSize(1400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnNorth = new JPanel();
		JPanel pnQLNV = new JPanel();
		JLabel lblQLNV;
		pnQLNV.add(lblQLNV = new JLabel("QUẢN LÝ NHÂN VIÊN", JLabel.CENTER));
		lblQLNV.setFont(new Font("Arial", Font.BOLD, 26));
		pnNorth.add(pnQLNV);
		add(pnNorth, BorderLayout.NORTH);

		JPanel pnWest = new JPanel(new GridLayout(16,0));
		add(pnWest, BorderLayout.WEST);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe;
		pnTieuDe.add(lblTieuDe = new JLabel("Thông tin nhân viên", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 18));
		pnWest.add(lblTieuDe);
		
		JPanel pnMaNV = new JPanel();
		JLabel lblMaNV;
		pnMaNV.add(lblMaNV = new JLabel("Mã nhân viên"));
		pnMaNV.add(txtMaNV = new JTextField(11));
		pnWest.add(pnMaNV);
		
		JPanel pnTen = new JPanel();
		JLabel lblTen;
		pnTen.add(lblTen = new JLabel("Tên"));
		pnTen.add(txtTen = new JTextField(11));
		pnWest.add(pnTen);
		
		JPanel pnCMND= new JPanel();
		JLabel lblCMND;
		pnCMND.add(lblCMND = new JLabel("Chứng minh nhân dân"));
		pnCMND.add(txtCMND = new JTextField(11));
		pnWest.add(pnCMND);
		
		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi;
		pnDiaChi.add(lblDiaChi = new JLabel("Địa chỉ"));
		pnDiaChi.add(txtDiaChi = new JTextField(11));
		pnWest.add(pnDiaChi);
		
		JPanel pnSDT = new JPanel();
		JLabel lblSDT;
		pnSDT.add(lblSDT= new JLabel("Số điên thoại"));
		pnSDT.add(txtSDT = new JTextField(11));
		pnWest.add(pnSDT);
		
		JPanel pnNgaySinh = new JPanel();
		JLabel lblNgaySinh;
		pnNgaySinh.add(lblNgaySinh= new JLabel("Ngày sinh"));
		pnNgaySinh.add(txtNgaySinh = new JTextField(11));
		pnWest.add(pnNgaySinh);
		
		JPanel pnGioiTinh = new JPanel();
		JLabel lblGioiTinh;
		pnGioiTinh.add(lblGioiTinh = new JLabel("Giới tính"));
		pnGioiTinh.add(radNam = new JRadioButton("Nam"));
		pnGioiTinh.add(Box.createRigidArea(new Dimension(14, 0)));
		pnGioiTinh.add(radNu = new JRadioButton("Nu"));
		pnWest.add(pnGioiTinh);
		ButtonGroup groupGT = new ButtonGroup();
		groupGT.add(radNam);
		groupGT.add(radNu);
		
		JPanel pnTienLuong = new JPanel();
		JLabel lblTienLuong;
		pnTienLuong.add(lblTienLuong = new JLabel("TienLuong"));
		pnTienLuong.add(txtTienLuong = new JTextField(11));
		pnWest.add(pnTienLuong);
		
		JPanel pnCaLam = new JPanel();
		JLabel lblCalam;
		pnCaLam.add(lblCalam = new JLabel("Ca làm"));
		pnCaLam.add(cbCaLam = new JComboBox());
		cbCaLam.setPreferredSize(new Dimension(114, 20));
		pnWest.add(pnCaLam);

		JPanel pnThem = new JPanel();
		pnThem.add(btnThem = new JButton("Thêm"));
		pnWest.add(pnThem);
		
		JPanel pnLuu = new JPanel();
		pnLuu.add(btnLuu = new JButton("Lưu"));
		pnWest.add(pnLuu);	
		
		JPanel pnXoa = new JPanel();
		pnXoa.add(btnXoa = new JButton("Xóa"));
		pnWest.add(pnXoa);	
		
		JPanel pnSua = new JPanel();
		pnSua.add(btnSua = new JButton("Sửa"));
		pnWest.add(pnSua);	
		
		btnThem.setPreferredSize(new Dimension(246,24));
		btnLuu.setPreferredSize(new Dimension(246,24));
		btnXoa.setPreferredSize(new Dimension(246,24));
		btnSua.setPreferredSize(new Dimension(246,24));

		lblMaNV.setPreferredSize(lblCMND.getPreferredSize());
		lblTen.setPreferredSize(lblCMND.getPreferredSize());
		lblCMND.setPreferredSize(lblCMND.getPreferredSize());
		lblSDT.setPreferredSize(lblCMND.getPreferredSize());
		lblDiaChi.setPreferredSize(lblCMND.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblCMND.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblCMND.getPreferredSize());
		lblTienLuong.setPreferredSize(lblCMND.getPreferredSize());
		lblCalam.setPreferredSize(lblCMND.getPreferredSize());

		Border bdwest = BorderFactory.createLineBorder(Color.GRAY, 1);
		TitledBorder TittleWest = new TitledBorder(bdwest,"");
		pnWest.setBorder(TittleWest);

		JPanel pnCenter = new JPanel(new BorderLayout());
		JPanel pnNorth_New = new JPanel();
		
		pnNorth_New.add(btnDau = new JButton("<<"));
		pnNorth_New.add(btnTruoc = new JButton("<"));
		pnNorth_New.add(lblMauTin = new JLabel());
		pnNorth_New.add(btnSau = new JButton(">"));
		pnNorth_New.add(btnCuoi = new JButton(">>"));
		pnNorth_New.add(txtTimKiem = new JTextField(20));
		pnNorth_New.add(btnTimKiem = new JButton("Tìm kiếm"));
		pnCenter.add(pnNorth_New,BorderLayout.NORTH);

		String[] headers = { "Mã nhân viên","Tên nhân viên","Chứng minh nhân dân","Địa chỉ",
				             "Số điện thoại","Ngày sinh","Giới tính","Tiền Lương","Ca làm"};
		dataModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll;
		pnCenter.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));
		add(pnCenter,BorderLayout.CENTER);
		Border bdCenter = BorderFactory.createLineBorder(Color.GRAY, 1);
		TitledBorder TittleCenter = new TitledBorder(bdCenter, "");
		pnCenter.setBorder(TittleCenter);

		nv_dao = new NhanVien_DAO();
		table.setRowHeight(25);
		for (NhanVien nv : nv_dao.getAllNhanVien()) {
			Object[] rowData = { nv.getMaNhanVien(),
					nv.getTenNhanVien(),
					nv.getChungMinhNhanDan(),
					nv.getDiaChi(),
					nv.getSoDienThoai(),
					nv.getNgaySinh(),
					nv.isGioiTinh(),
					nv.getTienLuong(),
					nv.getCaLam().getMaCaLam()};
			dataModel.addRow(rowData);
		}
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					mauTinHienHanh = row;
					capNhatThongTinMauTin(mauTinHienHanh);
				}
			}
		});
		mauTinHienHanh = -1;
		tongSoMauTin = table.getRowCount();
		if (tongSoMauTin > 0) {
			mauTinHienHanh = 0; // Khởi tạo là mẫu tin đầu tiên
			capNhatThongTinMauTin(mauTinHienHanh);
		}
		
		btnDau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		
//		moKhoaTextfields(false);
//		moKhoaGioiTinh(false);
		loadCombox();
	}
	private void napLopHocVaoTextfields() {
		int row = table.getSelectedRow();
		if (row >= 0) {
			txtMaNV.setText(dataModel.getValueAt(row, 0).toString());
			txtTen.setText(dataModel.getValueAt(row, 1).toString());
			txtCMND.setText(dataModel.getValueAt(row, 2).toString());
			txtDiaChi.setText(dataModel.getValueAt(row, 3).toString());
			txtSDT.setText(dataModel.getValueAt(row, 4).toString());
			txtNgaySinh.setText(dataModel.getValueAt(row, 5).toString());
			Boolean  gioiTinh = (Boolean) dataModel.getValueAt(row, 6);
			if(gioiTinh) {
				radNam.setSelected(true);;
			}else {
				radNu.setSelected(true);
			}
			txtTienLuong.setText(dataModel.getValueAt(row, 7).toString());
			
			if( dataModel.getValueAt(row, 8) != null) {
				String calam = dataModel.getValueAt(row, 8).toString();
				cbCaLam.setSelectedItem(calam);
			}
			
			else cbCaLam.setSelectedIndex(0);
		}
	}
	public void loadCombox() {
		try {
			ConnectDB a = new ConnectDB();
			Connection con = a.getConnection();
			PreparedStatement ps = con.prepareStatement("Select CaLam from NhanVien group by CaLam");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cbCaLam.addItem(rs.getString("CaLam"));
				
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
 
	private void capNhatThongTinMauTin(int n) {
		table.setRowSelectionInterval(n, n);
		lblMauTin.setText(mauTinHienHanh + 1 + "/" + tongSoMauTin);
		napLopHocVaoTextfields();
	}

//	private void moKhoaControls(boolean b) {
//
//		btnThem.setEnabled(b);
//		btnLuu.setEnabled(b);
//		btnSua.setEnabled(b);
//		btnXoa.setEnabled(b);
//		
//	}
//	private void moKhoaGioiTinh(boolean b) {
//		radNam.setEnabled(b);
//		radNu.setEnabled(b);
//	
//	}
//	

//	private void moKhoaTextfields(boolean b) {
//		txtMaNV.setEditable(b);
//		txtTen.setEditable(b);
//		txtCMND.setEditable(b);
//		txtDiaChi.setEditable(b);
//		txtSDT.setEditable(b);
//		txtNgaySinh.setEditable(b);
//		txtTienLuong.setEditable(b);
//	}
	private void xoaRongTextfields() {
		txtMaNV.setText("");
		txtTienLuong.setText("");
		txtTen.setText("");
		txtCMND.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtNgaySinh.setText("");
		txtMaNV.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
//		if (o.equals(btnThem)) {
//			 if (btnThem.getText().equalsIgnoreCase("Thêm")) {
//				
//				moKhoaTextfields(true);
//				moKhoaGioiTinh(true);
//				moKhoaControls(false);
//				btnLuu.setEnabled(true);
//				btnThem.setEnabled(true);
//				xoaRongTextfields();
//				btnThem.setText("Hủy");
//				
////				
//			} else if (btnThem.getText().equalsIgnoreCase("Hủy")) {
//				moKhoaTextfields(false);
//				moKhoaControls(true);
//				moKhoaGioiTinh(false);
//				btnLuu.setEnabled(false);
//				btnThem.setText("Thêm");
//				napLopHocVaoTextfields();
//				
//			}
//
//		}
		 if(o.equals(btnThem)) {
			try {
				
				String ma = txtMaNV.getText();
				String ten = txtTen.getText();
				String cmnd = txtCMND.getText();
				String diaChi = txtDiaChi.getText();
				String sodt = txtSDT.getText();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date date =   sf.parse(txtNgaySinh.getText());
				java.sql.Date sqlDate = new Date(date.getTime());
				boolean phai = radNam.isSelected();
				DecimalFormat df = new DecimalFormat("#,##0.00VND");
				java.math.BigDecimal  gia = (BigDecimal) df.parse(txtTienLuong.getText());
				String caLam = cbCaLam.getSelectedItem().toString();
				
				NhanVien nv = new NhanVien(ma, ten, caLam, diaChi, sodt, sqlDate, phai, gia, new CaLam(caLam));
				try {
					nv_dao.craete(nv);
						dataModel.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getChungMinhNhanDan(),
								nv.getDiaChi(),nv.getSoDienThoai(),nv.getNgaySinh(),nv.isGioiTinh(),nv.getTienLuong()});
	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Trung");
				}
			} catch (Exception e2) {
				System.out.println(e2.toString());
			}
		}
		else if (o.equals(btnSua)) {
			if (btnSua.getText().equalsIgnoreCase("Sửa")) {
//				moKhoaTextfields(true);
				txtMaNV.setEditable(false);
//				moKhoaControls(false);
				btnLuu.setEnabled(true);
				btnSua.setEnabled(true);
				btnSua.setText("Hủy");
			} else if (btnSua.getText().equalsIgnoreCase("Hủy")) {
//				moKhoaTextfields(false);
//				moKhoaControls(true);
				btnLuu.setEnabled(false);
				btnSua.setText("Sửa");
				napLopHocVaoTextfields();
			}

		} 
		else if (tongSoMauTin > 0) { // Cho các nút duyệt
			if (o.equals(btnDau))
				mauTinHienHanh = 0;
			else if (o.equals(btnCuoi))
				mauTinHienHanh = tongSoMauTin - 1;
			else if (o.equals(btnSau) && mauTinHienHanh < tongSoMauTin - 1)
				mauTinHienHanh++;
			else if (o.equals(btnTruoc) && mauTinHienHanh > 0)
				mauTinHienHanh--;
			capNhatThongTinMauTin(mauTinHienHanh);
		}
	}
	
}
