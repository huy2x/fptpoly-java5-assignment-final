package com.DAS.ControllerUser;
//Make by Bình An || AnLaVN || KatoVN

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AnLa.FILE.Log;
import com.DAS.DAO.DiemDAO;
import com.DAS.DAO.KhoahocDAO;
import com.DAS.DAO.SinhvienDAO;
import com.DAS.Entity.Cauhoi;
import com.DAS.Entity.Diem;
import com.DAS.Entity.DiemId;
import com.DAS.Entity.Khoahoc;
import com.DAS.Entity.Sinhvien;
import com.DAS.Tools.ALParam;
import com.DAS.Tools.ALSession;

@Controller
@RequestMapping("/Exam")
public class Exam {
	@Autowired
	KhoahocDAO khoahocDAO;
	@Autowired
	SinhvienDAO sinhvienDAO;
	@Autowired
	DiemDAO diemDAO;
	
	@GetMapping("/{idkh}")
	public String ExamGET(@PathVariable("idkh") String idkh, Model model) {
		// Xử lí dữ liệu
		String idsv = ((Sinhvien) ALSession.getSession("userSV")).getUsername();// Lấy idsv hiện tại
		Diem diem = diemDAO.findById(new DiemId(idsv, idkh)).orElse(null);		// Lấy điểm theo idsv và idkh, nếu chưa thi thì gán null
		Khoahoc course = khoahocDAO.findById(idkh).get();						// Lấy khoá học theo idkh

		// Set dữ liệu qua view
		model.addAttribute("Course", course);
		model.addAttribute("Mark", diem != null ? diem.getDiem() : 0.0);
		
		// Thông báo qua Log
		Log.add("ExamGET - Exam Course " + idkh + " by " + idsv);
		return "User/Exam";
	}
	
	@PostMapping("/{idkh}")
	public String ExamPOST(@PathVariable("idkh") String idkh, Model model) {
		// Xử lí dữ liệu
		String idsv = ((Sinhvien) ALSession.getSession("userSV")).getUsername();// Lấy idsv hiện tại
		Sinhvien sv = sinhvienDAO.findById(idsv).get();							// Lấy sinhvien theo idsv
		Khoahoc khoahoc = khoahocDAO.findById(idkh).get();						// Lấy khoá học theo idkh
		List<Cauhoi> listCauhoi = khoahoc.getCauhois();							// Lấy list câu hỏi của khoá học
		int size = listCauhoi.size();											// Lấy kích thước của bộ câu hỏi
		double  mark = 100.0 / size,											// Tính điểm trung bình từng cầu
				totalMark = 0.0;												// Biến chứa tổng điểm.
		
		for(int i = 0 ; i < size ; i++) {	// Duyệt tất cả câu hỏi, nếu trùng đáp án thì lấy điểm trung bình cộng dồn vào tổng điềm
			boolean isMatch = ALParam.getString("AnswerOfSentence"+i).equalsIgnoreCase(listCauhoi.get(i).getDapandung());
			if(isMatch) totalMark += mark;
		}
		
		// Lưu dữ liệu vào csdl
		Diem diem = new Diem(new DiemId(idsv, idkh), khoahoc, sv, totalMark);
		diemDAO.save(diem);
		sv.getDiems().add(diem);
		sinhvienDAO.save(sv);
		
		// Thông báo qua Log
		Log.add("ExamPOST - Username " + idsv + " submit exam of course " + idkh + " with " + totalMark + " mark");
		return "redirect:/Exam/"+idkh;
	}
}