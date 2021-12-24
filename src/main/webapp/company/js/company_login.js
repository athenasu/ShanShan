//    $('input.shopPwd').on("keyup",function(e){
//         if(e.which == 13){
//             $(".middlelogin").click();
//         }
//     });
    // const loginBtn = document.querySelector(".middlelogin")
    $('.middlelogin').click(function(){
        const companyEmail = document.querySelector(".shopAcc").value;
        const companyPassword = document.querySelector(".shopPwd").value;
        if(companyEmail == "" || companyPassword == ""){
            alert("帳號密碼不可空白！")
        }else{
            fetch("/shanshan/company/login" , {
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                },
                body: JSON.stringify({
                    companyEmail,
                    companyPassword,
                }),
            })
            .then(function(response){
                console.log(response);
                console.log("in first then");
                return response.json();
            })
            .then((body) => {
                console.log("in second then");
                console.log(body);   
            })
            window.location.replace("../company/company_backend_page.html");
        
        }
    })
