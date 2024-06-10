<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>


	
	<!-- All Courses -->
	<div class="row justify-content-center m-0 my-4 p-0">
		<c:forEach var="course" items="${CoursesPage.content}" varStatus="loop">
		<div class="card m-0 my-3 m-md-3 p-0 col-12 col-md-5 col-xl-3" 
			onclick="location.href='${url}Course/${course.idkh}'" style="cursor: pointer;"
			data-bs-toggle="tooltip" data-bs-title="${course.motangan}" data-bs-custom-class="custom-tooltip">
			<div class="card-header">
				<c:choose>
					<c:when test="${course.cauhois.size() > 0}"><i class="bi bi-patch-check-fill me-2 text-success"></i></c:when>
					<c:otherwise><i class="bi bi-patch-exclamation-fill me-2 text-danger"></i></c:otherwise>
				</c:choose>
				${course.phanloai.tenpl}
			</div>
			<img class="img-fluid" src="${course.anhmota}">
			<div class="card-body">
				<h5 class="card-title fs-6 m-0">${course.tenkhoahoc}</h5>
				<p class="card-text d-block d-lg-none">${course.motangan}</p>
			</div>
		</div>
		</c:forEach>
	</div>
	
	
	<!-- Nav bar -->
	<nav>
		<ul class="pagination m-0 p-0 pb-5 justify-content-center">
			<li class="page-item"><a class="page-link" href="?page=1" onclick="handleClick(this)">&laquo;</a></li>
			<c:forEach var="i" begin="1" end="${CoursesPage.totalPages}">
			<li class="page-item ${CurrentPage==i?'active':''}"><a class="page-link" href="?page=${i}" onclick="handleClick(this)">${i}</a>
			</c:forEach>
			<li class="page-item"><a class="page-link" href="?page=${CoursesPage.totalPages}" onclick="handleClick(this)">&raquo;</a></li>
		</ul>
	</nav>



</body>
</html>