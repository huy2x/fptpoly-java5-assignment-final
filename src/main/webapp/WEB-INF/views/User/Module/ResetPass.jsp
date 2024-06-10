<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- Reset Password -->
	<div class="card m-auto my-5" style="max-width: 32rem;">
		<div class="card-header"><h5 class="card-title"><spring:message code="user.resetpassword.resetpassword"/></h5></div>
		<div class="card-body">
			<form class="mx-1 mx-sm-3 mx-md-5 my-4 needs-validation" novalidate name="formRP" action="${url}ResetPass" method="post">
				<div class="input-group has-validation mb-4">
					<input type="email" class="form-control form-control-lg {{formRP.txtEmailRP.$valid?'':'is-invalid'}}" name="txtEmailRP" placeholder="<spring:message code="user.resetpassword.email"/>" required maxlength="256" ng-model="txtEmailRP" ng-disabled="sendEmail">
					<button class="btn btn-outline-primary" type="button" ng-click="sendEmail = formRP.txtEmailRP.$valid; sendEmail ? SendMail(txtEmailRP) : false" ng-disabled="sendEmail">
						<div class="spinner-border spinner-border-sm" ng-show="sendEmail"></div>
						<i class="bi bi-send-fill" ng-hide="sendEmail"></i>
					</button>
					<div class="invalid-feedback"><spring:message code="user.resetpassword.emailinvalid"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtOTP" name="txtOTP" placeholder="OTP" required maxlength="8">
					<label for="txtOTP" class="form-label"><spring:message code="user.resetpassword.otpcode"/></label>
					<div class="invalid-feedback"><spring:message code="user.resetpassword.otpcodeinvalid"/></div>
				</div>
				<div class="form-floating mb-4" ng-init="showPassRP">
					<input type="{{showPassRP?'text':'password'}}" class="form-control form-control-lg {{formRP.txtNPassRP.$valid?'':'is-invalid'}}"
					id="txtNPassRP" name="txtNPassRP" placeholder="Pass" required ng-model="NPassRP" ng-pattern="/^(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/">
					<label for="txtNPassRP" class="form-label"><spring:message code="user.resetpassword.newpassword"/></label>
					<div class="form-check is-valid">
						<input type="checkbox" class="form-check-input" id="rdoShowPassRP" ng-model="showPassRP">
						<label class="form-check-label" for="rdoShowPassRP"><spring:message code="user.resetpassword.showpassword"/></label>
					</div>
					<div class="invalid-feedback"><spring:message code="user.resetpassword.newpassinvalid"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="{{showPassRP?'text':'password'}}" class="form-control form-control-lg {{NPassRP!=CPassRP?'is-invalid':''}}"
					id="txtCPassRP" name="txtCPassRP" placeholder="Pass" required ng-model="CPassRP">
					<label for="txtCPassRP" class="form-label"><spring:message code="user.resetpassword.confirmpassword"/></label>
					<div class="invalid-feedback"><spring:message code="user.resetpassword.confirmpasswordinvalid"/></div>
				</div>
				<div class="mt-5">
					<button type="submit" class="btn btn-lg btn-primary w-100"><spring:message code="user.resetpassword.resetpassword"/></button>
				</div>
			</form>
		</div>
	</div>
	
	
	
	
	<!-- Toast success -->
	<div class="toast-container position-fixed top-0 end-0 p-3"  >
		<div id="ToastSC" class="toast align-items-center" role="alert">
			<div class="d-flex">
				<div class="toast-body text-success"><spring:message code="user.resetpassword.toastsuccess"/></div>
				<button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast"></button>
			</div>
		</div>
	</div>
	
	
	<!-- Toast error -->
	<div class="toast-container position-fixed top-0 end-0 p-3"  >
		<div id="ToastER" class="toast align-items-center" role="alert">
			<div class="d-flex">
				<div class="toast-body text-danger"><spring:message code="user.resetpassword.toasterror"/></div>
				<button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast"></button>
			</div>
		</div>
	</div>
		



</body>
</html>