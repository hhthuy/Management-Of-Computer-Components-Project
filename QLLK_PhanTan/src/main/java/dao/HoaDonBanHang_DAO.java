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
public interface HoaDonBanHang_DAO extends Remote {
	/**
	 *
	 * láy tất cả dữ liệu hoa đơn
	 */
	public List<HoaDonBanHang> getAllHD() throws RemoteException;

	/**
	 *
	 * Thêm một hóa đơn mới vào csdl
	 */
	public boolean themHD(HoaDonBanHang hd) throws RemoteException;

	/**
	 *
	 * Láy thông tin hóa đơn bằng mã hóa đơn
	 */
	public HoaDonBanHang getHD(String maHD) throws RemoteException;

	/**
	 *
	 * Tìm hóa đơn mới lập
	 */
	public HoaDonBanHang getHoaDonMoiNhat() throws RemoteException;

	/**
	 *
	 * Số hóa dơn lập trong ngày hôm nay
	 */
	public int soHd(String data) throws RemoteException;

	/**
	 *
	 * thong ke doanh thu trong 7 ngày trước
	 */
	public List<Double> soDoanhThu(String day, String year) throws RemoteException;

}
