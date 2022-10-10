package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.LinhKien_DAO;
import entity.CT_HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import util.HibernateUtil;

public class LinhKien_Imp extends UnicastRemoteObject implements LinhKien_DAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em = null;

	public LinhKien_Imp() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public List<LinhKien> getAllLK() throws RemoteException {
		List<LinhKien> listLK = new ArrayList<LinhKien>();
		EntityTransaction tr = em.getTransaction();
		String sql = "select * from LinhKien";
		try {
			tr.begin();
			listLK = em.createNativeQuery(sql, LinhKien.class).getResultList();
			tr.commit();

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return listLK;
	}

	@Override
	public LinhKien getLinhKien(String maLK) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		LinhKien lk = new LinhKien();
		try {
			tr.begin();
			lk = em.find(LinhKien.class, maLK);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return lk;
	}

	@Override
	public boolean themLK(LinhKien lk) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "INSERT [dbo].[LinhKien] ( [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) "
					+ "VALUES ('" + lk.getLoaiLinhKien().getMaLoaiLK() + "' , '" + lk.getTenLK() + "', '"
					+ lk.getSoLuongTon() + "'," + " '" + lk.getDonGia() + "', '" + lk.getNhaSx() + "','"
					+ lk.getTinhTrang() + "', '" + lk.getBaoHanh() + "')";
			int n = em.createNativeQuery(sql, LinhKien.class).executeUpdate();
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

	@Override
	public boolean xoaLK(String maLK) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(LinhKien.class, maLK));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean update(LinhKien lk) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(lk);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<LinhKien> searchTenOrMa(String text) throws RemoteException {
		List<LinhKien> listLK = new ArrayList<LinhKien>();
		EntityTransaction tr = em.getTransaction();
		String sql = "select * from LinhKien where TenLK like '%" + text + "%' or MaLK='" + text
				+ "' and  SoLuongTon >1";
		try {
			tr.begin();
			listLK = em.createNativeQuery(sql, LinhKien.class).getResultList();
			System.out.println("list dao" + listLK);
			tr.commit();

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return listLK;
	}

	@Override
	public int soLkBanDuoc(String data) throws RemoteException {
		int soLK = 0;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "SELECT COUNT (sosp.sp) AS 'Masp' from\r\n"
					+ "				(SELECT cthd.MaLk sp ,SUM (cthd.SoLuong)  sl, sp.TenLK ten ,sp.GiaLK dongia \r\n"
					+ "                					FROM [dbo].[CTHoaDon] cthd, [dbo].[LinhKien] sp , [dbo].[HoaDon] hdb\r\n"
					+ "                					WHERE  cthd.MaLk = sp.MaLK and cthd.MaHD =hdb.MaHD  and day( hdb.NgayLapHD) ='"
					+ data + "'\r\n" + "          					 GROUP BY cthd.MaLk , sp.TenLK,sp.GiaLK ) sosp";
			soLK = (int) em.createNativeQuery(sql).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return soLK;
	}

}
