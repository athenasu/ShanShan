////////////////////////////////////////
/////// selecting elements ///////
/////// CARDS ///////
const cards = document.querySelector(".cards");

////////////////////////////////////////
/////// RENDER CARDS ///////
// format time
const formatDate = function (timestamp) {
  var d = new Date(timestamp);

  var dateString =
    d.getFullYear() + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日";

  return dateString;
};
// RENDER POINTS USED CARD
const renderPointsUsedCards = function (
  itemId,
  usedDate,
  itemNo,
  type,
  pointsUsed
) {
  let html = `
            <a href="${itemId}">
              <div class="card-${itemNo}">
                <div class="order-date">
                  <p>使用日期：${usedDate}</p>
                </div>
                <div class="order-no">
                  <a href="#"><p>${type}編號： ${itemId}</p></a>
                </div>
                <div class="order-sum">
                  <p>使用點數：-${pointsUsed}</p>
                </div>
              </div>
            </a>
  `;
  cards.insertAdjacentHTML("afterbegin", html);
};

// RENDER POINTS RECEIVED CARD
const renderPointsReceivedCard = function (
  itemId,
  usedDate,
  itemNo,
  type,
  pointsReceived
) {
  let html = `
            <a href="${itemId}">
              <div class="card-${itemNo}">
                <div class="order-date">
                  <p>發文日期：${usedDate}</p>
                </div>
                <div class="order-no">
                  <a href="#"><p>${type}編號： ${itemId}</p></a>
                </div>
                <div class="order-sum">
                  <p>發文：+${pointsReceived}</p>
                </div>
              </div>
            </a>
`;
  cards.insertAdjacentHTML("afterbegin", html);
};

////////////////////////////////////////
//////// POPULATING PAGE ///////
let itemNo = 1;

// POINTS RECEIVED FROM EVENTS
const pointsReceivedEvent = function () {
  fetch(`/shanshan/memberArticle/findAllEventsByMemId`)
    .then((body) => body.json())
    .then((eventList) => {
      for (let eventItem of eventList) {
        if (eventItem.eventStatus == 5) {
          itemNo = itemNo == 1 ? 2 : 1;
          let startDate = formatDate(eventItem.eventStartDate);
          renderPointsReceivedCard(
            eventItem.eventId,
            startDate,
            itemNo,
            "揪團",
            eventItem.eventPoints
          );
        }
      }
    });
};

// POINTS RECEIVED FROM ARTICLES
const pointsReceivedArticle = function () {
  fetch(`/shanshan/memberArticle/findAllArticlesByMemId`)
    .then((body) => body.json())
    .then((articleList) => {
      for (let article of articleList) {
        itemNo = itemNo == 1 ? 2 : 1;
        let dateCreated = formatDate(article.article_date_created);
        renderPointsReceivedCard(
          article.article_id,
          dateCreated,
          itemNo,
          "文章",
          article.Article_points_recieved
        );
      }
    });
};

// POINTS USED IN ORDERS
const pointsUsedOrders = function () {
  fetch(`/shanshan/memberOrder/findAllOrdersByMemId`)
    .then((body) => body.json())
    .then((orderList) => {
      for (let orderItem of orderList) {
        itemNo = itemNo == 1 ? 2 : 1;
        let dateCreated = formatDate(orderItem.order_created_date);
        renderPointsUsedCards(
          orderItem.order_id,
          dateCreated,
          itemNo,
          "訂單",
          orderItem.point_used
        );
      }
    });
};

// POINTS USED IN ARTICLES
const pointsUsedArticle = function () {
  fetch(`/shanshan/pointsUsedArticle/findPointsUsedArticles`)
    .then((body) => body.json())
    .then((articlePoints) => {
      for (let articlePoint of articlePoints) {
        itemNo = itemNo == 1 ? 2 : 1;
        let dateUsed = formatDate(articlePoint.pointsUsedDate);
        renderPointsUsedCards(
          articlePoint.articleId,
          dateUsed,
          itemNo,
          "文章",
          articlePoint.pointsUsed
        );
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
  pointsUsedArticle();
  pointsUsedOrders();
  pointsReceivedArticle();
  pointsReceivedEvent();
};
