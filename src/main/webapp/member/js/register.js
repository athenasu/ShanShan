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

// forgot password, show email modal
$("p.forgot_password").click(function (e) {
  e.preventDefault();
  $("div.login_modal_email").addClass("-none");
  $("div.forgot_password_modal").removeClass("-none");
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
// check email validity
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
const logoutBtn = document.querySelector(".logout_modal_button");
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

/////////// REGISTER ///////////
let memberEmailInput = document.querySelector("input.register-email");
let emailInputError = document.querySelector(".error-message");
memberEmailInput.addEventListener("keyup", function () {
  let validate = validateEmail(memberEmailInput.value);
  if (!validate) {
    emailInputError.innerHTML = "<p>請輸入合法信箱</p>";
  } else {
    emailInputError.textContent = "";
  }
});

const registerSubmitBtn = document.querySelector(".register_summitbutton");
registerSubmitBtn.addEventListener("click", function () {
  const memberName = document.querySelector(".register-name").value;
  const memberEmail = document.querySelector(".register-email").value;
  const memberPassword = document.querySelector(".register-password").value;
  const memberRepeatPassword = document.querySelector(
    ".register-repeatpassword"
  ).value;
  if (memberPassword == memberRepeatPassword && validateEmail(memberEmail)) {
    fetch("/shanshan/memberRegister/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        memberName,
        memberEmail,
        memberPassword,
      }),
    });
  } else {
    alert("wrong password"); // can probably show something on the div
  }
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
});
