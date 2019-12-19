<#setting classic_compatible=true>

<!doctype html>
<html xmlns:wb="http://open.weibo.com/wb">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<#if seoDO?exists>
		  <meta name ="keywords" content="${seoDO.keywords!''}" />
		  <meta name="description" content="${seoDO.description!''}"/>
		  <title>${seoDO.title!''}</title>
		<#else>
		  <title>${title}</title>
		</#if>
		<meta name="renderer" content="webkit" /> 
		<link rel="stylesheet" href="${base}/static/css/reset.css" type="text/css" media="screen"/>
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
		<script>
			var _hmt = _hmt || [];
			(function() {
  			var hm = document.createElement("script");
  			hm.src = "//hm.baidu.com/hm.js?5a6739a868dc255f2dd6876d37fe9f26";
  			var s = document.getElementsByTagName("script")[0]; 
  			s.parentNode.insertBefore(hm, s);
			})();
		</script>
	</head>
	<body>
		<!-- top nav  -->
		<#include "layout/site-nav-step.ftl">
		<!-- // top nav  -->
		<sitemesh:write property='body'/>
		${body}		
		<!-- footer -->
		<#include "layout/footer.ftl">
		<!-- // footer -->
	</body>
</html>
