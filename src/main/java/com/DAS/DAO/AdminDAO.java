package com.DAS.DAO;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.data.jpa.repository.JpaRepository;

import com.DAS.Entity.Admin;

public interface AdminDAO extends JpaRepository<Admin, String>{
	
	boolean existsByUsernameAndMatkhau(String username, String matkhau);

}