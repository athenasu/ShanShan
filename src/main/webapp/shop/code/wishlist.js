$(document).ready(function () {
	
    let product_id = $("input.data_product_id");
    let wp_product_id = $("input.wish_list");
    let member_id = $("input.member_id").val();
    
//  在JSP中，已經把該會員全部的wp porduct id全遍歷出來，放在各自個input.value裡面
//  在這裡把頁面上有的product_id都遍歷出來
    for ( let i = 0 ; i < product_id.length; i++){

//  在這裡把頁面上有的wp_product_id都遍歷出來
		for ( let a = 0 ; a < wp_product_id.length; a++){
//	如果wp_product_id == product_id 就把愛心變色
			if (wp_product_id.eq(a).val() == product_id.eq(i).val()){
				product_id.eq(i).siblings("div.goods_icon").addClass("-none");
				product_id.eq(i).siblings("div.goods_icon").parent().find("div.goods_icon_keep").removeClass("-none");
			}
    	}
    }
    
    
//	 點擊收藏商品
    $("div.goods_icon").click(function (e) {
    	if (member_id !=0 || member_id != ""){
        $(this).addClass("-none");
        $(this).parent().find("div.goods_icon_keep").removeClass("-none");
        e.stopPropagation();
        console.log("收藏商品")
    	}else{
            e.stopPropagation();
    		alert("請先登入，再收藏商品。")
    	}
    })
    
// 	點擊取消收藏商品
    $("div.goods_icon_keep").click(function (e) {
    	if (member_id !=0 || member_id != ""){
        $(this).addClass("-none");
        $(this).parent().find("div.goods_icon").removeClass("-none");
        e.stopPropagation();
        console.log("取消收藏商品");
    	}else{
            e.stopPropagation();
    		alert("請先登入，再收藏商品。")
    	}
    })
    
    
 // 添加/取消收藏商品 跑servlet
    $("div.goods_icon_keep,div.goods_icon").click(function (e) {
    	if (member_id !=0 || member_id != ""){
        let thisProductId = $(this).siblings("input.data_product_id").val();
    		$.ajax({
    			url:"/shanshan/WishProductServlet?method=addRemoveWishProduct",
    			type:"get",
    			data:{"productId":`${thisProductId}`},
    			dataType:"text",
    			success:function(result){
    			},
    			error:function(result){
    			}
    		})
    	}
    })
    

})