<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>購物車</title>
    <link rel="stylesheet" type="text/css" href="./code/style.css">


</head>

<body>
    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>

    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">

        <div class="goodsindex_innercontent ">
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
                <ul class="cart_product_content_area">
                    <ul class="cart_product_content">
                        <li class="cart_product_content1"><input type="checkbox" name="choose"></li>
                        <li class="cart_product_content2"><img src="img\product_pic_01.jpg" alt=""></li>
                        <li class="cart_product_content3"><span>Arc'teryx 始祖鳥</span></li>
                        <li class="cart_product_content4"><span>聚酯纖維彈性襯衫</span></li>
                        <li class="cart_product_content5"><span>L</span></li>
                        <li class="cart_product_content6"><span>黑色</span></li>
                        <li class="cart_product_content7">NT&ensp;<span class="cart_single_item_price">1390</span></li>
                        <li class="cart_product_content8">
                            <div class="carts_adjust_qty">
                                <i class="fas fa-minus carts_adjust_qty_icon"></i>
                                <span class="carts_adust_item_qty">1</span>
                                <i class="fas fa-plus carts_adjust_qty_icon"></i>
                            </div>
                        </li>
                        <li class="cart_product_content9">NT&ensp;<span class="cart_item_price"></span></li>
                        <li class="cart_product_content10"><span>移除</span></li>
                    </ul>
                    <ul class="cart_product_content">
                        <li class="cart_product_content1"><input type="checkbox" name="choose"></li>
                        <li class="cart_product_content2"><img src="img\product_pic_01.jpg" alt=""></li>
                        <li class="cart_product_content3"><span>Arc'teryx 始祖鳥</span></li>
                        <li class="cart_product_content4"><span>聚酯纖維彈性襯衫</span></li>
                        <li class="cart_product_content5"><span>L</span></li>
                        <li class="cart_product_content6"><span>黑色</span></li>
                        <li class="cart_product_content7">NT&ensp;<span class="cart_single_item_price">1390</span></li>
                        <li class="cart_product_content8">
                            <div class="carts_adjust_qty">
                                <i class="fas fa-minus carts_adjust_qty_icon"></i>
                                <span class="carts_adust_item_qty">1</span>
                                <i class="fas fa-plus carts_adjust_qty_icon"></i>
                            </div>
                        </li>
                        <li class="cart_product_content9">NT&ensp;<span class="cart_item_price"></span></li>
                        <li class="cart_product_content10"><span>移除</span></li>
                    </ul>
                    <ul class="cart_product_content">
                        <li class="cart_product_content1"><input type="checkbox" name="choose"></li>
                        <li class="cart_product_content2"><img src="img\product_pic_01.jpg" alt=""></li>
                        <li class="cart_product_content3"><span>Arc'teryx 始祖鳥</span></li>
                        <li class="cart_product_content4"><span>聚酯纖維彈性襯衫</span></li>
                        <li class="cart_product_content5"><span>L</span></li>
                        <li class="cart_product_content6"><span>黑色</span></li>
                        <li class="cart_product_content7">NT&ensp;<span class="cart_single_item_price">1390</span></li>
                        <li class="cart_product_content8">
                            <div class="carts_adjust_qty">
                                <i class="fas fa-minus carts_adjust_qty_icon"></i>
                                <span class="carts_adust_item_qty">1</span>
                                <i class="fas fa-plus carts_adjust_qty_icon"></i>
                            </div>
                        </li>
                        <li class="cart_product_content9">NT&ensp;<span class="cart_item_price"></span></li>
                        <li class="cart_product_content10"><span>移除</span></li>
                    </ul>
                    <ul class="cart_product_content">
                        <li class="cart_product_content1"><input type="checkbox" name="choose"></li>
                        <li class="cart_product_content2"><img src="img\product_pic_01.jpg" alt=""></li>
                        <li class="cart_product_content3"><span>Arc'teryx 始祖鳥</span></li>
                        <li class="cart_product_content4"><span>聚酯纖維彈性襯衫</span></li>
                        <li class="cart_product_content5"><span>L</span></li>
                        <li class="cart_product_content6"><span>黑色</span></li>
                        <li class="cart_product_content7">NT&ensp;<span class="cart_single_item_price">1390</span></li>
                        <li class="cart_product_content8">
                            <div class="carts_adjust_qty">
                                <i class="fas fa-minus carts_adjust_qty_icon"></i>
                                <span class="carts_adust_item_qty">1</span>
                                <i class="fas fa-plus carts_adjust_qty_icon"></i>
                            </div>
                        </li>
                        <li class="cart_product_content9">NT&ensp;<span class="cart_item_price"></span></li>
                        <li class="cart_product_content10"><span>移除</span></li>
                    </ul>
                    <ul class="cart_product_content">
                        <li class="cart_product_content1"><input type="checkbox" name="choose"></li>
                        <li class="cart_product_content2"><img src="img\product_pic_01.jpg" alt=""></li>
                        <li class="cart_product_content3"><span>Arc'teryx 始祖鳥</span></li>
                        <li class="cart_product_content4"><span>聚酯纖維彈性襯衫</span></li>
                        <li class="cart_product_content5"><span>L</span></li>
                        <li class="cart_product_content6"><span>黑色</span></li>
                        <li class="cart_product_content7">NT&ensp;<span class="cart_single_item_price">1390</span></li>
                        <li class="cart_product_content8">
                            <div class="carts_adjust_qty">
                                <i class="fas fa-minus carts_adjust_qty_icon"></i>
                                <span class="carts_adust_item_qty">1</span>
                                <i class="fas fa-plus carts_adjust_qty_icon"></i>
                            </div>
                        </li>
                        <li class="cart_product_content9">NT&ensp;<span class="cart_item_price"></span></li>
                        <li class="cart_product_content10"><span>移除</span></li>
                    </ul>
                </ul>
                <div class="cart_end_gap"></div>
                <ul class="cart_end_area">
                    <li><input class="selectallcart" type="checkbox" for="" name="selectallcart">&ensp;全選</li>
                    <li><span>全部移除</span></li>
                    <li>總金額(不含運費)：NT&ensp;<span class="cart_total_price">0</span></li>
                    <li onclick="location.href='goods_payment_check.jsp'">前往結帳</li>
                </ul>
            </div>
        </div>
    </div>

    <!-- 商店首頁 結束-->
    
    <!-- 插入 商城頁尾-->
<%@ include file="goods_footer.jsp" %>

    <!-- 載入jQuery -->
    <!-- <script type='text/javascript' src='./code/jquery-3.6.0.js'></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- 載入index.js -->
    <script type='text/javascript' src='./code/index.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html>