<#setting classic_compatible=true>

<title>订单明细</title>

<link rel="stylesheet" type="text/css"  href="${base}/static/css/hycon.css"/>
<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header-step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/order_detail.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/localcss/bootstrap.min.css" type="text/css" media="screen"/>

<style>
.Eject{ margin:auto; width:540px; min-height:396px; overflow:hidden; border-radius:5px; position:relative;}
.Eject .success{height:30px; width:540px; position:absolute; background:#94ce02; color:#FFFFFF; text-align:center; line-height:30px; font-size:14px; display: none;}
.Eject .fail{height:30px; width:540px; position:absolute; background:#e74c3c; color:#FFFFFF; text-align:center; line-height:30px; font-size:14px; display: none;}
.Eject label{ font-size:14px; color:#a6a6a6; width:88px; text-align:right; display:inline-block;} 
.Eject ul{ margin:30px 40px 0 40px; } 
.Eject ul li{ margin-bottom:15px;}
.Eject input{ width:120px; border:1px solid #dfdfdf; } 
.Eject select{ width:284px; border:1px solid #dfdfdf; height: 30px;} 
.Eject span{ color:#FF0000;margin-left:5px; font-weight:bold;}
.Eject .save{ background:#fafafa; text-align:center; height:50px; padding-top:20px;}
.block {margin:15px; background:#ffffff; border:1px solid #ebebeb; overflow:hidden;}
.topnav .topnavcontent h4{line-height: 2.2;}
</style>
<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="JavaScript:history.back(-1)"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-10px;" alt=""/></a></div>
   <#if order.scoutStatus==2>
    <div class="I_step"><img src="${base}/static/images/new/05_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li class="pink">确认订单</li>
        <li class="pink">支付订单</li>
        <li class="pink">待接单</li>
        <li class="pink">生产中</li>
        <li class="red">已完成</li>
      </ul>
    </div>
    <#elseif order.scoutStatus==1 >
		<div class="I_step"><img src="${base}/static/images/new/04_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li class="pink">确认订单</li>
        <li class="pink">支付订单</li>
        <li class="pink">待接单</li>
        <li class="red">生产中</li>
        <li class="pink">已完成</li>
      </ul>
    </div>	    
    <#elseif order.scoutStatus==0 && order.payStatus==1>
    <div class="I_step"><img src="${base}/static/images/new/05_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li class="pink">确认订单</li>
        <li class="pink">支付订单</li>
        <li class="pink">待接单</li>
        <li class="red">生产中</li>
        <li class="pink">已完成</li>
      </ul>
    </div>	    
    </#if>
  </div>
</div>
  <div style="background-color: #f7f7f7"> <div style="width:1125px;margin: auto;"><h1 style="padding: 8px;    padding: 10px 0px 0px;" >订单详情</h1></div></div>
<div class="bjf7 p20 of" >
	
  <div class="order_detial_main">
    <div class="order_detail_content">
      <div class="detail_title">
        <div class="fl bold">订单编号:${order.orderNo}</div>
        <div class="fr " style="font-weight: bold;font-size: 1px;color: #4c4c4c;" >订单状态：<span style="color:red;font-size: large;">
        <#if order.scoutStatus==0>
        	<#if (order.offlinePayStatus!0)==-1 && (order.payMode!0)==2>线下支付被驳回<#elseif (order.offlinePayStatus!0)==0 && (order.payMode!0)==2>线下支付待确认<#else> <#if order.payStatus==0>待支付<#else>待接单</#if> </#if>
        <#elseif order.scoutStatus==1>生产中<#elseif order.scoutStatus==2>已完成<#elseif order.scoutStatus==-1>已取消
        </#if></span></div>
        <div class="fr nub" style="padding-right: 360px;font-weight: bold;font-size: 1px;color: #4c4c4c;" >下单时间：<#if order.payTime??>${order.payTime?datetime}</#if> <#if order.approveStatus == -1>(已作废)</#if></div>
      </div>
      <p class="pline" style="margin: 16px -50px;" ></p>
	       <div class="content_block">
          <div class="content_title">收货信息</div>
          <div class="content">
            <ul>
              <li>
                <label>收货人：</label>
                <span>${order.linkman}</span> </li>
              <li>
                <label>电话：</label>
                <span>${order.mobileTel}</span> </li>
                <li>
                <label>收货地址：</label>
                <span>${order.province}${order.city}${order.district}${order.address}</span> </li>
            </ul>
          </div>
        </div>
         <p class="pline" style="margin: 16px -50px;" ></p>
        <div class="content_block">
          <div class="content_title">支付及配送方式</div>
          <div class="content">
            <ul>
              <li>
                <label>支付方式：</label>
                <span><#if (order.payType!0) == 1>在线支付<#elseif (order.payType!0) == 2> 线下支付<#elseif (order.payType!0) == 4>签约月结<#else>未知</#if></span> </li>
              <li>
                <label>配送方式：</label>
                <span><#if (order.logistics!0) == 1>快递物流<#elseif (order.logistics!0) == 2>网点自提<#else>未知</#if></span> </li>
            </ul>
          </div>
        </div>
      <p class="pline" style="margin: 16px -50px;" ></p>
   <!--     <div class="content_block">
          <div class="content_title">发票信息</div>
          <div class="content">
            <ul>
              <li>
                <label>发票类型：</label>
                <span>
					<#if (order.isNeedInvoice!0) == 0>无发票
					<#elseif order.isNeedInvoice == 1>
						<#if order.invoiceType == 0>个人发票
						<#elseif order.invoiceType == 1>企业发票
						<#elseif order.invoiceType == 2>增值税发票
						</#if>
					</#if>
				</span>
			  </li>
              <li>
                <#if order.invoiceType != 2>
                	<label>发票抬头：</label>
                	<span>${order.invoiceTitle!'无'}</span>
                <#elseif order.isNeedInvoice==1 && order.invoiceType == 2>
                <#list orderInvoiceList as orderInvoice>
                	<label>发票信息：</label>
                	<table width="100%" border="0" cellPadding="0" cellSpacing="0">
				    	<tr>
							<td class="tr" width="15%">公司抬头：</td>					
				    		<td class="tl" width="20%">${orderInvoice.company}</td>
				    		<td class="tr" width="15%">纳税人识别号：</td>
				    		<td class="tl">${orderInvoice.taxId}</td>
				    		<td class="tr" width="15%">开票金额：</td>
				    		<td class="tl">${orderInvoice.invoicedAmount}</td>
				    	</tr>
				    	<tr>
				    		<td class="tr">收票人地址：</td>
				    		<td class="tl">${orderInvoice.address}</td>
				    		<td class="tr">收票人姓名：</td>
				    		<td class="tl">${orderInvoice.realName}</td>
				    		<td class="tr">收票人电话：</td>
				    		<td class="tl">${orderInvoice.mobilePhone}</td>
				    	</tr>
				    </table>
				    </#list>
				</#if>
			  </li>
            </ul>
          </div>
        </div> 
       <div class="line">&nbsp;</div> -->


      <div class="info_block">
          <div class="info_content">
            <div class="table_content">
              <table  style="width:100%;" id="table">
                <tr style="border-bottom:1px dashed #CACACA;height:55px;line-height:55px;text-align:center">
                  <th style="width:11%;"><div style="text-align:center">商品名称</div></td>
                  <th style="width:12%;"><div  style="text-align:center">批次号</div></td>
                  <th style="width:8%;"><div  style="text-align:center">商品编号</div></td>
                  <th style="width:7%;"><div style="text-align:center">颜色</div></td>
                  <th style="width:9%;"><div style="text-align:center">号型</div></td>
                  <th style="width:7%;"><div style="text-align:center">size</div></td>
                  <th style="width:7%;"><div style="text-align:center">币种</div></td>
                  <th style="width:6%;"><div  style="text-align:center">数量</div></td>
                  <th style="width:8%;"><div  style="text-align:center">单价(单位:元)</div></td>
                  <th style="width:8%;"><div  style="text-align:center">总价(单位:元)</div></td>
                  <th style="width:10%;"><div  style="text-align:center">快递单号</div></td>
                  <th style="width:9.5%;"><div  style="text-align:center">操作</div></td>
                </tr>
                <#list infoList as infoLL>
                	<#list infoLL.infoList as info>
                		<#if info_index == 0>
	                		<tr class="t_content" style="height:35px;line-height:35px;text-align:center;border-bottom:1px solid #CACACA">
				                  <td rowspan="${infoLL.infoList?size}" style="display:table-cell; vertical-align:middle"><div style="width:80%;margin:auto">${info.commodityName}</div></td>
				                  <td rowspan="${infoLL.infoList?size}" style="display:table-cell; vertical-align:middle">${info.batch}</td>
				                  <td>${info.commodityCode}</td>
				                  <td>${info.color}</td>
				                  <td>${info.spec}</td>
				                  <td>${info.size}</td>
				                  <td>${info.currency}</td>
				                  <td>${info.number}</td>
				                  <td>${info.rePrice}</td>
				                  <td>${info.totalPrice}</td>
				                  <td><a href="#" onclick="trackingInfo(${info.trackingNum})" >${info.trackingNum}</a></td>
				                  <td rowspan="${infoLL.infoList?size}">
				                  		<#if userProfile.position == 'OEM'><#if order.payStatus==0><#if info.type==1 || info.type==2 || info.type==4 || info.type==5><div style="color:red;text-decoration:underline;cursor:pointer;" onclick="addImage(${info.itemId})">重新上传↑</div></#if></#if></#if>
				                  		<input id="multupload_${info.itemId}" lang="${info.type}"  type="file" name="file"  style="display:none">
				                  		<#if info.type==1 || info.type==2 || info.type==4 || info.type==5><div><a style="color:red;text-decoration:underline" href="${base}/down-load-file-excel.html?FileUrl=${info.fileUrl}&itemId=${info.itemId}">文件下载↓</a></div></#if>
				                  </td>
				             </tr>
                		</#if>
                		<#if info_index != 0>
	                		<tr class="t_content" style="height:35px;line-height:35px;text-align:center;border-bottom:1px solid #CACACA">
				                  <td>${info.commodityCode}</td>
				                  <td>${info.color}</td>
				                  <td>${info.spec}</td>
				                  <td>${info.size}</td>
				                  <td>${info.currency}</td>
				                  <td>${info.number}</td>
				                  <td>${info.rePrice}</td>
				                  <td>${info.totalPrice}</td>
				                  <td><a>${info.trackingNum}</a></td>
				             </tr>
                		</#if>
                	</#list>
                	
                </#list>
	            
              </table>
            </div>
            <div class="step2-txt">
              <textarea id='remark' readonly>${order.remark}</textarea>
            </div>
        </div>
      </div>



         <p class="pline" style="margin: 16px -50px;" ></p>
        <div class="content_block">
          <div class="content summaryContent">
            <ul>
              <li>
                <label>商品金额：</label>
                <div><span class="number">${order.totalPrice}</span>元</div>
              </li>
              <!-- <li>
                <label>配送费用：</label>
                <div><span class="color_gray">（满99元包邮）</span><span class="number">${(order.carriage!'0')?number?string('0.00')}</span>元</div>
              </li> -->
              <li>
                <label>支付金额：</label>
                <div><span class="number pay_price">${order.payAmount}</span>元</div>
              </li>
            </ul>
          </div>
        </div>
      </div>
     
    </div>
    
  </div>
 
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" style="top: 17px;right: 16px;" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">物流轨迹</h4>
              
            </div>
            <div class="modal-body">
            	<table  id="model-table"  style="border-collapse:separate; border-spacing:10px 15px;"  >
				</table>
            </div>
            
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
  <form id="alipaysubmit" action="${base}/pay/direct-pay-new.htm" method="POST">
  	<input type="hidden" name="order.id" id="alipayOrderId"/>
  	<input type="hidden" name="_token_" value="${_token_!}" />
  </form>

<script src="${base}/static/js/jquery/jquery.min.js?v=2.1.4" type="text/javascript"></script>
<script src="${base}/static/js/distpicker.min.js" type="text/javascript"></script>
<script src="${base}/static/js/jquery.blockUI.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/static/js/localjs/bootstrap.min.js?v=3.3.6" charset="utf-8"></script>
<script src="${base}/static/js/fileupload/vendor/jquery.ui.widget.js"></script>
<script src="${base}/static/js/fileupload/jquery.iframe-transport.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-process.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-validate.js"></script>
<script type="text/javascript">
	
<#list infoList as info>
$('#multupload_${info.itemId}').fileupload({
    url: "${base}/order/excel-order-reUpload",
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
			var a = data.result.obj;
			var HTML = "";
			HTML = HTML +  '<tr style="border-bottom:1px dashed #CACACA;height:55px;line-height:55px;">'
						+		'<th style="width:18%;"><div>商品名称</div></td>'
						+		'<th style="width:12%;"><div>批次号</div></td>'
						+		'<th style="width:14%;"><div>商品编号</div></td>'
						+		'<th style="width:12%;"><div>规格</div></td>'
						+		'<th style="width:10%;"><div>数量</div></td>'
						+		'<th style="width:11.5%;"><div>单价(单位:元)</div></td>'
						+		'<th style="width:13%;"><div>总价(单位:元)</div></td>'
						+		'<th style="width:9.5%;"><div>操作</div></td>'
						+	'</tr>'
       			for(var i=0;i<data.result.obj.length;i++){
       				for(var j=0;j<data.result.obj[i].infoList.length;j++){
       					if(j==0){
	       	HTML = HTML +	'<tr class="t_content" style="height:35px;line-height:35px;text-align:center;border-bottom:1px solid #CACACA">'
					    +        '<td rowspan='+data.result.obj[i].infoList.length+' style="display:table-cell; vertical-align:middle"><div style="width:80%;margin:auto">'+data.result.obj[i].infoList[j].commodityName+'</div></td>'
					    +        '<td rowspan='+data.result.obj[i].infoList.length+' style="display:table-cell; vertical-align:middle">'+data.result.obj[i].infoList[j].batch+'</td>'
					    +       '<td>'+data.result.obj[i].infoList[j].commodityCode+'</td>'
					    +        '<td>'+data.result.obj[i].infoList[j].spec+'</td>'
					    +       '<td>'+data.result.obj[i].infoList[j].number+'5454564'+data.result.obj[i].infoList.length+'</td>'
					    +        '<td>'+data.result.obj[i].infoList[j].rePrice+'</td>'
					    +        '<td>'+data.result.obj[i].infoList[j].totalPrice+'</td>'
					    +        '<td rowspan='+data.result.obj[i].infoList.length+'>'
				if(data.result.obj[i].infoList[j].type==1 || data.result.obj[i].infoList[j].type==2){
			HTML = HTML	+				'<div style="color:red;text-decoration:underline;cursor:pointer;" onclick="addImage('+data.result.obj[i].infoList[j].itemId+')">重新上传↑</div>'
				}
			HTML = HTML	+        		'<input id="multupload_'+data.result.obj[i].infoList[j].itemId+'" lang="'+data.result.obj[i].infoList[j].type+'"  type="file" name="file"  style="display:none">'
				if(data.result.obj[i].infoList[j].type==1 || data.result.obj[i].infoList[j].type==2){
			HTML = HTML +        		'<div><a style="color:red;text-decoration:underline" href="${base}/down-load-file-excel.html?FileUrl=$'+data.result.obj[i].infoList[j].fileUrl+'&itemId='+data.result.obj[i].infoList[j].itemId+'">文件下载↓</a></div>'
				}
			HTML = HTML	+        '</td>'
					    +   '</tr>'
       					}else{
       		HTML = HTML +	'<tr class="t_content" style="height:35px;line-height:35px;text-align:center;border-bottom:1px solid #CACACA">'
			            +      '<td>'+data.result.obj[i].infoList[j].commodityCode+'</td>'
			            +      '<td>'+data.result.obj[i].infoList[j].spec+'</td>'
			            +      '<td>'+data.result.obj[i].infoList[j].number+'</td>'
			            +      '<td>'+data.result.obj[i].infoList[j].rePrice+'</td>'
			            +      '<td>'+data.result.obj[i].infoList[j].totalPrice+'</td>'
			            + 	'</tr>'
       					}
       				}
       			}
            
            
            $("#table").html(HTML);
            
            
            
          
  
            window.location.reload();//刷新当前页面.
			
			
			
			
			
			
			
			
			
			
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
	$('#multupload_${info.itemId}').bind('fileuploadsubmit', function (e, data) {
	    data.formData = { itemId: "${info.itemId}",type: $("#multupload_${info.itemId}").attr("lang")};  //如果需要额外添加参数可以在这里添加
	});
</#list>


function addImage(a){
	$("#multupload_"+a+"").click();
}



function trackingInfo(trackingNum){
	
 $('#myModal').modal('show');
	 $.ajax({
		url : '/trackingInfo/' + trackingNum +'.html' ,
		dataType: "json",
		success:function(data){
			
			for(var i in data) {
				var html="";
				html+="<tr><td>" + data[i].acceptTime+ "</td><td>"+ data[i].acceptStation +"<td></td>"+ data[i].remark  +"</tr>";
				var tb=$("#model-table");
				tb.append(html);
			}

		}
	 })
}
$('#myModal').on('hidden.bs.modal', function () {
	var tb=$("#model-table");
	tb.empty();
});
</script>

