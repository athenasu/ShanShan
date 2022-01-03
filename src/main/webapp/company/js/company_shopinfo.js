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

    /* -----------店家首圖上傳---------- */
      var sb = document.getElementById("sb");
      sb.addEventListener("change",function(e){
        // console.log("change");
        // console.log(this);
        // console.log(this.files);
        // console.log(this.files[0]);
      var sbanner = document.getElementsByClassName("sbanner")[0];
      sbanner.innerHTML = "";

        let reader = new FileReader();
        reader.readAsDataURL(this.files[0]);
        reader.addEventListener("load",function(){
          console.log(reader.result);
          let li_html =`<li><img src="${reader.result}" class="shopbanner"></li>`;
          sbanner.insertAdjacentHTML("beforeend",li_html);
        });
      })

    
      var shopreset = document.getElementById("shopreset");
      shopreset.addEventListener("click",function(){
        // console.log("aaa");
        sbanner.innerHTML = '<span class="sbtext">圖片預覽</span>';
      })
      
      /* ---------------------------店家資訊頁面串後端------------------------------ */
      // show info on page 
      const poplatePage = function(){
        fetch("findByPK")
        .then((body) => body.json())
        .then((company) => {
          console.log(company);
          const bytesStr = atob(company.companyBanner);
          let len = bytesStr.length;
          const u8Array = new Uint8Array(len);
          while(len--){
            u8Array[len] = bytesStr.charCodeAt(len);
          }
        
          const blob = new Blob([u8Array]);
          const url = URL.createObjectURL(blob);
          document.querySelector(".shopbannerimg").src = url;
          document.querySelector(".shopaccountin").value = company.companyEmail;
          document.querySelector(".shoppasswordin").value = company.companyPassword;
          document.querySelector(".shopownerin").value = company.companyOwner;
          document.querySelector(".shopnamein").value = company.companyName;
          document.querySelector(".shopaddressin").value = company.companyAddress;
          document.querySelector(".shoptelin").value = company.companyPhone;
          document.querySelector(".shopcellin").value = company.companyCell;
          document.querySelector(".shopintroin").value = company.companyIntro;

        })
      };
      /* ---------------------------店家資訊頁面更新------------------------------ */
      //Update Company
      const submitBtn = document.querySelector("#shopsubmit");
      //去抓上傳圖檔的input標籤
      const uploadShopbanner = document.querySelector(".upload_shopbanner")
      const updateInfo = function(){
        const companyEmail = document.querySelector(".shopaccountin").value;
        const companyPassword = document.querySelector(".shoppasswordin").value;
        const companyOwner = document.querySelector(".shopownerin").value;
        const companyName = document.querySelector(".shopnamein").value;
        const companyAddress = document.querySelector(".shopaddressin").value;
        const companyPhone = document.querySelector(".shoptelin").value;
        const companyCell = document.querySelector(".shopcellin").value;
        const companyIntro = document.querySelector(".shopintroin").value;
        const file = uploadShopbanner.files[0];
        const fileReader = new FileReader();

        fileReader.onload = function(e) {
          const base64str = btoa(e.target.result);
          fetch("companyUpdate" , {
            method: "POST",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify({
              picStr: base64str,
              companyPassword,
              companyOwner,
              companyName,
              companyAddress,
              companyPhone,
              companyCell,
              companyIntro,
            }),
          }).then(body => body.json())
          	.then(company => {
          		console.log(company);
          		alert("資料已更新");
          	});
        };
        fileReader.readAsBinaryString(file);
      };
      
      poplatePage();
      
      
      submitBtn.addEventListener("click", function(){
    	  console.log("clicked submit");
    	  updateInfo();
    	  console.log("shop info updated");
      });
      
      /* ---------------------------店家資訊頁面串後端------------------------------ */
      
      
      })

    
   
