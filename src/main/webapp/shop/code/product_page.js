$(document).ready(
		function() {
			
			// 改變購物車icon的數字
		    function showCartItemQty(){
//		    	console.log("header.js/showCartItemQty()執行了");
		    	$.ajax({
		    		url:"/shanshan/CartServlet?method=showCartItemQty",
		    		type:"get",
//		    		data:{"method":"showCartItemQty"},
		    		data:{},
		    		dataType:"text",
		    		success:function(result){
//		    	    	console.log("成功了");
		    	    	$(".shopcarticon_num").text(result)
		    		},
		    		error:function(result){
//		    	    	console.log("失敗了");
		    		}
		    	})
		    }
		    
		    
			// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 提交表格區
			function subAddCartItem() {
		    	console.log("提交form,addCartItem")
		    	
		    	$("#product_format_detail").ajaxSubmit(function(message) {
			    	console.log("提交form,addCartItem OK!!")
		    	});
		    	return false
			}

			// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商品圖片 首圖
			// 開始

			// 設定第一張展示圖 為大圖 的方法
			function set_firstpic_as_mainpic() {
				let img = $("li.product_slideshow_pics:first-child").html()
				$("div.product_slideshow_main").children("img")
						.replaceWith(img);
			}
			// 載入方法
			set_firstpic_as_mainpic();

			// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商品圖片 輪播圖

			// hover的圖片 成為大圖 / 變成紅框 /其他的圖片解除紅框
			$("li.product_slideshow_pics").hover(
					function() {
						$("li.product_slideshow_pics").removeClass(
								"pics_select");
						$(this).addClass("pics_select")

						let img = $(this).html()
						$("div.product_slideshow_main").children("img")
								.replaceWith(img);
					})

			// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 商品圖片 輪播圖

			// 移動展示圖
			var slide_area = $(".product_slideshow_pages_ul");
			let slide_img = $(".product_slideshow_pics");

			// 設定slider data 作為 top屬性 參照
			slide_area.attr("data-counter", 0);

			// 點擊 up按鈕, 往下移動展示圖ul
			$("i.product_slideshow_contrl_icon_up")
					.click(
							function() {
								// 取得目前的data(top屬性數字)再加90，做為要設定的top數據
								let movedown = parseInt(slide_area
										.attr("data-counter")) + 90;
								// 改變top屬性
								if (movedown < 0) {
									$(".product_slideshow_pages_ul").css("top",
											movedown + "px")
									// 同時改變data做為下一次的動作的依據
									slide_area.attr("data-counter", movedown);
								}

							})

			// 點擊 down按鈕, 往上移動展示圖ul
			$("i.product_slideshow_contrl_icon_down").click(function() {
				// 取得目前的data(top屬性數字)再減90，做為要設定的top數據
				let moveup = parseInt(slide_area.attr("data-counter")) - 90;
				// (圖片個數-5) * -90px =最小top屬性
				let mintop = (slide_img.length - 5) * -90;
				// 改變top屬性
				if (mintop <= moveup) {
					$(".product_slideshow_pages_ul").css("top", moveup + "px")
					// 同時改變data做為下一次的動作的依據
					slide_area.attr("data-counter", moveup);
				}
			})

			// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 調整數量

			var product_QTY = $(".product_adust_item_qty");

			// 點擊add，購買數增加1
			$("i.fa-plus").click(
					function() {
						let add_qty = parseInt(product_QTY.text()) + 1;
						product_QTY.text(add_qty);
						$(".product_adust_item_qty_value").attr("value",
								product_QTY.text());
					})

			// 點擊reduce，購買數減少1
			$("i.fa-minus").click(
					function() {
						let reduce_qty = parseInt(product_QTY.text()) - 1;

						if (product_QTY.text() > 1) {
							product_QTY.text(reduce_qty);
							$(".product_adust_item_qty_value").attr("value",
									product_QTY.text());
						}
					})

			// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 加入購物車

			// 點擊按鈕 加入購物車 提交FORM表單
			$(".product_format_detail_button_2").click(function() {
				$("#product_format_detail").submit();
				showCartItemQty();
			})

			// WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 直接購買
				
//			$(".product_format_detail_button_1").click(function() {
//				$("#buy_directly").submit(function(e){
//	    	    	console.log("提交了");
//				});
//			})

			$(".product_format_detail_button_1").click(function() {
//				更改form的資料
				$("#product_format_detail").attr("action", "/shanshan/PurchaseServlet");
				$("#product_format_detail").attr("onsubmit", "");
//				更改input的資料
				$(".submit_method").attr("value", "buyDirectly");

//				提交
				$("#product_format_detail").submit();
			})
			
			

//            <form method="get" id="buy_directly" action="<%=contextPath%>/PurchaseServlet">
		})