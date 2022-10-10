/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import entity.*;

/**
 *
 * @author HP
 */
public interface NhanVien_dao extends Remote {
	/**
	 *
	 * Láy tất cả dữ liẹue nhân viên
	 */
	public ArrayList<NhanVien> getAllNV() throws RemoteException;

	/**
	 *
	 * Tìm nhân viên qua mã nhân viên
	 */
	public NhanVien getNV(String maNV) throws RemoteException;

}
