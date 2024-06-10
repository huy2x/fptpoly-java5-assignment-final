<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="MyApp" ng-controller="MyCtrl" data-bs-theme="{{Theme}}">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- bs -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<!-- angularjs -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.js"></script>

<!-- link fontw -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous"
	referrerpolicy="no-referrer" />
<!-- jquery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"
	integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw==" crossorigin="anonymous"
	referrerpolicy="no-referrer"></script>

<link rel="icon" type="image/x-icon" href="/Image/Logo.png">
<script type="text/javascript" src="/resources/AdminJS/ADKhoaHoc.js"></script>
<script type="text/javascript" src="/resources/AdminJS/ADCauHoi.js"></script>
<script type="text/javascript" src="/resources/AdminJS/ADTaiLieu.js"></script>


<link rel="stylesheet" href="../../../resources/style.css">
<link rel="stylesheet" href="../../../resources/Admin.css">
<script src="../../../resources/script.js"></script>
<script src="../../../resources/Admin.js"></script>
<title>admin</title>
<script>
	var app = angular.module('myApp', []);
</script>
</head>

<body ng-app="myApp">
	<c:choose>
		<c:when test="${isUserAD}">
		
	<jsp:include page="Module/ADHeader.jsp"></jsp:include>
	<div class="container-fluid ">
			<div class="row">
				<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-body-tertiary sidebar collapse p-0" style="margin-top: -10px;">
					<div class="position-sticky  pt-md-5 mt-3 sidebar-sticky">
						<h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-5 mb-1 text-body-secondary text-uppercase">
							<span>QUẢN LÝ</span> <a class="link-secondary" href="#" aria-label="Add a new report"> <span data-feather="plus-circle"
								class="align-text-bottom"></span>
							</a>
						</h6>
						<ul class="nav flex-column mb-2 ms-3">
							<li class="nav-item"><a class="nav-link" href="/admin/khoahoc"> <span data-feather="file-text" class="align-text-bottom"></span><i
									class="fa-solid fa-circle me-2"></i>Khóa học
							</a></li>
							<li class="nav-item"><a class="nav-link" href="/admin/ThongKe"> <span data-feather="file-text" class="align-text-bottom"></span><i
									class="fa-solid fa-circle me-2"></i>Thống kê
							</a></li>
	
						</ul>
					</div>
				</nav>
	
				<article class="col-md-9 ms-sm-auto col-lg-10 p-2 bg-body-tertiary">
					<div style="height: auto;">
						<jsp:include page="${view}"></jsp:include></div>
				</article>
			</div>
		</div>
	
		</c:when>
		<c:otherwise>
			<script>window.location = "/"</script>
		</c:otherwise>
	</c:choose>
	
	
</body>

</html>