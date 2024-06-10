package com.DAS.DAO;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.data.jpa.repository.JpaRepository;

import com.DAS.Entity.Danhgia;
import com.DAS.Entity.DanhgiaId;

public interface DanhgiaDAO extends JpaRepository<Danhgia, DanhgiaId>{

}