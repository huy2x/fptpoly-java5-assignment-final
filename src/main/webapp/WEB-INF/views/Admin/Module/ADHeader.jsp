<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="navbar navbar-expand-xxl bg-black sticky-top" data-bs-theme="dark" style="height: 10vh;">
	<div class="container-fluid">
		<div class="d-md-none">
			<i class="bi bi-{{Theme=='dark'?'moon-stars':'sun'}} fs-4 text-light link-info mx-2" ng-click="ChangeTheme()" role="button"></i>
			<!-- <a class="text-white mt-1 h6" href="#"><i class="fa-solid fa-user me-2"></i>Login</a> -->
		</div>
		<a class="navbar-brand col-3 col-md-2 col-lg-1 d-flex justify-content-center" href="#"><img src="../../../../Image/Text.png" width="70%" alt=""></a>
		<button class="navbar-toggler  d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="d-none d-md-block">
			<i class="bi bi-{{Theme=='dark'?'moon-stars':'sun'}} fs-4 text-light link-info mx-2" ng-click="ChangeTheme()" role="button"></i>
		</div>
	</div>
</header>