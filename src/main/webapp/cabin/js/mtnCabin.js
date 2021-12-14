$(document).ready(function() {
	let cabin1Path ="CabinServlet.do";
 	$.ajax({
		url : cabin1Path,
		data : {
			"action" : "getBooking"
		},
		dataType : "html",
		method : "POST",
		success : function(result) {
			$(".booking").html(result);
		}
	})
})

