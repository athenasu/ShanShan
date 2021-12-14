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

    /* -----------訂單dataTable開始---------- */
    $.ajax({
	      url:"../companyOrder/findByOrderStatus?orderStatus=4&companyId=1",
	      type:"GET",
	      dataType:"json",
	      success: function(data){
	        console.log("search success");
	        orderdata(data);
	      },
	      error: function(){
	        console.log("search error");
	      }
    });
    function orderdata(data){
      var orderlist = $('#orderlist').dataTable({
        "lengthMenu":[5,10,20],
        "language":{
          "url":"https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json"
        },
        "aaData":data,
        "columns":[
          {'data':'order_id'},
          {'data':'member_id'},
          {'data':'order_member_phone'},
          {'data':'order_created_date',
           'render': function(data){
                    var date = new Date (data);
                    var month = date.getMonth() +1;
                    return date.getFullYear()+ "/" + (month.toString().length > 1 ? month : "0" + month) + "/" + date.getDate()  ;
                    }
          },
          {'data':'order_sum_before'},
          {'data':'order_sum_after'},
          {'data':null,
           'defaultContent':"<button>明細</button>"
          }
        ]
      }) 
    }
    /* -----------訂單dataTable結束---------- */
    /* -----------訂單詳情顯示開始---------- */
    $('#orderlist tbody').on('click','button',function(e){
        console.log("in click function")
        $('div.orderdetail').dialog("open");
        e.preventDefault();
    });
    
    $('div.orderdetail').dialog({
      width:800,
      autoOpen:false,
      open: function(){
        fetch("../companyOrder/findDesByOrderId?orderId=40")
        .then((body) => body.json())
        .then((OrderDescriptionBO) => {
          console.log(OrderDescriptionBO);
          $.each(OrderDescriptionBO,function(index,item){
            // console.log(item.order_id);
            document.querySelector(".orderid").value = item.order_id;
            document.querySelector(".orderdate").value = item.order_created_date;
            document.querySelector(".clientname").value = item.order_member_name;
            document.querySelector(".clientphone").value = item.order_member_phone;
            document.querySelector(".shipaddress").value = item.order_member_address;
            document.querySelector(".sumafter").value = item.order_sum_after;
           });


          //  function dateformat (){
          //    console.log("in format ");
          //   var orderD = document.querySelector(".orderdate").value;
          //   var date = new Date (orderD);
          //   var month = date.getMonth() +1;
          //   return date.getFullYear()+ "/" + (month.toString().length > 1 ? month : "0" + month) + "/" + date.getDate()  ;
          //   }
           
           
        })
      },
      modal:true,
      title:"訂單詳情",
      buttons:{
        "確認出貨":function(){
          $(this).dialog("close");
          $('div.confirmship').dialog("open");
        },
        "訂單取消":function(){
          $(this).dialog("close");
          $('div.cancleorder').dialog("open");
        }
      },
      
    });
    $.ajax({
      url:"../companyOrder/findDesByOrderId?orderId=7",
      type:"GET",
      dataType:"json",
      success: function(data){
        console.log("des success");
        orderDesData(data);
      },
      error: function(){
        console.log("search error");
      }
    });
    function orderDesData(data){
      var orderdeslist = $('#orderdes').dataTable({
        "searching": false,
        "ordering":false,
        "autoWidth":true,
        "paging":false,
        "lengthMenu":[5,10,20],
        "language":{
          "url":"https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json"
        },
        "aaData":data,
        "columns":[
          {'data':'product_name'},
          {'data':'product_quantity'},
          {'data':'order_description_price'},
        ]
      }) 
    }

  
    
    
    /* -----------訂單詳情顯示結束---------- */
  
    /* -----------訂單確認出貨開始---------- */
    $('div.confirmship').dialog({
      width:800,
      autoOpen:false,
      modal:true,
      title:"確認出貨",
      buttons:{
        "確認出貨":function(){
          if($('#shipnumber') == null){
            $('div.confirmship').dialog("close");
          }else{
            alert('貨運單號不可空白!')
          }
        }
      }
    });
    /* -----------訂單確認出貨結束---------- */
   
    /* -----------訂單取消開始---------- */
    $('div.cancleorder').dialog({
      width:800,
      autoOpen:false,
      modal:true,
      title:"取消訂單確認",
      buttons:{
        "取消訂單":function(){
          $(this).dialog("close");
        }
      }
    })
    /* -----------訂單取消結束---------- */

    
      
      
      
      
})

    
   
