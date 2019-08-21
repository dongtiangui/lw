<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="baseurl" value="${pageContext.request.contextPath}/" />
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>后台管理登陆</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="../static/css/bootstrap.min.css" type="text/css"
	rel="stylesheet" />
<!-- Material Design Bootstrap -->
<link href="../static/css/mdb.min.css" type="text/css" rel="stylesheet" />
<!-- Your custom styles (optional) -->
<link href="../static/css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="view"
		style="background-image: url('https://mdbootstrap.com/img/Photos/Horizontal/Nature/full page/img(20).jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center; top: 0px">
		<div class="mask rgba-gradient align-items-center">
			<div class="container">
				<div class="row mt-5">
					<div
						class="col-md-6 mb-5 mt-md-0 mt-5 white-text text-center text-md-left">
						<h1 class="h1-responsive font-weight-bold wow fadeInLeft"
							data-wow-delay="0.3s">love||wall后台管理</h1>
						<hr class="hr-light wow fadeInLeft" data-wow-delay="0.3s">
						<h6 class="mb-3 wow fadeInLeft" data-wow-delay="0.3s">机遇创造未来</h6>
						<a class="btn btn-outline-white wow fadeInLeft"
							data-wow-delay="0.3s">Learn more</a>
					</div>
					<div class="col-md-6 col-xl-5 mb-4">
						<div class="card fadeInRight"
							style="opacity: 0.6; background-color: black;"
							data-wow-delay="0.3s">
							<div class="card-body">
								<div class="text-center">
									<h3 class="white-text">
										<i class="fas fa-user white-text"></i> 管理员登陆
									</h3>
									<hr class="hr-light">
								</div>
								<div class="md-form">
									<i class="fas fa-user prefix white-text active"></i> <input
										type="text" id="materialLoginFormUserName" name="name"
										class="text-light form-control"> <label
										for="materialLoginFormUserName" class="active">用户名</label>
								</div>
								<div class="md-form">
									<i class="fas fa-lock prefix white-text active"></i> <input
										type="password" id="materialLoginFormPassword" name="pass"
										class="text-light form-control"> <label
										for="materialLoginFormPassword">密码</label>
								</div>
								<div class="text-center mt-4">
									<button id="agreementSub"
										class="btn btn-default btn-lg btn-block">登陆</button>
									<hr class="hr-light mb-3 mt-4">
									<div
										class="inline-ul text-center d-flex justify-content-center">
										<a class="p-2 m-2 tw-ic"> <i
											class="fab fa-twitter white-text"></i>
										</a> <a class="p-2 m-2 li-ic"> <i
											class="fab fa-linkedin-in white-text"> </i>
										</a> <a class="p-2 m-2 ins-ic"> <i
											class="fab fa-instagram white-text"> </i>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../static/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="../static/js/popper.min.js"></script>
	<script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../static/js/mdb.min.js"></script>
	<script src="https://cdn.bootcss.com/three.js/r83/three.js"></script>
	<script type="text/javascript">
		$("#agreementSub").click(function() {
			if ($("#materialLoginFormUserName").val() === '') {
				alert("用户名为空");
				return;
			}
			if ($("#materialLoginFormPassword").val() === '') {
				alert("密码为空");
				return;
			}
			$.ajax({
				type : "post",
				url : "/login/ajaxLogin",
				dataType : "json", //data传递的是一个json类型的值，而不是字符串，且必须标明dataType的类型，否则会出现400错误或者其他错误。
				data : {
					"name" : $("#materialLoginFormUserName").val(),
					"pass" : $("#materialLoginFormPassword").val()
				},
				success : function(data) {
					if (data.status == 200) {
						window.location.href = '/home';
					} else {
						alert("密码错误");
					}
				},
				error : function() {
					alert("网络错误");
				}
			});
		})
	</script>
</body>
</html>
