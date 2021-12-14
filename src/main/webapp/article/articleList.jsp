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
      
    Integer  member_id=1;
    pageContext.setAttribute("member_id",member_id);
   
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
			<div class="addArt"><a href="<%=request.getContextPath() %>/article/addArticle.jsp">我要發文<i class="fas fa-pencil-alt"></i></a></div>
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
									</a>
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
		
	</main>
	 <div class="overlay -none">
      <div class="modal">
        <form>       
	          <div>目前您擁有<span id="havepoint">${memSvc.findMemberPoints(member_id)}</span>點</div>
	          <div>請輸入要打賞的點數<input type="text" id="givepoint" />點</div>
	          <div id="errormsg"></div>
	          <input type="button" value="確定" id="giveBtn"/>
	          <input type="button" value="取消" id="cancel"/>
        </form>
      </div>
    </div>
    <div class="overlay2 -none">
      <div class="modal2">
	          <div id="errormsg">無法打賞給自己</div>
	          <input type="button" value="確定" id="cancel2"/>
      </div>
    </div>
	<!-- footer -->
	<footer>
		<h4>
			Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN
		</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
		
		
	<script src="<%=request.getContextPath()%>/article/vendors/jquery/jquery-3.6.0.min.js"></script>
	<script>
	var member_id=${member_id};
	var artid="";
	var memid="";
	$("i.artpoint").click(function () {
		memid = $(this).parent(".artother").data("memid");
		artid = $(this).parent(".artother").data("artid");
		if(memid == member_id){
			$(".overlay2").removeClass("-none");
		}else{
			$(".overlay").removeClass("-none");
			 $("#givepoint").val("");
			 $("#errormsg").html("");	 
		}
	});
	  
	
	$("#cancel").click(function(){
		$(".overlay").addClass("-none");
	});
	$("#cancel2").click(function(){
		$(".overlay2").addClass("-none");
	});
	
	$("#giveBtn").click(function () {
	  var havepoint = $("#havepoint").text().trim();
	  var givepoint = parseInt($("#givepoint").val().trim());
	  var clear = "";

	  if (!/^[0-9]*$/.test(givepoint) | (givepoint == null)) {
	    $("#errormsg").html("請填寫正確數字");
	    $("#givepoint").val("");
	  } else {
	    if (givepoint > parseInt(havepoint)) {
	      $("#errormsg").html("擁有的點數不足");
	    } else {
	      //   執行ajax
	      $.ajax({
	        url: "<%=request.getContextPath()%>/member/updateMemberPoints",
	        data: {
	          memberId: memid,
	          points: givepoint,
	        },
	        method: "POST",
	      });
	      $.ajax({
		        url: "<%=request.getContextPath()%>/ArticleServlet.do?action=addpoint",
		        data: {
		        	article_id: artid,
		        	article_points_recieved:givepoint,
		        },
		        method: "POST",
		      });
	      $.ajax({
		        url: "<%=request.getContextPath()%>/member/updateMemberPoints",
		        data: {
		          memberId: member_id,
		          points: -givepoint,
		        },
		        method: "POST",
		      });
	      let pointsUsedArticle= JSON.stringify({
	    		"memberId": member_id,
		        "pointsUsed": givepoint,
		        "articleId": artid,
				"pointsUsedDate":$.now(),
	      })	      
	      $.ajax({
		        url: "<%=request.getContextPath()%>/pointsUsedArticle/pointsSpentArticle",
		        type: "POST",
		        contentType: 'application/json',
		        dataType: "json",
		        data: pointsUsedArticle,
		        success: function (e) {
				$("div.overlay").addClass("-none");
				history.go(0);
		        },
		      });
	    }
	  }
	});
	
	</script>	
</body>
</html>

