<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="modal-dialog modal-dialog-centered" style="max-width: 800px;">
	<div class="modal-content">
		<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">Thêm câu hỏi</h1>
		</div>
		<div class="modal-body">
			<form novalidate="novalidate" id="formAddCauHoi" class="row" method="POST">
				<div class="mb-3 col-12">
					<label for="dapana" class="form-label">Câu hỏi</label>
					<textarea class="form-control" id="cauhoi" name="tencauhoi" rows="3" maxlength="256" required></textarea>
					<div class="invalid-feedback" >Vui lòng nhập tên câu hỏi !</div>
				</div>
				<div class="mb-3 col-6">
					<label for="dapana" class="form-label">Đáp Án A</label>
					<textarea class="form-control" id="dapana" name="dapana" rows="3" maxlength="256" required></textarea>
					<div class="invalid-feedback" >Vui lòng nhập đáp án !</div>
				</div>
				<div class="mb-3 col-6">
					<label for="dapanb" class="form-label">Đáp Án B</label>
					<textarea class="form-control" id="dapanb" name="dapanb" rows="3" maxlength="256" required></textarea>
					<div class="invalid-feedback" >Vui lòng nhập đáp án !</div>
				</div>
				<div class="mb-3 col-6">
					<label for="dapanc" class="form-label">Đáp Án C</label>
					<textarea class="form-control" id="dapanc" name="dapanc" rows="3" maxlength="256" required></textarea>
					<div class="invalid-feedback">Vui lòng nhập đáp án !</div>
				</div>
				<div class="mb-3 col-6">
					<label for="dapand" class="form-label">Đáp Án D</label>
					<textarea class="form-control" id="dapand" name="dapand" rows="3" maxlength="256" required></textarea>
					<div class="invalid-feedback">Vui lòng nhập đáp án !</div>
				</div>
				<div class="mb-3 col-6">
					<label for="dapandung" class="form-label">Đáp Án Đúng</label> <select class="form-select" id="dapandung" name="dapandung" required>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
					</select>
				</div>
				<div class="d-flex justify-content-end col-6 mt-4">
					<button type="submit" class="btn btn-primary me-2 col-6 fw-bold" style="height: 50px">Thêm</button>
					<button class="btn btn-secondary col-6 fw-bold" type="button"style="height: 50px"  data-bs-dismiss="modal">Hủy</button>
				</div>
			</form>
		</div>
	</div>
</div>
