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
    <title>訂單確認</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">


</head>

<body>

    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>


    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">

        <div class="goodsindex_innercontent ">
            <ul class="cart_top_title_area_01">
                <li>查看購物車</li>
                <li><i class="fas fa-arrow-circle-right"></i></li>
                <li style="color: rgb(51, 51, 51);">訂單確認</li>
                <li style="color: rgb(51, 51, 51);"><i class="fas fa-arrow-circle-right"></i></li>
                <li>訂單完成</li>
            </ul>
            <div class="goods_title01 ">訂單確認</div>
            <div class="payment_check_order_area">

                <div class="payment_check_order_title">請填寫收貨地址</div>
                <input class="payment_fill_address" type="text" placeholder="縣市" style="width: 60px;">
                <input class="payment_fill_address" type="text" placeholder="鄉鎮市區" style="width: 60px;">
                <input class="payment_fill_address" type="text" placeholder="道路街" style="width: 120px;">
                <input class="payment_fill_address" type="text" placeholder="巷" style="width: 40px;">
                <input class="payment_fill_address" type="text" placeholder="弄" style="width: 40px;">
                <input class="payment_fill_address" type="text" placeholder="號" style="width: 40px;">
                <input class="payment_fill_address" type="text" placeholder="樓" style="width: 40px;">
                <input class="payment_fill_address" type="text" placeholder="室" style="width: 40px;">
                <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">請選擇付款方式</div>
                <input class="payment_fill_payway" type="radio" checked>&ensp;信用卡
                <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">商品詳情：</div>
                <div>
                    <div class="payment_check_order_area_company">
                        <div class="payment_check_order_area_company_title">訂單一</div>
                        <div class="payment_check_order_detail_area">
                            <ul class="payment_check_order_detail_title">
                                <li>商品圖片</li>
                                <li>店名</li>
                                <li>商品訊息</li>
                                <li>尺寸</li>
                                <li>顏色</li>
                                <li>售價</li>
                                <li>數量</li>
                                <li>小計</li>
                            </ul>
                            
         				   <c:forEach items="${orderDes}" var="orderDes" >
                            <ul class="payment_check_order_detail">
                                <li class=""><img src="img\product_pic_01.jpg" alt=""></li>
                                <li class=""><span>Arc'teryx 始祖鳥</span></li>
                                <li class=""><span>聚酯纖維彈性襯衫</span></li>
                                <li class=""><span>L</span></li>
                                <li class=""><span>黑色</span></li>
                                <li class="">NT&ensp;<span class="">1390</span></li>
                                <li class=""><span>2</span></li>
                                <li class="">NT&ensp;<span class="">1390</span></li>
                            </ul>
                            </c:forEach>
                        </div>
                        <div class="payment_check_order_area_company_shipfee">運費：NT$<span>100</span></div>
                    </div>
                </div>
                <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">付款詳細資料</div>
                <ul>
                    <li style="margin-bottom: 10px;">信用卡類型：
                        <input class="payment_fill_credit_type" name="payment_fill_credit_type" value="visa"
                            type="radio"><img src="img\credit_logo_visa.jpg" width="50px">
                        <input class="payment_fill_credit_type" name="payment_fill_credit_type" value="mastercard"
                            type="radio"><img src="img\credit_logo_mastercard.jpg" width="50px">
                        <input class="payment_fill_credit_type" name="payment_fill_credit_type" value="JCB"
                            type="radio"><img src="img\credit_logo_JCB.jpg" width="50px">
                    </li>
                    <li style="margin-bottom: 10px;">信用卡號碼：
                        <input class="payment_fill_credit_num" name="payment_fill_credit_num" type="text" maxlength="4"
                            style="width: 50px;">&ensp;-&ensp;
                        <input class="payment_fill_credit_num" name="payment_fill_credit_num" type="text" maxlength="4"
                            style="width: 50px;">&ensp;-&ensp;
                        <input class="payment_fill_credit_num" name="payment_fill_credit_num" type="text" maxlength="4"
                            style="width: 50px;">&ensp;-&ensp;
                        <input class="payment_fill_credit_num" name="payment_fill_credit_num" type="text" maxlength="4"
                            style="width: 50px;">
                    </li>
                    <li style="margin-bottom: 10px;">到期月份：
                        <select name="expire_month" style="width: 70px;">
                            <option value="">月份</option>
                            <option value="1">一月</option>
                            <option value="2">二月</option>
                            <option value="3">三月</option>
                            <option value="4">四月</option>
                            <option value="5">五月</option>
                            <option value="6">六月</option>
                            <option value="7">七月</option>
                            <option value="8">八月</option>
                            <option value="9">九月</option>
                            <option value="10">十月</option>
                            <option value="11">十一月</option>
                            <option value="12">十二月</option>
                        </select>
                    </li>
                    <li style="margin-bottom: 10px;">到期年份：
                        <select name="expire_year" style="width: 70px;">
                            <option value="">年份</option>
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                            <option value="2025">2025</option>
                            <option value="2026">2026</option>
                        </select>
                    </li>
                    <li style="margin-bottom: 10px;">CVN：
                        <input class="payment_fill_CVN" name="payment_fill_CVN" type="text" style="width: 40px;">
                    </li>
                </ul>
                <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">山山點數</div>
                <input class="payment_points_range" type="range" checked min="0" max="100" value="0"> 使用點數：
                <span class="payment_points_num">0</span>
                <div class="point_game_rule">*遊戲規則：
                    <br>&ensp;&ensp;&ensp;a. 使用山山點數可以獲得商品金額折扣。
                    <br>&ensp;&ensp;&ensp;b. 使用1點可以獲得0.1%的折扣。
                    <br>&ensp;&ensp;&ensp;c. 每次結帳最多可以獲取商品金額5%的折扣。
                    <br>&ensp;&ensp;&ensp;d. 每次結帳可使用的最大點數為商品金額的5%。
                </div>
                <div class="cart_end_gap" style="margin-top: 10px;"></div>
            </div>

            <div class="payment_check_order_endarea">
                <ul class="payment_check_total_price">
                    <ul>
                        <li>&ensp;NT$&ensp;<span>1,000</span></li>
                        <li>&ensp;NT$&ensp;<span>200</span></li>
                        <li>&ensp;NT$&ensp;<span>1,200</span></li>
                    </ul>
                    <ul>
                        <li>商品金額：</li>
                        <li>運費：</li>
                        <li>應付總金額：</li>
                    </ul>
                </ul>
                <ul class="payment_check_end_botton">
                    <li class="payment_back_carts" onclick="location.href='goods_shopcart.jsp'">返回購物車</li>
                    <li class="payment_confirm_pay" onclick="location.href='goods_payment_complete.jsp'">確認訂單並付款</li>
                </ul>


            </div>
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
    <script type='text/javascript' src='<%=contextPath%>/shop/code/chekc_order.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html>