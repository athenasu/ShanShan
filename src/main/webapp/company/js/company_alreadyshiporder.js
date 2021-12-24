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

    //dateformat method 
    const dateformat = function (data){
      var date = new Date (data);
      var month = date.getMonth() +1;
      var dateStr = date.getFullYear()+ "/" + (month.toString().length > 1 ? month : "0" + month) + "/" + date.getDate()  ;
      return dateStr;
    }

    /* -----------已出貨訂單dataTable開始---------- */
    $.ajax({
        url:`/shanshan/companyOrder/findAllShipped`,
        type:"GET",
        dataType:"json",
        success: function(data){
          console.log("success")
          alreadylist(data);
        },
        error: function(){
          console.log("search error");
        }
    })
    function alreadylist(data){
      var already = $('table.orders').DataTable({
        "lengthMenu":[5,10,20],
        "language":{
          "url":"https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json"
        },
        "aaData":data,
        "columns":[
          {'data':'order_id'},
          {'data':'order_member_name'},
          {'data':'order_member_phone'},
          {'data':'order_created_date',
            'render': function(data){
                        var date = new Date (data);
                        var month = date.getMonth() +1;
                        return date.getFullYear()+ "/" + (month.toString().length > 1 ? month : "0" + month) + "/" + date.getDate()  ;
                      }
          },
          {'data':'order_sum_after'},
          {'data':'order_status',
            'render': function(data){
              if(data == 2){
                return data = '已寄送'
              }else if(data == 3){
                return data = '配送中'
              }else if(data == 4){
                return data = '已收貨'
              }else{
                return data = '已結單'
              }
            }
          },
          {'data':null,
            'defaultContent':"<button>明細</button>"
          }
        ]
      })
    }
    /* -----------已出貨訂單dataTable結束---------- */

    /* -----------單一訂單詳情顯示開始---------- */
    // 先載入dialog並保持關閉
    $('div.shippedorderDetail').dialog({
      width:800,
      autoOpen:false,
    });
    $('.orders tbody').on('click','button',function(e){
      console.log("in click order detail function")
      e.preventDefault();
      let orderId = $(this).parents("tr").find("td").eq(0).text();
      console.log(orderId);
      $('div.shippedorderDetail').dialog({
        open: function(){
          fetch(`/shanshan/companyOrder/findDesByOrderId?orderId=${orderId}`)
          .then((body) => body.json())
          .then((orderDetail) =>{
            console.log(orderDetail);
            $.each(orderDetail,function(index,item){
              // console.log(item.order_id);
              document.querySelector(".orderid").value = item.order_id;
              document.querySelector(".orderdate").value = dateformat(item.order_created_date);
              document.querySelector(".clientname").value = item.order_member_name;
              document.querySelector(".clientphone").value = item.order_member_phone;
              document.querySelector(".shipaddress").value = item.order_member_address;
              document.querySelector(".shipdate").value = dateformat(item.order_shipped_date);
              document.querySelector(".sumafter").value = item.order_sum_after;
            });
              document.getElementById("shippedlisttable").style.width='100%';
              ////////////////////////////單一訂單商品明細表格/////////////////////////////
              $.ajax({
                url:`/shanshan/companyOrder/findDesByOrderId?orderId=${orderId}`,
                type:"GET",
                dataType:"json",
                success: function(data){
                  console.log("Des dataTable search success");
                  // console.log(data);
                  //step1 初始化dataTable
                  dttable = $('#shippedlisttable').dataTable();
                  //step2 清空dataTable
                  dttable.fnClearTable();
                  //step3 還原已經初始化過的dataTable
                  dttable.fnDestroy();
                  dttable = $('#shippedlisttable').dataTable({
                    //retrieve 設定為true避免dataTable不停警告重複初始化
                    "retrieve":true,
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
                      {'data':'prodes_id'},
                      {'data':'product_name'},
                      {'data':'product_quantity'},
                      {'data':'order_description_price'},
                    ]
                  }) 
                },
                error: function(){
                  console.log("Des dataTable search error ")
                }
              });
          })
        },
        modal:true,
        title:"訂單詳情",
        buttons:{
          "關閉訂單":function(){
            $(this).dialog("close");
          }
        }
      });
      //open寫在整個dialog外,dialog open之後進行資料傳輸載入 
      $('div.shippedorderDetail').dialog("open");
    });


    /* -----------訂單詳情顯示結束---------- */  
})

    
   
