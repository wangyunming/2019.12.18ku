<link rel="stylesheet" href="${base}/static/css/sidebar.css" type="text/css" media="screen"/>

<link rel="stylesheet" href="${base}/static/css/new/header-step.css" type="text/css" media="screen"/>


<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header-step.css" type="text/css" media="screen"/>
<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-12px;"  alt=""/></a></div>
    <div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black">选择商品类别</div></div>
    <!-- <div class="I_step"><img src="${base}/static/images/new/01_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li class="red">我要下单</li>
        <li>支付订单</li>
        <li>上传文件</li>
        <li>等待审核</li>
        <li>等待收货</li>
      </ul>
    </div> -->
  </div>
</div>
<div class="bjf7 p20 of">
  <div class="user of">
		 <#include "/layout/sidebar.ftl">
	    <div class="user-con pb0" style="height:auto;overflow:hidden;">
	  		<div class="right_con">
					<div class="right_title">我要下单</div>
						<table style="height:auto;overflow:hidden;margin-top:30px;">
							<#list commodityTypeList as commodityListList>
								<tr>
									<#list commodityListList as commodityType>
										<td style="width:320px;height:370px;">
											<div style="width:270px;height:270px;display: flex;border:1px solid #D2D2D2;text-align: center;" id="initial_${commodityType.id}" onclick="nextStep(${commodityType.id},${commodityType.type})">
												<!-- 价格牌1start -->
													 <img alt="" src="${base}${commodityType.imageUrl}" style="width:110px;margin:auto" />
												<!-- 价格牌1end -->
											</div>	
											<div style="margin:10px 0px 0px 30px;font-size:13px">
												<div><span>商品名称：${commodityType.commodityName}</span></div>
												<div style="margin-top:5px;"><span>尺寸：${commodityType.size}</span></div>
												<div style="margin-top:5px;color:red;"><span>单价:${commodityType.rePrice}元</span></div>
											</div>
										</td>
									</#list>
								</tr>
							</#list>
							
							
						</table>
						<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />
						<div style="width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto; line-height:23px; color:#d90b19; margin-bottom:10px;">
							<a style="color:#d90b19;text-decoration:none;cursor:pointer;" id="next">下一步</a>
						</div>
			</div>
		</div>
	</div>
</div>

<script src="${base}/static/js/jquery.min.js"></script>

<script>
	var b = 0;
	var c;
	function nextStep(a,y){
		$("div[id^=initial_]").each(function(){
			$(this).css("border","1px solid #D2D2D2");//移除 ID为two的对象的class名为divClass的样式。
		})
		$("#initial_"+a+"").css("border","1px solid red");
		b = a;
		c = y;
	}
	
	
	$("#next").click(function(){
		if(b == 0){
			alert("请选择商品类别!");
			return;
		}
		if(c==1 || c==2 || c==4 || c==5){
			window.location="${base}/order/order-file-upload.html?id="+b;//上传文件
		}else if(c==3){
			window.location="${base}/order/order-file-upload-no.html?id="+b;//不用上传文件
		}
	})

	

</script>










