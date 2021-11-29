<%@ page import="tw.idv.tibame.tfa104.shanshan.web.orderDescription.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String contextPath = request.getContextPath();%>
<%-- 取出 Controller orderDescriptionServlet.java已存入request的Poplist物件 --%>
<%=(String) request.getAttribute("Pop")%>
<%=(String) request.getAttribute("Poplist")%>


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
        

            <div class="goods_title01 ">熱門商品</div>
            <ul class="goods_area ">
            <c:forEach items="Pop" var="Poplist" begin="1" end="10" step="1" >
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">${Poplist.company.companyName}</span>
                    <a class="good_headname">
                        <h4>${Poplist.product.productName}</h4>
                    </a>
                    <span class="good_headprice">售價${Poplist.product.productPrice}</span>
                </li>
            </c:forEach>
            </ul>
			
            <div class="goods_title01">新駐商品</div>
            <ul class="goods_area">
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">山山巧福</span>
                    <a class="good_headname">
                        <h4>聚酯纖維彈性襯衫</h4>
                    </a>
                    <span class="good_headprice">售價290元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">The North Face</span>
                    <a class="good_headname">
                        <h4>有機棉法蘭絨襯衫</h4>
                    </a>
                    <span class="good_headprice">售價2,200元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Marmot</span>
                    <a class="good_headname">
                        <h4>有機棉水洗牛津布八分褲</h4>
                    </a>
                    <span class="good_headprice">售價2,190元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Patagonia</span>
                    <a class="good_headname">
                        <h4>聚酯纖維彈性起毛錐形褲</h4>
                    </a>
                    <span class="good_headprice">售價1,230元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">Gregory</span>
                    <a class="good_headname">
                        <h4>輕量羽絨可攜式無領外套</h4>
                    </a>
                    <span class="good_headprice">售價1,760元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">WELL FIT威飛客</span>
                    <a class="good_headname">
                        <h4>輕量羽絨可攜式無領背心</h4>
                    </a>
                    <span class="good_headprice">售價2,010元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">山野倉庫</span>
                    <a class="good_headname">
                        <h4>防撥水彈性6口袋外套</h4>
                    </a>
                    <span class="good_headprice">售價1,450元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">ARCTERYX始祖鳥</span>
                    <a class="good_headname">
                        <h4>羽絨可攜式立領背心</h4>
                    </a>
                    <span class="good_headprice">售價390元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">HAGLOFS</span>
                    <a class="good_headname">
                        <h4>透氣撥水防水連帽外套</h4>
                    </a>
                    <span class="good_headprice">售價3,330元</span>
                </li>
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier">FIZAN</span>
                    <a class="good_headname">
                        <h4>超長棉二重織長版衫</h4>
                    </a>
                    <span class="good_headprice">售價2,190元</span>
                </li>
            </ul>
        </div>
    </div>

    <!-- 商店首頁 結束-->
    
    <!-- 插入 商城頁尾-->
<%@ include file="goods_footer.jsp" %>

    <!-- 載入jQuery -->
    <!-- <script type='text/javascript' src='./code/jquery-3.6.0.js'></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- 載入index.js -->
    <script type='text/javascript' src='<%=contextPath%>/shop/code/index.js'></script>
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>
</html>