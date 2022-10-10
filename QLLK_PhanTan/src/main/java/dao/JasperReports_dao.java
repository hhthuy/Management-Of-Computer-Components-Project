package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JasperReports_dao extends Remote {
	/**
	 *
	 * In hóa đơn
	 */
	public void printBill(String maHD)throws RemoteException;
	
	/**
	 *
	 * Thong kê
	 */
	public void printThongKe(String date, String year)throws RemoteException;
}
