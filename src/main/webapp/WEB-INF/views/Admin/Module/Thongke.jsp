<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.js"></script>
    <link rel="icon" type="image/x-icon" href="/Image/Logo.png">
    <title>Thống kê</title>
    <link href="/resources/style.css" rel="stylesheet">
    <script src="/resources/script.js"></script>
</head>
-->
<body class="d-flex flex-column h-100">

	<div class="GH text-center m-4">${sizeCourses} COURSES</div>
	<div class="h4 text-center m-4" ng-show="${sizeCourses} == 0">Không có khoá học nào</div>
	<div class="TableItem" ng-hide="${sizeCourses} == 0">
		<div class="row text-center m-0" style="border-bottom: 2px solid #E8E8E1;">
			<div class="col-3 col-md-3 col-xl-2 d-none d-md-block p-0 pb-3"></div>
			<div class="col-9 col-md-6 col-xl-7 d-none d-md-block p-0 pb-3"></div>
			<div class="col-4 col-md-1 col-xl-1 d-none d-md-block p-0 pb-3">Lượt đánh giá</div>
			<div class="col-4 col-md-1 col-xl-1 d-none d-md-block p-0 pb-3">Sinh viên</div>
			<div class="col-4 col-md-1 col-xl-1 d-none d-md-block p-0 pb-3">Chứng chỉ</div>
		</div>
		<c:forEach var="khoahoc" items="${CoursesPage.content}">
		<div class="row m-0 mt-3 pb-3" style="border-bottom: 1px solid #B0B0AA;">
			<div class="col-3 col-md-3 col-xl-2 p-2 text-center"><img src="${khoahoc.anhmota}" class="img-fluid"></div>
			<div class="col-9 col-md-6 col-xl-7 p-0 align-items-center">
				<p><strong>${khoahoc.tenkhoahoc}</strong></p>
				<p>${khoahoc.motangan}</p>
			</div>
			<div class="col-4 col-md-1 col-xl-1 p-0 text-center">
				<div class="d-md-none d-block mt-4 text-start px-2">Lượt đánh giá</div>
				<div class="d-md-none d-block mt-2 text-start px-2">${khoahoc.danhgias.size()}</div>
				<div class="d-none d-md-block mt-2">${khoahoc.danhgias.size()}</div>
			</div>
			<div class="col-4 col-md-1 col-xl-1 p-0 text-center">
				<div class="d-md-none d-block mt-4">Sinh viên</div>
				<div class="mt-2 text-center">${khoahoc.sinhviens.size()}</div>
			</div>
			<div class="col-4 col-md-1 col-xl-1 p-0 text-center">
				<div class="d-md-none d-block mt-4 text-end px-2">Chứng chỉ</div>
				<div class="d-md-none d-block mt-2 text-end px-2">${khoahoc.diems.size()}</div>
				<div class="d-none d-md-block mt-2">${khoahoc.diems.size()}</div>
			</div>
		</div>
		</c:forEach>
	</div>
		
	
	
	<!-- Nav bar -->
	<nav>
		<ul class="pagination m-0 mt-5 p-0 pb-5 justify-content-center">
			<li class="page-item"><a class="page-link" href="?page=1" onclick="handleClick(this)">&laquo;</a></li>
			<c:forEach var="i" begin="1" end="${CoursesPage.totalPages}">
			<li class="page-item ${CurrentPage==i?'active':''}"><a class="page-link" href="?page=${i}" onclick="handleClick(this)">${i}</a>
			</c:forEach>
			<li class="page-item"><a class="page-link" href="?page=${CoursesPage.totalPages}" onclick="handleClick(this)">&raquo;</a></li>
		</ul>
	</nav>
	
	


	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>