<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <iframe class="iframe_popular" frameborder="0" src="<c:url value='http://localhost:8081/shanshan/orderDescriptionServlet'/>" name="iframe_popular">
            <div class="goods_title01 ">熱門商品</div>
            <ul class="goods_area ">
            <c:forEach items="${Poplist}" var="pop" begin="1" end="10" step="1" >
                <li class="single_good_area" onclick="location.href='goods_product_page.jsp'">
                    <img class="good_headpic" src="img\good01.jpg" width="250px" alt="goods">
                    <div class="goods_icon"><i class="far fa-heart "></i></div>
                    <div class="goods_icon_keep -none"><i class="fas fa-heart "></i></div>
                    <span class="good_headsupplier"></span>
                    <a class="good_headname">
                        <h4></h4>
                    </a>
                    <span class="good_headprice">售價</span>
                </li>
            </c:forEach>
            </ul>
            </iframe>