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
@Table(name = "LoaiLinhKien")
public class LoaiLinhKien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -458165945545935349L;
	@Id
	@Column(name = "MaLoaiLK")
	private String maLoaiLK;
	@Column(name = "TenLoaiLK",columnDefinition = "nvarchar(255)")
	private String tenLoaiLK;

	@OneToMany(mappedBy = "loaiLinhKien")
	private List<LinhKien> linhkiens;

	public LoaiLinhKien() {
	}

	public LoaiLinhKien(String maLoaiLK, String tenLoaiLK, List<LinhKien> linhkiens) {
		super();
		this.maLoaiLK = maLoaiLK;
		this.tenLoaiLK = tenLoaiLK;
		this.linhkiens = linhkiens;
	}

	public LoaiLinhKien(String maLoaiLK, String tenLoaiLK) {
		super();
		this.maLoaiLK = maLoaiLK;
		this.tenLoaiLK = tenLoaiLK;
	}

	public String getMaLoaiLK() {
		return maLoaiLK;
	}

	public void setMaLoaiLK(String maLoaiLK) {
		this.maLoaiLK = maLoaiLK;
	}

	public String getTenLoaiLK() {
		return tenLoaiLK;
	}

	public void setTenLoaiLK(String tenLoaiLK) {
		this.tenLoaiLK = tenLoaiLK;
	}

	public List<LinhKien> getLinhkiens() {
		return linhkiens;
	}

	public void setLinhkiens(List<LinhKien> linhkiens) {
		this.linhkiens = linhkiens;
	}

	@Override
	public String toString() {
		return "LoaiLinhKien [maLoaiLK=" + maLoaiLK + ", tenLoaiLK=" + tenLoaiLK + "]";
	}

}
