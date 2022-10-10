/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "HoaDon")
public class HoaDonBanHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2005277866497692601L;
	@Id
	private String maHD;
	private Date ngaylapHD;

	@ManyToOne
	@JoinColumn(name = "MaNV")
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name = "MaKH")
	private KhachHang khachHang;

	@OneToMany(mappedBy = "HoaDon")
	private List<CT_HoaDon> ct_HoaDon;

	public HoaDonBanHang() {
	}

	public HoaDonBanHang(String maHD, Date ngaylapHD, NhanVien nhanVien, KhachHang khachHang,
			List<CT_HoaDon> ct_HoaDon) {
		super();
		this.maHD = maHD;
		this.ngaylapHD = ngaylapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ct_HoaDon = ct_HoaDon;
	}

	public HoaDonBanHang(String maHD, Date ngaylapHD, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngaylapHD = ngaylapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}

	public HoaDonBanHang(Date ngaylapHD, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.ngaylapHD = ngaylapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}

	public HoaDonBanHang(String maHD) {
		super();
		this.maHD = maHD;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public Date getNgaylapHD() {
		return ngaylapHD;
	}

	public void setNgaylapHD(Date ngaylapHD) {
		this.ngaylapHD = ngaylapHD;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public List<CT_HoaDon> getCt_HoaDon() {
		return ct_HoaDon;
	}

	public void setCt_HoaDon(List<CT_HoaDon> ct_HoaDon) {
		this.ct_HoaDon = ct_HoaDon;
	}

	@Override
	public String toString() {
		return "HoaDonBanHang [maHD=" + maHD + ", ngaylapHD=" + ngaylapHD + ", nhanVien=" + nhanVien + ", khachHang="
				+ khachHang + "]";
	}

}
