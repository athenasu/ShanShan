// 註冊燈箱     OK
// 登入燈箱     OK
// 購物主頁     OK
// 全部商品頁面 OK
// 全部店家頁面 OK
// 店家頁面     OK
// 單類商品頁面 OK
// 單項商品頁面 OK
// 購物車
// 結帳流程

$(document).ready(function () {

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 登入 開始
    // 點擊登入按鈕，開啟選擇登入方式的燈箱
    $("input.login_modal_botton").click(function () {
        $("div.login_modal_bcg").removeClass("-none")
        $("div.login_modal").removeClass("-none")
    })


    // 點擊半透明黑色背景，取消登入的燈箱
    $("div.login_modal_bcg").click(function () {
        $("div.login_modal_bcg").addClass("-none")
        $("div.login_modal").addClass("-none")
        $("div.login_modal_email").addClass("-none")
    })


    // 點擊用EMAIL登入，到EMAIL登入
    $("input.emaillogin").click(function () {
        $("div.login_modal").addClass("-none")
        $("div.login_modal_email").removeClass("-none")
    })

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 登入 結束


    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 註冊 開始
    // 點擊註冊頁面，回到選擇註冊方式
    $("div.registor_title_signup").click(function () {
        $("form.signup_email_form").addClass("-none")
        $("form.choose_signup_form").removeClass("-none")
    })

    // 點擊用電子郵件註冊，到電子郵件註冊
    $("input.summitbutton_signupemail").click(function () {
        $("form.choose_signup_form").addClass("-none")
        $("form.signup_email_form").removeClass("-none")
    })

    // 點擊logo圖片或註冊頁面，到山山首頁
    $("div.registor_titlepic").click(function () {
        //超連結至首頁
    })
    $("div.registor_title_shanshan").click(function () {
        //超連結至首頁
    })

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 註冊 結束

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商店 開始

    // 登入 按鈕
    $("input.goods_login_modal_botton").click(function () {
        $("div.login_modal_bcg").removeClass("-none")
        $("div.login_modal").removeClass("-none")
    })

    // 註冊 按鈕
    $("input.registor_botton").click(function () {
    })

    // 山山來此 圖示
    $("div.goods_titlepic").click(function () {
        alert("功能未實現。")
    })

    // 山山來此 字樣
    $("div.goods_header_title_shanshan").click(function () {
        alert("功能未實現。")
    })

    // 攻山小物 字樣
    $("div.goods_header_title").click(function () {
        alert("功能未實現。")
    })

    // 商品 字樣
    $("div.goods_header_item_goods").click(function () {
        alert("功能未實現。")
    })

    // 商店 字樣
    $("div.goods_header_item_stores").click(function () {
        alert("功能未實現。")
    })


    // focus 搜尋功能div,input,select ,產生效果
    $("div.goods_search_area,input.goods_search,select.goods_search_choose_bar").focus(function () {
        $("div.goods_search_area").css("outline", "2px solid rgb(187, 177, 147)")
        $("div.goods_search_area").css("border", "2px solid transparent")
    });
    $("div.goods_search_area,input.goods_search,select.goods_search_choose_bar").blur(function () {
        $("div.goods_search_area").css("outline", "none")
        $("div.goods_search_area").css("border", "2px solid rgb(214, 214, 214)")
    });


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

    // 觸發第1頁
    function hovercircle1() {
        $("div.slideshow_circle_area div:nth-child(1)").mouseenter(function () {
            console.log("觸發第1");
            $(slider1).removeClass("-none");
            $(slider2).addClass("-none");
            $(slider3).addClass("-none");
        })
    }
    // 觸發第2頁
    function hovercircle2() {
        $("div.slideshow_circle_area div:nth-child(2)").mouseenter(function () {
            console.log("觸發第2");
            $(slider1).addClass("-none");
            $(slider2).removeClass("-none");
            $(slider3).addClass("-none");
        })
    }
    // 觸發第3頁
    function hovercircle3() {
        $("div.slideshow_circle_area div:nth-child(3)").mouseenter(function () {
            console.log("觸發第3");
            $(slider1).addClass("-none");
            $(slider2).addClass("-none");
            $(slider3).removeClass("-none");
        })
    }


    // 點擊收藏商品
    $("div.goods_icon").click(function (e) {
        $(this).addClass("-none")
        $(this).parent().find("div.goods_icon_keep").removeClass("-none")
        e.stopPropagation()
    })

    // 點擊取消收藏商品
    $("div.goods_icon_keep").click(function (e) {
        $(this).addClass("-none")
        $(this).parent().find("div.goods_icon").removeClass("-none")
        e.stopPropagation()
    })

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商品頁面
    // 單項 商品 展示圖 

    // 設定第一張展示圖 為大圖 的方法
    function set_firstpic_as_mainpic() {
        let img = $("li.product_slideshow_pics:first-child").html()
        $("div.product_slideshow_main").children("img").replaceWith(img);
    }
    // 載入方法
    set_firstpic_as_mainpic();

    // hover的圖片 成為大圖 / 變成紅框 /其他的圖片解除紅框 
    $("li.product_slideshow_pics").hover(function () {
        $("li.product_slideshow_pics").removeClass("pics_select");
        $(this).addClass("pics_select")

        let img = $(this).html()
        $("div.product_slideshow_main").children("img").replaceWith(img);
    })

    // 點擊 up按鈕, 移動展示圖 (未完成)
    // $("i.product_slideshow_contrl_icon_up").click(function () {
    //     console.log("up")
    //     let up = "-90"
    //     $("ul.product_slideshow_pages_ul").css(`"top","${up}px"`)
    //     $("ul.product_slideshow_pages_ul").css("top","-90px")
    // })
    // 
    // 點擊 down按鈕, 移動展示圖(未完成)
    // $("i.product_slideshow_contrl_icon_down").click(function () {
    //     console.log("down")
    // })


    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 購物車頁面 開始
    // 載入 商品X數量 的 價格 (未完成)
    function cart_item_price() {

        // 如何寫循環?
        let cart_item_price = (parseInt($("span.cart_single_item_price:eq(0)").text()) * parseInt($("span.carts_adust_item_qty:eq(0)").text()))
        $("span.cart_item_price:eq(0)").text(cart_item_price)

        // let cart_single_item_price = $("span.cart_single_item_price:eq(0)").text()
        // let carts_adust_item_qty = $("span.carts_adust_item_qty:eq(0)").text()
        // let cart_item_price = (parseInt(cart_single_item_price,10) * parseInt(carts_adust_item_qty,10))
        // $("span.cart_item_price:eq(0)").text(cart_item_price)

    }
    cart_item_price()

    // 點擊 全選，選擇全部商品，如果再次點擊時，全選checkbox已經checked，那就全部取消 (未完成)
    // $("input.selectallcart").click(function () {
    //     console.log("selectallcart")
    // })

    // 點擊 清空購物車，移除購物車全部商品 
    $("ul.cart_end_area li:nth-child(2)").click(function () {

        let check = confirm("是否要移除購物車全部商品");
        if (check) {
            $("ul.cart_product_content_area").empty();
        }
        // 移除購物車全部商品時，單品價格與購物車總價格也要變動
        $("span.cart_total_price").text("0")
    })

    // 點擊 移除，移除該項商品  (未完成)
    $("li.cart_product_content10 span").click(function () {
        $(this).closest("ul").remove()
        // 移除商品時，單品價格與購物車總價格也要變動
    })

    // 點擊add，購買數增加1  (未完成)
    $("div.carts_adjust_qty i.fa-plus").click(function () {
        let cur_qty = $(this).siblings("span").text()
        let add_qty = parseInt(cur_qty) + 1;
        $(this).siblings("span").text(add_qty)
        // 添加數量時，單品價格與購物車總價格也要變動

    })

    // 點擊reduce，購買數減少1  (未完成)
    $("div.carts_adjust_qty i.fa-minus").click(function () {
        let cur_qty = $(this).siblings("span").text()
        let reduce_qty = parseInt(cur_qty) - 1;
        if (cur_qty > 1) {
            $(this).siblings("span").text(reduce_qty)
        }
        else if (cur_qty = 1) {
            let check = confirm("是否要移除本商品");
            if (check) {
                $(this).closest("ul").remove()
            }
        }
        // 添加數量時，單品價格與購物車總價格也要變動
    })



    // 計算 商品X數量 的 價格 (未完成)
    $("div.carts_adjust_qty i.fa-plus").click(function () {

        // console.log($("span.cart_single_item_price:eq(0)").text())

        // console.log($("ul.cart_product_content:nth-child(1)").html())
        // console.log($("li.cart_product_content6 span"))
        // console.log($("li.cart_product_content6 span").text())
    })

    // 計算購物車總價格 (未完成) 
    // 1.載入時，計算總價格
    // 2.有任何變動時，計算總價格(寫在其他功能裡)
    $("ul.cart_product_content_area").on("change", function () {
        // console.log($("ul.cart_product_content:nth-child(1)").html())
        // console.log($("li.cart_product_content6 span"))
        // console.log($("li.cart_product_content6 span").text())
        // console.log(parseInt("li.cart_product_content6 span"))
    })

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 購物車頁面 結束
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 確認訂單頁面 開始

    $("input.payment_points_range").change(function () {
        $("span.payment_points_num").text($("input.payment_points_range").val())

    })

    
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 確認訂單頁面 結束

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商店 結束

    // $(document).ready()結束
})