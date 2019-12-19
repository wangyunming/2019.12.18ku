<#setting classic_compatible=true>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<#if seoDO?exists>
		  <title>${seoDO.title!''}</title>
		  <meta name ="keywords" content="${seoDO.keywords!''}" />
		  <meta name="description" content="${seoDO.description!''}"/>
		<#else>
		  <title>${title}</title>
		</#if>
		<meta name="renderer" content="webkit" /> 
		<meta name="robots" content="all">
		 <link rel="stylesheet" href="${base}/static/css/localcss/bootstrap.min.css">
		<link rel="stylesheet" href="${base}/static/css/base.css" type="text/css" media="screen"/>
		<link rel="stylesheet" href="${base}/static/css/common.css" type="text/css" media="screen"/>
		<!--<link rel="stylesheet" href="${base}/default/css/layout.css" type="text/css" media="screen"/>-->
		<link rel="stylesheet" href="${base}/static/css/style.css" type="text/css" media="screen"/>
		
		<!--[if IE 6]> 
		<script src="${base}/default/js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
		<script> 
		  DD_belatedPNG.fix(".mshop , .logo, .picon , .itubiao .sp1 , .itubiao .sp2 , .itubiao .sp3 ,.con2a , .tit , #zdv");
		</script> 
		<![endif]--> 
		<#--
		<div id="noticebar" class="noticebar">
			<style type="text/css">body { background-position: center 90px;}.body_store { background-position: center 126px;}.header { padding-top: 90px;}.hfixed { padding-top: 90px;}.body_store .hfixed { padding-top: 126px;}</style>
			<div class="notice">
				<div class="text">【温馨提示】国庆假期好印网照常服务，因印刷厂放假原因，您的订单会受到不同程度的影响，请在下单时联系客服确认，10月1日及以后的订单将安排在10月8日陆续生产发货，好印客服人员于10月1日-7日放假，届时将不提供电话及在线客户服务。为不影响您的订单交付，请您提前计划下单时间，节前若遇到急单或疑问，请详询客服热线400-188-6383。
				</div>
				<a class="close" href="javascript:;" onclick="closeTop()"><b>X</b></a>
			</div>
		</div>
		-->
	</head>
	<body>
		<!-- top nav  -->
		<#include "layout/site-nav.ftl">
		<!-- // top nav  -->
		<sitemesh:write property='body'/>
		${body}		
		<!-- footer -->
		<#include "layout/footer.ftl">
		<!-- // footer -->
	</body>
</html>
