// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 登入 開始
// 點擊登入按鈕，開啟選擇登入方式的燈箱
$("input.login_modal_botton").click(function () {
  $("div.login_modal_bcg").removeClass("-none");
  $("div.login_modal").removeClass("-none");
});

// 點擊半透明黑色背景，取消登入的燈箱
$("div.login_modal_bcg").click(function () {
  $("div.login_modal_bcg").addClass("-none");
  $("div.login_modal").addClass("-none");
  $("div.login_modal_email").addClass("-none");
});

// 點擊用EMAIL登入，到EMAIL登入
$("input.emaillogin").click(function () {
  $("div.login_modal").addClass("-none");
  $("div.login_modal_email").removeClass("-none");
});

// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 登入 結束

// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 註冊 開始
// 點擊註冊頁面，回到選擇註冊方式
$("div.registor_title_signup").click(function () {
  $("form.signup_email_form").addClass("-none");
  $("form.choose_signup_form").removeClass("-none");
});

// 點擊用電子郵件註冊，到電子郵件註冊
$("input.summitbutton_signupemail").click(function () {
  $("form.choose_signup_form").addClass("-none");
  $("form.signup_email_form").removeClass("-none");
});

// 點擊logo圖片或註冊頁面，到山山首頁
$("div.registor_titlepic").click(function () {
  //超連結至首頁
});
$("div.registor_title_shanshan").click(function () {
  //超連結至首頁
});

// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 註冊 結束
