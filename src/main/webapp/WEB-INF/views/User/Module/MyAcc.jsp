<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- My Account form -->
	<div class="card m-auto my-5" style="max-width: 32rem;">
		<div class="card-header"><h5 class="card-title"><spring:message code="user.myaccount.myaccount"/></h5></div>
		<div class="card-body">
			<div class="m-0 mb-5 p-0 text-center">
				<img class="img-fluid w-50" src="${sessionScope.userSV.avatar}">
			</div>
			<form class="mx-1 mx-sm-3 mx-md-5 my-4 needs-validation" novalidate action="${url}MyAcc" method="post" enctype="multipart/form-data">
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg is-valid" id="txtUsernameMA" name="username" placeholder="Username" value="${sessionScope.userSV.username}" readonly>
					<label for="txtUsernameMA" class="form-label"><spring:message code="user.myaccount.idaccount"/></label>
				</div>
				<div class="form-floating mb-4">
					<input type="email" class="form-control form-control-lg is-valid" id="txtEmailMA" name="email" placeholder="Email" value="${sessionScope.userSV.email}" readonly>
					<label for="txtEmailMA" class="form-label"><spring:message code="user.myaccount.email"/></label>
				</div>
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtFullnameMA" name="ten" placeholder="Fullname" value="${sessionScope.userSV.ten}" required maxlength="128">
					<label for="txtFullnameMA" class="form-label"><spring:message code="user.myaccount.fullname"/></label>
					<div class="invalid-feedback"><spring:message code="user.myaccount.fullnameinvalid"/></div>
				</div>
				<div class="has-validation mb-4">
					<label for="inpAvatar" class="form-label"><spring:message code="user.myaccount.avatar"/></label>
					<input type="file" class="form-control form-control-lg" name="picAvatar" id="inpAvatar">
				</div>
				<div class="mt-5">
					<button type="submit" class="btn btn-lg btn-primary w-100"><spring:message code="user.myaccount.updateaccount"/></button>
				</div>
			</form>
		</div>
	</div>



</body>
</html>