"use strict";

const groupCard = document.querySelector("#grouplist");
const userInfo = document.querySelector(".user-info");
const sortByProductBtn = document.querySelector(".sort-by-product");
const sortByArticleBtn = document.querySelector(".sort-by-article");
const sortByEventBtn = document.querySelector(".sort-by-event");
const grouplist = document.querySelector("#grouplist");

////////////////////////////////////////
/////// RENDER CARDS ///////

// Format Date
const formatDate = function (timestamp) {
  var d = new Date(timestamp);

  var dateString =
    d.getFullYear() + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日";

  return dateString;
};

const stayTypeStr = function (type) {
  if (type == 0) {
    return "當天來回";
  }
  if (type == 1) {
    return "野營";
  }
  if (type == 2) {
    return "山屋";
  }
  if (type == 3) {
    return "飯店";
  }
};

const countdownDiv = function (timestamp) {
  let today = new Date();
  let eventDate = new Date(timestamp);
  let countdownDate = eventDate - today;
  if (countdownDate > 0) {
    let dateString = eventDate.getDate() + "天" + eventDate.getHours() + "小時";
    return `<p class="countdown">倒數：<span>${dateString}</span></p>`;
  } else {
    return `<p class="countdown-done">倒數：<span>已出發</span></p>`;
  }
};

const renderWishlistEvent = function (event) {
  // mountain picture
  const mtnBytesStr = atob(event.mountainPicStr);
  let mtnLen = mtnBytesStr.length;
  const mtnu8Array = new Uint8Array(mtnLen);
  while (mtnLen--) {
    mtnu8Array[mtnLen] = mtnBytesStr.charCodeAt(mtnLen);
  }
  const mtnBlob = new Blob([mtnu8Array]);
  const mtnUrl = URL.createObjectURL(mtnBlob);

  // leader picture
  const leaderBytesStr = atob(event.memberProfilePicStr);
  let leaderLen = leaderBytesStr.length;
  const leaderu8Array = new Uint8Array(leaderLen);
  while (leaderLen--) {
    leaderu8Array[leaderLen] = leaderBytesStr.charCodeAt(leaderLen);
  }
  const leaderBlob = new Blob([leaderu8Array]);
  const leaderUrl = URL.createObjectURL(leaderBlob);

  let startDate = formatDate(event.eventStartDate);
  let stayType = stayTypeStr(event.stayType);
  let countdown = countdownDiv(event.eventStartDate);
  // add a current date to subtract from event date
  // if the date is already up, then make it a different color or something

  let html = `
            <div class="groupcard">
            <a href="#?${event.wishlistEventId}">
              <div class="groupimg">
                <span wishlist-id="${event.wishlistEventId}" class="heart-event">
                  <i class="fas fa-heart"></i>
                </span>
                <img src="${mtnUrl}" class="img" />
                ${countdown}
              </div>
              <div class="groupinfo">
                <h3 class="title2 gp_name">${event.eventName}</h3>
                <div class="infolist">
                  <div><i class="far fa-clock"></i></div>
                  <div>出團日期：<span>${startDate}</span></div>
                </div>
                <div class="infolist">
                  <div><i class="fas fa-bed"></i></div>
                  <div>住宿種類：<span>${stayType}</span></div>
                </div>
                <div class="infolist">
                  <div><i class="fas fa-hiking"></i></div>
                  <div><span>${event.mountainName}</span></div>
                </div>
                <div class="leader">
                  <div class="leaderimg">
                    <img src="${leaderUrl}" class="img" />
                  </div>
                  <div><span>${event.memberName}</span></div>
                </div>
              </div>
            </a>
          </div>`;
  // insert HTML
  groupCard.insertAdjacentHTML("beforeend", html);
  // heartEvent.addEventListener("click", function () {
  //   deleteWishlist("Event", `${article.wishlistEventId}`);
  // });
};

const renderWishlistArticle = function (article) {
  // mountain picture
  const articleBytesStr = atob(article.articlePictureStr);
  let articleLen = articleBytesStr.length;
  const articleu8Array = new Uint8Array(articleLen);
  while (articleLen--) {
    articleu8Array[articleLen] = articleBytesStr.charCodeAt(articleLen);
  }
  const articleBlob = new Blob([articleu8Array]);
  const articleUrl = URL.createObjectURL(articleBlob);

  // writer picture
  const writerBytesStr = atob(article.memberPictureStr);
  let writerLen = writerBytesStr.length;
  const writeru8Array = new Uint8Array(writerLen);
  while (writerLen--) {
    writeru8Array[writerLen] = writerBytesStr.charCodeAt(writerLen);
  }
  const writerBlob = new Blob([writeru8Array]);
  const writerUrl = URL.createObjectURL(writerBlob);

  let eventDate = formatDate(article.eventDate);

  let html = `
            <div class="groupcard">
            <a href="#?${article.wishlistArticleId}">
              <div class="groupimg">
                <span wishlist-id= "${article.wishlistArticleId}" class="heart-article">
                  <i class="fas fa-heart"></i>
                </span>
                <img src="${articleUrl}" class="img" />
              </div>
              <div class="groupinfo">
                <h3 class="title2 gp_name">${article.articleTitle}</h3>
                <div class="infolist">
                  <div><i class="far fa-clock"></i></div>
                  <div>出團日期：<span>${eventDate}</span></div>
                </div>
                <div class="infolist">
                  <div><i class="fas fa-hiking"></i></div>
                  <div><span>${article.mountainName}</span></div>
                </div>
                <div class="leader">
                  <div class="leaderimg">
                    <img src="${writerUrl}" class="img" />
                  </div>
                  <div><span>${article.memberName}</span></div>
                </div>
              </div>
            </a>
          </div>`;
  // insert HTML
  groupCard.insertAdjacentHTML("beforeend", html);
  // heartArticle.addEventListener("click", function () {
  //   deleteWishlist("Article", `${article.wishlistArticleId}`);
  // });
};

const renderWishlistProduct = function (product) {
  // product img
  const productBytesStr = atob(product.productImgStr);
  let productLen = productBytesStr.length;
  const productu8Array = new Uint8Array(productLen);
  while (productLen--) {
    productu8Array[productLen] = productBytesStr.charCodeAt(productLen);
  }
  const productBlob = new Blob([productu8Array]);
  const productUrl = URL.createObjectURL(productBlob);

  // company banner
  const companyBytesStr = atob(product.companyBannerStr);
  let companyLen = companyBytesStr.length;
  const companyu8Array = new Uint8Array(companyLen);
  while (companyLen--) {
    companyu8Array[companyLen] = companyBytesStr.charCodeAt(companyLen);
  }
  const companyBlob = new Blob([companyu8Array]);
  const companyUrl = URL.createObjectURL(companyBlob);

  let html = `
            <div class="groupcard">
            <a href="#?${product.wishlistProductId}">
              <div class="groupimg">
                <span wishlist-id= "${product.wishlistProductId}" class="heart-product">
                  <i class="fas fa-heart"></i>
                </span>
                <img src="${productUrl}" class="img" />
              </div>
              <div class="groupinfo">
                <h3 class="title2 gp_name">${product.productName}</h3>
                <div class="leader">
                  <div class="leaderimg">
                    <img src="${companyUrl}" class="img" />
                  </div>
                  <div><span>${product.companyName}</span></div>
                </div>
              </div>
            </a>
          </div>`;
  // insert HTML
  groupCard.insertAdjacentHTML("beforeend", html);
};

////////////////////////////////////////
//////// POPULATING PAGE ///////

// RENDER MEMBER DAHSBOARD
const memberInfo = function () {
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
      document.querySelector(".member-name-dashboard").textContent =
        member.memberName;
      document.querySelector(".member-username-dashboard").textContent =
        member.memberUsername;
      let points = `<p>您總共有${member.memberSumPoints}點數</p>`;
      userInfo.insertAdjacentHTML("afterend", points);
    });
};

// EVENT WISHLIST
const eventWishlist = function () {
  fetch(`/shanshan/wishlistEvent/findWishlistEventsByMemberId`)
    .then((body) => body.json())
    .then((wishlistEvents) => {
      for (let event of wishlistEvents) {
        renderWishlistEvent(event);
      }
    });
};

// ARTICLE WISHLIST
const articleWishlist = function () {
  fetch(`/shanshan/wishlistArticle/findWishlistArticlesByMemberId`)
    .then((body) => body.json())
    .then((wishlistArticles) => {
      for (let article of wishlistArticles) {
        // getting every event from the list
        // console.log(article);
        renderWishlistArticle(article);
      }
    });
};

// PRODUCT WISHLIST
const productWishlist = function () {
  fetch(`/shanshan/wishlistProduct/findWishlistProductsByMemberId`)
    .then((body) => body.json())
    .then((wishlistProducts) => {
      for (let product of wishlistProducts) {
        // getting every event from the list
        // console.log(product);
        renderWishlistProduct(product);
      }
    });
};

window.onload = function () {
  memberInfo();
  productWishlist();
  articleWishlist();
  eventWishlist();
};

////////////////////////////////////////
//////// BUTTON SORTING ///////

// SORT BY PRODUCT
sortByProductBtn.addEventListener("click", function () {
  grouplist.innerHTML = "";
  productWishlist();
});

// SORT BY ARTICLE
sortByArticleBtn.addEventListener("click", function () {
  grouplist.innerHTML = "";
  articleWishlist();
});

// SORT BY EVENT
sortByEventBtn.addEventListener("click", function () {
  grouplist.innerHTML = "";
  eventWishlist();
});

////////////////////////////////////////
//////// DELETE WISHLIST ///////

const deleteArticleWishlist = function (wishlistId) {
  fetch(`/shanshan/wishlistArticle/deleteWishlistArticle`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      wishlistArticleId: wishlistId,
    }),
  });
};

const deleteEventWishlist = function (wishlistId) {
  fetch(`/shanshan/wishlistEvent/deleteWishlistEvent`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      wishlistEventId: wishlistId,
    }),
  });
};

const deleteProductWishlist = function (wishlistId) {
  fetch(`/shanshan/wishlistProduct/deleteWishlistProduct`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      wishlistProductId: wishlistId,
    }),
  });
};

document.addEventListener("click", function (e) {
  console.log(e.target);
  if (e.target.classList.contains("heart-product")) {
    console.log("heart product clicked");
    let parent = e.target.closest("div.groupcard");
    let elem = parent.querySelector(".heart-product");
    let wishlistId = elem.getAttribute("wishlist-id");
    deleteProductWishlist(wishlistId);
    parent.remove();
  }
  if (e.target.classList.contains("heart-article")) {
    console.log("heart article clicked");
    let parent = e.target.closest("div.groupcard");
    let elem = parent.querySelector(".heart-article");
    let wishlistId = elem.getAttribute("wishlist-id");
    deleteArticleWishlist(wishlistId);
    parent.remove();
  }
  if (e.target.classList.contains("heart-event")) {
    console.log("heart event clicked");
    let parent = e.target.closest("div.groupcard");
    let elem = parent.querySelector(".heart-event");
    let wishlistId = elem.getAttribute("wishlist-id");
    deleteEventWishlist(wishlistId);
    parent.remove();
  }
});

// heartProduct.addEventListener("click", function () {
//   console.log("heart product clicked");
//   // deleteWishlist("Product", `${product.wishlistProductId}`);
// });
// $('.member-email input[name=my_id]').val(row.my_id).prop('readonly', true);
