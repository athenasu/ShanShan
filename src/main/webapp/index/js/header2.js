	$("#memberCenter").click(function(){
		$.ajax({
				url:"/shanshan/CheckAccount.do",
				method: "GET",
				success : function(e) {
					if(e==="ok"){
						location.href = "/shanshan/member/member_main.html"
					}else{
						$(".overlayh").removeClass("-none");
						$(".modalh #errormsg").html("請先登入帳號");	
					}
				}			
			})
	})

		$("#cancelh").click(function(){
			$(".modalh #errormsg").html("");
			$(".overlayh").addClass("-none");		
		});