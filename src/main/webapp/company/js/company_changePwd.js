//    $('input.shopPwd').on("keyup",function(e){
//         if(e.which == 13){
//             $(".middlelogin").click();
//         }
//     });
    // const loginBtn = document.querySelector(".middlelogin")
    $('.submitPwd').click(function(){
        const companyPassword = document.querySelector(".shopPwd").value;
        const companyPasswordRepeat = document.querySelector(".shopPwdRepeat").value;
        if(companyPassword == companyPasswordRepeat) {
            fetch(`/shanshan/company/changePwd` , {
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                },
                body: JSON.stringify({
                    companyPassword,
                }),
            })
            .then((body) => {
                console.log(body);   
                window.location.replace(`/shanshan/company/company_login.html`);
            })
        }
    })
