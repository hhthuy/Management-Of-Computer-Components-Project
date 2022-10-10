package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.CTHoaDon_DAO;
import entity.CT_HoaDon;
import entity.KhachHang;
import util.HibernateUtil;

public class CTHoaDon_Imp extends UnicastRemoteObject implements CTHoaDon_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public CTHoaDon_Imp() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public List<CT_HoaDon> getAllCTHD() {
		EntityTransaction tr = em.getTransaction();
		List<CT_HoaDon> ls = new ArrayList<CT_HoaDon>();
		String sql = "select * from CTHoaDon";
		try {
			tr.begin();
			ls = em.createNativeQuery(sql, CT_HoaDon.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return ls;
	}

	public boolean themCthd(CT_HoaDon ct) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			String sql = "INSERT [dbo].[CTHoaDon] ([MaHD],[MaLk], [giaban],[soluong]) VALUES ( '"
					+ ct.getHoaDon().getMaHD() + "', N'" + ct.getLinhKien().getMaLK() + "'," + ct.getGiaban() + ","
					+ ct.getSoluong() + ")";
			int n = em.createNativeQuery(sql, CT_HoaDon.class).executeUpdate();
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

	public List<CT_HoaDon> getCthd(String maHD) {
		EntityTransaction tr = em.getTransaction();
		List<CT_HoaDon> listctHD = new ArrayList<CT_HoaDon>();
		String sql = "select * from CTHoaDon where MaHD = '" + maHD + "'";
		try {
			tr.begin();
			listctHD = em.createNativeQuery(sql, CT_HoaDon.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return listctHD;
	}

}
