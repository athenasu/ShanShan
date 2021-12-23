"use strict";
/////////// CHANGE PASSWORD ///////////
const changePasswordBtn = document.querySelector(
  ".change_password_submitbutton"
);
changePasswordBtn.addEventListener("click", function () {
  const memberPassword = document.querySelector(".change-password").value;
  const memberRepeatPassword = document.querySelector(
    ".change-password-repeatpassword"
  ).value;
  if (memberPassword == memberRepeatPassword) {
    fetch(`/shanshan/memberLogin/changePassword`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        memberPassword,
      }),
    }).then((body) => {
      console.log(body);
      window.location.href = "../index/index.jsp";
    });
  }
});
