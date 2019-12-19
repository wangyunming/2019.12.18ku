
<script src="${base}/static/js/haoyin.cookie.js" type="text/javascript"></script>
<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/footer.css" type="text/css" media="screen"/>
<div class="topnav">
  <div class="topnavcontent">
    <ul >
      <script type="text/javascript">
	  	var pc = new HaoyinCookie('${base}');
	    pc.showLoginNav();
	  </script>
	  <li class="big"></li>
      <li><a href="${base}/order/ongoing-order.html">我的好印</a></li>
      <#if position != 'INITIAL'>
      <li><a href="${base}/cart/shopping-cart.html">购物车（<span id="carts">0</span>）</a></li>
      </#if>
     <#-- <li><a href="${base}/main/net-deliver-list.htm">网点查询</a></li>
	 <li class="big">
	  	<div class="menu-hd">
	  		<div class="cum"> <a>大客户入口</a> <i></i> </div>
	  		<div class="menu-list"> 
	  		  <div>
	  		    <a>大客户入口</a> <i></i>
	  		  </div>
	  		 <#if userType==null||userType!=1>
	  		  		<span><a href='//private.haoyin.com/melaleuca/meeting/item-list.htm'><img target="_blank" link="" src="${base}/static/images/link-logo.png" name="link"/></a></span> 
	  		   <#elseif userLevel==2>
	  		   		<span><a  href='${base}/order/order-setting-agent.htm'><img  link="" src="${base}/static/images/new/haoyinmendian.png" name="link"/></a></span>
			  <#else>
			  	 	<span><a href='${base}/order/order-setting-agent.htm'><img  link="" src="${base}/v/images/new/haoyindaili.png" name="link"/></a></span>
			   </#if>
	  		</div>
		</div>
     </li>
    <li class="big">
		<div class="menu-hd">
	  		<div class="cum"> <a href="//scm.haoyin.com" target="_blank">供应商入口</a> <i></i> </div>
		</div>
     </li>-->
    </ul>
  </div>
</div>


<script>
	function PlayJsAdPopWin() {
		popwin = window.location.href = 'tencent://message/?uin=1844479688&Site=好印网&Menu=yes'
	};
	function PlayJsAdPopWin_qudao() {
		popwin = window.location.href = 'tencent://message/?uin=2763469544&Site=好印网（渠道）&Menu=yes'
	};
</script>

<script src="${base}/static/js/jquery.min.js" type="text/javascript"></script>
<script>
	document.getElementById("carts").innerHTML=pc.getShoppingCartCount();
</script>
