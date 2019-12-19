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
          <div class="right_title">我要开票</div>
      
          	<div style="margin-bottom: 34px;margin-top: 15px;font-size:16px;">
          	当前可开票总金额：
          <b style="margin-top: 15px;font-size:20px;color:red;" id="canMake">${canMake}元</b>
          </div>
          <div style="margin-bottom: 14px;margin-top: 15px;">
          		<input type="button" id="withOrder" name="billing" value="按订单开票" style="width: 200px; padding: 15px;font-size:15px;color:#FFFFFF;background-color:#D00000"  />
          		<!-- <input type="button" id="withMoney" value="按金额开票" name="billing" style="width: 200px; padding: 15px;font-size:15px;color:#FFFFFF;background-color:#C0C0C0" /> -->
          </div>
          <div class="order" id="orderList">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <input type="hidden" id="ids"> 
            <input type="hidden" id="typech" value="0"> 
            <input type="hidden" id="tag" value="0"> 
              <tr class="tr-a">
                <td><input type="checkbox" id="selectAll">&nbsp;&nbsp;全选</td>
                <td>订单金额</td>
                <td>订单号</td>
                <td>商品信息</td>
                <td>下单日期</td>
              </tr>
            </table>
			
            <#list information as info>
            <table style="border-collapse:separate; border-spacing:0px 10px;" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td ><input type="checkbox" name="subclass" value="${info_index}" id="${info_index}" lang="${info.id}" langm="${info.payAmount}">
				</td>
                <td ><div style="font-size:16px;color:#A0A0A0;">${info.payAmount}</div></td>
                <td ><div style="font-size:16px;color:#A0A0A0;">${info.orderNo}</div></td>
                <td ><div style="font-size:16px;color:#A0A0A0;">${info.productInfomation}</div></td>
                <td ><div style="font-size:16px;color:#A0A0A0;">${info.submitTime?string('yyyy-MM-dd HH:mm:ss')}</div></td>
              </tr>
            </table>
            <hr style=" height:1px;border:none;border-top: 1px dashed #D8D8D8;">
             </#list>
            
	            <#--<div class="page-m">
	       		 <#include "/layout/pagination.ftl">
	     		<div class="clear"></div>
	        	</div>-->
            <p style="text-align:right"><b style="margin-top: 15px;font-size:15px;color:red;" id="totalNum"></b>
            		个订单，共计<b style="margin-top: 15px;font-size:20px;color:red;" id="totalMoney" ></b>元</p>
      	  <hr style=" height:1px;border:none;border-top: 2px dashed #D8D8D8;">
            
          </div>
          <div class="order" id="billingList"></div>
          <div class="order">
          		<form>
          			<table style="border-collapse:separate; border-spacing:0px 10px;">
	          			<tr id=moneyNum1><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">开票金额：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 230px;" id="invMoney">
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr id=moneyNum2><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">开票金额：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 230px;">
		          						<input type="text"  id="invMoney2"  name="invMoney2" style="width: 300px;height:28px;" oninput="value=value.replace(/[^\d.]/g,'')"/>
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">公司抬头：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<select  id="companyTitle"  name="companyTitle" style="width: 300px;height:28px;" onchange="gradeChange(this)">
							                    <option value="0" selected = "selected" >请选择公司抬头</option>
		          							<#list invoices as inv>
							                    <option value="${inv.id}" >${inv.companyTitle}</option>
							                </#list>
			                    		</select>
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">纳税人识别号：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<input type="text"  id="taxId"  name="taxId" style="width: 300px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">注册地址：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<input type="text"  id="regAddress"  name="regAddress" style="width: 300px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">注册电话：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<input type="text"  id="regPhone"  name="regPhone" style="width: 300px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">开户银行：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<input type="text"  id="bank"  name="bank" style="width: 300px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">银行账号：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<input type="text"  id="account"  name="account" style="width: 300px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          		</table>	
	          			<hr style=" height:1px;border:none;border-top: 2px dashed #D8D8D8;">
	          		<table style="border-collapse:separate; border-spacing:0px 10px;">	
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">收票人：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<input  type="text" id="taker"  name="taker" style="width: 300px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">收票地址：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<input type="text"  id="billAddress"  name="billAddress" style="width: 300px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:left">
	          						<div style="margin-top: 20px;font-size:16px;width: 130px;">收票人电话：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 20px;font-size:16px;width: 300px;">
		          						<input type="text"  id="billPhone"  name="billPhone" style="width: 300px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			
	          			
          			</table>
          		</form>
          		
          </div>
          <hr style=" height:1px;border:none;border-top: 2px dashed #D8D8D8;">
          	<div style="text-align: center;">
          		<button type="button" id="returnes"  style="background:#FFFFFF;color:#D80000; border: 1px solid #D80000;width: 70px;padding:3px;font-size:15px;" >返 回</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
          		<button type="button" id="submit"  style="background:#FFFFFF;color:#D80000; border: 1px solid #D80000;width: 70px;padding:3px;font-size:15px;" >提 交</button>	
          	</div>
        </div>
        	
        <div class="h5">&nbsp;</div>
      </div>
    </div>
  </div>
</div>

    
<script src="${base}/static/js/jquery/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/static/js/date/WdatePicker.js"></script>
<script type="text/javascript">
	function redOrder(x){
		x.style.backgroundColor="#D00000";
		document.getElementById("withMoney").style.backgroundColor="#C0C0C0";
	};
	<#--function greyOrder(x){
		x.style.background-color="#D00000";
		$("#withMoney").style.background-color="#C0C0C0";
	};-->
	<#-- function redMoney(x){
		x.style.backgroundColor="#D00000";
		document.getElementById("withOrder").style.backgroundColor="#C0C0C0";
	};
	function greyMoney(x){
		x.style.backgroundColor="#C0C0C0";
		document.getElementById("withOrder").style.backgroundColor="#D00000";
	};-->
$(function() {
//默认先隐藏按订单开票的内容
 $("#moneyNum2").hide();
 	
	 var record = 0;
	 var tolMoney=0;
	$("#invMoney").html(tolMoney+"元");
	$("#invMoney").val(tolMoney);
	$("#totalMoney").html(0);
	$("#totalNum").html(0);
	var record2 = Number($("#totalNum").text());
	var tolMoney2=Number($("#totalMoney").text());
	 //返回
	 $("#returnes").click(function() {
	        history.go(-1);
     });
     //选择按金额开票事件
     $("#withMoney").click(function(){
     	$("#tag").val(1);
     	document.getElementById("withMoney").style.backgroundColor="#D00000";
		document.getElementById("withOrder").style.backgroundColor="#C0C0C0";
		$("#orderList").hide();
		$("#moneyNum1").hide();
		$("#moneyNum2").show();
		//$("#canMake").html(${canMake}+"元");
		$("#typech").val(1);
     });
     //选择按订单开票事件
     $("#withOrder").click(function(){
     	$("#tag").val(0);
     	document.getElementById("withMoney").style.backgroundColor="#C0C0C0";
		document.getElementById("withOrder").style.backgroundColor="#D00000";
		$("#orderList").show();
		$("#moneyNum1").show();
		$("#moneyNum2").hide();
		//$("#canMake").html(${totalMoney}+"元");
		$("#typech").val(0);
     });
     
     //全选，取消全选事件
     $("#selectAll").click(function() {
     	if($("#selectAll").prop("checked")){
     		$("input[type='checkbox'][name='subclass']").prop("checked",true);//全选
     	}else{
     		$("input[type='checkbox'][name='subclass']").prop("checked",false);//取消全选
     	}
     	 total();
     });
     //子复选框事件
     $('[name="subclass"]').click(function(){
     	//当没有选中某个子复选框时，SelectAll取消选中
     	if(!$('[name="subclass"]').checked){
     		$("#selectAll").prop("checked",false);
     	}
     	var chsub = $("input[type='checkbox'][name='subclass']").length; //获取subcheck的个数  
	    var checkedsub = $("input[type='checkbox'][name='subclass']:checked").length; //获取选中的subcheck的个数  
	    if (checkedsub == chsub) {  
	        $("#selectAll").prop("checked", true);  
	    }
	     total();
     });
     
		
		function total() {
			var arrChk=$("input[name='subclass']:checked");
			 var totalprice=0;
			 var recordNum=0;
			 var ids="";
  			$(arrChk).each(function(){
  				 <#list information as item>
		    	  	if(${item_index}==this.value){
		    	  		var price=parseFloat($("#"+this.id).attr("langm"));
		    	  		totalprice=totalprice+price;
		    	  		recordNum=recordNum+1;
		    	  		var ids1=$("#"+this.id).attr("lang").replace(/,/g, "");
		    	  		ids=ids+ids1+",";
		    	  	}
		    	  </#list>
    		});
    		$("#totalMoney").html(totalprice.toFixed(2));
    		$("#totalMoney").val(totalprice.toFixed(2));
    		$("#totalNum").html(recordNum);
    		$("#invMoney").html(totalprice.toFixed(2)+"元");
			$("#invMoney").val(totalprice.toFixed(2));
			$("#ids").val(ids);
			if(totalprice>${canMake}){
				alert("订单开票金额不能大于当前可开票金额");
				return false;
			}
		}
		
});

 //select选中事件
     function gradeChange(obj){
       var opt = obj.options[obj.selectedIndex];
        var id=opt.value;
        $.ajax({
			type : "post",
			url : "${base}/invoice/queryInvoiceInformationById.html", 
			data : {id:id},
			dataType : "json",
			success : function(data) {
				 //$("#companyTitle").val(data.companyTitle);
			    $("#taxId").val(data.taxId);
			    $("#regAddress").val(data.regAddress);
			    $("#regPhone").val(data.regPhone);
			    $("#bank").val(data.bank);
			    $("#account").val(data.account);
			    $("#taker").val(data.taker);
			    $("#billAddress").val(data.billAddress);
			    $("#billPhone").val(data.billPhone);
				},error : function(err) {alert(err);}
			});	
       }
       
      //申请开票提交
      $("#submit").click(function(){
    	  
    	if($("#tag").val()==0){//按订单开票
    		var checkedsub = $("input[type='checkbox'][name='subclass']:checked").length; //获取选中的subcheck的个数  
    		if(checkedsub<1){
    			alert("按订单开票时请选择订单！");
    			return;
    		}
        }
    	if($("#companyTitle").val()==0){
    		alert("请选择公司抬头！");
    		return;
    	}
      var inMoney=$("#invMoney2").val();
      var inMoney1=$("#invMoney").val()
      	if(typeof(inMoney)!="undefined" && inMoney>${canMake}){
      		alert("开票金额不能大于当前可开票总额");
      		return false;
      	}
      	if(typeof(inMoney1)!="undefined" && inMoney1>${canMake}){
      		alert("开票金额不能大于当前可开票总额");
      		return false;
      	}
      	var finalMonery;
      	if($("#tag").val()==0){
      		finalMonery=$("#invMoney").val();
      	}else{
      		finalMonery=$("#invMoney2").val();
      		if(finalMonery==""){
      			finalMonery=0;
      		}
      	}
      		var parameterSave={
					companyTitle:$("#companyTitle").find("option:selected").text(),
					taxId:$("#taxId").val(),
					regAddress:$("#regAddress").val(),
					regPhone:$("#regPhone").val(),
					bank:$("#bank").val(),
					account:$("#account").val(),
					invMoney:finalMonery,
					ids:$("#ids").val(),
					taker:$("#taker").val(),
					billAddress:$("#billAddress").val(),
					billPhone:$("#billPhone").val(),
					type:$("#typech").val()
				}
	 			$.ajax({
	                url: "${base}/invoice/makeInvoiceSubmit.html",
	                type: "POST",
	                contentType : 'application/json;charset=utf-8',
	                dataType:"json",
	                data: JSON.stringify(parameterSave),
	                success: function(data){
	                    if (!data.success){ 
	                    	alert("操作失败!");
	                    	$('#save').attr("disabled",false);
							return false; 
	                    }else{
	                    	 alert("添加成功!");
					        window.location="${base}/invoice/makeInvoice.html";
						}
	                },
	                error: function(res){
	                    alert("参数错误!");
	                }
	            });
      });
</script>
<style>
input[type="checkbox"]{width:15px;height:15px;display: inline-block;text-align: center;vertical-align: middle; line-height: 13px;position: relative;}
input[type="checkbox"]::before{content: "";position: absolute;top: 0;left: 0;background: #fff;width: 100%;height: 100%;border: 1px solid #d9d9d9}
input[type="checkbox"]:checked::before{content: "\2713";background-color: #fff;position: absolute;top: 0;left: 0;width:100%;border: 1px solid #e50232;color:#e50232;font-size: 15px;font-weight: bold;}
</style>
