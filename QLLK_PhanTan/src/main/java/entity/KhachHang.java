/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2737343644760232698L;
	@Id
	@Column(name = "MaKH")
	private String maKH;
	@Column(name = "TenKH" ,columnDefinition = "nvarchar(255)")
	private String tenKH;
	@Column(name = "DiaChi",columnDefinition = "nvarchar(255)")
	private String diaChi;
	@Column(name = "SDT")
	private String sdt;
	@OneToMany(mappedBy = "khachHang")
	private List<HoaDonBanHang> donBanHangs;

	public KhachHang() {

	}

	public KhachHang(String maKH, String tenKH, String diaChi, String sdt) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public KhachHang(String tenKH, String diaChi, String sdt) {
		super();
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<HoaDonBanHang> getDonBanHangs() {
		return donBanHangs;
	}

	public void setDonBanHangs(List<HoaDonBanHang> donBanHangs) {
		this.donBanHangs = donBanHangs;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", sdt=" + sdt + "]";
	}

}
