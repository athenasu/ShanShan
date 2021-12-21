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
                console.log(body);//didn't show in console
            })
        // $.ajax({
        //     url:`/shanshan/company/login`,
        //     type:"POST",
        //     dataType:"json",
        //     data:{
        //         companyEmail,
        //         companyPassword
        //     },
        //     success: function(data){
        //         console.log("login success");
        //         if(data.success){
        //             var companyId = data.attr.company.companyId;
        //             sessionStorage.companyId = companyId;
        //             window.location.href = 'http://localhost/shanshan/company/company_backend_page.html'
        //         }

        //     }
        // })
        
        
        }
    })
