<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page
	import="tw.idv.tibame.tfa104.shanshan.web.article.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.entity.*"%>
<%@ page
	import="tw.idv.tibame.tfa104.shanshan.web.articlePicture.service.impl.*"%>
<%@ page
	import="tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.*"%>
<%@ page
	import="tw.idv.tibame.tfa104.shanshan.web.actLogMsg.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.actLogMsg.entity.*"%>

<%

	List<ArticleVO> articleVO = (ArrayList<ArticleVO>) request.getAttribute("articleVO");

    application.getAttribute("memSvc");
    application.getAttribute("mtnSvc");
         
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/img/favicon.png" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/article/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/article/css/articleList.css" />
<title>山山來此|山友日誌</title>
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

	<main>
		<!-- 搜尋列 -->
		<div class="artsearch">
			<form method="post" action="<%=request.getContextPath() %>/ArticleServlet.do?action=search">
				<div id="searcharea">
					<input type="text" placeholder="請輸入關鍵字" id="textinput" value="" name="keyword" /> 
					<input type="submit" value="送出" id="searchbtn" />
					<input type="hidden" name="action" value="search">
				</div>
			</form>
			</div>
		<h3>搜尋如下:</h3>
		<div class="artlist">
			<c:forEach var="ArticleVO" items="${articleVO}" varStatus="loop">
				<div class="artcard">
					<a
						href="<%=request.getContextPath() %>/ArticleServlet.do?article_id=${articleVO[loop.index].article_id}&action=getThisArt"
						class="art">
						<div class="artimg">
							<img
								src="<%=request.getContextPath() %>/ArticlePictureServlet.do?article_id=${articleVO[loop.index].article_id}&action=getOneImage"
								alt="" class="img">
							<div class="locinfo">
								<i class="fas fa-map-marker-alt locicon"></i> <span
									class="artloc">${mtnSvc.findMtnByPk(articleVO[loop.index].mountain_id).mountainName}</span>
								<span class="artloc">${articleVO[loop.index].other_mtn}</span>

							</div>
						</div>
						<div class="artinfo">
							<div class="arttime">發文日期：${articleVO[loop.index].article_date_created}</div>
							<div class="arttitle">${articleVO[loop.index].article_title}</div>
							<div class="artmeminfo">
								<div class="artmem">
									<div class="artmemimg">
										<img
											src="<%=request.getContextPath() %>/ArticlePictureServlet.do?member_id=${articleVO[loop.index].member_id}&action=getImage"
											class="img memimg" />
									</div>
									<div>
										<span class="artmemid">${memSvc.findById(articleVO[loop.index].member_id).memberName}</span>
									</div>
								</div>
								<div class="artother">
									<i class="far fa-heart artwish"></i> <i
										class="fab fa-product-hunt artpoint"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</main>
	<footer>
		<h4>Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
</body>
</html>