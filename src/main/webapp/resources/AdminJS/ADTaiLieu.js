$(document).ready(function() {
    taiLieu.addTaiLieu();
    taiLieu.deleteTN();
    taiLieu.editTaiNguyen();
    taiLieu.updateTN();
});



var taiLieu = new function() {
    this.addTaiLieu = function() {
        ///hàm thêm tài liệu cho khóa học
        $('#formAddTaiLieu').off('submit').on('submit', function(e) {
            if (!e.target.checkValidity()) {
                e.preventDefault(); // Ngăn chặn submit form nếu không hợp lệ
                e.stopPropagation(); // Ngăn chặn lan truyền sự kiện
            } else {
                //lấy dữ liệu trên form add câu hỏi
                var formData = new FormData($('#formAddTaiLieu')[0]);
                // lấy id khóa học
                var idkh = $('#idkh').text();
                //gửi request kèm dữ liệu về server
                formData.append('idkh', idkh)
                $.ajax({
                    type: "post",
                    url: "/admin/khoahoc/addTaiNguyen",
                    data: formData,
                    processData: false, // Ngăn việc xử lý dữ liệu formData
                    contentType: false, // Ngăn việc đặt lại header Content
                    dataType: 'html',
                    success: function(response) {
                        $('#hienThiTN').html(response);
                        //add lại sự kiện xóa câu hỏi
                        if (response != "false") {
                            // set lại thông báo của toast
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Thêm mới thành công");
                            $('#formAddTaiLieu')[0].reset();
                        } else {
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        }
                        new bootstrap.Toast(document.getElementById('Toast')).show();
                        $('#addTaiLieu').modal('hide');
                        // gán lại sự kiện cho các hàm
                        taiLieu.addTaiLieu();
                        taiLieu.deleteTN();
                        taiLieu.editTaiNguyen();
                        taiLieu.updateTN();
                    }
                });
            }

            e.target.classList.add('was-validated');

        });
    }


    //sự kiện xóa câu hỏi
    this.deleteTN = function() {
        $('a[name="btnXoaTN"]').off('click').on('click', function(e) {
            // e.preventDefault();
            var idtn = ($(this).attr('id'));
            var idkh = $('#idkh').text();
            $.ajax({
                type: "post",
                url: "/admin/khoahoc/xoaTaiNguyen",
                data: { 'idtn': idtn, 'idkh': idkh },
                dataType: 'html',
                success: function(response) {
                    $('#hienThiTN').html(response);
                    // thây thế html add lại sự kiện
                    if (response != "false") {
                        // set lại thông báo của toast
                        $('#bgToast').addClass("bg-info");
                        $('#message').text("Xóa thành công tài nguyên");
                    } else {
                        $('#bgToast').addClass("bg-info");
                        $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                    }
                    new bootstrap.Toast(document.getElementById('Toast')).show();

                    // gán lại sự kiện cho các hàm
                    taiLieu.addTaiLieu();
                    taiLieu.deleteTN();
                    taiLieu.editTaiNguyen();
                    taiLieu.updateTN();
                }
            });
        });
    }


    this.updateTN = function() {
        $('#formUpdateTaiNguyen').off('submit').on('submit', function(e) {
            if (!e.target.checkValidity()) {
                e.preventDefault(); // Ngăn chặn submit form nếu không hợp lệ
                e.stopPropagation(); // Ngăn chặn lan truyền sự kiện
            } else {
                //lấy dữ liệu trên form add câu hỏi
                var formData = new FormData($('#formUpdateTaiNguyen')[0]);
                //gửi request kèm dữ liệu về server
                var idkh = $('#idkh').text();
                var idtn = $('#CNIdtn').text();
                formData.append('idtn', idtn);
                formData.append('idkh', idkh);
                $.ajax({
                    type: "post",
                    url: "/admin/khoahoc/updateTaiNguyen",
                    data: formData,
                    processData: false, // Ngăn việc xử lý dữ liệu formData
                    contentType: false, // Ngăn việc đặt lại header Content
                    dataType: 'html',
                    success: function(response) {
                        $('#hienThiTN').html(response);
                        if (response != "false") {
                            // set lại thông báo của toast
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Cập nhật thành công");
                        } else {
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        }
                        new bootstrap.Toast(document.getElementById('Toast')).show();
                        $('#updateTaiNguyen').modal('hide');
                        // gán lại sự kiện cho các hàm
                        taiLieu.addTaiLieu();
                        taiLieu.deleteTN();
                        taiLieu.editTaiNguyen();
                        taiLieu.updateTN();
                    }
                });

            }
            e.target.classList.add('was-validated');
        });
    }



    this.editTaiNguyen = function() {
        $('a[name="editTN"]').click(function(e) {
            // e.preventDefault();
            var row = $(this).closest('tr');
            var idtn = $(this).closest('tr').attr('itemid');
            var tentainguyen = row.find('td:nth-child(1)').text();
            var idyoutube = row.find('td:nth-child(2)').text();
            var mota = row.find('td:nth-child(4)').text();

            //hiển thị modal sửa khóa học
            $('#updateTaiNguyen').modal('show');

            //gán gia trị lên form
            $('#CNIdtn').text(idtn);
            $('#tentainguyen').val(tentainguyen);
            $('#idyoutube').val(idyoutube);
            $('#mota').text(mota);

            // Sử dụng các giá trị đã lấy được để thực hiện các thao tác cần thiết
            console.log(idtn, tentainguyen, idyoutube, mota);
        });
    }










}