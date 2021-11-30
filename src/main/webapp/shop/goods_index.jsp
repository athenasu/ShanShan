<%@ page import="tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.shop.service.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO"%>


<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath();%>

<%	
	ShopService shopsvc = new ShopServiceImpl();
	List<ProductBO> popular10 = shopsvc.findPopular10();
    pageContext.setAttribute("popular10",popular10);     
%>

<%--
    ShopService pssvc = new ShopServiceImpl();
	List<ProductBO> lastest10 = shopsvc.findNew();  //用我的service去呼叫LULU的service
    pageContext.setAttribute("lastest10",lastest10);     
    
--%>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商城首頁</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">


</head>

<body>
    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>

    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">
        <!-- 輪播圖 -->
        <div class="goodsindex_topslideshow">
            <ul class="goodsindex_topslideshow_area">
                <!-- https://i.imgur.com/ZhH3DAc.png -->
                <li><a href=""><img src="img\goodsindex_topslideshow_area_03.png"></a></li>
                <!-- https://i.imgur.com/sfBaq5r.png -->
                <li class="-none"><a href=""><img src="img\goodsindex_topslideshow_area_02.png"></a></li>
                <!-- https://i.imgur.com/YWTgIN5.png -->
                <li class="-none"><a href=""><img src="img\goodsindex_topslideshow_area_01.png"></a></li>
            </ul>

            <div class="slideshow_circle_area">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>

        <div class="goodsindex_innercontent ">
        
            <div class="goods_title01">熱門商品</div>
            <ul class="goods_area">
            <c:forEach items="${popular10}" var="ProductBO" >
                <li class="single_good_area" onclick="location.href='<%=contextPath %>/shop/goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" src="<%=contextPath %>/popularProductPicServlet?productId=${ProductBO.productId}&action=getPopImage" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">${ProductBO.companyName}</span>	
                    <a class="good_headname"><h5>${ProductBO.productName}</h5></a>
                    <span class="good_headprice">售價${ProductBO.productPrice}</span>
                </li>
            </c:forEach>
            </ul>
			
            <div class="goods_title01">新駐商品</div>
			<ul class="goods_area">
			<c:forEach  items="${lastest10}" var="ProductBO2">
                <li class="single_good_area" onclick="location.href='<%=contextPath%>/shop/goods_product_page.jsp'">
					<div class="good_headpic"><img class="good_headpic_img" src="<%=contextPath%>/LastestProductPicServlet?productId=${ProductBO2.productId}&action=getPopImage" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">${ProductBO2.companyName}</span>	
                    <a class="good_headname"><h5>${ProductBO2.productName}</h5></a>
                    <span class="good_headprice">售價${ProductBO2.productPrice}</span>
                </li>
			</c:forEach>
			</ul>
        </div>
    </div>

    <!-- 商店首頁 結束-->
    
    <!-- 插入 商城頁尾-->
<%@ include file="goods_footer.jsp" %>

    <!-- 載入jQuery -->
    <!-- <script type='text/javascript' src='<%=contextPath%>/shop/code/jquery-3.6.0.js'></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- 載入index.js -->
    <script type='text/javascript' src='<%=contextPath%>/shop/code/index.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>
</html>