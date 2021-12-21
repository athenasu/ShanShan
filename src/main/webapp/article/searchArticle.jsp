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
//     登入用
    session.getAttribute("memberId");
    session.getAttribute("memberName");
         
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/img/favicon.png" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/index/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/article/css/searchArt.css" />
<title>山山來此|山友日誌</title>
</head>
<body>
	<%@ include file="/index/header.jsp" %>

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
					<a href="<%=request.getContextPath() %>/ArticleServlet.do?article_id=${articleVO[loop.index].article_id}&action=getThisArt"
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
							<div class="arttime">發文日期：${articleVO[loop.index].article_date_created}<span class="views"><i class="far fa-eye"></i>${articleVO[loop.index].aritcle_viewer}次</span></div>
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
									<i class="fab fa-product-hunt artpoint"></i>${articleVO[loop.index].article_points_recieved}
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
	<script src="<%=request.getContextPath()%>/index/vendors/jquery/jquery-3.6.0.min.js"></script>	
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
		<script src="<%=request.getContextPath()%>/member/js/register.js"></script>
	
<%-- 	<script src="<%=request.getContextPath()%>/index/js/header2.js"></script> --%>
	<script>
	$(function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/CheckAccount.do",
			method: "GET",
			success : function(e) {
				if(e==="ok"){
					$(".logout_modal_button").removeClass("-none")
					$(".login_modal_button").addClass("-none")
				}else{
					$(".logout_modal_button").addClass("-none")
					$(".login_modal_button").removeClass("-none")	
				}
			}			
		})
	})
	</script>
</body>
</html>