<#setting classic_compatible=true>


 <link rel="stylesheet" href="${base}/static/css/sidebar.css" type="text/css" media="screen"/>
 <link rel="stylesheet" href="${base}/static/css/jquery.fileupload.min.css">
<link rel="stylesheet" href="${base}/static/css/new/step.css" type="text/css" media="screen"/>
  <style>
  	.td_top{font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)}
  	.td_bottom{font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)}
  	.margin_td{width:80px}
  	.margin_td_top{margin-top:-2px}
  	.width_left2{width:85px}
  	.margin_td_top2{margin-top:-4px}
  </style>
  
  <div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-12px;"  alt=""/></a></div>
    <div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black"></div></div>
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
	    <div class="user-con pb0">
	  		<div class="right_con">
					<div class="right_title">我要下单</div>
						
						<table style="margin:30px 0px 0px 30px;">
							<tr>
								<td>
									<div style="width:270px;height:270px;border:1px solid #D2D2D2;display: flex;text-align: center;">
											<img alt="" src="${base}${commodityType.imageUrl}" style="width:110px;margin:auto">
									</div>	
								</td>
								<td style="width:700px;position:relative;">
									<div style="position:absolute;left:36px;top:0px;">
										<div>
											<span style="font-size:13px;font-weight:bold">${commodityType.commodityName}</span>
										</div>
										<div style="color:red;margin-top:5px;">
											<span>单价:</span><span style="font-size:16px;font-weight:bold">${commodityType.rePrice}元</span>
										</div>
										<div style="margin-top:3px;">
											<span>尺寸：${commodityType.size}</span>
										</div>
										<div style="margin-top:3px;">
											<span>纸张材质：康戴里磨成  Matter Goya white270gsm，横切，打孔</span>
										</div>
										<div style="margin-top:3px;">
											<span>LOGO烫黑金，锦旗 stamp #CW烫黑金</span>
										</div>
										<div style="margin-top:3px;">
											<span>烫黑金尺寸为：14*0.5CM + 可变的印刷内容</span>
										</div>
										<div class="SQ_w130"> 
								          	<span id='minusSC' class="cuts" >－</span>
								            <input id='CountSC' type="text" name="" style="width:50px;" class="delivery" value="1" onkeyup="value=value.replace(/[^\d]/g,'')">
								            <span id='addSC' class="plus failed">＋</span>
							             </div>
										
									</div>
									
								</td>
							</tr>
						</table>

						<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:40px;" />

						<table style="margin:auto;margin-bottom:100px;margin-top:50px;">
							<tr>
								<td>
									<div style="width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto; line-height:23px; color:#d90b19; margin:0px 20px 10px 0px;">
										<a id="returns" style="color:#d90b19;cursor:pointer;text-decoration:none">返回</a>
									</div>
								</td>
								<td>
									<div id="subBtnDiv" style="width:98px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto; line-height:23px; color:#d90b19; margin-bottom:10px;">
										<a id="subBtn"  style="color:#d90b19;cursor:pointer;text-decoration:none">加入购物车</a>
									</div>
								</td>
							</tr>
						</table>


			</div>
		</div>
	</div>
</div>

<script src="${base}/static/js/jquery.min.js"></script>
<script src="${base}/static/js/fileupload/vendor/jquery.ui.widget.js"></script>
<script src="${base}/static/js/fileupload/jquery.iframe-transport.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-process.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-validate.js"></script>


<script>
	$("#returns").click(function(){
		window.history.go(-1);
	})
	
	$("#addSC").click(function(){
		var CountSC = Number($("#CountSC").val());
		$("#CountSC").val(CountSC+1)
	})
	$("#minusSC").click(function(){
		var CountSC = Number($("#CountSC").val());
		if(CountSC>0){
			$("#CountSC").val(CountSC-1)
		}
	})
	$("#subBtn").click(function(){
		
		var CountSC = $("#CountSC").val();
		var reg = /^[1-9]\d*$/;
		if(reg.test(CountSC)){
			var shoppingCartItem = new Object();
			//shoppingCartItem.fileUrl = $("#fileUrl_input").val();//文件路径
			//shoppingCartItem.fileName = $("#fileName_input").val();//文件名称
			shoppingCartItem.commodityName = "${commodityType.commodityName}";//商品名称
			shoppingCartItem.itemId = "${commodityType.id}";//商品ID
			shoppingCartItem.rePrice = "${commodityType.rePrice}";//商品单价
			shoppingCartItem.number = $("#CountSC").val();//商品数量
			shoppingCartItem.type = "${commodityType.type}";//商品类型
			shoppingCartItem.supplierPrice = "${commodityType.supplierPrice}";//供应商单价

			$.ajax({
				url:"${base}/order/addShoppingCart",
			  	type: "POST",
	            contentType : 'application/json;charset=utf-8',
	            dataType:"json",
				data:JSON.stringify(shoppingCartItem),
				dataType:"json",
				success:function(data){
					if(data.success){
						location.href='${base}/cart/shopping-cart.html';
					}else{
						alert("加入购物车失败!");
					}
				},error:function(data){
					alert("加入购物车失败!");
				}
			})
		}else{
			alert("请输入合法的商品数量");
		}
		
		
	})
</script>









