//    $('input.shopAcc').on("keyup",function(e){
//         if(e.which == 13){
//             $(".middlelogin").click();
//         }
//     });
    // const loginBtn = document.querySelector(".middlelogin")
    $('.submitPwd').click(function(){
        let companyEmail = document.querySelector(".shopAcc").value;
        console.log(companyEmail);
        if(companyEmail == ""){
            alert("信箱不可空白！")
        }else{
            fetch(`/shanshan/company/forgetPwdCheckEmail` , {
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                },
                body: JSON.stringify({
                    companyEmail,
                }),
            })
            .then(function(response){
                console.log(response);
                console.log("in first then");
                return response.json();
            })
            .then((body) => {
                console.log(body.successful);
                if(body.successful){
                    alert("變更密碼信件已寄送，請前往收信確認")
                } 
            })
        }
    })
