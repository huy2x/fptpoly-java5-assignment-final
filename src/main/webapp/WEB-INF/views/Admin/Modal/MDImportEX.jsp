<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<h1 class="modal-title fs-5" id="exampleModalLabel">Import Excel Câu hỏi</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body">
			<form novalidate="novalidate" id="formImportCH" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="fileInput" class="form-label">Chọn file Excel.</label>
					<input class="form-control" type="file" name="fileEX" id="fileInput" accept=".xlsx" required="required">
				</div>

				<div class="mb-3">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="ckImport" id="option1" value="true">
						<label class="form-check-label" for="option1">Thây thế dữ liệu cũ ?</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio"  checked="checked" name="ckImport" id="option2" value="false">
						<label class="form-check-label" for="option2">Giữ lại dữ liệu cũ ?</label>
					</div>
				</div>
				<div class="mb-3">
					<h4 class="fw-bold text-danger">Lưu ý:</h4>
					<h6 class="text-danger">1.Tên Sheet phải được đặt là "Sheet 1"</h6>
				</div>

				<button type="submit" class="btn btn-primary">Import</button>
			</form>
		</div>
	</div>
</div>