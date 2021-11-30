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
    <title>所有商品</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">


</head>

<body>

    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>


    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">
        <div class="goodsindex_innercontent ">
            <div class="goods_breadcrumb"><a href="goods_index.html">攻山小物</a> > <a href="goods_all_products.html">全部商品</a></div>
            <div class="goods_title01 ">全部商品</div>
            <ul class="goods_area ">
                <!-- https://i.imgur.com/1EiiZs2.png -->
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">山山巧福</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">The North Face</span>
                    <a class="good_headname">
                        <h5>有機棉法蘭絨襯衫</h5>
                    </a>
                    <span class="good_headprice">售價2,200元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Marmot</span>
                    <a class="good_headname">
                        <h5>有機棉水洗牛津布八分褲</h5>
                    </a>
                    <span class="good_headprice">售價2,190元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Patagonia</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性起毛錐形褲</h5>
                    </a>
                    <span class="good_headprice">售價1,230元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Gregory</span>
                    <a class="good_headname">
                        <h5>輕量羽絨可攜式無領外套</h5>
                    </a>
                    <span class="good_headprice">售價1,760元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">WELL FIT威飛客</span>
                    <a class="good_headname">
                        <h5>輕量羽絨可攜式無領背心</h5>
                    </a>
                    <span class="good_headprice">售價2,010元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">山野倉庫</span>
                    <a class="good_headname">
                        <h5>防撥水彈性6口袋外套</h5>
                    </a>
                    <span class="good_headprice">售價1,450元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>羽絨可攜式立領背心</h5>
                    </a>
                    <span class="good_headprice">售價390元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">HAGLOFS</span>
                    <a class="good_headname">
                        <h5>透氣撥水防水連帽外套</h5>
                    </a>
                    <span class="good_headprice">售價3,330元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">FIZAN</span>
                    <a class="good_headname">
                        <h5>超長棉二重織長版衫</h5>
                    </a>
                    <span class="good_headprice">售價2,190元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">山山巧福</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性襯衫</h5>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">The North Face</span>
                    <a class="good_headname">
                        <h5>有機棉法蘭絨襯衫</h5>
                    </a>
                    <span class="good_headprice">售價2,200元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Marmot</span>
                    <a class="good_headname">
                        <h5>有機棉水洗牛津布八分褲</h5>
                    </a>
                    <span class="good_headprice">售價2,190元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Patagonia</span>
                    <a class="good_headname">
                        <h5>聚酯纖維彈性起毛錐形褲</h5>
                    </a>
                    <span class="good_headprice">售價1,230元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Gregory</span>
                    <a class="good_headname">
                        <h5>輕量羽絨可攜式無領外套</h5>
                    </a>
                    <span class="good_headprice">售價1,760元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">WELL FIT威飛客</span>
                    <a class="good_headname">
                        <h5>輕量羽絨可攜式無領背心</h5>
                    </a>
                    <span class="good_headprice">售價2,010元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">山野倉庫</span>
                    <a class="good_headname">
                        <h5>防撥水彈性6口袋外套</h5>
                    </a>
                    <span class="good_headprice">售價1,450元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h5>羽絨可攜式立領背心</h5>
                    </a>
                    <span class="good_headprice">售價390元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">HAGLOFS</span>
                    <a class="good_headname">
                        <h5>透氣撥水防水連帽外套</h5>
                    </a>
                    <span class="good_headprice">售價3,330元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.html'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">FIZAN</span>
                    <a class="good_headname">
                        <h5>超長棉二重織長版衫</h5>
                    </a>
                    <span class="good_headprice">售價2,190元</span>
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