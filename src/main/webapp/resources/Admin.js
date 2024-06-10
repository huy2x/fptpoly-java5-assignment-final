//lấy đường dẫn file image up lên để hiển thị trước khi gửi về server'
function getFilePath() {
	var fileInput = document.getElementById('fileAnh');
	var file = fileInput.files[0];
	var filePath = URL.createObjectURL(file);
	document.getElementById('imageKH').setAttribute('src', filePath);
	console.log(filePath);
}

