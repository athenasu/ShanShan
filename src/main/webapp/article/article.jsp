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
	
	Integer  member_id=3;
    pageContext.setAttribute("member_id",member_id);
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
				
				<div class="icongroup">
					<div id="point">目前文章點數: ${articleVO.article_points_recieved} </div>
					<div id="todo" data-memid="${articleVO.member_id}" data-artid="${articleVO.article_id}">
						<div class="repo"><i class="fas fa-exclamation-circle"></i>檢舉網誌</div>
						<div class="artpoint"><i class="fab fa-product-hunt"></i><span >我要打賞</span></div>
					</div>
					
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
									<div class="msgtime"><span>留言時間</span>
									<c:set var="time" value="${msgVO[loop.index].msg_time}" />
									<span><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${time}" /></span>
									</div>
									<div class="msgrepo">檢舉留言<i class="fas fa-exclamation-circle msgrepo"></i></div>
								</div>
								<div class="msg">${msgVO[loop.index].msg_content}</div>
								
							</div>
							
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="message">
				<form  class="msgform">
					<input type="text" name="msg_content" value="" class="msgarea" placeholder="有話要說"> 
					<input type="hidden" name="action" value="sendMsg"> 
					<input type="hidden" name="member_id" value="${member_id}"> 
					<input type="hidden" name="article_id" value="${articleVO.article_id}">
					<input type="button" value="送出" class="subBtn">
				</form>
			</div>
		</div>
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
	          <div id="errormsg"></div>
	          <input type="button" value="確定" id="cancel2"/>
      </div>
    </div>
    
        <div class="overlay3 -none">
      <div class="modal3">
      <form>
      <div>請選擇檢舉原因</div>
      	<div>
      		<label><input type="radio" name="reason" class="reportReason" value="0" checked>色情騷擾</label>
      		<label><input type="radio" name="reason" class="reportReason" value="1" >不實資訊</label>
      		<label><input type="radio" name="reason" class="reportReason" value="2" >垃圾訊息</label>
      		<label><input type="radio" name="reason" class="reportReason" value="3" >仇恨言論</label>
      		</div>
	          <div id="errormsg"></div>
	          <input type="button" value="確定" id="send"/>
	          <input type="button" value="取消" id="cancel3"/>
      </form>
      </div>
    </div>
	</main>
	<footer>
		<h4>Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
		<script src="<%=request.getContextPath()%>/article/vendors/jquery/jquery-3.6.0.min.js"></script>
	
	<script>	
	var member_id=${member_id};
	var artid="";
	var memid="";
	//打賞點數
	$("div.artpoint").click(function () {
		let str =`<div>目前您擁有<span id="havepoint">${memSvc.findMemberPoints(member_id)}</span>點</div><div>無法進行打賞</div>`;
		memid = $(this).parent("#todo").data("memid");
		artid = $(this).parent("#todo").data("artid");
		var havepoint = $("#havepoint").text().trim();
		if(memid == member_id){
			$(".overlay2").removeClass("-none");
			$(".modal2 #errormsg").html("無法打賞給自己");	
		}else if(parseInt(havepoint)== 0){
			$(".overlay2").removeClass("-none");
	    	$(".modal2 #errormsg").html(str);
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
		 $(".modal2 #errormsg").html("");
		$(".overlay2").addClass("-none");
		
	});
	$("#cancel3").click(function(){
		$(".overlay3").addClass("-none");
	});
	
	$("#giveBtn").click(function () {
	  var havepoint = $("#havepoint").text().trim();
	  var givepoint = parseInt($("#givepoint").val().trim());
	  var clear = "";

	  if (!/^[0-9]*$/.test(givepoint) | (givepoint == null)) {
	    $("#errormsg").html("請填寫正確數字");
	    $("#givepoint").val("");
	  }else {
	    if (givepoint > parseInt(havepoint)) {
	      $("#errormsg").html("擁有的點數不足");
	    }else {
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
	
	//檢舉
		$(".repo").click(function(){
		$(".overlay3").removeClass("-none");
	});
	
	
		$("#send").click(function(){
		let artreason=$("input[name='reason']:checked").val();
		let artid=${articleVO.article_id};
		$.ajax({
			url: "<%=request.getContextPath()%>/ArticleReportServlet.do?action=artRepo",
			method: "POST",       
	        data:{
	        	member_id:member_id,
		        article_id:artid,
		        article_report_reason:artreason,
				},
	        success: function (e) {
			$("div.overlay").addClass("-none");
			history.go(0);
	        }
      });	   
	});
		
		
		//留言
		$(".subBtn").click(function(){

			let artid=${articleVO.article_id};
			let msg_content=$(".msgarea").val().trim();
			if(msg_content==""){
				$(".overlay2").removeClass("-none");
				$(".modal2 #errormsg").html("留言無空白，請填寫留言再送出");	
			}else{
				$.ajax({
					url: "<%=request.getContextPath()%>/ActLogMsgServlet?action=sendMsg",
					method: "POST",       
			        data:{
			        	member_id:member_id,
				        article_id:artid,
				        msg_content:msg_content,
						},
			        success: function (e) {
			        	history.go(0);
			        }
		      });	   
			}
			
			

		})
	</script>
	
</body>
</html>
