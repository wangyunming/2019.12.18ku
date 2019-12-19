<#setting classic_compatible=true>
<link rel="stylesheet" href="${base}/static/css/new/sidebar.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/localcss/bootstrapValidator.min.css">
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
          <div class="right_title">发票信息</div>
      
          <div style="margin-bottom: 14px;margin-top: 15px;">
          		<input type="button" id="addInvoice" name="billing" value="添加发票信息" style="width: 200px; padding: 15px;font-size:15px;color:#FFFFFF;background-color:#D00000" />
          </div>
          <div class="order" id="orderList">
            <table style="border-collapse:collapse; border-spacing:0px 10px;font-size:13px;border: solid thin 	#D8D8D8" bordercolor="#D8D8D8" width="100%" border="1" cellspacing="0" cellpadding="0">
              <tr class="tr-a">
                <td style="width: 10%;">公司抬头</td>
                <td style="width: 10%;">纳税人识别号</td>
                <td style="width: 10%;">注册地址</td>
                <td style="width: 10%;">注册电话</td>
                <td style="width: 10%;">开户银行</td>
                <td style="width: 10%;">银行账号</td>
                <td style="width: 10%;">收票人</td>
                <td style="width: 10%;">收票地址</td>
                <td style="width: 10%;">收票人电话</td>
                <td style="width: 10%;">操作</td>
              </tr>
              <#list invoices as inv>
              <tr>
                <td height="70px"><div style="font-size:12px;">${inv.companyTitle}</div></td>
                <td height="70px"><div style="font-size:12px;">${inv.taxId}</div></td>
                <td height="70px"><div style="font-size:12px;">${inv.regAddress}</div></td>
                <td height="70px"><div style="font-size:12px;">${inv.regPhone}</div></td>
                <td height="70px"><div style="font-size:12px;">${inv.bank}</div></td>
                <td height="70px"><div style="font-size:12px;">${inv.account}</div></td>
                <td height="70px"><div style="font-size:12px;">${inv.taker}</div></td>
                <td height="70px"><div style="font-size:12px;">${inv.billAddress}</div></td>
                <td height="70px"><div style="font-size:12px;">${inv.billPhone}</div></td>
                <td height="70px">
	                <div style="font-size:12px;">
	                	<input type="button" name="update" lang="${inv.id}" value="编辑" style="font-size:12px;color:#b2b2b2;"/>/
		          		<input type="button" name="delete" lang="${inv.id}" value="删除" style="font-size:12px;color:#b2b2b2;"/>
	                </div>
                </td>
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


<#-- 模态框（Modal） -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="text-align:center;">
				<h1 class="modal-title" id="myModalLabel">
					添加发票信息
				</h1>
			</div>
			<div class="modal-body">
				<table style="border-collapse:separate; border-spacing:0px 10px;">
					<form class="form-horizontal bv-form" id="menuDetail" >	
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">公司抬头：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="companyTitle"  name="companyTitle" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">纳税人识别号：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="taxId"  name="taxId" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">注册地址：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="regAddress"  name="regAddress" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">注册电话：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="regPhone"  name="regPhone" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">开户银行：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="bank"  name="bank" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">银行账号：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="account"  name="account" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">收票人：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="taker"  name="taker" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">收票地址：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="billAddress"  name="billAddress" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">收票人电话：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="billPhone"  name="billPhone" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          		</form> 	
	          	</table>		
			</div>
			<div class="modal-footer" style="text-align:center;">
				<button type="button" class="btn btn-primary" id="save" style="background: #D00000;color:#FFFFFF;min-width: 80px;padding: 5px 8px;border: 1px solid #D00000;">
					保存
				</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-default" data-dismiss="modal" style="background: #D00000;color:#FFFFFF;min-width: 80px;padding: 5px 8px;border: 1px solid #D00000;">
					取消
				</button>
			</div>
		</div><#-- /.modal-content -->
	</div>
   </div> <#-- /.modal -->
   
   <#-- 模态框（Modal） -->
<div class="modal fade" id="modalUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="text-align:center;">
				<h1 class="modal-title" id="myModalLabel">
					修改发票信息
				</h1>
			</div>
			<div class="modal-body">
				<table style="border-collapse:separate; border-spacing:0px 10px;">
					<form class="form-horizontal bv-form" id="wizard1" >
					<input id="updateId" type="hidden"  name="id" >	
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">公司抬头：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="companyTitle1"  name="companyTitle" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">纳税人识别号：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="taxId1"  name="taxId" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">注册地址：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="regAddress1"  name="regAddress" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">注册电话：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="regPhone1"  name="regPhone" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">开户银行：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="bank1"  name="bank" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">银行账号：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="account1"  name="account" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">收票人：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="taker1"  name="taker" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">收票地址：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="billAddress1"  name="billAddress" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          			<tr><td style="text-align:right">
	          						<div style="margin-top: 6px;font-size:15px;width: 130px;">收票人电话：</div>
	          					</td>
		          				<td style="text-align:left">
		          					<div style="margin-top: 6px;font-size:15px;width: 350px;">
		          						<input  type="text" id="billPhone1"  name="billPhone" style="width: 350px;height:28px;" />
			                    	</div>	
	          					</td>
	          			</tr>
	          		</form> 	
	          	</table>		
			</div>
			<div class="modal-footer" style="text-align:center;">
				<button type="button" class="btn btn-primary" id="updateSave" style="background: #D00000;color:#FFFFFF;min-width: 80px;padding: 5px 8px;border: 1px solid #D00000;">
					保存
				</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-default" data-dismiss="modal" style="background: #D00000;color:#FFFFFF;min-width: 80px;padding: 5px 8px;border: 1px solid #D00000;">
					取消
				</button>
			</div>
		</div><#-- /.modal-content -->
	</div>
   </div> <#-- /.modal -->
  
<script src="${base}/static/js/localjs/jquery-2.2.2.min.js" type="text/javascript"></script>
<script src="${base}/static/js/localjs/bootstrap.min.js" type="text/javascript"></script>
<script src="${base}/static/js/localjs/formValidation.min.js"></script>
<script src="${base}/static/js/localjs/formValidation_zh_CN.js"></script>
<script src="${base}/static/js/localjs/validator/bootstrap.min.js"></script>

<script src="${base}/static/js/localjs/bootstrapValidator.js"></script>



<script type="text/javascript" src="${base}/static/js/date/WdatePicker.js"></script>
<script type="text/javascript">
$(function() {

	//打开添加弹窗
    	$("#addInvoice").click(function(){
    		$('#modal').modal('show');
    	});
    //打开修改弹窗
    	$('[name="update"]').click(function(){
    	  	$("#wizard1").data('formValidation').validate();
  			if ($("#wizard1").data('formValidation').isValid()) {
  				var id = $(this).attr('lang');
  		  $.ajax({
			type : "post",
			url : "${base}/invoice/queryInvoiceInformationById.html", 
			data : { id : id},
			dataType : "json",
			success : function(data) {
			    $("#companyTitle1").val(data.companyTitle);
			    $("#taxId1").val(data.taxId);
			    $("#regAddress1").val(data.regAddress);
			    $("#regPhone1").val(data.regPhone);
			    $("#bank1").val(data.bank);
			    $("#account1").val(data.account);
			    $("#taker1").val(data.taker);
			    $("#billAddress1").val(data.billAddress);
			    $("#billPhone1").val(data.billPhone);
			    $("#updateId").val(data.id);
			    },error : function(err) {}
			  }); 
			}
		$('#modalUpdate').modal('show');	
    	});	
    	

    //新增界面表单验证	
     $('#menuDetail').formValidation({
			framework: 'bootstrap',
			excluded: ':disabled',
        	message: 'This value is not valid',
        	icon: { valid: 'fa fa-check', invalid: 'fa fa-times', validating: 'fa fa-refresh' },
        	fields: {
	            'companyTitle' : {
	            	validators: {
	            		notEmpty: { message: '公司抬头不能为空！' },
	            	}
	            },
	            'taxId':{
	            	validators: {
	            		notEmpty: { message: '纳税人识别号不能为空！' },
	            	}
	            },
	            'regAddress':{
	            	validators: {
	            		notEmpty: { message: '注册地址不能为空！' },
	            	}
	            },
	            'regPhone':{
	            	validators: {
	            		notEmpty: { message: '注册电话不能为空！' },
	            	}
	            },
	            'bank':{
	            	validators: {
	            		notEmpty: { message: '开户银行不能为空！' },
	            	}
	            },
	            'account':{
	            	validators: {
	            		notEmpty: { message: '银行账号不能为空！' },
	            	}
	            }
	            
        	}
        });	
        
    //修改界面表单验证	
     $('#wizard1').formValidation({
			framework: 'bootstrap',
			excluded: ':disabled',
        	message: 'This value is not valid',
        	icon: { valid: 'fa fa-check', invalid: 'fa fa-times', validating: 'fa fa-refresh' },
        	fields: {
	            'companyTitle' : {
	            	validators: {
	            		notEmpty: { message: '公司抬头不能为空！' },
	            	}
	            },
	            'taxId':{
	            	validators: {
	            		notEmpty: { message: '纳税人识别号不能为空！' },
	            	}
	            },
	            'regAddress':{
	            	validators: {
	            		notEmpty: { message: '注册地址不能为空！' },
	            	}
	            },
	            'regPhone':{
	            	validators: {
	            		notEmpty: { message: '注册电话不能为空！' },
	            	}
	            },
	            'bank':{
	            	validators: {
	            		notEmpty: { message: '开户银行不能为空！' },
	            	}
	            },
	            'account':{
	            	validators: {
	            		notEmpty: { message: '银行账号不能为空！' },
	            	}
	            }
	            
        	}
        });	
        
        <#-- $('#modal').on('hidden.bs.modal', function () {
			$('#menuDetail')[0].reset(); //重置表单
            $("#modal input[type='text']").val("");
            $("#describe").val("");
            var $temp = $('#licenseBox');
			$temp.siblings().remove();
			$('[name="licenseCopy"]').val('');
			$('#menuDetail').data('formValidation').updateStatus('salesRange', 'NOT_VALIDATED');
			$('#menuDetail').data('formValidation').updateStatus('billGmtStr1', 'NOT_VALIDATED');
        });	-->
        
        
             //新增保存提交
        $("#save").click(function(){
        
        	 $("#menuDetail").bootstrapValidator('validate');//提交验证
                if ($("#menuDetail").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
                 //验证成功后的操作，如ajax
                }
        			var parameterSave={
					companyTitle:$("#companyTitle").val(),
					taxId:$("#taxId").val(),
					regAddress:$("#regAddress").val(),
					regPhone:$("#regPhone").val(),
					bank:$("#bank").val(),
					account:$("#account").val(),
					taker:$("#taker").val(),
					billAddress:$("#billAddress").val(),
					billPhone:$("#billPhone").val()
				}
				$('#save').attr("disabled",true);
	 			$.ajax({
	                url: "${base}/invoice/addInvoiceInformation.html",
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
					        window.location="${base}/invoice/invoiceInformation.html";
						}
	                },
	                error: function(res){
	                    alert("参数错误!");
	                }
	            });
        //关闭弹窗
        	$('#modal').modal('hide');
        });
        
            //修改发票信息
    	$("#updateSave").click(function(){
    	  	$("#wizard1").data('formValidation').validate();
  			if ($("#wizard1").data('formValidation').isValid()) {
  				var params1 = $("#wizard1").serialize();//序列号form表单
				$.post('${base}/invoice/updateInvoiceInformation.html', params1, function(data) {
					if (!data.success) {
						alert("参数错误！");
						return false;
					}else{
						alert("修改成功");
						window.location="${base}/invoice/invoiceInformation.html";
					}
				}, 'json');
			}
			$('#modalUpdate').modal('hidden');
    	});	
        
        //删除发票信息
        $('[name="delete"]').click(function() {
			if (!confirm('确定要删除?')) {
				return false;
			}
			var id = $(this).attr('lang');
			$.post('${base}/invoice/deleteInvoiceInformation.html', {id: id}, function(data) {
				if (!data.success) {
					alert('删除失败');
					return false;
				}else{
				alert("删除成功");
					window.location="${base}/invoice/invoiceInformation.html";
				}
				<#--$('#queryForm').attr({
					action: '${base}//invoice/invoiceInformation.html',
					method: 'post'
				}).append('<input type="hidden" value="${query.page}" name="currentPage">').submit();-->
				return true;
			}, 'json');
		});	   
        
});
</script>
<!--修改模态框 出现的位置-->
<style type="text/css">
    .modal.fade.in{
        top:150px;  
    }
</style>