<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<div class="row justify-content-center m-0 mt-4 mx-xxl-5 p-0">
		<!-- Main video -->
		<div class="col-12 col-md-8 m-0 p-0 mb-5">
			<div class="m-0 p-0 mx-md-3 card">
				<div class="ratio ratio-16x9">
					<iframe src="https://www.youtube.com/embed/${Tainguyen.idyoutube}?autoplay=1&enablejsapi=1" id="IframeYT" class="rounded-top" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
				</div>
				<div class="p-2 m-0 py-2 border rounded-bottom"><!-- Body -->
					<h5 class="fs-5 fw-bold">${Tainguyen.tentainguyen}</h5>
					<a data-bs-toggle="collapse" href="#Description" role="button" ng-click="viewDescrip = true" ng-hide="viewDescrip"><spring:message code="user.course.material.describe"/></a>
					<span class="collapse" id="Description">${Tainguyen.mota}</span>
					<div class="row justify-content-center m-0 mt-3 p-0">
						<div class="col text-end m-0 p-0">
							<i class="bi bi-eye me-2"></i>${Khoahoc.sinhviens.getSize()}
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- Recommend video -->
		<div class="col-12 col-md-4 m-0 p-0 px-md-3">
			<c:forEach var="tainguyen" items="${Khoahoc.tainguyens}" varStatus="loop">
			<div class="card mb-3 ${Tainguyen.idyoutube == tainguyen.idyoutube ? 'bg-secondary' : ''}" onclick="location.href='${url}Course/${Khoahoc.idkh}/Material?idtn=${tainguyen.idtn}'" style="cursor: pointer;">
				<div class="row m-0 p-0">
					<div class="col-4 m-0 p-0">
						<img class="img-fluid rounded" src="https://i3.ytimg.com/vi/${tainguyen.idyoutube}/maxresdefault.jpg" onload="checkYT(this)">
					</div>
					<div class="col-8 m-0 p-2 row">
						<div class="align-self-start m-0 p-0 text-truncate">${tainguyen.tentainguyen}</div>
					</div>
				</div>
			</div>
			
			<c:if test="${Tainguyen.idyoutube == tainguyen.idyoutube && loop.index < Khoahoc.tainguyens.size() - 1}">
			    <script>
			        var player;
			        function onYouTubeIframeAPIReady() {
			            player = new YT.Player('IframeYT', {
			                events: { 'onStateChange': function (event){
			                	if (event.data == YT.PlayerState.ENDED){
			                		location.href="${url}Course/${Khoahoc.idkh}/Material?idtn=${Khoahoc.tainguyens[loop.index+1].idtn}";
			        }}}});}
			    </script>
			</c:if>
			</c:forEach>
			<c:choose>
				<c:when test="${Khoahoc.cauhois.size() > 0}">
					<button type="button" class="btn btn-lg btn-primary my-5 w-100" onclick="location.href='${url}Exam/${Khoahoc.idkh}'"><spring:message code="user.course.material.exam"/></button>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-lg btn-danger my-5 w-100" disabled><spring:message code="user.course.material.noexam"/></button>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
		
		
		
</body>
</html>