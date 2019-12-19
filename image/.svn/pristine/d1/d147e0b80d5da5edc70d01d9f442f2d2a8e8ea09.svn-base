
<style type="text/css"> 
/*弹出层的STYLE*/ 
html,body {height:100%; margin:0px; font-size:12px;} 

.mydiv { 
background-color: #FFFFFF; 
text-align: center; 
font-size: 12px; 
font-weight: bold; 
z-index:99; 
width: 400px; 
height: 150px; 
left:46%;/*FF IE7*/ 
top: 30%;/*FF IE7*/ 

margin-left:-150px!important;/*FF IE7 该值为本身宽的一半 */ 
margin-top:-60px!important;/*FF IE7 该值为本身高的一半*/ 

margin-top:0px; 

position:fixed!important;/*FF IE7*/ 
position:absolute;/*IE6*/ 

_top: expression(eval(document.compatMode && 
document.compatMode=='CSS1Compat') ? 
documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/ 
document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);/*IE5 IE5.5*/ 

} 

.bg { 
background-color: #ccc; 
width: 100%; 
height: 100%; 
left:0; 
top:0;/*FF IE7*/ 
filter:alpha(opacity=50);/*IE*/ 
opacity:0.5;/*FF*/ 
z-index:1; 

position:fixed!important;/*FF IE7*/ 
position:absolute;/*IE6*/ 

_top: expression(eval(document.compatMode && 
document.compatMode=='CSS1Compat') ? 
documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 :/*IE6*/ 
document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);/*IE5 IE5.5*/ 

} 
/*The END*/ 

</style> 


<#setting classic_compatible=true>
<link rel="stylesheet" href="${base}/static/css/new/sidebar.css" type="text/css" media="screen"/>
<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-12px;"  alt=""/></a></div>
    <div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black">生产中的订单</div></div>
    <#--<div class="I_step"><img src="${base}/static/images/new/01_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li class="red">确认商品</li>
        <li>支付订单</li>
        <li>上传文件</li>
        <li>等待审核</li>
        <li>等待收货</li>  
      </ul>
    </div> --> 
  </div>
</div> 
<!--中间内容↓--> 
<div class="bjf7 p20">
  <div class="user of">
     <#include "/layout/sidebar.ftl">
	<form id="loginForm" action="http://private.haoyin.com/authz/login.htm" method="POST" target="_blank" style="display:none;">
	      <input type="hidden" name="login.loginName" value="${user.loginName!}" />
	      <input type="hidden" name="login.hashed" value="${user.hashed}" />
	  	  <input type="hidden" name="returnUrl" value="//private.haoyin.com/private/private-template.htm" />
    </form>
	  <form id="alipaysubmit" action="${base}/pay/direct-pay-new.html" method="POST">
	  	<input type="hidden" name="orderId" id="alipayOrderId"/>
	  	<input type="hidden" name="token" value="${_token_!}" />
	  </form>
	  <form id="yeepaysubmit" action="${base}/pay/yee-pay-new.html" method="POST">
	  	<input type="hidden" name="orderId" id="yeepayOrderId"/>
	  	<input type="hidden" name="token" value="${_token_!}" />
	  </form>
	  <form id="goonpaysubmit" action="${base}/order/order-go-on-pay.html" method="POST"><!-- 继续支付 可以选择支付方式修改收货地址 -->
	  	<input type="hidden" name="orderId" id="goOnOrderId"/>
	  	<input type="hidden" name="token" value="${_token_!}" />
	  </form>
    <form id="queryForm" action="${base}/order/ongoing-order.html" method="POST">
    	<input type="hidden" name="startTime" value="${query.startTime}" />
    	<input type="hidden" name="endTime" value="${query.endTime}" />
    	<input type="hidden" name="orderId" value="${query.orderId}" />
    	<input type="hidden" name="orderNo" value="${query.orderNo}" />
    	<input type="hidden" name="companyName" value="${query.companyName}" />
    	<input type="hidden" name="scoutStatus" value=" <#if query.payStatus == 0 > 3 <#else> ${order.scoutStatus}</#if>"  />
	</form>
	<form id="updateForm" action="${base}/order/update-order-detail.html" method="POST">
    	<input type="hidden" name="updateOrderId" />
	</form>
    <div class="user-con pb0">
       <#if fanxianInfo?exists> 
	      <div class="right_con_middle">
	     	 <img src="${base}/default/images/new/horn.png" /><span class="record">截止${fanxianInfo[0]}月${fanxianInfo[1]}日,您已消费${fanxianInfo[2]}元,还差
	     	 	<span class="red">${fanxianInfo[3]}</span>元,可奖励<span class="red">${fanxianInfo[4]}</span>元,
	     	 	当前可奖励<span class="red">${fanxianInfo[5]}</span>元,已累计奖励<span class="red">${fanxianInfo[6]}</span>元
	     	</span>
	      </div>
      </#if>
      <div class="right_con">
        <div>
          <div class="right_title">我的订单</div>
          <div class="mt10">
          	订单号：
		  	<input name="orderInput" id="orderInput" type="text" value="${query.orderNo}"/>
		  	&nbsp;公司名&nbsp;
		  	<select id="oemSelect" style="width: 160px; padding: 4px;" >
		  		<option value=""></option>          	
          		<#list CompanyList as CompanyName>
          		<option value="${CompanyName}">${CompanyName}</option>
          		</#list>
		  	</select>
		  	&nbsp;状态&nbsp;
		  	<select id="statusSelect" style="width: 160px; padding: 4px;" >
		  		<option value=""></option>          	
          		<option value="3" >待支付</option>
          		
          		<option value="0" >待接单</option>
          		
          		<option value="1" >生产中</option>
          		
          		<option value="-1" >待退款</option>
          		
		  	</select>
          </div>
          <div class="mt10">
          	下单时间：
		  	<input type="text" id="startTime" class="Wdate" value="<#if query.startTime?exists>${query.startTime}</#if>" style="width: 160px; padding: 4px;" />
		  	&nbsp;到&nbsp;
		  	<input type="text" id="endTime" class="Wdate" value="<#if query.endTime?exists>${query.endTime}</#if>" style="width: 160px; padding: 4px;" />
		  	&nbsp;&nbsp;&nbsp;<input class="searchBtn" type="button" value="查 询" style="float:right" >
          </div>
          <div class="order" style="margin-top: 16px;" >
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr-a">
                <td><div class="info" style="width: 155px;" >商品信息</div></td>
                <td><div class="service">商品数量</div></td>
                <td><div class="number">公司名</div></td>
                <td><div class="money">订单总额</div></td>
                <td><div class="state">状态</div></td>
                <td><div class="money">接单时间</div></td>
                <td><div class="money">预计完成时间(节假日顺延)</div></td>
                <td><div class="operation">操作</div></td>
              </tr>
            </table>
			<#if query.items!=0> 
			 <#list orderList as order>
            <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 18px;">
              <tr class="tr-b" style="background-color: #f7f7f7;height: 36px;" >
                <td colspan="7">
                	
                		<span class="fl ml20">${order.orderNo}</span>
                		<span class="fr mr20"><#if order.payTime?exists>${order.payTime?string('yyyy-MM-dd')}</#if></span>
               
                </td>
              </tr>
              <tr class="tr-c">
                <td class="td-a" style="width: 332px;">
	                <#list order.itemList as item>
		                <div class="of pt10 pb10 border-d">
		                    <div class="img fl ml10 mr10"><img src="${item.imageUrl!''}" width="80" height="80"  alt=""/></div>
		                    <div class="fl" style="float:right;line-height: 68px;" >
		                    	<div>
			                    	<div class="number fl mt8">${item.number!''}</div>
								</div>
								<div class="itemsize" hidden>
									<#if item.spuName=='代理商定制'>
										<span class="size">${order.remark!''}</span>+${item.count!''}${item.unit!''}<span class="binding"></span>
									</#if>
								</div>
		                    </div>
		                 </div>
	                  </#list>
				</td>
                <td ><div class="pay">
                    <p   style="width:100%" >${order.companyName}</p>
                  </div></td>
                	<#if 0==(order.scoutStatus!10)>
                	<#if 0==(order.payStatus!0)>
                  	<td><div class="operation">${order.totalPrice}</div></td>
                  	
                  	</div>
                	<td><div class="operation">	
                	<#if (order.payMode!0)==2>线下支付<#else>待支付</#if>
                		<#if (order.offlinePayStatus!0)==0 && (order.payMode!0)==2><div>待确认</div></#if>
                		<#if (order.offlinePayStatus!0)==-1 && (order.payMode!0)==2><div>已驳回</div></#if>
                	</div>
                	</td>
                	<td><div class="operation">	
                	<#if order.receiptTime?exists>${order.receiptTime?date}</#if></div>
                	</td>
                	<td><div class="operation">	
                	</div>
                	</td>
                	<#else>
                	<td><div class="operation">${order.totalPrice}</div></td>
                  	
                	<td><div class="operation">	
                	待接单</div></div></td>
                	<td><div class="operation">	
                	<#if order.receiptTime?exists>${order.receiptTime?date}</#if></div>
                	</td>
                	<td><div class="operation">	
                	</div>
                	</td>
                	</#if>
                <#elseif 1==(order.scoutStatus!10)>
                	<td><div class="operation">${order.totalPrice}</div></td>
                  	
                	<td><div class="operation">	
                	生产中</div>
                	</td>
                	<td><div class="operation">	
                	<#if order.receiptTime?exists>${order.receiptTime?date}</#if></div>
                	</td>
                	<td><div class="operation">	
                	</div>
                	</td>
                <#elseif -1==(order.scoutStatus!10)>
                	<td><div class="operation">${order.totalPrice}</div></td>
                  	
                	<td><div class="operation">	
                	待退款</div>
                	</td>
                	<td><div class="operation">	
                	<#if order.receiptTime?exists>${order.receiptTime?date}</#if></div>
                	</td>
                	<td><div class="operation">	
                	</div>
                	</td>
                <#elseif 20==(order.scoutStatus!10)>
                    <td><div class="state red">待上传文件</div></td>
                	<td><div class="operation"><a class="a-b" href="${base}/order/uploadOrder-${order.id?c}.html">上传文件</a>
                	<a class="a-c botton" onClick="javascript: setStatus('${order.id?c}',80)">申请退款</a>
                	<a href="${base}/order/order-${order.id?c}.html" target="_blank" class="a-a">订单详情</a></div></td>
                <#elseif 30==(order.scoutStatus!10)>
                	<#if order.approveStatus==1||order.approveStatus==0>
                		<td><div class="state">待审核<p class="color999">订单审核中</p></div></td>
                		<td><div class="operation"><a href="${base}/order/order-${order.id?c}.html" class="a-a">订单详情</a></div></td>
                	<#elseif order.approveStatus==-1>
                	  	<td><div class="state color999">审核不通过</div></td>
               		 	<td><div class="operation"><a class="a-c botton" href="${base}/order/uploadOrder-${order.id?c}.html">上传设计稿</a>
               		 	<a class="a-c botton" onClick="javascript: setStatus('${order.id?c}',80)">申请退款</a>
               		 	<a href="${base}/order/order-${order.id?c}.html" target="_blank" class="a-a">订单详情</a></div></td>
                	</#if>
 				 <#elseif 35==(order.scoutStatus!10)>
                	  	<td><div class="state red">用户确认文件</div></td>
               		 	<td><div class="operation"><a class="a-c botton" href="${base}/order/uploadConfirm-${order.id?c}.html">查看文件</a>
               		 	<a href="${base}/order/order-${order.id?c}.html" target="_blank" class="a-a">订单详情</a></div></td>
               	<#elseif 36==(order.scoutStatus!10) || 37==(order.scoutStatus!10)>
                	 <td><div class="state color999">${order.totalPrice}</div></td>
               		 <td><div class="operation">待收货</div></td>
               <#elseif 40==(order.scoutStatus!10)>
                	<td><div class="state color999">${order.totalPrice}</div></td>
                	<td><div class="state">等待收货</div></td>
                   <td><div class="operation"><a onClick="javascript: setStatus('${order.id?c}',50)" class="a-c botton">确认收货</a>
                    <a href="${base}/order/order-${order.id?c}.html" target="_blank" class="a-a">订单详情</a></div></td> 
              	 <#elseif 2==(order.scoutStatus!10)>
                	 <td><div class="state color999">${order.totalPrice}</div></td>
               		 <td><div class="operation">已完成
               		 </div></td> 
                <#elseif 60==(order.scoutStatus!10)>
                	<td><div class="state">待处理<p class="color999">售后处理中</p></div></td>
                	<td><div class="operation"><a href="${base}/order/order-${order.id?c}.html" class="a-a">订单详情</a></div></td>
                <#elseif 70==(order.scoutStatus!10)>
                	<td><div class="state color999">售后处理完成</div></td>
                	<td><div class="operation"><a href="${base}/order/order-${order.id?c}.html" class="a-a">订单详情</a></div></td>
                <#elseif 80==(order.scoutStatus!10)>
                	<td><div class="state color999">退款中</div></td>
                 	<td><div class="operation"><a href="${base}/order/order-${order.id?c}.html" class="a-a">订单详情</a></div></td>
                <#elseif 90==(order.scoutStatus!10)>
                	<td><div class="state color999">已退款</div></td>
                	<td><div class="operation"><a href="${base}/order/order-${order.id?c}.html" class="a-a">订单详情</a></div></td>
                </#if>
                	<td>
                	<#if 0==(order.scoutStatus!10) && 0==(order.payStatus!0) && order.userId==userId && 1==(order.payMode!0)>
                		<!-- <#if 2==(order.payMode!0)><#else><div class="operation"><a class="a-b" onClick="javascript: directPay('${order.id?c}')">立即支付</a></div></#if>  -->
                		<#if 2==(order.payMode!0)><#else><div class="operation"><a class="a-b" onClick="javascript: goOnPay('${order.id?c}')">立即支付</a></div></#if> 
                	</#if>
                	 <#if 0==(order.scoutStatus!10) && 0==(order.payStatus!0) && order.userId==userId && 3==(order.payMode!0)>
                		<!-- <#if 2==(order.payMode!0)><#else><div class="operation"><a class="a-b" onClick="javascript: directYeePay('${order.id?c}')">立即支付</a></div></#if> -->
                		<#if 2==(order.payMode!0)><#else><div class="operation"><a class="a-b" onClick="javascript: goOnPay('${order.id?c}')">立即支付</a></div></#if>  
                	</#if>                   	
                	<#if (order.scoutStatus!0)==-1>
                			<div class="operation"><a class="a-a" target="__blank" style="color:red;text-decoration:none;">已取消</a></div><!-- 取消订单 -->
                	</#if>
                	<#if 0==(order.scoutStatus!10) && order.userId==userId>
                		<#if (order.offlinePayStatus!0)==-1 && (order.payMode!0)==2>
                			<div class="operation"><a class="a-b" style="cursor:pointer" onClick="javascript: updateOrder('${order.id?c}')">重新提交</a></div><!-- 待支付取消订单 -->
                		</#if>
	                	<#if 0==(order.payStatus!0)>
							<div class="operation"><a class="a-b" style="cursor:pointer" onClick="javascript: cancelOrder('${order.orderNo}','${order.id?c}','0','${order.payMode}')">取消订单</a></div><!-- 待支付取消订单 -->
	                	<#else>
	  						<div class="operation"><a class="a-b" style="cursor:pointer" onClick="javascript: cancelOrder('${order.orderNo}','${order.id?c}','1','${order.payMode}')">取消订单</a></div><!-- 待接单取消订单 -->
	                	</#if>
                	<#elseif 1==(order.scoutStatus!10) && order.userId==userId>
                			<div class="operation"><a class="a-b" style="cursor:pointer" onClick="javascript: cancelOrder('${order.orderNo}','${order.id?c}','2','${order.payMode}')">取消订单</a></div><!-- 生产中取消订单 -->
                	</#if>
                	
                	
                	<div class="operation"><a href="${base}/order/order-${order.id?c}.html" target="__blank" class="a-a">订单详情</a></div>
                	</td>
               </tr>
            </table>
      	  </#list>
      	  <#else>
            <dd>
              <p style="padding:10px;padding-left:280px;">您目前还没有订单，请选择您喜欢的商品下单！</p>
            </dd>
         </#if>
          </div>
        </div>
        <div class="page-m">
        	<#--<a class="hebing fl ml5">合并支付</a>-->
       		 <#include "/layout/pagination.ftl">
     		<div class="clear"></div>
        </div>
        <div class="h5">&nbsp;</div>
      </div>
    </div>
  </div>
</div>
</div>


<script type="text/javascript"> 

function showDiv(){ 
	document.getElementById('popDiv').style.display='block'; 
	document.getElementById('bg').style.display='block'; 
	} 
function goPaySuccess(){ 
	var orderId = $("#paySuccess").val();
	location.href="${base}/org/pay/weixinpaysuccess.htm?order.id="+orderId;
	} 
	function closeDiv(){ 
	document.getElementById('popDiv').style.display='none'; 
	document.getElementById('bg').style.display='none'; 
	} 

</script> 


<div id="popDiv" class="mydiv" style="display:none;">
	
<div style="margin-left:-300px;font-size:14px;">取消订单</div>
	
	
</div> 
<div id="bg" class="bg" style="display:none;"></div> 


<script src="${base}/static/js/jquery/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/static/js/date/WdatePicker.js"></script>
<script type="text/javascript">
	function updateOrder(orderId){
		$('input[name="updateOrderId"]').val(orderId);
		$("#updateForm").submit();
	}

	function cancelOrder(orderNo,orderId,type,payMode){
		var HTMLS = "";
		HTMLS=  HTMLS+ '<div style="margin-left:-300px;font-size:14px;margin-top:10px;">取消订单</div>'
					 + '<div style="border:0.5px solid gray;width:360px;margin-left:20px;margin-top:10px;"></div>'
		if(type==0){
			HTMLS=  HTMLS+ '<div style="font-size:14px;"><div style="margin-left:20px;text-align:left;margin-top:10px;">是否取消订单'+orderNo+'？</div></div>'
		}else if(type==1){//待接单取消订单
			HTMLS=  HTMLS+ '<div style="font-size:14px;"><div style="margin-left:20px;text-align:left;">是否取消订单'+orderNo+'？</div></div>'
		}else if(type==2){//生产中取消订单
			HTMLS=  HTMLS+ '<div style="font-size:14px;"><div style="margin-left:20px;text-align:left;">订单'+orderNo+'状态为<span style="color:red">"进行中"</span>,是否确认取消此订单？取消后此订单<span style="color:red">不做退款、发货</span>处理</div></div>'
		}
			HTMLS=  HTMLS + '<button class="btn btn-primary btn-lg" onclick="javascript:closeDiv()" style="margin-top:20px;width:100px;background-color:#FFFFFF;border:1px solid red;color:#192019;">返回</button>'
		 				+ '<button class="btn btn-primary btn-lg" onclick="javascript:cancelOrderYes(\''+orderNo+'\',\''+orderId+'\',\''+type+'\',\''+payMode+'\')" style="margin-left:20%;width:100px;background-color:#FFFFFF;color:#192019;margin-top:20px;border:1px solid red;">确认</button>';
		
		$("#popDiv").html(HTMLS);
		showDiv();		
	}
	
	function cancelOrderYes(orderNo,orderId,type,payMode){	 
		if(type==0){//待支付取消订单
			if(payMode==2){//线下支付时不删除订单  改为退款
				$.post("${base}/order/cancel-order.htm?orderId="+orderId+"&type="+"1",function(data){
					if(data.success){
						alert(orderNo+"订单已取消，退款金额将会在3-7个工作日原路返回，请注意查收");
						top.location.href = "${base}/order/ongoing-order.html";
					}
				},"json");
			}else{
				$.post("${base}/order/remove-order.htm?orderId="+orderId,function(data){
					if(data.success){
						alert(orderNo+"订单取消成功");
						top.location.href = "${base}/order/ongoing-order.html";
					}
				},"json");
			}
		}else if(type==1){//待接单取消订单
			$.post("${base}/order/cancel-order.htm?orderId="+orderId+"&type="+type,function(data){
				if(data.success){
					alert(orderNo+"订单已取消，退款金额将会在3-7个工作日原路返回，请注意查收");
					top.location.href = "${base}/order/ongoing-order.html";
				}
			},"json");
		}else if(type==2){//生产中取消订单
			$.post("${base}/order/cancel-order.htm?orderId="+orderId+"&type="+type,function(data){
				if(data.success){
					alert(orderNo+"订单取消成功");
					top.location.href = "${base}/order/ongoing-order.html";
				}
			},"json");
		}
	}


	$(function() {
	 	var orderNo="${query.orderNo}";
	 	//orderId=orderId.replace(/,/g , "");
		$("#orderInput").val(orderNo);
		$("#oemSelect").val('${query.oemName}');
		if('${query.scoutStatus!''}'=='0' && '${query.payStatus!''}'=='0'){
		$("#statusSelect").val('3')
		}else{
		$("#statusSelect").val('${query.scoutStatus}')
		}
		$("#startTime").focus(function() {
			var endTime = $("#endTime").val();
			if (endTime != "") {
				var datetime = new Date(Date.parse(endTime.replace(/-/g, "/")));
				datetime.setMinutes(datetime.getMinutes() - 1);
				endTime = datetime.toLocaleString();
				WdatePicker({
					dateFmt : 'yyyy-MM-dd H:mm:00',
					maxDate : endTime
				});
			} else {
				WdatePicker({
					dateFmt : 'yyyy-MM-dd H:mm:00',
					minDate : '2011-01-01 00:00:00',
					maxDate : '%y-%M-%d {%H}:{%m}:00'
				});
			}
		});
		$("#endTime").focus(function() {
			var startTime = $("#startTime").val();
			if (startTime != "") {
				var datetime = new Date(Date.parse(startTime.replace(/-/g, "/")));
				datetime.setMinutes(datetime.getMinutes() + 1);
				startTime = datetime.toLocaleString();
				WdatePicker({
					dateFmt : 'yyyy-MM-dd H:mm:00',
					minDate : startTime
				});
			} else {
				WdatePicker({
					dateFmt : 'yyyy-MM-dd H:mm:00',
					minDate : '%y-%M-%d {%H}:{%m+2}:00'
				});
			}
		});
		$('input.searchBtn').click(function(){
			$('input[name="startTime"]').val( $("#startTime").val());
			$('input[name="endTime"]').val($("#endTime").val());
			$('input[name="orderNo"]').val($("#orderInput").val());
			$('input[name="companyName"]').val($("#oemSelect option:selected").val());
			$('input[name="scoutStatus"]').val($("#statusSelect option:selected").val());
			$('#queryForm').submit();
		});
		
		$('.itemsize').each(function(i,value){
			var $t = $(this).find('span.size');
			var arr = $.trim($t.text()).split('；');
			var size = '';
			var binding = '';
			var str = '';
			for(var i=0;i<arr.length;i++){
				if(arr[i].indexOf('A3')!=-1 || arr[i].indexOf('A4')!=-1 || arr[i].indexOf('A5')!=-1 || arr[i].indexOf('A6')!=-1 || arr[i].indexOf('B2')!=-1){
					if(arr[i].indexOf('A')!=-1){
						size = arr[i].substr(arr[i].indexOf('A'),2);
					}else{
						size = arr[i].substr(arr[i].indexOf('B'),2);
					}
				}else{
					if(arr[i].indexOf('长边')!=-1){
						size = arr[i].replace('纸张尺寸：','').replace('|','');
					}
				}
				if(arr[i].indexOf('装订：')!=-1){
					binding = $.trim(arr[i].replace('装订：','').replace('|',''));
				}
			}
			switch(size){
				case 'A3':
					str = '450mm*310mm';
					break;
				case 'A4':
					str = '297mm*210mm';
					break;
				case 'A5':
					str = '145mm*210mm';
					break;
				case 'A6':
					str = '105mm*148mm';
					break;
				case 'B2':
					str = '500mm*706mm';
					break;
				default:
					str = size.replace(' ','').replace('长边-','').replace('短边-','mm*') + 'mm';
					break;
			}
			$t.text(str).end().show();
			$(this).find('span.binding').text(binding==''?'':'+'+binding);
		});
	
		$('a[name="search"]').click(function() {
			$('input[name="query.payStatus"]').val( $(this).attr('id') );
			$('#queryForm').submit();
		});
		$('#searchSelect').change(function() {
			$('#queryForm').submit();
		});
		$('#privateTemp').click(function() {
			$('#loginForm').submit();
		});
		$("a[name='inval_order']").click(function() {
			var id = $(this).attr( 'id' );
			if (confirm( "您确定要取消此订单吗?" )) {
				$.get("${base}/order/inval-order.html", { id : id }, function(data){
					if (data == 'success') {
						$('#queryForm').submit();
					} else {
						alert(data);
					} 
					return false;
				}, "text");
			}
		});
	});
	
	
	function delOrder(orderId){
		if (confirm('确定要删除此订单吗？')) {
			$.post("${base}/order/remove-order.html?id="+orderId, function(data) {
				top.location.href = "${base}/order/my-orders.html";
			}, 'json');
		}
	}
	function mutlSubmit(idList){
		if (confirm('确定要合并付款吗？')) {
			top.location.href = "${base}/order/mutl-sub-order.html?id="+idList; 
		}
	}
	function setStatus(orderId,status){
		$.post("${base}/order/status-order.html?id="+orderId+"&status="+status, function(data) {
			if(data){
			top.location.href = "${base}/order/ongoing-order.html";
			}
		}, 'json');
	}
	function directPay(orderId){
		$("#alipayOrderId").attr("value",orderId);
		$("#alipaysubmit").submit();
	}
	function directYeePay(orderId){
		$("#yeepayOrderId").attr("value",orderId);
		$("#yeepaysubmit").submit();
	}
	function goOnPay(orderId){
		$("#goOnOrderId").attr("value",orderId);
		$("#goonpaysubmit").submit();
	}
</script>
