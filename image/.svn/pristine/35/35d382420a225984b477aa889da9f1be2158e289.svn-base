
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title></title>
		<META NAME="Generator" CONTENT="EditPlus">  
 		<META NAME="Author" CONTENT=""> 
		<META NAME="Keywords" CONTENT="">  
		<META NAME="Description" CONTENT=""> 
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<style>
  	.td_top{font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)}
  	.td_bottom{font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)}
  	.margin_td{width:70px}
  	.margin_td_top{margin-top:-4px}
  	.width_left2{width:83px}
  	.margin_td_top2{margin-top:-8px}
		</style>
		<script src="//cdn.bootcss.com/jquery/2.2.1/jquery.min.js"></script>
	</head>
	<body > 
  		<div id="print2" >
  		  
  		</div>

		<script type="text/javascript">
		$(function(){
			printView();
		}); 
		
		
		function printView(){ 
			selectLogView();
			eval("print2").style.visibility="visible";  
			//document.all.wb.ExecWB(8,1);//打印页面设置
			//document.all.wb.ExecWB(7,1);//打印预览
			 
			eval("print2").style.visibility="visible"; 
		 
		} 
		
		function trim(str){//去除字符串所有空格
		    return str.replace(/\s|\xA0/g,"");    
		}
		
		function selectLogView(){ 
		 
		 $.ajax({
   			type : "post",
   			url:"${base}/get-excel-initial-info",
			data:{
				id:${excel.id},
				fileType:${excel.fileType}
			},
   			dataType: "json",
   			success : function(data) {
   				
				var a = ${excel.fileType};
				var HTML = "";
				
				if(a == 1){//价格吊牌1
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703px;margin-right:50px;position:relative;page-break-before:always">'
									+	 '			  <img alt="" src="${base}/static/images/fileUpload/initial模板-05.png" style="width:310px;height:703px; page-break-before: always;">'
									+	 '		      <div><span style="position:absolute;left:75px;top:22px;font-size:12px;">'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '		      <div><span style="position:absolute;left:178px;top:22px;font-size:12px;">'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '		      <div><span style="position:absolute;left:246px;top:22px;font-size:12px;">'+data.obj[i][j][k].orderQty+'</span></div>'
									+	 '		      <div style="margin:-614px 0px 0px 0px;">'
									+	 '					<div style="margin:0px 0px 0px 53px;">'
									+	 '						<span style="letter-spacing:2.5px;font-size:18px;">'+data.obj[i][j][k].itemNo+'</span>'
									+	 '					</div>'
									+	 '					<div style="margin-top:35px">'
									+	 '						<div style="margin-left:35px;font-size:18px;">'+data.obj[i][j][k].colour+'</div>'
									+	 '						<div style="margin:-24px 0px 0px 117px;font-size:18px;">'+data.obj[i][j][k].size+'</div>'
									+	 '						<div style="margin:-18px 0px 0px 200px;font-size:12px;-webkit-transform-origin-x:0;-webkit-transform: scale(0.95)">'+data.obj[i][j][k].currency+'</div>'
									+	 '						<div style="margin:-22px 24px 0px 0px;font-size:18px;text-align:right">'+data.obj[i][j][k].unitPrice+'</div>'
													  var setPrice = "";
								  					  var thisSetPrice = trim(data.obj[i][j][k].setPrice);//去空格
													  if(thisSetPrice == "SETPRICE"){
														  setPrice = "(SET PRICE)";
													  }
					 HTML = HTML	+	 '						<div style="margin:0px 8px 0px 0px;font-size:18px;text-align:right;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'+setPrice+'</div>'
									+	 '					</div>'
									+	 '		      		<div style="margin:46px 0px 0px 53px;font-size:12px;">'
									+	 '		          		<span>'+data.obj[i][j][k].description+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:295px 0px 0px 36px;letter-spacing:10.7px;font-size:14px;">'
									+	 '		          		<span>'+data.obj[i][j][k].barCode+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:40px 0px 0px 32px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		          		<span>'+data.obj[i][j][k].itemNo+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:-16px 0px 0px 165px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		          		<span>'+data.obj[i][j][k].colour+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:-15px 0px 0px 227px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		          		<span>'+data.obj[i][j][k].size+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:33px 0px 0px 33px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		          		<span>'+data.obj[i][j][k].description+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:-14px 0px 0px 164px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		          		<span>'+data.obj[i][j][k].currency+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:-22px 0px 0px 203px;font-size:18px">'
									+	 '		          		<span>'+data.obj[i][j][k].unitPrice+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:-3px 0px 0px 198px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		          		<span>'+setPrice+'</span>'
									+	 '		      		</div>'
									+	 '			  </div>'
									+	 '	</td>'				
							}
							HTML = HTML	+	'</tr>'
						}
						HTML = HTML	+  '</table>'
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:50px;" />'
					}

				}else if(a == 2){//价格吊牌2
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:338px;position:relative;margin-right:10px">'
									+	 '			  <img alt="" src="${base}/static/images/fileUpload/initial模板-06.png" style="width:310px;height:338px;">'
									+	 '		      <div><span style="position:absolute;left:75px;top:18px;font-size:12px;">'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '		      <div><span style="position:absolute;left:178px;top:18px;font-size:12px;">'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '		      <div><span style="position:absolute;left:246px;top:18px;font-size:12px;">'+data.obj[i][j][k].orderQty+'</span></div>'
									+	 '		      <div style="margin:-175px 0px 0px 0px">'
									+	 '					<div style="margin:0px 0px 0px 36px;font-size:12px;">'
									+	 '		          		<span>'+data.obj[i][j][k].colour+'</span>'
									+	 '					</div>'
									+	 '					<div style="margin:-15px 0px 0px 116px;font-size:12px;">'
									+	 '		          		<span>'+data.obj[i][j][k].size+'</span> '
									+	 '					</div>'
									+	 '					<div style="margin:-16px 0px 0px 180px;font-size:12px;">'
									+	 '		          		<span>'+data.obj[i][j][k].itemNo+'</span> '
									+	 '					</div>'
									+	 '		      		<div style="margin:55px 0px 0px 37px;letter-spacing:10.7px;font-size:14px;">'
									+	 '		          		<span>'+data.obj[i][j][k].barCode+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:34px 0px 0px 36px;font-size:13px;">'
									+	 '		          		<span>'+data.obj[i][j][k].currency+'</span>'
									+	 '		      		</div>'
									+	 '		      		<div style="margin:-32px 0px 0px 209px;font-size:27px">'
									+	 '		          		<span>'+data.obj[i][j][k].unitPrice+'</span>'
									+	 '		      		</div>'
									+	 '		      </div>'
									+	 '		</div>'
									+	 '	</td>'				
							}
							HTML = HTML	+	'</tr>'
						}
						HTML = HTML	+  '</table>'
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'

					}
					
				}else if(a == 3){//合格证1
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;margin-right:20px;position:relative;page-break-before:always">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
									 +	 '			<div class="td_top" style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>' 
									+	 '	      	<div style="margin:-624px 0px 0px 36px;">'
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
									/* 			if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null && data.obj[i][j][k].artNo != ''){
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
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">等级</td>'
									+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
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
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">安全类别</td>'
									+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].category+'</div></td>'
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
									+	 '		      <div style="margin:-2px 0px 0px 36px;width:600px">'
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
													if(m == 0){
														HTML = HTML	+	 '<td><div style="margin-top:0px;">'+componentInfo+'</div></td>'
													}else{
														HTML = HTML	+	 '<td><div style="margin-top:-2px;">'+componentInfo+'</div></td>'
													}
													+	 '	    </tr>'
											}
									if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != null && data.obj[i][j][k].fabricList[l].remarks != ''){
										HTML = HTML		+	 ' 		<tr class="td_top">'
										+	 '			<td class="margin_td"></td>'
										+	 '			<td>'
													for(var m=0;m<data.obj[i][j][k].fabricList[l].remarksList.length;m++){
														if(m==0){
										HTML = HTML		+		'<div style="margin-top:-5px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'	
														}else{
										HTML = HTML		+		'<div style="margin-top:2px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'	
														}
													}
								HTML = HTML		+	 '	</td></tr>'
									}
									HTML = HTML	+	 '    </table>'
										}
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:-4px 0px 0px 36px;">'
												if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '		      	<div>'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">生产日期</td>'
									+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
						HTML = HTML	+	 '		        <div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">检测员</td>'
									+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
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
						HTML = HTML	+	 '		           	<div class="margin_td_top" style="width:600px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">经销商</td>'
									+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top" style="width:600px">'
									+	 '		      			<table>'
												if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">地址</td>'
									+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'
												}
									
						HTML = HTML	+	 '		           		</table>'
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
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">邮政编码</td>'
									+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].washingInstructions != 'null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
						HTML = HTML	+	 '		           	<div style="margin-top:-8px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">洗涤说明</td>'
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
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:30px;" />' 
					}
				}else if(a == 4){//合格证2
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
									+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
									+	 '			<div class="td_top" style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
									+	 '	      	<div style="margin:-280px 0px 0px 38px;">'
												if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null &&data.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">产品名称</td>'
									+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null &&data.obj[i][j][k].itemNo != ''){
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
										/* 		if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null &&data.obj[i][j][k].artNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">货号</td>'
									+	 '		           				<td>'+data.obj[i][j][k].artNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												} */
												if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null &&data.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">内部码</td>'
									+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null &&data.obj[i][j][k].grade != ''){
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
												if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null &&data.obj[i][j][k].securityCategory != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">安全类别</td>'
									+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2"></td>'
									+	 '		           				<td><div style="margin-top:-4px">'+data.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
												if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null &&data.obj[i][j][k].colour != '' ){
						HTML = HTML	+ 	 '			<div class="margin_td_top2">'
									+	 '		      	<table>'
									+	 '		           		<tr class="td_top">'
									+	 '		           			<td class="width_left2">颜色</td>'
									+	 '		           			<td>'+data.obj[i][j][k].colour+'</td>'
									+	 '		           		</tr>'
									+	 '		         </table>'	
									+	 '		 	</div>'
												}
						HTML = HTML	+	 '	</div>'
									+	 '	<div style="margin:-8px 0px 0px 38px;width:600px">'
										for(var l=0;l<data.obj[i][j][k].fabricList.length;l++){
											if(l == 0){
												HTML = HTML	+	 '<table>'
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
															HTML = HTML	+	 '<td><div style="margin-top:1px;">'+componentInfo+'</div></td>'
														}else{
															HTML = HTML	+	 '<td><div style="margin-top:-6px;">'+componentInfo+'</div></td>'
														}
														+	 '	    </tr>'
												}
												if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != ''){
									HTML = HTML		+	 ' 		<tr class="td_top">'
													+	 '			<td class="width_left2"></td>'
													+	 '			<td>'
													for(var m=0;m<data.obj[i][j][k].fabricList[l].remarksList.length;m++){
														if(m==0){
													HTML = HTML		+		'<div style="margin-top:-7px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
														}else{
													HTML = HTML		+		'<div style="margin-top:-1px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
														}
													}
											HTML = HTML		+	 '	</td></tr>'
												}
												HTML = HTML	+	 '</table>'
											}else{
												HTML = HTML	+	 '<table style="margin-top:-8px;">'
												for(var m=0;m<data.obj[i][j][k].fabricList[l].component.length;m++){
													var name = "";
													if(m == 0){name=data.obj[i][j][k].fabricList[l].name }
												HTML = HTML	+	 ' <tr class="td_top"  style="border:1px solid red;">'
														+	 '	     	<td class="width_left2">'+name+'</td>'
														var componentInfo = "";
														for(var n=0;n<data.obj[i][j][k].fabricList[l].component[m].length;n++){
															componentInfo = componentInfo + data.obj[i][j][k].fabricList[l].component[m][n]+"&nbsp;";
														}
														if(m == 0){
															HTML = HTML	+	 '<td><div style="margin-top:-2px;">'+componentInfo+'</div></td>'
														}else{
															HTML = HTML	+	 '<td><div style="margin-top:-6px;">'+componentInfo+'</div></td>'
														}
														+	 '	    </tr>'
												}
												if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != null && data.obj[i][j][k].fabricList[l].remarks != ''){
													HTML = HTML		+	 ' 		<tr class="td_top">'
													+	 '			<td class="width_left2"></td>'
													+	 '			<td><div style="margin-top:-6px;">'+data.obj[i][j][k].fabricList[l].remarks+'</div></td>'
													+	 '	    </tr>'
												}
												HTML = HTML	+	 '</table>'
											}
										}
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:-8px 0px 0px 38px;">'
												if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null &&data.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '	  			<div>'
									+	 '		           	<table>'
									+	 '		           		<tr class="td_top">'
									+	 '		           			<td class="width_left2">生产日期</td>'
									+	 '		           			<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           		</tr>'
									+	 '		           	</table>'
									+	 '		     	</div>'
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
												if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null &&data.obj[i][j][k].placeOfOrigin != ''){
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
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="width:600px;">'
									+	 '		      			<table>'
												if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null &&data.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">地址</td>'
									+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2"></td>'
									+	 '		           				<td><div style="margin-top:-7px">'+data.obj[i][j][k].locationInfo+'</div></td>'
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
						HTML = HTML	+	 '		           	<div class="margin_td_top2">'
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
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'
					}
				}else if(a == 5 || a == 9){//fall 合格证  大  ||  成衣 -合格证 （非两件套）
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;margin-right:20px;position:relative;page-break-before:always">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
									 +	 '			<div class="td_top" style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>' 
									+	 '	      	<div style="margin:-624px 0px 0px 36px;">'
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
									/* 			if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null && data.obj[i][j][k].artNo != ''){
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
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">等级</td>'
									+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
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
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">安全类别</td>'
									+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].category+'</div></td>'
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
						HTML = HTML	+	 '		      	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">成份</td>'
									+	 '		           				<td>'+data.obj[i][j][k].fabricString+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '		      	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">生产日期</td>'
									+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
						HTML = HTML	+	 '		        <div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">检测员</td>'
									+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
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
						HTML = HTML	+	 '		           	<div class="margin_td_top" style="width:600px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">经销商</td>'
									+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top" style="width:600px">'
									+	 '		      			<table>'
												if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">地址</td>'
									+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'
												}
									
						HTML = HTML	+	 '		           		</table>'
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
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">邮政编码</td>'
									+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].washingInstructions != 'null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
						HTML = HTML	+	 '		           	<div style="margin-top:-8px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">洗涤说明</td>'
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
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:30px;" />' 
					}
				}else if(a == 6){//fall  合格证  小
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
									+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
									+	 '			<div class="td_top" style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
									+	 '	      	<div style="margin:-280px 0px 0px 38px;">'
												if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null &&data.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">产品名称</td>'
									+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null &&data.obj[i][j][k].itemNo != ''){
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
												if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null &&data.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">内部码</td>'
									+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null &&data.obj[i][j][k].grade != ''){
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
												if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null &&data.obj[i][j][k].securityCategory != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">安全类别</td>'
									+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2"></td>'
									+	 '		           				<td><div style="margin-top:-4px">'+data.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'

												if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null &&data.obj[i][j][k].colour != '' ){
						HTML = HTML	+ 	 '			<div class="margin_td_top2">'
									+	 '		      	<table>'
									+	 '		           		<tr class="td_top">'
									+	 '		           			<td class="width_left2">颜色</td>'
									+	 '		           			<td>'+data.obj[i][j][k].colour+'</td>'
									+	 '		           		</tr>'
									+	 '		         </table>'	
									+	 '		 	</div>'
												}
												if(data.obj[i][j][k].fabricString != 'null' && data.obj[i][j][k].fabricString != null &&data.obj[i][j][k].fabricString != ''){
						HTML = HTML	+	 '	  		<div class="margin_td_top2">'
									+	 '		           	<table>'
									+	 '		           		<tr class="td_top">'
									+	 '		           			<td class="width_left2">成份</td>'
									+	 '		           			<td>'+data.obj[i][j][k].fabricString+'</td>'
									+	 '		           		</tr>'
									+	 '		           	</table>'
									+	 '		     </div>'
												}
												if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null &&data.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '	  		<div class="margin_td_top2">'
									+	 '		           	<table>'
									+	 '		           		<tr class="td_top">'
									+	 '		           			<td class="width_left2">生产日期</td>'
									+	 '		           			<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           		</tr>'
									+	 '		           	</table>'
									+	 '		     </div>'
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
												if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null &&data.obj[i][j][k].placeOfOrigin != ''){
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
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="width:600px;">'
									+	 '		      			<table>'
												if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null &&data.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">地址</td>'
									+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2"></td>'
									+	 '		           				<td><div style="margin-top:-7px">'+data.obj[i][j][k].locationInfo+'</div></td>'
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
						HTML = HTML	+	 '		           	<div class="margin_td_top2">'
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
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'
					}
				}else if(a == 7){//2019新合格证（大）
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;margin-right:20px;position:relative;page-break-before:always">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
									 +	 '			<div class="td_top" style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>' 
									+	 '	      	<div style="margin:-624px 0px 0px 36px;">'
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
									/* 			if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null && data.obj[i][j][k].artNo != ''){
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
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">等级</td>'
									+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].productStandard != 'null' && data.obj[i][j][k].productStandard != null && data.obj[i][j][k].productStandard != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
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
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">安全类别</td>'
									+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].category+'</div></td>'
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
									+	 '		      <div style="margin:-2px 0px 0px 36px;width:600px">'
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
													if(m == 0){
														HTML = HTML	+	 '<td><div style="margin-top:0px;">'+componentInfo+'</div></td>'
													}else{
														HTML = HTML	+	 '<td><div style="margin-top:-2px;">'+componentInfo+'</div></td>'
													}
													+	 '	    </tr>'
											}
									if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != null && data.obj[i][j][k].fabricList[l].remarks != ''){
										HTML = HTML		+	 ' 		<tr class="td_top">'
										+	 '			<td class="margin_td"></td>'
										+	 '			<td>'
													for(var m=0;m<data.obj[i][j][k].fabricList[l].remarksList.length;m++){
														if(m==0){
										HTML = HTML		+		'<div style="margin-top:-5px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'	
														}else{
										HTML = HTML		+		'<div style="margin-top:2px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'	
														}
													}
								HTML = HTML		+	 '	</td></tr>'
									}
									HTML = HTML	+	 '    </table>'
										}
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:-4px 0px 0px 36px;">'
												if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '		      	<div>'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">生产日期</td>'
									+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
						HTML = HTML	+	 '		        <div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">检测员</td>'
									+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
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
						HTML = HTML	+	 '		           	<div class="margin_td_top" style="width:600px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">经销商</td>'
									+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top" style="width:600px">'
									+	 '		      			<table>'
												if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">地址</td>'
									+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'
												}
									
						HTML = HTML	+	 '		           		</table>'
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
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">邮政编码</td>'
									+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].washingInstructions != 'null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
						HTML = HTML	+	 '		           	<div style="margin-top:-8px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">洗涤说明</td>'
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
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:30px;" />' 
					}
				}else if(a == 8){////2019新合格证（小）
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
									+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
									+	 '			<div class="td_top" style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>'
									+	 '	      	<div style="margin:-280px 0px 0px 38px;">'
												if(data.obj[i][j][k].productName != 'null' && data.obj[i][j][k].productName != null &&data.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">产品名称</td>'
									+	 '		           				<td>'+data.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].itemNo != 'null' && data.obj[i][j][k].itemNo != null &&data.obj[i][j][k].itemNo != ''){
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
												if(data.obj[i][j][k].internalCode != 'null' && data.obj[i][j][k].internalCode != null &&data.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">内部码</td>'
									+	 '		           				<td>'+data.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].grade != 'null' && data.obj[i][j][k].grade != null &&data.obj[i][j][k].grade != ''){
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
												if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null &&data.obj[i][j][k].securityCategory != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">安全类别</td>'
									+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2"></td>'
									+	 '		           				<td><div style="margin-top:-4px">'+data.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
												if(data.obj[i][j][k].colour != 'null' && data.obj[i][j][k].colour != null &&data.obj[i][j][k].colour != '' ){
						HTML = HTML	+ 	 '			<div class="margin_td_top2">'
									+	 '		      	<table>'
									+	 '		           		<tr class="td_top">'
									+	 '		           			<td class="width_left2">颜色</td>'
									+	 '		           			<td>'+data.obj[i][j][k].colour+'</td>'
									+	 '		           		</tr>'
									+	 '		         </table>'	
									+	 '		 	</div>'
												}
						HTML = HTML	+	 '	</div>'
									+	 '	<div style="margin:-8px 0px 0px 38px;width:600px">'
										for(var l=0;l<data.obj[i][j][k].fabricList.length;l++){
											if(l == 0){
												HTML = HTML	+	 '<table>'
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
															HTML = HTML	+	 '<td><div style="margin-top:1px;">'+componentInfo+'</div></td>'
														}else{
															HTML = HTML	+	 '<td><div style="margin-top:-6px;">'+componentInfo+'</div></td>'
														}
														+	 '	    </tr>'
												}
												if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != ''){
									HTML = HTML		+	 ' 		<tr class="td_top">'
													+	 '			<td class="width_left2"></td>'
													+	 '			<td>'
													for(var m=0;m<data.obj[i][j][k].fabricList[l].remarksList.length;m++){
														if(m==0){
													HTML = HTML		+		'<div style="margin-top:-7px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
														}else{
													HTML = HTML		+		'<div style="margin-top:-1px;">'+data.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
														}
													}
											HTML = HTML		+	 '	</td></tr>'
												}
												HTML = HTML	+	 '</table>'
											}else{
												HTML = HTML	+	 '<table style="margin-top:-8px;">'
												for(var m=0;m<data.obj[i][j][k].fabricList[l].component.length;m++){
													var name = "";
													if(m == 0){name=data.obj[i][j][k].fabricList[l].name }
												HTML = HTML	+	 ' <tr class="td_top"  style="border:1px solid red;">'
														+	 '	     	<td class="width_left2">'+name+'</td>'
														var componentInfo = "";
														for(var n=0;n<data.obj[i][j][k].fabricList[l].component[m].length;n++){
															componentInfo = componentInfo + data.obj[i][j][k].fabricList[l].component[m][n]+"&nbsp;";
														}
														if(m == 0){
															HTML = HTML	+	 '<td><div style="margin-top:-2px;">'+componentInfo+'</div></td>'
														}else{
															HTML = HTML	+	 '<td><div style="margin-top:-6px;">'+componentInfo+'</div></td>'
														}
														+	 '	    </tr>'
												}
												if(data.obj[i][j][k].fabricList[l].remarks != 'null' && data.obj[i][j][k].fabricList[l].remarks != null && data.obj[i][j][k].fabricList[l].remarks != ''){
													HTML = HTML		+	 ' 		<tr class="td_top">'
													+	 '			<td class="width_left2"></td>'
													+	 '			<td><div style="margin-top:-6px;">'+data.obj[i][j][k].fabricList[l].remarks+'</div></td>'
													+	 '	    </tr>'
												}
												HTML = HTML	+	 '</table>'
											}
										}
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:-8px 0px 0px 38px;">'
												if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null &&data.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '	  			<div>'
									+	 '		           	<table>'
									+	 '		           		<tr class="td_top">'
									+	 '		           			<td class="width_left2">生产日期</td>'
									+	 '		           			<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           		</tr>'
									+	 '		           	</table>'
									+	 '		     	</div>'
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
												if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].placeOfOrigin != null &&data.obj[i][j][k].placeOfOrigin != ''){
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
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="width:600px;">'
									+	 '		      			<table>'
												if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null &&data.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2">地址</td>'
									+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="width_left2"></td>'
									+	 '		           				<td><div style="margin-top:-7px">'+data.obj[i][j][k].locationInfo+'</div></td>'
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
						HTML = HTML	+	 '		           	<div class="margin_td_top2">'
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
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;" />'
					}
				}else if(a==10){//成衣 --合格证（两件套）
					for(var i=0;i<data.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.obj[i][j].length;k++){
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;margin-right:20px;position:relative;page-break-before:always">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
									 +	 '			<div class="td_top" style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:186px;top:18px;"><span>'+data.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div class="td_top" style="position:absolute;left:256px;top:18px;"><span>'+data.obj[i][j][k].orderQty+'</span></div>' 
									+	 '	      	<div style="margin:-624px 0px 0px 36px;">'
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
									/* 			if(data.obj[i][j][k].artNo != 'null' && data.obj[i][j][k].artNo != null && data.obj[i][j][k].artNo != ''){
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
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">等级</td>'
									+	 '		           				<td>'+data.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.obj[i][j][k].productStandardList.length>0){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
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
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
												if(data.obj[i][j][k].securityCategory != 'null' && data.obj[i][j][k].securityCategory != null && data.obj[i][j][k].securityCategory != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">安全类别</td>'
									+	 '		           				<td>'+data.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].category != 'null' && data.obj[i][j][k].category != null && data.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].category+'</div></td>'
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
						HTML = HTML	+	 '		      	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">成份</td>'
									+	 '		           				<td>'+data.obj[i][j][k].fabricString+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].dateOfManufacture != 'null' && data.obj[i][j][k].dateOfManufacture != null && data.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '		      	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">生产日期</td>'
									+	 '		           				<td>'+data.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].inspector != 'null' && data.obj[i][j][k].inspector != null && data.obj[i][j][k].inspector != ''){
						HTML = HTML	+	 '		        <div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">检测员</td>'
									+	 '		           				<td>'+data.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].placeOfOrigin != 'null' && data.obj[i][j][k].distributor != null && data.obj[i][j][k].distributor != ''){
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
						HTML = HTML	+	 '		           	<div class="margin_td_top" style="width:600px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">经销商</td>'
									+	 '		           				<td>'+data.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top" style="width:600px">'
									+	 '		      			<table>'
												if(data.obj[i][j][k].location != 'null' && data.obj[i][j][k].location != null && data.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">地址</td>'
									+	 '		           				<td>'+data.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.obj[i][j][k].locationInfo != 'null' && data.obj[i][j][k].locationInfo != null && data.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'
												}
									
						HTML = HTML	+	 '		           		</table>'
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
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">邮政编码</td>'
									+	 '		           				<td>'+data.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.obj[i][j][k].washingInstructions != 'null' && data.obj[i][j][k].washingInstructions != null && data.obj[i][j][k].washingInstructions != ''){
						HTML = HTML	+	 '		           	<div style="margin-top:-8px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top">'
									+	 '		           				<td class="margin_td">洗涤说明</td>'
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
									+	'<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:30px;" />' 
					}
				}
				
				
	
				
				
				
				$("#print2").html(HTML);
				window.print();
   			},
   			error : function(err) {
   			}
    	});  
	} 



	
	
	
		</script>
	</body>
</html>