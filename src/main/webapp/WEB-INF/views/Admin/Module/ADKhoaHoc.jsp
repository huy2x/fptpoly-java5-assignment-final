<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="toast-container position-fixed top-0 end-0 p-3 mt-5">
	<div id="Toast" class="toast align-items-center mt-2" role="alert">
		<div class="d-flex bg-info" style="border-radius: 5px">
			<div class="toast-body fw-bold">Xóa thành công khóa học</div>
			<button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast"></button>
		</div>
	</div>
</div>
<c:if test="${message}">
	<script>
		new bootstrap.Toast(document.getElementById('Toast')).show()
	</script>
</c:if>
<h3 class="mt-3 fw-bold ms-3" style="font-family: 'Courier New', Courier;">DANH SÁCH KHÓA HỌC</h3>
<div class="row p-0 m-0">
	<div class="col-10 col-md-6 col-lg-4 mx-auto mt-2">
		<!--  <div class="input-group mb-3 ms-0">
			<input type="text" class="form-control" style="border-radius: 20px 0px 0 20px; border-right: 0px;" placeholder="Tìm kiếm">
			<a class="input-group-text bg-white" id="basic-addon1" href="#" style="text-decoration: none; border-radius: 0px 20px 20px 0px;"><i
				class="fa-solid fa-magnifying-glass me-2"></i></a>
		</div>
	</div>
	<div class="col-10 col-md-6 col-lg-3 col-xl-2 mt-2 mx-auto d-block">
		<div class="col-12 float-end ">
			<select required="required" id="course-filter" name="phanloai" class="form-select">
				<option value="">Tất cả</option>
				<c:forEach var="phanloai" items="${phanLoai}">
					<option value="${phanloai.idpl}">${phanloai.tenpl}</option>
				</c:forEach>
			</select>
		</div>-->
	</div>
	<div class="col-10 mx-auto col-lg-2 mt-3 mt-lg-0">
		<a href="/admin/addKH" class="btn btn-outline-info mt-2 fw-bold col-12" style="border-radius: 20px 20px 20px 20px;" id="themMoi"> <i
			class="fa-solid fa-plus me-2"></i>Thêm mới
		</a>
	</div>
</div>
<hr>

<div class="row gap-3 d-flex justify-content-center m-0 p-0">
	<!--Hiển thị box khóa học -->
	<c:forEach var="khoaHoc" items="${listKhoaHoc.content}">
		<div class="card col-9  col-md-5 col-xl-3 p-2 mt-4 box-KH card-KH">
			<a href="/admin/khoahoc/${khoaHoc.idkh}">
				<div class="card-img p-0 ">
					<img style="border-radius: 20px;" src="${khoaHoc.anhmota}" width="100%" alt="">
				</div>
				<div class="card-body pb-0" style="border-radius: 20px;">
					<h6 class="text-black-50">${khoaHoc.phanloai.tenpl}</h6>
					<h5 style="color: rgb(153, 45, 224); font-family: Calibri;" class="fw-bold">${khoaHoc.tenkhoahoc}</h5>
				</div>
			</a>
		</div>
	</c:forEach>
	<nav aria-label="Page navigation example" class="d-flex justify-content-center">
		<ul class="pagination">
			<c:forEach var="pageNo" begin="0" end="${listKhoaHoc.totalPages <= 0 ?0:listKhoaHoc.totalPages-1}">
				<li class="page-item ${indexPage == pageNo ?'active':''}"><a href="/admin/khoahoc?pageNo=${pageNo}" class="page-link">${pageNo+1}</a></li>
			</c:forEach>
		</ul>
	</nav>
</div>

