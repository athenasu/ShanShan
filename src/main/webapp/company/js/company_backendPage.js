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
          fetch(`/shanshan/company/logout`)
          .then((response) =>
          console.log(response)
          );
          window.location.replace("../index/index.jsp")
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

    /* -----------訂單dataTable開始---------- */
    $.ajax({
        url:"/shanshan/companyOrder/findAllOrdersByComId",
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
        "order":[[ 0, "desc" ]],
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
        ]
      })
    }
})

    
   
