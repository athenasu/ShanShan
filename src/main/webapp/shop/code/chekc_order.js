$(document).ready(function () {

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 確認訂單 開始
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 變數與方法 開始


	let orderQTY = $(".payment_check_order_area_company").find(".payment_check_order_area_company_title").length // 算總共有多少訂單
	let cur_point  = $(".payment_check_order_area_company").find(".payment_current_point_num").eq(0).text();//	現有點數
	let can_be_used_point = cur_point ;//還可以用的點數
	let max_point_for_each_order = 50;
	let ship_fee ; //總運費
	let sum_before ; //總折扣前金額
	let sum_after ; //總折扣後金額
	let used_point ; //以使用金額

//  算 每張訂單 的 折扣後價格
	function countEveryOrderSumAfter(){
	  	for(let i = 0 ; i <orderQTY ; i++){
//	  		取得 折扣前價格
	  		let this_sum_before = Number($(".payment_check_order_area_company").find(".this_sum_before").eq(i).text());
//	  		更新 折扣後價格
	  		$(".payment_check_order_area_company").find(".this_sum_after").eq(i).text(this_sum_before);
	  	}
//    	console.log("每張訂單 的 折扣後價格 完成更新")
	  	
	}

//  算總折扣前金額
	function countSumBefore(){
//		加總 全部 訂單 折扣前價格
		sum_before = 0 ;
    	for(let i = 0 ; i <orderQTY ; i++){
    		sum_before += Number($(".payment_check_order_area_company").find(".this_sum_before").eq(i).text());
    	}
//    	全部 訂單 折扣前價格
    	$(".sum_before_num").text(sum_before)
//    	console.log("更新 總 折扣前價格: "+$(".sum_before_num").text())
	}
	
//	算總運費
	function countShippingFee(){
//		加總 全部 訂單 運費
		ship_fee= 0 ;
    	for(let i = 0 ; i <orderQTY ; i++){
    		ship_fee += Number($(".payment_check_order_area_company").find(".this_ship_fee").eq(i).text());
    	}
    	$(".shipping_fee_num").text(ship_fee)
//    	console.log("更新 總 運費: "+$(".shipping_fee_num").text())
	}
	
//	算總折扣後金額
	function countSumAfter(){
//		加總 全部 訂單 折扣後價格
		sum_after= 0 ;
    	for(let i = 0 ; i <orderQTY ; i++){
    		sum_after += Number($(".payment_check_order_area_company").find(".this_sum_after").eq(i).text());
    	}
//    	全部 訂單 折扣後價格  + 運費
    	sum_after += ship_fee
    	$(".sum_after_num").text(sum_after)
//    	console.log("更新 總 折扣後價格: "+$(".sum_after_num").text())
	}
	
//	    計算每張訂單  可以使用的最大點數
	function countEveryOrderMaxPoints(){
    	for(let i = 0 ; i <orderQTY ; i++){
//    		如果點數小於  每張訂單可用最大點數 ，調整最大使用點數
    		if (cur_point < max_point_for_each_order ){
//        		最大使用點數為現有點數
        		$(".payment_check_order_area_company").find(".payment_points_range").eq(i).attr("max" , cur_point)
//        		最大使用點數為現有點數
        		max_point_for_each_order = cur_point;
    		}
//    		如果點數等於0，不讓用
    		if (cur_point == 0 ){
        		$(".payment_check_order_area_company").find(".payment_current_point").eq(i).empty();
        		$(".payment_check_order_area_company").find(".payment_current_point").eq(i).html("您現有的山山點數為：0，無法使用山山點數獲取折扣。")
    		}
    	}
	}
	
	
//	 WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 加載網頁後  執行
    
//    算每張訂單 得折扣後金額
		countEveryOrderSumAfter();
//    算總折扣前金額
    	countSumBefore();
//    算總運費
    	countShippingFee();
//    算總折扣後金額
    	countSumAfter();
//	    計算每張訂單  可以使用的最大點數
    	countEveryOrderMaxPoints();
	
//	 WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW
//	使用點數 隨著input.range調整
    $("input.payment_points_range").change(function () {
//    	================================================================
//    	計算已經使用的點數
    	used_point=0;
    	for(let i = 0 ; i <orderQTY ; i++){
    		used_point += parseInt($(".payment_check_order_area_company").find(".payment_points_range").eq(i).val())
    	}
//    	計算還可用(剩下的)點數
    	can_be_used_point = cur_point - used_point
//    	目前點擊的元素的索引順序
    	let el_index =$(".payment_check_order_area_company").find(".payment_points_range").index(this)
//    	===情境一============================================================
//    	持有點數小於  每張訂單可用最大點數 ，調整最大使用點數=持有點數
//		已在countEveryOrderMaxPoints()方法處理
//    	===情境二============================================================
//    	剩下的點數 小於  每張訂單可用最大點數 時，調整全部input.range的最大可用點數
    	if (can_be_used_point < max_point_for_each_order){
    	    for(let i = 0 ; i <orderQTY ; i++){
    	    	if(i != el_index){
            		$(".payment_check_order_area_company").find(".payment_points_range").eq(i).attr("max" , can_be_used_point)
    	    	}
    		}
    	}
//    	===情境三============================================================
    	if (can_be_used_point > max_point_for_each_order){
    		 for(let i = 0 ; i <orderQTY ; i++){
         		$(".payment_check_order_area_company").find(".payment_points_range").eq(i).attr("max" , max_point_for_each_order)
     		}
    	}
//    	================================================================
        let points = $(this).val()
//      在使用點數  輸入input.range的值
        $(this).siblings("span.payment_usepoints_num").text(points)
        
//      獲得 本訂單 折扣前價格
        let this_sum_before =  $(this).parents(".payment_check_order_detail_area").children().find(".this_sum_before").text();
//		更新 折扣後價格
        
//    	console.log("本訂單 使用了: "+points +"點 山山點數。")
//    	console.log("本訂單 獲得了: "+ (100 - points)/10 +"% 的折扣。")
        
    	let this_sum_after_1000times = (this_sum_before*1000) - (this_sum_before*points);
    	let this_sum_after = parseInt(this_sum_after_1000times/1000)
    	$(this).parents(".payment_check_order_detail_area").children().find(".this_sum_after").text(this_sum_after)
    	
//    	console.log("本訂單 折扣後價格為 " + this_sum_after +"元")
//      更新 總 折扣後價格
        countSumAfter();
    	
    })
    
//    提交訂單
        $("li.payment_confirm_pay").click(function () {
        	console.log("點了提交按鈕了")
//        	拿到各張訂單的使用點數/折扣後價格，更新進去另外準備的input     point_used  /order_sum_after
    	    for(let i = 0 ; i < orderQTY ; i++){
    	    	let this_use_pionts = $(".payment_check_order_area_company").find("span.payment_usepoints_num").eq(i).text();
    	    	let this_use_after = $(".payment_check_order_area_company").find("li.this_sum_after").eq(i).text();
    	    	$(".payment_check_order_area_company").find("input.payment_usedPoints").eq(i).val(this_use_pionts);
    	    	$(".payment_check_order_area_company").find("input.payment_sumAfter").eq(i).val(this_use_after);
    	    }
        	
//        	放接好的住址 到 input
        	let address = "";
        	for(let i = 0 ; i < 8 ; i++){
        		address += $(".payment_fill_address").eq(i).val();
        	}
        	$(".payment_address").val(address)
        	        	
        	$("#PaymentResultServlet").submit();
        })
    
    
    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 確認訂單頁面 結束

})