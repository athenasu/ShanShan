<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.shop.service.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.product.entity.*"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath();%>

<%
 
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品頁面</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">



    <script type='text/javascript'>
			function subForm() {
		    	$("#product_format_detail").ajaxSubmit(function(message) {
			    	console.log("提交form到CartServlet")
		    	});
		    	return false
			}
			
	</script>

</head>

<body>
    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>


    <!-- 商品頁面 開始-->
    <!-- 圖片區 -->
    <div class="product_main_area">

        <!-- 圖片區 五圖輪播-->
        <div class="product_slideshow_pages">
            <div class="product_slideshow_contrl"><i class="fas fa-sort-up product_slideshow_contrl_icon_up"></i></div>
            <div class="product_wrapping_slidesarea">
                <ul class="product_slideshow_pages_ul">
              	  	<c:forEach items="${listAllPic}" var="ProductImgBO" varStatus="p">
                    <li class="product_slideshow_pics"><img src="<%=contextPath %>/ProductPicServlet?productId=${ProductImgBO.product_id}&productSequence=${p.count}&action=thePic" alt=""></li>
                	</c:forEach>
                </ul>
            </div>
            <div class="product_slideshow_contrl"><i class="fas fa-sort-down product_slideshow_contrl_icon_down"></i>
            </div>
        </div>
        <!-- 圖片區 首圖-->
        <div class="product_pic_area">
            <div class="product_slideshow_main" ><img src="<%=contextPath%>/ProductPicServlet?productId=${listProductDetail[0].productId}&productSequence=0&action=firstPic"></div>
        </div>



        <!-- 產品規格區-->
        <div class="product_format_detail_area">
            <div class="product_format_detail_breadcrumb">全部商品 > ${porductTypeName} > ${listProductDetail[0].productName}</div>
          		<div class="product_format_detail_name">品名：${listProductDetail[0].productName}</div>
            	<div class="product_format_detail_id">商品編號：${listProductDetail[0].productId}</div>
            	<div class="product_format_detail_price">售價：NT ${listProductDetail[0].productPrice}</div>
            <form method="get" id="product_format_detail" action="<%=contextPath%>/CartServlet" onsubmit="return subForm();">
            
                <input class="submit_method" type="hidden" name="method" value="addCartItem" ">
            	<div class="product_format_detail_style">樣式：
             		<c:forEach items="${listProductDetail}" var="listProductDetail" >
                    <div class="product_format_detail_style_each">
                	    <input class="product_format_detail_radio" type="radio" name="productDesId" value="${listProductDetail.prodesId}" checked >&ensp;${listProductDetail.productColor}&ensp;/&ensp;<span class="product_page_productSize">${listProductDetail.productSize}</span>&ensp;
                    </div>
                    </c:forEach>
            	</div>
            	<div class="product_format_detail_qty">數量：
                    <div class="product_adjust_qty">
                        <i class="fas fa-minus product_adjust_qty_icon"></i>
                        <input class="product_adust_item_qty_value" type="hidden" value="1" name="itemQTY">
                        <span class="product_adust_item_qty">1</span>
                        <i class="fas fa-plus product_adjust_qty_icon"></i>
                    </div>
                </div>
            </form>
           		<div class="product_format_detail_payway">付款方式：
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_payway" value="信用卡" checked>&ensp;信用卡
           		</div>
           		<div class="product_format_detail_deliveryway">配送方式：
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_deliveryway" value="宅配" checked>&ensp;宅配
            	</div>
            <div class="product_format_detail_buttons">
                   <div class="product_format_detail_button_1" >直接購買</div>
                   <div class="product_format_detail_button_2" >加入購物車</div>
                </div>
            <div class="product_format_detail_remark">※ 備註：如果商品是貼身衣物，則無法退貨。</div>
        </div>
    </div>


    <!-- 產品介紹簡介區-->
    <div class="product_intro_area">

        <div class="product_intro_description_area">

            <div class="goods_prodcut_title">商品詳情</div>

            <!-- 產品 文檔區-->
            <div class="product_intro_description">${listProductDetail[0].productIntro}</div>
        </div>
    </div>


    <!-- 相關產品區-->
    <div class="goods_product_innercontent ">
        <div class="goods_prodcut_title ">其他熱門商品</div>
        <ul class="goods_area">
            <c:forEach items="${popular5}" var="ProductBO" >
                <li class="single_good_area" onclick="location.href='<%=contextPath %>/GetProductServlet?productId=${ProductBO.productId}'">
                    <div class="good_headpic"><img class="good_headpic_img" src="<%=contextPath %>/ProductPicServlet?productId=${ProductBO.productId}&productImgId=0&action=firstPic" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart toWishList"></i></div>
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

    <!-- 商品頁面 結束-->

    <!-- 插入 商城頁尾-->
<%@ include file="goods_footer.jsp" %>


    <!-- 載入jQuery -->
    <!-- <script type='text/javascript' src='<%=contextPath%>/shop/code/jquery-3.6.0.js'></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- 載入jQuery form-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
    <!-- 載入index.js -->
    <script type='text/javascript' src='<%=contextPath%>/shop/code/header.js'></script>
    <script type='text/javascript' src='<%=contextPath%>/shop/code/wishlist.js'></script>
    <script type='text/javascript' src='<%=contextPath%>/shop/code/product_page.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html>