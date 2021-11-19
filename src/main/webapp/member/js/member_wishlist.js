const groupCard = document.querySelector(".groupcard");

const renderWishlistEvent = function (event) {
  let html = `
  <div class="groupcard">
  <a href="#?${event.wishlistEventId}">
    <div class="groupimg">
      <img src="/img/TKAI8700--02.jpg" class="img" />
      <p class="countdown">倒數：<span>10天13小時</span></p>
    </div>
    <div class="groupinfo">
      <h3 class="title2 gp_name">${event.event.eventName}</h3>
      <div class="infolist">
        <div><i class="far fa-clock"></i></div>
        <div>出團日期：<span>${event.event.eventStartDate}</span></div>
      </div>
      <div class="infolist">
        <div><i class="fas fa-bed"></i></div>
        <div>住宿種類：<span>${event.event.stayType}</span></div>
      </div>
      <div class="infolist">
        <div><i class="fas fa-hiking"></i></div>
        <div><span>東部</span></div>
      </div>
      <div class="leader">
        <div class="leaderimg">
          <img src="/img/d1900618.jpg" class="img" />
        </div>
        <div><span>${event.event.memberID}</span></div>
      </div>
    </div>
  </a>
</div>`;
  // insert HTML
  groupCard.insertAdjacentHTML("beforeend", html);
};

// INITIAL STUFF ON STIE //
const populatePage = function () {
  fetch("memberWishlist/findWishlistEventByMemberId")
    .then((body) => body.json())
    .then((member) => {
      for (let event of member.wishlistEvents) {
        // getting every event from the list
        renderWishlistEvent(event);
      }
      for (let prod of member.wishlistProducts) {
        renderWishlist(prod);
      }
    });
};

// UPLOAD FILE //
const submitBtn = document.querySelector(".submit-btn");

const updateInfo = function () {
  const memberName = document.querySelector(".member-name").value;
  const memberUsername = document.querySelector(".member-username").value;
  const memberEmail = document.querySelector(".member-email").value;
  const memberPassword = document.querySelector(".member-password").value;
  const memberIntro = document.querySelector(".member-intro-text").value;
  const file = hiddenInput.files[0];
  const fileReader = new FileReader();

  fileReader.onload = function (e) {
    const base64str = btoa(e.target.result);
    fetch("memberUpdate", {
      method: "POST",
      headers: {
        // we're telling Java what kind of file we're sending
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        picStr: base64str,
        memberName,
        memberUsername,
        memberEmail,
        memberPassword,
        memberIntro,
      }),
    });
  };
  fileReader.readAsBinaryString(file);
};

window.onload = function () {
  populatePage();
};

submitBtn.addEventListener("click", function () {
  console.log("submit button clicked");
  updateInfo();
  console.log("information updated");
  populatePage(); // why doesn't this work?
});

// $('.member-email input[name=my_id]').val(row.my_id).prop('readonly', true);
