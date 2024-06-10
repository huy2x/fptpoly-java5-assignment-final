package com.DAS.Entity;
//Make by Bình An || AnLaVN || KatoVN

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CAUHOI", schema = "dbo", catalog = "DASJ5SQL")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Cauhoi{
	@Id
	@Column(name = "IDCH", unique = true, nullable = false, length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idch;
	
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDKH")
	private Khoahoc khoahoc;
	
	@NonNull
	@Column(name = "TENCAUHOI")
	private String tencauhoi;
	@NonNull
	@Column(name = "DAPANA")
	private String dapana;
	
	@NonNull
	@Column(name = "DAPANB")
	private String dapanb;
	
	@NonNull
	@Column(name = "DAPANC")
	private String dapanc;
	
	
	@NonNull
	@Column(name = "DAPAND")
	private String dapand;
	
	
	@NonNull
	@Column(name = "DAPANDUNG", length = 1)
	private String dapandung;
	
	
	
	
	@Override
	public String toString() {
		return "tencauhoi [idch=" + idch + ", khoahoc=" + khoahoc + ", tencauhoi=" + tencauhoi + ", dapana=" + dapana
				+ ", dapanb=" + dapanb + ", dapanc=" + dapanc + ", dapand=" + dapand + ", dapandung=" + dapandung + "]";
	}
	
	


	

}