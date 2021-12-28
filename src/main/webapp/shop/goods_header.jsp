<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <!-- 燈箱登入方式選擇 -->
    <div class="login_modal_bcg -none"></div>
    <div class="login_modal -none">
        <h1 class="login_form_title">登入</h1>
        <div>
            <div class="login_formbox">
                <input class="summitbutton_signupfacebook" type="button" value="用FACEBOOK登入"></input>
            </div>

            <div class="login_formbox">
                <input class="summitbutton_signupgoogle" type="button" value="用GOOGLE登入"></input>
            </div>

            <div class="horizen_gap"></div>
            <div class="horizen_gap_or">or</div>
            <div class="horizen_gap"></div>


            <div class="login_formbox">
                <input class="emaillogin" type="button" value="電子郵件登入"></input>
            </div>

            <div class="login_formbox" style=" text-align: center;">
                <p>還沒註冊?請點選這裡<a href="<%=request.getContextPath()%>/member/register.html">註冊成為新山友</a></p>
            </div>
        </div>

    </div>
    <!-- 燈箱登入方式選擇 結束-->

    <!-- 燈箱郵件登入 開始-->
    <div class="login_modal_email -none">
        <h1 class="login_form_title">用電子郵件登入</h1>
        <div>
        <form method="post" action="<%=request.getContextPath()%>/memberLogin/login" id="loginSubmit">
            <div class="login_formbox_2 ">
                <label class="login_formname" for="Email">電子郵件地址</label>
                <input class="login_formbar_email login_formbar" name="Email" placeholder="請輸入您的電子郵件地址" value="athenasu210@gmail.com"></input></br>
            </div>

            <div class="login_formbox">
                <label class="login_formname" for="password">密碼</label>
                <input class="login_formbar_password login_formbar" name="password" placeholder="請輸入您的密碼" value="P@ssword"></input></br>
            </div>

		</form>
            <div class="login_formbox login_description">
                <input class="login_formcheckbox" type="checkbox">&ensp;記住我的密碼</input>
            </div>
            <div class="login_formbox">
                <input class="login_summitbutton" type="button" value="登入"></input>
            </div>
			<input type="hidden" class="member_id" value="${memberId}"> <!--  登入狀態   -->
            <div class="login_formbox" style=" text-align: center;">
                <p class= "forgot_password"><a href="#">忘記密碼?</a></p>
            </div>
        </div>
    </div>
  	 <div class="forgot_password_modal -none">
 	     <h1 class="forgot_password_title">請輸入電子郵件</h1>
 		 <div>
   			<div class="forgot_password_formbox">
   	   	  		<label class="forgot_password_formname" for="Email">電子郵件地址</label>
   	     		<input class="forgot_password_email" name="Email" placeholder="請輸入您的電子郵件地址"></input></br>
   	     	</div>
   	     	<div class="forgot_password_formbox">
      	    	<input class="forgot_password_summitbutton" type="button" value="發送驗證信"></input>
         	</div>
         </div>
	</div>
    <!-- 燈箱郵件登入 結束-->

    <!-- 商店導覽列 開始-->
    <header class="goods_header">
        <div class="goods_titlebar">
            <div class="goods_titlepic"><img src="<%=request.getContextPath()%>/shop/img/logo.png" width="60px" height="60px" alt=""></div>

            <!-- 山山來此 標題 -->
            <div class="goods_header_title_shanshan" onclick="location.href='<%=request.getContextPath()%>/index/index.jsp'">山山來此</div>

            <!-- 隔線 -->
            <div class="goods_titlegap"></div>
            
            <!-- 會員中心 標題 -->
            <div class="goods_header_title_shanshan" onclick="location.href='<%=request.getContextPath()%>/member/member_main.html'">會員中心</div>
            
            <!-- 隔線 -->
            <div class="goods_titlegap"></div>

            <!-- 攻山小物 標題 -->
            <div class="goods_header_title_goods" onclick="location.href='<%=request.getContextPath()%>/shop/goods_index.jsp'">攻山小物</div>

            
          
            <!-- 購物車icon -->
            <div class="goods_shopcart_area" onclick="location.href='<%=request.getContextPath()%>/shop/goods_shopcart.jsp'">
                <i class="fas fa-shopping-cart header_shopcarticon"></i>
                <div class="shopcarticon_num_bg"><span class="shopcarticon_num">${cart.totalItemQTY}</span></div>
            </div>
			<form method="get" action="<%=request.getContextPath()%>/CartServlet" id="totalItemQTY" onsubmit="return submitTotalItemQTY();">
                  <input type="hidden" name="method" value="totalItemQTY">
            </form>

            <!-- 商品情報 標題 -->
            <div class="goods_header_kinds_area">
                <div class="goods_header_kinds_title">商品情報</div> <!-- 標題按鈕 -->
                <div class="goods_kinds_list">
                    <div class="goods_list_firstculomn">
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/AllProductServlet?pageNum=1'">全部商品</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetProductTypeServlet?ProductType=1&pageNum=1'">衣著/鞋子/背包</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetProductTypeServlet?ProductType=2&pageNum=1'	">工具/照明/登山杖</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetProductTypeServlet?ProductType=3&pageNum=1'">炊具</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetProductTypeServlet?ProductType=4&pageNum=1'">寢具/帳篷/睡袋</div>
                    </div>
                </div> <!-- 下拉框 -->
            </div>
            <!-- 隔線 -->
            <div class="goods_titlegap"></div>

            <!-- 品牌情報 標題 -->
            <div class="goods_header_stores_area">
                <div class="goods_header_stores_title">品牌情報</div> <!-- 標題按鈕 -->
                <div class="goods_stores_list">
                    <div class="goods_list_firstculomn">
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/AllCompanyServlet'">全部品牌</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetCompanyServlet?companyId=1'">好好登山</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetCompanyServlet?companyId=2'">攻山小屋</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetCompanyServlet?companyId=3'">攀登趣</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetCompanyServlet?companyId=4'">聞青</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetCompanyServlet?companyId=5'">GOGOHiking!</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetCompanyServlet?companyId=6'">goClimbing</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetCompanyServlet?companyId=7'">山商巧福</div>
                        <div class="goods_list_item" onclick="location.href='<%=request.getContextPath()%>/GetCompanyServlet?companyId=8'">山山來煮</div>
                    </div>
                </div> <!-- 下拉框 -->
            </div>

            <!-- 搜尋功能 -->
            <div class="goods_search_area" tabindex="0">
              <form id="search_bar" action="<%=request.getContextPath()%>/SearchServlet" method="get" >
                <div class="goods_search_choose">

                    <i class="fas fa-search goods_search_icon"></i>
                    <select class="goods_search_choose_bar" value="1" name="method" tabindex="0">
                        <option value="product">商品</option>
                        <option value="company">商店</option>
                    </select>
                </div>
                <label for="goods_search">
                    <input type="text" class="goods_search" placeholder="輸入關鍵字..." name="searchString" tabindex="0"></input>
                </label>
           	 </form>
            </div>
            <!-- 登入註冊 -->
            <input type="button" class="goods_registor_botton" value="註冊"
                onclick="location.href='<%=request.getContextPath()%>/member/register.html'"></input>
            <input type="button" class="goods_login_modal_botton" value="登入"></input>
        </div>
    </header>

    <!-- 商店導覽列 結束 -->