   $('input.shopPwd').on("keyup",function(e){
        if(e.which == 13){
            $(".middlelogin").click();
        }
    });
    // const loginBtn = document.querySelector(".middlelogin")
    $('.middlelogin').click(function(){
        const companyEmail = document.querySelector(".shopAcc").value;
        const companyPassword = document.querySelector(".shopPwd").value;
        if(companyEmail == "" || companyPassword == ""){
            alert("帳號密碼不可空白！")
        }else{
            fetch(`/shanshan/company/getStatus?email=${companyEmail}`)
            .then(function(response){
                console.log(response);
                return response.json();
            })
            .then((body) => {
                if (body.successful) {
                    console.log(body.successful);
                    fetch(`/shanshan/company/login` , {
                        method:"POST",
                        headers:{
                            "Content-Type":"application/json",
                        },
                        body: JSON.stringify({
                            companyEmail,
                            companyPassword,
                        }),
                    })
                    window.location.replace("../company/company_backend_page.html");
                }else{
                    alert("目前尚未通過審核，審核通過後才可登入：）")
                }
            })
        }
    })
