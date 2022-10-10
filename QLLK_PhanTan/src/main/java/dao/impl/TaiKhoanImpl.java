package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.TaiKhoan_DAO;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;
import entity.TaiKhoan;
import util.HibernateUtil;

public class TaiKhoanImpl extends UnicastRemoteObject implements TaiKhoan_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7232053582794375079L;
	private EntityManager em;

	public TaiKhoanImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public TaiKhoan getTkByTenDN(String tenDn) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		TaiKhoan tk = new TaiKhoan();
		try {
			tr.begin();
			tk = em.find(TaiKhoan.class, tenDn);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return tk;
	}

	@Override
	public TaiKhoan getTkByMaNv(String maNv) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		String sql = "select * from TaiKhoan where [MaNV]='" + maNv + "'";
		TaiKhoan tk = new TaiKhoan();
		try {
			tr.begin();
			tk = (TaiKhoan) em.createNativeQuery(sql, TaiKhoan.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return tk;
	}

	@Override
	public TaiKhoan getTkByTenDNvsMK(String tenDn, String mk) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		String sql = "select * from TaiKhoan where [TenDN]='" + tenDn + "' and [MatKhau] ='" + mk + "'";
		TaiKhoan tk = new TaiKhoan();
		try {
			tr.begin();
			tk = (TaiKhoan) em.createNativeQuery(sql, TaiKhoan.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return tk;
	}

	@Override
	public boolean capNhatTrangThai(TaiKhoan tk) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

}
