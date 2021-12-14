<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>


<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.service.impl.*"%>
<%@ page import="tw.idv.tibame.tfa104.shanshan.web.article.entity.*"%>

<%
	ArticleService articleSvc = new ArticleService();
	List<ArticleVO> list = articleSvc.getAll();
	pageContext.setAttribute("list",list);
	
	application.getAttribute("memSvc");
	application.getAttribute("mtnSvc");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon" href="/img/favicon.png" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/article/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/article/css/addArt.css" />
<title>發表日誌</title>
</head>
<body>
	<header>
		<div id="logo">
			<a href="<%=request.getContextPath()%>/index/index.jsp"> 
			<img src="<%=request.getContextPath()%>/index/img/logo.png" class="img" /></a>
		</div>
		<nav id="navlist">
			<ul>
				<li><a href="<%=request.getContextPath()%>/event/event.html">找山友</a></li>
				<li><a
					href="<%=request.getContextPath()%>/article/articleList.jsp">山友日誌</a></li>
				<li><a
					href="<%=request.getContextPath()%>/shop/goods_index.jsp">攻山小物</a></li>
				<li><a href="<%=request.getContextPath()%>/cabin/mtnIndex.jsp">登山資訊</a></li>
				<li><a
					href="<%=request.getContextPath()%>/member/member_main.html">會員中心</a></li>
			</ul>
		</nav>
		<div id="memcheck">
			<div id="login">
				<a href="#">登入</a>
			</div>
			<div id="register">
				<a href="<%=request.getContextPath()%>/member/register.html">註冊</a>
			</div>
		</div>
	</header>
   <div id="wrap" style="background-image: url('<%=request.getContextPath()%>/article/img/a7.jpg')">
      <main>
        <div id="toptitle">
          <h3>發表網誌</h3>
        </div>
        <div id="content">
          <form
            action="<%=request.getContextPath()%>/ArticleServlet.do?action=new"
            method="post"
            enctype="multipart/form-data"
          >
            <div class="top">
              <div class="left">
                <div class="group">
                  <div class="grouptitle">網誌標題</div>
                  <div class="groupcontent title">
                    <input type="text" name="article_title" id="artTitle" />
                  </div>
                </div>
                <div class="group">
                  <div class="grouptitle">活動日期</div>
                  <div class="groupcontent">
                    <input type="date" name="event_date" />
                  </div>
                </div>
                <div class="group">
                  <div id="mtn">
                    <div class="grouptitle">登山地點</div>
                    <div>
                      <select name="mountain_id">
                        <c:forEach var="mtnVO" items="${mtnSvc.findAllMtns()}">
                          <option value="${mtnVO.mountainId}">
                            ${mtnVO.mountainName}
                          </option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                  <div id="otherMtn">
                    <div class="grouptitle">其他地點</div>
                    <div id="otherMtnadd">
                      <input type="text" name="other_mtn" />
                    </div>
                  </div>
                </div>
                <div class="group">
                  <div class="grouptitle">推薦程度</div>
                  <div class="groupcontent">
                    <select name="recommendation">
                      <option name="recommendation" value="1">非常不推</option>
                      <option name="recommendation" value="2">不推</option>
                      <option name="recommendation" value="3">普通</option>
                      <option name="recommendation" value="4">推薦</option>
                      <option name="recommendation" value="5">非常推薦</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="right">
                <div class="group">
                  <div class="grouptitle">日誌內容</div>
                  <div class="groupcontent addArtContent">
                    <textarea
                      name="article_content"
                      id="artContent"
                      maxlength="300"
                    ></textarea>
                  </div>
                </div>
                <div class="group">
                  <div class="grouptitle">上傳圖片</div>
                  <div class="groupcontent">
                    <input
                      type="file"
                      multiple="multiple"
                      id="upimg"
                      name="article_picture"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="bottom">
              <input type="hidden" name="member_id" value="1" />
              <div><input type="submit" value="送出" id="sendbtn" /></div>
            </div>
          </form>
        </div>
      </main>
    </div>
<!-- 	<div id="title"> -->
<!-- 		<h3>發表網誌</h3> -->
<!-- 	</div> -->
<!-- 	<div id="content"> -->
<!-- 		<form -->
<%-- 			action="<%=request.getContextPath()%>/ArticleServlet.do?action=new" --%>
<!-- 			method=post enctype="multipart/form-data"> -->

<!-- 			<div> -->
<!-- 				<div>網誌標題</div> -->
<!-- 				<div> -->
<!-- 					<input type="text" name="article_title" id="artTitle"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<div>活動日期</div> -->
<!-- 				<div> -->
<!-- 					<input type="date" name="event_date"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<div>登山地點</div> -->
<!-- 				<div> -->
<!-- 					<select name="mountain_id"> -->
<%-- 						<c:forEach var="mtnVO" items="${mtnSvc.findAllMtns()}"> --%>
<%-- 							<option value="${mtnVO.mountainId}">${mtnVO.mountainName}</option> --%>
<%-- 						</c:forEach> --%>
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 				<div>其他登山地點</div> -->
<!-- 				<div> -->
<!-- 					<input type="text" name="other_mtn"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<div>推薦程度</div> -->
<!-- 				<div> -->
<!-- 					<select name="recommendation"> -->
<!-- 						<option name="recommendation" value="1">非常不推</option> -->
<!-- 						<option name="recommendation" value="2">不推</option> -->
<!-- 						<option name="recommendation" value="3">普通</option> -->
<!-- 						<option name="recommendation" value="4">推薦</option> -->
<!-- 						<option name="recommendation" value="5">非常推薦</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<div>內容</div> -->
<!-- 				<div> -->
<!-- 					<input type="text" name="article_content" id="artContent"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<div>上傳圖片</div> -->
<!-- 				<div> -->
<!-- 					<input type="file" multiple="multiple" id="upimg" -->
<!-- 						name="article_picture"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<input type="hidden" name="member_id" value="1"> -->
<!-- 			<div> -->
<!-- 				<input type="submit" value="送出"> -->
<!-- 			</div> -->
<!-- 		</form> -->
<!-- 	</div> -->
	<footer>
		<h4>
			Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN
		</h4>
	</footer>
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
</body>
</html>