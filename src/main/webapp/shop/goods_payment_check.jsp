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


                <form method="get" action="<%=contextPath%>/PaymentResultServlet" id="PaymentResultServlet">
                
                <div class="payment_check_order_title">請填寫收件人姓名</div>
                <input class="payment_fill_name" type="text" placeholder="王小明" style="width: 80px;" name="fill_name">
                <div class="payment_check_order_title">請填寫收件人電話</div>
                <input class="payment_fill_phone" type="text" placeholder="09..." style="width: 100px;" name="fill_phone">
                <div class="payment_check_order_title">請填寫收貨地址</div>
                <input class="payment_address" type="hidden" name="address" value="">
                <input class="payment_fill_address" type="text" placeholder="縣市" style="width: 60px;">
                <input class="payment_fill_address" type="text" placeholder="鄉鎮市區" style="width: 60px;">
                <input class="payment_fill_address" type="text" placeholder="道路街" style="width: 120px;">
                <input class="payment_fill_address" type="text" placeholder="巷" style="width: 40px;">
                <input class="payment_fill_address" type="text" placeholder="弄" style="width: 40px;">
                <input class="payment_fill_address" type="text" placeholder="號" style="width: 40px;">
                <input class="payment_fill_address" type="text" placeholder="樓" style="width: 40px;">
                <input class="payment_fill_address" type="text" placeholder="室" style="width: 40px;" >
                <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">請選擇付款方式</div>
                <input class="payment_fill_payway" type="radio" checked>&ensp;信用卡
                <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">商品詳情：</div>
                <div>
                    <div class="payment_check_order_area_company">
         				<c:forEach items="${orderList}" var="orderList" varStatus="s">
                        <div class="payment_check_order_area_company_title">訂單${s.count}</div>
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
                            
         					<c:forEach items="${orderList.orderDesBOList}" var="orderDesBOList" >
                            <ul class="payment_check_order_detail">
                                <li class=""><img src="<%=contextPath %>/ProductPicServlet?productId=${orderDesBOList.product_id}&productSequence=0&action=firstPic" alt=""></li>
                                <li class=""><span>${orderDesBOList.company_name}</span></li>
                                <li class=""><span>${orderDesBOList.product_name}</span></li>
                                <li class=""><span>${orderDesBOList.product_size}</span></li>
                                <li class=""><span>${orderDesBOList.product_color}</span></li>
                                <li class="">NT&ensp;<span class="">${orderDesBOList.order_description_price}</span></li>
                                <li class=""><span>${orderDesBOList.product_quantity}</span></li>
                                <li class="">NT&ensp;<span class="">${orderDesBOList.subtotal_price}</span></li>
                            </ul>
                            </c:forEach>
                            <ul class="payment_current_point">
                       		         您現有的山山點數為：
                                <span class="payment_current_point_num">${memberPoint}</span>
                         		       ，使用&ensp;<span class="payment_usepoints_num">0</span>&ensp;點取得對應折扣。&ensp;
                                 <input class="payment_points_range" type="range" min="0" max="50" step="1" value="0" >
          					     <input class="payment_usedPoints" type="hidden" name="${s.index}point">
          					     <input class="payment_sumAfter" type="hidden" name="${s.index}sumAfter">
                            </ul>
                            <ul class="payment_check_order_area_company_shipfee">
                                <li class="this_ship_fee">0</li>
                                <li>本訂單運費：&ensp;NT$&ensp;</li>
                            </ul>
                            <ul class="payment_check_order_area_company_totalfee">
                                <li class="this_sum_before">${orderList.order_sum_before}</li>
                                <li>折扣前金額：&ensp;NT$&ensp;</li>
                            </ul>
                            <ul class="payment_check_order_area_company_totalfee ">
                                <li class="this_sum_after">${orderList.order_sum_after}</li>
                                <li>折扣後金額：&ensp;NT$&ensp;</li>
                            </ul>
                        </div>
                        </c:forEach>
                        
                    </div>
                </div>
                <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">山山點數 遊戲規則</div>
                <div class="point_game_rule">
                    &ensp;&ensp;&ensp;a. 使用山山點數可以獲得商品金額折扣。
                    <br>&ensp;&ensp;&ensp;b. 使用1點可以獲得0.1%的折扣。
                    <br>&ensp;&ensp;&ensp;c. 每張訂單最多可以獲取商品金額5%的折扣。
                </div>
                
                <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">付款詳細資料</div>
                <ul>
                    <li style="margin-bottom: 10px;">信用卡類型：
                        <input class="payment_fill_credit_type" name="" value="visa"
                            type="radio"><img src="<%=contextPath %>/shop/img/credit_logo_visa.jpg" width="50px">
                        <input class="payment_fill_credit_type" name="" value="mastercard"
                            type="radio"><img src="<%=contextPath %>/shop/img/credit_logo_mastercard.jpg" width="50px">
                        <input class="payment_fill_credit_type" name="" value="JCB"
                            type="radio"><img src="<%=contextPath %>/shop/img/credit_logo_JCB.jpg" width="50px">
                    </li>
                    <li style="margin-bottom: 10px;">信用卡號碼：
                        <input class="payment_fill_credit_num" name="" type="text" maxlength="4"
                            style="width: 50px;">&ensp;-&ensp;
                        <input class="payment_fill_credit_num" name="" type="text" maxlength="4"
                            style="width: 50px;">&ensp;-&ensp;
                        <input class="payment_fill_credit_num" name="" type="text" maxlength="4"
                            style="width: 50px;">&ensp;-&ensp;
                        <input class="payment_fill_credit_num" name="" type="text" maxlength="4"
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
               <!--  <div class="cart_end_gap2"></div>
                <div class="payment_check_order_title">山山點數</div>
                <div class="payment_current_point">您的現有點數為：</div>
                <div class="payment_current_point_num">1,203</div>
                <div>
                    <input class="payment_points_range" type="range" checked min="0" max="100" value="0"> 
                    <div class="payment_usepoints">&ensp;使用點數：</div>
                    <div class="payment_usepoints_num">0</div>
                </div>
                <div class="point_game_rule">*遊戲規則：
                    <br>&ensp;&ensp;&ensp;a. 使用山山點數可以獲得商品金額折扣。
                    <br>&ensp;&ensp;&ensp;b. 使用1點可以獲得0.1%的折扣。
                    <br>&ensp;&ensp;&ensp;c. 每次結帳最多可以獲取商品金額5%的折扣。
                    <br>&ensp;&ensp;&ensp;d. 每次結帳可使用的最大點數為商品金額的5%。
                </div> -->
                
                <div class="cart_end_gap" style="margin-top: 10px;"></div>
                </form>
            </div>

            <div class="payment_check_order_endarea">
                <ul class="payment_check_sum_before">
                    <li class="sum_before_num">1,200</li>
                    <li>折扣前金額：&ensp;NT$&ensp;</li>
                </ul>
                
                <ul class="payment_check_shipping_fee">
                    <li class="shipping_fee_num">0</li>
                    <li>總運費：&ensp;NT$&ensp;</li>
                </ul>

                <ul class="payment_check_sum_after">
                    <li class="sum_after_num">1,200</li>
                    <li>應付總金額：&ensp;NT$&ensp;</li>
                </ul>
               
                <ul class="payment_check_end_botton">
                    <li class="payment_back_carts" onclick="location.href='<%=contextPath%>/CartServlet?method=mycart'">返回購物車</li>
                    <li class="payment_confirm_pay" >確認訂單並付款</li>
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
    <!-- 載入jQuery form-->
    <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.js"></script>
    <!-- 載入index.js -->
    <script type='text/javascript' src='<%=contextPath%>/shop/code/header.js'></script>
    <script type='text/javascript' src='<%=contextPath%>/shop/code/chekc_order.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html>