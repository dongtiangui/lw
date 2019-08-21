<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@page import="org.apache.shiro.session.Session"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<html>
<head>
<title>home</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<style type="text/css">
body{
	font-family:'Roboto'!important;
	overflow: hidden;
}
.sidebar-nav {
	background: #ce93d8 !important;
}
.sidebar-nav ul {
	color: #ffffff;
	padding: 0;
	margin: 0;
	list-style: none;
	background: #ce93d8;
}

.sidebar-nav .metismenu {
	color: #ffffff;
	background: #ce93d8;
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-ms-flex-direction: column;
	flex-direction: column;
}
.sidebar-nav .metismenu li+li {
	margin-top: 5px;
}
.sidebar-nav .metismenu li:first-child {
	margin-top: 5px;
}
.sidebar-nav .metismenu li:last-child {
	margin-bottom: 5px;
}
.sidebar-nav .metismenu>li {
	/*-webkit-box-flex: 1;
		    -ms-flex: 1 1 0%;
		    flex: 1 1 0%;*/
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-ms-flex-direction: column;
	flex-direction: column;
	position: relative;
}

.sidebar-nav .metismenu a {
	position: relative;
	display: block;
	padding: 13px 15px;
	color: #ffffff;;
	outline-width: 0;
	transition: all .3s ease-out;
}

.sidebar-nav .metismenu ul a {
	padding: 10px 15px 10px 30px;
}

.sidebar-nav .metismenu ul ul a {
	padding: 10px 15px 10px 45px;
}

.sidebar-nav .metismenu a:hover, .sidebar-nav .metismenu a:focus,
	.sidebar-nav .metismenu a:active, .sidebar-nav .metismenu .mm-active>a
	{
	color: #f8f9fa;
	text-decoration: none;
	background: #0b7285;
}
</style>
</head>
<body class="fixed-sn light-blue-skin">
	<header id="header">
		<!-- jsp:include 动态传递参数 -->
		<%@include file="../common/head.jsp" %>
	</header>
	<section class="main">
		<div class="row">
			<aside class="col-2">
				<%@include file="../common/nav.jsp"%>
			</aside>
			<main class="col-10">
			 <%@include file="../common/main.jsp"%>
			</main>
		</div>
	</section>
	<footer id="footer">
		<%@include file="../common/footer.jsp"%>
	</footer>

<script type="text/javascript" src="../../static/js/base.js"></script>


</body>
</html>
