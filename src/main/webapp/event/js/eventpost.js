$("#event_deadline").on("change", function () {
    $("#event_deadline").attr("value", $(this).val());
})

$("#event_start_date").on("change", function () {
    $("#event_start_date").attr("value", $(this).val());
})

$("#difficulty").on("change", function () {
    $("#difficulty").attr("value", $(this).val());
})

$("#stay_type").on("change", function () {
    $("#stay_type").attr("value", $(this).val());
})

$(document).on("change", "#mountain_area", function () {
    $("#mountain_area").attr("value", $(this).val())
    // console.log($("select").filter(".-on"));

    $("select").filter(".-on").removeClass("-on");

    var choice = parseInt($(this).val());
    switch (choice) {
        case 1:
            $("select.north_mountain").addClass("-on")
            break;
        case 2:
            $("select.mid_mountain").addClass("-on");
            break;
        case 3:
            $("select.south_mountain").addClass("-on");
            break;
        case 4:
            $("select.east_mountain").addClass("-on");
            break;
        case 5:
            $("select.other_mountain").addClass("-on");
            break;
    }
})
$(document).on("change", "#mountain_id", function () {
    $("#mountain_id").attr("value", $(this).val());
    console.log($(this).val())
    $.ajax({
        url: "http://localhost:8081/shanshan/mountain/findMtnByPk",
        type: "GET",
        data: {"mtnId":$(this).val()},
        beforeSend: function () {

        },
        success: function (data) {
            console.log(data.mountainId);

            var bytes = new Uint8Array(data.mountainPic);
            var blob = new Blob([bytes], { type: "image/png" });
            var url = URL.createObjectURL(blob);
            $("div.mountain_pic").html('<img src="'+ url +'" class="mountain_pic">');
        }
    })
})

$(document).on("click", "button.submit_btn", function () {
    console.log("123")
    if ($("input.event_name").val() == null || $("input.event_days").val() == null || $("#event_start_date").val() <= $("#event_deadline").val() || $("input.min_num_of_people").val() >= $("input.max_num_of_people").val() || $("textarea.event_content").val() == null) {
        alert("請輸入完整資訊, 並確認'出發日期'晚於'結團日期'、'人數上限'大於'最少出發人數'");
    } else {
        var member_id = 1;
        var event_status = 2;
        var event_points = 10;
        var event_cur_part = 1;
        let event = JSON.stringify({
            "memberId": member_id,                                                      //set as 1 for test
            "mountainId": $("#mountain_id").val(),
            "eventName": $("input.event_name").val(),
            "eventDays": $("input.event_days").val(),
            "difficulty": $("#difficulty").val(),
            "eventDeadline": $("#event_deadline").val(),
            "eventStartDate": $("#event_start_date").val(),
            "eventPostDate": new Date().toISOString(),
            "stayType": $("#stay_type").val(),
            "minNumOfPeople": $("input.min_num_of_people").val(),
            "maxNumOfPeople": $("input.min_num_of_people").val(),
            "assemblingPlace": $("input.assembling_place").val(),
            "eventContent": $("textarea.event_content").val(),
            "eventStatus": event_status,
            "eventPoints": event_points,
            "eventCurPart": event_cur_part
        });


        $.ajax({
            url: "http://localhost:8081/shanshan/event/addEvent",
            type: "POST",
            contentType: 'application/json',
            data: event,
            dataType: "json",
            beforeSend: function () {

            },
            success: function (data) {
                console.log("send data successfully")
            }
        })
    }
})
