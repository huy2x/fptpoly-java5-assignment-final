package com.DAS.DAO;
//Make by Bình An || AnLaVN || KatoVN

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DAS.Entity.Khoahoc;
import com.DAS.Entity.Tainguyen;

public interface TainguyenDAO extends JpaRepository<Tainguyen, Integer>{
	List<Tainguyen> findByKhoahoc(Khoahoc khoahoc);
}