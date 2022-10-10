/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6051356792457866271L;
	@Id
	@Column(name = "MaNV")
	private String maNv;
	@Column(name = "TenNV",columnDefinition = "nvarchar(255)")
	private String tenNv;
	@Column(name = "NgaySinh")
	private Date ngaySinh;
	@Column(name = "GioiTinh",columnDefinition = "nvarchar(255)")
	private String gioTinh;
	@Column(name = "ChucVu",columnDefinition = "nvarchar(255)")
	private String chucVu;
	@Column(name = "Luong")
	private Double luong;

	@OneToMany(mappedBy = "nhanVien")
	private List<HoaDonBanHang> orders;

	@OneToMany(mappedBy = "nhanVien")
	private List<TaiKhoan> taiKhoan;

	public NhanVien() {

	}

	public NhanVien(String maNv, String tenNv, Date ngaySinh, String gioTinh, String chucVu, Double luong) {
		super();
		this.maNv = maNv;
		this.tenNv = tenNv;
		this.ngaySinh = ngaySinh;
		this.gioTinh = gioTinh;
		this.chucVu = chucVu;
		this.luong = luong;
	}

	public NhanVien(String maNv) {
		super();
		this.maNv = maNv;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public String getTenNv() {
		return tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioTinh() {
		return gioTinh;
	}

	public void setGioTinh(String gioTinh) {
		this.gioTinh = gioTinh;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public Double getLuong() {
		return luong;
	}

	public void setLuong(Double luong) {
		this.luong = luong;
	}

	public List<HoaDonBanHang> getOrders() {
		return orders;
	}

	public void setOrders(List<HoaDonBanHang> orders) {
		this.orders = orders;
	}

	public List<TaiKhoan> getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(List<TaiKhoan> taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "NhanVien [maNv=" + maNv + ", tenNv=" + tenNv + ", ngaySinh=" + ngaySinh + ", gioTinh=" + gioTinh
				+ ", chucVu=" + chucVu + ", luong=" + luong + "]";
	}

}
