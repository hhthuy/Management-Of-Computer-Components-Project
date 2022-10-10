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
public interface KhachHang_DAO extends Remote {
	/**
	 *
	 * Láy tất cả dữ liệu khách hàng
	 */
	public List<KhachHang> getAllKH() throws RemoteException;

	/**
	 *
	 * Thêm 1 khách hàng mới
	 */
	public boolean themKH(KhachHang kh) throws RemoteException;

	/**
	 *
	 * Láy khách hàng bằng mã khách hàng
	 */
	public KhachHang getKH(String maKH) throws RemoteException;

	/**
	 *
	 * Láy khách hàng mới thêm
	 */
	public KhachHang getKHMoi() throws RemoteException;

	/**
	 *
	 * Xóa khách hàng bằng mã khách hàng
	 */
	public boolean xoaKH(String maKH) throws RemoteException;

	/**
	 *
	 * Cập nhật thông tin khách hàng
	 */
	public boolean updateKH(KhachHang kh) throws RemoteException;

	/**
	 *
	 * Số khách hàng mua trong ngày
	 */
	public int soKhMua(String data) throws RemoteException;

}
