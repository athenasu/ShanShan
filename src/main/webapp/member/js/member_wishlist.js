const groupCard = document.querySelector("#grouplist");
const userInfo = document.querySelector(".user-info");
const sortByProductBtn = document.querySelector(".sort-by-product");
const sortByArticleBtn = document.querySelector(".sort-by-article");
const sortByEventBtn = document.querySelector(".sort-by-event");
const grouplist = document.querySelector("#grouplist");

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

  // add a current date to subtract from event date
  // if the date is already up, then make it a different color or something
  // might need to convert the stayType manually
  let html = `
            <div class="groupcard">
            <a href="#?${event.wishlistEventId}">
              <div class="groupimg">
                <img src="${mtnUrl}" class="img" />
                <i class="fas fa-heart heart-event"></i>
                <p class="countdown">倒數：<span>10天13小時</span></p>
              </div>
              <div class="groupinfo">
                <h3 class="title2 gp_name">${event.eventName}</h3>
                <div class="infolist">
                  <div><i class="far fa-clock"></i></div>
                  <div>出團日期：<span>${event.eventStartDate}</span></div>
                </div>
                <div class="infolist">
                  <div><i class="fas fa-bed"></i></div>
                  <div>住宿種類：<span>${event.stayType}</span></div>
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

  let html = `
            <div class="groupcard">
            <a href="#?${article.wishlistArticleId}">
              <div class="groupimg">
                <img src="${articleUrl}" class="img" />
                <i class="fas fa-heart heart-article"></i>
              </div>
              <div class="groupinfo">
                <h3 class="title2 gp_name">${article.articleTitle}</h3>
                <div class="infolist">
                  <div><i class="far fa-clock"></i></div>
                  <div>出團日期：<span>${article.eventDate}</span></div>
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
            <a href="#">
              <div class="groupimg">
                <img src="${productUrl}" class="img" />
                <i class="fas fa-heart heart-product"></i>
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

// INITIAL STUFF ON STIE //
// member info
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

const eventWishlist = function (memberId) {
  fetch(
    `/shanshan/wishlistEvent/findWishlistEventsByMemberId?memberId=${memberId}`
  )
    .then((body) => body.json())
    .then((wishlistEvents) => {
      for (let event of wishlistEvents) {
        // getting every event from the list
        // console.log(event);
        renderWishlistEvent(event);
      }
    });
};

const articleWishlist = function (memberId) {
  fetch(
    `/shanshan/wishlistArticle/findWishlistArticlesByMemberId?memberId=${memberId}`
  )
    .then((body) => body.json())
    .then((wishlistArticles) => {
      for (let article of wishlistArticles) {
        // getting every event from the list
        // console.log(article);
        renderWishlistArticle(article);
      }
    });
};

const productWishlist = function (memberId) {
  fetch(
    `/shanshan/wishlistProduct/findWishlistProductsByMemberId?memberId=${memberId}`
  )
    .then((body) => body.json())
    .then((wishlistProducts) => {
      for (let product of wishlistProducts) {
        // getting every event from the list
        // console.log(product);
        renderWishlistProduct(product);
      }
    });
};

// delete wishlist item
// can i use this for post requests? how do i pass in information using post requests@@?
const deleteWishlist = function (wishlistType, wishlistId) {
  fetch(
    `/shanshan/wishlist${wishlistType}/deleteWishlist${wishlistType}?=${wishlistId}`
  );
};

// on load
window.onload = function () {
  // need to somehow get the memberId here
  memberInfo();
  productWishlist(1);
  articleWishlist(1);
  eventWishlist(1);
};

// button sorting
sortByProductBtn.addEventListener("click", function (memberId) {
  // this just appends to the original stuff
  grouplist.innerHTML = "";
  productWishlist(1);
});

sortByArticleBtn.addEventListener("click", function (memberId) {
  grouplist.innerHTML = "";
  articleWishlist(1);
});

sortByEventBtn.addEventListener("click", function (memberId) {
  grouplist.innerHTML = "";
  eventWishlist(1);
});

// delete
// let heartProduct = document.querySelector(".heart-product");
// let heartArticle = document.querySelector(".heart-article");
// let heartEvent = document.querySelector(".heart-event");

document.addEventListener("click", function (e) {
  console.log(e.target);
  if (e.target.classList.contains("heart-product")) {
    console.log("heart-product");
  }
});

// heartProduct.addEventListener("click", function () {
//   console.log("heart product clicked");
//   // deleteWishlist("Product", `${product.wishlistProductId}`);
// });
// $('.member-email input[name=my_id]').val(row.my_id).prop('readonly', true);
