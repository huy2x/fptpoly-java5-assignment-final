package com.DAS.DAO;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DAS.Entity.Sinhvien;

public interface SinhvienDAO extends JpaRepository<Sinhvien, String> {
	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsernameAndMatkhau(String username, String matkhau);

	@Query(value = "SELECT dbo.FN_FIND_SV_KH(?1, ?2)", nativeQuery = true)
	boolean isExistsSV_KH(String username, String idkh);

	Sinhvien findByEmail(String email);

	// Tiến sỹ
	//xóa sinh viên ra khỏi khóa học
	@Query(value = "DELETE FROM KHOAHOC_SINHVIEN WHERE idkh = ?1",nativeQuery = true)
	void deleteSVRaKhoaHoc(String idkh);
	// -------------------
}