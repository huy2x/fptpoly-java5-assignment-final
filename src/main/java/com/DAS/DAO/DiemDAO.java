package com.DAS.DAO;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.data.jpa.repository.JpaRepository;

import com.DAS.Entity.Diem;
import com.DAS.Entity.DiemId;

public interface DiemDAO extends JpaRepository<Diem, DiemId>{
	
}