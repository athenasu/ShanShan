////////////////////////////////////////
/////// selecting elements ///////
/////// CARDS ///////
const cards = document.querySelector(".cards");

////////////////////////////////////////
/////// RENDER CARDS ///////

// RENDER CARD
const renderPointsCards = function (card, itemNo, type) {
  let html = `
          <a href="${card.articleId}">
            <div class="card-${itemNo}">
              <div class="order-date">
                <p>日期：${card.pointsUsedDate}</p>
              </div>
              <div class="order-no">
                <p>${type}編號： ${card.articleId}</p>
              </div>
              <div class="order-sum">
                <p>點數：${card.pointsUsed}</p>
            </div>
          </a>
  `;
  cards.insertAdjacentHTML("afterbegin", html);
};

////////////////////////////////////////
//////// POPULATING PAGE ///////
let itemNo = 1;
const pointsListArticle = function () {
  fetch(`/shanshan/pointsUsedArticle/findPointsUsedArticles`)
    .then((body) => body.json())
    .then((articlePoints) => {
      for (let articlePoint of articlePoints) {
        itemNo = 1 ? 2 : 1;
        renderPointsCards(articlePoint, itemNo, "文章");
      }
    });
};

// RENDER MEMBER DAHSBOARD
const populateMemberDashboard = function () {
  fetch("findMemberById")
    .then((body) => body.json())
    .then((member) => {
      const bytesStr = atob(member.picStr);
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
    });
};

window.onload = function () {
  populateMemberDashboard();
  pointsListArticle();
};
