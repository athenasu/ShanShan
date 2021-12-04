///////////// selecting elements ////////////

// CARDS
const cards = document.querySelector(".cards");

// //ARTICLE MODAL
// const modalArticle = document.querySelector(".modal-article");
// const overlayArticle = document.querySelector(".overlay-article");
// const btnCloseModalArticle = document.querySelector(
//   ".btn--close-modal-article"
// );
// const btnsOpenModalArticle = document.querySelectorAll(
//   ".btn--show-modal-article"
// );

// // PARTICIPANT MODAL
// const modalPart = document.querySelector(".modal-part");
// const overlayPart = document.querySelector(".overlay-part");
// const btnCloseModalPart = document.querySelector(".btn--close-modal-part");
// const btnsOpenModalPart = document.querySelectorAll(".btn--show-modal-part");

// ///////////////////////////////////////
// // MODAL

// // EVENT MODAL //
// const openModal = function (e) {
//   e.preventDefault();
//   modal.classList.remove("hidden");
//   overlay.classList.remove("hidden");
// };

// const closeModal = function () {
//   modal.classList.add("hidden");
//   overlay.classList.add("hidden");
// };
// btnsOpenModal.forEach((btn) => btn.addEventListener("click", openModal));

// btnCloseModal.addEventListener("click", closeModal);
// overlay.addEventListener("click", closeModal);

// document.addEventListener("keydown", function (e) {
//   if (e.key === "Escape" && !modal.classList.contains("hidden")) {
//     closeModal();
//   }
// });

// PARTICIPANT MODAL //
// const openModalPart = function (e) {
//   e.preventDefault();
//   modalPart.classList.remove("hidden");
//   overlayPart.classList.remove("hidden");
// };

// const closeModalPart = function () {
//   modalPart.classList.add("hidden");
//   overlayPart.classList.add("hidden");
// };

// btnsOpenModalPart.forEach((btn) =>
//   btn.addEventListener("click", openModalPart)
// );

// btnCloseModalPart.addEventListener("click", closeModalPart);
// overlayPart.addEventListener("click", closeModalPart);

// document.addEventListener("keydown", function (e) {
//   if (e.key === "Escape" && !modalPart.classList.contains("hidden")) {
//     closeModalPart();
//   }
// });

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

const renderParticipant = function (part) {
  // need to convert the time
  // const partBytesStr = atob(part.picString);
  // let partLen = partBytesStr.length;
  // const partu8Array = new Uint8Array(partLen);
  // while (partLen--) {
  //   partu8Array[partLen] = partBytesStr.charCodeAt(partLen);
  // }
  // const partBlob = new Blob([partu8Array]);
  // const partUrl = URL.createObjectURL(partBlob);

  let html = `
            <a href="#" class = "part-card">
              <div class="card-3">
                <div class="event-status">
                  <p>狀態: 已成團</p>
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
                          src="./img/TKAI8700--02.jpg"
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

const article = function () {
  fetch(`/shanshan/memberArticle/findAllArticlesByMemId?memberId=1`)
    .then((body) => body.json())
    .then((articles) => {
      for (let article of articles) {
        renderArticle(article);
      }
    });
};

const part = function () {
  fetch(`/shanshan/memberArticle/findPartEventByMemberId?memberId=1`)
    .then((body) => body.json())
    .then((parts) => {
      for (let part of parts) {
        renderParticipant(part);
      }
    });
};

window.onload = function () {
  article();
  part();
};

document.addEventListener("click", function (e) {
  if (e.target.classList.contains("btn--show-modal-article")) {
    console.log("modal-article button clicked");
    // ARTICLE MODAL
    let parent = e.target.closest("a.article-card");
    let modalArticle = parent.querySelector(".modal-article");
    let overlayArticle = document.querySelector(".overlay-article");
    let btnCloseModalArticle = parent.querySelector(
      ".btn--close-modal-article"
    );
    // let btnsOpenModalArticle = parent.querySelector(".btn--show-modal-article");

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
  if (e.target.classList.contains("btn--show-modal-part")) {
    let parent = e.target.closest("a.part-card");
    let modalPart = parent.querySelector(".modal-part");
    let overlayPart = document.querySelector(".overlay-part");
    let btnCloseModalPart = parent.querySelector(".btn--close-modal-part");
    // const btnsOpenModalPart = parent.querySelector(".btn--show-modal-part");

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
