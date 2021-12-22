<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
session.getAttribute("memberId");
session.getAttribute("memberName");
%>
	<!-- 導覽列 -->
	<header>
		<div id="logo">
			<a href="<%=request.getContextPath()%>/index/index.jsp">
			<img src="<%=request.getContextPath()%>/index/img/logo.png" class="img" /></a>
		</div>
		<nav id="navlist">
			<ul>
				<li><a href="<%=request.getContextPath()%>/event/event.html">找山友</a></li>
				<li><a href="<%=request.getContextPath()%>/article/articleList.jsp">山友日誌</a></li>
				<li><a href="<%=request.getContextPath()%>/shop/goods_index.jsp">攻山小物</a></li>
				<li><a href="<%=request.getContextPath()%>/cabin/mtnIndex.jsp">登山資訊</a></li>
<%-- 				<li id="memberCenter"><a href="<%=request.getContextPath()%>/member/member_main.html">會員中心</a></li> --%>
				<li id="memberCenter"><a >會員中心</a></li>
			</ul>
		</nav>
		<div id="memcheck">
<!--       <div id="ball"><i class="fas fa-bell"></i></div> -->
      <a href="<%=request.getContextPath()%>/member/register.html">
      <input type="button" class="register_button" value="註冊"></input></a>
      <input type="button" class="login_modal_button" value="登入"></input>
      <input type="button" class="logout_modal_button -none" value="登出"></input>
    </div>
  
<div class="login_modal_bcg -none"></div>
      <div class="login_modal -none">
          <h1 class="login_form_title">登入</h1>
          <div>
              <div class="login_formbox">
                  <input class="emaillogin" type="button" value="用電子郵件登入"></input>
              </div>
              <div class="login_formbox" style=" text-align: center;">
                  <p>還沒註冊?請點選這裡<a href="<%=request.getContextPath()%>/member/register.html">註冊成為新山友</a></p>
              </div>
          </div>
      </div>
       <!-- 燈箱郵件登入 開始 USER LOGIN-->
    <div class="login_modal_email -none">
      <h1 class="login_form_title">用電子郵件登入</h1>
      <div>
          <div class="login_formbox_2 ">
              <label class="login_formname" for="Email">電子郵件地址</label>
              <input class="login_formbar_email" name="Email" placeholder="請輸入您的電子郵件地址"></input>
          </div>
          <div class="login_formbox">
              <label class="login_formname" for="password">密碼</label>
              <input class="login_formbar_password" type = "password"  name="password" placeholder="請輸入您的密碼"></input>
          </div>
          <div class="login_formbox">
              <input class="login_summitbutton" type="button" value="登入"></input>
          </div>
          <div class="login_formbox" style=" text-align: center;">
              <p class= "forgot_password"><a href="#">忘記密碼?</a></p>
          </div>
        </div>
    </div>
<!-- FORGOT PASSWORD-->
<div class="forgot_password_modal -none">
  <h1 class="forgot_password_title">請輸入電子郵件</h1>
  <div>
      <div class="forgot_password_formbox">
          <label class="forgot_password_formname" for="Email">電子郵件地址</label>
          <input class="forgot_password_email" name="Email" placeholder="請輸入您的電子郵件地址"></input>
      </div>
      <div class="forgot_password_formbox">
          <input class="forgot_password_summitbutton" type="button" value="發信"></input>
      </div>
  </div>
</div>
	<div class="overlayh -none">
      	<div class="modalh">
	       <div id="errormsg">請先登入會員</div>
	        <input type="button" value="確定" id="cancelh"/>
      	</div>
	</header>
