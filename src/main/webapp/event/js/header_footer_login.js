window.addEventListener("scroll", function () {
  var scrollY = window.scrollY;
  //   console.log(window.scrollY);
  let opac = "rgba(255, 255, 255,0)";
  if (scrollY > 0) {
    opac = "rgba(255, 255, 255," + (scrollY + 62.5) / 500 + ")";
    $("#navlist a,.fa-bell, #memcheck a").css("color", "#2d4b4d");
  } else {
    $("#navlist a,.fa-bell, #memcheck a").css("color", "white");
  }
  $("header").css("background-color", opac);
});

/////////////////////////////////////
/////////// LOGIN MODAL ///////////
// 點擊登入按鈕，開啟選擇登入方式的燈箱
$("input.login_modal_button").click(function () {
  console.log("login button clicked");
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

// forgot password, show email modal
$("p.forgot_password").click(function (e) {
  e.preventDefault();
  $("div.login_modal_email").addClass("-none");
  $("div.forgot_password_modal").removeClass("-none");
});

///////////////////////////////////// 註冊 結束

/////////////////////////////////////
// CHECK EMAIL VALIDITY
const validateEmail = function (emailAdress) {
  let regexEmail = /\S+@\S+\.\S+/;
  if (emailAdress.match(regexEmail)) {
    return true;
  } else {
    return false;
  }
};
/////////// LOGIN ///////////
const loginSubmitBtn = document.querySelector(".login_summitbutton");
const loginBtn = document.querySelector(".login_modal_button");
loginSubmitBtn.addEventListener("click", function () {
  const memberEmail = document.querySelector(".login_formbar_email").value;
  const memberPassword = document.querySelector(
    ".login_formbar_password"
  ).value;
  fetch("/shanshan/memberLogin/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    // setting the variables
    // need to test this
    body: JSON.stringify({
      memberEmail,
      memberPassword,
    }),
  })
    .then(function (response) {
      console.log(response);
      return response.json();
    })
    .then((body) => {
      // console.log(body.successful);
      if (body.successful) {
        console.log("Sign in successful");
        $("div.login_modal_bcg").addClass("-none");
        $("div.login_modal").addClass("-none");
        $("div.login_modal_email").addClass("-none");
        $("input.logout_modal_button").removeClass("-none");
        $("input.login_modal_button").addClass("-none");
      } else {
        console.log("Login unsuccessful");
      }
    });
});

/////////// FORGOT PASSWORD ///////////
const forgotPasswordSubmitBtn = document.querySelector(
  ".forgot_password_summitbutton"
);
forgotPasswordSubmitBtn.addEventListener("click", function () {
  let memberEmail = document.querySelector(".forgot_password_email").value;
  fetch(`/shanshan/memberLogin/forgotPasswordCheckEmail`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      memberEmail,
    }),
  })
    .then(function (response) {
      console.log(response);
      return response.json();
    })
    .then((body) => {
      if (body.successful) {
        $("div.login_modal_bcg").addClass("-none");
        $("div.login_modal").addClass("-none");
        $("div.login_modal_email").addClass("-none");
        $("div.forgot_password_modal").addClass("-none");
      }
    });
});

/////////// LOGOUT ///////////
const logoutBtn = document.querySelector(".logout_modal_button");
logoutBtn.addEventListener("click", function () {
  fetch(`/shanshan/memberLogin/logout`);
  $("input.logout_modal_button").addClass("-none");
  $("input.login_modal_button").removeClass("-none");
});
