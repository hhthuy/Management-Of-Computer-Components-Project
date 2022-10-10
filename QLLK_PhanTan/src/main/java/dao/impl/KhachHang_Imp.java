package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import dao.KhachHang_DAO;
import entity.KhachHang;
import entity.LinhKien;
import util.HibernateUtil;

public class KhachHang_Imp extends UnicastRemoteObject implements KhachHang_DAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em = null;

	public KhachHang_Imp() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public List<KhachHang> getAllKH() {
		EntityTransaction tr = em.getTransaction();
		List<KhachHang> dskh = new ArrayList<KhachHang>();
		String sql = "select * from KhachHang";
		try {
			tr.begin();
			dskh = em.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return dskh;
	}

	public boolean themKH(KhachHang kh) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "INSERT [dbo].[KhachHang] ( [TenKH], [SDT], [DiaChi]) VALUES ( N'" + kh.getTenKH() + "', N'"
					+ kh.getSdt() + "', N'" + kh.getDiaChi() + "')";
			int n = em.createNativeQuery(sql, KhachHang.class).executeUpdate();
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

	public KhachHang getKH(String maKH) {
		EntityTransaction tr = em.getTransaction();
		KhachHang kh = new KhachHang();
		try {
			tr.begin();
			kh = em.find(KhachHang.class, maKH);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kh;
	}

	public KhachHang getKHMoi() {
		EntityTransaction tr = em.getTransaction();
		String sql = "select top 1 * from KhachHang order by MaKH DESC";
		KhachHang kh = new KhachHang();
		try {
			tr.begin();
			kh = (KhachHang) em.createNativeQuery(sql, KhachHang.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kh;
	}

	@Override
	public boolean xoaKH(String maKH) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(KhachHang.class, maKH));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateKH(KhachHang kh) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(kh);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public int soKhMua(String data) throws RemoteException {
		int soLK = 0;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT count (sokh.kh) from\r\n"
					+ "				(SELECT hdb.MaKH kh , COUNT(hdb.MaHD) sc, kh.TenKH ten \r\n"
					+ "                					FROM [dbo].[HoaDon] hdb, [dbo].[KhachHang] kh\r\n"
					+ "                					WHERE hdb.MaKH = kh.MaKH and day( hdb.NgayLapHD) ='" + data
					+ "'\r\n" + "               					 GROUP BY hdb.MaKH , kh.TenKH ) sokh";
			soLK = (int) em.createNativeQuery(sql).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return soLK;
	}

}
