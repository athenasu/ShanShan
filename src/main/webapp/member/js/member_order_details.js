///////////// selecting elements ////////////

// done cases //
const modalDone = document.querySelector(".modal-done");
const overlayDone = document.querySelector(".overlay-done");
const btnCloseModalDone = document.querySelector(".btn--close-modal-done");
const btnsOpenModalDone = document.querySelectorAll(".btn--show-modal-done");

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

///////////////////////////////////////
// Modal window

// done cases //
const openModalDone = function (e) {
  e.preventDefault();
  modalDone.classList.remove("hidden");
  overlayDone.classList.remove("hidden");
};

const closeModalDone = function () {
  modalDone.classList.add("hidden");
  overlayDone.classList.add("hidden");
};

btnsOpenModalDone.forEach((btn) =>
  btn.addEventListener("click", openModalDone)
);
btnCloseModalDone.addEventListener("click", closeModalDone);
overlayDone.addEventListener("click", closeModalDone);

document.addEventListener("keydown", function (e) {
  if (e.key === "Escape" && !modalDone.classList.contains("hidden")) {
    closeModalDone();
  }
});

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

btnsOpenModalIntransit.forEach((btn) =>
  btn.addEventListener("click", openModalIntransit)
);
btnCloseModalIntransit.addEventListener("click", closeModalIntransit);
overlayIntransit.addEventListener("click", closeModalIntransit);

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

btnsOpenModalReturned.forEach((btn) =>
  btn.addEventListener("click", openModalReturned)
);
btnCloseModalReturned.addEventListener("click", closeModalReturned);
overlayReturned.addEventListener("click", closeModalReturned);

document.addEventListener("keydown", function (e) {
  if (e.key === "Escape" && !modalReturned.classList.contains("hidden")) {
    closeModalReturned();
  }
});
