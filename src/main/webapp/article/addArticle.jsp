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
	
//     Integer  member_id=1;
    session.getAttribute("memberId");
    session.getAttribute("memberName");
//     pageContext.setAttribute("member_id",member_id);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon" href="/img/favicon.png" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/index/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/article/css/addArt.css" />
<title>發表日誌</title>
</head>
<body>
<%@ include file="/index/header.jsp" %>
	
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
                  <input type="text" id="date" name="event_date" class="date">
                  </div>
                </div>
                <div class="group">
                  <div id="mtn">
                    <div class="grouptitle">登山地點</div>
                    <div>
                      <select name="mountain_id" class="mtnId">
                        <c:forEach var="mtnVO" items="${mtnSvc.findAllMtns()}">
                          <option value="${mtnVO.mountainId}">${mtnVO.mountainName}
                          </option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
          
                  <div id="otherMtn">
                    <div class="grouptitle">其他地點</div>
                    <div id="otherMtnadd">
                      <input type="text" name="other_mtn" disabled="disabled" class="addMtn" value=""/>
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
              <input type="hidden" name="member_id" value="${memberId}" />
              <div><input type="button" value="送出" id="sendbtn" />
              		<input type="button" value="取消" id="cancelbtn">
              </div>
            </div>
          </form>
        </div>
      </main>
    </div>
    <div class="overlay -none">
      <div class="modal">
	          <div id="errormsg"></div>
	          <input type="button" value="確定" id="cancel"/>
	         
      </div>
    </div>
	<footer>
		<h4>
			Copyright <i class="far fa-copyright"></i>2021 G3 SANSAN
		</h4>
	</footer>
	<script src="<%=request.getContextPath()%>/index/vendors/jquery/jquery-3.6.0.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>	
	<script src="https://kit.fontawesome.com/2336c06c64.js"></script>
	<script src="<%=request.getContextPath()%>/index/js/header2.js"></script>
	<script src="<%=request.getContextPath()%>/member/js/register.js"></script>
	<script src="<%=request.getContextPath()%>/article/js/add.js"></script>


</body>
</html>