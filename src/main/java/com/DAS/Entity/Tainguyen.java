package com.DAS.Entity;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "TAINGUYEN", schema = "dbo", catalog = "DASJ5SQL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping
public class Tainguyen {

	@Id
	@Column(name = "IDTN", unique = true, nullable = false, length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDKH")
	@NonNull
	private Khoahoc khoahoc;
	
	@Column(name = "TENTAINGUYEN")
	@NonNull
	private String tentainguyen;
	
	@Column(name = "IDYOUTUBE", length = 11)
	@NonNull
	private String idyoutube;
	
	@Column(name = "MOTA")
	@NonNull
	private String mota;

}