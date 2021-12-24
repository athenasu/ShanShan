/////////////////////////////////////
/////////// SELECTING ELEMENTS ///////////
const forgotPasswordSubmitBtn = document.querySelector(
  ".forgot_password_summitbutton"
);
const loginSubmitBtn = document.querySelector(".login_summitbutton");
const loginBtn = document.querySelector(".login_modal_button");
const memberEmailInput = document.querySelector("input.register-email");
const emailInputError = document.querySelector(".error-message");

const registerSubmitBtn = document.querySelector(".register_summitbutton");

const logoutBtn = document.querySelector(".logout_modal_button");
/////////////////////////////////////
/////////// MODAL AREA ///////////

/////////// LOGIN MODAL ///////////
// OPEN LOGIN MODAL
$("input.login_modal_button").click(function () {
  console.log("login button clicked");
  $("div.login_modal_bcg").removeClass("-none");
  $("div.login_modal").removeClass("-none");
});

// CANCELLING LOGIN MODAL
$("div.login_modal_bcg").click(function () {
  $("div.login_modal_bcg").addClass("-none");
  $("div.login_modal").addClass("-none");
  $("div.login_modal_email").addClass("-none");
});

// LOGIN WITH EMAIL
$("input.emaillogin").click(function () {
  $("div.login_modal").addClass("-none");
  $("div.login_modal_email").removeClass("-none");
});

// FORGOT PASSWORD, OPEN FORGOT PASSWORD MODAL
$("p.forgot_password").click(function (e) {
  // e.preventDefault();
  $("div.login_modal_email").addClass("-none");
  $("div.forgot_password_modal").removeClass("-none");
});

/////////// REGISTER ///////////
// REGISTER
$("div.registor_title_signup").click(function () {
  $("div.signup_email_form").addClass("-none");
  $("div.choose_signup_form").removeClass("-none");
});

// REGISTER BY EMAIL
$("input.summitbutton_signupemail").click(function () {
  $("div.choose_signup_form").addClass("-none");
  $("div.signup_email_form").removeClass("-none");
});

/////////////////////////////////////
/////////// LOGIN/REGISTER/FORGOTPASSWORD/LOGOUT FUNCTIONS ///////////

// CHECK EMAIL VALIDITY
const validateEmail = function (emailAdress) {
  let regexEmail = /\S+@\S+\.\S+/;
  if (emailAdress.match(regexEmail)) {
    return true;
  } else {
    return false;
  }
};

/////////// EMAIL LOGIN ///////////
loginSubmitBtn &&
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
          $("input.register_button").addClass("-none");
        } else {
          console.log("Login unsuccessful");
        }
      });
  });

/////////// EMAIL REGISTER ///////////
memberEmailInput &&
  memberEmailInput.addEventListener("keyup", function () {
    let validate = validateEmail(memberEmailInput.value);
    if (!validate) {
      emailInputError.innerHTML = "<p>請輸入合法信箱</p>";
    } else {
      emailInputError.textContent = "";
    }
  });

registerSubmitBtn &&
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
      window.location.replace("../index/index.jsp");
    } else {
      alert("wrong password"); // can probably show something on the div
    }
  });

/////////// FORGOT PASSWORD ///////////
forgotPasswordSubmitBtn &&
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

/////////// FACEBOOK LOGIN ///////////
function statusChangeCallback(response) {
  // Called with the results from FB.getLoginStatus().
  console.log("statusChangeCallback");
  // console.log(response);                   // The current login status of the person.
  if (response.status === "connected") {
    // Logged into your webpage and Facebook.
    console.log("connected");
    testAPI();
  } else {
    // Not logged into your webpage or we are unable to tell.
    console.log("Not logged in");
  }
}

function checkLoginState() {
  // Called when a person is finished with the Login Button.
  FB.getLoginStatus(function (response) {
    // See the onlogin handler
    statusChangeCallback(response);
  });
}

window.fbAsyncInit = function () {
  FB.init({
    appId: "219469793703408",
    cookie: true, // Enable cookies to allow the server to access the session.
    xfbml: true, // Parse social plugins on this webpage.
    version: "v12.0", // Use this Graph API version for this call.
  });

  FB.getLoginStatus(function (response) {
    // Called after the JS SDK has been initialized.
    statusChangeCallback(response); // Returns the login status.
    if (response.status === "connected") {
      console.log("connected");
    } else {
      // not_logged_in
      console.log("not logged in");
    }
  });
};

function testAPI() {
  FB.api("/me?fields=id,name,email", function (response) {
    console.log(response);
    fetch(`/shanshan/memberLogin/facebookLogin`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        memberEmail: response.email,
      }),
    })
      .then(function (response) {
        console.log(response);
        return response.json();
      })
      .then((body) => {
        if (body.successful) {
          // if email already exists,
          // then send them to front page
          $("div.login_modal_bcg").addClass("-none");
          $("div.login_modal").addClass("-none");
          $("input.logout_modal_button").removeClass("-none");
          $("input.login_modal_button").addClass("-none");
          $("input.register_button").addClass("-none");
          console.log("Logged in");
        } else {
          // if email doesn't exist create a new account:
          fetch("/shanshan/memberRegister/fbRegister", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify({
              memberName: response.name,
              memberEmail: response.email,
            }),
          });
          $("div.login_modal_bcg").addClass("-none");
          $("div.login_modal").addClass("-none");
          $("input.logout_modal_button").removeClass("-none");
          $("input.login_modal_button").addClass("-none");
          $("input.register_button").addClass("-none");
        }
      });
  });
}

// Load the SDK Asynchronously
(function (d, s, id) {
  var js,
    fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) {
    return;
  }
  js = d.createElement(s);
  js.id = id;
  js.src = "https://connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
})(document, "script", "facebook-jssdk");

function login() {
  FB.login(
    function (response) {
      if (response.authResponse) {
        // connected
        testAPI();
      } else {
        // cancelled
        console.log("user cancelled login through facebook");
      }
    },
    { scope: "email" }
  );
}

/////////// LOGOUT ///////////
logoutBtn &&
  logoutBtn.addEventListener("click", function () {
    FB.logout(function (response) {
      console.log("facebook logged out");
    });
    window.localStorage.removeItem("LoginID");
    window.localStorage.removeItem("LoginNAME");
    fetch(`/shanshan/memberLogin/logout`).then((response) => {
      console.log(response);
      window.location.href = "../index/index.jsp";
    });
  });

/////////////////////////////////////
/////////// CHECK LOGIN STATUS ON LOAD ///////////
window.onload = function (e) {
  console.log(e);
  fetch(`/shanshan/sessionStatus/checkSessionStatus`)
    .then(function (response) {
      console.log(response);
      return response.json();
    })
    .then((body) => {
      console.log(body);
      window.localStorage.setItem("LoginID", body.memberId);
      window.localStorage.setItem("LoginNAME", body.memberName);
      if (body.memberId != null) {
        window.localStorage.setItem("LoginID", body.memberId);
        window.localStorage.setItem("LoginNAME", body.memberName);
        $("input.logout_modal_button").removeClass("-none");
        $("input.login_modal_button").addClass("-none");
        $("input.register_button").addClass("-none");
      } else {
        return;
      }
    });
};
