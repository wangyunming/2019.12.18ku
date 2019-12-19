
<script src="${base}/static/js/haoyin.cookie.js" type="text/javascript"></script>
<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header.css?v=1" type="text/css" media="screen"/>
<div class="topnav">
  <div class="topnavcontent">
    <ul>
      <script type="text/javascript">
	  	var pc = new HaoyinCookie('${base}');
	    pc.showLoginNav();
	  </script>
	  <li class="big">
	</li>
    </ul>
  </div>
</div>
<form id='privateLogin'>
	<input  name="login.loginName" type="hidden"/>
	<input  name="login.loginName" type="hidden"/>
</form>


<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><img id="logImg" src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-10px;"  /></div>
  </div>
</div>

<script>
	<#--QQ弹窗  -->
	function PlayJsAdPopWin() {
		popwin = window.location.href = 'tencent://message/?uin=1844479688&Site=好印网&Menu=yes'
	};
	function PlayJsAdPopWin_qudao() {
		popwin = window.location.href = 'tencent://message/?uin=2763469544&Site=好印网（渠道）&Menu=yes'
	};
</script>
<script>
</script>
<script src="${base}/static/js/jquery.min.js" type="text/javascript"></script>
<script>
<#-- 搜索框颜色切换 -->
var colors = new Array();
colors[0] = '#FFFFFF';
colors[1] = '#A6FDFE';
colors[2] = '#FFFFFF';
colors[3] = '#A6FDFE';
var i = colors.length;
function ChangeBackColor() {
	if( i>=1 ) {
		i--;
		$('#key').css('background-color', colors[i]);
		setTimeout('ChangeBackColor()', 100);
	}
}
	
	$(function() {
	
		$('#noticebarClose').click(function(){
			$('#noticebar').hide();
		});
		
		$('#scoreMall').click(function(){
			self.location.href = '${base}/scoremall/scoremall.htm';
		});
		
		$('#scene').click(function(){
			self.location.href = '${base}/main/scene.htm';
		});
		$('#searchProducts').click(function(){
			var name = $.trim($('#key').val());
			if(name=='') {
				ChangeBackColor();
			} else {
				self.location.href = '${base}/products/products.htm?query.name=' + name;
			}
		});
		
		document.onkeydown=function(event){
			var e = event || window.event || arguments.callee.caller.arguments[0];
			 if(e && e.keyCode==13 && $('#key').is(':focus')){ // enter 键
			   	var name = $.trim($('#key').val());
				if(name=='') {
					ChangeBackColor();
				} else {
					self.location.href = '${base}/products/products.htm?query.name=' + name;
				}  
			}
        };

        
	});

</script>
