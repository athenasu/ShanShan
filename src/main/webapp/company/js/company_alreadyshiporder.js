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
    $('table.orders').DataTable({
      // 中文化
      "language":{
        "url":"https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json"
      }
    });
    /* -----------訂單dataTable結束---------- */

    /* -----------訂單詳情顯示開始---------- */
    $('button.shiporder1').click(function(e){
      $('div.order1detail').dialog("open");
      e.preventDefault();
    });
    $('div.order1detail').dialog({
      width:800,
      autoOpen:false,
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
      }
    });
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

    
   
