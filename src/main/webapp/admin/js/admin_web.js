$(document).on("click", "a.lightbox-close", function () {
    $("div.event_report_lightbox").removeClass("-on");
    $("div.article_report_lightbox").removeClass("-on");
    $("div.msg_report_lightbox").removeClass("-on");
    $("div.store_verify_lightbox").removeClass("-on");
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
                url: "../eventReport/selectNew",
                type: "GET",
                data: {},
                beforeSend: function () {

                },
                success: function (data) {

                    let event_repot_list = "";

                    $.each(data, function (index, item) {

                        event_repot_list += '<div class="case_list_display event">';
                        event_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.eventReportID + '">EVENT - ' + item.eventReportID + '</div>';
                        event_repot_list += '<div class="case_content">case content</div>';
                        event_repot_list += '<div class="case_status">NEW</div>';
                        event_repot_list += '<div class="case_create_date">' + new Date(item.reportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }) + '</div>';
                        event_repot_list += '</div>';

                    })
                    $("div.case_list_body").append(event_repot_list);

                }
            })

            //GET NEW MSG REPORT
            //            $.ajax({
            //                url: "http://localhost:8081/shanshan//",
            //                type: "GET",
            //                data: {},
            //                beforeSend: function () {
            //
            //                },
            //                success: function (data) {
            //
            //                }
            //            })
            //GET NEW ARTICLE REPORT
            $.ajax({
                url: "../admin/findArticleReportByStatus",
                type: "GET",
                data: { "articleReportStatus": 1 },
                beforeSend: function () {

                },
                success: function (data) {
                    let article_repot_list = "";
                    console.log(data);
                    $.each(data, function (index, item) {
                        article_repot_list += '<div class="case_list_display article">';
                        article_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.articleReportId + '">ARTICLE - ' + item.articleReportId + '</div>';
                        article_repot_list += '<div class="case_content">case content</div>';
                        article_repot_list += '<div class="case_status">NEW</div>';
                        article_repot_list += '<div class="case_create_date">' + new Date(item.articleReportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }) + '</div>';
                        article_repot_list += '</div>';
                    })
                    $("div.case_list_body").append(article_repot_list);
                }
            })
            break;
        case 2:
            //GET DONE EVENT REPORT
            $.ajax({
                url: "../eventReport/selectDone",
                type: "GET",
                data: {},
                beforeSend: function () {

                },
                success: function (data) {
                    let event_repot_list = "";

                    $.each(data, function (index, item) {

                        event_repot_list += '<div class="case_list_display event">';
                        event_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.eventReportID + '">EVENT - ' + item.eventReportID + '</div>';
                        event_repot_list += '<div class="case_content">case content</div>';
                        event_repot_list += '<div class="case_status">DONE</div>';
                        event_repot_list += '<div class="case_create_date">' + new Date(item.reportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }) + '</div>';
                        event_repot_list += '</div>';

                    })
                    $("div.case_list_body").append(event_repot_list);
                }
            })

            //GET DONE MSG REPORT
            //            $.ajax({
            //                url: "http://localhost:8081/shanshan//",
            //                type: "GET",
            //                data: {},
            //                beforeSend: function () {
            //
            //                },
            //                success: function (data) {
            //
            //                }
            //            })
            //GET DONE ARTICLE REPORT
            $.ajax({
                url: "../admin/findArticleReportByStatus",
                type: "GET",
                data: { "articleReportStatus": 2 },
                beforeSend: function () {

                },
                success: function (data) {
                    let article_repot_list = "";
                    console.log(data);
                    $.each(data, function (index, item) {
                        article_repot_list += '<div class="case_list_display article">';
                        article_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.articleReportId + '">ARTICLE - ' + item.articleReportIdd + '</div>';
                        article_repot_list += '<div class="case_content">case content</div>';
                        article_repot_list += '<div class="case_status">DONE</div>';
                        article_repot_list += '<div class="case_create_date">' + new Date(item.articleReportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }) + '</div>';
                        article_repot_list += '</div>';
                    })
                    $("div.case_list_body").append(article_repot_list);
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
    $(this).parents().find(".menu").children().remove();
    $(this).parents().find("main").children().remove();
    let list_html = "";
    // list_html += '<div class="menu" name="menu">';
    list_html += '<ul class="case_block">';
    list_html += '<select class="case_status">';
    list_html += '<option value="1">NEW</option>';
    list_html += '<option value="2">DONE</option>';
    list_html += '</select>';
    list_html += '</ul>';

    $("main").html("<div class='case_list_body'></div>")
    $(this).parents().find(".menu").append(list_html)
    //GET NEW EVENT REPORT
    $.ajax({
        url: "../eventReport/selectNew",
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
                event_repot_list += '<div class="case_list_display event">';
                event_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.eventReportID + '">EVENT - ' + item.eventReportID + '</div>';
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
            $.each(data, function (index, item) {

            })
            $("div.case_list_body").append(msg_repot_list);
        }
    })
    //GET NEW ARTICLE REPORT
    $.ajax({
        url: "../admin/findArticleReportByStatus",
        type: "GET",
        data: { "articleReportStatus": 1 },
        beforeSend: function () {

        },
        success: function (data) {
            let article_repot_list = "";
            console.log(data);
            $.each(data, function (index, item) {
                article_repot_list += '<div class="case_list_display article">';
                article_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.articleReportId + '">ARTICLE - ' + item.articleReportId + '</div>';
                article_repot_list += '<div class="case_content">case content</div>';
                article_repot_list += '<div class="case_status">NEW</div>';
                article_repot_list += '<div class="case_create_date">' + new Date(item.articleReportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' }) + '</div>';
                article_repot_list += '</div>';
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
    sv_menu += '</ul>';
    $(this).parents().find(".menu").append(sv_menu);

    let sv_main = "";
    sv_main += '<div class="sv_body">';
    sv_main += '<h1>尚未審核店家</h1>';
    sv_main += '</div>';
    $("main").append(sv_main);

    $.ajax({
        url: "../company/findAllCompany",
        type: "GET",
        data: {},
        beforeSend: function () {

        },
        success: function (data) {
            console.log(data)

            let sv_list = "";
            $.each(data, function (index, item) {
                sv_list += '<div class="sv_display" data-companyid="' + item.companyId + '">';
                sv_list += '<div class="sv_status">NEW</div>';
                sv_list += '<div class="store_name">' + item.companyName + '</div>';
                sv_list += '<div class="sv_create_date">' + new Date(item.companyRegisterDate) + '</div>';
                sv_list += '<button class="sv_detail">詳情</button>';
                sv_list += '</div>';
            })
            $("div.sv_body").append(sv_list);
        }
    })

    $(document).on("click", "button.sv_detail", function () {
        $("div.store_verify_lightbox").addClass("-on")
        let that = this
        $.ajax({
            url: "../company/findByPK",
            type: "GET",
            data: { "companyId": $(that).parent().data("companyid") },
            beforeSend: function () {

            },
            success: function (data) {
//                var bytes = new Uint8Array(data.picStr);
//                var blob = new Blob([bytes], { type: "image/png" });
                // var url = URL.createObjectURL(data.picStr);
                let verifyContent = `
                        <div class="verify_content">
                            <h3>店家申請資料</h3>
                            <li>帳號：${data.companyEmail}</li>
                            <li>店家名稱：${data.companyName}</li>
                            <li>店家編號：${data.companyId}</li>
                            <li>負責人：${data.companyId}</li>
                            <li>手機：${data.companyCell}</li>
                            <li>電話：${data.companyPhone}</li>
                            <li>地址：${data.companyAddress}</li>
                            <li>店家介紹：${data.companyIntro}</li>
                            <li>註冊日期：${new Date(data.companyRegisterDate)}</li>
                            
                        </div>
                        <div class= "verify_pic">
                        	<img class="store_pic" src="">
                        </div>
                        <div class="verification">
                        	<input class="pass" name="verification" type="radio" id="pass">
                    			<label for="pass">上架</label>
                    		<input class="denied" name="verification" type="radio" id="denied" value="0">
                    			<label for="denied">下架</label>
                        	<button class = "send_virification">送出</button>
                        </div>                        
                        <a class="lightbox-close" href="#"></a>
            `
            $("div.store_verify_lightbox").html(verifyContent);
            }
        })
    })

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

        if (r == true) {
            //=========== UPDATE EVENT REPORT STATUS AND CASE DONE ===========
            if ($("li").data("type") == "event") {
                $.ajax({
                    url: "../eventReport/updateEventReport",
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
                            url: "../event/updateEvent",
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
            } else if ($("li").data("type") == "article") {
                $.ajax({
                    url: "../articleReport/changeStatus",
                    type: "POST",
                    contentType: 'application/json',
                    dataType: "json",
                    data: JSON.stringify({
                        // "eventReportID": $("li").data("eventreportid"),
                        // "caseStatus": 2,
                        // "caseDone": new Date().toISOString()
                        "article_report_id": $("li").data("articlereportid"),
                        "article_report_status": 2,
                        "case_done": new Date().toISOString()
                    }),
                    beforeSend: function () {

                    },
                    success: function (data) {
                        //=========== UPDATE ARTICLE STATUS ===========
                        $.ajax({
                            url: "../admin/updateArticle",
                            type: "PUT",
                            contentType: 'application/json',
                            dataType: "json",
                            data: JSON.stringify({
                                "articleId": $("div.case_ref_content").data("articleid"),
                                "articleStatus": 2
                            }),
                            beforeSend: function () {

                            },
                            success: function (data) {
                                console.log(data);
                                $("div.event_report_lightbox").removeClass("-on");
                                $("div.article_report_lightbox").removeClass("-on");
                                $("div.msg_report_lightbox").removeClass("-on");

                            }
                        })
                    }
                })
            } else {
                //=========== UPDATE EVENT MSG REPORT STATUS AND CASE DONE ===========

                //=========== UPDATE ARTICLE MSG REPORT STATUS AND CASE DONE ===========

                //=========== UPDATE EVENT MSG STATUS ===========

                //=========== UPDATE ARTICLE MSG STATUS ===========
            }
        }
    } else {
        //=========== UPDATE EVENT REPORT STATUS AND CASE DONE ===========
        $.ajax({
            url: "../eventReport/updateEventReport",
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
$(document).on("click", "div.case_list_display", function (e) {
    let that = this;
    console.log($(this).closest("div.case_list_display"))
    if ($(this).closest("div.case_list_display").hasClass("article")) {
        console.log("this is article report")
        $("div.article_report_lightbox").addClass("-on")
        $.ajax({
            url: "../admin/findArticleReportById",
            type: "GET",
            data: { "articleReportId": $(that).children().data("casenumber") },
            beforeSend: function () {

            },
            success: function (data) {
                // console.log($(that).closest("div").data("casenumber"));
                console.log(data);
                let article_report_content = `
                <div class="case_info_block">
                <div class="case_info_title">
                    Case Information
                </div>
                <ul>
                    <li data-type="article" data-articlereportid="${data[0].articleReportId}">檢舉編號：${data[0].articleReportId}</li>
                    <li>檢舉原因：${data[0].articleReportReason}</li>
                    <li>檢舉人：${data[0].memberName}</li>
                    <li>案件狀態：${data[0].articleReportStatus}</li>
                    <li>案件開立時間：${new Date(data[0].articleReportDate).toLocaleDateString('fr-CA', { year: 'numeric', month: '2-digit', day: '2-digit' })}</li>
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
                <div data-articleid="${data[0].articleId}" class="case_ref_content">
                    <textarea readonly="readonly">${data[0].articleContent}</textarea>
                </div>
            </div>
            <a class="lightbox-close" href="#"></a>
                `;
                $("div.article_report_lightbox").html(article_report_content)
            }
        })
    } else if ($(this).closest("div.case_list_display").hasClass("event")) {
        console.log("this is event report")
        $("div.event_report_lightbox").addClass("-on")

        $.ajax({
            url: "../eventReport/selectByIdtest",
            type: "GET",
            data: { "eventReportID": $(that).children().data("casenumber") },
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
                    <li data-type="event" data-eventreportid="${data[0].eventReportID}">檢舉編號：${data[0].eventReportID}</li>
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
                    <textarea readonly="readonly">${data[0].eventContent}</textarea>
                </div>
            </div>
            <a class="lightbox-close" href="#"></a>
                `;
                $("div.event_report_lightbox").html(event_report_content)
            }
        })
    } else {
        console.log("this is msg report")
    }




})

//===================================================================================================================================
//=========================================================== DROP DOWN =============================================================
//===================================================================================================================================



// =================================================================================================
