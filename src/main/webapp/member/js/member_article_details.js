"use strict";
///////////// selecting elements ////////////
/////// CARDS ///////
const cards = document.querySelector(".cards");
const sortBtnEvent = document.querySelector(".sort-button-event");
const sortBtnPart = document.querySelector(".sort-button-part");
const sortBtnArticle = document.querySelector(".sort-button-article");

////////////////////////////////////////
/////// RENDER CARDS AND MODALS ///////

// RENDER ARTICLE
const renderArticle = function (article) {
  // need to convert the time
  const articleBytesStr = atob(article.picString);
  let articleLen = articleBytesStr.length;
  const articleu8Array = new Uint8Array(articleLen);
  while (articleLen--) {
    articleu8Array[articleLen] = articleBytesStr.charCodeAt(articleLen);
  }
  const articleBlob = new Blob([articleu8Array]);
  const articleUrl = URL.createObjectURL(articleBlob);

  let html = `
            <a href="#" class = "article-card">
              <div class="card-2">
                <div class="article-type">
                  <p>日誌文章</p>
                </div>
                <div class="article-no">
                  <p>文章編號: ${article.article_id}</p>
                </div>
                <div class="article-title">
                  <p>文章名稱: ${article.article_title}</p>
                </div>
                <div class="article-date">
                  <p>文章日期: ${article.article_date_created}</p>
                </div>
                <div class="article-mtn">
                  <p>地點: ${article.mountain_name}</p>
                </div>
                <div class="article-points">
                  <p>總點數: ${article.article_points_recieved} 點</p>
                </div>
                <div class="event-details">
                  <button class="btn--show-modal-article">詳情</button>
                </div>
              </div>
                <div class="modal-article hidden">
                  <button class="btn--close-modal-article">&times;</button>
                  <h2 class="modal__header">文章詳情</h2>
                  <p class="modal-sub-header">累計點數：${article.article_points_recieved} 點</p>
                  <div class="modal__container">
                    <div class="article-div">
                      <div class="article-top-box">
                        <div class="article-picture">
                          <img
                            src="${articleUrl}"
                            alt="article-picture"
                            class="article-img"
                          />
                        </div>
                        <div class="article-details">
                          <h4>名稱：${article.article_title}</h4>
                          <p>發文日期：${article.article_date_created}</p>
                          <p>登山日期：${article.event_date}</p>
                          <p>山名：${article.mountain_name}</p>
                        </div>
                      </div>
                      <div class="article-bottom-box">
                        <div class="article-text">
                          <h4>內容：</h4>
                          <p>
                            ${article.article_content}
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
            </a>
  `;
  cards.insertAdjacentHTML("afterbegin", html);
};

// RENDER PARTICIPATING EVENTS
const renderPartEvent = function (part) {
  // need to convert the time
  // need to convert event status
  const partBytesStr = atob(part.picString);
  let partLen = partBytesStr.length;
  const partu8Array = new Uint8Array(partLen);
  while (partLen--) {
    partu8Array[partLen] = partBytesStr.charCodeAt(partLen);
  }
  const partBlob = new Blob([partu8Array]);
  const partUrl = URL.createObjectURL(partBlob);

  let html = `
            <a href="#" class = "part-card">
              <div class="card-3">
                <div class="event-status">
                  <p>狀態: ${part.eventStatus}</p>
                </div>
                <div class="event-no">
                  <p>參團編號: ${part.eventId}</p>
                </div>
                <div class="event-name">
                  <p>參團名稱: ${part.eventName}</p>
                </div>
                <div class="event-date">
                  <p>出團日期: ${part.eventStartDate}</p>
                </div>
                <div class="event-mtn">
                  <p>地點: ${part.mountainName}</p>
                </div>
                <div class="event-attendees">
                  <p>目前參加人數: ${part.eventCurPart} 人</p>
                </div>
                <div class="event-details">
                  <button class="btn--show-modal-part">詳情</button>
                </div>
              </div>
              <div class="modal-part hidden">
                <button class="btn--close-modal-part">&times;</button>
                <h2 class="modal__header">參團詳情</h2>
                <p class="modal-sub-header">目前人數：${part.eventCurPart} 位</p>
                <div class="modal__container">
                  <div class="part-div">
                    <div class="part-top-box">
                      <div class="part-picture">
                        <img
                          src="${partUrl}"
                          alt="part-picture"
                          class="part-img"
                        />
                      </div>
                      <div class="part-details">
                        <h4>名稱：${part.eventName}</h4>
                        <p>登山日期：${part.eventStartDate}</p>
                        <p>山名：${part.mountainName}</p>
                        <p>集合地點：${part.assemblingPlace}</p>
                      </div>
                    </div>
                    <div class="part-bottom-box">
                      <div class="part-textbox">
                        <h4>揪團內容：</h4>
                        <div class="part-content">
                          <p>
                          ${part.eventContent}
                          </p>
                        </div>
                        <div class="cancel-part">
                          <button class="cancel-part-btn">取消參團</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div> 
          </a> 
  `;
  cards.insertAdjacentHTML("afterbegin", html);
};

// RENDER EVENT
const renderEvent = function (eventList) {
  // need to convert the time
  // need to convert the eventStatus

  let html = `
              <a href="#" class = "event-card">
              <div class="card-1">
                <div class="event-status">
                  <p>狀態：${eventList.eventStatus}</p>
                </div>
                <div class="event-no">
                  <p>揪團編號：${eventList.eventId}</p>
                </div>
                <div class="event-name">
                  <p>揪團名稱：${eventList.eventName}</p>
                </div>
                <div class="event-date">
                  <p>出團日期：${eventList.eventStartDate}</p>
                </div>
                <div class="event-mtn">
                  <p>地點：${eventList.mountainName}</p>
                </div>
                <div class="event-attendees">
                  <p>目前參加人數：${eventList.eventCurPart} 人</p>
                </div>
                <div class="event-details">
                  <button class="btn--show-modal">詳情</button>
                </div>
              </div>
              <div class="modal hidden">
                <button class="btn--close-modal">&times;</button>
                <h2 class="modal__header">揪團詳情</h2>
                <p class="modal-sub-header">狀態：${eventList.eventStatus}</p>
                <div class="modal__container">
                  <div class="modal-box1">
                    <form class="confirm-event">
                      <ul class="modal-event-details">
                        <li>揪團編號：${eventList.eventId}</li>
                        <li>團名：${eventList.eventName}</li>
                        <li>出團日期：${eventList.eventStartDate}</li>
                        <li>預計截團日期：${eventList.eventDeadline}</li>
                        <li>目前參與人數：${eventList.eventCurPart} 位</li>
                        <li>成團人數：${eventList.maxNumOfPeople} 位</li>
                        <div class="submit-button">
                          <button type="submit" class="submit-confirm-event">
                            確定成團
                          </button>
                        </div>
                      </ul>
                    </form>
                    <div class="cancel-event">
                      <div class="cancel-title">
                        <h3>取消原因</h3>
                        <p>若欲取消開團，請點選原因</p>
                      </div>
                      <form class="form-cancel-reason" action="GET">
                        <div class="reason group1">
                          <label
                            ><input
                              type="radio"
                              name="cancel-reason"
                              value="weather"
                            />天氣關係</label
                          >
                          <label
                            ><input
                              type="radio"
                              name="cancel-reason"
                              value="people"
                            />人數不足</label
                          >
                        </div>
                        <div class="reason group2">
                          <label
                            ><input
                              type="radio"
                              name="cancel-reason"
                              value="sick"
                            />身體不適</label
                          >
                          <label
                            ><input
                              type="radio"
                              name="cancel-reason"
                              value="other"
                            />其他因素</label
                          >
                        </div>
                        <div class="submit-button">
                          <button type="submit" class="submit-cancel-event">
                            確定取消
                          </button>
                        </div>
                      </form>
                    </div>
                  </div>
                  <div class="modal-box2">
                    <h4>參加人員</h4>
                    <div class="attendee-list event-list-no-${eventList.eventId}">
                      
                    </div>
                  </div>
                </div>
              </div>
            </a>
            `;
  cards.insertAdjacentHTML("afterbegin", html);
};

// RENDER EVENT PARTICIPANTS
const renderParticipants = function (eventPart, eventId, itemNo) {
  const memberBytesStr = atob(eventPart.picStr);
  let memberLen = memberBytesStr.length;
  const memberu8Array = new Uint8Array(memberLen);
  while (memberLen--) {
    memberu8Array[memberLen] = memberBytesStr.charCodeAt(memberLen);
  }
  const memberBlob = new Blob([memberu8Array]);
  const memberUrl = URL.createObjectURL(memberBlob);

  let eventPartDiv = document.querySelector(`.event-list-no-${eventId}`);
  let html = `
              <div class="attendee-item">
                <ul class="attendee-${itemNo}">
                  <li class="attendee-img">
                    <img
                      class="member-profile"
                      src="${memberUrl}"
                      alt="user_pic"
                    />
                  </li>
                  <li class="attendee-name">${eventPart.memberName}</li>
                  <li class="attendee-email">${eventPart.memberEmail}</li>
                </ul>
              </div>
            `;
  eventPartDiv.insertAdjacentHTML("afterbegin", html);
};

////////////////////////////////////////
//////// POPULATING PAGE ///////
const articleList = function () {
  fetch(`/shanshan/memberArticle/findAllArticlesByMemId`)
    .then((body) => body.json())
    .then((articles) => {
      for (let article of articles) {
        renderArticle(article);
      }
    });
};

const partEventList = function () {
  fetch(`/shanshan/memberArticle/findPartEventByMemberId`)
    .then((body) => body.json())
    .then((parts) => {
      for (let part of parts) {
        renderPartEvent(part);
      }
    });
};

let itemNo = 1;
const eventList = function () {
  fetch(`/shanshan/memberArticle/findAllEventsByMemId`)
    .then((body) => body.json())
    .then(async (events) => {
      for (let event of events) {
        renderEvent(event);
        const response = await fetch(
          `/shanshan/memberArticle/findParEventByEventId?eventId=${event.eventId}`
        );
        const eventParts = await response.json();
        for (let eventPart of eventParts) {
          itemNo = itemNo == 2 ? 1 : 2;
          renderParticipants(eventPart, event.eventId, itemNo);
        }
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
  articleList();
  partEventList();
  eventList();
};

////////////////////////////////////////
// OPEN & CLOSE MODAL
document.addEventListener("click", function (e) {
  // card-1 event-card
  if (e.target.classList.contains("btn--show-modal")) {
    let parent = e.target.closest("a.event-card");
    let modal = parent.querySelector(".modal");
    let overlay = document.querySelector(".overlay");
    let btnCloseModal = parent.querySelector(".btn--close-modal");
    let btnConfirmEvent = parent.querySelector(".submit-confirm-event");

    modal.classList.remove("hidden");
    overlay.classList.remove("hidden");

    const closeModal = function () {
      modal.classList.add("hidden");
      overlay.classList.add("hidden");
    };

    btnCloseModal.addEventListener("click", closeModal);
    overlay.addEventListener("click", closeModal);

    document.addEventListener("keydown", function (e) {
      if (e.key === "Escape" && !modal.classList.contains("hidden")) {
        closeModal();
      }
    });

    btnConfirmEvent.addEventListener("click", function (e) {
      e.preventDefault();
      console.log("event-submit clicked");
    });
  }
  // card-2 article-card
  if (e.target.classList.contains("btn--show-modal-article")) {
    // console.log("modal-article button clicked");
    let parent = e.target.closest("a.article-card");
    let modalArticle = parent.querySelector(".modal-article");
    let overlayArticle = document.querySelector(".overlay-article");
    let btnCloseModalArticle = parent.querySelector(
      ".btn--close-modal-article"
    );

    modalArticle.classList.remove("hidden");
    overlayArticle.classList.remove("hidden");

    const closeModalArticle = function () {
      modalArticle.classList.add("hidden");
      overlayArticle.classList.add("hidden");
    };

    btnCloseModalArticle.addEventListener("click", closeModalArticle);
    overlayArticle.addEventListener("click", closeModalArticle);

    document.addEventListener("keydown", function (e) {
      if (e.key === "Escape" && !modalArticle.classList.contains("hidden")) {
        closeModalArticle();
      }
    });
  }
  // card-3 part-card
  if (e.target.classList.contains("btn--show-modal-part")) {
    let parent = e.target.closest("a.part-card");
    let modalPart = parent.querySelector(".modal-part");
    let overlayPart = document.querySelector(".overlay-part");
    let btnCloseModalPart = parent.querySelector(".btn--close-modal-part");

    modalPart.classList.remove("hidden");
    overlayPart.classList.remove("hidden");

    const closeModal = function () {
      modalPart.classList.add("hidden");
      overlayPart.classList.add("hidden");
    };

    btnCloseModalPart.addEventListener("click", closeModal);
    overlayPart.addEventListener("click", closeModal);

    document.addEventListener("keydown", function (e) {
      if (e.key === "Escape" && !modalPart.classList.contains("hidden")) {
        closeModal();
      }
    });
  }
});

////////////////////////////////////////
//////// SORT CARDS ///////
sortBtnArticle.addEventListener("click", function () {
  cards.innerHTML = "";
  articleList();
});

sortBtnEvent.addEventListener("click", function () {
  cards.innerHTML = "";
  eventList();
});

sortBtnPart.addEventListener("click", function () {
  cards.innerHTML = "";
  partEventList();
});
