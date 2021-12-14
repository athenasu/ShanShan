$(document).ready(function () {

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 變數與方法
	  var member_id = 0;
//  登入 登出 切換
	  function login_logout (){
//		  取得登入狀態
		  member_id = $("input.member_id").val();
		  if (member_id > 0 ){
//		 登入：隱藏註冊按鈕
			$("input.goods_registor_botton").css( "visibility" , "hidden");
		  	$("input.goods_login_modal_botton").attr("value" , "登出");
		  }
	  }
	  
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 加載後執行
	  
	  login_logout();
		
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 登入 開始
//    // 點擊登入按鈕，開啟選擇登入方式的燈箱
//    $("input.login_modal_botton").click(function () {
//        $("div.login_modal_bcg").removeClass("-none")
////      $("div.login_modal").removeClass("-none")    // 第三方登入功能 的程式碼
//        $("div.login_modal_email").removeClass("-none")  	// 限EMAIL登入  程式碼
//    })


    // 點擊半透明黑色背景，取消登入的燈箱
    $("div.login_modal_bcg").click(function () {
        $("div.login_modal_bcg").addClass("-none")
        $("div.login_modal").addClass("-none")
        $("div.login_modal_email").addClass("-none")
    })


    // 點擊用EMAIL登入，到EMAIL登入                 // 第三方登入功能 的程式碼
//    $("input.emaillogin").click(function () {
//        $("div.login_modal").addClass("-none")
//        $("div.login_modal_email").removeClass("-none")
//    })

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
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商店 header 開始

//      登入/登出 按鈕
    $("input.goods_login_modal_botton").click(function () {
//      如果是未登入狀態
    	if (member_id == 0){
            $("div.login_modal_bcg").removeClass("-none")
//          $("div.login_modal").removeClass("-none")           // 第三方登入功能 的程式碼
            $("div.login_modal_email").removeClass("-none")  	// 限EMAIL登入  程式碼
    	}
        
//      如果是登入狀態
        if(member_id > 0){
        	if(confirm("您確定要登出嗎?")){
//				改登入狀態
        		$("input.member_id").val("0");
        		member_id = 0
//				把註冊變成可見
    			$("input.goods_registor_botton").css( "visibility" , "visible");
//				把登出按鈕變成登入按鈕
    		  	$("input.goods_login_modal_botton").attr("value" , "登入");
        	}
        }
    })

    // 註冊 按鈕
    $("input.registor_botton").click(function () {
    })

    // 山山來此 字樣
    $("div.goods_header_title_shanshan").click(function () {
        alert("你將離開商城頁面。")
    })


    // focus 搜尋功能 div,input,select ,產生效果
    $("div.goods_search_area,input.goods_search,select.goods_search_choose_bar").focus(function () {
        $("div.goods_search_area").css("outline", "2px solid rgb(187, 177, 147)")
        $("div.goods_search_area").css("border", "2px solid transparent")
    });
    $("div.goods_search_area,input.goods_search,select.goods_search_choose_bar").blur(function () {
        $("div.goods_search_area").css("outline", "none")
        $("div.goods_search_area").css("border", "2px solid rgb(214, 214, 214)")
    });

//    點擊搜尋
    $("i.goods_search_icon").click(function () {
        $("#search_bar").submit();
    });

//  按enter搜尋

//  看更多功能
  $(".see_more_button_allproduct").click(function () {
  	let productBOLList = "";
	  
//	  取得目前頁數
	 let pageNum =$(".see_more_pages").val();
	  console.log("pageNum="+pageNum)
  	$.ajax({
	    type : "GET",
	    url : "AllProductServlet",
	    data: `pageNum=${pageNum}`,  //"pageNum=2"
	    dataType : "text", //設定傳遞給Server參數的格式
	    contentType: "application/json; charset=utf-8",//設定Server傳回值格式
	    success : function(productBOLList) {
//	    	更新目前頁數
	    	pageNum = parseInt(pageNum) + 1;
	    	$(".see_more_pages").val(pageNum);

	    	console.log("json物件的元素個數是：" + productBOLList.length);
	    	console.log("productBOLList[0]是：" + productBOLList[0].ProductBO);
	    	
	    	var size = 0, key;
	    	for (key in productBOLList) {
	    	    if (productBOLList.hasOwnProperty(key)) size++;
	    	}
	    	console.log("json物件的元素個數是：" + size);
	    	
	    },
	    error: function(result){
	    	console.log("ajax: servlet傳值失敗")
	    }
	});
  	
  });
  
  $(".see_more_button_kindproduct").click(function () {
		 let pageNum =$(".see_more_pages_pageNum").val();
		 let productType = $(".see_more_pages_ProductType").val();
		  console.log("pageNum="+pageNum)
	  	$.ajax({
		    type : "GET",
		    url : "AllProductServlet",
		    data: `ProductType=${productType},pageNum=${pageNum}`,  //"pageNum=2"
		    dataType : "text", //設定傳遞給Server參數的格式
		    contentType: "application/json; charset=utf-8",//設定Server傳回值格式
		    success : function(productBOLList) {
		    	pageNum = parseInt(pageNum) + 1;
		    	$(".see_more_pages").val(pageNum);
//		    	console.log(result)
		    },
		    error: function(result){
		    	console.log("ajax: servlet傳值失敗")
		    }
		});
	  	
	  });
  
 

//  .goods_registor_botton{   value="註冊"
//      visibility:hidden/visible
//  }
//    value="登入"
  
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商店 header 結束

})