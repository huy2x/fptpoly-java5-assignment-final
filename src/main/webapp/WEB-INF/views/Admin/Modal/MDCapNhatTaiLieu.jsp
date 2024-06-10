<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">Cập nhật tài nguyên <span id="CNIdtn"></span></h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body">
			<form method="post" id="formUpdateTaiNguyen" novalidate="novalidate" >
				<div class="col-8 mx-auto d-flex justify-content-center">
					<img class="img-fluid " width="80%" src="{{'https://i3.ytimg.com/vi/'+IDVideo+'/maxresdefault.jpg'}}" onload="checkYT(this)">
				</div>
				<div class="mb-3">
					<label for="resource-name" class="form-label">Tên tài nguyên</label>
					<input type="text" name="tentainguyen" maxlength="128" class="form-control" required="required" id="tentainguyen" placeholder="Nhập tên tài nguyên">
					<div class="invalid-feedback">Vui lòng nhập tên tài nguyên !</div>
				</div>
				<label for="" class="form-label">ID Youtube</label>
				<div class="input-group mb-4 has-validation">
					<span class="input-group-text">https://www.youtube.com/watch?v=</span>
					<input type="text" maxlength="11" class="form-control" name="idyoutube" id="idyoutube" ng-init="IDVideo=''" ng-model="IDVideo" placeholder="IDYoutube" required>
					<div class="invalid-feedback">Vui lòng nhập ID Youtube !</div>
				</div>
				<div class="mb-3">
					<label for="description" class="form-label">Mô tả</label>
					<textarea class="form-control" maxlength="1024" name="mota" id="mota" rows="4" placeholder="Nhập mô tả"></textarea>
				</div>
				<div class="mt-2 d-flex justify-content-end column-gap-2">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary">Cập nhật</button>
				</div>
			</form>
		</div>
	</div>
</div>