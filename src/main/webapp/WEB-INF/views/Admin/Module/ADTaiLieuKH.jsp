<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-bordered table-hover table-">
	<tr class="text-center">
		<th>Tên tài liệu</th>
		<th>ID Youtube</th>
		<th>Ảnh video</th>
		<th class="d-none d-lg-table-cell">Mô Tả</th>
		<th></th>
	</tr>
	<tbody id="hienThiTN">
		<c:forEach var="taiNguyen" items="${khoaHoc.tainguyens}">
			<tr style="height: auto;" class="text-center" itemid="${taiNguyen.idtn}">
				<td>${taiNguyen.tentainguyen}</td>
				<td>${taiNguyen.idyoutube}</td>
				<td class="col-2">
					<img src="https://i3.ytimg.com/vi/${taiNguyen.idyoutube}/maxresdefault.jpg" onload="checkYT(this)" width="100%" alt="">
				</td>
				<td class="d-none d-lg-table-cell">${taiNguyen.mota}</td>
				<td>
					<a class="fs-2 text-danger me-4" id="${taiNguyen.idtn}" name="btnXoaTN">
						<i class="fa-sharp fa-solid fa-delete-left"></i>
					</a>
					<a class="fs-2 editTN"  name="editTN">
						<i class="fa-solid fa-pen-to-square"></i>
					</a>
				</td>
			</tr>
	
	</c:forEach>
	</tbody>
</table>