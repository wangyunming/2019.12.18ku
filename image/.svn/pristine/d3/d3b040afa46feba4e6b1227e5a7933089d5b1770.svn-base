<#setting classic_compatible=true>


 <link rel="stylesheet" href="${base}/static/css/sidebar.css" type="text/css" media="screen"/>
 <link rel="stylesheet" href="${base}/static/css/jquery.fileupload.min.css">
  <style>
  	.td_top{font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)}
  	.td_bottom{font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)}
  	.margin_td{width:72px}
  	.margin_td_top{margin-top:0px}
  	.width_left2{width:85px}
  	.margin_td_top2{margin-top:-4px}
  </style>

<div class="bjf7 p20 of">
  <div class="user of">
		 <#include "/layout/sidebar.ftl">
	    <div class="user-con pb0">
	  		<div class="right_con">
					<div class="right_title">文件列表-详情</div>
						

						<!--startprint-->
						<div id="hehe" style="padding-top: 20px;">	

						
						</div>
						<!--endprint-->
						
						<table style="margin:auto;margin-bottom:100px">
							<tr>
								<td>
									<div id="returnsDiv" style="display:none;width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto 10px 10px; line-height:23px; color:#d90b19; margin-bottom:10px;">
										<a id="returns" style="color:#d90b19;cursor:pointer;text-decoration:none">返回</a>
									</div>
								</td>
								<td>
									<div id="subBtnDiv" style="display:none;width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto 10px 10px; line-height:23px; color:#d90b19; margin-bottom:10px;">
										<a id="subBtn"  style="color:#d90b19;cursor:pointer;text-decoration:none">确认</a>
									</div>
								</td>
								<td>
									<div id="rejectBtnDiv" style="display:none;width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto 10px 10px; line-height:23px; color:#d90b19; margin-bottom:10px;">
										<a id="reject"  style="color:#d90b19;cursor:pointer;text-decoration:none">驳回</a>
									</div>
								</td>
								<td>
									
										<div style="width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin:auto 10px 10px; line-height:23px; color:#d90b19; margin-bottom:10px;">
											<a style="color:#d90b19;cursor:pointer;text-decoration:none" id="print">打印</a>
										</div>						
									
								</td>
							</tr>
						</table>


			</div>
		</div>
	</div>
</div>

<script>

function doPrint() {   
    bdhtml=window.document.body.innerHTML;   
    sprnstr="<!--startprint-->";   
    eprnstr="<!--endprint-->";   
    prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);   
    prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));   
    window.document.body.innerHTML=prnhtml;  
    window.print();   
}

function trim(str){//去除字符串所有空格
    return str.replace(/\s|\xA0/g,"");    
}
	
	$(function(){
		
		
        $("#print").click(function(){
        	var id = $(this).attr('lang');
        	var curWwwPath = window.document.location.href;
			var pathName = window.document.location.pathname;
			var pos = curWwwPath.indexOf(pathName);
			var localhostPaht = curWwwPath.substring(0, pos);
			var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
			var redirect = localhostPaht + '/print-initial-info'+"?id="+1;
			var win = window;
			while (win != win.parent) {
			 	win = win.parent;
			}
		    //win.location = redirect;
		    window.open(localhostPaht + '/print-initial-info.html'+"?id="+${excel.id}+"&fileType="+${excel.fileType});
        });
		<#if '${excel.status}'=='0' >
			$("#subBtnDiv").show();
			$("#rejectBtnDiv").show();
		<#else>
			$("#returnsDiv").show();		
		</#if>
		
		
		
		$.ajax({
			type:"post",
			url:"${base}/get-excel-initial-info",
			data:{
				id:${excel.id},
				fileType:${excel.fileType}
			},
			dataType:"json",
			success:function(data){
				if (data.success) {
					
					var a = ${excel.fileType};
					var HTML = "";
					if(a == 1){//价格吊牌1
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table>'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td>'
										+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:10px">'
										+	 '			  <img alt="" src="${base}/static/images/fileUpload/initial模板-05.png" style="width:310px;height:703.5px;">'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:75px;top:18px;font-size:12px;">'+data.obj[i][j][k].customerName+'</span>'
										+	 '		          <span style="position:absolute;left:178px;top:18px;font-size:12px;">'+data.obj[i][j][k].smlpc+'</span> '
										+	 '		          <span style="position:absolute;left:246px;top:18px;font-size:12px;">'+data.obj[i][j][k].orderQty+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '					<span style="position:absolute;left:54px;top:93px;letter-spacing:2.7px;font-size:18px;">'+data.obj[i][j][k].itemNo+'</span>'
										+	 '			  </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:34px;top:152px;font-size:18px;">'+data.obj[i][j][k].colour+'</span>'
										+	 '		          <span style="position:absolute;left:118px;top:152px;font-size:18px;">'+data.obj[i][j][k].size+'</span> '
										+	 '		          <span style="position:absolute;left:201px;top:157px;" class="td_top">'+data.obj[i][j][k].currency+'</span> '
										+	 '		          <span style="position:absolute;right:24px;top:152px;font-size:18px;">'+data.obj[i][j][k].unitPrice+'</span>'
															  var setPrice = "";
										  					  var thisSetPrice = trim(data.obj[i][j][k].setPrice);//去空格
															  if(thisSetPrice == "SETPRICE"){
																  setPrice = "(SET PRICE)";
															  }
						HTML = HTML		+	 '		          <span style="position:absolute;right:22px;top:175px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'+setPrice+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:54px;top:220px;">'+data.obj[i][j][k].description+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:40px;top:535px;letter-spacing:13px;"  class="td_bottom">'+data.obj[i][j][k].barCode+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:33px;top:594px;" class="td_bottom">'+data.obj[i][j][k].itemNo+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:166px;top:594px;" class="td_bottom">'+data.obj[i][j][k].colour+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:228px;top:594px;" class="td_bottom">'+data.obj[i][j][k].size+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:34px;top:643px;" class="td_bottom">'+data.obj[i][j][k].description+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:166px;top:645px;" class="td_bottom">'+data.obj[i][j][k].currency+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:205px;top:639px;font-size:18px">'+data.obj[i][j][k].unitPrice+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:200px;top:661px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'+setPrice+'</span>'
										+	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}else if(a == 2){//价格吊牌2
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table style="page-break-before:always">'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td>'
										+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px">'
										+	 '			  <img alt="" src="${base}/static/images/fileUpload/initial模板-06.png" style="width:310px;height:338.2px;">'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:75px;top:18px;font-size:12px;">'+data.obj[i][j][k].customerName+'</span>'
										+	 '		          <span style="position:absolute;left:178px;top:18px;font-size:12px;">'+data.obj[i][j][k].smlpc+'</span> '
										+	 '		          <span style="position:absolute;left:246px;top:18px;font-size:12px;">'+data.obj[i][j][k].orderQty+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:36px;top:168px;" class="td_top">'+data.obj[i][j][k].colour+'</span>'
										+	 '		          <span style="position:absolute;left:119px;top:168px;" class="td_top">'+data.obj[i][j][k].size+'</span> '
										+	 '		          <span style="position:absolute;left:180px;top:168px;letter-spacing:1px;" class="td_top">'+data.obj[i][j][k].itemNo+'</span> '
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:37px;top:238px;letter-spacing:9.6px;">'+data.obj[i][j][k].barCode+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:39px;top:291px;font-size:14px">'+data.obj[i][j][k].currency+'</span>'
										+	 '		      </div>'
										+	 '		      <div>'
										+	 '		          <span style="position:absolute;left:210px;top:277px;font-size:28px">'+data.obj[i][j][k].unitPrice+'</span>'
										+	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}else if(a == 3){//合格证1
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table>'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td>'
										+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:20px;margin-bottom:10px;">'
										+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
										+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
										+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
										+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
										+	 '	      	<div style="margin:-618px 0px 0px 38px;">'
													if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null && data.obj[i][j][k].productName != ''){
							HTML = HTML	+	 '		      	   <div>'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产品名称</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null && data.obj[i][j][k].itemNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		      	   		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">货品编号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].itemNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].type != 'null' && data.obj[i][j][k].type != null && data.obj[i][j][k].type != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">号型</td>'
										+	 '		           				<td>'+data.obj[i][j][k].type+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
											/* 		if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null && data.obj[i][j][k].artNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">货号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].artNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													} */
													if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null && data.obj[i][j][k].internalCode != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">内部码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null && data.obj[i][j][k].grade != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">等级</td>'
										+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产品标准</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productStandard+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}

							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
															if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null && data.obj[i][j][k].securityCategory != ''){
							HTML = HTML +	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">安全类别</td>'
										+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
										+	 '		           			</tr>'
															}
															if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td"></td>'
										+	 '		           				<td><div style="margin-top:0px">'+data.obj[i][j][k].category+'</div></td>'
										+	 '		           			</tr>'
															}
							HTML = HTML	+	 '		           		</table>'
										+	 '		      	   </div>'
										
															if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null && data.obj[i][j][k].colour != ''){
							HTML = HTML	+	 '	 			  <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '		           				<td class="margin_td" style="width:72px">颜色</td>'
										+	 '		           				<td>'+data.obj[i][j][k].colour+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
									}
										
							HTML = HTML	+	 '		      </div>'
										+	 '		      <div style="margin:0px 0px 0px 38px;width:600px">'
											for(var l=0;l<data.obj[i][j][k].fabricList.length;l++){
										HTML = HTML	+	 '	  <table class="margin_td_top">'
												for(var m=0;m<data.obj[i][j][k].fabricList[l].component.length;m++){
													var name = "";
													if(data.obj[i][j][k].fabricList[l].name != 'null' && data.obj[i][j][k].fabricList[l].name != null && m == 0){name=data.obj[i][j][k].fabricList[l].name }
												HTML = HTML	+	 ' <tr class="td_top">'
														+	 '	     	<td class="margin_td">'+name+'</td>'
														var componentInfo = "";
														for(var n=0;n<data.obj[i][j][k].fabricList[l].component[m].length;n++){
															componentInfo = componentInfo + data.obj[i][j][k].fabricList[l].component[m][n] + "&nbsp;";
														}
														HTML = HTML	+	 '<td><div style="margin-top:0px;">'+componentInfo+'</div></td>'
														+	 '	    </tr>'
												}
										if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != null && data.obj[i][j][k].fabricList[l].remarks != ''){
											HTML = HTML		+	 ' 		<tr class="td_top">'
											+	 '			<td class="margin_td"></td>'
											+	 '			<td>'
														for(var m=0;m<data.obj[i][j][k].fabricList[l].remarksList.length;m++){
															if(m==0){
												HTML = HTML	+			'<div style="margin-top:-1px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
															}else{
												HTML = HTML	+			'<div style="margin-top:1px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
															}
														}
								HTML = HTML	+	 '	    	</td></tr>'
										}
										HTML = HTML	+	 '    </table>'
											}
							HTML = HTML	+	 '		      </div>'
										+	 '		      <div style="margin:0px 0px 0px 38px;">'
													if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
							HTML = HTML	+    '		      		<div>'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">生产日期</td>'
										+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'	
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
							HTML = HTML	+    '		        	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">检测员</td>'
										+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null && data.obj[i][j][k].placeOfOrigin != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产地</td>'
										+	 '		           				<td>'+data.obj[i][j][k].placeOfOrigin+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].distributor != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
							HTML = HTML +	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">经销商</td>'
										+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
													if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">地址</td>'
										+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
							HTML = HTML +	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td"></td>'
										+	 '		           				<td><div style="margin-top:-1px">'+data.obj[i][j][k].locationInfo+'</div></td>'
										+	 '		           			</tr>'
													}
										+	 '		           		</table>'
										+	 '		           	</div>'
													if(data.obj[i][j][k].phone != 'null' && data.obj[i][j][k].phone != null && data.obj[i][j][k].phone != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">电话</td>'
										+	 '		           				<td>'+data.obj[i][j][k].phone+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].postalCode != 'null' && data.obj[i][j][k].postalCode != null && data.obj[i][j][k].postalCode != ''){
							HTML = HTML +	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">邮政编码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
									}
													if(data.obj[i][j][k].washingInstructions !='null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">洗涤说明</td>'
										+	 '		           				<td><img alt="" src="${base}/static/images/fileUpload/'+data.obj[i][j][k].washingInstructions+'.png?" style="width:170px;height:18px;margin-top:4px;"></td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML +	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:30px;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}else if(a == 4){//合格证2
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table style="page-break-before:always">'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
										+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px" id="haha">'
										+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
										+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
										+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
										+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
										+	 '	      	<div style="margin:-274px 0px 0px 40px;">'
													if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null && data.obj[i][j][k].productName != ''){
							HTML = HTML	+	 '		      	   <div>'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">产品名称</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null && data.obj[i][j][k].itemNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		      	   		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">货品编号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].itemNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].type != 'null' && data.obj[i][j][k].type != null && data.obj[i][j][k].type != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">号型</td>'
										+	 '		           				<td>'+data.obj[i][j][k].type+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
										/* 			if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null && data.obj[i][j][k].artNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">货号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].artNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													} */
													if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null && data.obj[i][j][k].internalCode != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">内部码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null && data.obj[i][j][k].grade != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">等级</td>'
										+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
												if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">产品标准</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productStandard+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
													if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null && data.obj[i][j][k].securityCategory != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">安全类别</td>'
										+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2"></td>'
										+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].category+'</div></td>'
										+	 '		           			</tr>'
													}
							HTML = HTML	+	 '		           		</table>'
										+	 '		      	   </div>'
							
									if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null && data.obj[i][j][k].colour != ''){
							HTML = HTML	+ 	 '				   <div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">颜色</td>'
										+	 '		           				<td>'+data.obj[i][j][k].colour+'</td>'
										+	 '		           			</tr>'
										+	 '		         		</table>'	
										+	 '		 			</div>'
									}
							
									HTML = HTML		+	 '	</div>'
										+	 '		      <div style="margin:-4px 0px 0px 40px;width:600px">'
											for(var l=0;l<data.obj[i][j][k].fabricList.length;l++){
										HTML = HTML	+	 '	  <table>'
												for(var m=0;m<data.obj[i][j][k].fabricList[l].component.length;m++){
													var name = "";
													if(data.obj[i][j][k].fabricList[l].name != 'null' && data.obj[i][j][k].fabricList[l].name != null && m == 0){name=data.obj[i][j][k].fabricList[l].name }
												HTML = HTML	+	 ' <tr class="td_top">'
														+	 '	     	<td class="width_left2">'+name+'</td>'
														var componentInfo = "";
														for(var n=0;n<data.obj[i][j][k].fabricList[l].component[m].length;n++){
															componentInfo = componentInfo + data.obj[i][j][k].fabricList[l].component[m][n]+"&nbsp;";
														}
														if(m == 0){
															HTML = HTML	+	 '<td><div style="margin-top:0px;">'+componentInfo+'</div></td>'
														}else{
															HTML = HTML	+	 '<td><div style="margin-top:-8px;">'+componentInfo+'</div></td>'
														}
														+	 '	    </tr>'
												}
										if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != null && data.obj[i][j][k].fabricList[l].remarks != ''){
											HTML = HTML		+	 ' 		<tr class="td_top">'
											+	 '			<td class="width_left2"></td>'
											+	 '			<td>'
											for(var m=0;m<data.obj[i][j][k].fabricList[l].remarksList.length;m++){
												if(m == 0){
													HTML = HTML	+			'<div style="margin-top:-6px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
												}else{
													HTML = HTML	+			'<div style="margin-top:-2px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
												}
																}
							HTML = HTML		+	 '	   		</td></tr>'
										}
										HTML = HTML	+	 '    </table>'
											}
							HTML = HTML	+	 '		      </div>'
										+	 '		      <div style="margin:-4px 0px 0px 40px;">'
													if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
							HTML = HTML	+	 '		           	<div>'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">生产日期</td>'
										+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
							HTML = HTML	+	 '		        	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">检测员</td>'
										+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null && data.obj[i][j][k].placeOfOrigin != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">产地</td>'
										+	 '		           				<td>'+data.obj[i][j][k].placeOfOrigin+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].distributor != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">经销商</td>'
										+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
													if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">地址</td>'
										+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2"></td>'
										+	 '		           				<td><div style="margin-top:-5px">'+data.obj[i][j][k].locationInfo+'</div></td>'
										+	 '		           			</tr>'				
													}
							HTML = HTML	+	 '		           		</table>'
										+	 '		           	</div>'
													if(data.obj[i][j][k].phone != 'null' && data.obj[i][j][k].phone != null && data.obj[i][j][k].phone != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">电话</td>'
										+	 '		           				<td>'+data.obj[i][j][k].phone+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].postalCode != 'null' && data.obj[i][j][k].postalCode != null && data.obj[i][j][k].postalCode != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">邮政编码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].washingInstructions != 'null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
						HTML = HTML		+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">洗涤说明</td>'
										+	 '		           				<td><img alt="" src="${base}/static/images/fileUpload/'+data.obj[i][j][k].washingInstructions+'.png" style="width:170px;height:18px;margin-top:4px;"></td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
										+	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}else if(a == 5 || a == 9){//	 fall 合格证  大  ||  成衣 -合格证 （非两件套）
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table>'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td>'
										+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:20px;margin-bottom:10px;">'
										+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
										+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
										+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
										+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
										+	 '	      	<div style="margin:-618px 0px 0px 38px;">'
													if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null && data.obj[i][j][k].productName != ''){
							HTML = HTML	+	 '		      	   <div>'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产品名称</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null && data.obj[i][j][k].itemNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		      	   		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">货品编号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].itemNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].type != 'null' && data.obj[i][j][k].type != null && data.obj[i][j][k].type != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">号型</td>'
										+	 '		           				<td>'+data.obj[i][j][k].type+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null && data.obj[i][j][k].internalCode != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">内部码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null && data.obj[i][j][k].grade != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">等级</td>'
										+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">执行标准</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productStandard+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}

							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
															if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null && data.obj[i][j][k].securityCategory != ''){
							HTML = HTML +	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">安全类别</td>'
										+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
										+	 '		           			</tr>'
															}
															if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td"></td>'
										+	 '		           				<td><div style="margin-top:0px">'+data.obj[i][j][k].category+'</div></td>'
										+	 '		           			</tr>'
															}
							HTML = HTML	+	 '		           		</table>'
										+	 '		      	   </div>'
										
															if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null && data.obj[i][j][k].colour != ''){
							HTML = HTML	+	 '	 			  <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '		           				<td class="margin_td" style="width:72px">颜色</td>'
										+	 '		           				<td>'+data.obj[i][j][k].colour+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
									}
													if(data.obj[i][j][k].fabricString != 'null' && data.obj[i][j][k].fabricString != null && data.obj[i][j][k].fabricString != ''){
							HTML = HTML	+	 '	 			  <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '		           				<td class="margin_td" style="width:72px">成份</td>'
										+	 '		           				<td>'+data.obj[i][j][k].fabricString+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
							HTML = HTML	+    '		      		<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">生产日期</td>'
										+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'	
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
							HTML = HTML	+    '		        	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">检测员</td>'
										+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null && data.obj[i][j][k].placeOfOrigin != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产地</td>'
										+	 '		           				<td>'+data.obj[i][j][k].placeOfOrigin+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].distributor != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
							HTML = HTML +	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">经销商</td>'
										+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
													if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">地址</td>'
										+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
							HTML = HTML +	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td"></td>'
										+	 '		           				<td><div style="margin-top:-1px">'+data.obj[i][j][k].locationInfo+'</div></td>'
										+	 '		           			</tr>'
													}
										+	 '		           		</table>'
										+	 '		           	</div>'
													if(data.obj[i][j][k].phone != 'null' && data.obj[i][j][k].phone != null && data.obj[i][j][k].phone != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">电话</td>'
										+	 '		           				<td>'+data.obj[i][j][k].phone+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].postalCode != 'null' && data.obj[i][j][k].postalCode != null && data.obj[i][j][k].postalCode != ''){
							HTML = HTML +	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">邮政编码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
									}
													if(data.obj[i][j][k].washingInstructions !='null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">洗涤说明</td>'
										+	 '		           				<td>'+data.obj[i][j][k].washingInstructions+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML +	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:30px;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}else if(a == 6){	//fall 合格证  小
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table style="page-break-before:always">'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
										+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px" id="haha">'
										+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
										+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
										+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
										+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
										+	 '	      	<div style="margin:-274px 0px 0px 40px;">'
													if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null && data.obj[i][j][k].productName != ''){
							HTML = HTML	+	 '		      	   <div>'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">产品名称</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null && data.obj[i][j][k].itemNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		      	   		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">货品编号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].itemNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].type != 'null' && data.obj[i][j][k].type != null && data.obj[i][j][k].type != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">号型</td>'
										+	 '		           				<td>'+data.obj[i][j][k].type+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
										/* 			if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null && data.obj[i][j][k].artNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">货号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].artNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													} */
													if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null && data.obj[i][j][k].internalCode != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">内部码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null && data.obj[i][j][k].grade != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">等级</td>'
										+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
												if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">产品标准</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productStandard+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
													if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null && data.obj[i][j][k].securityCategory != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">安全类别</td>'
										+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2"></td>'
										+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].category+'</div></td>'
										+	 '		           			</tr>'
													}
							HTML = HTML	+	 '		           		</table>'
										+	 '		      	   </div>'
							
									if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null && data.obj[i][j][k].colour != ''){
							HTML = HTML	+ 	 '				   <div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">颜色</td>'
										+	 '		           				<td>'+data.obj[i][j][k].colour+'</td>'
										+	 '		           			</tr>'
										+	 '		         		</table>'	
										+	 '		 			</div>'
									}
													if(data.obj[i][j][k].fabricString != 'null' && data.obj[i][j][k].fabricString != null && data.obj[i][j][k].fabricString != ''){
							HTML = HTML	+	 '		        	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">成份</td>'
										+	 '		           				<td>'+data.obj[i][j][k].fabricString+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
							HTML = HTML	+	 '	 			  <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">生产日期</td>'
										+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
									}
													if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
							HTML = HTML	+	 '		        	<div>'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">检测员</td>'
										+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null && data.obj[i][j][k].placeOfOrigin != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">产地</td>'
										+	 '		           				<td>'+data.obj[i][j][k].placeOfOrigin+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].distributor != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">经销商</td>'
										+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
													if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">地址</td>'
										+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2"></td>'
										+	 '		           				<td><div style="margin-top:-5px">'+data.obj[i][j][k].locationInfo+'</div></td>'
										+	 '		           			</tr>'				
													}
							HTML = HTML	+	 '		           		</table>'
										+	 '		           	</div>'
													if(data.obj[i][j][k].phone != 'null' && data.obj[i][j][k].phone != null && data.obj[i][j][k].phone != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">电话</td>'
										+	 '		           				<td>'+data.obj[i][j][k].phone+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].postalCode != 'null' && data.obj[i][j][k].postalCode != null && data.obj[i][j][k].postalCode != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">邮政编码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].washingInstructions != 'null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
						HTML = HTML		+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">洗涤说明</td>'
										+	 '		           				<td>'+data.obj[i][j][k].washingInstructions+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
										+	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}else if(a == 7){//2019新合格证(大)
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table>'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td>'
										+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:20px;margin-bottom:10px;">'
										+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
										+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
										+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
										+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
										+	 '	      	<div style="margin:-618px 0px 0px 38px;">'
													if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null && data.obj[i][j][k].productName != ''){
							HTML = HTML	+	 '		      	   <div>'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产品名称</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null && data.obj[i][j][k].itemNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		      	   		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">货品编号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].itemNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].type != 'null' && data.obj[i][j][k].type != null && data.obj[i][j][k].type != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">号型</td>'
										+	 '		           				<td>'+data.obj[i][j][k].type+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
											/* 		if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null && data.obj[i][j][k].artNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">货号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].artNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													} */
													if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null && data.obj[i][j][k].internalCode != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">内部码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null && data.obj[i][j][k].grade != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">等级</td>'
										+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">执行标准</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productStandard+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}

							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
															if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null && data.obj[i][j][k].securityCategory != ''){
							HTML = HTML +	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">安全类别</td>'
										+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
										+	 '		           			</tr>'
															}
															if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td"></td>'
										+	 '		           				<td><div style="margin-top:0px">'+data.obj[i][j][k].category+'</div></td>'
										+	 '		           			</tr>'
															}
							HTML = HTML	+	 '		           		</table>'
										+	 '		      	   </div>'
										
															if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null && data.obj[i][j][k].colour != ''){
							HTML = HTML	+	 '	 			  <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '		           				<td class="margin_td" style="width:72px">颜色</td>'
										+	 '		           				<td>'+data.obj[i][j][k].colour+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
									}
										
							HTML = HTML	+	 '		      </div>'
										+	 '		      <div style="margin:0px 0px 0px 38px;width:600px">'
											for(var l=0;l<data.obj[i][j][k].fabricList.length;l++){
										HTML = HTML	+	 '	  <table class="margin_td_top">'
												for(var m=0;m<data.obj[i][j][k].fabricList[l].component.length;m++){
													var name = "";
													if(data.obj[i][j][k].fabricList[l].name != 'null' && data.obj[i][j][k].fabricList[l].name != null && m == 0){name=data.obj[i][j][k].fabricList[l].name }
												HTML = HTML	+	 ' <tr class="td_top">'
														+	 '	     	<td class="margin_td">'+name+'</td>'
														var componentInfo = "";
														for(var n=0;n<data.obj[i][j][k].fabricList[l].component[m].length;n++){
															componentInfo = componentInfo + data.obj[i][j][k].fabricList[l].component[m][n] + "&nbsp;";
														}
														HTML = HTML	+	 '<td><div style="margin-top:0px;">'+componentInfo+'</div></td>'
														+	 '	    </tr>'
												}
										if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != null && data.obj[i][j][k].fabricList[l].remarks != ''){
											HTML = HTML		+	 ' 		<tr class="td_top">'
											+	 '			<td class="margin_td"></td>'
											+	 '			<td>'
														for(var m=0;m<data.obj[i][j][k].fabricList[l].remarksList.length;m++){
															if(m==0){
												HTML = HTML	+			'<div style="margin-top:-1px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
															}else{
												HTML = HTML	+			'<div style="margin-top:1px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
															}
														}
								HTML = HTML	+	 '	    	</td></tr>'
										}
										HTML = HTML	+	 '    </table>'
											}
							HTML = HTML	+	 '		      </div>'
										+	 '		      <div style="margin:0px 0px 0px 38px;">'
													if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
							HTML = HTML	+    '		      		<div>'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">生产日期</td>'
										+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'	
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
							HTML = HTML	+    '		        	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">检测员</td>'
										+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null && data.obj[i][j][k].placeOfOrigin != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产地</td>'
										+	 '		           				<td>'+data.obj[i][j][k].placeOfOrigin+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].distributor != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
							HTML = HTML +	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">经销商</td>'
										+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
													if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">地址</td>'
										+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
							HTML = HTML +	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td"></td>'
										+	 '		           				<td><div style="margin-top:-1px">'+data.obj[i][j][k].locationInfo+'</div></td>'
										+	 '		           			</tr>'
													}
										+	 '		           		</table>'
										+	 '		           	</div>'
													if(data.obj[i][j][k].phone != 'null' && data.obj[i][j][k].phone != null && data.obj[i][j][k].phone != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">电话</td>'
										+	 '		           				<td>'+data.obj[i][j][k].phone+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].postalCode != 'null' && data.obj[i][j][k].postalCode != null && data.obj[i][j][k].postalCode != ''){
							HTML = HTML +	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">邮政编码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
									}
													if(data.obj[i][j][k].washingInstructions !='null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">洗涤说明</td>'
										+	 '		           				<td><img alt="" src="${base}/static/images/fileUpload/'+data.obj[i][j][k].washingInstructions+'.png?" style="width:170px;height:18px;margin-top:4px;"></td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML +	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:30px;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}else if(a == 8){////2019新合格证(小)
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table style="page-break-before:always">'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
										+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px" id="haha">'
										+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
										+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
										+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
										+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
										+	 '	      	<div style="margin:-274px 0px 0px 40px;">'
													if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null && data.obj[i][j][k].productName != ''){
							HTML = HTML	+	 '		      	   <div>'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">产品名称</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null && data.obj[i][j][k].itemNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		      	   		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">货品编号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].itemNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].type != 'null' && data.obj[i][j][k].type != null && data.obj[i][j][k].type != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">号型</td>'
										+	 '		           				<td>'+data.obj[i][j][k].type+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null && data.obj[i][j][k].internalCode != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">内部码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null && data.obj[i][j][k].grade != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">等级</td>'
										+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
												if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">执行标准</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productStandard+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
							HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
										+	 '		           		<table>'
													if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null && data.obj[i][j][k].securityCategory != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">安全类别</td>'
										+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2"></td>'
										+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].category+'</div></td>'
										+	 '		           			</tr>'
													}
							HTML = HTML	+	 '		           		</table>'
										+	 '		      	   </div>'
							
									if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null && data.obj[i][j][k].colour != ''){
							HTML = HTML	+ 	 '				   <div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">颜色</td>'
										+	 '		           				<td>'+data.obj[i][j][k].colour+'</td>'
										+	 '		           			</tr>'
										+	 '		         		</table>'	
										+	 '		 			</div>'
									}
							
									HTML = HTML		+	 '	</div>'
										+	 '		      <div style="margin:-4px 0px 0px 40px;width:600px">'
											for(var l=0;l<data.obj[i][j][k].fabricList.length;l++){
										HTML = HTML	+	 '	  <table>'
												for(var m=0;m<data.obj[i][j][k].fabricList[l].component.length;m++){
													var name = "";
													if(data.obj[i][j][k].fabricList[l].name != 'null' && data.obj[i][j][k].fabricList[l].name != null && m == 0){name=data.obj[i][j][k].fabricList[l].name }
												HTML = HTML	+	 ' <tr class="td_top">'
														+	 '	     	<td class="width_left2">'+name+'</td>'
														var componentInfo = "";
														for(var n=0;n<data.obj[i][j][k].fabricList[l].component[m].length;n++){
															componentInfo = componentInfo + data.obj[i][j][k].fabricList[l].component[m][n]+"&nbsp;";
														}
														if(m == 0){
															HTML = HTML	+	 '<td><div style="margin-top:0px;">'+componentInfo+'</div></td>'
														}else{
															HTML = HTML	+	 '<td><div style="margin-top:-8px;">'+componentInfo+'</div></td>'
														}
														+	 '	    </tr>'
												}
										if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != null && data.obj[i][j][k].fabricList[l].remarks != ''){
											HTML = HTML		+	 ' 		<tr class="td_top">'
											+	 '			<td class="width_left2"></td>'
											+	 '			<td>'
											for(var m=0;m<data.obj[i][j][k].fabricList[l].remarksList.length;m++){
												if(m == 0){
													HTML = HTML	+			'<div style="margin-top:-6px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
												}else{
													HTML = HTML	+			'<div style="margin-top:-2px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
												}
																}
							HTML = HTML		+	 '	   		</td></tr>'
										}
										HTML = HTML	+	 '    </table>'
											}
							HTML = HTML	+	 '		      </div>'
										+	 '		      <div style="margin:-4px 0px 0px 40px;">'
													if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
							HTML = HTML	+	 '		           	<div>'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">生产日期</td>'
										+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
							HTML = HTML	+	 '		        	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">检测员</td>'
										+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null && data.obj[i][j][k].placeOfOrigin != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">产地</td>'
										+	 '		           				<td>'+data.obj[i][j][k].placeOfOrigin+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].distributor != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">经销商</td>'
										+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
													if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">地址</td>'
										+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2"></td>'
										+	 '		           				<td><div style="margin-top:-5px">'+data.obj[i][j][k].locationInfo+'</div></td>'
										+	 '		           			</tr>'				
													}
							HTML = HTML	+	 '		           		</table>'
										+	 '		           	</div>'
													if(data.obj[i][j][k].phone != 'null' && data.obj[i][j][k].phone != null && data.obj[i][j][k].phone != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">电话</td>'
										+	 '		           				<td>'+data.obj[i][j][k].phone+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].postalCode != 'null' && data.obj[i][j][k].postalCode != null && data.obj[i][j][k].postalCode != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">邮政编码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].washingInstructions != 'null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
						HTML = HTML		+	 '		           	<div class="margin_td_top2">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="width_left2">洗涤说明</td>'
										+	 '		           				<td><img alt="" src="${base}/static/images/fileUpload/'+data.obj[i][j][k].washingInstructions+'.png" style="width:170px;height:18px;margin-top:4px;"></td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
										+	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}else if(a==10){//成衣 --合格证（两件套）
						for(var i=0;i<data.obj.length;i++){
							HTML = HTML	+'<table>'     	
							for(var j=0;j<data.obj[i].length;j++){
								HTML = HTML	 +   '<tr>'
								for(var k=0;k<data.obj[i][j].length;k++){
										HTML = HTML	+	'<td>'
										+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:20px;margin-bottom:10px;">'
										+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
										+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
										+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
										+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
										+	 '	      	<div style="margin:-618px 0px 0px 38px;">'
													if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null && data.obj[i][j][k].productName != ''){
							HTML = HTML	+	 '		      	   <div>'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产品名称</td>'
										+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null && data.obj[i][j][k].itemNo != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		      	   		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">货品编号</td>'
										+	 '		           				<td>'+data.obj[i][j][k].itemNo+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].type != 'null' && data.obj[i][j][k].type != null && data.obj[i][j][k].type != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">号型</td>'
										+	 '		           				<td>'+data.obj[i][j][k].type+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null && data.obj[i][j][k].internalCode != ''){
							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">内部码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null && data.obj[i][j][k].grade != ''){
							HTML = HTML +	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">等级</td>'
										+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].productStandardList.length>0){
							HTML = HTML +	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
					for(var l=0;l<data.obj[i][j][k].productStandardList.length;l++){
							if(l==0){
							HTML = HTML	+	 '							<tr class="td_top">'
										+	 '	  							<td class="margin_td">执行标准</td>'
										+	 '	  							<td style="letter-spacing: -0.5px;">'+data.obj[i][j][k].productStandardList[l]+'</td>'
										+	 '	 						</tr>'
							}else{
							HTML = HTML	+	 '							<tr class="td_top">'
										+	 '								<td class="margin_td"></td>'
										+	 '								<td style="letter-spacing: -0.5px;">'+data.obj[i][j][k].productStandardList[l]+'</td>'
										+	 '							</tr>'
							}
					}
							HTML = HTML +	 '		           		</table>'
										+	 '		      	   </div>'
													}

							HTML = HTML	+	 '		      	   <div class="margin_td_top">'
										+	 '		           		<table>'
															if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null && data.obj[i][j][k].securityCategory != ''){
							HTML = HTML +	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">安全类别</td>'
										+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
										+	 '		           			</tr>'
															}
															if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td"></td>'
										+	 '		           				<td><div style="margin-top:0px">'+data.obj[i][j][k].category+'</div></td>'
										+	 '		           			</tr>'
															}
							HTML = HTML	+	 '		           		</table>'
										+	 '		      	   </div>'
										
															if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null && data.obj[i][j][k].colour != ''){
							HTML = HTML	+	 '	 			  <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '		           				<td class="margin_td" style="width:72px">颜色</td>'
										+	 '		           				<td>'+data.obj[i][j][k].colour+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
									}
													if(data.obj[i][j][k].fabricString != 'null' && data.obj[i][j][k].fabricString != null && data.obj[i][j][k].fabricString != ''){
							HTML = HTML	+	 '	 			  <div class="margin_td_top">'
										+	 '		           		<table>'
										+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '		           				<td class="margin_td" style="width:72px">成份</td>'
										+	 '		           				<td>'+data.obj[i][j][k].fabricString+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		      	   </div>'
													}
													if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
							HTML = HTML	+    '		      		<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">生产日期</td>'
										+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'	
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
							HTML = HTML	+    '		        	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">检测员</td>'
										+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null && data.obj[i][j][k].placeOfOrigin != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">产地</td>'
										+	 '		           				<td>'+data.obj[i][j][k].placeOfOrigin+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].distributor != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
							HTML = HTML +	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">经销商</td>'
										+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
													if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
							HTML = HTML	+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">地址</td>'
										+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
										+	 '		           			</tr>'
													}
													if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
							HTML = HTML +	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td"></td>'
										+	 '		           				<td><div style="margin-top:-1px">'+data.obj[i][j][k].locationInfo+'</div></td>'
										+	 '		           			</tr>'
													}
										+	 '		           		</table>'
										+	 '		           	</div>'
													if(data.obj[i][j][k].phone != 'null' && data.obj[i][j][k].phone != null && data.obj[i][j][k].phone != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">电话</td>'
										+	 '		           				<td>'+data.obj[i][j][k].phone+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
													if(data.obj[i][j][k].postalCode != 'null' && data.obj[i][j][k].postalCode != null && data.obj[i][j][k].postalCode != ''){
							HTML = HTML +	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">邮政编码</td>'
										+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
									}
													if(data.obj[i][j][k].washingInstructions !='null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
							HTML = HTML	+	 '		           	<div class="margin_td_top">'
										+	 '		      			<table>'
										+	 '		           			<tr class="td_top">'
										+	 '		           				<td class="margin_td">洗涤说明</td>'
										+	 '		           				<td>'+data.obj[i][j][k].washingInstructions+'</td>'
										+	 '		           			</tr>'
										+	 '		           		</table>'
										+	 '		           	</div>'
													}
							HTML = HTML +	 '		      </div>'
										+	 '		</div>'
										+	 '	</td>'				
								}
								HTML = HTML	+	'</tr>'
							}
							HTML = HTML	+  '</table>'
										+	'<div style="margin-left:3%;height:120px;">'
										+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:30px;" />'
		/* 	 				            +      		'<textarea style="resize: none;width:1000px" class="form-control" placeholder="备注 ..." rows="4" id="remarks0" maxlength="200"></textarea>'
		 */				              	+	'</div>'
						}
					}
					
					
					
					
					$("#hehe").html(HTML);
					
					
				}else{
					alert("提交失败!");
				}
			}
		})
	})
	
	
	$("#returnsDiv").on('click',function(){
		window.history.back();
	})
	$("#subBtnDiv").on('click',function(){
		$.post(
			'${base}/confirm-excel-file.html',
			{id:${excel.id},status:1},
			function(data){
			if(data.success){
				alert("确认成功!");
			window.location="${base}/fileList.html"	
			}
			}
		)
	})
	$("#rejectBtnDiv").on('click',function(){
		$.post(
			'${base}/confirm-excel-file.html',
			{id:${excel.id},status:2},
			function(data){
			if(data.success){
				alert("驳回成功!");
			window.location="${base}/fileList.html"	
			}
			}
		)
	})
</script>

