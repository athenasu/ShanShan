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
    <title>商品頁面</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">


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
                    <li class="product_slideshow_pics"><img src="img\product_pic_01.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_test2.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_03.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_04.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_05.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_01.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_test2.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_03.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_04.jpg" alt=""></li>
                    <li class="product_slideshow_pics"><img src="img\product_pic_05.jpg" alt=""></li>
                </ul>
            </div>
            <div class="product_slideshow_contrl"><i class="fas fa-sort-down product_slideshow_contrl_icon_down"></i>
            </div>
        </div>
        <!-- 圖片區 首圖-->
        <div class="product_pic_area">
            <div class="product_slideshow_main"><img></div>
        </div>



        <!-- 產品規格區-->
        <div class="product_format_detail_area">
            <div class="product_format_detail_breadcrumb">全部商品 > 衣著/鞋子/背包 > 聚酯纖維彈性襯衫</div>
            <div class="product_format_detail_name">品名：聚酯纖維彈性襯衫</div>
            <div class="product_format_detail_id">商品編號：123456789</div>
            <div class="product_format_detail_price">售價：NT 590</div>
            <div class="product_format_detail_color">顏色：
                <form style="display: inline-block;" for="product_format_detail_color">
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_color"
                        value="white" checked>&ensp;白色
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_color"
                        value="grey">&ensp;灰色
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_color"
                        value="black">&ensp;黑色
                </form>
            </div>
            <div class="product_format_detail_size">尺寸：
                <form style="display: inline-block;" for="product_format_detail_size">
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_size" value="S"
                        checked>&ensp;S
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_size"
                        value="M">&ensp;M
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_size"
                        value="L">&ensp;L
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_size"
                        value="XL">&ensp;XL
                </form>
            </div>
            <div class="product_format_detail_payway">付款方式：
                <form style="display: inline-block;" for="product_format_detail_payway">
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_payway"
                        value="信用卡" checked>&ensp;信用卡
                </form>
            </div>
            <div class="product_format_detail_deliveryway">配送方式：
                <form style="display: inline-block;" for="product_format_detail_deliveryway">
                    <input class="product_format_detail_radio" type="radio" name="product_format_detail_deliveryway"
                        value="宅配" checked>&ensp;宅配
                </form>
            </div>
            <div class="product_format_detail_buttons">
                <div>
                    <input class="product_format_detail_button_1" type="button" value="直接購買"></input>
                </div>
                <div>
                    <input class="product_format_detail_button_2" type="button" value="加入購物車"></input>
                </div>
            </div>
            <div class="product_format_detail_remark">※ 備註：貼身衣物無法退貨。</div>
        </div>
    </div>


    <!-- 產品介紹簡介區-->
    <div class="product_intro_area">

        <div class="product_intro_description_area">

            <div class="goods_prodcut_title">商品詳情</div>

            <!-- 產品 文檔區-->
            <div class="product_intro_description">※ 此商品特殊尺寸為 XS，XXL，3XL</br>
                ※ 特別尺碼的實際庫存請依頁面顯之庫存為準</br></br>

                自然風格及舒適質地兼具的。細節升級，外觀更加好看的圓領T恤。UPF40</br></br>
                ・採用具速乾機能及接觸涼感的AlRism素材。</br>
                ・柔順風格設計。</br>
                ・表面壓線搭配素材，改為更細緻的織線。</br>
                ・袖口羅紋設計，手臂活動更為方便。</br>
                ・臂洞不加入壓線，展現俐落風格。</br>
                ・兩邊下襬加入開叉，可單穿可層疊，搭配方便。</br>
                ・適合每日穿著的基本款圓領T恤。</br></br>

                物料組成</br>
                大身： 73％ 棉，27％ 聚酯纖維/ 羅紋部分： 65％ 棉，35％ 聚酯纖維</br></br>

                洗滌方式</br>
                洗衣機（水溫40度）</br></br>

                ※ 此商品可退換，須受換貨、退貨及退款細則約束。</br>
            </div>
        </div>
    </div>


    <!-- 相關產品區-->
    <div class="goods_product_innercontent ">
        <div class="goods_prodcut_title ">其他熱門商品</div>
        <ul class="goods_area">
            <!-- https://i.imgur.com/1EiiZs2.png    -->
            <li class="single_good_area" onclick="location.href='#'">
                <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                <div class="goods_icon"><i class="far fa-heart "></i></div>
                <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                <span class="good_headsupplier">山山巧福</span>
                <a class="good_headname">
                    <h5>聚酯纖維彈性襯衫</h5>
                </a>
                <span class="good_headprice">售價290元</span>
            </li>
            <li class="single_good_area" onclick="location.href='#'">
                <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                <div class="goods_icon"><i class="far fa-heart "></i></div>
                <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                <span class="good_headsupplier">The North Face</span>
                <a class="good_headname">
                    <h5>有機棉法蘭絨襯衫</h5>
                </a>
                <span class="good_headprice">售價2,200元</span>
            </li>
            <li class="single_good_area" onclick="location.href='#'">
                <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                <div class="goods_icon"><i class="far fa-heart "></i></div>
                <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                <span class="good_headsupplier">Marmot</span>
                <a class="good_headname">
                    <h5>有機棉水洗牛津布八分褲</h5>
                </a>
                <span class="good_headprice">售價2,190元</span>
            </li>
            <li class="single_good_area" onclick="location.href='#'">
                <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                <div class="goods_icon"><i class="far fa-heart "></i></div>
                <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                <span class="good_headsupplier">Patagonia</span>
                <a class="good_headname">
                    <h5>聚酯纖維彈性起毛錐形褲</h5>
                </a>
                <span class="good_headprice">售價1,230元</span>
            </li>
            <li class="single_good_area" onclick="location.href='#'">
                <div class="good_headpic"><img class="good_headpic_img" ssrc="img\good01.jpg" width="250px" alt="goods"></div>
                <div class="goods_icon"><i class="far fa-heart "></i></div>
                <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                <span class="good_headsupplier">Gregory</span>
                <a class="good_headname">
                    <h5>輕量羽絨可攜式無領外套</h5>
                </a>
                <span class="good_headprice">售價1,760元</span>
            </li>
        </ul>
    </div>

    <!-- 商品頁面 結束-->

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