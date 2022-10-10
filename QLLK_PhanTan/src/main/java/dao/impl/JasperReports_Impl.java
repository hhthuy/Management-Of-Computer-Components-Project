package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.persistence.EntityManager;

import dao.JasperReports_dao;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import util.HibernateUtil;

public class JasperReports_Impl extends UnicastRemoteObject implements JasperReports_dao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7641872216659072497L;
	private EntityManager em;

	public JasperReports_Impl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public void printBill(String maHD) throws RemoteException {
		try {
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLLK_RMI", "sa",
						"dang");
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			Hashtable map = new Hashtable();
			JasperReport report = JasperCompileManager
					.compileReport("src\\main\\java\\HoaDon\\rptHoaDon.jrxml");
			map.put("MaHD", maHD);
			
			JasperPrint p = JasperFillManager.fillReport(report, map, conn);
			JasperViewer.viewReport(p, false);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

	}

	@Override
	public void printThongKe(String date, String year) throws RemoteException {
		try {
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLLK_RMI", "sa",
						"dang");
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			Hashtable map = new Hashtable();
			JasperReport report = JasperCompileManager
					.compileReport("src\\main\\java\\HoaDon\\rptThongKe.jrxml");
			map.put("date", date);
			map.put("year", year);
			JasperPrint p = JasperFillManager.fillReport(report, map, conn);
			JasperViewer.viewReport(p, false);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
	}

}
