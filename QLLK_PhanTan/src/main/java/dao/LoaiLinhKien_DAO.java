package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import entity.LoaiLinhKien;

public interface LoaiLinhKien_DAO extends Remote {
	/**
	 *
	 * Láy tất cả du liệu loại linh kiện
	 */
	public List<LoaiLinhKien> getAllLLK() throws RemoteException;

	/**
	 *
	 * Tìm loại linh kiện qua mã
	 */
	public LoaiLinhKien getLoaiLinhKien(String maLoaiLK) throws RemoteException;

	/**
	 *
	 * Tìm loại linh kiện qua tên
	 */
	public LoaiLinhKien getLoaiLinhKienTheoTenLK(String tenLLK) throws RemoteException;
}
