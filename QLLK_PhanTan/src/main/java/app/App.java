package app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import dao.CTHoaDon_DAO;
import dao.HoaDonBanHang_DAO;
import dao.JasperReports_dao;
import dao.KhachHang_DAO;
import dao.LinhKien_DAO;
import dao.LoaiLinhKien_DAO;
import dao.NhanVien_dao;
import dao.TaiKhoan_DAO;
import dao.impl.CTHoaDon_Imp;
import dao.impl.HoaDonBanHang_Imp;
import dao.impl.JasperReports_Impl;
import dao.impl.KhachHang_Imp;
import dao.impl.LinhKien_Imp;
import dao.impl.LoaiLinhKien_Imp;
import dao.impl.NhanVien_Imp;
import dao.impl.TaiKhoanImpl;
import entity.CT_HoaDon;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LinhKien;
import entity.LoaiLinhKien;
import entity.NhanVien;
import entity.TaiKhoan;
import util.HibernateUtil;

public class App {
	
	
	public static void main(String[] args) {
		 Date date2 = new Date(2021,11,23);
		 Date date = new Date();
		 SimpleDateFormat formatterday = new SimpleDateFormat("dd");
		 SimpleDateFormat formatterYear = new SimpleDateFormat("YYYY");
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		
		try {
			LinhKien_DAO lkDao = new LinhKien_Imp();
			LoaiLinhKien_DAO llkDao = new LoaiLinhKien_Imp();
			KhachHang_DAO khDao = new KhachHang_Imp();
			NhanVien_dao nvDao = new NhanVien_Imp();
			TaiKhoan_DAO tkDao = new TaiKhoanImpl();
			HoaDonBanHang_DAO banHang_DAO = new HoaDonBanHang_Imp();
			CTHoaDon_DAO ctHoaDon_DAO = new CTHoaDon_Imp();
			JasperReports_dao billDao = new JasperReports_Impl();
			
			
//			lkDao.getAllLK().forEach(lk->System.out.println(lk));
			
//			lkDao.searchTenOrMa("LK007").forEach(lk->System.out.println(lk));
			//tim linh kien theo ma
//			LinhKien lk = lkDao.getLinhKien("LK007");
//			System.out.println("linh kien tìm"+lk);
			
			//getloailk theo ten
			
//			llkDao.getLoaiLinhKienTheoTenLK("CPU").forEach(lk->System.out.println(lk));
			
//			LoaiLinhKien llk = llkDao.getLoaiLinhKien("LLK06");
//			System.out.println("linh kien tìm"+llk);
			
			//them linh kien mowi
//			LinhKien lk = new LinhKien("aa", "AA", "aa", "aa", 20, 5555.0);
//			
//			
//			LoaiLinhKien llk = new  LoaiLinhKien("LLK01", "Intel Core i7 10700K");
//			lk.setLoaiLinhKien(llk);
//			boolean rs = lkDao.themLK(lk);
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			//them khach hang
//			KhachHang kh = new KhachHang("Dang", "Go Vap", 012121212121);
//			boolean rs = khDao.themKH(kh);
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			//tim khach hang moi
//			KhachHang kh = khDao.getKHMoi();
//			System.out.println("Khach hang"+kh);
			
			//tim nhân viên đang online
//			TaiKhoan tk = tkDao.getTrangThai();
//			
//			System.out.println("Nhan vien"+tk);
			
			//tim khach hang qua ma
//			KhachHang kh = khDao.getKH("KH001");
//			System.out.println("Khach hang"+kh);
			
			//them hd 
//			NhanVien nv = new NhanVien("NV002");
//			KhachHang kh = new KhachHang("KH001");
//			HoaDonBanHang hd = new HoaDonBanHang( new java.sql.Date(2001 - 1900, 11, 22),nv ,kh );
//			boolean rs = banHang_DAO.themHD(hd);
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			
			//lay hd moi nhat
//			HoaDonBanHang hd = banHang_DAO.getHoaDonMoiNhat();
//			System.out.println("Hoa don"+hd);
			
			//them cthd
//			HoaDonBanHang hd = new HoaDonBanHang("HDBH021");
//			LinhKien lk = new LinhKien("LK007");
//			CT_HoaDon ct = new CT_HoaDon(hd, lk, 5000.0, 20);
//			boolean rs = ctHoaDon_DAO.themCthd(ct);
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			//cap nhat sl lk
//			boolean rs = lkDao.capNhatSoLuong("LK001", 50);
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			//lay tat ca dl hoa don
//			banHang_DAO.getAllHD().forEach(lk->System.out.println(lk));
			
			
			//tim hd bag mã
//			HoaDonBanHang hd=  banHang_DAO.getHD("HDBH021");
//			System.out.println(hd);
			
			
			//tim cthd qua mã hd
//			ctHoaDon_DAO.getCthd("HDBH021").forEach(lk->System.out.println(lk));
			
			//in hoa don
//			billDao.printBill("HDBH026");
			
			//lay ds khách hàng
//			khDao.getAllKH().forEach(lk->System.out.println(lk));
			
			//xóa khách hàng
//			boolean rs = khDao.xoaKH("KH009");
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			//cap nhật khách hàng
//			boolean rs =khDao.updateKH(new KhachHang("KH008", "a", "a","01474477415"));
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			//xóa lk
//			boolean rs = lkDao.xoaLK("LK029");
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			//cap nhật lk
//			boolean rs = lkDao.update(new LinhKien("LK029", "a", "a", "a", "a", 50, 5000.0));
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			//tim llk theo ten
//			LoaiLinhKien llk= llkDao.getLoaiLinhKienTheoTenLK("CPU");
//			System.out.println(llk);
			
			//so lk het hang
//			int so = lkDao.soLkHetHang();
//			System.out.println(so);
			
			//so sp bn
//			String day = (String) formatterday.format(date);
//			int so = lkDao.soLkBanDuoc(day);
//			System.out.println(so);
			
			//so khach hang
//			String day = (String) formatterday.format(date2);
//			int so = khDao.soKhMua(day);
//			System.out.println(so);
			
			//so Hoa Don
//			String day = (String) formatterday.format(date2);
//			int so = banHang_DAO.soHd(day);
//			System.out.println(so);
			
			
			//ds llk
//			llkDao.getAllLLK().forEach(lk->System.out.println(lk));
			
			//thong ke
//			String day = (String) formatterday.format(date);
//			String year = (String) formatterYear.format(date);
////			
//			banHang_DAO.soDoanhThu(day, year).forEach(lk->System.out.println(lk));
			
			//tim tk qua ten dang nhap
//			TaiKhoan tk = tkDao.getTkByTenDN("19526881");
//			System.out.println(tk);
			
			//tim tk qua ma nhan vien
//			TaiKhoan tk = tkDao.getTkByMaNv("NV002");
//			System.out.println(tk);
			
			//tim tk qua ma ten dang nhap makhau
//			TaiKhoan tk = tkDao.getTkByTenDNvsMK("19526881", "12345678");
//			System.out.println(tk);
			
			//cap nhật tài khoản
//			NhanVien nv = new NhanVien("NV002");
//			boolean rs =tkDao.capNhatTrangThai(new TaiKhoan("19526881", "12345678", "QuanLy", "off",nv ));
//			if (rs) {
//				System.out.println("ok");
//			}else {
//				System.out.println("no");
//			}
			
			
			//in thog ke
//			String day = (String) formatterday.format(date);
//			String year = (String) formatterYear.format(date);
//			billDao.printThongKe(day, year);
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
