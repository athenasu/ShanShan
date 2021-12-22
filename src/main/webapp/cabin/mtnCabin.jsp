<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import ="tw.idv.tibame.tfa104.shanshan.web.cabin.controller.*"%>

<%
request.setAttribute("date",new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/index/img/favicon.png" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/index/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/cabin/css/cabin.css" />
<title>山山來此|登山情報</title>
</head>
<body>
<%@ include file="/index/header.jsp" %>

	<main class="main">
			<div class="top"><ul class="breadcrumb">
				<li><a href="<%=request.getContextPath()%>/cabin/mtnIndex.jsp">登山資訊首頁</a></li>
				<li><a href="" class="titlelink">${mtn.mountainName}</a></li>
			</ul></div>
        <!-- 首屏 -->
        <div class="mountain-title">
            <h1>${mtn.mountainName}</h1>
        </div>
        <div class="main-content">
            <div class="main-img-wrapper">
            	<img src="<%=request.getContextPath()%>/CabinServlet.do?action=getMtnImg&mountainId=${mtn.mountainId}"  alt="main-mountain-img" class="main-img"/>
            </div>
            <div class="main-title">
                <h3>基本資訊</h3>
                <p>${mtn.mountainInfo}</p>
            </div>
        </div>
        <!-- 一周天氣 -->
        <div class="weather-container">
            <div class="weather-title-wrapper">
                <h2>一周天氣</h2>
            </div>
            <table class="weather-table">
            <tr class="week"></tr>
            <tr class="temp"></tr>
               
            </table>
        </div>
        <!-- 基本資訊 -->
<!--         <div class="info-container"> -->
<!--             <div class="info-title-wrapper"> -->
<!--                 <h2>基本資訊</h2> -->
<!--             </div> -->
            
<!--         </div> -->
        <!-- 山屋預約狀態 -->
        <div class="reserve-container">
            <div class="reserve-title-wrapper">
                <h2>山屋預約狀態</h2>
            </div>
            <div class="reserve-section">
            <h3 id="time"><fmt:formatDate pattern="yyyy-MM" value="${date}" /></h3>
            <div class="booking"></div>
            <p id="updateTime">最後更新時間 <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${date}" /></p>
            <p id="msg">預約狀態資訊僅供參考，正確資訊請至該山屋官網確認</p>
            </div>
        </div>
        <!-- 相關揪團 -->
        <div class="group-container">
            <div class="group-title-wrapper">
                <h2>相關揪團</h2>
            </div>
         <jsp:useBean id="mtnForCabinSvc" class="tw.idv.tibame.tfa104.shanshan.web.cabin.service.impl.MtnForCabinService"></jsp:useBean>           
            <div class="group-section">
            <c:forEach var="event" items="${mtnForCabinSvc.eventByMtn(mtn.mountainId)}">
                <div class="group-card"  data-gpid="${event.eventId}">
                    <div class="group-img-wrapper">
                        <img src="<%=request.getContextPath()%>/CabinServlet.do?action=getMtnImg&mountainId=${mtn.mountainId}" alt="group-mountain-img" class="group-img" />
                    </div>
                    <h3>${event.eventName}</h3>
                </div>
              </c:forEach>
            </div>
        </div>
        <!-- 相關文章 -->
        <div class="article-container">
            <div class="article-title-wrapper">
                <h2>相關文章</h2>
            </div>
            <div class="article-section">
            <jsp:useBean id="artSvc" class="tw.idv.tibame.tfa104.shanshan.web.article.service.impl.ArticleService"></jsp:useBean>
                <c:forEach var="art" items="${artSvc.findByMtn(mtn.mountainId)}">
				<a href="<%=request.getContextPath() %>/ArticleServlet.do?article_id=${art.article_id}&action=getThisArt" class="art">
	                <div class="article-card">
	                    <h3>${art.article_title}</h3>
	                    <p class="article-para">${art.article_content}</p>
	                </div>
                </a>
                </c:forEach>
            </div>
        </div>
    </main>
	
	<footer>
		<h4>Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>

	<script src="<%=request.getContextPath()%>/index/vendors/jquery/jquery-3.6.0.min.js"></script>
	<script src="<%=request.getContextPath()%>/index/js/header2.js"></script>	
	<script src="<%=request.getContextPath()%>/member/js/register.js"></script>	
	<script src="<%=request.getContextPath()%>/cabin/js/mtnCabin.js"></script>
	
	<script>

//爬山屋資料

$(document).ready(function() {	
	$.ajax({
		url : "<%=request.getContextPath()%>/CabinServlet.do", 
		data : { 
			"action" : "getBooking",
			"mountainId":${mtn.mountainId},
		}, 
		dataType : "html", 
		method : "POST", 
		success : function(result) { 
			$(".booking").html(result); 
 		} 
 	}) 
 //天氣api用
 	$.ajax({
		url : "<%=request.getContextPath()%>/CabinServlet.do",
		data : {
			"action" : "getnum",
			"mountainId":${mtn.mountainId},
		},
		success : function(num) {
			getdata(num);
		}
		
	})
});
	

</script>
</body>
</html>

