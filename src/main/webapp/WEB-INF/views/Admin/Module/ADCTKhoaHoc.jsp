<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Hiển thị thông báo khi cập nhật -->
<div class="toast-container position-fixed top-0 end-0 p-3 mt-5">
	<div id="Toast" class="toast align-items-center mt-2" role="alert">
		<div class="d-flex" id="bgToast" style="border-radius: 5px">
			<div class="toast-body fw-bold text-white" id="message"></div>
			<button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast"></button>
		</div>
	</div>
</div>

<div id="loadingOverlay">
  <div class="loading-spinner"></div>
</div>
<div id="message"></div>
<div class="py-3 mx-3">
	<a href="/admin/khoahoc" class="text-black-50 h6">Khóa học</a><span class="mx-2">/</span><a href="/admin/khoahoc/${khoaHoc.idkh}" class="h6"
		style="color: blue;">Chi tiết khóa học</a>
</div>
<div class="row m-0">
	<h3 class="ms-2 fw-bold" style="font-family: 'Courier New', Courier, monospace; text-shadow: 2px 3px 4px gray;">Quản trị khóa học</h3>
	<!-- form chỉnh sửa khóa học -->
	<div class="col-12">
		<form class="row ms-2" novalidate="novalidate" id="formUpdateKH" method="post" enctype="multipart/form-data">
			<div class="col-12 mt-5 mt-sm-5 mt-lg-4 col-lg-4 col-xxl-3">
				<div class="mt-4 mt-md-5 mt-xxl-5 col-12 text-center">
					<h4 id="idkh" >${khoaHoc.idkh}</h4>
				</div>
				<div class="mb-0">
					<c:if test="${khoaHoc.anhmota!=null}">
						<a href="#"> <img width="100%" id="imageKH" class="img-fluid img-thumbnail" src="${khoaHoc.anhmota}" alt="">
						</a>
					</c:if>
					<c:if test="${khoaHoc.anhmota==null}">
						<a href="#"> <img width="100%" id="imageKH" class="img-fluid img-thumbnail"
							src="https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg" alt="">
						</a>
					</c:if>
				</div>
				<div class=" col-12 col-lg-12  d-flex justify-content-center my-3 ">
					<input class="form-control" name="fileAnh" onchange="getFilePath()" type="file" id="fileAnh" accept=".jpg,.png"  >
				</div>
				<span class="text-danger fw-bold d-none" id="messageImage">Vui lòng chọn file ảnh !</span>
			</div>
			<div class="col-12 col-lg-8 col-xxl-4">
				<div class="mb-3 mt-2 mt-lg-5 mt-xxl-5">
					<label for="tenKhoaHoc" class="form-label">Tên khóa học</label>
					<input type="text" class="form-control" name="tenkhoahoc" value="${khoaHoc.tenkhoahoc}" required="required" id="tenKhoaHoc"
						placeholder="Nhập tên khóa học">
				</div>
				<div class="mb-3">
					<label for="tenKhoaHoc" class="form-label">Phân loại</label> <select required="required" name="phanloai" id="phanLoai" class="form-select">
						<c:forEach var="phanloai" items="${phanLoai}">
							<option ${phanloai.idpl == khoaHoc.phanloai.idpl?'selected="selected"':''} value="${phanloai.idpl}">${phanloai.tenpl}</option>
						</c:forEach>
						<!-- Thêm các tùy chọn khác tại đây -->
					</select>
				</div>
				<div class="mb-3">
					<label for="moTa" class="form-label">Mô tả</label>
					<textarea class="form-control" name="motangan" style="height: 185px" id="moTaNgan" rows="3" placeholder="Nhập mô tả khóa học">${khoaHoc.motangan}</textarea>
				</div>

			</div>
			<div class="col-12 col-xxl-5">
				<div class="mb-3 mt-2 mt-lg-3 mt-xxl-5">
					<label for="moTaCT" class="form-label">Mô tả chi tiết</label>
					<textarea class="form-control" name="mota" style="height: 350px" id="moTaCT" rows="3" placeholder="Nhập mô tả khóa học">${khoaHoc.mota}</textarea>
					<div class="d-flex justify-content-end mt-3">
						<button class="btn btn-danger fw-bold col-3 me-2" type="button" data-bs-toggle="modal" data-bs-target="#xoaKH">Xóa KH</button>
						<button class="btn btn-info fw-bold col-3" type="submit" id="formUpdateKH1">Lưu</button>
					</div>
				</div>
			</div>
			<div class="modal fade" id="xoaKH" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header p-1 px-3"
							style="background-image: url('https://static.vecteezy.com/system/resources/previews/000/155/103/original/vector-grunge-danger-caution-background.jpg'); background-size: cover; width: 100%;">
							<h1 class="modal-title fs-2 text-danger fw-bold" id="staticBackdropLabel">Cảnh báo</h1>
						</div>
						<div class="modal-body p-0" style="background-color: yellow;">
							<div class="d-flex justify-content-center mb-3">
								<img class="col-4" src="../../../../Image/warning.gif" width="100%" />
							</div>
							<div>
								<h6 class="text-danger p-3">
									1.Mất dữ liệu: Một khi khóa học dữ liệu bị xóa, tất cả các thông tin, tài liệu, bài giảng và tài nguyên liên quan sẽ bị mất vĩnh viễn. Bất kỳ
									công trình nghiên cứu, bài tập, hoặc dữ liệu quan trọng liên quan đến khóa học đó sẽ không thể phục hồi được. Xin hãy cân nhắc kỹ trước khi
									tiếp tục. <br>
									<br> 2.Không thể hoàn tác: Sau khi bạn xóa khóa học, không có cách nào để khôi phục lại dữ liệu đã bị xóa. Chúng tôi không thể phục hồi
									hoặc khôi phục lại bất kỳ thông tin nào. Điều này có nghĩa là tất cả những công sức và thời gian bạn đã dành cho việc tạo và phát triển khóa
									học sẽ bị mất một cách vĩnh viễn. <br>
									<br> 3.Ảnh hưởng đến người học: Việc xóa một khóa học dữ liệu sẽ ảnh hưởng đến người học của bạn. Họ sẽ không thể tiếp tục truy cập vào
									tài liệu, bài giảng và tài nguyên mà bạn đã cung cấp. Điều này có thể gây thất vọng và bất tiện cho họ, đồng thời ảnh hưởng đến quyết định
									của họ trong việc theo học và phát triển.
								</h6>
							</div>
						</div>
						<div class="modal-footer p-1"
							style="background-image: url('https://static.vecteezy.com/system/resources/previews/000/155/103/original/vector-grunge-danger-caution-background.jpg'); background-size: cover; width: 100%;">
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
							<a href="/admin/removeKH/${khoaHoc.idkh}" class="btn btn-danger">Đồng ý</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- Các nút thêm khóa học và import export  -->
	<div class="col-12 mt-0 mt-xxl-4">
		<div class="mt-3 p-2">
			<ul class="list-group row list-group-horizontal">
				<li class="col-6 col-xl-3 border-0 bg-body-tertiary list-group-item d-flex justify-content-center">
					<button id="btnAddTaiLieu" data-bs-toggle="modal" data-bs-target="#addTaiLieu" class="btn btn-outline-success fw-bold  col-10">
						<i class="fa-solid fa-plus me-2"></i>Thêm tài liệu
					</button>
				</li>
				<li class="col-6 col-xl-3 border-0 bg-body-tertiary list-group-item d-flex justify-content-center">
					<button id="btnAddCauHoi" data-bs-toggle="modal" data-bs-target="#addCauHoi" class=" btn btn-outline-success fw-bold  col-10">
						<i class="fa-solid fa-plus me-2"></i>Thêm câu hỏi
					</button>
				</li>
				<li class="col-6 col-xl-3 border-0 bg-body-tertiary list-group-item d-flex justify-content-center">
					<button class="btn btn-outline-success fw-bold  col-10" data-bs-toggle="modal" data-bs-target="#importExcel">
						<i class="fa-solid fa-file-import me-2"></i>Import Excel
					</button>
				</li>
				<li class="col-6 col-xl-3 border-0 bg-body-tertiary list-group-item d-flex justify-content-center">
					<button class="btn btn-outline-success fw-bold  col-10">
						<i class="fa-solid fa-file-export me-2"></i>Export Excel
					</button>
				</li>
			</ul>
		</div>
	</div>
		<!-- Modal sửa câu hỏi -->
	<div class="modal fade" id="updateCauHoi" tabindex="-1" ><jsp:include page="../Modal/MDCapNhatCauHoi.jsp"></jsp:include></div>
	<!-- Modal Các nút thêm khóa học và import export -->
	<div class="modal fade" id="addCauHoi" tabindex="-1" ><jsp:include page="../Modal/MDThemCauHoi.jsp"></jsp:include></div>
	
	<div class="modal fade" id="addTaiLieu" tabindex="-1"><jsp:include page="../Modal/MDThemTaiLieu.jsp"></jsp:include></div>
	
	<div class="modal fade" id="updateTaiNguyen" tabindex="-1"><jsp:include page="../Modal/MDCapNhatTaiLieu.jsp"></jsp:include></div>
	
	<div class="modal fade" id="importExcel" tabindex="-1"><jsp:include page="../Modal/MDImportEX.jsp"></jsp:include></div>
	
	<div class="col-11 mx-auto">
		<hr>
	</div>
	<!-- accordion Table hiển thị tài liệu và câu hỏi khóa học -->
	<div>
		<div class="accordion">
			<div class="accordion-item">
				<h2 class="accordion-header fw-bold">
					<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne">
						<h4 class="fw-bold">Bộ tài liệu khóa học</h4>
					</button>
				</h2>
				<div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse">
					<div class="accordion-body p-0">
						<div>
							<jsp:include page="ADTaiLieuKH.jsp"></jsp:include>
						</div>
					</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header">
					<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo">
						<h4 class="fw-bold">Bộ câu hỏi kiểm tra</h4>
					</button>
				</h2>
				<div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
					<div class="accordion-body p-0">
						<div class="p-0">
							<jsp:include page="ADBoCauHoi.jsp"></jsp:include>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>