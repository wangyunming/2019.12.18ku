<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>${title}</title>
		<link rel="stylesheet" href="${base}/default/css/reset.css" type="text/css" media="screen"/>
		<link rel="stylesheet" href="${base}/default/css/base.css" type="text/css" media="screen"/>
		<link rel="stylesheet" href="${base}/default/css/common.css" type="text/css" media="screen"/>
		<link rel="stylesheet" href="${base}/default/css/style.css" type="text/css" media="screen"/>
		<link rel="stylesheet" href="${base}/default/css/new/header.css" type="text/css" media="screen"/>
		<script src="${base}/default/js/haoyin.cookie.js" type="text/javascript"></script>
	</head>
	<body <#if isWeiXin?? && isWeiXin=='true'>style="background: #ebebeb;"</#if>>
		<#if isWeiXin?? && isWeiXin=='true'>
			${body}
		<#else>
			<!-- top nav  -->
			<div class="topnav">
				<div class="topnavcontent">
				</div>
			</div>
			<div class="mainbav">
				<div class="container">
					<div class="mainbav-logo"><img src="${base}/default/images/new/logo.png" width="254" height="44"  alt=""/></div>
				</div>
			</div>
			<!-- // top nav  -->
			${body}
			<!-- footer -->
			<#include "footer.ftl">
			<!-- // footer -->
	    </#if>
	</body>
</html>

<script>
	function PlayJsAdPopWin() {
		popwin = window.location.href = 'tencent://message/?uin=1844479688&Site=好印网&Menu=yes'
	};
</script>