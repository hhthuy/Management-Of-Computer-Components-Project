/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import entity.LinhKien;

/**
 *
 * @author HP
 */
public interface LinhKien_DAO extends Remote {
	/**
	 *
	 * Láy tất cả dử liệu
	 */
	public List<LinhKien> getAllLK() throws RemoteException;

	/**
	 *
	 * Tìm Linh kiện bằng mã linh kiện
	 */
	public LinhKien getLinhKien(String maLK) throws RemoteException;

	/**
	 *
	 * Thêm Linh kiện
	 */
	public boolean themLK(LinhKien lk) throws RemoteException;

	/**
	 *
	 * Xóa Linh kiện bằng mã linh kiện
	 */
	public boolean xoaLK(String maLK) throws RemoteException;

	/**
	 *
	 * Cập nhật Linh kiện
	 */
	public boolean update(LinhKien lk) throws RemoteException;

	/**
	 *
	 * Số Linh kiện bán được
	 */
	public int soLkBanDuoc(String data) throws RemoteException;

	/**
	 *
	 * Tim linh kien bằng mã,tên
	 */
	public List<LinhKien> searchTenOrMa(String text) throws RemoteException;

}
