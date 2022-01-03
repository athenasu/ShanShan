$(document).on("click", "a.lightbox-close", function () {
    $("div.event_report_lightbox").removeClass("-on");
    $("div.article_report_lightbox").removeClass("-on");
    $("div.msg_report_lightbox").removeClass("-on");
    $("div.store_verify_lightbox").removeClass("-on");
})
$(document).on("click", function () {
    $("div.event_report_lightbox").removeClass("-on");
    $("div.article_report_lightbox").removeClass("-on");
    $("div.msg_report_lightbox").removeClass("-on");
    $("div.store_verify_lightbox").removeClass("-on");
})
$(document).on("click", "div.event_report_lightbox", function (e) {
    e.stopPropagation();
})
$(document).on("click", "div.article_report_lightbox", function (e) {
    e.stopPropagation();
})
$(document).on("click", "div.msg_report_lightbox", function (e) {
    e.stopPropagation();
})
$(document).on("click", "div.store_verify_lightbox", function (e) {
    e.stopPropagation();
})

$(document).on("click", "input.report_accepted", function () {
    $(this).attr("checked", true);
    $("input.report_denied").attr("checked", false);
})
$(document).on("click", "input.report_denied", function () {
    $(this).attr("checked", true);
    $("input.report_accepted").attr("checked", false);
})
$(document).on("click", "input.denied", function () {
    $(this).attr("checked", true);
    $("input.pass").attr("checked", false);
})
$(document).on("click", "input.pass", function () {
    $(this).attr("checked", true);
    $("input.denied").attr("checked", false);
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
                        article_repot_list += '<div id= "case_number" class="case_number" data-casenumber="' + item.articleReportId + '">ARTICLE - ' + item.articleReportId + '</div>';
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
    admin_list += '<div class="admin_account">帳號：shanshan01@gmail.com</div>';
    admin_list += '<div class="admin_name">姓名：Owen</div>';
    admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    admin_list += '<div class="status_slide">';
    admin_list += '<input class="account_status" type="checkbox" value="None" id="1" name="check" checked />';
    admin_list += '<label class="slide" for="1"></label>';
    admin_list += '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list += '<h3>Admin 2 <span class=""></span></h3>';
    admin_list += '<div class="admin_account">帳號：shanshan02@gmail.com</div>';
    admin_list += '<div class="admin_name">姓名：Owen02</div>';
    admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    admin_list += '<div class="status_slide">';
    admin_list += '<input class="account_status" type="checkbox" value="None" id="2" name="check" checked />';
    admin_list += '<label class="slide" for="2"></label>';
    admin_list += '</div>';
    admin_list += '</div>';
    // admin_list += '<div class="admin_display">';
    // admin_list += '<h3>Admin 1 <span class=""></span></h3>';
    // admin_list += '<div class="admin_account">帳號：</div>';
    // admin_list += '<div class="admin_name">姓名：</div>';
    // admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    // admin_list += '<div class="status_slide">';
    // admin_list += '<input type="checkbox" value="None" id="3" name="check" checked />';
    // admin_list += '<label class="slide" for="3"></label>';
    // admin_list += '</div>';
    // admin_list += '</div>';
    // admin_list += '<div class="admin_display">';
    // admin_list += '<h3>Admin 1 <span class=""></span></h3>';
    // admin_list += '<div class="admin_account">帳號：</div>';
    // admin_list += '<div class="admin_name">姓名：</div>';
    // admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    // admin_list += '<div class="status_slide">';
    // admin_list += '<input type="checkbox" value="None" id="4" name="check" checked />';
    // admin_list += '<label class="slide" for="4"></label>';
    // admin_list += '</div>';
    // admin_list += '</div>';
    // admin_list += '<div class="admin_display">';
    // admin_list += '<h3>Admin 1 <span class=""></span></h3>';
    // admin_list += '<div class="admin_account">帳號：</div>';
    // admin_list += '<div class="admin_name">姓名：</div>';
    // admin_list += '<div class="admin_account_status">帳號狀態：</div>';
    // admin_list += '<div class="status_slide">';
    // admin_list += '<input type="checkbox" value="None" id="5" name="check" checked />';
    // admin_list += '<label class="slide" for="5"></label>';
    // admin_list += '</div>';
    // admin_list += '</div>';
    admin_list += '</div>';
    $("main").append(admin_list);
})

$(document).on("change", "input.account_status", function(){
    let r = confirm("確認取消管理員資格?")
    if(r == true){
        $(this).removeAttr("checked");
    }
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
$(document).on("click", "li.store_verify", function () {
    $("main").children().remove();
    // $(this).parents().find(".menu").children().remove();

    // let sv_menu = "";
    // sv_menu += '<ul class="store_tabs"></ul>'
    // sv_menu += '<li class="store_verify" href="#store_verify" role="tab" data-toggle="tab">Store Verify</li>'
    // // sv_menu += '<li class="order_info" href="#order_info" role="tab" data-toggle="tab">Order Info</li>'
    // sv_menu += '<li class="statistics" href="#statistics" role="tab" data-toggle="tab">Statistics</li>'
    // sv_menu += '</ul>';
    // $(this).parents().find(".menu").append(sv_menu);

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
})
$(document).on("click", "button.store_management", function (e) {
    $(this).parents().find(".menu").children().remove();
    $(this).parents().find("main").children().remove();

    let sv_menu = "";
    sv_menu += '<ul class="store_tabs"></ul>'
    sv_menu += '<li class="store_verify" href="#store_verify" role="tab" data-toggle="tab">商家審核</li>'
    // sv_menu += '<li class="order_info" href="#order_info" role="tab" data-toggle="tab">Order Info</li>'
    sv_menu += '<li class="statistics" href="#statistics" role="tab" data-toggle="tab">營收統計</li>'
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
                if (item.companyStatus == 0) {
                    sv_list += '<div class="sv_display" data-companyid="' + item.companyId + '">';
                    sv_list += '<div class="sv_status">NEW</div>';
                    sv_list += '<div class="store_name">' + item.companyName + '</div>';
                    sv_list += '<div class="sv_create_date">' + new Date(item.companyRegisterDate) + '</div>';
                    sv_list += '<button class="sv_detail">詳情</button>';
                    sv_list += '</div>';
                }
            })
            $("div.sv_body").append(sv_list);
        }
    })

    $(document).on("click", "button.sv_detail", function (e) {
        $("div.store_verify_lightbox").addClass("-on")
        e.stopPropagation()
        let that = this
        $.ajax({
            url: "../company/findByPK",
            type: "GET",
            data: { "companyId": $(that).parent().data("companyid") },
            beforeSend: function () {

            },
            success: function (data) {
                // var bytes = new Uint8Array(data.companyCetificate);
                // var blob = new Blob([bytes], { type: "image/png" });
                // var url = URL.createObjectURL(blob);

                const bytesStr = atob(data.companyCetificate);
                let len = bytesStr.length;
                const u8Array = new Uint8Array(len);
                while (len--) {
                    u8Array[len] = bytesStr.charCodeAt(len);
                }
                const blob = new Blob([u8Array]);
                const url = URL.createObjectURL(blob);

                let verifyContent = `
                        <div class="verify_content">
                            <h3>店家申請資料</h3>
                            <li>帳號：${data.companyEmail}</li>
                            <li>店家名稱：${data.companyName}</li>
                            <li class="company_id" data-companyid="${data.companyId}">店家編號：${data.companyId}</li>
                            <li>負責人：${data.companyOwner}</li>
                            <li>手機：${data.companyCell}</li>
                            <li>電話：${data.companyPhone}</li>
                            <li>地址：${data.companyAddress}</li>
                            <li>店家介紹：${data.companyIntro}</li>
                            <li>註冊日期：${new Date(data.companyRegisterDate)}</li>
                            <div class="verification">
                        	    <input class="pass" name="verification" type="radio" id="pass">
                    			<label for="pass">上架</label>
                    		    <input class="denied" name="verification" type="radio" id="denied" value="0">
                    			<label for="denied">下架</label>
                        	    <button class = "send_verification">送出</button>
                            </div>
                        </div>
                        <div class= "verify_pic">
                        	<img class="store_pic" src="${url}">
                        </div>
                        
                        <a class="lightbox-close" href="#"></a>
            `
                $("div.store_verify_lightbox").html(verifyContent);
            }
        })
    })
})

$(document).on("click", "button.send_verification", function () {
    console.log($("li.company_id").data("companyid"))
    if ($("input.pass").is(":checked")) {
        let r = confirm("確認上架?")

        if (r == true) {
            $.ajax({
                url: "../company/updateStatus",
                type: "POST",
                contentType: 'application/json',
                dataType: "json",
                data: JSON.stringify({
                    "companyId": $("li.company_id").data("companyid"),
                    "companyStatus": 1
                }),
                beforeSend: function () {

                },
                success: function (data) {
                    $("div.event_report_lightbox").removeClass("-on");
                    $("div.article_report_lightbox").removeClass("-on");
                    $("div.msg_report_lightbox").removeClass("-on");
                    $("div.store_verify_lightbox").removeClass("-on");
                }
            })
        }

    } else if ($("input.denied").is(":checked")) {
        let r1 = confirm("確認下架?")
        if (r1 == true) {
            $.ajax({
                url: "../company/updateStatus",
                type: "POST",
                contentType: 'application/json',
                dataType: "json",
                data: JSON.stringify({
                    "companyId": $("li.company_id").data("companyid"),
                    "companyStatus": 2
                }),
                beforeSend: function () {

                },
                success: function (data) {
                    $("div.event_report_lightbox").removeClass("-on");
                    $("div.article_report_lightbox").removeClass("-on");
                    $("div.msg_report_lightbox").removeClass("-on");
                    $("div.store_verify_lightbox").removeClass("-on");
                }
            })
        }
    }
})
//===================================================================================================================================
//=========================================================== CASE MANAGE ===========================================================
//===================================================================================================================================

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
                                $("div.store_verify_lightbox").removeClass("-on");
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
    e.stopPropagation()
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
//=========================================================== STATICS =============================================================
//===================================================================================================================================
$(document).on("click", "li.statistics", function () {
    $("main").children().remove();;
    $("main").append(`
        <div class="static_chart">
            <lable>開始日期： </lable>
            <input class="start_date" type="date">
            <lable>結束日期： </lable>
            <input class="end_date" type="date">
            <button class="analyze">開始統計</button>
        </div>

        <div class="statics">
            <div class="current_month_profit">
                <span>區間營收：<span class="profit"></span></span>
            </div>
            <div class="current_month_orders">
                <span>區間訂單：</span>
                <table class="order_table">
                    <tr>
                        <td>店家編號</td>
                        <td>訂單編號</td>
                        <td>購買人姓名</td>
                        <td>折扣前金額</td>
                        <td>折扣後金額</td>
                        <td>使用點數</td>
                        <td>出貨編號</td>
                        <td>出貨時間</td>
                    </tr>
                </table>
            </div>
        </div>`
    )
})
// $(document).ready(function () {
$(document).on("click", "button.analyze", function () {
    //GET ORDERS OF CURRENT MONTH
    // var fromDate = $("input.start_date").val().toString();
    // var toDate = $("input.end_date").val().toString();
    var fromDate = $("input.start_date").val();
    var toDate = $("input.end_date").val();
    // console.log(typeof (fromDate));
    // console.log(fromDate);
    // console.log(typeof (toDate));
    // console.log(toDate);

    $.ajax({
        url: `../admin/findAllByDateRangePayStatus?fromDate=${fromDate}&toDate=${toDate}&paymentStatus=1`,
        type: "GET",
        contentType: 'application/json',
        // data: JSON.stringify({
        //     "from_date": fromDate,
        //     "to_date": toDate,
        //     "payment_status": 5
        // }),
        beforeSend: function () {

        },
        success: function (data) {
            console.log(data)
            $("table.order_table").children().remove();
            let order_list = `
                <tr>
                    <td>店家編號</td>
                    <td>訂單編號</td>
                    <td>購買人姓名</td>
                    <td>折扣前金額</td>
                    <td>折扣後金額</td>
                    <td>使用點數</td>
                    <td>出貨編號</td>
                    <td>出貨時間</td>
                </tr>`;
            let sum = 0;

            $.each(data, function (index, item) {

                order_list += "<tr>";
                order_list += "<td>" + item.companyId + "</td>";
                order_list += "<td>" + item.orderId + "</td>";
                order_list += "<td>" + item.orderMemberName + "</td>";
                order_list += "<td>" + item.orderSumBefore + "</td>";
                order_list += "<td>" + item.orderSumAfter + "</td>";
                order_list += "<td>" + item.pointUsed + "</td>";
                order_list += "<td>" + item.shipNumber + "</td>";
                order_list += "<td>" + new Date(item.orderShippedDate).toLocaleDateString() + "</td>";
                order_list += "<tr>";

                sum += item.orderSumAfter;
            })
            $("table.order_table").append(order_list);
            $("span.profit").html(sum);
        }
    })

    // function getMonthBetween(fromDate, toDate) {
    //     //初始化数组
    //     var result = [];
    //     //切割起始年月
    //     var s = start.split("-");
    //     //切割结束年月
    //     var e = end.split("-");
    //     //获取时间对象
    //     var min = new Date();
    //     var max = new Date();
    //     //设置起始时间
    //     min.setFullYear(s[0], s[1]);
    //     //设置结束时间
    //     max.setFullYear(e[0], e[1]);

    //     //复制一份起始时间对象
    //     var curr = min;
    //     //定义字符串
    //     var str = "";
    //     //起始时间在结束时间之前
    //     while (curr <= max) {
    //         //获取此时间的月份
    //         var month = curr.getMonth();
    //         //如果月份为0，也就是代表12月份
    //         if (month === 0) {
    //             str = (curr.getFullYear() - 1) + "-" + 12;
    //         } else {//正常月份
    //             str = curr.getFullYear() + "-" + (month < 10 ? ("0" + month) : month);
    //         }
    //         //将此年月加入数组
    //         result.push(str);
    //         //更新此时间月份
    //         curr.setMonth(month + 1);
    //     }
    //     return result;
    // }
    // console.log($("input.start_date").val().slice(0, 4)); //取年
    // console.log($("input.start_date").val().slice(5, 7)); //取月
    // console.log($("input.start_date").val().slice(8, 10)); //取日

    // console.log($("input.end_date").val().slice(0, 4));
    // console.log($("input.end_date").val().slice(5, 7));
    // console.log($("input.end_date").val().slice(8, 10));



    // var ctx = $("#myChart");
    // var chart = new Chart(ctx, {
    //     type: "bar",
    //     data: {
    //         labels: ["2020/02/17", "", "2020/02/23", "", "2020/02/29", ""],
    //         datasets: [
    //             {
    //                 type: "bar",
    //                 backgroundColor: "rgba(54, 162, 235, 0.2)",
    //                 borderColor: "rgba(54, 162, 235, 1)",
    //                 borderWidth: 1,
    //                 label: "標籤一",
    //                 data: [60, 49, 72, 90, 100, 60]
    //             },
    //             {
    //                 type: "line",
    //                 label: "標籤二",
    //                 data: [25, 13, 30, 35, 25, 40],
    //                 lineTension: 0, // 曲線的彎度，設 0 表示直線
    //                 fill: true // 是否填滿色彩
    //             }
    //         ]
    //     }
    // });

})

// })



// =================================================================================================
