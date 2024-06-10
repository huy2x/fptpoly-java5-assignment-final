<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- Sign In form -->
	<div class="card m-auto my-5" style="max-width: 32rem;">
		<div class="card-header"><h5 class="card-title"><spring:message code="user.signin.signin"/></h5></div>
		<div class="card-body">
			<form class="mx-1 mx-sm-3 mx-md-5 my-4 needs-validation" novalidate action="${url}SignIn" method="post">
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtUsernameSI" name="username" placeholder="Username" required>
					<label for="txtUsernameSI" class="form-label"><spring:message code="user.signin.username"/></label>
					<div class="invalid-feedback"><spring:message code="user.signin.usernameinvalid"/></div>
				</div>
				<div class="form-floating mb-4" ng-init="showPassSI">
					<input type="{{showPassSI?'text':'password'}}" class="form-control form-control-lg" id="txtPass" name="matkhau" placeholder="Password" required>
					<label for="txtPass" class="form-label"><spring:message code="user.signin.password"/></label>
					<div class="invalid-feedback"><spring:message code="user.signin.passwordinvalid"/></div>
					<div class="form-check is-valid">
						<input type="checkbox" class="form-check-input" id="rdoShowPassSI" ng-model="showPassSI">
						<label class="form-check-label" for="rdoShowPassSI"><spring:message code="user.signin.showpassword"/></label>
					</div>
				</div>
				<div class="form-check mb-4">
					<input type="checkbox" class="form-check-input" id="rdoCheck" name="rdoCheck">
					<label class="form-check-label" for="rdoCheck"><spring:message code="user.signin.rememberme"/></label>
				</div>
				<div class="mt-5">
					<button type="submit" class="btn btn-lg btn-primary w-100"><spring:message code="user.signin.signin"/></button>
				</div>
			</form>
		</div>
	</div>



</body>
</html>