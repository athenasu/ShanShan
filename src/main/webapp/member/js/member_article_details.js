///////////// selecting elements ////////////
// EVENT MODAL
const modal = document.querySelector(".modal");
const overlay = document.querySelector(".overlay");
const btnCloseModal = document.querySelector(".btn--close-modal");
const btnsOpenModal = document.querySelectorAll(".btn--show-modal");

//ARTICLE MODAL
const modalArticle = document.querySelector(".modal-article");
const overlayArticle = document.querySelector(".overlay-article");
const btnCloseModalArticle = document.querySelector(
  ".btn--close-modal-article"
);
const btnsOpenModalArticle = document.querySelectorAll(
  ".btn--show-modal-article"
);

// PARTICIPANT MODAL
const modalPart = document.querySelector(".modal-part");
const overlayPart = document.querySelector(".overlay-part");
const btnCloseModalPart = document.querySelector(".btn--close-modal-part");
const btnsOpenModalPart = document.querySelectorAll(".btn--show-modal-part");

///////////////////////////////////////
// MODAL

// EVENT MODAL //
const openModal = function (e) {
  e.preventDefault();
  modal.classList.remove("hidden");
  overlay.classList.remove("hidden");
};

const closeModal = function () {
  modal.classList.add("hidden");
  overlay.classList.add("hidden");
};
btnsOpenModal.forEach((btn) => btn.addEventListener("click", openModal));

btnCloseModal.addEventListener("click", closeModal);
overlay.addEventListener("click", closeModal);

document.addEventListener("keydown", function (e) {
  if (e.key === "Escape" && !modal.classList.contains("hidden")) {
    closeModal();
  }
});

// ARTICLE MODAL //
const openModalArticle = function (e) {
  e.preventDefault();
  modalArticle.classList.remove("hidden");
  overlayArticle.classList.remove("hidden");
};

const closeModalArticle = function () {
  modalArticle.classList.add("hidden");
  overlayArticle.classList.add("hidden");
};

btnsOpenModalArticle.forEach((btn) =>
  btn.addEventListener("click", openModalArticle)
);
btnCloseModalArticle.addEventListener("click", closeModalArticle);
overlayArticle.addEventListener("click", closeModalArticle);

document.addEventListener("keydown", function (e) {
  if (e.key === "Escape" && !modalArticle.classList.contains("hidden")) {
    closeModalArticle();
  }
});

// PARTICIPANT MODAL //
const openModalPart = function (e) {
  e.preventDefault();
  modalPart.classList.remove("hidden");
  overlayPart.classList.remove("hidden");
};

const closeModalPart = function () {
  modalPart.classList.add("hidden");
  overlayPart.classList.add("hidden");
};

btnsOpenModalPart.forEach((btn) =>
  btn.addEventListener("click", openModalPart)
);

btnCloseModalPart.addEventListener("click", closeModalPart);
overlayPart.addEventListener("click", closeModalPart);

document.addEventListener("keydown", function (e) {
  if (e.key === "Escape" && !modalPart.classList.contains("hidden")) {
    closeModalPart();
  }
});
