$(function(){
    /* ----------側邊欄開始---------- */
    $('ul.subs').hide()
    $('div.main').click(function(){
      $('ul.subs').slideUp()
      $('div.main').removeClass('open')
      if($('+ul',this).css('display')=='none'){
        $('+ul',this).slideDown()
        $(this).addClass('open')
      }
    })
    .mouseover(function(){
      $(this).addClass('rollover')
    })
    .mouseout(function(){
      $(this).removeClass('rollover')
    })
    /* -----------側邊欄結束---------- */

    /* -----------登出鈕開始---------- */
    $('button.logout').click(function(e){
      $('div.logoutConfirmbox').dialog("open");
       e.preventDefault();
    });
    $('div.logoutConfirmbox').dialog({
      autoOpen:false,
      modal:true,
      title:"確認登出",
      buttons:{
        "是":function(){
          $(this).dialog("close");
        },
        "否":function(){
          $(this).dialog("close");
        }
      }

    });
    /* -----------登出鈕結束---------- */

    /* -----------商品dataTable開始---------- */
     $.ajax({
    	 	url:"../product/findByComId?companyId=2",
    	 	type:"GET",
    	 	dataType:"json",
    	 	success: function(data){
    	 		console.log("search success");
    	 		datalist(data);
    	 	},
     		error: function(){
     	          console.log("search error")
            }
     });
     
     function datalist(data){
    	 var allproducts = $('#productlist').dataTable({
    		 "lengthMenu":[5,10,20],
    	      // 中文化
    	     "language":{
    	        "url":"https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json",
    	      },
    		 "allData":data,
    		 "columns":[
    	         {'data':'productName'},
    	         {'data':'productPrice'},
    	         {'data':'productSize'},
    	         {'data':'productColor'},
    	         {'data':'proDesStock'},
    	       ]
    	 })
     }
      
     /* -----------商品dataTable結束---------- */
      
      })

    
   
