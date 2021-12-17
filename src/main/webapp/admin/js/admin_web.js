$(document).on("click", "a.lightbox-close", function () {
    $("div.event_report_lightbox").removeClass("-on");
    $("div.article_report_lightbox").removeClass("-on");
    $("div.msg_report_lightbox").removeClass("-on");
})
$(document).on("click", "input.report_accepted", function () {
    $(this).attr("checked", true);
    $("input.report_denied").attr("checked", false);
})
$(document).on("click", "input.report_denied", function () {
    $(this).attr("checked", true);
    $("input.report_accepted").attr("checked", false);
})

//================================================================================================================================
//=========================================================== SIDE BAR ===========================================================
//================================================================================================================================
//================================================================================================================================


//================================================================================================================================
$(document).on("change", "select.case_status", function () {
    $("select.case_status").attr("value", $(this).val())
    $("div.case_list_display").remove();

    switch (parseInt($("select.case_status").val())) {
        case 1:
            //GET NEW EVENT REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan/eventReport/selectNew",
                type: "GET",
                data: {},
                beforeSend: function () {

                },
                success: function (data) {
                    // console.log("123");
                    // console.log(data);
                    let event_repot_list = "";

                    $.each(data, function (index, item) {
                        //  console.log(item)
                        //  event_repot_list +=         '<h1>New Cases</h1>';
                        event_repot_list += '<div class="case_list_display">';
                        event_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.eventReportID + '">EVENT <a href="#" target="">' + item.eventReportID + '</a></div>';
                        event_repot_list += '<div class="case_content">case content</div>';
                        event_repot_list += '<div class="case_status">NEW</div>';
                        event_repot_list += '<div class="case_create_date">' + new Date(item.reportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }) + '</div>';
                        event_repot_list += '</div>';

                    })
                    $("div.case_list_body").append(event_repot_list);
                    // console.log($("div.case_number").data("casenumber"))
                }
            })

            //GET NEW MSG REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan//",
                type: "GET",
                data: {},
                beforeSend: function () {

                },
                success: function (data) {

                }
            })
            //GET NEW ARTICLE REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan//",
                type: "GET",
                data: {},
                beforeSend: function () {

                },
                success: function (data) {

                }
            })
            break;
        case 2:
            //GET DONE EVENT REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan/eventReport/selectDone",
                type: "GET",
                data: {},
                beforeSend: function () {

                },
                success: function (data) {
                    let event_repot_list = "";

                    $.each(data, function (index, item) {

                        event_repot_list += '<div class="case_list_display">';
                        event_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.eventReportID + '">EVENT <a href="#" target="">' + item.eventReportID + '</a></div>';
                        event_repot_list += '<div class="case_content">case content</div>';
                        event_repot_list += '<div class="case_status">NEW</div>';
                        event_repot_list += '<div class="case_create_date">' + new Date(item.reportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }) + '</div>';
                        event_repot_list += '</div>';

                    })
                    $("div.case_list_body").append(event_repot_list);
                }
            })

            //GET DONE MSG REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan//",
                type: "GET",
                data: {},
                beforeSend: function () {

                },
                success: function (data) {

                }
            })
            //GET DONE ARTICLE REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan//",
                type: "GET",
                data: {},
                beforeSend: function () {

                },
                success: function (data) {

                }
            })

            break;

    }
})
//================================================================================================================================

//===================================== ADMIN IFNORMATION =====================================
$(document).on("click", "button.admin_info", function (e) {
    console.log($(this).parents().find("main"))
    $(this).parents().find(".menu").children().remove();
    $(this).parents().find("main").children().remove();
    let admin_list = "";
    admin_list += '<div class="admin_information_body" name="admin_information">';
    admin_list += '<h1>Admin Information</h1>';
    admin_list += '<div class="admin_display">';
    admin_list += '<h3>Admin 1 <span class=""></span></h3>';
    admin_list += '<div class="admin_account">帳號：</div>';
    admin_list += '<div class="admin_name">姓名：</div>';
    admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    admin_list += '<div class="status_slide">';
    admin_list += '<input type="checkbox" value="None" id="1" name="check" checked />';
    admin_list += '<label class="slide" for="1"></label>';
    admin_list += '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list += '<h3>Admin 1 <span class=""></span></h3>';
    admin_list += '<div class="admin_account">帳號：</div>';
    admin_list += '<div class="admin_name">姓名：</div>';
    admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    admin_list += '<div class="status_slide">';
    admin_list += '<input type="checkbox" value="None" id="2" name="check" checked />';
    admin_list += '<label class="slide" for="2"></label>';
    admin_list += '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list += '<h3>Admin 1 <span class=""></span></h3>';
    admin_list += '<div class="admin_account">帳號：</div>';
    admin_list += '<div class="admin_name">姓名：</div>';
    admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    admin_list += '<div class="status_slide">';
    admin_list += '<input type="checkbox" value="None" id="3" name="check" checked />';
    admin_list += '<label class="slide" for="3"></label>';
    admin_list += '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list += '<h3>Admin 1 <span class=""></span></h3>';
    admin_list += '<div class="admin_account">帳號：</div>';
    admin_list += '<div class="admin_name">姓名：</div>';
    admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    admin_list += '<div class="status_slide">';
    admin_list += '<input type="checkbox" value="None" id="4" name="check" checked />';
    admin_list += '<label class="slide" for="4"></label>';
    admin_list += '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list += '<h3>Admin 1 <span class=""></span></h3>';
    admin_list += '<div class="admin_account">帳號：</div>';
    admin_list += '<div class="admin_name">姓名：</div>';
    admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    admin_list += '<div class="status_slide">';
    admin_list += '<input type="checkbox" value="None" id="5" name="check" checked />';
    admin_list += '<label class="slide" for="5"></label>';
    admin_list += '</div>';
    admin_list += '</div>';

    $("main").append(admin_list);
})

//===================================== CASE MANAGE =====================================
$(document).on("click", "button.report_management", function (e) {
    $(this).parents().find(".menu").children().remove();                 //應該會從session取回資料代入上方TAB區塊
    $(this).parents().find("main").children().remove();
    let list_html = "";
    // list_html += '<div class="menu" name="menu">';
    list_html += '<ul class="case_block">';
    list_html += '<select class="case_status">';
    list_html += '<option value="1">NEW</option>';
    // list_html +=            '<option value="2">WAITING</option>';
    // list_html +=            '<option value="3">UPDATE</option>';
    list_html += '<option value="2">DONE</option>';
    list_html += '</select>';
    list_html += '<div class="tab_container">';
    list_html += '</div>';
    list_html += '</ul>';
    list_html += '<div class="case_list_body">';
    list_html += '</div>';

    $(this).parents().find(".menu").append(list_html)
    //GET NEW EVENT REPORT
    $.ajax({
        url: "http://localhost:8081/shanshan/eventReport/selectNew",
        type: "GET",
        data: {},
        beforeSend: function () {

        },
        success: function (data) {
            // console.log("123");
            // console.log(data);
            let event_repot_list = "";

            $.each(data, function (index, item) {
                //  console.log(item)
                //  event_repot_list +=         '<h1>New Cases</h1>';
                event_repot_list += '<div class="case_list_display">';
                event_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.eventReportID + '">EVENT<a href="#" target="">' + item.eventReportID + '</a></div>';
                event_repot_list += '<div class="case_content">case content</div>';
                event_repot_list += '<div class="case_status">NEW</div>';
                event_repot_list += '<div class="case_create_date">' + new Date(item.reportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }) + '</div>';
                event_repot_list += '</div>';

            })
            $("div.case_list_body").append(event_repot_list);

        }
    })

    //GET NEW MSG REPORT
    $.ajax({
        url: "http://localhost:8081/shanshan//",
        type: "GET",
        data: {},
        beforeSend: function () {

        },
        success: function (data) {
            let msg_repot_list = "";
            $.each(data, function (index, time) {

            })
            $("div.case_list_body").append(msg_repot_list);
        }
    })
    //GET NEW ARTICLE REPORT
    $.ajax({
        url: "http://localhost:8081/shanshan//",
        type: "GET",
        data: {},
        beforeSend: function () {

        },
        success: function (data) {
            let article_repot_list = "";
            $.each(data, function (index, time) {

            })
            $("div.case_list_body").append(article_repot_list);
        }
    })

})

//===================================== STORE MANAGE =====================================
$(document).on("click", "button.store_management", function (e) {
    $(this).parents().find(".menu").children().remove();                 //應該會從session取回資料代入上方TAB區塊
    $(this).parents().find("main").children().remove();

    let sv_menu = "";
    sv_menu += '<ul class="store_tabs"></ul>'
    sv_menu += '<li class="store_verify" href="#store_verify" role="tab" data-toggle="tab">Store Verify</li>'
    sv_menu += '<li class="order_info" href="#order_info" role="tab" data-toggle="tab">Order Info</li>'
    sv_menu += '<li class="statistics" href="#statistics" role="tab" data-toggle="tab">Statistics</li>'
    sv_menu += '</ul>'

    // let sv_list = "";
    // sv_list += '<div class="store_manage_body" name="store_manage_body"></div>'
    // sv_list += '<div class="sv_selector"></div>'
    // sv_list += '<select class="svs_container"></select>'
    // sv_list += '<option>NEW</option>'
    // sv_list += '<option>WAITING</option>'
    // sv_list += '<option>DONE</option>'
    // sv_list += '</select>'
    // sv_list += '</div>'
    // sv_list += '<div class="sv_body"></div>'
    // sv_list += '<h1>New</h1>'
    // sv_list += '<div class="sv_display"></div>'
    // sv_list += '<div class="sv_status">NEW</div>'
    // sv_list += '<div class="store_name">山山</div>'
    // sv_list += '<div class="sv_create_date">2021.11.11 00:00:00</div>'
    // sv_list += '<button class="sv_detail">詳情</button>'
    // sv_list += '</div>'
    // sv_list += '</div>'
    // sv_list += '</div>'
    let sv_list = `
        <div class="store_manage_body" name="store_manage_body">
            <div class="sv_selector">
                <select class="svs_container">
                    <option>NEW</option>
                    <option>WAITING</option>
                    <option>DONE</option>
                </select>
            </div>

            <div class="sv_body">
                <h1>New</h1>
                <div class="sv_display">
                    <div class="sv_status">NEW</div>
                    <div class="store_name">山山</div>
                    <div class="sv_create_date">2021.11.11 00:00:00</div>
                    <button class="sv_detail">詳情</button>
                </div>
            </div>
        </div>
    `;

    $(this).parents().find(".menu").append(sv_menu);
    $(this).parents().find("main").html(sv_list);

})
//===================================================================================================================================
//=========================================================== CASE MANAGE ===========================================================
//===================================================================================================================================

//======= TABS =======
// $("a[href^='#']").on("click", function (e) {
//     e.preventDefault();
//     //return false;
// });

// $(document).on("click", "li.case_number", function (e) {
//     $(this).parent().find("li").each(function (index) {
//         if ($(this).parent().find("li").hasClass("-active")) {
//             $(this).removeClass("-active");
//         }
//     })
//     $(this).addClass("-active");
//     $(".page iframe").attr("src", $(this).find("a").attr("href"));
//     e.preventDefault();
// })

// $(document).on("click", ".tab_container li a.tab_close", function (e) {
//     $(this).closest("li").remove();
//     if ($(".tab_container li").size() == 0) {                         //沒有TAB時顯示所有NEW案件
//         // $(".tab_container").append('<li><span>New Tab</span><a class="close" href="#">x</a></li>')
//     }
// })

//======= DISPOSAL BTN =======
$(document).on("click", "button.send_disposal_btn", function () {

    if ($("input.report_accepted").is(":checked")) {
        let r = confirm("確認下架?")
        //=========== UPDATE EVENT REPORT STATUS AND CASE DONE ===========
        $.ajax({
            url: "http://localhost:8081/shanshan/eventReport/updateEventReport",
            type: "PUT",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify({
                "eventReportID": $("li").data("eventreportid"),
                "caseStatus": 2,
                "caseDone": new Date().toISOString()
            }),
            beforeSend: function () {

            },
            success: function (data) {
                //=========== UPDATE EVENT STATUS ===========
                $.ajax({
                    url: "http://localhost:8081/shanshan/event/updateEvent",
                    type: "PUT",
                    contentType: 'application/json',
                    dataType: "json",
                    data: JSON.stringify({
                        "eventId": $("div.case_ref_content").data("eventid"),
                        "eventStatus": 0
                    }),
                    beforeSend: function () {

                    },
                    success: function (data) {
                        $("div.event_report_lightbox").removeClass("-on");
                        $("div.article_report_lightbox").removeClass("-on");
                        $("div.msg_report_lightbox").removeClass("-on");

                    }
                })
            }
        })
        //=========== UPDATE ARTICLE REPORT STATUS AND CASE DONE ===========

        //=========== UPDATE EVENT MSG REPORT STATUS AND CASE DONE ===========

        //=========== UPDATE ARTICLE MSG REPORT STATUS AND CASE DONE ===========


        //=========== UPDATE ARTICLE STATUS ===========

        //=========== UPDATE EVENT MSG STATUS ===========

        //=========== UPDATE ARTICLE MSG STATUS ===========
    } else {
        //=========== UPDATE EVENT REPORT STATUS AND CASE DONE ===========
        $.ajax({
            url: "http://localhost:8081/shanshan/eventReport/updateEventReport",
            type: "PUT",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify({
                "eventReportID": $("li").data("eventreportid"),
                "caseStatus": 2,
                "caseDone": new Date().toISOString()
            }),
            beforeSend: function () {

            },
            success: function (data) {

            }
        })
        //=========== UPDATE ARTICLE REPORT STATUS AND CASE DONE ===========

        //=========== UPDATE EVENT MSG REPORT STATUS AND CASE DONE ===========

        //=========== UPDATE ARTICLE MSG REPORT STATUS AND CASE DONE ===========
    }

    // $(this).parent().find("input").each(function (index) {
    //     console.log($(this).hasClass("report_denied"))
    //     if ($(this).hasClass("report_denied")) {
    //         let r = confirm("確認上架?");
    //     } else {
    //         let r1 = confirm("確認下架?");
    //     }

    // })
})

//======= CHOOSE CASE =======
$(document).on("click", "div.case_list_display a", function (e) {
    let that = this;
    $("div.event_report_lightbox").addClass("-on")

    $.ajax({
        url: "http://localhost:8081/shanshan/eventReport/selectByIdtest",
        type: "GET",
        data: { "eventReportID": $(that).closest("div").data("casenumber") },
        beforeSend: function () {

        },
        success: function (data) {
            // console.log($(that).closest("div").data("casenumber"));
            let event_report_content = `
            <div class="case_info_block">
            <div class="case_info_title">
                Case Information
            </div>
            <ul>
                <li data-eventreportid="${data[0].eventReportID}">檢舉編號：${data[0].eventReportID}</li>
                <li>檢舉原因：${data[0].reportReason}</li>
                <li>檢舉人：${data[0].memberName}</li>
                <li>案件狀態：${data[0].caseStatus}</li>
                <li>案件開立時間：${new Date(data[0].reportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' })}</li>
                <li>案件完成時間：${new Date(data[0].caseDone).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' })}</li>
            </ul>
            <form>
                <p>處置：</p>
                <input class="report_denied" name="case_disposal" type="radio" id="report_denied">
                <label for="report_denied">上架</label>
                <input class="report_accepted" name="case_disposal" type="radio" id="report_accepted" value="0">
                <label for="report_accepted">下架</label>
            </form>
            <button class="send_disposal_btn">送出處置</button>
        </div>

        <div class="case_ref_block">
            <div class="case_ref_title">
                Reference
            </div>
            <div data-eventid="${data[0].eventId}" class="case_ref_content">
                <textarea>${data[0].eventContent}</textarea>
            </div>
        </div>
        <a class="lightbox-close" href="#"></a>
            `;
            $("div.event_report_lightbox").html(event_report_content)
        }
    })
})

//===================================================================================================================================
//=========================================================== DROP DOWN =============================================================
//===================================================================================================================================



// =================================================================================================
