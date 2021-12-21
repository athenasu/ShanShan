
$(function() {
    $("#date").datepicker({
    	maxDate: "$.now()",
    	dateFormat: "yy-mm-dd"
    	});
  });
  	
	var mtnid=1;
	$(".mtnId").change(function(){
		mtnid=$(this).val()
		if(mtnid==100){
			$(".addMtn").attr('disabled', false);
		}
		else{
			$(".addMtn").attr('disabled',"disabled");
		}
	})
	
	$("#cancel").click(function(){
		$(".overlay").addClass("-none");
	});
	
	var imglength="";
	$("#upimg").change(function(){
		imglength=this.files.length;
	})
	
	$("#sendbtn").click(function(){
		var date =$(".date").val();
		var artTitle =$("#artTitle").val();
		var otherMtn =$(".addMtn").val();
		var artContent = $("#artContent").val();

		if(artTitle == ""|artContent ==""|(otherMtn=="" && mtnid == 100)|date ==""){
			$(".overlay").removeClass("-none");
			$("#errormsg").html("有資料未填寫，請完成填寫");
		}else if(imglength > 5){
			$(".overlay").removeClass("-none");
			$("#errormsg").html("圖片不可上傳超過5張，請確認重新上傳");
		}else if(imglength ==0){
			$(".overlay").removeClass("-none");
			$("#errormsg").html("請至少上傳一張照片");
		}else{
			$("form").submit();
		}

	})
	
	$("#cancelbtn").click(function(){
		location.href =("articleList.jsp");
	})