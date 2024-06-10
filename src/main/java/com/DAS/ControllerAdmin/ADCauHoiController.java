package com.DAS.ControllerAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DAS.DAO.CauhoiDAO;
import com.DAS.DAO.KhoahocDAO;
import com.DAS.Entity.Cauhoi;

@Controller
public class ADCauHoiController {
	@Autowired
	CauhoiDAO cauhoiDAO;

	@Autowired
	KhoahocDAO khoahocDAO;

	@ResponseBody
	@PostMapping("/admin/khoahoc/addCauHoi/{idkh}")
	public String addCauHoi(Cauhoi cauhoi, @PathVariable("idkh") String idkh) {
		
		try {
			cauhoi.setKhoahoc(khoahocDAO.findById(idkh).get());
			cauhoiDAO.save(cauhoi);
			return getCauHoiHtml(idkh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

	@ResponseBody
	@PostMapping("/admin/khoahoc/xoaCH")
	public String xoaCauHoi(@RequestParam("idch") int idch, @RequestParam("idkh") String idkh) {
		try {
			cauhoiDAO.deleteById(idch);
			return getCauHoiHtml(idkh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

	
	
	@ResponseBody
	@PostMapping("/admin/khoahoc/updateCH")
	public String updateCH(Cauhoi cauhoi,@RequestParam("idkh") String idkh
			) {
		try {
			System.out.println(cauhoi.getTencauhoi() + cauhoi.getIdch());
			cauhoi.setKhoahoc(khoahocDAO.findById(idkh).get());
			cauhoiDAO.save(cauhoi);
			
			return getCauHoiHtml(idkh);
		} catch (Exception e) {
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
