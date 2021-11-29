<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page
	import="tw.idv.tibame.tfa104.shanshan.web.article.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.entity.*"%>
<%-- <%@ page import="tw.idv.tibame.tfa104.shanshan.web.articlePicture.service.impl.*"%> --%>


<%
	ArticleService articleSvc = new ArticleService();
	List<ArticleVO> list = articleSvc.getAll();
    pageContext.setAttribute("list",list);
    
    List<ArticleVO> list2 =articleSvc.orderByViewer();
    pageContext.setAttribute("list2",list2);
%>

<%-- <jsp:useBean id="artPicSvc" scope="page" --%>
<%-- 	class="tw.idv.tibame.tfa104.shanshan.web.articlePicture.service.impl.ArticlePictureService" /> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link rel="shortcut icon" href="/img/favicon.png" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/article/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/article/css/article.css" />
<title>山山來此|山友日誌</title>
</head>
<body>
	<header>
		<div id="logo">
			<a href="index.html"><img src="img/logo.png" class="img" /></a>
		</div>
		<nav id="navlist">
			<ul>
				<li><a href="#">找山友</a></li>
				<li><a href="#">山友日誌</a></li>
				<li><a href="#">攻山小物</a></li>
				<li><a href="#">登山資訊</a></li>
				<li><a href="#">會員中心</a></li>
			</ul>
		</nav>
		<div id="memcheck">
			<div id="ball">
				<i class="fas fa-bell"></i>
			</div>
			<div id="login">
				<a href="#">登入</a>
			</div>
			<div id="register">
				<a href="#">註冊</a>
			</div>
		</div>
	</header>
	<main>
		<div class="wrap">
			<!-- 搜尋列 -->
			<div class="artsearch">
				<input type="text" placeholder="請輸入關鍵字" id="textinput" /> <i
					class="fas fa-search"></i>
			</div>
			<!-- 主要內容 -->
			<div class="wrapper">
				<div class="artlist">
					<c:forEach var="ArticleVO" items="${list}">
						<div class="artcard">
							<a href="article01.html" class="art">
								<div class="artimg">
<%-- 									<img src="${artPicSvc.getOnePic(ArticleVO.article_id).article_picture}&action=getOneImage" class="img" /> --%>
			  							<img src="<%=request.getContextPath() %>/ArticlePictureServlet.do?article_id=${ArticleVO.article_id}&action=getOneImage" alt="" class="img">															 
									<div class="locinfo">
										<i class="fas fa-map-marker-alt locicon"></i>
										<span class="artloc">${ArticleVO.mountain_id}</span>
									</div>
								</div>
								<div class="artinfo">
									<div class="arttime">${ArticleVO.event_date}</div>
									<div class="arttitle">${ArticleVO.article_title}</div>
									<div class="artmeminfo">
										<div class="artmem">
											<div class="artmemimg">
												<img src="/img/d1900618.jpg" class="img memimg" />
											</div>
											<div>
												<span class="artmemid">${ArticleVO.member_id}</span>
											</div>
										</div>
										<div class="artother">
											<i class="far fa-heart artwish"></i> 
											<i class="fab fa-product-hunt artpoint"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
				<aside>
					<div class="artranking">
						<h3>點閱排名</h3>
						<div class="rankinglist">
						<c:forEach var="ArticleVO" items="${list2}">
							<div class="rankingcard">
								<a href="">
									<div class="rankingimg">
										<img src="<%=request.getContextPath() %>/ArticlePictureServlet.do?article_id=${ArticleVO.article_id}&action=getOneImage" class="img" />
									</div>
									<div class="rankingartinfo">
										<h4 class="ranktitle">${ArticleVO.article_title}</h4>
										<span class="rankmem">${ArticleVO.member_id}</span>
									</div>
									<div class="checktime">
										<span>${ArticleVO.aritcle_viewer}</span><span>次觀看</span>
									</div>
								</a>
							</div>
						</c:forEach>
						</div>
					</div>
					<div></div>
				</aside>
			</div>
		</div>
	</main>
	<!-- footer -->
	<footer>
		<h4>
			Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN
		</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"
		crossorigin="anonymous"></script>
</body>
</html>