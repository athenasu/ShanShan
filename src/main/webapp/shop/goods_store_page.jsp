<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>店家專頁</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">


</head>

<body>
<input type="hidden" class="member_id" value="${memberId}">
    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>

    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">
        <div class="goodsindex_innercontent ">
            <div class="goods_breadcrumb"><a href="goods_index.html">攻山小物</a> > <a href="/shanshan/AllCompanyServlet">全部品牌</a> >  <a href="/shanshan/GetCompanyServlet?companyId=${companyDetail.companyId}">${companyDetail.companyName}</a></div>
            <div class="storepages_pic_area">
                <img src="<%=contextPath%>/GetCompanyBannerServlet?companyId=${companyDetail.companyId}&action=companyBanner" width="1200px" height="500px" alt="">
            </div>
            <div class="storepages_name">${companyDetail.companyName}</div>
            <div class="storepages_description_area">
            <div class="storepages_description">　　${companyDetail.companyIntro}</div>
            </div>
            <div class="goods_title01 ">我們的商品</div>

            <ul class="goods_area ">

            <c:forEach items="${ourProduct}" var="ProductBO" >
                <li class="single_good_area" onclick="location.href='<%=contextPath %>/GetProductServlet?productId=${ProductBO.productId}'">
                    <div class="good_headpic"><img class="good_headpic_img" src="<%=contextPath %>/ProductPicServlet?productId=${ProductBO.productId}&productSequence=0&action=firstPic" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart toWishList "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart offWishList "></i></div>
                    <span class="good_headsupplier">${ProductBO.companyName}</span>	
                    <a class="good_headname"><h5>${ProductBO.productName}</h5></a>
                    <span class="good_headprice">售價${ProductBO.productPrice}</span>
                    <input type="hidden" class="data_product_id" value="${ProductBO.productId}">
                </li>
            </c:forEach>
            
			<c:forEach  items="${listwp}" var="wp">
                    <input type="hidden" class="wish_list" value="${wp}">
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
    <script type='text/javascript' src='<%=contextPath%>/shop/code/header.js'></script>
    <script type='text/javascript' src='<%=contextPath%>/shop/code/wishlist.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html>