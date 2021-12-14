//================================================================================================================================
//=========================================================== SIDE BAR ===========================================================
//================================================================================================================================
//================================================================================================================================


//================================================================================================================================
$(document).on("change", "select.case_status", function(){
    $("select.case_status").attr("value", $(this).val())
    console.log($("select.case_status"))
    switch(parseInt($("select.case_status").val())){
        case 1:
            //GET NEW EVENT REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan/eventReport/selectNew",
                type: "GET",
                data: {},
                beforeSend: function(){

                },
                success: function(data){
                    // console.log("123");
                    // console.log(data);
                    let event_repot_list = "";

                    $.each(data, function(index, item){
                     console.log(item)
                    //  event_repot_list +=         '<h1>New Cases</h1>';
                     event_repot_list +=         '<div class="case_list_display">';
                     event_repot_list +=             '<div class="case_number"><a href="#" target="">'+item.eventReportID+'</a></div>';
                     event_repot_list +=             '<div class="case_content">case content</div>';
                     event_repot_list +=             '<div class="case_status">NEW</div>';
                     event_repot_list +=             '<div class="case_create_date">'+new Date(item.reportDate)+'</div>';
                     event_repot_list +=         '</div>';

                    })
                    $("div.case_list_body").html(event_repot_list);

                }
            })

            //GET NEW MSG REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan//",
                type: "GET",
                data: {},
                beforeSend: function(){

                },
                success: function(data){
                    
                }
            })
            //GET NEW ARTICLE REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan//",
                type: "GET",
                data: {},
                beforeSend: function(){

                },
                success: function(data){
                    
                }
            })
            break;
        case 2:
            //GET DONE EVENT REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan/eventReport/selectDone",
                type: "GET",
                data: {},
                beforeSend: function(){

                },
                success: function(data){
                    
                }
            })

            //GET DONE MSG REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan//",
                type: "GET",
                data: {},
                beforeSend: function(){

                },
                success: function(data){
                    
                }
            })
            //GET DONE ARTICLE REPORT
            $.ajax({
                url: "http://localhost:8081/shanshan//",
                type: "GET",
                data: {},
                beforeSend: function(){

                },
                success: function(data){
                    
                }
            })

            break;

    }
})
//================================================================================================================================

//===================================== ADMIN IFNORMATION =====================================
$(document).on("click", "button.admin_info", function(e){
    console.log($(this).parents().find("main"))
    $(this).parents().find(".menu").children().remove();
    $(this).parents().find("main").children().remove();
    let admin_list = "";
    admin_list += '<div class="admin_information_body" name="admin_information">';
    admin_list += '<h1>Admin Information</h1>';
    admin_list += '<div class="admin_display">';
    admin_list +=   '<h3>Admin 1 <span class=""></span></h3>';
    admin_list +=   '<div class="admin_account">帳號：</div>';
    admin_list +=   '<div class="admin_name">姓名：</div>';
    admin_list +=   '<div class="admin_account_status">帳號狀態：</div>';
    admin_list +=   '<div class="status_slide">';
    admin_list +=       '<input type="checkbox" value="None" id="status_slide" name="check" checked />';
    admin_list +=       '<label class="slide" for="status_slide"></label>';
    admin_list +=   '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list +=   '<h3>Admin 1 <span class=""></span></h3>';
    admin_list +=   '<div class="admin_account">帳號：</div>';
    admin_list +=   '<div class="admin_name">姓名：</div>';
    admin_list +=   '<div class="admin_account_status">帳號狀態：</div>';
    admin_list +=   '<div class="status_slide">';
    admin_list +=       '<input type="checkbox" value="None" id="status_slide" name="check" checked />';
    admin_list +=       '<label class="slide" for="status_slide"></label>';
    admin_list +=   '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list +=   '<h3>Admin 1 <span class=""></span></h3>';
    admin_list +=   '<div class="admin_account">帳號：</div>';
    admin_list +=   '<div class="admin_name">姓名：</div>';
    admin_list +=   '<div class="admin_account_status">帳號狀態：</div>';
    admin_list +=   '<div class="status_slide">';
    admin_list +=       '<input type="checkbox" value="None" id="status_slide" name="check" checked />';
    admin_list +=       '<label class="slide" for="status_slide"></label>';
    admin_list +=   '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list +=   '<h3>Admin 1 <span class=""></span></h3>';
    admin_list +=   '<div class="admin_account">帳號：</div>';
    admin_list +=   '<div class="admin_name">姓名：</div>';
    admin_list +=   '<div class="admin_account_status">帳號狀態：</div>';
    admin_list +=   '<div class="status_slide">';
    admin_list +=       '<input type="checkbox" value="None" id="status_slide" name="check" checked />';
    admin_list +=       '<label class="slide" for="status_slide"></label>';
    admin_list +=   '</div>';
    admin_list += '</div>';
    admin_list += '<div class="admin_display">';
    admin_list +=   '<h3>Admin 1 <span class=""></span></h3>';
    admin_list +=   '<div class="admin_account">帳號：</div>';
    admin_list +=   '<div class="admin_name">姓名：</div>';
    admin_list +=   '<div class="admin_account_status">帳號狀態：</div>';
    admin_list +=   '<div class="status_slide">';
    admin_list +=       '<input type="checkbox" value="None" id="status_slide" name="check" checked />';
    admin_list +=       '<label class="slide" for="status_slide"></label>';
    admin_list +=   '</div>';
    admin_list += '</div>';

    $("main").append(admin_list);
})

//===================================== CASE MANAGE =====================================
$(document).on("click", "button.report_management", function(e){
    $(this).parents().find(".menu").children().remove();                 //應該會從session取回資料代入上方TAB區塊
    $(this).parents().find("main").children().remove();             
    let list_html = "";
    // list_html += '<div class="menu" name="menu">';
    list_html +=    '<ul class="case_block">';
    list_html +=        '<select class="case_status">';
    list_html +=            '<option value="1">NEW</option>';
    list_html +=            '<option value="2">WAITING</option>';
    list_html +=            '<option value="3">UPDATE</option>';
    list_html +=            '<option value="4">DONE</option>';
    list_html +=        '</select>';
    list_html +=        '<div class="tab_container">';
    list_html +=        '</div>';
    list_html +=    '</ul>';
    // list_html += '<hr>'; //這hr有重複加入的問題待解決
    list_html +=    '<div class="case_list_body">';
    // list_html +=         '<h1>New Cases</h1>';
    // list_html +=         '<div class="case_list_display">';
    // list_html +=             '<div class="case_number"><a href="#" target="">123456</a></div>';
    // list_html +=             '<div class="case_content">case content</div>';
    // list_html +=             '<div class="case_status">NEW</div>';
    // list_html +=             '<div class="case_create_date">2021.10.30 00:00:00</div>';
    // list_html +=         '</div>';
    list_html +=    '</div>';
 
    $(this).parents().find(".menu").append(list_html)

})

//===================================== STORE MANAGE =====================================
$(document).on("click", "button.store_management", function(e){
    $(this).parents().find(".menu").children().remove();                 //應該會從session取回資料代入上方TAB區塊
    $(this).parents().find("main").children().remove();

    let sv_menu = "";
    sv_menu +=         '<ul class="store_tabs"></ul>'
    sv_menu +=             '<li class="store_verify" href="#store_verify" role="tab" data-toggle="tab">Store Verify</li>'
    sv_menu +=             '<li class="order_info" href="#order_info" role="tab" data-toggle="tab">Order Info</li>'
    sv_menu +=             '<li class="statistics" href="#statistics" role="tab" data-toggle="tab">Statistics</li>'
    sv_menu +=         '</ul>'

    let sv_list = "";
    sv_list +=         '<div class="store_manage_body" name="store_manage_body"></div>'
    sv_list +=             '<div class="sv_selector"></div>'
    sv_list +=                 '<select class="svs_container"></select>'
    sv_list +=                     '<option>NEW</option>'
    sv_list +=                     '<option>WAITING</option>'
    sv_list +=                     '<option>DONE</option>'
    sv_list +=                 '</select>'
    sv_list +=             '</div>'
    sv_list +=             '<div class="sv_body"></div>'
    sv_list +=                 '<h1>New</h1>'
    sv_list +=                 '<div class="sv_display"></div>'
    sv_list +=                     '<div class="sv_status">NEW</div>'
    sv_list +=                     '<div class="store_name">山山</div>'
    sv_list +=                     '<div class="sv_create_date">2021.11.11 00:00:00</div>'
    sv_list +=                     '<button class="sv_detail">詳情</button>'
    sv_list +=                 '</div>'
    sv_list +=             '</div>'
    sv_list +=         '</div>'

    $(this).parents().find(".menu").append(sv_menu);
    $(this).parents().find("main").append(sv_list);

})
//===================================================================================================================================
//=========================================================== CASE MANAGE ===========================================================
//===================================================================================================================================

//======= TABS =======
$("a[href^='#']").on("click", function(e){
    e.preventDefault();
    //return false;
  });

$(document).on("click","li.case_number" , function(e){
    $(this).parent().find("li").each(function(index){
        if($(this).parent().find("li").hasClass("-active")){
            $(this).removeClass("-active");
        }
    })
    $(this).addClass("-active");
    $(".page iframe").attr("src", $(this).find("a").attr("href"));
    e.preventDefault();
})

$(document).on("click",".tab_container li a.tab_close", function(e){
    $(this).closest("li").remove();
    if($(".tab_container li").size() == 0){                         //沒有TAB時顯示所有NEW案件
        // $(".tab_container").append('<li><span>New Tab</span><a class="close" href="#">x</a></li>')
    }
})

//======= DISPOSAL BTN =======
$(document).on("click", "button.send_disposal_btn", function(){
    $(this).parent().find("input").each(function(index){
        console.log($(this).hasClass("report_denied"))
        if($(this).hasClass("report_denied")){
            let r = confirm("確認上架?");
        }else{
            let r1 = confirm("確認下架?");
        }

    })
})

//======= CHOOSE CASE =======
$(document).on("click", "div.case_list_display a", function(e){
    // console.log($(this)[0].text);
    var that = this;
    let tab_list = "";
    tab_list += '<li class="case_number -active">';
    tab_list +=     '<span data-target="case" class="tab">'+ $(this)[0].text +'</span>';
    tab_list +=     '<a class="tab_close" href="#">x</a>';
    tab_list += '</li>';
    //缺少判斷上方TAB 是否已有此案件編號 
    $(this).parents().find(".tab_container").append(tab_list);
    
    
    $(".case_list_body").remove();      //將下方main 標籤中的內容清空以加入以下案件內容
    let case_content = ""
    case_content +='<div class="case_content">'
    case_content +='<div class="case_info_block">'
    case_content +='<div class="case_info_title">Case Information</div>'
    case_content +='<ul>'
    case_content +='<li>檢舉編號：</li>'
    case_content +='<li>檢舉原因：</li>'
    case_content +='<li>檢舉人：</li>'
    case_content +='<li>案件狀態：</li>'
    case_content +='<li>案件開立時間：</li>'
    case_content +='<li>案件完成時間：</li>'
    case_content +='</ul>'
    case_content +='</div>'
    case_content +='<div class="operating_area_block">'
    case_content +='<div class="operating_area_title">Respond</div>'
    case_content +='<div>'
    case_content +='<li>簡略敘述：</li>'
    case_content +='<textarea class="case_description"></textarea>'
    case_content +='<div>處置：'
    case_content +='<input class="report_denied" name="casae_disposal" type="radio" id="report_denied" check="checked">'
    case_content +='<label for="report_denied">上架</label>'
    case_content +='<input class="report_accepted" name="casae_disposal" type="radio" id="report_accepted">'
    case_content +='<label for="report_accepted">下架</label>'
    case_content +='</div>'
    case_content +='<button class="send_disposal_btn">送出處置</button>'
    case_content +='</div>'
    case_content +='</div>'
    case_content +='<div class="case_ref_block">'
    case_content +='<div class="case_ref_title">Reference</div>'
    case_content +='</div>'
    case_content +='</div>'
    $("main").append(case_content)
})

//===================================================================================================================================
//=========================================================== DROP DOWN =============================================================
//===================================================================================================================================



// =================================================================================================
