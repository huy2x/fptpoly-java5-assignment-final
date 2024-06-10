$(document).ready(function() {


    // hàm INSERT khóa học gửi request thông qua ajax
    $('#formThemKH').submit(function(e) {
        if (!e.target.checkValidity()) {
            e.preventDefault(); // Ngăn chặn submit form nếu không hợp lệ
            e.stopPropagation(); // Ngăn chặn lan truyền sự kiện
        } else { // không xảy ra lỗi ràng buột form của boostrap -> thực hiện gửi dữ liệu về server
            // set hiển thị màng hình loadding khi update
            if (isValidImage($('#fileAnh').val()) === true) {
                $('#loadingOverlay').css('display', 'flex');
                var formData = new FormData($('#formThemKH')[0]); // Lấy đối tượng form và tạo FormData từ form
                //var serializedData = $('#formUpdateKH').serialize();  // Chuỗi dữ liệu đã mã hóa URL

                formData.append('fileAnh', $('#fileAnh')[0].files[0]);
                $.ajax({
                    url: '/admin/addKH', // Đường dẫn đến server Url xử lý upload
                    type: 'POST',
                    data: formData,
                    processData: false, // Ngăn việc xử lý dữ liệu formData
                    contentType: false, // Ngăn việc đặt lại header Content
                    success: function(response) {
                        $('#loadingOverlay').css('display', 'none');
                        //Kiểm tra xem có xẩy ra ngoại lệ
                        if (response == "true") {
                            // set lại thông báo của toast
                            $('#bgToast').addClass("bg-info");
                            $('#bgToast').removeClass("bg-danger");
                            $('#message').text("Thêm mới thành công");
                        } else if (response == "false") {
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        } else {
                            $('#idkh').addClass("is-invalid");
                            $('#messageID').text("");

                            $('#bgToast').addClass("bg-danger");
                            $('#message').text(response);
                        }
                        new bootstrap.Toast(document.getElementById('Toast')).show();// gọi thông báo toast
                    },
                    error: function(error) {
                        $('#loadingOverlay').css('display', 'none');
                        $('#bgToast').addClass("bg-danger");
                        $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        new bootstrap.Toast(document.getElementById('Toast')).show();
                    }

                });
            } else {
                $('#messageImage').addClass("d-block");
                $('#messageImage').removeClass("d-none");

            }
        }
        e.target.classList.add('was-validated');
    });




    // hàm gửi updateKH gửi request thông qua ajax
    $('#formUpdateKH').submit(function(e) {
        if (!e.target.checkValidity()) {
            e.preventDefault(); // Ngăn chặn submit form nếu không hợp lệ
            e.stopPropagation(); // Ngăn chặn lan truyền sự kiện
        } else { // không xảy ra lỗi ràng buột form của boostrap -> thực hiện gửi dữ liệu về server

            // kiểm tra đúng file ảnh mới gửi request
            if (isValidImage($('#fileAnh').val()) === true) {


                // set hiển thị màng hình loadding khi update
                $('#loadingOverlay').css('display', 'flex');
                var formData = new FormData($('#formUpdateKH')[0]); // Lấy đối tượng form và tạo FormData từ form
                //var serializedData = $('#formUpdateKH').serialize();  // Chuỗi dữ liệu đã mã hóa URL

                formData.append('fileAnh', $('#fileAnh')[0].files[0]);
                $.ajax({
                    url: '/admin/update/' + $('#idkh').text(), // Đường dẫn đến server Url xử lý upload
                    type: 'POST',
                    data: formData,
                    processData: false, // Ngăn việc xử lý dữ liệu formData
                    contentType: false, // Ngăn việc đặt lại header Content-Type
                    success: function(response) {
                        //ẩn loading
                        $('#loadingOverlay').css('display', 'none');
                        $('#messageImage').addClass("d-none");
                        //Kiểm tra xem có xẩy ra ngoại lệ
                        if (response == "true") {
                            // set lại thông báo của toast
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Cập nhật thành công");
                        } else {
                            $('#bgToast').addClass("bg-danger");
                            $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        }
                        new bootstrap.Toast(document.getElementById('Toast')).show();
                    },
                    error: function(xhr, status, error) {
                        $('#loadingOverlay').css('display', 'none');
                        $('#bgToast').addClass("bg-danger");
                        $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        new bootstrap.Toast(document.getElementById('Toast')).show();
                    }

                });
            } else {
                $('#messageImage').addClass("d-block");
                $('#messageImage').removeClass("d-none");

            }
        }
        e.target.classList.add('was-validated');
    });





})




// CHECK KIỂU FILE XEM CÓ PHẢI FILE ẢNH KHÔNG
var isValidImage = function(pathImage) {
    var fileType = pathImage.substr(pathImage.lastIndexOf(".")).toLowerCase();
    if (fileType == ".jpg" || fileType == ".jpeg" || fileType == ".png" || fileType == "") return true
    else return false
}