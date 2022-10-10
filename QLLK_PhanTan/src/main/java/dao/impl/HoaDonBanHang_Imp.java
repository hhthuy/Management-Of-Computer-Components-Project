package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.HoaDonBanHang_DAO;
import entity.HoaDonBanHang;
import entity.KhachHang;
import entity.LinhKien;
import util.HibernateUtil;

public class HoaDonBanHang_Imp extends UnicastRemoteObject implements HoaDonBanHang_DAO {
	private EntityManager em = null;

	public HoaDonBanHang_Imp() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public List<HoaDonBanHang> getAllHD() {
		EntityTransaction tr = em.getTransaction();
		List<HoaDonBanHang> dshd = new ArrayList<HoaDonBanHang>();
		String sql = "select * from HoaDon";
		try {
			tr.begin();
			dshd = em.createNativeQuery(sql, HoaDonBanHang.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return dshd;
	}

	public boolean themHD(HoaDonBanHang hd) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "INSERT [dbo].[HoaDon]([ngaylapHD] , [MaNV], [MaKH]) VALUES ( '" + hd.getNgaylapHD() + "', N'"
					+ hd.getNhanVien().getMaNv() + "', N'" + hd.getKhachHang().getMaKH() + "')";
			int n = em.createNativeQuery(sql, HoaDonBanHang.class).executeUpdate();
			tr.commit();
			if (n > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public HoaDonBanHang getHD(String maHD) {
		EntityTransaction tr = em.getTransaction();
		HoaDonBanHang hd = new HoaDonBanHang();
		try {
			tr.begin();
			hd = em.find(HoaDonBanHang.class, maHD);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return hd;
	}

	public HoaDonBanHang getHoaDonMoiNhat() {
		EntityTransaction tr = em.getTransaction();
		HoaDonBanHang hd = new HoaDonBanHang();
		String sql = "select top 1 * from HoaDon order by MaHD DESC";
		try {
			tr.begin();
			hd = (HoaDonBanHang) em.createNativeQuery(sql, HoaDonBanHang.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return hd;
	}

	@Override
	public int soHd(String date) throws RemoteException {
		int soHD = 0;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "select COUNT(hd.maHD) from [dbo].[HoaDon] hd where day(ngaylapHD) ='" + date + "'";
			soHD = (int) em.createNativeQuery(sql).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return soHD;
	}

	@Override
	public List<Double> soDoanhThu(String day, String year) throws RemoteException {
		List<Double> list = new ArrayList<Double>();
		EntityTransaction tr = em.getTransaction();
		String sql = "select sum(tong.tongTien) tongDoanhThu from \r\n"
				+ "(SELECT HoaDon.ngaylapHD ngaylap, sum(CTHoaDon.giaban* CTHoaDon.soluong) tongTien\r\n"
				+ "FROM     CTHoaDon INNER JOIN\r\n" + "                  HoaDon ON CTHoaDon.MaHD = HoaDon.maHD\r\n"
				+ "				  where   day(ngaylapHD) <=" + day + " and day(ngaylapHD) >" + day
				+ "-7 and YEAR(ngaylapHD)='" + year + "'\r\n" + "				  group by  HoaDon.ngaylapHD\r\n"
				+ "				  )tong\r\n" + "				  group by ngaylap order by tong.ngaylap ASC";
		try {
			tr.begin();
			list = em.createNativeQuery(sql).getResultList();

			tr.commit();

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return list;
	}
}
