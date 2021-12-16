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
    <title>各類商品</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">

</head>

<body>
    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>

    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">
        <div class="goodsindex_innercontent ">
            <div class="goods_breadcrumb"><a href="goods_index.html">攻山小物</a> > <a href="goods_all_products.html">全部商品</a> >  <a href="goods_all_products.html">衣著/鞋子/背包</a></div>
            <div class="goods_title01 ">衣著/鞋子/背包</div>
            <ul class="goods_area ">
            
			<c:forEach  items="${listTypeProductBO}" var="ProductBO">
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

            <!-- 分頁標籤與分頁查詢功能 -->
            <!-- <div class="page_num">
                <ul>
                    <li class="page_num_two_words"><a href="">首頁</a></li>
                    <li class="page_num_three_words"><a href="">上一頁</a></li>
                    <li class="current_page_num"><a href="">1</a></li>
                    <li><a href="">2</a></li>
                    <li><a href="">3</a></li>
                    <li><a href="">4</a></li>
                    <li><a href="">5</a></li>
                    <li class="page_num_three_words"><a href="">下一頁</a></li>
                    <li class="page_num_two_words"><a href="">末頁</a></li>
                </ul>
            </div> -->
             <!-- 看更多功能 -->
             <input type="hidden" class="see_more_pages_ProductType" name="ProductType" value="${listTypeProductBO[0].productType}">
             <input type="hidden" class="see_more_pages_pageNum" name="pageNum" value="2">
             <div class="see_more">
                <div class="see_more_button see_more_button_kindproduct">看更多</div>
             </div>
        </div>
    </div>

    <!-- 商店首頁 結束-->

    <!-- 插入 商城頁尾-->
<%@ include file="goods_footer.jsp" %>

    <!-- 載入jQuery -->
    <!-- <script type='text/javascript' src='<%=contextPath%>/shop/code/jquery-3.6.0.js'></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- 載入jQuery form-->
    <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
    <!-- 載入index.js -->
    <script type='text/javascript' src='<%=contextPath%>/shop/code/header.js'></script>
    <script type='text/javascript' src='<%=contextPath%>/shop/code/wishlist.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html>