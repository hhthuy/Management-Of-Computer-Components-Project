package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import dao.LoaiLinhKien_DAO;
import entity.LinhKien;
import entity.LoaiLinhKien;
import util.HibernateUtil;

public class LoaiLinhKien_Imp extends UnicastRemoteObject implements LoaiLinhKien_DAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em = null;

	public LoaiLinhKien_Imp() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public List<LoaiLinhKien> getAllLLK() {
		EntityTransaction tr = em.getTransaction();
		List<LoaiLinhKien> dsLLK = new ArrayList<LoaiLinhKien>();
		String sql = "select * from LoaiLinhKien";
		try {
			tr.begin();
			dsLLK = em.createNativeQuery(sql, LoaiLinhKien.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return dsLLK;
	}

	public LoaiLinhKien getLoaiLinhKien(String maLoaiLK) {
		EntityTransaction tr = em.getTransaction();
		LoaiLinhKien loaiLinhKien = new LoaiLinhKien();
		try {
			tr.begin();
			loaiLinhKien = em.find(LoaiLinhKien.class, maLoaiLK);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return loaiLinhKien;
	}

	public LoaiLinhKien getLoaiLinhKienTheoTenLK(String tenLLK) {
		LoaiLinhKien loaiLinhKien = new LoaiLinhKien();
		EntityTransaction tr = em.getTransaction();
		String sql = "select * from LoaiLinhKien where TenLoaiLK ='" + tenLLK + "'";
		try {
			tr.begin();
			loaiLinhKien = (LoaiLinhKien) em.createNativeQuery(sql, LoaiLinhKien.class).getSingleResult();

			tr.commit();

		} catch (RuntimeException e) {
			e.printStackTrace();
			tr.rollback();
		}
		return loaiLinhKien;
	}

}
