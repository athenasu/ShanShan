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
    /* -----------商品dataTable開始---------- */
    $.ajax({
        url:"../product/findByComId?companyId=1",
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
      var already = $('#allProduct').DataTable({
        "lengthMenu":[5,10,20],
        "language":{
          "url":"https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json"
        },
        "aaData":data,
        "columns":[
          {'data':'prodesId'},
          {'data':'productName'},
          {'data':'productType',
            'render': function(data){
              if(data == 1){
                return data = '衣著'
              }else if(data ==2){
                return data = '工具照明'
              }else if(data == 3){
                return data = '炊具'
              }else{
                return data = '帳篷寢具'
              }
            }
          },
          {'data':'productPrice'},
          {'data':'productSize',
            'render': function(data){
              if(data == 0){
                return data = 'F'
              }else if(data == 1){
                return data = 'S'
              }else if(data == 2){
                return data = 'M'
              }else if(data == 3){
                return data = 'L'
              }else{
                return data = 'XL'
              }
            }
          },
          {'data':'productColor'},
          {'data':'proDesStock',},
          {'data':null,
            'render':function(data,type,row){
              return '<button type="button" class="update">修改</button>'
            }
          },
          {'data':null,
            'render':function(data,type,row){
            return '<button type="button" class="onShelf">上架</button>'
            }
          },
          {'data':null,
            'render':function(data,type,row){
            return '<button type="button" class="downShelf">下架</button>'
            }
          }
        ]
      })
    }
    /* -----------商品dataTable結束---------- */

    /* -----------商品上架開始---------- */
    $('.productlist tbody').on('click','.onShelf',function(e){
      console.log("in click order onShelf function")
      $('div.onShelfConfirm').dialog("open");
      e.preventDefault();
    });
    $('.productlist tbody').on('click','.downShelf',function(e){
      console.log("in click order downShelf function")
      $('div.onShelfConfirm').dialog("open");
      e.preventDefault();
    })

    $('div.onShelfConfirm').dialog({
      width:800,
      autoOpen:false,
      open: function(){
        //fetch 要帶入productDES id
        fetch("../product/findByComId?companyId=1")
        .then((body) => body.json())
        .then((productBO) =>{
            console.log(productBO);
          $.each(productBO,function(index,item){
            //給動態productDes id 
            document.querySelector(".conProDesId").value = item.prodesId;
            console.log(item.prodesId); //1~55
            document.querySelector(".conProName").value = item.productName;
            document.querySelector(".conProType").value = item.productType;
            document.querySelector(".conProSize").value = item.productSize;
            document.querySelector(".conProColor").value = item.productColor;
            document.querySelector(".conProStock").value = item.proDesStock;
          });
        })
      },
      modal:true,
      title:"確認商品上下架",
      buttons:{
        "確認上架":function(){
          //update productDes Status > 1
          let status = 1;
          let productDesId = document.querySelector(".conProDesId").value;
          fetch("../companyProduct/updateProDesStatusOfShelf" , {
            method:"POST",
            headers:{
              "Content-Type":"application/json"
            },
            body: JSON.stringify({
              status,
              productDesId,
            })
          })
          $(this).dialog("close");
          alert('此商品已上架');
        },
        "確認下架":function(){
          //update productDes Status > 0
          let status = 0;
          let productDesId = document.querySelector(".conProDesId").value;
          fetch("../companyProduct/updateProDesStatusOfShelf" , {
            method:"POST",
            headers:{
              "Content-Type":"application/json"
            },
            body: JSON.stringify({
              status,
              productDesId,
            })
          })
          $(this).dialog("close");
          alert('此商品已下架');
        }
      }
    });




    ///////////////////////////////////////////////////
    $.ajax({
      url:"../companyOrder/findDesByOrderId?orderId=1",
      type:"GET",
      dataType:"json",
      success: function(data){
        console.log("Des dataTable search success");
        orderDesData(data);
      },
      error: function(){
        console.log("Des dataTable search error ")
      }
    });
    function orderDesData(data){
      var orderdeslist = $('#shippedlisttable').dataTable({
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
    }
    /* -----------商品上架結束---------- */


    
      
      
      
      
})

    
   
