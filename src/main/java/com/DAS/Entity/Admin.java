package com.DAS.Entity;
//Make by Bình An || AnLaVN || KatoVN

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADMIN", schema = "dbo", catalog = "DASJ5SQL", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin{

	@Id
	@Column(name = "USERNAME", unique = true, nullable = false, length = 64)
	private String username;
	
	@Column(name = "MATKHAU", length = 64)
	private String matkhau;
	
	@Column(name = "TEN")
	private String ten;
	
	@Column(name = "EMAIL", unique = true, length = 256)
	private String email;

}