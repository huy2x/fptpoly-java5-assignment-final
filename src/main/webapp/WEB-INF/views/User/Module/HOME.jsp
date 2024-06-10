<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<main>
		<div class="px-4 py-5 my-5 text-center">
			<img class="d-block mx-auto mb-4" src="Image/Logo.png" width="100">
			<h1 class="display-5 fw-bold text-body-emphasis"><spring:message code="user.home.block_1.title"/></h1>
			<div class="col-lg-6 mx-auto">
				<p class="lead mb-4">
					<spring:message code="user.home.block_1.content"/>
				</p>
				<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
					<a class="btn btn-primary btn-lg px-4 gap-3" role="button" href="${url}SignIn"><spring:message code="user.home.block_1.signin"/></a>
					<a class="btn btn-outline-secondary btn-lg px-4" role="button" href="${url}SignUp"><spring:message code="user.home.block_1.signup"/></a>
				</div>
			</div>
		</div>

		<div class="b-example-divider"></div>

		<div class="px-4 pt-5 my-5 text-center border-bottom">
			<h1 class="display-4 fw-bold text-body-emphasis"><spring:message code="user.home.block_2.title"/></h1>
			<div class="col-lg-6 mx-auto">
				<p class="lead mb-4">
					<spring:message code="user.home.block_2.content"/>
				</p>
			</div>
			<div class="overflow-hidden" style="max-height: 30vh;">
				<div class="container px-5">
					<img src="/Image/Image1.png" class="img-fluid border rounded-3 shadow-lg mb-4" width="700"
						height="500" loading="lazy">
				</div>
			</div>
		</div>

		<div class="b-example-divider"></div>

		<div class="container col-xxl-8 px-4 py-5">
			<div class="row flex-lg-row-reverse align-items-center g-5 py-5">
				<div class="col-10 col-sm-8 col-lg-6">
					<img src="/Image/Image2.png"
						class="d-block mx-lg-auto img-fluid" width="700" height="500" loading="lazy">
				</div>
				<div class="col-lg-6">
					<h1 class="display-5 fw-bold text-body-emphasis lh-1 mb-3"><spring:message code="user.home.block_3.title"/></h1>
					<p class="lead"><spring:message code="user.home.block_3.content"/></p>
				</div>
			</div>
		</div>

		<div class="b-example-divider"></div>

		<div class="container my-5">
			<div class="row p-4 pb-0 pe-lg-0 pt-lg-5 align-items-center rounded-3 border shadow-lg">
				<div class="col-lg-7 p-3 p-lg-5 pt-lg-3">
					<h1 class="display-4 fw-bold lh-1 text-body-emphasis"><spring:message code="user.home.block_4.title"/></h1>
					<p class="lead"><spring:message code="user.home.block_4.content"/></p>
					<div class="d-grid gap-2 d-md-flex justify-content-md-start mb-4 mb-lg-3">
						<a class="btn btn-primary btn-lg px-4 gap-3" role="button" href="${url}SignIn"><spring:message code="user.home.block_4.signin"/></a>
						<a class="btn btn-outline-secondary btn-lg px-4" role="button" href="${url}SignUp"><spring:message code="user.home.block_4.signup"/></a>
					</div>
				</div>
				<div class="col-lg-4 offset-lg-1 p-0 overflow-hidden shadow-lg">
					<img class="rounded-lg-3" src="/Image/Image3.png" width="720">
				</div>
			</div>
		</div>

		<div class="b-example-divider"></div>

	</main>



</body>
</html>