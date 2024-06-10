package com.DAS.DAO;
//Make by Bình An || AnLaVN || KatoVN

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.DAS.Entity.Cauhoi;
import com.DAS.Entity.Khoahoc;

public interface CauhoiDAO extends JpaRepository<Cauhoi, Integer>{
	
	List<Cauhoi> findByKhoahoc(Khoahoc khoahoc);
	
	@Transactional
	void deleteByKhoahoc(Khoahoc khoahoc);
}