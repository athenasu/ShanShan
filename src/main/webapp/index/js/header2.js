	$("#memberCenter").click(function(){
		$.ajax({
				url:"/shanshan/CheckAccount.do",
				method: "GET",
				success : function(e) {
					if(e==="ok"){
						location.href = "/shanshan/member/member_main.html"
					}else{
						$(".overlay2").removeClass("-none");
						$(".modal2 #errormsg").html("請先登入帳號");	
					}
				}			
			})
	})

		$("#cancel2").click(function(){
			$(".modal2 #errormsg").html("");
			$(".overlay2").addClass("-none");		
		});