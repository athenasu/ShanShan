

var data;
function getdata(num) {
	
	if(num == "none"){
		errormsg =`
		<h3 style="color:#318d2b">目前未提供天氣狀況</h3>
		`			
		$(".weather-table").html(errormsg);
	}
	else{
		$.ajax({
		    url: "https://opendata.cwb.gov.tw/fileapi/v1/opendataapi/F-B0053-031?Authorization=CWB-753D61A7-090D-40B6-BAE8-8BDCFAFBC7E0&format=JSON",
		    method: "GET",
		    datatype: "JSON",
		    success: function (re) {
		    data = re.cwbopendata.dataset.locations.location;

		    let week="";
		    let temp="";
			for(var i=0; i<7 ;i++){		
			      var day=data[num].weatherElement[3].time[i].startTime.substr(5, 5).replace("-", "/") //日期
			      var high=data[num].weatherElement[3].time[i].elementValue.value //最高溫
			      var low=data[num].weatherElement[4].time[i].elementValue.value //最低溫
			      var weather = data[num].weatherElement[12].time[i].elementValue[0].value//天氣描述
			      var rain = data[num].weatherElement[9].time[i].elementValue.value//降雨機率
			      if(rain == null){
			    	  rain = 0;
			      }
			      
			      week +=`	      
		              <th>${day}</th>         
		          `         
		          temp +=`            
		                  <td>
		                      <div class="weather-cell">
		                          <p>${weather}</p>
		                          <p>降雨機率${rain}%</p>
		                          <p class="weather-degree">${low} - ${high} ℃</p>
		                      </div>
		                  </td>
		             `
			    	 $(".week").html(week);
			      $(".temp").html(temp);	      
			}
		    },
		  });
	}

}


$(".group-card").click(function(){
	
	eventid= $(this).data("gpid")
	window.localStorage.setItem("eventID", eventid);
    location.href="./event/eventview.html";
})
