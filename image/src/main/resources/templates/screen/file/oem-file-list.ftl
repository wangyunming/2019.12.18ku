<#setting classic_compatible=true>
<link rel="stylesheet" href="${base}/static/css/new/sidebar.css" type="text/css" media="screen"/>
<!--中间内容↓-->
<div class="bjf7 p20">
  <div class="user of">
     <#include "/layout/sidebar.ftl">
	<form id="queryForm" method="post" action="${base}/oem-fileList.html" >
		<input  type="hidden" name="fileType" id="fileType" value="${query.fileType}"/>
		<input  type="hidden" name="uploadUsername" id="uploadUsername"  value="${query.uploadUsername}"/>
		<input  type="hidden" name="status" id="status"  value="${query.status}"/>
		<input  type="hidden" name="startTime" id="startTime"  value="${query.startTime}"/>
		<input  type="hidden" name="endTime" id="endTime"  value="${query.endTime}"/>
		<input  type="hidden" name="fileName" id="fileName"  value="${query.fileName}"/>
		<input  type="hidden" name="pageNumTxt" id="pageNumTxt" />
	</form>
    <div class="user-con pb0">
       
      <div class="right_con">
        <div style="margin-bottom:30px;">
          <div class="right_title">文件列表</div>
      		<div class="mt10">
	          	文件提交时间：
			  	<input type="text" id="startTimeWdate" class="Wdate" value="${query.startTime}" style="width: 160px; padding: 4px;" />
			  	&nbsp;到&nbsp;
			  	<input type="text" id="endTimeWdate" class="Wdate" value="${query.endTime}" style="width: 160px; padding: 4px;" />
			  	
			  	<input class="searchBtn" type="button" value="查 询" style="float:right" >
			  	产品类别:
	          	<select  id="fileTypeSelect"  value="<#if query.fileType?exists>${query.fileType}</#if>" style="width: 160px; padding: 4px;" >
						<option value=""></option>          	
	          			<#list fileTypeList as fileType>
	          				<option value="${fileType}" >
									<#if fileType==1>Initial价格牌(大)
									<#elseif fileType==2>Initial价格牌(小)
									<#elseif fileType==3>Summer 2019 版合格证(大)
									<#elseif fileType==4>Summer 2019 版合格证(小)
									<#elseif fileType==5>Fall 2019 版合格证(大)
									<#elseif fileType==6>Fall 2019 版合格证(小)
									<#elseif fileType==7>ACC 大合格证
									<#elseif fileType==8>2019新合格证(小)
									<#elseif fileType==9>合格证成衣 (非两件套)
									<#elseif fileType==10>合格证 成衣 (两件套)</#if>
							</option>
	          			</#list>
	          	</select>
	          	状态:
	          	<select  id="statusSelect"  value="<#if query.status?exists>${query.status}</#if>" style="width: 160px; padding: 4px;" >
	          			<option value=""></option>          	
	          			<#list statusList as status>
	          			<option value="${status}"  ><#if status==0>待确认<#elseif status==1>已确认<#else>已驳回</#if></option>
	          			</#list>
	          	</select>
	          </div>
	          <div class="mt10">
	                               文件名&nbsp;&nbsp;:&nbsp;&nbsp;<input type="text" id="fileNameInput" value="${query.fileName}"  style="width: 160px; padding: 4px;" />
	          </div>
          </div>
          <div class="order">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr-a">
                <td>产品类别</td>
                <td>文件提交时间</td>
                <td>文件名</td>
                <td>状态</td>
                <td>操作</td>
              </tr>
            </table>
			
			 <#list fileList as order>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr-b">
                <td >
                	<#if order.fileType==1> <img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-01.png" />&nbsp;&nbspInitial价格牌（大）
                	<#elseif order.fileType==2> <img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-02.png" />&nbsp;&nbspInitial价格牌（小）
                	
                	
                	<#elseif order.fileType==3> <img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-03.png" />&nbsp;Summer 2019 版合格证(大)
                	
                	<#elseif order.fileType==4>	<img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-04.png" />&nbsp;Summer 2019 版合格证(小)
                	
                	<#elseif order.fileType==5>	<img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-03.png" />&nbsp;Fall 2019 版合格证(大)
                	
                	<#elseif order.fileType==6>	<img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-04.png" />&nbsp;Fall 2019 版合格证(小)
                	
                	<#elseif order.fileType==7>	<img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-03.png" />&nbsp;ACC 大合格证
                	<#elseif order.fileType==9>	<img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-03.png" />合格证成衣 (非两件套)
                	<#elseif order.fileType==10>	<img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-03.png" />合格证成衣 (两件套)
                	<#else>
                	<img style="width:39px;height:80px;" src="${base}/static/images/fileUpload/initial模板-04.png" />&nbsp;&nbsp2019新合格证(小)
                	</#if>
                </td>
                <td>
                	${order.uploadTime}
                </td>
                <td>
                	${order.fileName}
                </td>
                <td>
                	<#if order.status==0>待确认<#elseif order.status==1>已确认<#else>已驳回</#if>
                </td>
                <td>
                	<input type="button" id="read" class="read" style="width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto; line-height:23px; color:#d90b19; margin-bottom:10px;background: white;" onclick="toInfo(${order.id},${order.fileType},${order.status})" value="查看" >
                </td>
                 
              </tr>
               
           
             
            </table>
      	  <hr style="border:1px dashed #f7f7f7; height:1px">
      	 </#list>
            
     
          </div>
        </div>
        <div class="page-m">
       		 <#include "/layout/pagination.ftl">
        </div>
         <div style="margin-top:75px;">
    		 <input type="text" id="pageNumId" style="width:40px;margin-left:866px;" oninput = "value=value.replace(/[^\d]/g,'')">
    		 <button type="button" class="btn btn-info" id="spik" style="margin-left:10px;height:30px;margin-top:-5px">跳转</button>
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
	
	$("#spik").click(function(){
		var pageNum = $("#pageNumId").val();
		if(pageNum==null || pageNum==""){
			return;
		}
		$('input[name="startTime"]').val( $("#startTimeWdate").val());
		$('input[name="endTime"]').val($("#endTimeWdate").val());
		$('input[name="fileType"]').val($("#fileTypeSelect option:selected").val());
		$('input[name="uploadUsername"]').val($("#oemSelect option:selected").val());
		$('input[name="status"]').val($("#statusSelect option:selected").val());
		$('input[name="fileName"]').val($("#fileNameInput").val());
		$('input[name="pageNumTxt"]').val(pageNum);
		$('#queryForm').submit();
	})

	$(function() {
		$("#fileTypeSelect").val(${query.fileType});
		$("#oemSelect").val('${query.uploadUsername}');
		$("#statusSelect").val(${query.status});
		$("#startTimeWdate").focus(function() {
			var endTime = $("#endTimeWdate").val();
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
		$("#endTimeWdate").focus(function() {
			var startTime = $("#startTimeWdate").val();
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
		});
		$('input.searchBtn').click(function(){
			$('input[name="startTime"]').val( $("#startTimeWdate").val());
			$('input[name="endTime"]').val($("#endTimeWdate").val());
			$('input[name="fileType"]').val($("#fileTypeSelect option:selected").val());
			$('input[name="uploadUsername"]').val($("#oemSelect option:selected").val());
			$('input[name="status"]').val($("#statusSelect option:selected").val());
			$('input[name="fileName"]').val($("#fileNameInput").val());
			var pageNum = $("#pageNumId").val();
			if(pageNum!=null && pageNum!=""){
				$('input[name="pageNumTxt"]').val(pageNum);
			}
			$('#queryForm').submit();
		});
		

	function toInfo(id,fileType,status){
	window.location="${base}/excel-initial-info.html?id="+id+"&fileType="+fileType+"&status="+status;
	}
</script>
