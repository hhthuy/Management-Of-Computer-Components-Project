/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = -7227514795507990202L;

	@Id
	@Column(name = "TenDN")
	private String tenDN;
	@Column(name = "MatKhau")
	private String matKhau;
	@Column(name = "TenQuyen",columnDefinition = "nvarchar(255)")
	private String tenQuyen;
	@Column(name = "TrangThai")
	private String trangThai;

	@ManyToOne
	@JoinColumn(name = "MaNV")
	private NhanVien nhanVien;

	public TaiKhoan() {

	}

	public TaiKhoan(TaiKhoan tk) {
		this.tenDN = tk.getTenDN();
		this.matKhau = tk.getMatKhau();
		this.tenQuyen = tk.getTenQuyen();
		this.nhanVien = tk.getNhanVien();

	}

	public TaiKhoan(String tenDN, String matKhau, String tenQuyen, NhanVien nhanVien) {
		super();
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.tenQuyen = tenQuyen;
		this.nhanVien = nhanVien;
	}

	public TaiKhoan(String tenDN, String matKhau, String tenQuyen, String trangThai, NhanVien nhanVien) {
		super();
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.tenQuyen = tenQuyen;
		this.trangThai = trangThai;
		this.nhanVien = nhanVien;
	}

	public String getTenDN() {
		return tenDN;
	}

	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenDN=" + tenDN + ", matKhau=" + matKhau + ", tenQuyen=" + tenQuyen + ", trangThai="
				+ trangThai + ", nhanVien=" + nhanVien + "]";
	}

}
