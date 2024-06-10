<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<body>



		<div class="m-0 mx-md-5 my-5 p-0 row">

			<!-- Default Card -->
			<div class="col-12 m-0 p-0 d-lg-none d-block">
				<div class="card mb-5">
					<div class="row m-0 p-0">
						<div class="col-12 col-sm-5 m-0 p-0">
							<img class="img-fluid w-100" src="${Course.anhmota}">
						</div>
						<div class="col-12 col-sm-7 m-0 p-0">
							<div class="card-body">
								<h4 class="card-title">${sessionScope.userSV.ten}</h4>
								<p class="card-text">${Course.motangan}</p>
								<h6 class="card-subtitle mb-2 text-body-secondary">
									<spring:message code="user.course.exam.score" />
								</h6>
								<div class="progress" role="progressbar">
									<div class="progress-bar" id="Mark1" style="width: ${Mark}%">${Mark}%</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Float Card -->
			<div class="col-12 col-lg-4 m-0 p-0 position-relative row d-none d-lg-block">
				<div class="sticky-top">
					<div class="col-11 position-absolute" style="left: 50%; transform: translateX(-50%)">
						<div class="card">
							<img class="card-img-top" src="${Course.anhmota}">
							<div class="card-body">
								<h4 class="card-title">${sessionScope.userSV.ten}</h4>
								<p class="card-text" style="font-size: 1.1vw;">${Course.motangan}</p>
								<h6 class="card-subtitle mb-2 text-body-secondary">
									<spring:message code="user.course.exam.score" />
								</h6>
								<div class="progress" role="progressbar">
									<div class="progress-bar" id="Mark2" style="width: ${Mark}%">${Mark}%</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Exam Sentences -->
			<div class="col-12 col-lg-8 m-0 p-0">
				<form class="needs-validation" name="ExamForm" novalidate ng-init="Validation()" action="#" method="post">
					<div class="accordion" id="ExamSentences" ng-init="CheckSentence()">
						<c:forEach var="cauhoi" items="${Course.cauhois}" varStatus="loop">
							<div class="accordion-item">
								<h2 class="accordion-header">
									<button class="accordion-button collapsed${loop.index==0?'':' collapsed'} bg-opacity-75 fw-bold" type="button" data-bs-toggle="collapse" data-bs-target="#Sentence${loop.index}">
										Câu hỏi ${loop.index+1}: 
									</button>
								</h2>
								<div id="Sentence${loop.index}" class="accordion-collapse collapse${loop.index==0?' show':''}" data-bs-parent="#ExamSentencesDelete">
									<div class="accordion-body row m-0 p-0 p-md-2">
										<div class="col-12 mt-2 mb-3">${cauhoi.tencauhoi}</div>
										<div class="col-12 col-md-6 my-2">
											<div class="form-check">
												<input class="form-check-input" type="radio" name="AnswerOfSentence${loop.index}" value="A" id="AnswerAOfSentence${loop.index}" required>
												<label class="form-check-label" for="AnswerAOfSentence${loop.index}">A. ${cauhoi.dapana}</label>
											</div>
										</div>
										<div class="col-12 col-md-6 my-2">
											<div class="form-check">
												<input class="form-check-input" type="radio" name="AnswerOfSentence${loop.index}" value="B" id="AnswerBOfSentence${loop.index}" required>
												<label class="form-check-label" for="AnswerBOfSentence${loop.index}">B. ${cauhoi.dapanb}</label>
											</div>
										</div>
										<div class="col-12 col-md-6 my-2">
											<div class="form-check">
												<input class="form-check-input" type="radio" name="AnswerOfSentence${loop.index}" value="C" id="AnswerCOfSentence${loop.index}" required>
												<label class="form-check-label" for="AnswerCOfSentence${loop.index}">C. ${cauhoi.dapanc}</label>
											</div>
										</div>
										<div class="col-12 col-md-6 my-2">
											<div class="form-check">
												<input class="form-check-input" type="radio" name="AnswerOfSentence${loop.index}" value="D" id="AnswerDOfSentence${loop.index}" required>
												<label class="form-check-label" for="AnswerDOfSentence${loop.index}">D. ${cauhoi.dapand}</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>

					<button type="submit" class="btn btn-lg btn-primary my-4 w-100 fw-bolder fs-5">
					<c:choose>
						<c:when test="${Mark > 0}"><spring:message code="user.course.exam.retest"/></c:when>
						<c:otherwise><spring:message code="user.course.exam.finish"/></c:otherwise>
					</c:choose>
					</button>
				</form>
			</div>



		</div>



</body>
</html>