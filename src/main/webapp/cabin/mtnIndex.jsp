<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.cabin.service.impl.*" %>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.cabin.controller.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/index/img/favicon.png" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/index/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/cabin/css/mtnIndex.css" />
<title>山山來此|登山情報</title>
</head>
<body>
	<%@ include file="/index/header.jsp" %>
	
	<section id="allMountains">
<!--     <h1 class="mountainBan">山岳一覽</h1> -->
    <ul id="mountainFilter">    	
         
        <li class="list"><a href="#dis1">北部</a></li>
        <li class="list"><a href="#dis2">中部</a></li>
        <li class="list"><a href="#dis3">南部</a></li>
        <li class="list"><a href="#dis4">東部</a></li>
        <li class="list"><a href="#dis5">外島</a></li>
              
    </ul>
<jsp:useBean id="mtnforcabinSvc" scope="session" class="tw.idv.tibame.tfa104.shanshan.web.cabin.service.impl.MtnForCabinService" />
       
    <div class="imgss">
    <div class="allImgs dis" id="dis1">北部</div>
	    <c:forEach var="mtn" items="${mtnforcabinSvc.findByDistrict(1)}">  
	        <a href="<%=request.getContextPath()%>/CabinServlet.do?action=getMtn&mountainId=${mtn.mountainId}">
		        <div class="allImgs">
		            <img src="<%=request.getContextPath()%>/CabinServlet.do?action=getMtnImg&mountainId=${mtn.mountainId}" />
		            <p class="imgWords">${mtn.mountainName}</p>
		        </div>
	        </a>
	    </c:forEach> 
	    
	    <div class="allImgs dis" id="dis2">中部</div>
	    	    <c:forEach var="mtn" items="${mtnforcabinSvc.findByDistrict(2)}">  
	        <a href="<%=request.getContextPath()%>/CabinServlet.do?action=getMtn&mountainId=${mtn.mountainId}">
		        <div class="allImgs">
		            <img src="<%=request.getContextPath()%>/CabinServlet.do?action=getMtnImg&mountainId=${mtn.mountainId}" />
		            <p class="imgWords">${mtn.mountainName}</p>
		        </div>
	        </a>
	    </c:forEach> 
	   <div class="allImgs dis" id="dis3">南部</div>
	    <c:forEach var="mtn" items="${mtnforcabinSvc.findByDistrict(3)}">  
	        <a href="<%=request.getContextPath()%>/CabinServlet.do?action=getMtn&mountainId=${mtn.mountainId}">
		        <div class="allImgs">
		            <img src="<%=request.getContextPath()%>/CabinServlet.do?action=getMtnImg&mountainId=${mtn.mountainId}" />
		            <p class="imgWords">${mtn.mountainName}</p>
		        </div>
	        </a>
	    </c:forEach> 
	  <div class="allImgs dis" id="dis4">東部</div>
	   	<c:forEach var="mtn" items="${mtnforcabinSvc.findByDistrict(4)}">  
	        <a href="<%=request.getContextPath()%>/CabinServlet.do?action=getMtn&mountainId=${mtn.mountainId}">
		        <div class="allImgs">
		            <img src="<%=request.getContextPath()%>/CabinServlet.do?action=getMtnImg&mountainId=${mtn.mountainId}" />
		            <p class="imgWords">${mtn.mountainName}</p>
		        </div>
	        </a>
	    </c:forEach>  
	    <div class="allImgs dis " id="dis5">外島</div>
	    	    	    <c:forEach var="mtn" items="${mtnforcabinSvc.findByDistrict(5)}">  
	        <a href="<%=request.getContextPath()%>/CabinServlet.do?action=getMtn&mountainId=${mtn.mountainId}">
		        <div class="allImgs">
		            <img src="<%=request.getContextPath()%>/CabinServlet.do?action=getMtnImg&mountainId=${mtn.mountainId}" />
		            <p class="imgWords">${mtn.mountainName}</p>
		        </div>
	        </a>
	    </c:forEach>       
    </div>

    <h1 class="mountainBan giveTop">熱門山岳</h1>
	    <c:forEach var="hotMtn" items="${eventSvc.findPopularMountains()}" >  
    <div class="hotMountain">
        <div class="hotImg">
            <img src="<%=request.getContextPath()%>/CabinServlet.do?action=getMtnImg&mountainId=${hotMtn.mountainId}">
        </div>
        <div class="hotMounWord">
            <div class="mounTitle">
                <h2 class="mounName">${hotMtn.mountainName}</h2>
                <h3 class="joinNum"></h3>
            </div>            
            <div class="mounIntro"><p>${hotMtn.mountainInfo}
            </p></div>
            <div class="mounButton">
            	<a href="<%=request.getContextPath()%>/CabinServlet.do?action=getMtn&mountainId=${hotMtn.mountainId}">
            <div class="mounMore">More...</div>
            </a>
            </div>  
        </div>
    </div>
    </c:forEach>

</section>

	<footer>
		<h4>Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
	<script src="<%=request.getContextPath()%>/index/vendors/jquery/jquery-3.6.0.min.js"></script>
<%-- 			<script src="<%=request.getContextPath()%>/index/js/header2.js"></script> --%>
				<script src="<%=request.getContextPath()%>/member/js/register.js"></script>
			
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