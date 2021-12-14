"use strict";
// window.addEventListener("scroll", function () {
//   var scrollY = window.scrollY;
//   //   console.log(window.scrollY);
//   let opac = "rgba(255, 255, 255,0)";
//   if (scrollY > 0) {
//     opac = "rgba(255, 255, 255," + (scrollY + 62.5) / 500 + ")";
//     $("#navlist a,.fa-bell, #memcheck a").css("color", "#2d4b4d");
//   } else {
//     $("#navlist a,.fa-bell, #memcheck a").css("color", "white");
//   }
//   $("header").css("background-color", opac);
// });

// need to check if this works
const logoutDiv = document.querySelector("#logout");
logoutDiv.addEventListener("click", function () {
  fetch(`/shanshan/memberLogin/logout`);
});
