"use strict";

const dropArea = document.querySelector(".drag-area");
const dragText = document.querySelector("header");
const browseBtn = document.querySelector(".browse_btn");
const hiddenInput = document.querySelector(".hidden_input");
const cancelBtn = document.querySelector(".cancel-btn");
const submitBtn = document.querySelector(".submit-btn");
const changePasswordBtn = document.querySelector(".change-password-btn");
///////////////////////////////////
// SHOW PICTURE FOR UPLOAD
let file;
browseBtn.onclick = () => {
  hiddenInput.click(); // if the user clicks the customized button, the hidden
  // input is clicked as well
};

hiddenInput.addEventListener("change", function () {
  file = this.files[0];
  showFile();
});

// inside drop area
dropArea.addEventListener("dragover", (e) => {
  e.preventDefault();
  dropArea.classList.add("active");
  dragText.textContent = "Release to upload file";
});

// outside drop area
dropArea.addEventListener("dragleave", () => {
  dropArea.classList.remove("active");
  dragText.textContent = "Drag & drop to upload file";
});

// file dropped in droparea
dropArea.addEventListener("drop", (e) => {
  e.preventDefault();
  file = e.dataTransfer.files[0];
  showFile();
});

let fileURL;
let imgTag;

function showFile() {
  let fileType = file.type;
  let validExtensions = ["image/jpeg", "image/jpg", "image/png"];
  if (validExtensions.includes(fileType)) {
    let fileReader = new FileReader(); // creating new file object
    fileReader.onload = () => {
      fileURL = fileReader.result; // passing user file source in fileURL
      // variable
      imgTag = `<img src= ${fileURL} alt= "" >`;
      dropArea.innerHTML = imgTag;
    };
    fileReader.readAsDataURL(file);
  } else {
    alert("Not an image");
    dropArea.classList.remove("active");
  }
}

////////////////////////////////////////
// SHOW STUFF ON STIE //
const populatePage = function () {
  fetch("findMemberById")
    .then((body) => body.json())
    .then((member) => {
      const bytesStr = atob(member.picStr); // this is the property in the entity
      let len = bytesStr.length;
      const u8Array = new Uint8Array(len);
      while (len--) {
        u8Array[len] = bytesStr.charCodeAt(len);
      }
      const blob = new Blob([u8Array]);
      const url = URL.createObjectURL(blob);

      document.querySelector(".member_profile .member_profile_pic").src = url;
      document.querySelector(".member-name").value = member.memberName;
      document.querySelector(".member-username").value = member.memberUsername;
      document.querySelector(".member-name-dashboard").textContent =
        member.memberName;
      document.querySelector(".member-username-dashboard").textContent =
        member.memberUsername;
      document.querySelector(".member-email").value = member.memberEmail;
      // document.querySelector(".member-password").value = member.memberPassword;
      document.querySelector(".member-intro-text").value = member.memberIntro;
    });
};

// UPDATE MEMBER //
const updateInfo = function () {
  const memberName = document.querySelector(".member-name").value;
  const memberUsername = document.querySelector(".member-username").value;
  const memberPhoneNum = document.querySelector(".member-phone").value;
  const memberEmail = document.querySelector(".member-email").value;
  const memberIntro = document.querySelector(".member-intro-text").value;

  const file = hiddenInput.files[0];
  const fileReader = new FileReader();

  fileReader.onload = function (e) {
    const base64str = btoa(e.target.result);

    fetch("memberUpdate", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      // setting the variables
      body: JSON.stringify({
        picStr: base64str,
        memberName: memberName,
        memberUsername,
        memberEmail,
        memberPhoneNum,
        memberIntro,
      }),
    })
      .then(function (response) {
        console.log(response);
        return response.json();
      })
      .then(function (data) {
        console.log(data);
        document.querySelector(".drag-area img").src = "";
        populatePage();
      });
  };
  fileReader.readAsBinaryString(file);
};

window.onload = function () {
  populatePage();
};

submitBtn.addEventListener("click", function () {
  updateInfo();
});

cancelBtn.addEventListener("click", function () {
  populatePage();
});

// changePasswordBtn.addEventListener("click", function(){

// })
