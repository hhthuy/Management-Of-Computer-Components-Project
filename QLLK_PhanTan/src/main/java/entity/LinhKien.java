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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "LinhKien")
public class LinhKien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6117161789009867711L;
	@Id
	@Column(name = "MaLK")
	private String maLK;
	@Column(name = "TenLK",columnDefinition = "nvarchar(255)")
	private String tenLK;

	@Column(name = "NhaSX",columnDefinition = "nvarchar(255)")
	private String nhaSx;
	@Column(name = "TinhTrang",columnDefinition = "nvarchar(255)")
	private String tinhTrang;
	@Column(name = "BaoHanh",columnDefinition = "nvarchar(255)")
	private String baoHanh;

	@ManyToOne
	@JoinColumn(name = "MaLoaiLK")
	private LoaiLinhKien loaiLinhKien;
	@Column(name = "SoLuongTon")
	private int soLuongTon;
	@Column(name = "GiaLK")
	private double donGia;

	@OneToMany(mappedBy = "linhKien")
	private List<CT_HoaDon> ct_HoaDons;

	public LinhKien() {
	}

	public LinhKien(String maLK) {
		this.maLK = maLK;
	}

	public LinhKien(String maLK, String tenLK, String nhaSx, String tinhTrang, String baoHanh,
			LoaiLinhKien maLoaiLinhKien, int soLuongTon, double donGia) {
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.nhaSx = nhaSx;
		this.tinhTrang = tinhTrang;
		this.baoHanh = baoHanh;
		this.loaiLinhKien = maLoaiLinhKien;
		this.soLuongTon = soLuongTon;
		this.donGia = donGia;
	}

	public LinhKien(String maLK, String tenLK, String nhaSx, String tinhTrang, String baoHanh, int soLuongTon,
			double donGia) {
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.nhaSx = nhaSx;
		this.tinhTrang = tinhTrang;
		this.baoHanh = baoHanh;
		this.soLuongTon = soLuongTon;
		this.donGia = donGia;
	}

	public LinhKien(String tenLK, String nhaSx, String tinhTrang, String baoHanh, int soLuongTon, double donGia) {
		super();
		this.tenLK = tenLK;
		this.nhaSx = nhaSx;
		this.tinhTrang = tinhTrang;
		this.baoHanh = baoHanh;
		this.soLuongTon = soLuongTon;
		this.donGia = donGia;
	}

	public String getMaLK() {
		return maLK;
	}

	public void setMaLK(String maLK) {
		this.maLK = maLK;
	}

	public String getTenLK() {
		return tenLK;
	}

	public void setTenLK(String tenLK) {
		this.tenLK = tenLK;
	}

	public String getNhaSx() {
		return nhaSx;
	}

	public void setNhaSx(String nhaSx) {
		this.nhaSx = nhaSx;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(String baoHanh) {
		this.baoHanh = baoHanh;
	}

	public LoaiLinhKien getLoaiLinhKien() {
		return loaiLinhKien;
	}

	public void setLoaiLinhKien(LoaiLinhKien loaiLinhKien) {
		this.loaiLinhKien = loaiLinhKien;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public List<CT_HoaDon> getCt_HoaDons() {
		return ct_HoaDons;
	}

	public void setCt_HoaDons(List<CT_HoaDon> ct_HoaDons) {
		this.ct_HoaDons = ct_HoaDons;
	}

	@Override
	public String toString() {
		return "LinhKien [maLK=" + maLK + ", tenLK=" + tenLK + ", nhaSx=" + nhaSx + ", tinhTrang=" + tinhTrang
				+ ", baoHanh=" + baoHanh + ", loaiLinhKien=" + loaiLinhKien + ", soLuongTon=" + soLuongTon + ", donGia="
				+ donGia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLK == null) ? 0 : maLK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinhKien other = (LinhKien) obj;
		if (maLK == null) {
			if (other.maLK != null)
				return false;
		} else if (!maLK.equals(other.maLK))
			return false;
		return true;
	}

}
