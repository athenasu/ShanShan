	 const emailAddress = document.querySelector(".shopAcc");
   const companyPwd = document.querySelector(".shopPwd");
	 const errMsg = document.querySelector(".errMsg");
   const errPwd = document.querySelector(".errPwd");
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
    
      //////////////////////////////////信箱格式確認////////////////////////////////////
      const validateEmail = function(email){
        let regexEmail = /\S+@\S+\.\S+/;
        if(email.match(regexEmail)){
          return true;
        }else{
          return false;
        }
      }
   
      emailAddress.addEventListener("keyup", function(e){
        let validate = validateEmail(emailAddress.value);
          if(!validate){
            errMsg.innerHTML = "<p>請輸入正確格式信箱</p>";
          }else{
            errMsg.innerHTML = "";
          }
        
      })

      //////////////////////////////////密碼格式確認////////////////////////////////////
      const validatePwd = function(pwd){
        let regexPwd = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$/;
        if(pwd.match(regexPwd)){
          return true;
        }else{
          return false;
        }
      }

      companyPwd.addEventListener("keyup" , function(e){
        let validatePassword = validatePwd(companyPwd.value);
        if(!validatePassword){
          errPwd.innerHTML = "<p>請輸入8-16位含大小寫英文數字密碼</p>";
        }else{
          errPwd.innerHTML = "";
        }
      })


    /* -----------店家註冊送出---------- */
    let registerBtn = document.querySelector("#regibutton");
    registerBtn.addEventListener("click", function(){
      const PasswordTest = document.querySelector(".shopPwd").value;
        const companyName = document.querySelector(".shopName").value;
        const companyPassword = document.querySelector(".shopPwd").value;
        const companyEmail = document.querySelector(".shopAcc").value;
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


    
   
