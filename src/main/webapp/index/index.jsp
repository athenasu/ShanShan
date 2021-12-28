<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page
	import="tw.idv.tibame.tfa104.shanshan.web.article.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.entity.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.product.entity.* "%>

<%-- <jsp:useBean id="artSvc" scope="session" --%>
<%-- 	class="tw.idv.tibame.tfa104.shanshan.web.article.service.impl.ArticleService" /> --%>

<%
session.getAttribute("memberId");
session.getAttribute("memberName");
	
	ArticleService artSvc= new ArticleService();
	List<ArticleVO> list = artSvc.orderByViewer();
	pageContext.setAttribute("list", list);

	application.getAttribute("memSvc");
	application.getAttribute("mtnSvc");
	application.getAttribute("eventSvc");

	ShopServiceImpl shopsvc = new ShopServiceImpl();
	List<ProductBO> popular = shopsvc.findPopularNum(8);
	pageContext.setAttribute("popular", popular);
%>


<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="<%=request.getContextPath()%>/index/img/favicon.png" />
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/index/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/index/css/index.css" />
<title>山山來此|首頁</title>
</head>
<body>

<%@ include file="header.jsp" %>

	<main>
		<!-- 大圖+天氣 -->

		<div id="firstsc">
			<div class="bgImg">
				<div class="slidearea">
					<a href="#"> <img
						src="<%=request.getContextPath()%>/index/img/102.jpg"
						class="img slideimg" />
					</a>
				</div>
				<div class="slidearea">
					<a href="#"> <img
						src="<%=request.getContextPath()%>/index/img/101.jpg"
						class="img slideimg" />
					</a>
				</div>
				<div class="slidearea">
					<a href="#"> <img
						src="<%=request.getContextPath()%>/index/img/54.jpg"
						class="img slideimg" />
					</a>
				</div>
			</div>
			<div id="weather"></div>
		</div>
		<!-- 熱門揪團 -->
		<div id="group">
			<div class=>
				<i class="fas fa-mountain title"></i>
				<h2 class="title hottitle">熱門揪團</h2>
			</div>
<!-- 			<!-- 揪團列表 -->
			<div id="grouplist">
				<c:forEach var="popEventBO" items="${eventSvc.popularEvents()}">
					<div class="groupcard" data-gpid="${popEventBO.eventId}">
							<div class="groupimg">
								<img
									src="<%=request.getContextPath() %>/ArticlePictureServlet.do?mountainId=${popEventBO.mountainId}&action=getMtnPic"
									class="img" />
							</div>
							<div class="groupinfo">
								<h3 class="title2 gp_name">${popEventBO.eventName}</h3>
								<div class="infolist">
									<div>
										<i class="far fa-clock"></i>
									</div>
									<div>
										出團日期：<span><fmt:formatDate value="${popEventBO.eventStartDate}" pattern="yyyy-MM-dd" /></span> 
									</div>
								</div>
								<div class="infolist">
									<div>
										<i class="fas fa-bed"></i>
									</div>
									<c:set var="type" value="${popEventBO.mountainDistrict}" />
									<div>
										住宿種類：<span> <c:choose>
												<c:when test="${type==0}">當天來回</c:when>
												<c:when test="${type==1}">野營</c:when>
												<c:when test="${type==2}">山屋</c:when>
												<c:when test="${type==3}">飯店</c:when>
											</c:choose>
										</span>
									</div>
								</div>
								<div class="infolist">
									<div>
										<i class="fas fa-hiking"></i>
									</div>
									<c:set var="district" value="${popEventBO.mountainDistrict}" />
									<div>
										<span> <c:choose>
												<c:when test="${district==1}">北部</c:when>
												<c:when test="${district==2}">中部</c:when>
												<c:when test="${district==3}">南部</c:when>
												<c:when test="${district==4}">東部</c:when>
												<c:when test="${district==5}">外島</c:when>
											</c:choose>
										</span>
									</div>
								</div>
								<div class="leader">
									<div class="leaderimg">
										<img
											src="<%=request.getContextPath() %>/ArticlePictureServlet.do?member_id=${popEventBO.memberId}&action=getImage"
											class="img memimg" />
									</div>
									<div>
										<span>${popEventBO.memberName}</span>
									</div>
								</div>
							</div>
					</div>
				</c:forEach>

			</div>
		</div>

		<!-- 山友日誌 -->
		<div class="artarea">
			<i class="fas fa-mountain title"></i>
			<h2 class="title hottitle">山友日誌</h2>
			<div id="artlist">
				<c:forEach var="ArticleVO" items="${list}">
					<div class="artcard">
						<a
							href="<%=request.getContextPath() %>/ArticleServlet.do?article_id=${ArticleVO.article_id}&action=getThisArt"
							class="art">
							<div class="artimg">
								<img
									src="<%=request.getContextPath() %>/ArticlePictureServlet.do?article_id=${ArticleVO.article_id}&action=getOneImage"
									alt="" class="img">
								<div class="locinfo">
									<i class="fas fa-map-marker-alt locicon"></i> <span
										class="artloc">${mtnSvc.findMtnByPk(ArticleVO.mountain_id).mountainName}</span>
									<span class="artloc">${ArticleVO.other_mtn}</span>

								</div>
							</div>
							<div class="artinfo">
							<c:set var="time" value="${ArticleVO.article_date_created}" />
								<div class="arttime"><span>發文日期：<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${time}" /></span><span class="views"><i class="far fa-eye"></i>${ArticleVO.aritcle_viewer}次</span></div>
								<div class="arttitle">${ArticleVO.article_title}</div>
								<div class="artmeminfo">
									<div class="artmem">
										<div class="artmemimg">
											<img
												src="<%=request.getContextPath() %>/ArticlePictureServlet.do?member_id=${ArticleVO.member_id}&action=getImage"
												class="img memimg" />
										</div>
										<div>
											<span class="artmemid">${memSvc.findById(ArticleVO.member_id).memberName}</span>
										</div>
									</div>
									<div class="artother">
										<i class="fab fa-product-hunt artpoint"></i><span class="point">${ArticleVO.article_points_recieved}</span>
									</div>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- 商品 -->
		<div class="productarea">
			<h2 class="title hottitle">熱賣商品</h2>
			<div class="itemlist">
				<c:forEach var="product" items="${popular}">
					<a
						href="<%=request.getContextPath()%>/GetProductServlet?productId=${product.productId}"
						class="item">
						<div class="itemcard">
							<div class="itemimg">
								<img
									src="<%=request.getContextPath()%>/ProductPicServlet?productId=${product.productId}&productSequence=0&action=firstPic"
									class="img" />
							</div>
							<div class="iteminfo">
								<span class="shopname">${product.companyName}</span> <span
									class="productname">${product.productName}</span>
								<div>
									<span>售價</span> <span class="price">${product.productPrice}</span>
									<spans>元</spans>
								</div>
							</div>
						</div>
					</a>
				</c:forEach>
			</div>
		</div>
		<!-- 招商區 -->
		<div class="prarea">
			<div class="joinarea">
				<p>如果你也和我們一樣熱愛台灣</p>
				<p>想把台灣的自然山林分享給更多人知道</p>
				<p>加入我們，讓更多人認識你的品牌與商品</p>
				<a href="<%=request.getContextPath()%>/company/company_register.html" target="_blank" class="joinbtn"><div>Join Us</div></a>
			</div>
			<div class="joinimg">
				<img src="<%=request.getContextPath()%>/index/img/joinus.jpg"
					class="img" />
			</div>
		</div>
	</main>
	<footer
		style="background-image: url('<%=request.getContextPath()%>/index/img/footer.jpg')">
		<h4>
			Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN
		</h4>
	</footer>
	<script src="vendors/jquery/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

	<script src="<%=request.getContextPath()%>/index/js/header.js"></script>
	<script src="<%=request.getContextPath()%>/index/js/header2.js"></script>
	<script src="<%=request.getContextPath()%>/index/js/index.js"></script>
	<script src="<%=request.getContextPath()%>/member/js/register.js"></script>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>

</body>
</html>