package com.DAS.ControllerAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DAS.DAO.KhoahocDAO;
import com.DAS.DAO.TainguyenDAO;
import com.DAS.Entity.Cauhoi;
import com.DAS.Entity.Khoahoc;
import com.DAS.Entity.Tainguyen;

@Controller
public class ADTaiNguyenController {
	@Autowired
	KhoahocDAO khoahocDAO;

	@Autowired
	TainguyenDAO tainguyenDAO;
	
	
	@ResponseBody
	@PostMapping("/admin/khoahoc/addTaiNguyen")
	public String addTaiNguyen(Tainguyen tainguyen, @RequestParam("idkh") String idkh) {
		try {
			Khoahoc kh = khoahocDAO.findById(idkh).get();
			tainguyen.setKhoahoc(kh);
			tainguyenDAO.saveAndFlush(tainguyen);
			return getCauHoiHtml(idkh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}
	@ResponseBody
	@PostMapping("/admin/khoahoc/xoaTaiNguyen")
	public String xoaTaiNguyen(@RequestParam("idtn") int idtn, @RequestParam("idkh") String idkh) {
		try {
			tainguyenDAO.deleteById(idtn);
			System.out.println(idkh + "----" + idtn);
			return getCauHoiHtml(idkh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}
	@ResponseBody
	@PostMapping("/admin/khoahoc/updateTaiNguyen")
	public String updateTaiNguyen(Tainguyen tainguyen, @RequestParam("idkh") String idkh) {
		try {

			tainguyen.setKhoahoc(khoahocDAO.findById(idkh).get());
			tainguyenDAO.save(tainguyen);
			System.out.println("Cập nhật thành công");
			 return getCauHoiHtml(idkh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}

	public String getCauHoiHtml(String idkh) {
		List<Tainguyen> tainguyens = tainguyenDAO.findByKhoahoc(khoahocDAO.findById(idkh).get());
		String TaiNguyenTR = "";
		for (Tainguyen tainguyen : tainguyens) {
			TaiNguyenTR += "<tr style=\"height: auto;\" class=\"text-center\" itemid=\""+tainguyen.getIdtn()+"\">\r\n"
					+ "				<td>"+tainguyen.getTentainguyen()+"</td>\r\n"
					+ "				<td>"+tainguyen.getIdyoutube()+"</td>\r\n"
					+ "				<td class=\"col-2\">\r\n"
					+ "					<img src=\"https://i3.ytimg.com/vi/"+tainguyen.getIdyoutube()+"/maxresdefault.jpg\" onload=\"checkYT(this)\" width=\"100%\" alt=\"\">\r\n"
					+ "				</td>\r\n"
					+ "				<td class=\"d-none d-lg-table-cell\">"+tainguyen.getMota()+"</td>\r\n"
					+ "				<td>\r\n"
					+ "					<a class=\"fs-2 text-danger me-4\" id=\""+tainguyen.getIdtn()+"\" name=\"btnXoaTN\">\r\n"
					+ "						<i class=\"fa-sharp fa-solid fa-delete-left\"></i>\r\n"
					+ "					</a>\r\n"
					+ "					<a class=\"fs-2 editTN\"  name=\"editTN\">\r\n"
					+ "						<i class=\"fa-solid fa-pen-to-square\"></i>\r\n"
					+ "					</a>\r\n"
					+ "				</td>\r\n"
					+ "			</tr>";
		}
		return TaiNguyenTR;
	}

}
