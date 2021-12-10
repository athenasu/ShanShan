$(document).ready(function () {
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
	
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 購物車 開始

    let all_checked = $("input.selectallcart");
    let single_checked = $("input[name='choose']");


    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 提交表格區
//  提交購物車form，移除購物車項目
    function submitRemoveCartItem(){
    	console.log("提交form,RemoveCartItem")
    	
    	$("#removeCartItem").ajaxSubmit(function(message) {
	    	console.log("提交form,RemoveCartItem OK!!")
    	});
    	return false
    }
    
//  提交購物車form，清空購物車
    function submitCleanCartItem(){
    	/* $("#cleanCartItem").submit(); */
    	console.log("提交form,cleanCartItem()")
    	$("#cleanCartItem").ajaxSubmit(function(message) {
	    	console.log("提交form,cleanCartItem OK!!")
    	});
    	
    	return false
    }    
    
//  提交購物車form，改數量
    function submitChangeItemQTY(){
    	$("#changeItemQTY").submit();
    	console.log("提交form,changeItemQTY")
    	
    	$("#changeItemQTY").ajaxSubmit(function(message) {
	    	console.log("提交form,changeItemQTY OK!!")
    	});
    }
    
//    總價格更新方法
    function updateTotalPrice(){
        // 改變/移除購物車項目時，總價格變動
        // 得到購物車項目個數
        let item_qty = $(".cart_product_content").length;
        let sum_price = 0;
        // 遍歷所有小計，獲得總價格
        for (let i = 0; i < item_qty; i++) {
            sum_price += parseInt($("span.cart_item_price").eq(i).text());
        }
        // 更新總價格
        $(".cart_total_price").text(sum_price);
    	
    }
    
    // 點擊 全選
    all_checked.click(function () {
        // 如果全選未勾選(true)
        if (all_checked.prop("checked")) {
            // 選擇全部商品
            single_checked.prop("checked", true)
        }
        // 如果全選已勾選(false)
        else {
            // 全部取消
            single_checked.prop("checked", false)
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

    
    // 點擊 清空購物車，移除購物車全部商品 
    $("ul.cart_end_area li:nth-child(2)").click(function () {

        let check = confirm("是否要移除購物車全部商品？");
        if (check) {
            // 提交form，執行servlet
        	$("#cleanCartItem").submit();
            $("ul.cart_product_content_area").empty();
            // 移除購物車全部商品時，購物車總價格也要變動
            $("span.cart_total_price").text("0")
        	// 改變購物車icon的數字
            showCartItemQty();
        }
        
    })

    // 點擊 移除，移除該項商品 
    $("li.cart_product_content10 span").click(function () {
        // 提交form，執行servlet
    	$("#removeCartItem").submit();
    	
        $(this).closest("ul").remove()
        
        // 移除購物車全部商品時，購物車總價格也要變動
        updateTotalPrice();
    	// 改變購物車icon的數字
        showCartItemQty();
    })


    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 調整數量
    // 點擊add，購買數增加1  (未完成)
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
        // 更新input的值，提交form，執行servlet
        $("#changeItemQTY_itemQTY").attr("value", qty_culumn.text())
    	$("#changeItemQTY").submit();

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

            // 更新input的值，提交form，執行servlet
            $("#changeItemQTY_itemQTY").attr("value", qty_culumn.text())
        	$("#changeItemQTY").submit();
            
        }
        else if (qty_culumn = 1) {
            let check = confirm("目前商品數為1，是否要移除本商品？");
            if (check) {
                $(this).closest("ul").remove()

                // 提交form，執行servlet
            	$("#removeCartItem").submit();
            	// 改變購物車icon的數字
                showCartItemQty();
            }
        }
        // 改變總價
        updateTotalPrice();

    })

})