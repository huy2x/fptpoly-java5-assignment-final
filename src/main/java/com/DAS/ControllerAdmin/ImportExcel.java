package com.DAS.ControllerAdmin;
//Make by Bình An || AnLaVN || KatoVN

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.AnLa.FILE.Excel;
import com.AnLa.FILE.Log;
import com.DAS.DAO.CauhoiDAO;
import com.DAS.DAO.KhoahocDAO;
import com.DAS.Entity.Cauhoi;
import com.DAS.Entity.Khoahoc;
import com.DAS.Tools.ALParam;

@Controller
@RequestMapping("admin/khoahoc")
public class ImportExcel {
	@Autowired
	KhoahocDAO khoahocDAO;
	
	@Autowired
	CauhoiDAO cauhoiDAO;
	
	
	@ResponseBody
	@PostMapping("/importEX")
	public String SaveExcelData(@RequestParam("idkh") String idkh, @RequestParam("ckImport") boolean rdoMode, @RequestParam("fileEX") MultipartFile pFile){
		
		// Xử lí dữ liệu
		Khoahoc khoahoc = khoahocDAO.findById(idkh).get();	// Lấy thông tin khoá học hiện tại thoe idkh
		
		try { // Lưu file excel câu hỏi
			String  abPath = ALParam.saveFile(pFile, "/File/UserExcel/", idkh+".xlsx").getAbsolutePath();
			Log.add("SaveExcelData - Save Excel file successfully at: " + abPath);	// Thông báo qua Log
			Iterator<Object[]> data = Excel.ReadExcel(abPath, "Sheet1");			// Lấy data từ excel
			if(rdoMode) cauhoiDAO.deleteByKhoahoc(khoahoc);
			while (data.hasNext()) {						// Duyệt từng dòng dữ liệu
				Object[] row = data.next();  				// Lấy dữ liệu trong dòng
				String  cauhoi = String.valueOf(row[0]),
						dapanA = String.valueOf(row[1]),
						dapanB = String.valueOf(row[2]),
						dapanC = String.valueOf(row[3]),
						dapanD = String.valueOf(row[4]),
						dapan  = String.valueOf(row[5]);
				cauhoiDAO.save(new Cauhoi(khoahoc, cauhoi, dapanA, dapanB, dapanC, dapanD, dapan));
			}
			new File(abPath).delete();						// Xoá file excel đã lưu
			Log.add("SaveExcelData - Save data successfully");
			return getCauHoiHtml(idkh);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "false";
	}
	
	
	public String getCauHoiHtml(String idkh) {
		List<Cauhoi> cauHois = cauhoiDAO.findByKhoahoc(khoahocDAO.findById(idkh).get());
		String tabelTR = "";
		for (Cauhoi cauhoi : cauHois) {
			tabelTR += "<tr itemid=\""+cauhoi.getIdch()+"\">\r\n"
					+ "				<td>"+cauhoi.getTencauhoi()+"</td>\r\n"
					+ "				<td>"+cauhoi.getDapana()+"</td>\r\n"
					+ "				<td>"+cauhoi.getDapanb()+"</td>\r\n"
					+ "				<td>"+cauhoi.getDapanc()+"</td>\r\n"
					+ "				<td>"+cauhoi.getDapand()+"</td>\r\n"
					+ "				<td class=\"text-center\">"+cauhoi.getDapandung()+"</td>\r\n"
					+ "				<td class=\"d-flex justify-content-center\">\r\n"
					+ "					<a class=\"fs-2 text-danger me-4\" id=\""+cauhoi.getIdch()+"\" name=\"btnXoaCH\">\r\n"
					+ "						<i class=\"fa-sharp fa-solid fa-delete-left\"></i>\r\n"
					+ "					</a>\r\n"
					+ "					<a class=\"fs-2 editCH\"  name=\"editCH\">\r\n"
					+ "						<i class=\"fa-solid fa-pen-to-square\"></i>\r\n"
					+ "					</a>\r\n"
					+ "				</td>\r\n"
					+ "			</tr>";
		}
		return tabelTR;
	}
}