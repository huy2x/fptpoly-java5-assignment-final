package com.DAS.Entity;
//Make by Bình An || AnLaVN || KatoVN

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "KHOAHOC", schema = "dbo", catalog = "DASJ5SQL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Khoahoc{

	@Id
	@Column(name = "IDKH", unique = true, nullable = false, length = 20)
	@NonNull
	private String idkh;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDPL")
	private Phanloai phanloai;
	
	@Column(name = "TENKHOAHOC")
	private String tenkhoahoc;
	
	@Column(name = "MOTA")
	private String mota;
	
	@Column(name = "MOTANGAN")
	private String motangan;
	
	@Column(name = "ANHMOTA", length = 256)
	private String anhmota;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khoahoc",orphanRemoval = true)
	private List<Danhgia> danhgias = new ArrayList<Danhgia>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khoahoc",orphanRemoval = true)
	private List<Diem> diems = new ArrayList<Diem>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khoahoc",orphanRemoval = true)
	private List<Tainguyen> tainguyens = new ArrayList<Tainguyen>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "KHOAHOC_SINHVIEN", schema = "dbo", catalog = "DASJ5SQL", joinColumns = {
			@JoinColumn(name = "IDKH", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USERNAME", nullable = false, updatable = false) })
	private List<Sinhvien> sinhviens = new ArrayList<Sinhvien>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khoahoc",orphanRemoval = true)
	private List<Cauhoi> cauhois = new ArrayList<Cauhoi>();

	@Override
	public String toString() {
		return "Khoahoc [idkh=" + idkh + ", phanloai=" + phanloai + ", tenkhoahoc=" + tenkhoahoc + ", mota=" + mota
				+ ", motangan=" + motangan + ", anhmota=" + anhmota + ", danhgias=" + danhgias + ", diems=" + diems
				+ ", tainguyens=" + tainguyens + ", sinhviens=" + sinhviens + ", cauhois=" + cauhois + "]";
	}

}