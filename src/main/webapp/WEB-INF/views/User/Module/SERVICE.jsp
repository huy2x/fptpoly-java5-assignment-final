<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<div class="m-0 mx-md-5 my-4 p-0 row">
	
		<!-- Default Card -->
		<div class="col-12 m-0 p-0 d-lg-none d-block">
			<div class="card mb-3">
				<div class="card-body fs-5"><spring:message code="user.service.title"/></div>
			</div>
		</div>

		<!-- Float Card -->
		<div class="col-12 col-lg-5 m-0 p-0 position-relative row d-none d-lg-block">
			<div class="sticky-top">
				<div class="col-11 position-absolute"
					style="left: 50%; transform: translateX(-50%)">
					<div class="card">
						<div class="card-body fs-5"><spring:message code="user.service.title"/></div>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="col-12 col-lg-7 m-0 p-0">
			<div class="accordion" id="SERVICE">
				<c:forEach begin="1" end="7" varStatus="loop">
				    <div class="accordion-item">
						<h2 class="accordion-header">
							<button class="accordion-button collapsed bg-opacity-75 fw-bold" type="button"
								data-bs-toggle="collapse" data-bs-target="#Sentence${loop.index}">
								<spring:message code="user.service.title_${loop.index}"/>
							</button>
						</h2>
						<div id="Sentence${loop.index}" class="accordion-collapse collapse" data-bs-parent="#SERVICE">
							<div class="accordion-body">
								<spring:message code="user.service.content_${loop.index}"/>
								<c:if test="${loop.index == 5}">
								    <ul>
									<c:forEach begin="1" end="11" varStatus="loop">
										<li><spring:message code="user.service.content_5.${loop.index}"/></li>
									</c:forEach>
									</ul>
								</c:if>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>



</body>
</html>