//======================== SLIDESHOW ============================
 var slideIndex = 0;
 showSlides(slideIndex);

// // Next/previous controls
 function plusSlides(n) {
   showSlides(slideIndex += n);
 }

// // Thumbnail image controls
 function currentSlide(n) {
   showSlides(slideIndex = n);
 }

//  function showSlides(n) {
//    var i;
//    var slides = document.getElementsByClassName("mySlides");
//    var dots = document.getElementsByClassName("dot");
//    if (n > slides.length) {slideIndex = 1}
//    if (n < 1) {slideIndex = slides.length}
//    for (i = 0; i < slides.length; i++) {
//        slides[i].style.display = "none";
//    }
//    for (i = 0; i < dots.length; i++) {
//        dots[i].className = dots[i].className.replace(" active", "");
//    }
//    slides[slideIndex -1].style.display = "block";
//    dots[slideIndex -1].className += " active";
//  } 
//===============================================================
 var slideIndex = 0;
 showSlides();

 function showSlides() {
   var i;
   var slides = document.getElementsByClassName("mySlides");
   var dots = document.getElementsByClassName("dot");
   for (i = 0; i < slides.length; i++) {
     slides[i].style.display = "none";  
   }
   slideIndex++;
   if (slideIndex > slides.length) {slideIndex = 1}    
   for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" active", "");
   }
   slides[slideIndex-1].style.display = "block";  
   dots[slideIndex-1].className += " active";
   setTimeout(showSlides, 5000); // Change image every 5 seconds
 }
// function slideshow() {
//   // clone
//   $('.slider-1').clone().removeClass('slider-1').addClass('slider-2').insertAfter($('.slider'));

//   // set first
//   $('.slider-1').slick({
//     draggable: false,
//     dots: false,
//     infinite: true,
//     responsive: true,
//     asNavFor: '.slider-2',
//     touchThreshold: 20,
//     speed: 1000,
//     fade: true
//   });

//   // set second
//   $('.slider-2').slick({
//     dots: true,
//     infinite: true,
//     responsive: true,
//     asNavFor: '.slider-1',
//     arrows: false,
//     speed: 1000,
//     easing: 'easeInOutQuart'
//   });
// }

// $(function() {
//   slideshow();
//   setTimeout(function() {
//     $('.slider-1 .slick-next').click();
//   }, 1000);
// })