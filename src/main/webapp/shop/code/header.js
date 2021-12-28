$(document).ready(function () {

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 變數與方法
	  var member_id = 0;
// 登入 登出 按鈕 切換顯示
	  function login_logout (){
// 取得登入狀態
		  member_id = $("input.member_id").val();
		  if (member_id > 0 ){
// 登入：隱藏註冊按鈕
			$("input.goods_registor_botton").css( "visibility" , "hidden");
		  	$("input.goods_login_modal_botton").attr("value" , "登出");
		  }

		  if (member_id == "" ){
//			console.log("現在是未登入狀態喔!")
		  }
	  }
	  
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 加載後執行
	  
	  login_logout();
		
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 登入 開始
// // 點擊登入按鈕，開啟選擇登入方式的燈箱
// $("input.login_modal_botton").click(function () {
// $("div.login_modal_bcg").removeClass("-none")
// // $("div.login_modal").removeClass("-none") // 第三方登入功能 的程式碼
// $("div.login_modal_email").removeClass("-none") // 限EMAIL登入 程式碼
// })


    // 點擊半透明黑色背景，取消登入的燈箱
    $("div.login_modal_bcg").click(function () {
        $("div.login_modal_bcg").addClass("-none")
        $("div.login_modal").addClass("-none")
        $("div.login_modal_email").addClass("-none")
    })


    // 點擊用EMAIL登入，到EMAIL登入 // 第三方登入功能 的程式碼
// $("input.emaillogin").click(function () {
// $("div.login_modal").addClass("-none")
// $("div.login_modal_email").removeClass("-none")
// })

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
        // 超連結至首頁
    })
    $("div.registor_title_shanshan").click(function () {
        // 超連結至首頁
    })

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 註冊 結束
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商店 header 開始

// 登入/登出 
    $("input.goods_login_modal_botton").click(function () {
// 如果是未登入狀態
    	if (member_id == 0){
//          開啟登入燈箱 /黑幕
            $("div.login_modal_bcg").removeClass("-none")
// 			$("div.login_modal").removeClass("-none") // 第三方登入功能 的程式碼
            $("div.login_modal_email").removeClass("-none")  	// 限EMAIL登入 程式碼
    	}
        
//      如果是登入狀態
        if(member_id > 0){
        	if(confirm("您確定要登出嗎?")){
//   			    執行登出controller
        		  fetch("/shanshan/memberLogin/logout", {
        			  method: "POST",
        		  })
        		  .then(function (response) {
//        		           重新定向
        			  if($(".paymentPage") != null){
        				  location.assign("goods_index.jsp");
//        				  window.location.assign("goods_index.jsp");
//        				  document.location.href="goods_index.jsp";
        			  }else{
        			  location.reload();
        			  }
        		  })
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

    
//  點擊 提交登入按鈕   進行登入動作/伺服器驗證    
    $("input.login_summitbutton").click(function () {

//  	取得輸入的EMAIL
      let memberEmail = $(".login_formbar_email").val();
		console.log(memberEmail)
//  	取得輸入的密碼
      let memberPassword = $(".login_formbar_password").val();
		console.log(memberPassword)
		
//	   調用伺服器驗證 
	  fetch("/shanshan/memberLogin/login", {
		  method: "POST",
//		  設定請求頭
		  headers: {"Content-Type": "application/json"},
//		  設定請求體(傳給伺服器的參數)
		  body: JSON.stringify({
			  memberEmail,
			  memberPassword,
		  }),
	  })
	  .then(function (response) {
		  console.log("伺服器回傳訊息："+response);
		  return response.json();
	  })
	  .then((body) => {
		  if (body.successful) {
			  console.log("登入成功");
			  location.reload();
		  } else {
			  console.log("登入失敗");
		  }
	  });
//	   調用伺服器驗證 
//    	$.ajax({
//  	    type : "POST",
//  	    url : "/shanshan/memberLogin/login",
//  	    data: `memberEmail="${memberEmail}"&memberPassword=${memberPassword}`,  
//  	    dataType : "text", // 設定傳遞給Server參數的格式
//  	    contentType: "application/json",// 設定Server傳回值格式
//  	    success : function(result) {
//			  location.reload();
//  	    },
//  	    error: function(result){
//    		  console.log("登入失敗："+result);
//  	    }
//  	});
      
    });
    
    // focus 搜尋功能 div,input,select ,產生效果
    $("div.goods_search_area,input.goods_search,select.goods_search_choose_bar").focus(function () {
        $("div.goods_search_area").css("outline", "2px solid rgb(187, 177, 147)")
        $("div.goods_search_area").css("border", "2px solid transparent")
    });
    $("div.goods_search_area,input.goods_search,select.goods_search_choose_bar").blur(function () {
        $("div.goods_search_area").css("outline", "none")
        $("div.goods_search_area").css("border", "2px solid rgb(214, 214, 214)")
    });

// 點擊搜尋
    $("i.goods_search_icon").click(function () {
    	if($(".goods_search").val() != ""){
    		$("#search_bar").submit();
    	}else{
    		return false
    	}
    });

// 按enter搜尋 阻止空白表單送出
    $("#search_bar").keypress(function (e) {
    	let key = e.keyCode;
    	if (key == 13 && $(".goods_search").val() == ""){
    		return false
    	}
    });
    
// 看更多功能
  $(".see_more_button_allproduct").click(function () {
// 取得目前頁數
	 let pageNum =$(".see_more_pages").val();
	 
  	$.ajax({
	    type : "GET",
	    url : "AllProductServlet",
	    data: `pageNum=${pageNum}`,  // "pageNum=2"
	    dataType : "text", // 設定傳遞給Server參數的格式
	    contentType: "json",// 設定Server傳回值格式
	    success : function(result) {
	    	if(result == "" ){
	    		$(".see_more").empty();
	    		$(".see_more").append("<div>以上為全部商品</div>")
	    	}else{
// 把資料轉成JSON格式
	    	let productBOLList = JSON.parse(result);
	    	let ObjectQTY =productBOLList.length;
	    	
	    	let seemore ="";
	    	for (let i = 0 ; i < productBOLList.length; i++){
	    		seemore +=  `
		    		<li class="single_good_area" onclick="location.href='/shanshan/GetProductServlet?productId=${productBOLList[i].productId}'">
	                <img class="good_headpic" src="/shanshan/ProductPicServlet?productId=${productBOLList[i].productId}&productSequence=0&action=firstPic" width="250px" alt="goods">
	                <div class="goods_icon"><i class="far fa-heart toWishList "></i></div>
	                <div class="goods_icon_keep -none"><i class="fas fa-heart offWishList "></i></div>
	                <span class="good_headsupplier">${productBOLList[i].companyName}</span>	
	                <a class="good_headname"><h5>${productBOLList[i].productName}</h5></a>
	                <span class="good_headprice">售價${productBOLList[i].productPrice}</span>
	                <input type="hidden" class="data_product_id" value="${productBOLList[i].productId}">
		    		`;
	    	}
// 新增項目到頁面
	    	$(".goods_area").last().append(seemore);
	    	
// 更新目前頁數
	    	pageNum = parseInt(pageNum) + 1;
	    	$(".see_more_pages").val(pageNum);
	      }
	    },
	    error: function(result){
	    	console.log("ajax: servlet傳值失敗")
	    }
	});
  	
  });
  
  $(".see_more_button_kindproduct").click(function () {
// 取得參數
		 let pageNum =$(".see_more_pages_pageNum").val();
		 let productType = $(".see_more_pages_ProductType").val();
		 
	  	$.ajax({
		    type : "GET",
		    url : "GetProductTypeServlet",
		    data: `ProductType=${productType}&pageNum=${pageNum}`,  // "pageNum=2"
		    dataType : "text", // 設定傳遞給Server參數的格式
		    contentType: "application/json; charset=utf-8",// 設定Server傳回值格式
		    success : function(result) {
// 把資料轉成JSON格式
		    	if(result == "" ){
		    		$(".see_more").empty();
		    		$(".see_more").append("<div>以上為全部商品</div>")
		    	}else{
		    	let productBOLList = JSON.parse(result);
		    	let ObjectQTY =productBOLList.length;
		    	
		    	let seemore ="";
		    	for (let i = 0 ; i < productBOLList.length; i++){
		    		seemore +=  `
			    		<li class="single_good_area" onclick="location.href='/shanshan/GetProductServlet?productId=${productBOLList[i].productId}'">
		                <img class="good_headpic" src="/shanshan/ProductPicServlet?productId=${productBOLList[i].productId}&productSequence=0&action=firstPic" width="250px" alt="goods">
		                <div class="goods_icon"><i class="far fa-heart toWishList "></i></div>
		                <div class="goods_icon_keep -none"><i class="fas fa-heart offWishList "></i></div>
		                <span class="good_headsupplier">${productBOLList[i].companyName}</span>	
		                <a class="good_headname"><h5>${productBOLList[i].productName}</h5></a>
		                <span class="good_headprice">售價${productBOLList[i].productPrice}</span>
		                <input type="hidden" class="data_product_id" value="${productBOLList[i].productId}">
			    		`;
		    	}
		    	
// 新增項目到頁面
			    $(".goods_area").last().append(seemore);
// 更新目前頁數
		    	pageNum = parseInt(pageNum) + 1;
		    	$(".see_more_pages_pageNum").val(pageNum);
		    	}
		    },
		    error: function(result){
		    	console.log("ajax: servlet傳值失敗")
		    }
		});
	  	
	  });
  
 

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商店 header 結束

  // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 登入註冊

// 註冊 EMAIL 輸入驗證
  const validateEmail = function (emailAdress) {
	  let regexEmail = /\S+@\S+\.\S+/;
	  if (emailAdress.match(regexEmail)) {
		  return true;
	  } else {
		  return false;
	  }
  };

  // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 登入 密碼
// 忘記密碼 提交 調用伺服器
  const forgotPasswordSubmitBtn = $(".forgot_password_summitbutton");
  forgotPasswordSubmitBtn.click(function (){
	  let memberEmail = $(".forgot_password_email").val();
	  fetch(`/shanshan/memberLogin/forgotPasswordCheckEmail`, {
		  method: "POST",
		  headers: {
			  "Content-Type": "application/json",
		  },
		  body: JSON.stringify({
			  memberEmail,
		  }),
	  })
	  .then(function (response) {
		  return response.json();
	  })
	  .then((body) => {
		  if (body.successful) {
			  $("div.login_modal_bcg").addClass("-none");
			  $("div.login_modal").addClass("-none");
			  $("div.login_modal_email").addClass("-none");
			  $("div.forgot_password_modal").addClass("-none");
			  alert("已發送密碼驗證信");
		  }
	  });
  });

  
// 點擊 忘記密碼
  $("p.forgot_password").click(function (e) {
    e.preventDefault();
    $("div.login_modal_email").addClass("-none");
    $("div.forgot_password_modal").removeClass("-none");
  });

})