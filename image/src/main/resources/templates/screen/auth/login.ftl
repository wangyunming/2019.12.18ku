<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/login.css" type="text/css" media="screen"/>

<title>用户登录</title>
<link rel="stylesheet" type="text/css"  href="${base}/static/css/page6.css"/>
<link rel="stylesheet" href="${base}/static/css/validator.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/reset.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/common.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/style.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/footer.css" type="text/css" media="screen"/>
<style>
  #list tr {background-color:#fff;}
  #list tr:hover {background-color:#eee;cursor:pointer;}
  #list tr td {padding: 3px 6px;vertical-align:middle}
</style>


<div class="topnav">
				<div class="topnavcontent">
				</div>
			</div>
			<div class="mainbav">
				<div class="container">
					<div class="mainbav-logo"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-10px;" alt=""/></div>
				</div>
			</div>

<div class="bjf7 login-padding">
  <div class="login-main">
    <div class="login-content">
      <div class="login-banner"><img src="${base}/static/images/new/loginbanner.png" width="720" height="300"  alt="好印网"/></div>
      <div class="form-area">
        <form id="loginForm" action="${base}/auth/login" method="post" >
          <div class="area-item"> <span>用户名：</span>
           <input class="input" type="text" name="username" >
          </div>
          <div class="area-item mt10"> <span>密码：</span>
            <input class="input" type="password" name="password" >
           
          </div>
      
          
         
          <button class="botton mt20" type="submit" >登  录</button>
         <!-- <p style="float:left;" class="forget"> <input type="checkbox" id="remember_me" name="remember" class="lh12" />
	      <label name="rem_l" class="poi lh12 p3" >记住我的密码</label></p> -->
        </form>
      </div>
    </div>
  </div>
</div>


<div class="footer">
	<div class="footer-info">
		<div class="info-links">
		 <a href="http://www.beian.miit.gov.cn" target="_blank"> <img src="${base}/static/images/new/footer05.jpg" width="108" height="40"   alt=""/></a>
<!-- 		 <a href="http://www.sgs.gov.cn/lz/licenseLink.do?method=licenceView&entyId=20121203113739154" target="_blank"> <img src="${base}/static/images/new/footer02.png" width="108" height="40"  alt=""/></a>
 -->		 <a href="http://www.achieve-tech.com.cn" target="_blank"> <img src="${base}/static/images/new/footer03.png" width="175" height="40"  alt=""/></a>
		 <a href="https://auth.alipay.com/login/index.htm" target="_blank"> <img src="${base}/static/images/new/footer04.png" width="180" height="40"  alt=""/> </a>
		  <p class="mt10">Copyright © 2012-2022版权所有 上海好之印电子商务有限公司</p>
		 </div>
	</div>
</div>
<script src="${base}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${base}/static/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${base}/static/js/jquery.validate.js" type="text/javascript" charset="UTF-8"></script>
<script src="${base}/static/js/jquery.blockUI.js" type="text/javascript" charset="UTF-8"></script>
 
<script type="text/javascript">
	 $(function(){
	 	<#if invokeResult?exists && invokeResult!="">
			alert('${invokeResult}');
		</#if>
		var form = $(".login-form");
		form.css({
			opacity: 1,
     		"-webkit-transform": "scale(1)",
     		"transform": "scale(1)",
         	"-webkit-transition": ".5s",
      		"transition": ".5s"
    	});
    	
	});
	
</script>