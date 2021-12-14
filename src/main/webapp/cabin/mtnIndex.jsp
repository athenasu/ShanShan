<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/index/img/favicon.png" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/index/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<header>
		<div id="logo">
			<a href="<%=request.getContextPath()%>/index/index.jsp">
			<img src="<%=request.getContextPath()%>/index/img/logo.png" class="img" /></a>
		</div>
		<nav id="navlist">
			<ul>
				<li><a href="<%=request.getContextPath()%>/event/event.html">找山友</a></li>
				<li><a href="<%=request.getContextPath()%>/article/articleList.jsp">山友日誌</a></li>
				<li><a href="<%=request.getContextPath()%>/shop/goods_index.jsp">攻山小物</a></li>
				<li><a href="<%=request.getContextPath()%>/cabin/mtnIndex.jsp">登山資訊</a></li>
				<li><a href="<%=request.getContextPath()%>/member/member_main.html">會員中心</a></li>
			</ul>
		</nav>
		<div id="memcheck">
			<div id="login">
				<a href="#">登入</a>
			</div>
			<div id="register">
				<a href="<%=request.getContextPath()%>/member/register.html">註冊</a>
			</div>
		</div>
	</header>
	<footer>
		<h4>Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
</body>
</html>