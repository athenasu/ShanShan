<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/member/css/register_login.css" />
    <title>更改密碼</title>
  </head>
  <body>
    <div class="change_password_page">
      <h1 class="change_password_title">會員更改密碼</h1>
      <div>
        <div class="change_password_formbox">
          <label class="register_formname" for="password">密碼</label>
          <input class="register_formbar change-password" type = "password" name="password" placeholder="請輸入8-15位數之間的英文或數字"></input></br>
      </div>
      <div class="change_password_formbox">
          <label class="register_formname" for="repeatpassword">確認密碼</label>
          <input class="register_formbar change-password-repeatpassword" type = "password" name="repeatpassword" placeholder="請重複輸入密碼"></input></br>
      </div>
          <div class="change_password_formbox">
              <input class="change_password_submitbutton" type="button" value="確認更改密碼"></input>
          </div>
      </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/member/js/change_password.js'></script>
    <script src="https://kit.fontawesome.com/8cfc21ab70.js" crossorigin="anonymous"></script>
  </body>
</html>
