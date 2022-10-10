/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CTHoaDon_DAO extends Remote {
	/*
	 * Láy dữ liệu từ bảng chi tiet hoa don
	 *
	 * */
	public List<CT_HoaDon> getAllCTHD()throws RemoteException;
	/*
	 * Thêm một chi tiết vào bảng
	 * 
	 * */
	public boolean themCthd(CT_HoaDon ct)throws RemoteException;
	/*
	 * Tìm chi tiết qua mã hóa đơn
	 * 
	 * */
	public List<CT_HoaDon> getCthd(String maHD)throws RemoteException;
	
}
