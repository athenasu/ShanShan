function init() {
    $.ajax({
        url: "http://localhost:8081/shanshan/event/popularEvents",
        type: "GET",
        data: {},
        dataType: "json",
        beforeSend: function () {

        },
        success: function (data) {
            // console.log(data);
            // console.log(data[0].eventName);
            // console.log(new Date(data[0].eventStartDate));
            let popular_events = "";

            $.each(data, function (index, item) {
                var bytes = new Uint8Array(item.mountainPic);
                var blob = new Blob([bytes], {type: "image/png"});
                var url = URL.createObjectURL(blob);
                // console.log(JSON.stringify(item.mountainPic));

                popular_events +=   "<div class='event_slide'>";
                popular_events +=       "<img class='event_slide_pic' src='"+url+"'>";
                popular_events +=       "<h4 class='event_slide_name'>"+item.eventName+"</h4>";
                popular_events +=       "<h4 class ='slide_startdate'>出團日期："+(new Date(item.eventStartDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }))+"</h4>"
                popular_events +=   "</div>"
            })
            $("div.slidshow_container").html(popular_events);
        }
    })

    $.ajax({
        url: "http://localhost:8081/shanshan/event/eventList",
        type: "GET",
        data: {},
        dataType: "json",
        beforeSend: function () {

        },
        success: function (data) {
            // console.log(data);
            let event_list = "";
            $.each(data, function (index, item) {
                console.log(item)

                var bytes = new Uint8Array(item.mountainPic);
                var blob = new Blob([bytes], {type: "image/png"});
                var url = URL.createObjectURL(blob);
                console.log(url);

                event_list +=   "<div class='event_display'>";
                event_list +=       "<img class ='event_pic' src='"+url+"'>";
                event_list +=       "<h3 class='event_name'>"+item.eventName+"</h3>";
                event_list +=       "<div class='event_start_date'>出團日期：<span>"+(new Date(item.eventStartDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }))+"</span></div>"
                event_list +=   "</div>"
            })
            $("div.main_block").html(event_list);
        }
    })
}
$(function(){
    init();
})