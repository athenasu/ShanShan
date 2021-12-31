$(document).ready(function () {
	
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 購物車 開始
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 變數/方法

    let all_checked = $("input.selectallcart");
    let single_checked = $("input[name='choose']");
	// 改變購物車icon的數字
    function showCartItemQty(){
//    	console.log("header.js/showCartItemQty()執行了");
    	$.ajax({
    		url:"/shanshan/CartServlet?method=showCartItemQty",
    		type:"get",
//    		data:{"method":"showCartItemQty"},
    		data:{},
    		dataType:"text",
    		success:function(result){
//    	    	console.log("成功了");
    	    	$(".shopcarticon_num").text(result)
    		},
    		error:function(result){
//    	    	console.log("失敗了");
    		}
    	})
    }
    

//    尺寸解碼
    function decodeSize (){
//  	取得尺寸欄位
    	let productSize = $(".cart_product_content").find("span.product_page_productSize")
    	for (let i = 0 ; i < productSize.length; i++) {
    		switch (productSize.eq(i).text()) {
    		case "0":
    			productSize.eq(i).text("F")
    			break;
    		case "1":
    			productSize.eq(i).text("S")
    			break;
    		case "2":
    			productSize.eq(i).text("M")
    			break;
    		case "3":
    			productSize.eq(i).text("L")
    			break;
    		case "4":
    			productSize.eq(i).text("XL")
    			break;
    		}
    	}
    }

	decodeSize ();
    
//  提交購物車form，清空購物車
    function submitCleanCartItem(){
    	$("#cleanCartItem").ajaxSubmit(function(message) {
//    		移除所有checkbox
    		$("input[name='choose']").prop("checked", false)	 //更新實際頁面打勾狀況
            $("input[name='choose']").removeAttr("checked")  	 //更新checked的值
            $("input.selectallcart").prop("checked", false)
    	});
    	
    	return false
    }    
    
    function updateTotalPrice(){
        // 改變/移除購物車項目時，總價格變動
        // 得到購物車項目個數
        let item_qty = $(".cart_product_content").length;
        let sum_price = 0;
        // 遍歷所有小計，獲得總價格
        for (let i = 0; i < item_qty; i++) {
            sum_price += parseInt($("span.cart_item_price").eq(i).text());
        }
        // 更新總價格欄位
        $(".cart_total_price").text(sum_price);
    	
    }

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW checkbox優化打勾
//  如果checkbox打勾，就添加checked屬性，如果取消打勾，就移除checked屬性(變成undefined)
    $(".chooseItem").click(function () {
    	if($(this).attr("checked") == undefined){
        	$(this).attr("checked","checked")
    	}else{
        	$(this).removeAttr("checked")
    	}
    })
    // 點擊 全選
    all_checked.click(function () {
        // 如果全選未勾選(true)
        if (all_checked.prop("checked")) {
            // 選擇全部商品
            single_checked.prop("checked", true) 	 //更新實際頁面打勾狀況
            single_checked.attr("checked","checked") //更新checked的值
        }
        // 如果全選已勾選(false)
        else {
            // 全部取消
            single_checked.prop("checked", false)	 //更新實際頁面打勾狀況
            single_checked.removeAttr("checked")  	 //更新checked的值
        }
    })

    // 點擊 如果只差一個就全選，點了最後一個項目，"全選"要顯示勾選
    single_checked.click(function () {
        // 得到購物車項目個數
        let item_qty = $(".cart_product_content").length;
        let check_sum = 0;
        let check_count = 0;

        // 迴圈，結束後check_sum == 購物車項目個數，check_count == 有勾選的個數
        for (let i = 0; i < item_qty; i++) {
            check_sum += 1;
            if (single_checked.eq(i).prop("checked")) {
                check_count += 1;
            }
        }
        // 如果購物車項目個數==有勾選的個數，全選打勾；反之，取消勾
        if (check_sum == check_count) {
            all_checked.prop("checked", true)
        } else {
            all_checked.prop("checked", false)
        }
    })

    
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 刪除購物車項目
    // 點擊 清空購物車，移除購物車全部商品 
    $("ul.cart_end_area li:nth-child(2)").click(function () {

        let check = confirm("是否要移除購物車全部商品？");
        if (check) {
            $("ul.cart_product_content_area").empty();
            // 移除購物車全部商品時，購物車總價格也要變動
            $("span.cart_total_price").text("0")
        	// 改變購物車icon的數字
            showCartItemQty();

            // 提交form，執行servlet
        	$("form.formCleanCart").ajaxSubmit(function(message) {
//        		移除所有checkbox
        		$("input[name='choose']").prop("checked", false)	 //更新實際頁面打勾狀況
                $("input[name='choose']").removeAttr("checked")  	 //更新checked的值
                $("input.selectallcart").prop("checked", false)
        	});
            return false
        }
        
    })

    // 點擊 移除，移除該項商品 
    $("li.cart_product_content10 span").click(function () {
        // 提交form，執行servlet
        $(this).parents(".cart_product_content").find(".formRemoveCartItem").ajaxSubmit(function(message) {
//    		移除所有checkbox 打勾
    		$("input[name='choose']").prop("checked", false)	 //更新實際頁面打勾狀況
            $("input[name='choose']").removeAttr("checked")  	 //更新checked的值
            $("input.selectallcart").prop("checked", false)
    	});
        
//    	移除項目
        $(this).closest("ul").remove()
        
        // 移除購物車全部商品時，購物車總價格也要變動
        updateTotalPrice();
    	// 改變購物車icon的數字
        showCartItemQty();
        return false
    })


    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 調整數量
    // 點擊add，購買數增加1  
    $("i.fa-plus").click(function () {
        let qty_culumn = $(this).siblings("span")
        let add_qty = parseInt(qty_culumn.text()) + 1;
        $(this).siblings("span").text(add_qty)

        // 本項單價
        let item_price = parseInt($(this).closest(".cart_product_content8").siblings(".cart_product_content7").children("span").text());
        // 改變數量時，單項小計變動  單價*數量
        $(this).closest(".cart_product_content8").siblings(".cart_product_content9").children("span").text(qty_culumn.text() * item_price);
        // 改變總價
        updateTotalPrice();
        // 更新input的值
        $(this).parents(".cart_product_content").find("input.changeItemQTY_itemQTY").attr("value", qty_culumn.text())
        // 提交form，執行servlet
        $(this).parents(".cart_product_content").find(".formChangeItemQTY").ajaxSubmit(function(message) {
    	});

        return false
    })

    // 點擊reduce，購買數減少1  
    $("i.fa-minus").click(function () {
        let qty_culumn = $(this).siblings("span")
        let reduce_qty = parseInt(qty_culumn.text()) - 1;
        if (qty_culumn.text() > 1) {
            $(this).siblings("span").text(reduce_qty)
            // 本項單價
            let item_price = parseInt($(this).closest(".cart_product_content8").siblings(".cart_product_content7").children("span").text());
            // 改變數量時，單項小計變動  單價*數量
            $(this).closest(".cart_product_content8").siblings(".cart_product_content9").children("span").text(qty_culumn.text() * item_price);

            // 更新input的值
            $(this).parents(".cart_product_content").find("input.changeItemQTY_itemQTY").attr("value", qty_culumn.text())
            // 提交form，執行servlet
            $(this).parents(".cart_product_content").find(".formChangeItemQTY").ajaxSubmit(function(message) {
        	});

            // 改變總價
            updateTotalPrice();
            return false
        }
        else if (qty_culumn = 1) {
            let check = confirm("目前商品數為1，是否要移除本商品？");
            if (check) {
                // 提交form，執行servlet
                $(this).parents(".cart_product_content").find(".formRemoveCartItem").ajaxSubmit(function(message) {
//  	  		移除所有checkbox 打勾
                	$("input[name='choose']").prop("checked", false)	 //更新實際頁面打勾狀況
                	$("input[name='choose']").removeAttr("checked")  	 //更新checked的值
                	$("input.selectallcart").prop("checked", false)
                });
                
                $(this).closest("ul").remove()

            	// 改變購物車icon的數字
                showCartItemQty();
                // 改變總價
                updateTotalPrice();
                return false
                
            }
        }
       

    })
    
    
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 結帳
        // 點擊 提交表單 前往結帳頁面
    $("#go_to_pay").click(function () {
    	let cart = $(".cart_product_content_area");
    	let haschoose = 0;
    	let member_id = $("input.member_id").val();
//  	判斷是否有選擇商品
    	for (let c = 0 ; c < cart.children().length ; c++){
    		if ( cart.find(".cart_product_content").eq(c).find(".chooseItem").attr("checked") == "checked"){
    			haschoose = 1;
    		}
    	}
    	if(haschoose == 0){
    		alert("請選擇商品。")
    	}
//  	判斷是否登入
    	else if (member_id > 0){
//  		找到商品區域，所有有打勾的項目
//  		遍歷所有cart item
    		for (let c = 0 ; c < cart.children().length ; c++){
//  			如果cart item的checkbox有打勾，寫入所有資料到input。  name為資料順序(int)，value為商品資訊JSON
//  			url參數範例：/PurchaseServlet?method=buyDirectly&1prodesId=23&1itemQTY=1&2prodesId=43&2itemQTY=2
    			if (cart.find(".cart_product_content").eq(c).find(".chooseItem").attr("checked")){
    				let prodesId = cart.find(".cart_product_content").eq(c).find("input.changeItemQTY_productDesId").val();
    				cart.find(".cart_product_content").eq(c).find("input.buyCart_cartItem_prodesId").attr("value", prodesId);
    			}
    		}

//  		清除其他不提交的form/input表單，提交時避免出錯
    		$("#cleanCartItemInput").remove();
    		$(".formCleanCart").remove();
    		$(".formRemoveCartItem").remove();
    		$(".formChangeItemQTY").remove();
    		$("input.cartItem_companyId").remove();

    		// 提交form，執行servlet
    		$("#PurchaseProduct").submit();
    	}else {
    		alert("member_id="+member_id+"請先登入，再購買商品。")
    	}
    })
    
    
    
})