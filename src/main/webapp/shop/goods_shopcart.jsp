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
    <title>購物車</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">

    <script type='text/javascript'>
    
//  提交購物車form，移除購物車項目
    function submitRemoveCartItem(){
    	$("#removeCartItem").ajaxSubmit(function(message) {
	    	console.log("提交form,RemoveCartItem OK!!")
    	});
    	return false
    }
    
//  提交購物車form，清空購物車
    function submitCleanCartItem(){
    	$("#cleanCartItem").ajaxSubmit(function(message) {
	    	console.log("提交form,cleanCartItem OK!!")
    	});
    	
    	return false
    }    
    
//  提交購物車form，改數量
    function submitChangeItemQTY(){
    	$("#changeItemQTY").ajaxSubmit(function(message) {
	    	console.log("提交form,changeItemQTY OK!!")
    	});	
    	
    	return false
    }
    </script>

</head>

<body>
    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>

    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">

        <div class="goodsindex_innercontent ">
			<!-- 結帳 -->
            <form method="get" action="<%=contextPath%>/PurchaseServlet" id="PurchaseProduct">
       			<input type="hidden" name="method" value="buyCart">
            
            <ul class="cart_top_title_area_01">
                <li style="color: rgb(51, 51, 51);">查看購物車</li>
                <li><i class="fas fa-arrow-circle-right" style="color: rgb(51, 51, 51);"></i></li>
                <li>訂單確認</li>
                <li><i class="fas fa-arrow-circle-right"></i></li>
                <li>訂單完成</li>
            </ul>
            <div class="goods_title01 ">購物車</div>
            <div class="cart_area">
                <ul class="cart_top_title_area_02">
                    <li>選擇</li>
                    <li>商品圖片</li>
                    <li>店名</li>
                    <li>商品訊息</li>
                    <li>尺寸</li>
                    <li>顏色</li>
                    <li>售價</li>
                    <li>數量</li>
                    <li>小計</li>
                    <li>移除此項</li>
                </ul>
                       
						<!-- 刪除全部 -->
                        <form method="get" action="<%=contextPath%>/CartServlet" id="cleanCartItem" onsubmit="return submitCleanCartItem();">
                            <input type="hidden" name="method" value="cleanCartItem" id="cleanCartItemInput" >
                        </form>

                <ul class="cart_product_content_area">
         		  <c:forEach items="${cart.cartItems}" var="cartItem" varStatus="s">
                    <ul class="cart_product_content">
                        <li class="cart_product_content1"><input class="chooseItem" type="checkbox" name="choose" ></li>
                        <li class="cart_product_content2"><img src="<%=contextPath %>/ProductPicServlet?productId=${cartItem.productId}&productSequence=0&action=firstPic" alt=""></li>
                        <li class="cart_product_content3"><span>${cartItem.companyName}</span></li>
                        <li class="cart_product_content4"><span>${cartItem.productName}</span></li>
                        <li class="cart_product_content5"><span class="product_page_productSize">${cartItem.productSize}</span></li>
                        <li class="cart_product_content6"><span>${cartItem.productColor}</span></li>
                        <li class="cart_product_content7">NT&ensp;<span class="cart_single_item_price">${cartItem.productPrice}</span></li>
                        <li class="cart_product_content8">
                            <div class="carts_adjust_qty">
                                <i class="fas fa-minus carts_adjust_qty_icon"></i>
                                <span class="carts_adust_item_qty">${cartItem.itemQTY}</span>
                                <i class="fas fa-plus carts_adjust_qty_icon"></i>
                            </div>
                        </li>
                        <li class="cart_product_content9">NT&ensp;<span class="cart_item_price">${cartItem.subtotalPrice}</span></li>
                        <li class="cart_product_content10"><span>移除</span></li>
                        	<!-- 移除項目-->
                         <form method="get" action="<%=contextPath%>/CartServlet" id="removeCartItem" onsubmit="return submitRemoveCartItem();">
                            <input type="hidden" name="method" value="removeCartItem">
                            <input type="hidden" class="removeCartItem_productDesId" name="productDesId" value="${cartItem.prodesId}">
                        </form>
                        	<!-- 改數量 -->
                        <form method="get" action="<%=contextPath%>/CartServlet" id="changeItemQTY" onsubmit="return submitChangeItemQTY();">
                            <input type="hidden" name="method" value="changeItemQTY">
                            <input type="hidden" class="changeItemQTY_productDesId" name="productDesId" value="${cartItem.prodesId}">
                            <input type="hidden" class="changeItemQTY_itemQTY"name="itemQTY" value="">
                        </form>
                        	<!-- 結帳 -->
       				         <%-- <input type="hidden" class="cartItem_companyId" value="${cartItem.companyId}"> --%>
       				         <input type="hidden" class="buyCart_cartItem_prodesId" name="${s.count}" value="prodesId"><!-- 只取每個項目的prodesId -->
       				         <%-- <input type="hidden" class="buyCart_cartItem_itemQTY" name="${s.count}itemQTY" value="">
       				         <input type="hidden" class="buyCart_cartItem_companyId" name="${s.count}companyId" value="">
       				         <input type="hidden" class="buyCart_cartItem_companyId" name="${s.count}productId" value="">
       				         <input type="hidden" class="buyCart_cartItem_companyId" name="${s.count}companyName" value="">
       				         <input type="hidden" class="buyCart_cartItem_companyId" name="${s.count}productSize" value="">
       				         <input type="hidden" class="buyCart_cartItem_companyId" name="${s.count}productColor" value="">
       				         <input type="hidden" class="buyCart_cartItem_companyId" name="${s.count}productPrice" value="">
       				         <input type="hidden" class="buyCart_cartItem_companyId" name="${s.count}subtotalPrice" value=""> --%>
                    </ul>
                   </c:forEach> 
                   
                </ul>
                <div class="cart_end_gap"></div>
                <ul class="cart_end_area">
                    <li><input class="selectallcart" type="checkbox" name="selectallcart">&ensp;全選</li>
                    <li><span>全部移除</span></li>
                    <li>總金額(不含運費)：NT&ensp;<span class="cart_total_price">${cart.totalPrice}</span></li>
                    <li id="go_to_pay">前往結帳</li>
                </ul>
            </div>
            
           <!-- 結帳的/form -->
           </form>
        </div>
    </div>

    <!-- 商店首頁 結束-->
    
    <!-- 插入 商城頁尾-->
<%@ include file="goods_footer.jsp" %>

    <!-- 載入jQuery -->
    <!-- <script type='text/javascript' src='<%=contextPath%>/shop/code/jquery-3.6.0.js'></script> -->
    <script type='text/javascript' src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- 載入jQuery form-->
    <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
    <!-- 載入index.js -->
    <script type='text/javascript' src='<%=contextPath%>/shop/code/header.js'></script>
    <script type='text/javascript' src='<%=contextPath%>/shop/code/cart.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html>