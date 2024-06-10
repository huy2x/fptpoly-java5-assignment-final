<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- Description Course  -->
	<div class="card border-2 border-primary-subtle mx-0 my-4 mx-md-5 px-0">
		<div class="card-header border-primary-subtle h4">
			<c:choose>
				<c:when test="${Course.cauhois.size() > 0}"><i class="bi bi-patch-check-fill me-2 text-success"></i></c:when>
				<c:otherwise><i class="bi bi-patch-exclamation-fill me-2 text-danger"></i></c:otherwise>
			</c:choose>
			${Course.tenkhoahoc}
		</div>
		<div class="card-body row mx-0 px-0">
			<blockquote class="m-0 blockquotecol-12 col-lg-7 col-xl-8 fs-5">
				<p class="mt-5 fs-6">${Course.mota}</p>
			</blockquote>
			<div class="m-0 p-0 col-lg-5 col-xl-4 position-relative row d-none d-lg-block" style="min-height: 150px;">
				<!-- Float Card -->
				<div class="sticky-top">
					<div class="col-11 position-absolute pt-5" style="top: 25%; left: 50%; transform: translateX(-50%)">
						<c:if test="${Course.tainguyens.size() > 0}">
						<button type="button" class="btn btn-lg btn-outline-primary mt-4 mb-3 w-100" onclick="location.href='${url}Course/${Course.idkh}/Join'"><spring:message code="user.course.enroll"/></button>
						</c:if>
						<div class="card align-items-center overflow-y-auto" style="max-height: 60vh;">
							<img class="card-img-top" src="${Course.anhmota}">
							<div class="card-body">
								<p class="card-text" style="font-size: 1.1vw;">${Course.motangan}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	
	
	<!-- Lession of Course  -->
	
	<div class="mx-0 my-4 mx-md-5 px-0 row">
		<div class="m-0 p-0 col-lg-7 col-xl-8 accordion" >
			<div class="accordion-item">
				<c:choose>
					<c:when test="${Course.tainguyens.size() > 0}">
						<div class="accordion-header">
							<button class="accordion-button alert alert-{{Theme == 'dark' ? 'light' : 'primary'}} fw-bold h5 m-0" type="button" data-bs-toggle="collapse" data-bs-target="#AccorLession">
							<spring:message code="user.course.contentcourse"/> 
							</button>
						</div>
						<div class="accordion-collapse collapse show" id="AccorLession">
							<ul class="accordion-body list-group list-group-numbered m-0 p-0">
								<c:forEach var="tainguyen" items="${Course.tainguyens}" varStatus="loop">
								<li class="list-group-item list-group-item-action">${tainguyen.tentainguyen}</li>
								</c:forEach>
							</ul>
						</div>		
					</c:when>
					<c:otherwise><div class="accordion-header alert alert-dark fw-bold h5 m-0"><spring:message code="user.course.resource"/></div></c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
		
		
	
	<!-- Default Card -->
	<div class="mx-0 my-4 mx-md-5 px-0 d-block d-lg-none">
		<div class="card">
			<img class="card-img-top" src="${Course.anhmota}">
			<div class="card-body">
				<c:if test="${Course.tainguyens.size() > 0}">
				<button type="submit" class="btn btn-lg btn-outline-primary m-0 my-3 mb-5 w-100" onclick="location.href='${url}Course/${Course.idkh}/Join'"><spring:message code="user.course.enroll"/></button>
				</c:if>
				<h5 class="card-title">${Course.tenkhoahoc}</h5>
				<p class="card-text">${Course.motangan}</p>
			</div>
		</div>
	</div>



	<!-- Ratting Course -->
	<div class="mx-0 my-4 mx-md-5 px-0 row">
		<div class="m-0 mb-5 p-0 col-lg-7 col-xl-8 accordion">
			<div class="accordion-item" ng-init="ViewRatting = false">
				<div class="accordion-header">
					<button class="accordion-button collapsed alert alert-{{Theme == 'dark' ? 'light' : 'success'}} fw-bold h5 m-0 py-0"
					type="button" data-bs-toggle="collapse" data-bs-target="#AccorRating" ng-click="ViewRatting = true">
						<div class="m-0 p-0 col-auto text-center">
							<div class="my-0 d-none d-sm-block "><spring:message code="user.course.rate"/></div>
							<div class="d-sm-none d-block fs-1"><i class="bi bi-stars"></i></div>
						</div>
						<div class="col rating" data-vote="${Rating.sao != null ? Rating.sao : 0}">
							<div class="star hidden my-1">
								<span class="full" data-value="0"></span>
								<span class="half" data-value="0"></span>
							</div>
							<div class="star mx-0 mx-md-1">
								<span class="full" data-value="1"></span>
								<span class="half" data-value="0.5"></span>
								<span class="selected"></span>
							</div>
							<div class="star mx-0 mx-md-1">
								<span class="full" data-value="2"></span>
								<span class="half" data-value="1.5"></span>
								<span class="selected"></span>
							</div>
							<div class="star mx-0 mx-md-1">
								<span class="full" data-value="3"></span>
								<span class="half" data-value="2.5"></span>
								<span class="selected"></span>
							</div>
							<div class="star mx-0 mx-md-1">
								<span class="full" data-value="4"></span>
								<span class="half" data-value="3.5"></span>
								<span class="selected"></span>
							</div>
							<div class="star mx-0 mx-md-1">
								<span class="full" data-value="5"></span>
								<span class="half" data-value="4.5"></span>
								<span class="selected"></span>
							</div>
							<div class="score m-0 h5">
								<span class="score-rating js-score">0</span>
								<span>/</span>
								<span class="total">5</span>
							</div>
						</div>
					</button>
				</div>
				<div class="accordion-collapse collapse m-0" id="{{ViewRatting == false ? 'AccorRating' : ''}}">
					<div class="form-floating m-2">
						<textarea class="form-control form-control-lg" id="txtDescription" ng-init="Descrip='${Rating.binhluan}'" ng-model="Descrip" placeholder="Mô tả" style="height: 200px"></textarea>
						<label for="txtDescription"><spring:message code="user.course.comment"/></label>
					</div>
					<div class="col-12 text-end m-0 p-0 mb-4">
						<button class="btn btn-lg btn-outline-success m-2" ng-click="Ratting(Descrip)"><spring:message code="user.course.submit"/></button>
					</div>
					<c:forEach var="danhgia" items="${Course.danhgias}" varStatus="loop">
					<div class="card border-info-subtle m-2 mt-3 p-0">
						<div class="card-header" ng-init="star${loop.index} = ${danhgia.sao}">
							<div class="row">
								<div class="col">${danhgia.sinhvien.ten}</div>
								<div class="col-auto" style="color: #ffd700;">
									<i class="bi bi-star{{star${loop.index} <= 0.0 ? '' : (star${loop.index} <= 0.5 ? '-half' : '-fill')}}"></i>
									<i class="bi bi-star{{star${loop.index} <= 1.0 ? '' : (star${loop.index} <= 1.5 ? '-half' : '-fill')}}"></i>
									<i class="bi bi-star{{star${loop.index} <= 2.0 ? '' : (star${loop.index} <= 2.5 ? '-half' : '-fill')}}"></i>
									<i class="bi bi-star{{star${loop.index} <= 3.0 ? '' : (star${loop.index} <= 3.5 ? '-half' : '-fill')}}"></i>
									<i class="bi bi-star{{star${loop.index} <= 4.0 ? '' : (star${loop.index} <= 4.5 ? '-half' : '-fill')}}"></i>
								</div>
							</div>
						</div>
						<div class="card-body">
							<p class="card-text">${danhgia.binhluan}</p>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	<!-- Toast success -->
	<div class="toast-container position-fixed top-0 end-0 p-3"  >
		<div id="ToastSC" class="toast align-items-center" role="alert">
			<div class="d-flex">
				<div class="toast-body text-success"><spring:message code="user.course.toastsuccess"/></div>
				<button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast"></button>
			</div>
		</div>
	</div>
	
	
	<!-- Toast error -->
	<div class="toast-container position-fixed top-0 end-0 p-3"  >
		<div id="ToastER" class="toast align-items-center" role="alert">
			<div class="d-flex">
				<div class="toast-body text-danger"><spring:message code="user.course.toasterror"/></div>
				<button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast"></button>
			</div>
		</div>
	</div>
		



</body>
</html>