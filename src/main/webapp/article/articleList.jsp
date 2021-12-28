<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.entity.*"%>

<%
	ArticleService articleSvc = new ArticleService();
	List<ArticleVO> list = articleSvc.getAll();
    pageContext.setAttribute("list",list);
    
    List<ArticleVO> list2 =articleSvc.orderByViewer();
    pageContext.setAttribute("list2",list2);
    
    application.getAttribute("memSvc");
    application.getAttribute("mtnSvc");
    application.getAttribute("wishSvc");
//  登入用
    session.getAttribute("memberId");
    session.getAttribute("memberName");
//     Integer  member_id=1;
//     pageContext.setAttribute("member_id",member_id);
   
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/img/favicon.png" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/index/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/article/css/articleList.css" />
<title>山山來此|山友日誌</title>
</head>
<body>
	<%@ include file="/index/header.jsp" %>
	<main>	
		<div class="wrap">
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
<%-- 			<div class="addArt"><a href="<%=request.getContextPath() %>/article/addArticle.jsp" class="addcheck">我要發文<i class="fas fa-pencil-alt"></i></a></div> --%>
			<div class="addArt"><a class="addcheck">我要發文<i class="fas fa-pencil-alt"></i></a></div>
			<!-- 主要內容 -->
			<div class="wrapper">
			 <div class="artAndPage">
				<div class="artlist">
				<%@ include file="/article/pages/page1.file" %>
					<c:forEach var="ArticleVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
						<div class="artcard">
							<a href="<%=request.getContextPath() %>/ArticleServlet.do?article_id=${ArticleVO.article_id}&action=getThisArt" class="art">
								<div class="artimg">
									<img src="<%=request.getContextPath() %>/ArticlePictureServlet.do?article_id=${ArticleVO.article_id}&action=getOneImage" alt="" class="img">															 
									<div class="locinfo">
										<i class="fas fa-map-marker-alt locicon"></i>
										<span class="artloc">${mtnSvc.findMtnByPk(ArticleVO.mountain_id).mountainName}</span>
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
												<img src="<%=request.getContextPath() %>/ArticlePictureServlet.do?member_id=${ArticleVO.member_id}&action=getImage" class="img memimg" />
											</div>
											<div>
												<span class="artmemid">${memSvc.findById(ArticleVO.member_id).memberName}</span> 
											</div>
										</div>
										<div class="artother" data-memid="${ArticleVO.member_id}" data-artid="${ArticleVO.article_id}">
											<i class="fab fa-product-hunt artpoint"></i><span class="point">${ArticleVO.article_points_recieved}</span>
										</div>
									</div>
								</div>	
							</a>						
						</div>
					</c:forEach>
				</div>
				<div class="page"><%@ include file="/article/pages/page2.file" %></div>	
			</div>
				<aside>
					<div class="artranking">
						<h3>點閱排名</h3>
						<div class="rankinglist">
						<c:forEach var="ArticleVO" items="${list2}">
							<div class="rankingcard">
								<a href="<%=request.getContextPath() %>/ArticleServlet.do?article_id=${ArticleVO.article_id}&action=getThisArt">
									<div class="rankingimg">
										<img src="<%=request.getContextPath() %>/ArticlePictureServlet.do?article_id=${ArticleVO.article_id}&action=getOneImage" class="img" />
									</div>
									<div class="rankingartinfo">
										<h4 class="ranktitle">${ArticleVO.article_title}</h4>
										<span class="rankmem">${memSvc.findById(ArticleVO.member_id).memberName}</span>
									</div>
									<div class="checktime">
										<span>${ArticleVO.aritcle_viewer}</span><span>次觀看</span>
									</div>
								</a>
							</div>
						</c:forEach>
						</div>
					</div>
				</aside>
			</div>
		</div>
		    <div class="overlay2 -none">
      			<div class="modal2">
	          <div id="errormsg"></div>
	          <input type="button" value="確定" id="cancel2"/>
      		</div>
    </div>
	</main>

	<!-- footer -->
	<footer>
		<h4>
			Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN
		</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>		
	<script src="<%=request.getContextPath()%>/index/vendors/jquery/jquery-3.6.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/index/js/header2.js"></script>
		<script src="<%=request.getContextPath()%>/member/js/register.js"></script>
	
	<script>

	$(".addcheck").click(function(){		
		$.ajax({
			url:"<%=request.getContextPath()%>/CheckAccount.do",
			method: "GET",
			success : function(e) {
				if(e==="ok"){
					location.href = "<%=request.getContextPath() %>/article/addArticle.jsp"
				}else{
					$(".overlay2").removeClass("-none");
					$(".modal2 #errormsg").html("請先登入帳號");	
				}
			}			
		})
	})	
	$("#cancel2").click(function(){
// 		console.log("wwww")
		$(".modal2 #errormsg").html("");
		$(".overlay2").addClass("-none");		
	});
	</script>

</body>
</html>

