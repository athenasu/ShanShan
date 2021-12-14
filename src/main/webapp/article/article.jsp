<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.entity.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.articlePicture.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.actLogMsg.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.actLogMsg.entity.*"%>


<%

	ArticleVO articleVO = (ArticleVO) request.getAttribute("articleVO");
	
	ArticlePictureService artPicSvc = new ArticlePictureService();
	List<ArticlePictureVO> artPicVo = artPicSvc.findByArtId(articleVO.getArticle_id());
 	pageContext.setAttribute("artPicVo", artPicVo);

	ActLogMsgService msgSvc = new ActLogMsgService();
	List<ActLogMsgVO> msgVO = msgSvc.findMsgByArtId(articleVO.getArticle_id());
	pageContext.setAttribute("msgVO", msgVO);

	application.getAttribute("memSvc");
	application.getAttribute("mtnSvc");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="/img/favicon.png" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/article/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/article/css/article.css" />
<title>山山來此|山友日誌</title>
</head>
<body>
	<!-- 導覽列 -->
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
		<div class="topside">
			<ul class="breadcrumb">
				<li><a href="<%=request.getContextPath()%>/article/articleList.jsp">日誌列表</a></li>
				<li><a href="" class="titlelink">${articleVO.article_title}</a></li>
			</ul>
			<div class="artimginfo">
				<img
					src="<%=request.getContextPath() %>/ArticlePictureServlet.do?article_id=${articleVO.article_id}&action=getOneImage"
					class="img artimg" />
			</div>
			<div class="artinfo">
				<div class="artleft">
					<div class="artmem">
						<img src="<%=request.getContextPath() %>/ArticlePictureServlet.do?member_id=${articleVO.member_id}&action=getImage"
							class="img artmemimg" />
					</div>
					<div class="contentinfo">
						<h1 class="arttitle">${articleVO.article_title}</h1>
						<h3 class="artloc">登山區域：${mtnSvc.findMtnByPk(articleVO.mountain_id).mountainName}${articleVO.other_mtn}</h3>
						<h3 class="arttime">登山時間：${articleVO.event_date}</h3>
						<h3 class="artmemid">作者：${memSvc.findById(articleVO.member_id).memberName}</h3>
					
					</div>
					
				</div>
				<div>網誌點閱數: ${articleVO.aritcle_viewer}</div>
				<div>目前打賞數: ${articleVO.article_points_recieved} </div>
				<div class="icongroup">
				
					<i class="far fa-heart artwish"></i>
					<i class="fab fa-product-hunt artpoint"></i>
				</div>
			</div>
			<div class="content">
				<div class="recomm">
				
					<c:set var="recomm"  value="${articleVO.recommendation}" /> 
 					<span>推薦度：</span><span class="recommrank"> 
 					<c:choose> 
 							<c:when test="${recomm==1}">非常不推</c:when> 
 							<c:when test="${recomm==2}">不推薦</c:when> 
 							<c:when test="${recomm==3}">普通</c:when> 
 							<c:when test="${recomm==4}">推薦</c:when> 
							<c:when test="${recomm==5}">非常推薦</c:when> 
						</c:choose> 
					</span> 
					<c:forEach var="x"  begin="1" end="${articleVO.recommendation}"  step="1">
					<i class="fas fa-hiking" ></i>
					</c:forEach>
				</div>
				<p class="artcontent">${articleVO.article_content}</p>
			</div>
			<div class="more">
				<h3>更多照片</h3>
				<div class="moreimg">
					<c:forEach var="ArticlePictureVO" items="${artPicVo}"
 						varStatus="loop"> 
						<div class="imgOf5">
							<img 
								src="<%=request.getContextPath() %>/ArticlePictureServlet.do?article_picture_id=${artPicVo[loop.index].article_picture_id}&action=getArtPic"
 								class="img"> 
 						</div>
 					</c:forEach> 
				</div>
			</div>
		</div>
		<div class="bottomside">
			<div class="messageboard">
				<h3>留言</h3>
				<div class="msglist">
					<c:forEach var="ActLogMsgVO" items="${msgVO}" varStatus="loop">
						<div class="msgcard">
							<div class="msgmeminfo">
								<div class="msgimg">
									<img src="<%=request.getContextPath() %>/ArticlePictureServlet.do?member_id=${msgVO[loop.index].member_id}&action=getImage"
										class="img msgmemimg">
								</div>
								<span class="msgmemid">${memSvc.findById(msgVO[loop.index].member_id).memberName}</span>
							</div>
							<div class="msginfo">
								<div>
									<div class="msgtime">
									
									${msgVO[loop.index].msg_time}
									</div>
									<div class="msgrepo">
										檢舉留言<i class="fas fa-exclamation-circle"></i>
									</div>
								</div>
								<div class="msg">${msgVO[loop.index].msg_content}</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="message">
				<form method="post" action="<%=request.getContextPath()%>/ActLogMsgServlet" class="msgform">
					<input type="text" name="msg_content" value="" class="msgarea" placeholder="有話要說"> 
					<input type="hidden" name="action" value="sendMsg"> 
					<input type="hidden" name="member_id" value="16"> 
					<input type="hidden" name="article_id" value="${articleVO.article_id}">
					<input type="submit" value="送出" class="subBtn">
				</form>
			</div>
		</div>
	</main>
	<footer>
		<h4>Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
</body>
</html>
