<#setting classic_compatible=true>
<link rel="stylesheet" href="${base}/static/css/new/sidebar.css" type="text/css" media="screen"/>
<!--中间内容↓-->
<div class="bjf7 p20">
  <div class="user of">
     <#include "/layout/sidebar.ftl">
	<form id="queryForm" method="post" action="" >
		<input  type="hidden" name="fileType" id="fileType" />
		<input  type="hidden" name="uploadUsername" id="uploadUsername" />
		<input  type="hidden" name="status" id="status" />
		<input  type="hidden" name="startTime" id="startTime" />
		<input  type="hidden" name="endTime" id="endTime" />
	</form>
    <div class="user-con pb0">
       
      <div class="right_con">
        <div>
          <div class="right_title">开票记录</div>
      		
      		<hr style="border:1px dashed #FFFFFF; height:1px">
      	
          <div class="order" id="orderList">
            <table style="border-collapse:collapse; border-spacing:0px 10px;font-size:15px;border: solid thin 	#D8D8D8" bordercolor="#D8D8D8" width="100%" border="1" cellspacing="0" cellpadding="0">
              <tr class="tr-a">
                <td >申请开票日期</td>
                <td>开票类别</td>
                <td>开票金额</td>
                <td>开票状态</td>
                <td>物流信息</td>
              </tr>
              <#list invoices as info>
              <tr>
                <td height="50px"><div style="font-size:15px;">${info.createGmt}</div></td>
                <td height="50px"><div style="font-size:15px;"><#if '${info.type}'==0>按订单开票<#else>按金额开票</#if></div></td>
                <td height="50px"><div style="font-size:15px;">${info.invMoney}元</div></td>
                <td height="50px"><div style="font-size:15px;"><#if '${info.invoiceStatus}'==0>未开票<#elseif '${info.invoiceStatus}'==1>已开票</#if></div></td>
                <td height="50px"><div style="font-size:15px;"><#if info.logistics??>${info.logistics}<#else>暂无物流信息</#if></div></td>
              </tr>
              </#list>
            </table>
            
            
          </div>
          
        </div>
        	<div class="page-m">
	       		 <#include "/layout/pagination.ftl">
	     		<div class="clear"></div>
        	</div>
        	
        <div class="h5">&nbsp;</div>
      </div>
    </div>
  </div>
</div>

    
<script src="${base}/static/js/jquery/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/static/js/date/WdatePicker.js"></script>
<script type="text/javascript">
$(function() {
	
	
})
</script>