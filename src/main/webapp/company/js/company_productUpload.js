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
            if($("#pro").val() != null ){
             // step1 帶入companyId 把product建起 回傳productId("名稱種類介紹" 價格)
             // let companyId = 8;
             let status = 0;
             let productPrice = document.querySelector(".proprice").value;
             let productName = document.querySelector(".proname").value;
             let productType = document.querySelector('input[name="pType"]:checked').value;
             let productIntro = document.querySelector(".prointro").value;

            // console.log(companyId);
              fetch(`/shanshan/companyProduct/addproduct` , {
              //use await ? 
              method:"POST",
              headers:{
                "Content-Type":"application/json"
              },
              body: JSON.stringify({
                //  companyId,
                 status,
                 productPrice,
                 productName,
                 productType,
                 productIntro,
              }) 
            })
            .then(function(response){
                console.log("in first then");
                console.log(response);
                return response.json();
            })
            .then((body) => {
                console.log(body.productId);
                let productId = body.productId;
                console.log(productId)
                // step2 帶入step1建立好的productId 將prodes物件建起("尺寸顏色庫存" 價格不可為空值)
                let productSize = document.querySelector('input[name="product"]:checked').value;
                let productColor = document.querySelector(".color").value;
                let productStock = document.querySelector(".stock").value;
                let productPrice = document.querySelector(".proprice").value;
                let status = 0;
                fetch(`/shanshan/companyProduct/addprodes` , {
                  method:"POST",
                  headers:{
                    "Content-Type":"application/json"
                  },
                  body: JSON.stringify({
                    productId,
                    productSize,
                    productColor,
                    productStock,
                    productPrice,
                    status,
                  })

                })
                .then(function(response){
                  console.log("in second then");
                  console.log(response);
                  return response.json();
                })
                .then((body) => {
                  console.log(body.productDesId);
                  let productDesId = body.productDesId;
                  console.log(productDesId)
                  let productImgs = document.querySelector(".upload_pro");
                  const file = productImgs.files[0];
                  const fileReader = new FileReader();
                  fileReader.onload = function(e){
                    const base64str = btoa(e.target.result);
                  // step3 帶入prodesId 建入img( 帶入desId圖檔)
                    fetch(`/shanshan/companyProduct/addproimg` , {
                      method:"POST",
                      headers:{
                        "Content-Type":"application/json"
                      },
                      body: JSON.stringify({
                        productDesId,
                        productImg:base64str,
                      }),
                    }).then(body => body.json())
                      .then(proImg => {
                        console.log(proImg);
                        alert("商品資料已新增，請前往上下架頁面確認是否上架")
                      })
                  };
                  fileReader.readAsBinaryString(file);
                })
                $('.dialog-confirm').dialog("close");
            })
          }else{
            alert('需至少上傳一張商品圖片！')
            $('.dialog-confirm').dialog("close");
          }

         }
        },
          "否":function(){
            $(this).dialog("close");
          }
        });
  
});



    
   
