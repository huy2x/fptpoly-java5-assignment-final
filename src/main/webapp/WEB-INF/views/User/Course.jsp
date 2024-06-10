<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="h-100" ng-app="MyApp" ng-controller="MyCtrl" ng-init="Validation()" data-bs-theme="{{Theme}}">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.js"></script>
    <link rel="icon" type="image/x-icon" href="/Image/Logo.png">
    <title>${Course.tenkhoahoc}</title>
    <link href="/resources/style.css" rel="stylesheet">
    <script src="/resources/script.js"></script>
    <!-- CSS and JS for Rating -->
	<link href="https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<link href="/resources/RatingStyle.css" rel="stylesheet">
	<script src="/resources/RatingScript.js"></script>
    <style>
        #BGImage {
            background: url("{{getImageOnTime()}}") no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
    </style>
</head>

<body id="BGImage" class="d-flex flex-column h-100">
	<c:url var="url" value="/"/>
	
	<%@include file="Module/Header.jsp"%>




	<%@include file="Module/Course.jsp"%>



    
	<%@include file="Module/Footer.jsp"%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>