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
    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>

    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">
        <div class="goodsindex_innercontent ">
            <div class="goods_breadcrumb"><a href="goods_index.html">攻山小物</a> > <a href="goods_all_products.html">全部品牌</a> >  <a href="goods_all_products.html">Arc'teryx始祖鳥</a></div>
            <div class="storepages_pic_area">
                <img src="img\arc'teryx_page_01.jpg" width="1200px" height="500px" alt="">
            </div>
            <div class="storepages_name ">Arc'teryx 始祖鳥</div>
            <div class="storepages_description_area">
            <div class="storepages_description">　　來自加拿大的頂級戶外品牌Arc'teryx，追求產品傑出性能表現，執著於每一個小細節。擁有獨一無二的內部製模和設計中心，實現前所未有的創意，製造出最頂尖的產品。1989年創立於加拿大溫哥華，至今其總部，設計工作室，和主要生產線依然在溫哥華。
                </br>　　由於其對新工藝和新技術近乎瘋狂的追求，在短短十幾年時間內，成長成為公認的北美乃至全球領導型的戶外品牌，在服裝和背包領域類有著不錯的 產品。Arc'teryx的產品線今天依然只涉及戶外服裝、背包和攀登護具。
                由於Arc'teryx對新技術和新工藝近乎瘋狂的追求，以及對產品設計和做工不惜工本的強調，Arc'teryx迅速被公認為最高端的戶外 品牌之一，同時也帶來通常不菲的售價。
                Arc'teryx的產品幾乎件件都可以用藝術品來形容，而且服裝的功能完善，細節出色，給戶外使用者 充分的體驗和完善的保護。</div>
            </div>
            <div class="goods_title01 ">我們的商品</div>

            <ul class="goods_area ">
                <!-- https://i.imgur.com/1EiiZs2.png -->
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
            </ul>

            <!-- 分頁標籤與分頁查詢功能 -->
            <div class="page_num">
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
    <script type='text/javascript' src='<%=contextPath%>/shop/code/index.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html>