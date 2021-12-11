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
    <title>全部店家</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/shop/code/style.css">


</head>

<body>
<input type="hidden" class="member_id" value="${memberId}">

    <!-- 插入 商城頁首-->
<%@ include file="goods_header.jsp" %>

    <!-- 商店首頁 開始-->
    <div class="goodsindex_bodycontent">
        <div class="goodsindex_innercontent ">
            <div class="goods_breadcrumb"><a href="/shanshan/shop/goods_index.jsp">攻山小物</a> > <a href="/shanshan/AllCompanyServlet">全部品牌</a></div>
            <div class="goods_title01 ">全部品牌</div>
            <ul class="goods_stores_area ">
            
			<c:forEach  items="${listAllCompanyVO}" var="CompanyVO">
                <li class="goods_single_store_area"">
                    <a href="<%=contextPath %>/GetCompanyServlet?companyId=${CompanyVO.companyId}">
                    <div class="goods_stores_headpic_area"><img class="goods_stores_headpic" src="<%=contextPath%>/GetCompanyBannerServlet?companyId=${CompanyVO.companyId}&action=companyBanner" width="250px" alt="goods"></div>
                    <span class="goods_stores_name">${CompanyVO.companyName}</span>
                    <span class="goods_description">${CompanyVO.companyIntro}</span>
                    </a>
                </li>
			</c:forEach>
                
            </ul>

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
    <!-- 載入icon -->
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
</body>

</html></html>