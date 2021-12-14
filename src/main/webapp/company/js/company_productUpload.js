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


    /* -------------------------- 商品圖上傳一 ------------------------ */
      let pro = document.getElementById("pro");
      let pro2 = document.getElementById("pro2");
      let pro3 = document.getElementById("pro3");
      let pro4 = document.getElementById("pro4");
      let pro5 = document.getElementById("pro5");

      //
      pro.addEventListener("change",function(e){
        // console.log("change")
      var proimg = document.getElementsByClassName("proimg")[0];
      proimg.innerHTML = "";

        let reader = new FileReader();
        reader.readAsDataURL(this.files[0]);
        reader.addEventListener("load",function(){
          console.log(reader.result);
          let li_html =`<li><img src="${reader.result}" class="probanner"></li>`;
          proimg.insertAdjacentHTML("beforeend",li_html);
        });
      })
     
      //===========================商品圖上傳二================================
      pro2.addEventListener("change",function(e){
        // console.log("change")
      var proimg2 = document.getElementsByClassName("proimg2")[0];
      proimg2.innerHTML = "";

        let reader2 = new FileReader();
        reader2.readAsDataURL(this.files[0]);
        reader2.addEventListener("load",function(){
          console.log(reader2.result);
          let li_html2 =`<li><img src="${reader2.result}" class="probanner2"></li>`;
          proimg2.insertAdjacentHTML("beforeend",li_html2);
        });
      })

      //===========================商品圖上傳三================================
      pro3.addEventListener("change",function(e){
        // console.log("change")
      var proimg3 = document.getElementsByClassName("proimg3")[0];
      proimg3.innerHTML = "";

        let reader3 = new FileReader();
        reader3.readAsDataURL(this.files[0]);
        reader3.addEventListener("load",function(){
          console.log(reader3.result);
          let li_html3 =`<li><img src="${reader3.result}" class="probanner3"></li>`;
          proimg3.insertAdjacentHTML("beforeend",li_html3);
        });
      })

      //===========================商品圖上傳四================================
      pro4.addEventListener("change",function(e){
        // console.log("change")
      var proimg4 = document.getElementsByClassName("proimg4")[0];
      proimg4.innerHTML = "";

        let reader4 = new FileReader();
        reader4.readAsDataURL(this.files[0]);
        reader4.addEventListener("load",function(){
          console.log(reader4.result);
          let li_html4 =`<li><img src="${reader4.result}" class="probanner4"></li>`;
          proimg4.insertAdjacentHTML("beforeend",li_html4);
        });
      })
      //===========================商品圖上傳五================================
      pro5.addEventListener("change",function(e){
        // console.log("change")
      var proimg5 = document.getElementsByClassName("proimg5")[0];
      proimg5.innerHTML = "";

        let reader5 = new FileReader();
        reader5.readAsDataURL(this.files[0]);
        reader5.addEventListener("load",function(){
          console.log(reader5.result);
          let li_html5 =`<li><img src="${reader5.result}" class="probanner5"></li>`;
          proimg5.insertAdjacentHTML("beforeend",li_html5);
        });
      })
      //===========================清空=======================================
      var proreset = document.getElementById("proreset");
      proreset.addEventListener("click",function(){
        // console.log("aaa");
        proimg.innerHTML = '<span class="sbtext">圖片預覽</span>';
        proimg2.innerHTML = '<span class="sbtext">圖片預覽</span>';
        proimg3.innerHTML = '<span class="sbtext">圖片預覽</span>';
        proimg4.innerHTML = '<span class="sbtext">圖片預覽</span>';
        proimg5.innerHTML = '<span class="sbtext">圖片預覽</span>';
      })

      //===========================新增串後端=======================================

      $('#prosubmit').click(function(e){
        $('.dialog-confirm').dialog("open");
         e.preventDefault();
      });
      $('.dialog-confirm').dialog({
        autoOpen:false,
        modal:true,
        title:"確認新增",
        buttons:{
          "是":function(){
            $.ajax({
              type: "POST",
              url: "../product/addproduct",
              data:$('.pinfo').serialize(),
              dataType:"json",
              success: function(){
                console.log("submit product success");
                // $.ajax({
                //   type: "POST",
                //   url: "../product/addproduct",
                //   data:$('.pinfo').serialize(),
                //   dataType:"json",
                // })
                $(this).dialog("close");
              },
              error: function(){
                console.log("submit error")
              }
            })
          },
          "否":function(){
            $(this).dialog("close");
          }
        }
  
      });

      

})

    
   
