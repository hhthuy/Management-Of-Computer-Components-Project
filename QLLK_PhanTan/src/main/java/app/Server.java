package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

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

public class Server {
	public static void main(String[] args) {
		 SecurityManager securityManager = System.getSecurityManager();
	        if (securityManager == null) {
	            System.setProperty("java.security.policy", "policy\\policy.policy");
	            System.setSecurityManager(new SecurityManager());
	        }
	        
	        try {
	            LinhKien_DAO lkDao = new LinhKien_Imp();
	            LoaiLinhKien_DAO llkdao = new LoaiLinhKien_Imp();
	            NhanVien_dao nvDao = new NhanVien_Imp();
	            KhachHang_DAO khDao = new KhachHang_Imp();
	            TaiKhoan_DAO tkDao = new TaiKhoanImpl();
	            HoaDonBanHang_DAO hdbhDao = new HoaDonBanHang_Imp();
	            CTHoaDon_DAO ctDao = new CTHoaDon_Imp();
	            JasperReports_dao jspDao = new JasperReports_Impl();

	            LocateRegistry.createRegistry(1099);
	            Naming.bind("rmi://192.168.1.3:1099/lkDao", lkDao);
	            Naming.bind("rmi://192.168.1.3:1099/llkdao", llkdao);
	            Naming.bind("rmi://192.168.1.3:1099/nvDao", nvDao);
	            Naming.bind("rmi://192.168.1.3:1099/khDao", khDao);
	            Naming.bind("rmi://192.168.1.3:1099/tkDao", tkDao);
	            Naming.bind("rmi://192.168.1.3:1099/hdbhDao", hdbhDao);
	            Naming.bind("rmi://192.168.1.3:1099/ctDao", ctDao);
	            Naming.bind("rmi://192.168.1.3:1099/jspDao", jspDao);

	            System.out.println("Server RMI ready....");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        
	        
	}
}
