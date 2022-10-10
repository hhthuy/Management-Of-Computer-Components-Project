package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.NhanVien;
import entity.TaiKhoan;

public interface TaiKhoan_DAO extends Remote {
	/**
	 *
	 * Tìm Tài khoản bằng tênDn
	 */
	public TaiKhoan getTkByTenDN(String tenDn) throws RemoteException;

	/**
	 *
	 * Tìm Tài khoản bằng Ma nhan vien
	 */
	public TaiKhoan getTkByMaNv(String maNv) throws RemoteException;

	/**
	 *
	 * Tìm Tài khoản bằng ten dang nhaapj vs mật khẩu
	 */
	public TaiKhoan getTkByTenDNvsMK(String tenDn, String mk) throws RemoteException;

	/**
	 *
	 * Cập nhật trại thái tài khoản
	 */
	public boolean capNhatTrangThai(TaiKhoan tk) throws RemoteException;

}
