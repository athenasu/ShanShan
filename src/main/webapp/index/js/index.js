var count = 2;
getdata(102);

$(".bgImg").slick({
  dots: false,
  arrows: false,
  infinite: true,
  speed: 1500,
  fade: true,
  cssEase: "linear",
  autoplay: true,
  autoplaySpeed: 3000,
});

$(".bgImg").on("afterChange", function () {
  switch (count % 3) {
    case 1:
      getdata(102);
      count++;
      break;
    case 2:
      getdata(101);
      count++;
      break;
    case 0:
      getdata(54);
      count++;
      break;
  }
});

//傳入num，取得山區天氣資料 102:雪山;101:大霸尖山;54:合歡山
var data;
function getdata(num) {
  $.ajax({
    url: "https://opendata.cwb.gov.tw/fileapi/v1/opendataapi/F-B0053-031?Authorization=CWB-753D61A7-090D-40B6-BAE8-8BDCFAFBC7E0&format=JSON",
    method: "GET",
    datatype: "JSON",
    success: function (re) {
      var data = re.cwbopendata.dataset.locations.location;
//      console.log(data);
      var mtnName = data[num].locationName; //山名
      var weekMtnData = data[num].weatherElement[0]; //山的一周平均溫度資料 ;
      var weekWeatherData = data[num].weatherElement[12]; //一周天氣狀況
      var nowDay = weekMtnData.time[0].startTime.substr(5, 5).replace("-", "/"); //日期
      var nowTmp = weekMtnData.time[0].elementValue.value; //當日氣溫
      var nowWeather = weekWeatherData.time[0].elementValue[0].value; //當日天氣描述
      var nowrain = data[num].weatherElement[9].time[0].elementValue.value; //當日降雨機率
      var now = new Date().toLocaleString();
      var str = `
            <div id = "mountain">
                <i class="fas fa-map-marker-alt"></i><span>${mtnName}</span>
            </div>
            <div id="mountaininfo">         
                <div class="wheatherInfo">
                    <div id="now"><span>${nowDay}</span></div>
                    <div>
                        <div id="now_tmp">平均溫度<span>${nowTmp}</span>°C</div>
                        <div id="now_tmp">降雨機率<span>${nowrain}</span>%</div>
                    </div>
                </div>
                <div id="now_wh"><span>${nowWeather}</span></div>
            </div>
            <h5>最後更新時間：${now}</h5>       
    `;
      $("#weather").html(str);
    },
  });
}


$('#grouplist').slick({
	  infinite: true,
	  slidesToShow: 4,
	  slidesToScroll: 1,
	  dots: false,
	  arrows: false,
	  autoplay: true,
	  autoplaySpeed:3000,

	});

$('#artlist').slick({
	  infinite: true,
	  slidesToShow: 4,
	  slidesToScroll: 1,
	  dots: false,
	  arrows: false,
	  autoplay: true,
	  autoplaySpeed:3000,

	});


