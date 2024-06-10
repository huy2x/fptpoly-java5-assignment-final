package com.DAS.Entity;
//Make by Bình An || AnLaVN || KatoVN

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "DIEM", schema = "dbo", catalog = "DASJ5SQL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Diem{

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "username", column = @Column(name = "USERNAME", nullable = false, length = 64)),
			@AttributeOverride(name = "idkh", column = @Column(name = "IDKH", nullable = false, length = 20)) })
	@NonNull
	private DiemId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDKH", nullable = false, insertable = false, updatable = false)
	@NonNull
	private Khoahoc khoahoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERNAME", nullable = false, insertable = false, updatable = false)
	@NonNull
	private Sinhvien sinhvien;
	
	@Column(name = "DIEM", precision = 53, scale = 0)
	private Double diem;

}