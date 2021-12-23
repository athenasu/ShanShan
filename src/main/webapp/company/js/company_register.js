
    /* -----------店家註冊營登證上傳---------- */
      var ceti = document.getElementById("ceti");
      ceti.addEventListener("change",function(e){
        // console.log("change");
        // console.log(this);
        // console.log(this.files);
        // console.log(this.files[0]);
      var cetiPhoto = document.getElementsByClassName("cetiPhoto")[0];
      cetiPhoto.innerHTML = "";

        let reader = new FileReader();
        reader.readAsDataURL(this.files[0]);
        reader.addEventListener("load",function(){
          // console.log(reader.result);
          let li_html =`<li><img src="${reader.result}" class="cetiBanner"></li>`;
          cetiPhoto.insertAdjacentHTML("beforeend",li_html);
        });
      })
    /* -----------店家註冊營登證結束---------- */
    //信箱格式確認
    
    /* -----------店家註冊送出---------- */
    let registerBtn = document.querySelector("#regibutton");
    // const uploadCetiImg = document.querySelector(".cetiUp");

    registerBtn.addEventListener("click", function(){
      const companyName = document.querySelector(".shopName").value;
      const companyEmail = document.querySelector(".shopAcc").value;
      const companyPassword = document.querySelector(".shopPwd").value;
      const companyPwdConfirm = document.querySelector(".shopPwdConfirm");
      const companyOwner = document.querySelector(".shopBoss").value;
      const companyAddress = document.querySelector(".shopAdd").value;
      const companyPhone = document.querySelector(".shopTell").value;
      const companyCell = document.querySelector(".shopCell").value;
      const uploadCetiImg = document.querySelector(".cetiUp");
      const file = uploadCetiImg.files[0];//得到營登證
      const fileReader = new FileReader();//創建FileReader物件
      fileReader.onload = function(e){
        const base64str = btoa(e.target.result);  
        fetch("/shanshan/company/register" , {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            companyCetificate: base64str,
            companyName,
            companyEmail,
            companyPassword,
            companyOwner,
            companyAddress,
            companyPhone,
            companyCell,
          }),
        }).then(company => {
          alert("已遞交註冊資料,審核後將寄送email至註冊信箱。");
        });
      };
      fileReader.readAsBinaryString(file);
    });


    
   
