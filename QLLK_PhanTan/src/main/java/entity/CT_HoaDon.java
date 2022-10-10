/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "CTHoaDon")
@IdClass(CTHD_PK.class)
public class CT_HoaDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "MaHD")
	private HoaDonBanHang HoaDon;
	@Id
	@ManyToOne
	@JoinColumn(name = "MaLk")
	private LinhKien linhKien;
	private double giaBan;
	private int soLuong;

	public CT_HoaDon() {
	}

	public CT_HoaDon(HoaDonBanHang hoaDon, LinhKien linhKien, double giaBan, int soLuong) {
		super();
		HoaDon = hoaDon;
		this.linhKien = linhKien;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
	}

	public CT_HoaDon(double giaBan, int soLuong) {
		super();
		this.giaBan = giaBan;
		this.soLuong = soLuong;
	}

	public HoaDonBanHang getHoaDon() {
		return HoaDon;
	}

	public void setHoaDon(HoaDonBanHang hoaDon) {
		HoaDon = hoaDon;
	}

	public LinhKien getLinhKien() {
		return linhKien;
	}

	public void setLinhKien(LinhKien linhKien) {
		this.linhKien = linhKien;
	}

	public double getGiaban() {
		return giaBan;
	}

	public void setGiaban(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoluong() {
		return soLuong;
	}

	public void setSoluong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "CT_HoaDon [linhKien=" + linhKien + ", giaban=" + giaBan + ", soluong=" + soLuong + "]";
	}

}
