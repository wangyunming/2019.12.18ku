<#setting classic_compatible=true>


 <link rel="stylesheet" href="${base}/static/css/sidebar.css" type="text/css" media="screen"/>
 <link rel="stylesheet" href="${base}/static/css/jquery.fileupload.min.css">
<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header-step.css" type="text/css" media="screen"/>
<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-12px;"  alt=""/></a></div>
    <div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black">我要下单</div></div>
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
  <style>
  	.td_top{font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)}
  	.td_bottom{font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)}
  	.margin_td{width:80px}
  	.margin_td_top{margin-top:-2px}
  	.width_left2{width:85px}
  	.margin_td_top2{margin-top:-4px}
  </style>

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
										<div style="position:relative;left:0px;top:20px;">
											<div id="upload_button1" style="color:#d90b19;width:400px;margin-bottom:20px;">
									
											</div>
											<div style="width:75px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center;" id="upload_button_div">
												<a style="color:#d90b19;text-decoration:none;cursor:pointer;" id="upload_button" onclick="addImage()">上传文件</a>
												<input id="multupload" type="file" name="file" style="display:none">
											</div>
											<div id="upSucc" style="color:#d90b19;width:400px;margin-top:5px;display:none">说明：未加入购物车，可随时替换文件，重新上传</div>
										</div>
										
									</div>
									
								</td>
							</tr>
						</table>

						<input type="hidden" value="" id="fileUrl_input">
						<input type="hidden" value="" id="fileName_input">
		          		<input type="hidden" value="" id="quantity_input">



						
						<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:40px;" />
						<div id="hehe">	
						
						
								
						
						
						
						</div>
						<table style="margin:auto;margin-bottom:100px">
							<tr>
								<td>
									<div style="width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto; line-height:23px; color:#d90b19; margin:0px 20px 10px 0px;">
										<a id="returns" style="color:#d90b19;cursor:pointer;text-decoration:none">返回</a>
									</div>
								</td>
								<td>
									<div id="subBtnDiv" style="display:none;width:98px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto; line-height:23px; color:#d90b19; margin-bottom:10px;">
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
	function addImage(){
		$("#multupload").click();
	}
	
	
	$('#multupload').fileupload({
        url: "/order/excel-order-upload",
        dataType: 'json',
        paramName: 'file',
        maxFileSize: 5242880,
        singleFileUploads: false,
        maxNumberOfFiles: 1,
        minFileSize: 1024,
        acceptFileTypes: /(\.|\/)(xls|xlsx)$/i,
        formData: {param: Math.random() * 1000},
        add: function (e, data) {
        	if (data.files.length != 1) {
        		alert('文件数量错误! 请选择1个文件');
        		return false;
        	}
        	data.submit();
        },
        send : function(e, data) {
        	$('#mult-progress').removeClass('fadeOut').addClass('fadeIn');
        },
        done: function (e, data) {
			var result = data.result;
			if (result.success) {
				
				
				$("#upload_button").text("重新上传");
				$("#upload_button").css({'color':'black'});
				$('#upload_button_div').css({'position':'abosolute','top':'40px','border':'1px solid black'})
				var HTML2 = "";
				HTML2 = HTML2  + '<div style="width:400px">文件"<span style=" border-bottom:1px solid red;">'+result.objects.fileName+'</span>"上传完成</div>';
				$("#fileUrl_input").val(result.objects.fileUrl);
				$("#fileName_input").val(result.objects.fileName);
				$("#quantity_input").val(result.objects.quantity);
				$("#upload_button1").html(HTML2);
				$("#subBtnDiv").show();
				$("#upSucc").show();
				$("#subBtnDiv").addClass(""+result.objects.fileUrl+"");
				
			} else {
				alert(result.message);
			}
			setTimeout(function() {
				$('#mult-progress').addClass('fadeOut');
			}, 600);
        },
        fail: function(e, data) {
        	if (data.result) {
        		var haha = data.result.obj;
        		alert(data.result.obj);
        	} else {
        		alert("文件上传失败!");
        	}
        }
        });
		
		
	    //文件上传前触发事件
	    $('#multupload').bind('fileuploadsubmit', function (e, data) {
	        data.formData = { type: "${commodityType.type}" };  //如果需要额外添加参数可以在这里添加
	    });

	

	$("#subBtn").click(function(){
		var shoppingCartItem = new Object();
		shoppingCartItem.fileUrl = $("#fileUrl_input").val();//文件路径
		shoppingCartItem.fileName = $("#fileName_input").val();//文件名称
		shoppingCartItem.commodityName = "${commodityType.commodityName}";//商品名称
		shoppingCartItem.itemId = "${commodityType.id}";//商品ID
		shoppingCartItem.rePrice = "${commodityType.rePrice}";//商品单价
		shoppingCartItem.number = $("#quantity_input").val();//商品数量
		shoppingCartItem.type = "${commodityType.type}";//商品类型
		shoppingCartItem.supplierPrice = "${commodityType.supplierPrice}";//供应商单价
		
		/* if(${commodityType.type} == 1){
			alert("加入购物车商品为价格牌,将自动在购物车添加同等数量的吊绳");
		} */
		
		$.ajax({
			url:"${base}/order/addShoppingCart",
		  	type: "POST",
            contentType : 'application/json;charset=utf-8',
            dataType:"json",
			data:JSON.stringify(shoppingCartItem),
			dataType:"json",
			success:function(data){
			location.href='${base}/cart/shopping-cart.html';
				//alert(data.success);
			}
		})
	})
</script>









