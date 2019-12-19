<#setting classic_compatible=true>
<link rel="stylesheet" href="${base}/static/css/new/sidebar.css" type="text/css" media="screen"/>
<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-12px;"  alt=""/></a></div>
    <div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black">已完成的订单</div></div>
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
	  <form id="alipaysubmit" action="${base}/pay/direct-pay-unionpay.html" method="POST">
	  	<input type="hidden" name="orderId" id="alipayOrderId"/>
	  	<input type="hidden" name="token" value="${_token_!}" />
	  </form>
    <form id="queryForm" action="${base}/order/finished-order.html" method="POST">
    	<input type="hidden" name="startTime" value="${query.startTime}" />
    	<input type="hidden" name="endTime" value="${query.endTime}" />
    	<input type="hidden" name="orderNo"  value="${query.orderNo}" />
    	<input type="hidden" name="companyName" value="${query.companyName}" />
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
          		<option value="${CompanyName}" >${CompanyName}</option>
          		</#list>
		  	</select>
          	&nbsp;下单时间：&nbsp;
		  	<input type="text" id="startTime" class="Wdate" value="<#if query.startTime?exists>${query.startTime}</#if>" style="width: 160px; padding: 4px;" />
		  	&nbsp;到&nbsp;
		  	<input type="text" id="endTime" class="Wdate" value="<#if query.endTime?exists>${query.endTime}</#if>" style="width: 160px; padding: 4px;" />
		  	&nbsp;&nbsp;&nbsp;<input class="searchBtn" type="button" value="查 询" style="float:right" >
          </div>
          <div class="order" style="margin-top: 16px;" >
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr-a">
                <td><div class="info" style="width: 265px;" >商品信息</div></td>
                <td><div class="service">商品数量</div></td>
                <td><div class="number">公司名</div></td>
                <td><div class="money">订单总额</div></td>
                <td><div class="state">状态</div></td>
                <td><div class="state">接单时间</div></td>
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
                <#if 2==(order.scoutStatus!10)>
                  	<td><div class="state red">${order.totalPrice}</div></td>
                	<td><div class="operation">已完成</div></td>
                	<td><div class="operation"><#if order.receiptTime?exists>${order.receiptTime?date}</#if></div></td>
                 <#elseif -3==(order.scoutStatus!10)>
                	<td><div class="state red">${order.totalPrice}</div></td>
                	<td><div class="operation">已退款</div></td>
                	<td><div class="operation"><#if order.receiptTime?exists>${order.receiptTime?date}</#if></div></td>
                <#elseif -2==(order.scoutStatus!10)>
                	<td><div class="state red">${order.totalPrice}</div></td>
                	<td><div class="operation">已取消</div></td>
                	<td><div class="operation"><#if order.receiptTime?exists>${order.receiptTime?date}</#if></div></td>
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
                	 <td><div class="state color999">待发货</div></td>
               		 <td><div class="operation"><a href="${base}/order/order-${order.id?c}.html" target="_blank" class="a-a">订单详情</a></div></td>
                <#elseif 40==(order.scoutStatus!10)>
                	<td><div class="state">等待收货</div></td>
                    <td><div class="operation"><a onClick="javascript: setStatus('${order.id?c}',50)" class="a-c botton">确认收货</a>
                    <a href="${base}/order/order-${order.id?c}.html" target="_blank" class="a-a">订单详情</a></div></td>
                <#elseif 50==(order.scoutStatus!10)>
                	 <td><div class="state color999">${order.totalPrice}</div></td>
               		 <td><div class="operation"><#--<a class="a-c botton" href="${base}/my/add-back.html?orderId=${order.id?c}&orderNo=${order.orderNo}">申请售后</a> -->
               		 已完成</div></td>
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
                		<div class="operation"><a href="${base}/order/order-${order.id?c}.html" target="_blank" class="a-a">订单详情</a></div>
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
<script src="${base}/static/js/jquery/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/static/js/date/WdatePicker.js"></script>
<script type="text/javascript">
	$(function() {
		var orderNo="${query.orderNo}";
	 	//orderId=orderId.replace(/,/g , "");
		$("#orderInput").val(orderNo);
		$("#oemSelect").val('${query.oemName}');
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
			top.location.href = "${base}/order/my-orders.html";
		}, 'json');
	}
	function directPay(orderId){
		$("#alipayOrderId").attr("value",orderId);
		$("#alipaysubmit").submit();
	}
</script>
