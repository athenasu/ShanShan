$(document).on("change", "#event_deadline", function () {
    $("#event_deadline").attr("value", $(this.val()));
})

$(document).on("change", "#event_start_date", function () {
    $("#event_start_date").attr("value", $(this.val()));
})

$(document).on("change", "#difficulty", function () {
    $("#difficulty").attr("value", $(this).val());
})

$(document).on("change", "#stay_type", function () {
    $("#stay_type").attr("value", $(this).val());
})

$(document).on("change", "#mountain_id", function () {
    $("#mountain_id").attr("value", $(this).val());
})
$(document).on("click", "button.cancel_participate", function () {
    $(".lightbox-target").removeClass("-on")
})
$(document).on("change", "select.experience", function(){
    $("select.experience").attr("value", $(this).val());
})
$(document).on("change", "select.participation", function(){
    $("select.participation").attr("value", $(this).val());
    console.log(this)
})

$(document).on("change", "#mountain_area", function () {
    $("#mountain_area").attr("value", $(this).val());
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


function init() {

    //=========================== GET EVENT BY EVENT_ID FROM DATABASE ===========================
    $.ajax({
        url: "http://localhost:8081/shanshan/event/findEventByEventId",
        type: "GET",
        data: { "eventId": 1 },
        dataType: "json",
        beforeSend: function () {

        },
        success: function (data) {
            // console.log(data);
            // console.log(data[0].eventName);
            // console.log(new Date(data[0].eventPostDate).toISOString());

            var bytes = new Uint8Array(data[0].mountainPic);
            var blob = new Blob([bytes], { type: "image/png" });
            var url = URL.createObjectURL(blob);

            let event_view_html = `
            <h3 class="event_name"><input class="event_name" value="${data[0].eventName}" readonly="readonly"></h3>
            <div class="event_pic">
                <img class="event_pic" src="${url}">
            </div>
            <div class="wish_report">
                <button class="event_wish_btn"><i class="fas fa-heart"></i>Like</button>
                <button class="event_report_btn">Report</button>
                <button class="join_btn" href="lightbox-target">JOIN</button>
            </div>
            <div class="event_detail">
                <ul class="event_detail_left">
                    <li class="event_id" name="event_id" value="${data[0].eventId}"">揪團編號：<span>${data[0].eventId}</span></li>
                    <li class="mountain_district">活動地區：
                        <select class="area_option" id="mountain_area" disabled>
                            <option name="mountain_district" value="1">北部</option>
                            <option name="mountain_district" value="2">中部</option>
                            <option name="mountain_district" value="3">南部</option>
                            <option name="mountain_district" value="4">東部</option>
                            <option name="mountain_district" value="5">其他地區</option>
                        </select>
                    </li>
                    <li class="mountain_name">目標：
                        <select class="north_mountain -on" id="mountain_id" disabled>
                            <option name="mountain_id" value="1">大霸尖山</option>
                            <option name="mountain_id" value="2">伊澤山</option>
                            <option name="mountain_id" value="3">喀拉業山</option>
                            <option name="mountain_id" value="4">七星山</option>
                            <option name="mountain_id" value="5">金面山</option>
                            <option name="mountain_id" value="30">其他</option>
                        </select>
                        <select class="mid_mountain" id="mountain_id" disabled>
                            <option name="mountain_id" value="6">雪山</option>
                            <option name="mountain_id" value="7">南湖大山</option>
                            <option name="mountain_id" value="8">大劍山</option>
                            <option name="mountain_id" value="9">中央尖山</option>
                            <option name="mountain_id" value="10">品田山</option>
                            <option name="mountain_id" value="30">其他</option>
                        </select>
                        <select class="south_mountain" id="mountain_id" disabled>
                            <option name="mountain_id" value="11">卓社大山</option>
                            <option name="mountain_id" value="12">能高山</option>
                            <option name="mountain_id" value="13">白姑大山</option>
                            <option name="mountain_id" value="14">干卓萬山</option>
                            <option name="mountain_id" value="15">牧山</option>
                            <option name="mountain_id" value="30">其他</option>
                        </select>
                        <select class="east_mountain" id="mountain_id" disabled>
                            <option name="mountain_id" value="16">馬比杉山</option>
                            <option name="mountain_id" value="17">奇萊主山</option>
                            <option name="mountain_id" value="18">合歡山</option>
                            <option name="mountain_id" value="19">畢祿山</option>
                            <option name="mountain_id" value="20">太魯閣大山</option>
                            <option name="mountain_id" value="30">其他</option>
                        </select>
                        <select class="other_mountain" id="mountain_id" disabled>
                            <option name="mountain_id" value="21">紅頭山</option>
                            <option name="mountain_id" value="22">蛇頭山</option>
                            <option name="mountain_id" value="23">太武山</option>
                            <option name="mountain_id" value="24">雲台山</option>
                            <option name="mountain_id" value="30">其他</option>
                        </select>
                    </li>
                    <li class="assembling_place">集合地點：<input class="assembling_place " type="text" value="${data[0].assemblingPlace}" readonly="readonly"></li>
                    <li class="difficulty">難度：
                        <select class="difficulty" id="difficulty" disabled>
                            <option class="easiest" name="difficulty" value="1">非常簡單</option>
                            <option class="easy" name="difficulty" value="2">簡單</option>
                            <option class="normal" name="difficulty" value="3">普通</option>
                            <option class="difficult" name="difficulty" value="4">困難</option>
                            <option class="hardest" name="difficulty" value="5">非常困難</option>
                        </select>
                    </li>
                    <li class="stay_type" >住宿種類：
                        <select class="stay_type" id="stay_type" value="${data[0].stayType}" disabled>
                            <option class="day_return" name="stay_type"  value="0">當天來回</option>
                            <option class="camp" name="stay_type"  value="1">野營</option>
                            <option class="cabin" name="stay_type"  value="2">山屋</option>
                            <option class="hotel" name="stay_type"  value="3">飯店</option>
                        </select>
                    </li>
                </ul>
                <ul class="event_detail_right">
                    <li class="event_days">活動天數：<input class="event_days " type="text" value="${data[0].eventDays}" readonly="readonly"></li>
                    <li class="event_deadline">截止日期：<input class="event_deadline " type="date" value="${new Date(data[0].eventDeadline).toISOString().slice(0, -14)}").toISOString()}" disabled></li>
                    <li class="event_start_date">活動開始日期：<input class="event_start_date " type="date" value="${new Date(data[0].eventStartDate).toISOString().slice(0, -14)}" disabled></li>
                    <li class="max_num_of_people">最少人數：<input class="min_num_of_people " value="${data[0].minNumOfPeople}"></li>
                    <li class="max_num_of_people">人數上限：<input class="max_num_of_people " value="${data[0].maxNumOfPeople}"></li>
                    <li class="event_cur_part" value="${data[0].eventCurPart}">目前參加人數：${data[0].eventCurPart}</li>
                    <li class="event_post_date">發文日期：${new Date(data[0].eventPostDate).toISOString().replace('T', '  ').split('.')[0]}</li>
                </ul>
    
            </div>
            <div class="event_content">
                <textarea class="event_content" disabled>${data[0].eventContent}</textarea>
            </div>
            <div class="back_edit">
                <button class="back_btn">BACK</button>
                <button class="edit_btn">EDIT</button>
                <button class="send_btn -none">SEND</button>
            </div>
            `
            $(".event_view").html(event_view_html);

            switch (parseInt(data[0].stayType)) {
                case 0:
                    $("option.day_return").prop('selected', true);
                    break;
                case 1:
                    $("option.camp").prop('selected', true);
                    break;
                case 2:
                    $("option.cabin").prop('selected', true);
                    break;
                case 3:
                    $("option.hotel").prop('selected', true);
                    break;
            }

            switch (parseInt(data[0].difficulty)) {
                case 1:
                    $("option.easiest").prop('selected', true);
                    break;
                case 2:
                    $("option.easy").prop('selected', true);
                    break;
                case 3:
                    $("option.normal").prop('selected', true);
                    break;
                case 4:
                    $("option.difficult").prop('selected', true);
                    break;
                case 5:
                    $("option.hardest").prop('selected', true);
                    break;
            }
            console.log(data[0].mountainId)
            switch (parseInt(data[0].mountainId)) {

            }
        }
    })

    //=========================== GET EVENT_MSG BY EVENT_ID FROM DATABASE ===========================
    $.ajax({
        url: "http://localhost:8081/shanshan/eventMsg/eventMsgList",
        type: "GET",
        data: { "eventId": 1 },
        dataType: "json",
        beforeSend: function () {

        },
        success: function (data) {

            let event_msg_html = "";
            $.each(data, function (index, item) {
                var bytes = new Uint8Array(item.memberProfilePic);
                var blob = new Blob([bytes], { type: "image/png" });
                var url = URL.createObjectURL(blob);
                // console.log(item);
                // console.log(item.memberProfilePic)
                console.log(url);

                event_msg_html += "<ul class='event_msg'>";
                event_msg_html += "<img class='member_pic' src='" + url + "'>";
                event_msg_html += "<li class='member_name'>" + item.memberName + "</li>";
                event_msg_html += "<li class='msg_content'>" + item.msgContent + "</li>";
                event_msg_html += "<button class='msg_report_btn'>Report</button>";
                event_msg_html += "</ul>";
            })
            $("div.event_msg_list").html(event_msg_html);
        }
    })
}

//=========================== SEND EVENT_WISH_LIST TO DATABASE ===========================

$(document).on("click", "button.event_wish_btn", function () {

    let eventWishList = JSON.stringify({
        "memberId": 5,      //set as 5 for test, need to catch login memberId
        "eventId": $("li.event_id").val()
    })

    $.ajax({
        url: "http://localhost:8081/shanshan/wishlistEvent/addWishlistEvent",
        type: "POST",
        contentType: 'application/json',
        data: eventWishList,
        dataType: "json",
        beforeSend: function () {
        },
        success: function (data) {
            console.log("123");
        }
    })
})

//=========================== SEND EVENT_REPORT TO DATABASE ===========================
$(document).on("click", "button.event_report_btn", function () {
    $.ajax({
        url: "http://localhost:8081/shanshan/eventReport/addEventReport",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify({
            "eventId": 1,
            "memberId": 1,
            "reportReason": 1,
            "reportDate": new Date().toISOString(),
            "caseStatus": 1
        }),
        dataType: "json",
        beforeSend: function () {
        },
        success: function (data) {
            console.log("123");
        }
    })
})

$(document).on("click", "button.back_btn", function () {

})

//=========================== EDIT BUTTON ===========================
$(document).on("click", "button.edit_btn", function () {
    $("input.event_name").addClass("-on").removeAttr("readonly");
    $("input.event_days").addClass("-on").removeAttr("readonly");
    $("input.assembling_place").addClass("-on").removeAttr("readonly");
    $("input.event_deadline").addClass("-on").removeAttr("disabled");
    $("input.event_start_date").addClass("-on").removeAttr("disabled");
    $("input.max_num_of_people").addClass("-on").removeAttr("readonly");
    $("input.min_num_of_people").addClass("-on").removeAttr("readonly");
    $("input.event_content").removeAttr("readonly");
    $("select.area_option").removeAttr("disabled");
    $("select.north_mountain").removeAttr("disabled");
    $("select.mid_mountain").removeAttr("disabled");
    $("select.south_mountain").removeAttr("disabled");
    $("select.east_mountain").removeAttr("disabled");
    $("select.other_mountain").removeAttr("disabled");
    $("select.difficulty").removeAttr("disabled");
    $("select.stay_type").removeAttr("disabled");
    $("textarea.event_content").removeAttr("disabled");
    $("button.send_btn").removeClass("-none");
})
$(document).on("click", "button.send_btn", function () {
    alert("確定送出變更?");
    var member_id = 1;
    var event_status = 2;
    var event_points = 10;
    // var event_cur_part = 1;
    // console.log($("#stay_type").val())

    $.ajax({
        url: "http://localhost:8081/shanshan/event/updateEvent",
        type: "PUT",
        contentType: 'application/json',
        data: JSON.stringify({
            "eventId": $("li.event_id").val(),
            "memberId": member_id,                                                      //set as 1 for test
            "mountainId": $("#mountain_id").val(),
            "eventName": $("input.event_name").val(),
            "eventDays": $("input.event_days").val(),
            "difficulty": $("#difficulty").val(),
            "eventDeadline": $("input.event_deadline").val(),
            "eventStartDate": $("input.event_start_date").val(),
            "stayType": $("#stay_type").val(),
            "minNumOfPeople": $("input.min_num_of_people").val(),
            "maxNumOfPeople": $("input.max_num_of_people").val(),
            "assemblingPlace": $("input.assembling_place").val(),
            "eventContent": $("textarea.event_content").val(),
            "eventStatus": event_status,
            "eventPoints": event_points,
            "eventCurPart": $("li.event_cur_part").val()
        }),
        dataType: "json",
        beforeSend: function () {
        },
        success: function (data) {
            window.location.reload();
        }
    })
})


//=========================== GET PARTICIPANT INFO IF EXIST===========================
$(document).on("click", "button.join_btn", function () {
    // console.log("123")
    $(".lightbox-target").addClass("-on")
    $.ajax({
        url: "http://localhost:8081/shanshan/participant/selectParticipantByMemberId",
        type: "GET",
        contentType: 'application/json',
        data: { "memberId": 4, "eventId": $("li.event_id").val() }, //need to get the login memberId
        dataType: "json",
        beforeSend: function () {
        },
        success: function (data) {
            // console.log("123")
            // $.each(data, function (index, item) {
            // console.log(item.eventId == $("li.event_id").val())
            // console.log(data)

            if (data.length != 0) {
                // console.log(data[0])
                let has_participated = `
                    <div class="join_content">
                        <h3>已參團</h3>
                        <input type="hidden" class="part_id" value="${data[0].partId}">
                        <p>是否有經驗：</p>
                        <select class="experience" id="experience">
                            <option class="no_experience" id="experience" value="false">沒有經驗</option>
                            <option class="has_experience" id="experience" value="true">有經驗</option>
                        </select>
                        <p>是否參加：</p>
                        <select class="participation" id="participation">
                            <option class="participate" id="participation" value="true">參加</option>
                            <option class="no_participate" id="participation" value="false">不參加</option>
                        </select>
                        <p>連絡電話：</p>
                        <input type="text" class="phone_number" name="phone_number" value="${data[0].phoneNumber}">
                        <p>參加人數</p>
                        <input type="text" class="total_participants" name="total_participants" value="${data[0].totalParticipants}">
                        <button class="edit_participants_btn">送出修改</button>
                        <button class="cancel_participate">返回</button>
                    </div>
                    `
                $("div.lightbox-target").html(has_participated);
                switch (data[0].experience) {
                    case true:
                        $("option.has_experience").prop('selected', true);
                        $("select.experience").attr("value", true)
                        break;
                    case false:
                        $("option.no_experience").prop('selected', true);
                        $("select.experience").attr("value", false)
                }

                switch (data[0].participation) {
                    case true:
                        $("option.participate").prop('selected', true);
                        $("select.participate").attr("value", true)
                        break;
                    case false:
                        $("option.no_participate").prop('selected', true);
                        $("select.participate").attr("value", false)
                }

            }
            else {
                let no_participate = `
                    <div class="join_content">
                        <h3>尚未參加</h3>
                        <p>是否有經驗：</p>
                        <select class="experience" id="experience">
                            <option class="no_experience" id="experience" value="false">沒有經驗</option>
                            <option class="has_experience" id="experience" value="true">有經驗</option>
                        </select>
                        <p>是否參加：</p>
                        <select class="participation" id="participation">
                            <option class="participate" id="participation" value="true">參加</option>
                            <option class="no_participate" id="participation" value="false">不參加</option>
                        </select>
                        <p>連絡電話：</p>
                        <input type="text" class="phone_number" name="phone_number">
                        <p>參加人數</p>
                        <input type="text" class="total_participants" name="total_participants">
                        <button class="send_participants_btn">送出</button>
                        <button class="cancel_participate">返回</button>
                    </div>
                    `
                $("div.lightbox-target").html(no_participate);
            }
        }
    })
})

//============================== SEND PARTICIPANT TO DATABASE ADN UPDATE EVENT_CUR_PART ========================================
$(document).on("click", "button.send_participants_btn", function () {
    var memberId = 4;
    $.ajax({
        
        url: "http://localhost:8081/shanshan/participant/addParticipant",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify({
            "eventId": $("li.event_id").val(),
            "memberId": memberId,
            "experience": $("select.experience").val(),
            "phoneNumber": $("input.phone_number").val(),
            "participation": $("select.participation").val(),
            "joinDate": new Date().toISOString(),
            "totalParticipants": $("input.total_participants").val()
        }),
        dataType: "json",
        beforeSend: function () {
        },
        success: function (data) {
            console.log(typeof($("input.participation").val()));
            console.log(typeof($("#experience").val()));
            var member_id = 1;
            var event_status = 2;
            var event_points = 10;
            var event_cur_part = (parseInt($("li.event_cur_part").val()) + parseInt($("input.total_participants").val()));

            //========= UPDATE EVENT_CUR_PART AFTER ADD PARTICIPANTS =========
            $.ajax({
                url: "http://localhost:8081/shanshan/event/updateEvent",
                type: "PUT",
                contentType: 'application/json',
                data: JSON.stringify({
                    "eventId": $("li.event_id").val(),
                    "memberId": member_id,                                                      //set as 1 for test
                    "mountainId": $("#mountain_id").val(),
                    "eventName": $("input.event_name").val(),
                    "eventDays": $("input.event_days").val(),
                    "difficulty": $("#difficulty").val(),
                    "eventDeadline": $("input.event_deadline").val(),
                    "eventStartDate": $("input.event_start_date").val(),
                    "stayType": $("#stay_type").val(),
                    "minNumOfPeople": $("input.min_num_of_people").val(),
                    "maxNumOfPeople": $("input.max_num_of_people").val(),
                    "assemblingPlace": $("input.assembling_place").val(),
                    "eventContent": $("textarea.event_content").val(),
                    "eventStatus": event_status,
                    "eventPoints": event_points,
                    "eventCurPart": event_cur_part
                }),
                success: function (data) {
                    $(".lightbox-target").removeClass("-on")

                }
            })
        }
    })
})
//========================== UPDATE PARTICIPANT INFO ============================
$(document).on("click", "button.edit_participants_btn", function () {
    var memberId = 4;
    // console.log($("li.event_id").val());
    console.log($("select.experience").val());
    console.log($("input.phone_number").val());
    console.log($("select.participation").val());
    console.log($("input.part_id").val());
    console.log($("input.total_participants").val());
    // console.log(typeof($("select.participation").val()));
    // console.log(typeof($("#experience").val()));
    // if($("select.participation").val() == true){
    //     var participation = 1;
    // }else{
    //     var participation = 0;
    // }

    // if($("select.experience").val() == true){
    //     var experience = 1;
    // }else{
    //     var experience = 0;
    // }
    // console.log(participation);
    // console.log(experience);

    $.ajax({
        url: "http://localhost:8081/shanshan/participant/updateParticipant",
        type: "PUT",
        contentType: 'application/json',
        data: JSON.stringify({
            "partId": $("input.partId").val(),
            "eventId": $("li.event_id").val(),
            "memberId": memberId,
            "experience": 1,
            "phoneNumber": $("input.phone_number").val(),
            "participation": 1,
            "totalParticipants": $("input.total_participants").val()
        }),
        dataType: "json",
        beforeSend: function () {
        },
        success: function (data) {
            var member_id = 1;
            var event_status = 2;
            var event_points = 10;
            var event_cur_part = (parseInt($("li.event_cur_part").val()) + parseInt($("input.total_participants").val()));

            //========= UPDATE EVENT_CUR_PART AFTER UPDATE PARTICIPANTS =========
            $.ajax({
                url: "http://localhost:8081/shanshan/event/updateEvent",
                type: "PUT",
                contentType: 'application/json',
                data: JSON.stringify({
                    "eventId": $("li.event_id").val(),
                    "memberId": member_id,                                                      //set as 1 for test
                    "mountainId": $("#mountain_id").val(),
                    "eventName": $("input.event_name").val(),
                    "eventDays": $("input.event_days").val(),
                    "difficulty": $("#difficulty").val(),
                    "eventDeadline": $("input.event_deadline").val(),
                    "eventStartDate": $("input.event_start_date").val(),
                    "stayType": $("#stay_type").val(),
                    "minNumOfPeople": $("input.min_num_of_people").val(),
                    "maxNumOfPeople": $("input.max_num_of_people").val(),
                    "assemblingPlace": $("input.assembling_place").val(),
                    "eventContent": $("textarea.event_content").val(),
                    "eventStatus": event_status,
                    "eventPoints": event_points,
                    "eventCurPart": event_cur_part
                }),
                success: function (data) {
                    $(".lightbox-target").removeClass("-on")

                }
            })
        }
    })
})

//=========================== SEND EVENT_MSG TO DATABASE ===========================
$(document).on("click", "button.add_msg_btn", function () {
    let eventId = $("li.event_id").val();
    let memberId = 1;
    let msgDate = new Date().toISOString();
    let msgContent = $("input.add_msg").val();
    let msgStatus = 1;

    $.ajax({
        url: "http://localhost:8081/shanshan/eventMsg/addEventMsg",
        type: "POST",
        contentType: 'application/json',
        data: JSON.stringify({
            "eventId": eventId,
            "memberId": memberId,
            "msgDate": msgDate,
            "msgContent": msgContent,
            "msgStatus": msgStatus
        }),
        dataType: "json",
        beforeSend: function () {
        },
        success: function (data) {
            console.log("123");
            $("div.event_msg_list").prepend(`
                <ul class="event_msg">
                    <img class="member_pic" src="#">
                    <li class="member_name">Owen：</li>
                    <li class="msg_content">${$("input.add_msg").val()}</li>
                    <button class="msg_report_btn">Report</button>
            </ul>
            `)
            $("input.add_msg").val("");
        }
    })
})


$(function () {
    init();
})