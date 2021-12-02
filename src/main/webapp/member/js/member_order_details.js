"use strict";
///////////// selecting elements ////////////

// intransit cases //
const modalIntransit = document.querySelector(".modal-intransit");
const overlayIntransit = document.querySelector(".overlay-intransit");
const btnCloseModalIntransit = document.querySelector(
  ".btn--close-modal-intransit"
);
const btnsOpenModalIntransit = document.querySelectorAll(
  ".btn--show-modal-intransit"
);

// returned cases //
const modalReturned = document.querySelector(".modal-returned");
const overlayReturned = document.querySelector(".overlay-returned");
const btnCloseModalReturned = document.querySelector(
  ".btn--close-modal-returned"
);
const btnsOpenModalReturned = document.querySelectorAll(
  ".btn--show-modal-returned"
);

// CARDS //
/////////////////////////////
////// RENDER CARDS //////

// DONE ORDERS
const renderDoneOrders = function (order) {
  let card1 = `
                <div class="card-1">
                  <div class="order-status">
                    <p>狀態: 已完成</p>
                  </div>
                  <div class="order-no">
                    <p>訂單編號: ${order.order_id}</p>
                  </div>
                  <div class="order-date">
                    <p>訂購日期: ${order.order_created_date}</p>
                  </div>
                  <div class="order-sum">
                    <p>購物金額: ${order.order_sum_after} 元</p>
                  </div>
                  <div class="order-details">
                    <button class="btn--show-modal-done">詳情</button>
                  </div>
                </div>
              `;

  let hiddenCard = `
                <div class="modal-done hidden">
                <button class="btn--close-modal-done">&times;</button>
                <h2 class="modal__header">訂單詳情</h2>
                <p class="modal-sub-header">狀態：已完成</p>
                <div class="modal__container">
                  <div class="modal-box1">
                    <ul class="modal-event-details">
                      <li>訂單編號：${order.order_id}</li>
                      <li>訂購日期：${order.order_created_date}</li>
                      <li>購買商品：</li>
                      <div class="order-list no-${order.order_id}">
                        
                      </div>
                      <div class="modal-order-sum">總金額：${order.order_sum_after} 元</div>
                    </ul>
                    <div class="box2">
                      <div class="shipping-info">
                        <div class="cancel-title">
                          <ul>
                            <li>出貨日期：${order.order_shipped_date}</li>
                            <li>配送單號：${order.ship_number}</li>
                            <li>到貨日期：!!需要在計算＆轉換!!</li>
                            <ul class="notes">
                              <li>若須申請退貨，請於收到商品7天內申請</li>
                              <li>最晚退貨日期：!!需要在計算＆轉換!!</li>
                            </ul>
                          </ul>
                        </div>
                      </div>
                      <div class="confirm-buttons-container">
                        <div class="submit-button">
                          <button type="submit" class="submit-cancel-event">
                            確定付款
                          </button>
                        </div>
                        <div class="submit-button">
                          <button type="submit" class="submit-confirm-event">
                            申請退貨
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="overlay-done hidden"></div>
                `;

  const cards = document.querySelector(".cards");
  cards.insertAdjacentHTML("beforeend", card1);
  const hiddenCards = document.querySelector(".modal-area");
  hiddenCards.insertAdjacentHTML("beforeend", hiddenCard);
};

// DONE ORDER MODAL
const renderDoneOrderDetails = function (orderDetail, orderId) {
  const itemNo = 1 ? 2 : 1;
  // need to change this so that it selects the card that's relavent
  let orderItem = document.querySelector(`.no-${orderId}`);
  let html = `
              <a href="${orderDetail.prodes_id}">
                <ul class="item-${itemNo}">
                  <li class="item-name">品名：${orderDetail.product_name}</li>
                  <li class="item-size">規格：${orderDetail.product_color}${orderDetail.product_size}</li>
                  <li class="item-quantity">數量：!!沒有單個產品的數量!!</li>
                  <li class="item-price">單價：${orderDetail.subtotal_price} 元</li>
                </ul>
              </a>
              `;
  orderItem.insertAdjacentHTML("beforeend", html);
};

/////////////////////////////
////// POPULATING PAGE //////
// MAIN CARDS
const allOrders = function (memberId) {
  fetch(`/shanshan/memberOrder/findAllOrdersByMemId?memberId=${memberId}`)
    .then((body) => body.json())
    .then(async (orders) => {
      for (let order of orders) {
        if (order.order_status == 5) {
          renderDoneOrders(order);
          const response = await fetch(
            `/shanshan/memberOrder/findAllOrderDesByMemId?memberId=${memberId}&orderId=${order.order_id}`
          );
          // will wait until the above fetch is done before continuing the code below
          const orderDes = await response.json();
          for (let orderDetail of orderDes) {
            // in the case of member 1, there should be two orderDes
            renderDoneOrderDetails(orderDetail, order.order_id);
          }
        }
      }
    });
};

// const getCountryData = function (country) {
//   fetch(`https://restcountries.com/v2/name/${country}`)
//     .then(response => response.json())
//     .then(data => {
//       renderCountry(data[0]);
//       const neighbor = data[0].borders[0];

//       if (!neighbor) return;

//       return fetch(`https://restcountries.com/v2/alpha/${neighbor}`);
//     })
//     .then(response => response.json()) // also an asynchronous function, which is why we need another then()
//     .then(data => renderCountry(data, "neighbour"))
//     .catch(err => {
//       // console.error(err);
//       renderError(`Something went wrong: ${err.message}`);
//     });
// };

window.onload = function () {
  // need to fit the memberId in here. I think i can use the Promise(request, response) to initiate it first?
  // like to get the session and then stick it in here somehow
  allOrders(1);
};

///////////////////////////////////////
// Modal window

// intransit cases //
const openModalIntransit = function (e) {
  e.preventDefault();
  modalIntransit.classList.remove("hidden");
  overlayIntransit.classList.remove("hidden");
};

const closeModalIntransit = function () {
  modalIntransit.classList.add("hidden");
  overlayIntransit.classList.add("hidden");
};

// btnsOpenModalIntransit.forEach((btn) =>
//   btn.addEventListener("click", openModalIntransit)
// );
// btnCloseModalIntransit.addEventListener("click", closeModalIntransit);
// overlayIntransit.addEventListener("click", closeModalIntransit);

document.addEventListener("keydown", function (e) {
  if (e.key === "Escape" && !modalIntransit.classList.contains("hidden")) {
    closeModalIntransit();
  }
});

// returned cases //
const openModalReturned = function (e) {
  e.preventDefault();
  modalReturned.classList.remove("hidden");
  overlayReturned.classList.remove("hidden");
};

const closeModalReturned = function () {
  modalReturned.classList.add("hidden");
  overlayReturned.classList.add("hidden");
};

// btnsOpenModalReturned.forEach((btn) =>
//   btn.addEventListener("click", openModalReturned)
// );
// btnCloseModalReturned.addEventListener("click", closeModalReturned);
// overlayReturned.addEventListener("click", closeModalReturned);

document.addEventListener("keydown", function (e) {
  if (e.key === "Escape" && !modalReturned.classList.contains("hidden")) {
    closeModalReturned();
  }
});

document.addEventListener("click", function (e) {
  console.log(e.target);
  console.log();
  if (e.target.classList.contains("btn--show-modal-done")) {
    // done cases //
    let aaa = e.target.closest(".card-1");
    // let bbb = aaa.querySelector(".order-status");
    // console.log(bbb);
    let modalDone = aaa.querySelector(".modal-done");
    console.log(modalDone);
    let overlayDone = aaa.querySelector(".overlay-done");
    let btnCloseModalDone = aaa.querySelector(".btn--close-modal-done");
    let btnsOpenModalDone = aaa.querySelectorAll(".btn--show-modal-done");
    modalDone.classList.remove("hidden");
    overlayDone.classList.remove("hidden");
    console.log(btnsOpenModalDone);

    let openModalDone = function (e) {
      e.preventDefault();
      console.log("openModalDone");
      modalDone.classList.remove("hidden");
      overlayDone.classList.remove("hidden");
    };

    const closeModalDone = function () {
      modalDone.classList.add("hidden");
      overlayDone.classList.add("hidden");
    };

    // btnsOpenModalDone.forEach((btn) => {
    //   console.log("test");
    //   btn.addEventListener("click", openModalDone);
    // });
    btnCloseModalDone.addEventListener("click", closeModalDone);
    overlayDone.addEventListener("click", closeModalDone);

    document.addEventListener("keydown", function (e) {
      if (e.key === "Escape" && !modalDone.classList.contains("hidden")) {
        closeModalDone();
      }
    });
  }
});
