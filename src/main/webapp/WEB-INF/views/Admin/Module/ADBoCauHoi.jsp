<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<table class="table table-bordered table-hover" id="tableCauHoi">
	<tr class="text-center">
		<th>Câu hỏi</th>
		<th>Đáp án A</th>
		<th>Đáp án B</th>
		<th>Đáp án C</th>
		<th>Đáp án D</th>
		<th>Đáp án đúng</th>
		<th></th>
	</tr>
	<tbody id="hienThiCH">
		<c:forEach var="cauhoi" items="${khoaHoc.cauhois}">
			<tr itemid="${cauhoi.idch}">
				<td>${cauhoi.tencauhoi}</td>
				<td>${cauhoi.dapana}</td>
				<td>${cauhoi.dapanb}</td>
				<td>${cauhoi.dapanc}</td>
				<td>${cauhoi.dapand}</td>
				<td class="text-center">${cauhoi.dapandung}</td>
				<td class="d-flex justify-content-center">
					<a class="fs-2 text-danger me-4" id="${cauhoi.idch}" name="btnXoaCH">
						<i class="fa-sharp fa-solid fa-delete-left"></i>
					</a>
					<a class="fs-2 editCH"  name="editCH">
						<i class="fa-solid fa-pen-to-square"></i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

