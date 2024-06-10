package com.DAS.Entity;
//Make by Bình An || AnLaVN || KatoVN

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "SINHVIEN", schema = "dbo", catalog = "DASJ5SQL", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Sinhvien{

	@Id
	@Column(name = "USERNAME", unique = true, nullable = false, length = 64)
	@NonNull
	private String username;
	
	@Column(name = "MATKHAU", length = 64)
	private String matkhau;
	
	@Column(name = "TEN")
	private String ten;
	
	@Column(name = "AVATAR", length = 256)
	private String avatar;
	
	@Column(name = "EMAIL", unique = true, length = 256)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sinhvien", orphanRemoval = true)
	private List<Danhgia> danhgias = new ArrayList<Danhgia>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "KHOAHOC_SINHVIEN", schema = "dbo", catalog = "DASJ5SQL", joinColumns = {
			@JoinColumn(name = "USERNAME", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDKH", nullable = false, updatable = false) })
	private List<Khoahoc> khoahocs = new ArrayList<Khoahoc>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sinhvien", orphanRemoval = true)
	private List<Diem> diems = new ArrayList<Diem>();

}