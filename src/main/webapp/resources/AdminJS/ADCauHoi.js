$(document).ready(function() {
    cauHoi.addCauHoi();
    cauHoi.deleteCH();
    cauHoi.editcauHoi();
    cauHoi.updateCH();
    cauHoi.ImportCauHoi();
});


var cauHoi = new function() {
    // hàm import excel câu hỏi
    this.ImportCauHoi = function() {
        $('#formImportCH').off('submit').on('submit', function(e) {
            if (!e.target.checkValidity()) {
                e.preventDefault(); // Ngăn chặn submit form nếu không hợp lệ
                e.stopPropagation(); // Ngăn chặn lan truyền sự kiện
            } else {
                //lấy dữ liệu trên form add câu hỏi
                var formData = new FormData($('#formImportCH')[0]);
                //gửi request kèm dữ liệu về server
                formData.append('idkh', $('#idkh').text());
                $.ajax({
                    type: "post",
                    url: "/admin/khoahoc/importEX",
                    data: formData,
                    processData: false, // Ngăn việc xử lý dữ liệu formData
                    contentType: false, // Ngăn việc đặt lại header Content
                    dataType: 'html',
                    success: function(response) {
                        $('#hienThiCH').html(response);
                        //add lại sự kiện xóa câu hỏi
                        if (response != "false") {
                            // set lại thông báo của toast
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Thêm mới thành công");
                            $('#formImportCH')[0].reset();
                        } else {
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        }
                        new bootstrap.Toast(document.getElementById('Toast')).show();
                        $('#importExcel').modal('hide');
                        // gán lại sự kiện cho các hàm
                        cauHoi.deleteCH();
                        cauHoi.addCauHoi();
                        cauHoi.editcauHoi();
                        cauHoi.updateCH();
                    }
                });

            }

            e.target.classList.add('was-validated');
            //reset form

        });
    }



    // hàm thêm 
    this.addCauHoi = function() {
        $('#formAddCauHoi').off('submit').on('submit', function(e) {
            if (!e.target.checkValidity()) {
                e.preventDefault(); // Ngăn chặn submit form nếu không hợp lệ
                e.stopPropagation(); // Ngăn chặn lan truyền sự kiện
            } else {
                //lấy dữ liệu trên form add câu hỏi
                var formData = new FormData($('#formAddCauHoi')[0]);
                //gửi request kèm dữ liệu về server
                $.ajax({
                    type: "post",
                    url: "/admin/khoahoc/addCauHoi/" + $('#idkh').text(),
                    data: formData,
                    processData: false, // Ngăn việc xử lý dữ liệu formData
                    contentType: false, // Ngăn việc đặt lại header Content
                    dataType: 'html',
                    success: function(response) {
                        $('#hienThiCH').html(response);
                        //add lại sự kiện xóa câu hỏi
                        if (response != "false") {
                            // set lại thông báo của toast
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Thêm mới thành công");
                            $('#formAddCauHoi')[0].reset();
                        } else {
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        }
                        new bootstrap.Toast(document.getElementById('Toast')).show();
                        $('#addCauHoi').modal('hide');
                        // gán lại sự kiện cho các hàm
                        cauHoi.deleteCH();
                        cauHoi.addCauHoi();
                        cauHoi.editcauHoi();
                        cauHoi.updateCH();
                    }
                });

            }

            e.target.classList.add('was-validated');
            //reset form

        });
    }


    //sự kiện xóa câu hỏi
    this.deleteCH = function() {
        $('a[name="btnXoaCH"]').off('click').on('click', function(e) {
            // e.preventDefault();
            var idch = ($(this).attr('id'));
            var idkh = $('#idkh').text();
            $.ajax({
                type: "post",
                url: "/admin/khoahoc/xoaCH",
                data: { 'idch': idch, 'idkh': idkh },
                dataType: 'html',
                success: function(response) {
                    $('#hienThiCH').html(response);
                    // thây thế html add lại sự kiện
                    if (response != "false") {
                        // set lại thông báo của toast
                        $('#bgToast').addClass("bg-info");
                        $('#message').text("Xóa thành công câu hỏi");
                    } else {
                        $('#bgToast').addClass("bg-info");
                        $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                    }
                    new bootstrap.Toast(document.getElementById('Toast')).show();

                    // gán lại sự kiện cho các hàm
                    cauHoi.deleteCH();
                    cauHoi.addCauHoi();
                    cauHoi.editcauHoi();
                    cauHoi.updateCH();
                }
            });
        });
    }

    this.updateCH = function() {
        $('#formCapNhatCH').off('submit').on('submit', function(e) {
            if (!e.target.checkValidity()) {
                e.preventDefault(); // Ngăn chặn submit form nếu không hợp lệ
                e.stopPropagation(); // Ngăn chặn lan truyền sự kiện
            } else {
                //lấy dữ liệu trên form add câu hỏi
                var formData = new FormData($('#formCapNhatCH')[0]);
                //gửi request kèm dữ liệu về server
                var idkh = $('#idkh').text();
                var idch = $('#CNIdCauHoi').text();
                formData.append('idch', idch);
                formData.append('idkh', idkh);
                $.ajax({
                    type: "post",
                    url: "/admin/khoahoc/updateCH",
                    data: formData,
                    processData: false, // Ngăn việc xử lý dữ liệu formData
                    contentType: false, // Ngăn việc đặt lại header Content
                    dataType: 'html',
                    success: function(response) {
                        $('#hienThiCH').html(response);
                        //add lại sự kiện xóa câu hỏi
                        if (response != "false") {
                            // set lại thông báo của toast
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Cập nhật thành công");
                        } else {
                            $('#bgToast').addClass("bg-info");
                            $('#message').text("Có lỗi xảy ra trong quá trình xử lý !");
                        }
                        new bootstrap.Toast(document.getElementById('Toast')).show();
                        $('#updateCauHoi').modal('hide');
                        // gán lại sự kiện cho các hàm
                        cauHoi.deleteCH();
                        cauHoi.addCauHoi();
                        cauHoi.editcauHoi();
                        cauHoi.updateCH();
                    }
                });

            }
            e.target.classList.add('was-validated');
        });
    }



    /// HIỂN THỊ VALUE LÊN MODAL CẬP NHẬT CÂU HỎI
    this.editcauHoi = function() {
        $('a[name="editCH"]').click(function(e) {
            // e.preventDefault();
            var row = $(this).closest('tr');
            var idch = $(this).closest('tr').attr('itemid');
            var tenCauHoi = row.find('td:nth-child(1)').text();
            var dapAnA = row.find('td:nth-child(2)').text();
            var dapAnB = row.find('td:nth-child(3)').text();
            var dapAnC = row.find('td:nth-child(4)').text();
            var dapAnD = row.find('td:nth-child(5)').text();
            var dapAnDung = row.find('td:nth-child(6)').text();

            //hiển thị modal sửa khóa học
            $('#updateCauHoi').modal('show');
            //gán gia trị lên form
            $('#CNIdCauHoi').text(idch);
            $('#cauhoi').val(tenCauHoi);
            $('#dapana').val(dapAnA);
            $('#dapanb').val(dapAnB);
            $('#dapanc').val(dapAnC);
            $('#dapand').val(dapAnD);
            $('#dapandung').val(dapAnDung);
            // Sử dụng các giá trị đã lấy được để thực hiện các thao tác cần thiết
            console.log(idch, tenCauHoi, dapAnA, dapAnB, dapAnC, dapAnD, dapAnDung);
        });
    }
}