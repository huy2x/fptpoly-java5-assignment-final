<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- Sign Up form -->
	<div class="card m-auto my-5" style="max-width: 32rem;">
		<div class="card-header"><h5 class="card-title"><spring:message code="user.signup.signup"/></h5></div>
		<div class="card-body">
			<form class="mx-1 mx-sm-3 mx-md-4 my-4 needs-validation" novalidate name="formSU" action="${url}SignUp" method="post" enctype="multipart/form-data">
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtUsernameSU" name="username" placeholder="Username" required>
					<label for="txtUsernameSU" class="form-label"><spring:message code="user.signup.username"/></label>
					<div class="invalid-feedback"><spring:message code="user.signup.usernameinvalid"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtFullnameSU" name="ten" placeholder="Fullname" required maxlength="128">
					<label for="txtFullnameSU" class="form-label"><spring:message code="user.signup.fullname"/></label>
					<div class="invalid-feedback"><spring:message code="user.signup.fullnameinvalid"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="email" class="form-control form-control-lg" id="txtEmailSU" name="email" placeholder="Email" required maxlength="256">
					<label for="txtEmailSU" class="form-label"><spring:message code="user.signup.email"/></label>
					<div class="invalid-feedback"><spring:message code="user.signup.emailinvalid"/></div>
				</div>
				<div class="form-floating mb-4" ng-init="showPassSU">
					<input type="{{showPassSU?'text':'password'}}" class="form-control form-control-lg {{formSU.matkhau.$valid?'':'is-invalid'}}"
					id="txtNPassSU" name="matkhau" placeholder="Password" required ng-model="NPassSU" ng-pattern="/^(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/">
					<label for="txtNPassSU" class="form-label"><spring:message code="user.signup.password"/></label>
					<div class="form-check is-valid">
						<input type="checkbox" class="form-check-input" id="rdoShowPassSU" ng-model="showPassSU">
						<label class="form-check-label" for="rdoShowPassSU"><spring:message code="user.signup.showpassword"/></label>
					</div>
					<div class="invalid-feedback"><spring:message code="user.signup.passwordinvalid"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="{{showPassSU?'text':'password'}}" class="form-control form-control-lg {{NPassSU!=CPassSU?'is-invalid':''}}"
					id="txtCPassSU" name="txtCPassSU" placeholder="Password" required ng-model="CPassSU">
					<label for="txtCPassSU" class="form-label"><spring:message code="user.signup.confirmpassword"/></label>
					<div class="invalid-feedback"><spring:message code="user.signup.confirmpasswordinvalid"/></div>
				</div>
				<div class="has-validation mb-4">
					<label for="inpAvatar" class="form-label"><spring:message code="user.signup.avatar"/></label>
					<input type="file" class="form-control form-control-lg" name="picAvatar" id="inpAvatar" required>
					<div class="invalid-feedback"><spring:message code="user.signup.avatarinvalid"/></div>
				</div>
				<div class="mt-5">
					<button type="submit" class="btn btn-lg btn-primary w-100"><spring:message code="user.signup.signup"/></button>
				</div>
				<p><small><spring:message code="user.signup.termsofservice_1"/> <a href="${url}SERVICE"><spring:message code="user.signup.termsofservice_2"/></a></small></p>
			</form>
		</div>
	</div>



</body>
</html>