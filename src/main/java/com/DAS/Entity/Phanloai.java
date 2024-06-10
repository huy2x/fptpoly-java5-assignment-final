package com.DAS.Entity;
//Make by Bình An || AnLaVN || KatoVN

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "PHANLOAI", schema = "dbo", catalog = "DASJ5SQL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Phanloai{

	@Id
	@Column(name = "IDPL", unique = true, nullable = false, length = 10)
	@NonNull
	private String idpl;
	
	@Column(name = "TENPL")
	private String tenpl;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phanloai",orphanRemoval = true)
	private Set<Khoahoc> khoahocs = new HashSet<Khoahoc>(0);

}