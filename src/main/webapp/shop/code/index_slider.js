$(document).ready(function () {
    
    // 商店 兩秒自動輪播功能
    slidershow();
    setInterval(slidershow, 9000);

    var slider1 = "ul.goodsindex_topslideshow_area li:nth-child(1)";
    var slider2 = "ul.goodsindex_topslideshow_area li:nth-child(2)";
    var slider3 = "ul.goodsindex_topslideshow_area li:nth-child(3)";

    function slidershow() {
        setTimeout(slidershow1, 3000);
        setTimeout(slidershow2, 6000);
        setTimeout(slidershow3, 9000);
    }

    function slidershow1() {
        $(slider1).addClass("-none")
        $(slider2).removeClass("-none");
        $(slider3).addClass("-none")
    }

    function slidershow2() {
        $(slider1).addClass("-none")
        $(slider2).addClass("-none")
        $(slider3).removeClass("-none");
    }

    function slidershow3() {
        $(slider3).addClass("-none")
        $(slider2).addClass("-none")
        $(slider1).removeClass("-none");
    }

    // 輪播 按鈕
    hovercircle1();
    hovercircle2();
    hovercircle3();

    // 滑鼠hover觸發第1頁
    function hovercircle1() {
        $("div.slideshow_circle_area div:nth-child(1)").mouseenter(function () {
            console.log("觸發第1");
            $(slider1).removeClass("-none");
            $(slider2).addClass("-none");
            $(slider3).addClass("-none");
        })
    }
    // 滑鼠hover觸發第2頁
    function hovercircle2() {
        $("div.slideshow_circle_area div:nth-child(2)").mouseenter(function () {
            console.log("觸發第2");
            $(slider1).addClass("-none");
            $(slider2).removeClass("-none");
            $(slider3).addClass("-none");
        })
    }
    // 滑鼠hover觸發第3頁
    function hovercircle3() {
        $("div.slideshow_circle_area div:nth-child(3)").mouseenter(function () {
            console.log("觸發第3");
            $(slider1).addClass("-none");
            $(slider2).addClass("-none");
            $(slider3).removeClass("-none");
        })
    }


})