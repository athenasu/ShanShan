"use strict";
///////////// selecting elements ////////////
const infoSquare = document.querySelector(".square2");
const calendarIcon = document.querySelector(".calendar-icon");
const mapIcon = document.querySelector(".map-icon");
const mapOrCalendarArea = document.querySelector(".map-or-calendar");
////////////////////////////////////////
//////// MAPTY ///////
let map;
let mapZoom = 9;
let mapEvent;
let markers = [];

// for events and partEvents
const renderBoxEvent = function (eventMtn, leafletId) {
  let startDate = new Date(eventMtn.eventStartDate).toDateString();
  let html = `
                <div class="card" id = "${leafletId}">
                  <ul>
                    <li class="date">
                      <span><p>${startDate}</p></span>
                    </li>
                    <li class="event-name">
                      <span><p>名稱：${eventMtn.eventName}</p></span>
                    </li>
                    <li class="event-location">
                      <span><p>登山：${eventMtn.mountainName}</p></span>
                    </li>
                  </ul>
                </div>
            `;
  infoSquare.insertAdjacentHTML("afterbegin", html);
};

const renderBoxArticle = function (articleMtn, leafletId) {
  let startDate = new Date(articleMtn.event_date).toDateString();
  let html = `
                <div class="card" id = "${leafletId}">
                  <ul>
                    <li class="date">
                      <span><p>${startDate}</p></span>
                    </li>
                    <li class="event-name">
                      <span><p>名稱：${articleMtn.article_title}</p></span>
                    </li>
                    <li class="event-location">
                      <span><p>登山：${articleMtn.mountain_name}</p></span>
                    </li>
                  </ul>
                </div>
            `;
  infoSquare.insertAdjacentHTML("afterbegin", html);
};

// const renderBoxPart = function (partMtn, leafletId) {
//   let html = `
//                 <div class="card" id = "${leafletId}">
//                   <ul>
//                     <li class="date">
//                       <span><p>${partMtn.eventStartDate}</p></span>
//                     </li>
//                     <li class="event-name">
//                       <span><p>名稱：${partMtn.eventName}</p></span>
//                     </li>
//                     <li class="event-location">
//                       <span><p>登山：${partMtn.mountainName}</p></span>
//                     </li>
//                   </ul>
//                 </div>
//             `;
//   infoSquare.insertAdjacentHTML("afterbegin", html);
// };

const onMarkerClick = function (e) {
  console.log(e.target._leaflet_id);
  $(".card").removeClass("active");
  $(`div #${e.target._leaflet_id}`).addClass("active");
  map.panTo(e.target.getLatLng());
};

// const moveToMarker = function(e) {
//   const cardEl = e.target.closest(".card");

//   if (!cardEl) return;

//   const cardCont = this.markers.find(
//     leafletCard => leafletCard._leaflet_id === cardEl.dataset.id
//   );
//   this.map.setView(cardCont.coords, this.mapZoom, {
//     animate: true,
//     pan: {
//       duration: 1,
//     },
//   });

const renderMap = function () {
  if (navigator.geolocation) {
    // getting our current location
    navigator.geolocation.getCurrentPosition(
      function (position) {
        const { latitude } = position.coords;
        const { longitude } = position.coords;
        const coords = [latitude, longitude];
        console.log(coords);
        map = L.map("map").setView(coords, mapZoom);

        L.tileLayer("https://{s}.tile.openstreetmap.fr/hot/{z}/{x}/{y}.png", {
          attribution:
            '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
        }).addTo(map);

        // renders markers
        // render Event markers
        const renderEventMarker = function (eventMtn) {
          const coords = [
            eventMtn.mountainLatitude,
            eventMtn.mountainLongitude,
          ];
          // console.log(coords);
          L.marker(coords).addTo(map);
          let marker = new L.marker(coords);
          map.addLayer(marker);
          markers[marker._leaflet_id] = eventMtn.eventId;
          // console.log(marker._leaflet_id);
          renderBoxEvent(eventMtn, marker._leaflet_id);
          marker.on("click", onMarkerClick);
        };
        // render article markers
        const renderArticleMarker = function (articleMtn) {
          const coords = [
            articleMtn.mountain_latitude,
            articleMtn.mountain_longitude,
          ];
          // console.log(coords);
          L.marker(coords).addTo(map);
          let marker = new L.marker(coords);
          map.addLayer(marker);
          markers[marker._leaflet_id] = articleMtn.article_id;
          // console.log(marker._leaflet_id);
          renderBoxArticle(articleMtn, marker._leaflet_id);
          marker.on("click", onMarkerClick);
        };
        // render participating markers
        const renderPartMarker = function (partMtn) {
          const coords = [partMtn.mountainLatitude, partMtn.mountainLongitude];
          // console.log(coords);
          L.marker(coords).addTo(map);
          let marker = new L.marker(coords);
          map.addLayer(marker);
          markers[marker._leaflet_id] = partMtn.eventStartDate; // not using eventId because it might be the same
          // console.log(marker._leaflet_id);
          renderBoxEvent(partMtn, marker._leaflet_id);
          marker.on("click", onMarkerClick);
        };

        // fetching eventMtn
        fetch(`/shanshan/memberArticle/findAllEventsByMemId`)
          .then((body) => body.json())
          .then((eventMtns) => {
            for (let eventMtn of eventMtns) {
              renderEventMarker(eventMtn);
            }
          });
        // fetching articleMtn
        fetch(`/shanshan/memberArticle/findAllArticlesByMemId`)
          .then((body) => body.json())
          .then((articleMtns) => {
            for (let articleMtn of articleMtns) {
              renderArticleMarker(articleMtn);
            }
          });
        // fetching partMtn
        fetch(`/shanshan/memberArticle/findPartEventByMemberId`)
          .then((body) => body.json())
          .then((partMtns) => {
            for (let partMtn of partMtns) {
              renderPartMarker(partMtn);
            }
          });
      },
      function () {
        alert("Could not get your position.");
      }
    );
  }
};

////////////////////////////////////////
//////// Calendar ////////
let eventList = new Array();
const renderCalendar = function () {
  fetch(`/shanshan/memberArticle/findAllArticlesByMemId`)
    .then((body) => body.json())
    .then((articles) => {
      for (let article of articles) {
        let startDate = new Date(article.event_date).toDateString();
        let endDate = new Date(article.event_date).toDateString();
        let summary = article.article_title;
        let obj = {
          startDate: startDate,
          endDate: endDate,
          summary: summary,
        };
        eventList.push(obj);
      }
      return fetch(`/shanshan/memberArticle/findAllEventsByMemId`);
    })
    .then((body) => body.json())
    .then((memEvents) => {
      for (let memEvent of memEvents) {
        let startDate = new Date(memEvent.eventStartDate).toDateString();
        let endDate = new Date(memEvent.eventStartDate).toDateString();
        let summary = memEvent.eventName;
        let obj = {
          startDate: startDate,
          endDate: endDate,
          summary: summary,
        };
        eventList.push(obj);
      }
      return fetch(`/shanshan/memberArticle/findPartEventByMemberId`);
    })
    .then((body) => body.json())
    .then((partEvents) => {
      for (let partEvent of partEvents) {
        let startDate = new Date(partEvent.eventStartDate).toDateString();
        let endDate = new Date(partEvent.eventStartDate).toDateString();
        let summary = partEvent.eventName;
        let obj = {
          startDate: startDate,
          endDate: endDate,
          summary: summary,
        };
        eventList.push(obj);
      }
      console.log(eventList);
    })
    .then(
      jQuery("#container").simpleCalendar({
        displayEvent: true,
        // prettier-ignore
        months: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
        days: ["日", "一", "二", "三", "四", "五", "六"],
        events: eventList,

        // disable showing event details
        // disableEventDetails: false,
        // changing start day to sunday
        fixedStartDay: 0,

        // disable showing empty date details
        //        disableEmptyDetails: true,
        displayYear: true,
      })
    );
};

////////////////////////////////////////
//////// POPULATING PAGE ////////

// RENDER MEMBER DASHBOARD
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
  renderCalendar(); // depends on what i want to render first
};

////////////////////////////////////////
//////// SELECTING CALENDAR OR MAP ////////
calendarIcon.addEventListener("click", function () {
  mapOrCalendarArea.innerHTML = "";
  mapOrCalendarArea.insertAdjacentHTML(
    "afterbegin",
    `<div id="container"></div>`
  );
  renderCalendar();
});

mapIcon.addEventListener("click", function () {
  mapOrCalendarArea.innerHTML = "";
  mapOrCalendarArea.insertAdjacentHTML("afterbegin", `<div id="map"></div>`);
  renderMap();
});

// let startDate = new Date(
//   new Date().setHours(new Date().getHours() + 24)
// ).toDateString();
// let startDate = new Date(1625932800000).toDateString();
// console.log(startDate);
// console.log(typeof startDate);
