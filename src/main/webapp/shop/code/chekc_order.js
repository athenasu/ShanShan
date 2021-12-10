$(document).ready(function () {

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 確認訂單 開始
    
    $("input.payment_points_range").change(function () {
        $("div.payment_usepoints_num").text($("input.payment_points_range").val())
    })

    // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW 確認訂單頁面 結束

})