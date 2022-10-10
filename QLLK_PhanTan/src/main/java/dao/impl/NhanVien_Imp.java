package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import dao.NhanVien_dao;
import entity.KhachHang;
import entity.NhanVien;
import util.HibernateUtil;

public class NhanVien_Imp extends UnicastRemoteObject implements NhanVien_dao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public NhanVien_Imp() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public ArrayList<NhanVien> getAllNV() {
		EntityTransaction tr = em.getTransaction();
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		String sql = "select * from NhanVienBanHang";
		try {
			tr.begin();
			dsnv = (ArrayList<NhanVien>) em.createNamedQuery(sql).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return dsnv;
	}

	public NhanVien getNV(String maNV) {
		EntityTransaction tr = em.getTransaction();
		NhanVien nv = new NhanVien();
		try {
			tr.begin();
			nv = em.find(NhanVien.class, maNV);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return nv;
	}

}
