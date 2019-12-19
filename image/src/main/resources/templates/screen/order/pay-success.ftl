<#setting classic_compatible=true>


 <link rel="stylesheet" href="${base}/static/css/sidebar.css" type="text/css" media="screen"/>
 <link rel="stylesheet" href="${base}/static/css/jquery.fileupload.min.css">
<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header-step.css" type="text/css" media="screen"/>
<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-12px;"  alt=""/></a></div>
    <div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black">支付订单</div></div>
   <div class="I_step"><img src="${base}/static/images/new/02_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li >确认订单</li>
        <li class="red">支付订单</li>
        <li>待接单</li>
        <li>生产中</li>
        <li>已完成</li>
      </ul>
    </div> 
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
	  		<div class="right_con" style="display: flex;text-align: center;">
						
						<div style="margin: auto;padding-top:200px;padding-bottom:200px;">
							
							<table>
								<tr>
									<td>
										<img alt="" src="${base}/static/images/success_wx.png">
										<div style="color:red;font-size:14px;font-weight:800;">支付成功</div>
									</td>
									<td style="text-align:left;">
										<div style="margin-left:15px;">
											<div style="font-size:14px;font-weight:800;">订单编号:${order.orderNo}</div>
											<div style="margin-top:10px;font-size:14px;font-weight:800;">订单金额：<span style="color:red;">${order.totalPrice}</span>元</div>
											<div style="margin-top:10px;font-size:14px;font-weight:800;">收货信息：${order.linkman} &nbsp;&nbsp;&nbsp; ${order.province} ${order.city}  ${order.address} </div>
										</div>
									</td>
								</tr>
							</table>
						</div>


			</div>
		</div>
	</div>
</div>

<script src="${base}/static/js/jquery.min.js"></script>
<script src="${base}/static/js/fileupload/vendor/jquery.ui.widget.js"></script>
<script src="${base}/static/js/fileupload/jquery.iframe-transport.js"></script>




