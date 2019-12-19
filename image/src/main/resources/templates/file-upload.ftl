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
		 <input id="fileName" type="hidden" name="fileName">
	    <div class="user-con pb0">
	  		<div class="right_con">
					<div class="right_title">文件小助手</div>
						<div style="font-size:17px;margin-top:20px">上传Excel文件</div>
						<div style="font-size:15px;margin-top:4px;"><a href="${base}/down-load-template.html?id=${id}" style="color:red">下载Excel模板</a>&nbsp;<span style="color:red;">↓</span></div>
						
						<table>
							<tr>
								<td>
									<#if id=1>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:30px 0px 0px 30px">
											<!-- 价格牌1start -->
											<div style="width:101px;height:230px;position:relative;margin:auto;margin-top:15px">
												  <img alt="" src="${base}/static/images/fileUpload/initial模板-01.png" style="width:101px;height:230px;">
											</div>
											<!-- 价格牌1end -->
										</div>
									</#if>
									<#if id=2>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_2" onclick="nextStep(2)">
											<div style="width:150px;height:163.7px;position:relative;margin:auto;margin-top:40px">
												  <img alt="" src="${base}/static/images/fileUpload/initial模板-02.png" style="width:150px;height:163.7px;">
											</div>
										</div>	
									</#if>
									<#if id=3>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_3" onclick="nextStep(3)">
											<div style="width:101px;height:230px;position:relative;margin:auto;margin-top:15px">
												  <img alt="" src="${base}/static/images/fileUpload/initial模板-03.png" style="width:101px;height:230px;">
											</div>									
										</div>	
									</#if>
									<#if id=4>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_4" onclick="nextStep(4)">
											<div style="width:150px;height:163.7px;position:relative;margin:auto;margin-top:40px">
												  <img alt="" src="${base}/static/images/fileUpload/initial模板-04.png" style="width:150px;height:163.7px;">
											</div>
										</div>	
									</#if>
									<#if id=5>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_3" onclick="nextStep(5)">
											<div style="width:101px;height:230px;position:relative;margin:auto;margin-top:15px">
												  <img alt="" src="${base}/static/images/fileUpload/initial模板-03.png" style="width:101px;height:230px;">
											</div>									
										</div>	
									</#if>
									<#if id=6>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_4" onclick="nextStep(6)">
											<div style="width:150px;height:163.7px;position:relative;margin:auto;margin-top:40px">
												  <img alt="" src="${base}/static/images/fileUpload/initial模板-04.png" style="width:150px;height:163.7px;">
											</div>
										</div>	
									</#if>
									<#if id=7>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_3" onclick="nextStep(7)">
											<div style="width:101px;height:230px;position:relative;margin:auto;margin-top:15px">
												  <img alt="" src="${base}/static/images/fileUpload/initial模板-03.png" style="width:101px;height:230px;">
											</div>									
										</div>	
									</#if>
									<#if id=8>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_4" onclick="nextStep(8)">
											<div style="width:150px;height:163.7px;position:relative;margin:auto;margin-top:40px">
												  <img alt="" src="${base}/static/images/fileUpload/initial模板-04.png" style="width:150px;height:163.7px;">
											</div>
										</div>	
									</#if>
									<#if id=9>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_3" onclick="nextStep(9)">
											<div style="width:101px;height:230px;position:relative;margin:auto;margin-top:15px">
												  <img alt="" src="${base}/static/images/fileUpload/chengyi1-hegezheng.png" style="width:101px;height:230px;">
											</div>									
										</div>	
									</#if>
									<#if id=10>
										<div style="width:260px;height:260px;border:1px solid #D2D2D2;margin:auto" id="initial_3" onclick="nextStep(10)">
											<div style="width:101px;height:230px;position:relative;margin:auto;margin-top:15px">
												  <img alt="" src="${base}/static/images/fileUpload/chengyi2-hegezheng.png" style="width:101px;height:230px;">
											</div>									
										</div>	
									</#if>
								</td>
								<td style="position:relative;width:400px">
									<div id="upload_button1" style="color:#d90b19;position:absolute;left:36px;top:10px;width:400px;">
									
									</div>
									<div style="width:75px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center;position:absolute;left:36px;top:40px;" id="upload_button_div">
										<a style="color:#d90b19;text-decoration:none;cursor:pointer;" id="upload_button" onclick="addImage()">上传文件</a>
										<input id="multupload" type="file" name="file" style="display:none">
									</div>
								</td>
							</tr>
						</table>

						
		          



						
						<hr style="height:1px;border:none;border-top:1px dashed #D2D2D2;margin-top:40px;" />
						
						<!--startprint-->
						<div id="hehe">	
						
						
								
						
						
						
						</div>
						<!--endprint-->
						
						
						<table style="margin:auto;margin-bottom:100px">
							<tr>
								<td>
									<div style="width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center;margin-left:20px; line-height:23px; color:#d90b19; margin-bottom:10px;">
										<a id="returns" style="color:#d90b19;cursor:pointer;text-decoration:none">返回</a>
									</div>
								</td>
								<td>
									<div id="subBtnDiv" style="display:none;width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center; margin-left:20px; line-height:23px; color:#d90b19; margin-bottom:10px;">
										<a id="subBtn"  style="color:#d90b19;cursor:pointer;text-decoration:none">提交</a>
									</div>
								</td>
								<td>
									<div id="getPrint" style="display:none;width:68px;height:23px;font-size:15px; border:1px solid #d90b19;text-align:center;margin-left:20px; line-height:23px; color:#d90b19; margin-bottom:10px;">
										<a id="" onclick="doPrint()"  style="color:#d90b19;cursor:pointer;text-decoration:none">打印</a>
									</div>
								</td>
							</tr>
						</table>


			</div>
		</div>
	</div>
</div>

<script src="${base}/static/js/jquery.min.js"></script>
<script src="${base}/static/js/fileupload/vendor/jquery.ui.widget.js"></script>
<script src="${base}/static/js/fileupload/jquery.iframe-transport.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-process.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-validate.js"></script>


<script>
	$("#returns").click(function(){
		window.history.go(-1);
	})
	function addImage(){
		$("#multupload").click();
	}
	
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
	
	$(function() {
		$('#multupload').fileupload({
	        url: "<#if id=1>${base}/excel-upload-diaopai1</#if><#if id=2>${base}/excel-upload-diaopai2</#if><#if id=3>${base}/excel-upload-hegezheng1</#if><#if id=4>${base}/excel-upload-hegezheng2</#if><#if id=5 || id=9>${base}/excel-upload-hegezheng-fall-da</#if><#if id=6>${base}/excel-upload-hegezheng-fall-xiao</#if><#if id=7 ||id=8>${base}/excel-upload-hegezheng-xin</#if><#if id=10>${base}/excel-upload-hegezheng-chengyi</#if>",
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
					
				var HTML = "";
				if(${id} == 1){//价格吊牌1
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table>'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:10px">'
									+	 '			  <img alt="" src="${base}/static/images/fileUpload/initial模板-05.png" style="width:310px;height:703.5px;">'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:75px;top:18px;font-size:12px;">'+data.result.obj[i][j][k].customerName+'</span>'
									+	 '		          <span style="position:absolute;left:178px;top:18px;font-size:12px;">'+data.result.obj[i][j][k].smlpc+'</span> '
									+	 '		          <span style="position:absolute;left:246px;top:18px;font-size:12px;">'+data.result.obj[i][j][k].orderQty+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '					<span style="position:absolute;left:54px;top:93px;letter-spacing:2.7px;font-size:18px;">'+data.result.obj[i][j][k].itemNo+'</span>'
									+	 '			  </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:34px;top:152px;font-size:18px;">'+data.result.obj[i][j][k].colour+'</span>'
									+	 '		          <span style="position:absolute;left:118px;top:152px;font-size:18px;">'+data.result.obj[i][j][k].size+'</span> '
									+	 '		          <span style="position:absolute;left:201px;top:157px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'+data.result.obj[i][j][k].currency+'</span> '
									+	 '		          <span style="position:absolute;right:24px;top:152px;font-size:18px;">'+data.result.obj[i][j][k].unitPrice+'</span>'
														  var setPrice = "";
														  var thisSetPrice = trim(data.result.obj[i][j][k].setPrice);//去空格
														  if(thisSetPrice == "SETPRICE"){
															  setPrice = "(SET PRICE)";
														  }
				 	HTML = HTML		+	 '		          <span style="position:absolute;right:22px;top:175px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'+setPrice+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:54px;top:220px;">'+data.result.obj[i][j][k].description+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:40px;top:535px;letter-spacing:13px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)"  class="td_bottom">'+data.result.obj[i][j][k].barCode+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:33px;top:594px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)" class="td_bottom">'+data.result.obj[i][j][k].itemNo+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:166px;top:594px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)" class="td_bottom">'+data.result.obj[i][j][k].colour+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:228px;top:594px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)" class="td_bottom">'+data.result.obj[i][j][k].size+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:34px;top:643px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)" class="td_bottom">'+data.result.obj[i][j][k].description+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:166px;top:645px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)" class="td_bottom">'+data.result.obj[i][j][k].currency+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:205px;top:639px;font-size:18px">'+data.result.obj[i][j][k].unitPrice+'</span>'
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
				}else if(${id} == 2){//价格吊牌2
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px">'
									+	 '			  <img alt="" src="${base}/static/images/fileUpload/initial模板-06.png" style="width:310px;height:338.2px;">'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:75px;top:18px;font-size:12px;">'+data.result.obj[i][j][k].customerName+'</span>'
									+	 '		          <span style="position:absolute;left:178px;top:18px;font-size:12px;">'+data.result.obj[i][j][k].smlpc+'</span> '
									+	 '		          <span style="position:absolute;left:246px;top:18px;font-size:12px;">'+data.result.obj[i][j][k].orderQty+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:36px;top:168px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'+data.result.obj[i][j][k].colour+'</span>'
									+	 '		          <span style="position:absolute;left:119px;top:168px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)" >'+data.result.obj[i][j][k].size+'</span> '
									+	 '		          <span style="position:absolute;left:180px;top:168px;letter-spacing:1px;font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)" class="td_top">'+data.result.obj[i][j][k].itemNo+'</span> '
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:37px;top:238px;letter-spacing:11.8px;">'+data.result.obj[i][j][k].barCode+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:39px;top:291px;font-size:14px">'+data.result.obj[i][j][k].currency+'</span>'
									+	 '		      </div>'
									+	 '		      <div>'
									+	 '		          <span style="position:absolute;left:210px;top:277px;font-size:28px">'+data.result.obj[i][j][k].unitPrice+'</span>'
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
				}else if(${id} == 3){//合格证1
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									var customerName = "";
									var smlpc = "";
									var orderQty = "";
									if(data.result.obj[i][j][k].customerName != 'null' && data.result.obj[i][j][k].customerName != null){
										customerName = data.result.obj[i][j][k].customerName;
									}
									if(data.result.obj[i][j][k].smlpc != 'null' && data.result.obj[i][j][k].smlpc != null){
										smlpc = data.result.obj[i][j][k].smlpc;
									}
									if(data.result.obj[i][j][k].orderQty != 'null' && data.result.obj[i][j][k].orderQty != null){
										orderQty = data.result.obj[i][j][k].orderQty;
									}
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:20px">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
									+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+customerName+'</span></div>'
									+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+smlpc+'</span></div>'
									+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+orderQty+'</span></div>'
									+	 '	      	<div style="margin:-618px 0px 0px 38px;">'
												if(data.result.obj[i][j][k].productName != 'null' && data.result.obj[i][j][k].productName != null && data.result.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产品名称</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].itemNo != 'null' && data.result.obj[i][j][k].itemNo != null && data.result.obj[i][j][k].itemNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		      	   		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">货品编号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].itemNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].type != 'null' && data.result.obj[i][j][k].type != null && data.result.obj[i][j][k].type != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">号型</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].type+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
											/* 	if(data.result.obj[i][j][k].artNo != 'null' && data.result.obj[i][j][k].artNo != null && data.result.obj[i][j][k].artNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">货号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].artNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												} */
												if(data.result.obj[i][j][k].internalCode != 'null' && data.result.obj[i][j][k].internalCode != null && data.result.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">内部码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].grade != 'null' && data.result.obj[i][j][k].grade != null && data.result.obj[i][j][k].grade != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">等级</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].productStandard != 'null' && data.result.obj[i][j][k].productStandard != null && data.result.obj[i][j][k].productStandard != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产品标准</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productStandard+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}

						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
														if(data.result.obj[i][j][k].securityCategory != 'null' && data.result.obj[i][j][k].securityCategory != null && data.result.obj[i][j][k].securityCategory != ''){
						HTML = HTML +	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">安全类别</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
														}
														if(data.result.obj[i][j][k].category != 'null' && data.result.obj[i][j][k].category != null && data.result.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px"></td>'
									+	 '		           				<td><div style="margin-top:0px">'+data.result.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
														}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
									
														if(data.result.obj[i][j][k].colour != 'null' && data.result.obj[i][j][k].colour != null && data.result.obj[i][j][k].colour != ''){
						HTML = HTML	+	 '	 			  <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">颜色</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].colour+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
								}
									
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:0px 0px 0px 38px;width:600px">'
										for(var l=0;l<data.result.obj[i][j][k].fabricList.length;l++){
									HTML = HTML	+	 '	  <table class="margin_td_top">'
											for(var m=0;m<data.result.obj[i][j][k].fabricList[l].component.length;m++){
												var name = "";
												if(data.result.obj[i][j][k].fabricList[l].name != 'null' && data.result.obj[i][j][k].fabricList[l].name != null && m == 0){name=data.result.obj[i][j][k].fabricList[l].name }
											HTML = HTML	+	 ' <tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
													+	 '	     	<td class="margin_td" style="width:72px">'+name+'</td>'
													var componentInfo = "";
													for(var n=0;n<data.result.obj[i][j][k].fabricList[l].component[m].length;n++){
														componentInfo = componentInfo + data.result.obj[i][j][k].fabricList[l].component[m][n] + "&nbsp;";
													}
													HTML = HTML	+	 '<td><div style="margin-top:0px;">'+componentInfo+'</div></td>'
													+	 '	    </tr>'
											}
									if(data.result.obj[i][j][k].fabricList[l].remarks != 'null' && data.result.obj[i][j][k].fabricList[l].remarks != null && data.result.obj[i][j][k].fabricList[l].remarks != ''){
										HTML = HTML		+	 ' 		<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '			<td class="margin_td" style="width:72px"></td>'
							HTML = HTML	+	 '			<td>'
												for(var  m=0;m<data.result.obj[i][j][k].fabricList[l].remarksList.length;m++){
													if(m==0){
												HTML = HTML	+			'<div style="margin-top:-1px;">'+data.result.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
													}else{
												HTML = HTML	+			'<div style="margin-top:1px;">'+data.result.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
													}
												}
							HTML = HTML	+    '			</td></tr>'
									}
									HTML = HTML	+	 '    </table>'
										}
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:0px 0px 0px 38px;">'
												if(data.result.obj[i][j][k].dateOfManufacture != 'null' && data.result.obj[i][j][k].dateOfManufacture != null && data.result.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+    '		      		<div>'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">生产日期</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].inspector != 'null' && data.result.obj[i][j][k].inspector != null && data.result.obj[i][j][k].inspector != ''){
						HTML = HTML	+    '		        	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">检测员</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].placeOfOrigin != 'null' && data.result.obj[i][j][k].placeOfOrigin != null && data.result.obj[i][j][k].placeOfOrigin != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产地</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].placeOfOrigin+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].distributor != 'null' && data.result.obj[i][j][k].distributor != null && data.result.obj[i][j][k].distributor != ''){
						HTML = HTML +	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">经销商</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
												if(data.result.obj[i][j][k].location != 'null' && data.result.obj[i][j][k].location != null && data.result.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">地址</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].locationInfo != 'null' && data.result.obj[i][j][k].locationInfo != null && data.result.obj[i][j][k].locationInfo != ''){
						HTML = HTML +	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px"></td>'
									+	 '		           				<td><div style="margin-top:-1px">'+data.result.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'
												}
									+	 '		           		</table>'
									+	 '		           	</div>'
												if(data.result.obj[i][j][k].phone != 'null' && data.result.obj[i][j][k].phone != null && data.result.obj[i][j][k].phone != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">电话</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].phone+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].postalCode != 'null' && data.result.obj[i][j][k].postalCode != null && data.result.obj[i][j][k].postalCode != ''){
						HTML = HTML +	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">邮政编码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
								}
												if(data.result.obj[i][j][k].washingInstructions !='null' && data.result.obj[i][j][k].washingInstructions != null && data.result.obj[i][j][k].washingInstructions != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">洗涤说明</td>'
									+	 '		           				<td><img alt="" src="${base}/static/images/fileUpload/'+data.result.obj[i][j][k].washingInstructions+'.png" style="width:170px;height:18px;margin-top:4px;"></td>'
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

				}else if(${id} == 4){//合格证2
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
									+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px" id="haha">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
									+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.result.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.result.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.result.obj[i][j][k].orderQty+'</span></div>'
									+	 '	      	<div style="margin:-274px 0px 0px 40px;">'
												if(data.result.obj[i][j][k].productName != 'null' && data.result.obj[i][j][k].productName != null && data.result.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">产品名称</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].itemNo != 'null' && data.result.obj[i][j][k].itemNo != null && data.result.obj[i][j][k].itemNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      	   		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">货品编号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].itemNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
									/* 			if(data.result.obj[i][j][k].artNo != 'null' && data.result.obj[i][j][k].artNo != null && data.result.obj[i][j][k].artNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">货号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].artNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												} */
												if(data.result.obj[i][j][k].type != 'null' && data.result.obj[i][j][k].type != null && data.result.obj[i][j][k].type != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">号型</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].type+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].internalCode != 'null' && data.result.obj[i][j][k].internalCode != null && data.result.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">内部码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].grade != 'null' && data.result.obj[i][j][k].grade != null && data.result.obj[i][j][k].grade != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">等级</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].productStandard != 'null' && data.result.obj[i][j][k].productStandard != null && data.result.obj[i][j][k].productStandard != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">产品标准</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productStandard+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
												if(data.result.obj[i][j][k].securityCategory != 'null' && data.result.obj[i][j][k].securityCategory != null && data.result.obj[i][j][k].securityCategory != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">安全类别</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].category != 'null' && data.result.obj[i][j][k].category != null && data.result.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.result.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
						
								if(data.result.obj[i][j][k].colour != 'null' && data.result.obj[i][j][k].colour != null && data.result.obj[i][j][k].colour != ''){
						HTML = HTML	+ 	 '				   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">颜色</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].colour+'</td>'
									+	 '		           			</tr>'
									+	 '		         		</table>'	
									+	 '		 			</div>'
								}
						
								HTML = HTML		+	 '	</div>'
									+	 '		      <div style="margin:-4px 0px 0px 40px;width:600px">'
										for(var l=0;l<data.result.obj[i][j][k].fabricList.length;l++){
									HTML = HTML	+	 '	  <table>'
											for(var m=0;m<data.result.obj[i][j][k].fabricList[l].component.length;m++){
												var name = "";
												if(data.result.obj[i][j][k].fabricList[l].name != 'null' && data.result.obj[i][j][k].fabricList[l].name != null && m == 0){name=data.result.obj[i][j][k].fabricList[l].name }
											HTML = HTML	+	 ' <tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
													+	 '	     	<td class="width_left2" style="width:85px">'+name+'</td>'
													var componentInfo = "";
													for(var n=0;n<data.result.obj[i][j][k].fabricList[l].component[m].length;n++){
														componentInfo = componentInfo + data.result.obj[i][j][k].fabricList[l].component[m][n]+"&nbsp;";
													}
													if(m == 0){
														HTML = HTML	+	 '<td><div style="margin-top:-2px;">'+componentInfo+'</div></td>'
													}else{
														HTML = HTML	+	 '<td><div style="margin-top:-8px;">'+componentInfo+'</div></td>'
													}
													+	 '	    </tr>'
											}
									if(data.result.obj[i][j][k].fabricList[l].remarks != 'null' && data.result.obj[i][j][k].fabricList[l].remarks != null && data.result.obj[i][j][k].fabricList[l].remarks != ''){
						HTML = HTML		+	 ' 		<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '			<td class="width_left2" style="width:85px"></td>'
										+	 '			<td>'
										for(var  m=0;m<data.result.obj[i][j][k].fabricList[l].remarksList.length;m++){
											if(m==0){
									HTML = HTML	+			'<div style="margin-top:-6px;">'+data.result.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
											}else{
									HTML = HTML	+			'<div style="margin-top:-1px;">'+data.result.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
											}
										}
						HTML = HTML		+	 '	    	</td></tr>'
									}
						HTML = HTML		+	 '    </table>'
										}
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:-4px 0px 0px 40px;">'
												if(data.result.obj[i][j][k].dateOfManufacture != 'null' && data.result.obj[i][j][k].dateOfManufacture != null && data.result.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '		        	<div>'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">生产日期</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].inspector != 'null' && data.result.obj[i][j][k].inspector != null && data.result.obj[i][j][k].inspector != ''){
						HTML = HTML	+	 '		        	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">检测员</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].placeOfOrigin != 'null' && data.result.obj[i][j][k].placeOfOrigin != null && data.result.obj[i][j][k].placeOfOrigin != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">产地</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].placeOfOrigin+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].distributor != 'null' && data.result.obj[i][j][k].distributor != null && data.result.obj[i][j][k].distributor != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">经销商</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
												if(data.result.obj[i][j][k].location != 'null' && data.result.obj[i][j][k].location != null && data.result.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">地址</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].locationInfo != 'null' && data.result.obj[i][j][k].locationInfo != null && data.result.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px"></td>'
									+	 '		           				<td><div style="margin-top:-5px">'+data.result.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'				
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		           	</div>'
												if(data.result.obj[i][j][k].phone != 'null' && data.result.obj[i][j][k].phone != null && data.result.obj[i][j][k].phone != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">电话</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].phone+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].postalCode != 'null' && data.result.obj[i][j][k].postalCode != null && data.result.obj[i][j][k].postalCode != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">邮政编码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].washingInstructions != 'null' && data.result.obj[i][j][k].washingInstructions != null && data.result.obj[i][j][k].washingInstructions != ''){
					HTML = HTML		+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">洗涤说明</td>'
									+	 '		           				<td><img alt="" src="${base}/static/images/fileUpload/'+data.result.obj[i][j][k].washingInstructions+'.png" style="width:170px;height:18px;margin-top:4px;"></td>'
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
				}else if(${id} == 5 || ${id} == 9){//fall合格证  大 || 成衣-合格证（非两件套）
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									var customerName = "";
									var smlpc = "";
									var orderQty = "";
									if(data.result.obj[i][j][k].customerName != 'null' && data.result.obj[i][j][k].customerName != null){
										customerName = data.result.obj[i][j][k].customerName;
									}
									if(data.result.obj[i][j][k].smlpc != 'null' && data.result.obj[i][j][k].smlpc != null){
										smlpc = data.result.obj[i][j][k].smlpc;
									}
									if(data.result.obj[i][j][k].orderQty != 'null' && data.result.obj[i][j][k].orderQty != null){
										orderQty = data.result.obj[i][j][k].orderQty;
									}
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:20px">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
									+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+customerName+'</span></div>'
									+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+smlpc+'</span></div>'
									+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+orderQty+'</span></div>'
									+	 '	      	<div style="margin:-618px 0px 0px 38px;">'
												if(data.result.obj[i][j][k].productName != 'null' && data.result.obj[i][j][k].productName != null && data.result.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产品名称</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].itemNo != 'null' && data.result.obj[i][j][k].itemNo != null && data.result.obj[i][j][k].itemNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		      	   		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">货品编号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].itemNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].type != 'null' && data.result.obj[i][j][k].type != null && data.result.obj[i][j][k].type != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">号型</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].type+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
											/* 	if(data.result.obj[i][j][k].artNo != 'null' && data.result.obj[i][j][k].artNo != null && data.result.obj[i][j][k].artNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">货号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].artNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												} */
												if(data.result.obj[i][j][k].internalCode != 'null' && data.result.obj[i][j][k].internalCode != null && data.result.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">内部码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].grade != 'null' && data.result.obj[i][j][k].grade != null && data.result.obj[i][j][k].grade != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">等级</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].productStandard != 'null' && data.result.obj[i][j][k].productStandard != null && data.result.obj[i][j][k].productStandard != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">执行标准</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productStandard+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}

						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
														if(data.result.obj[i][j][k].securityCategory != 'null' && data.result.obj[i][j][k].securityCategory != null && data.result.obj[i][j][k].securityCategory != ''){
						HTML = HTML +	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">安全类别</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
														}
														if(data.result.obj[i][j][k].category != 'null' && data.result.obj[i][j][k].category != null && data.result.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px"></td>'
									+	 '		           				<td><div style="margin-top:0px">'+data.result.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
														}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
									
												if(data.result.obj[i][j][k].colour != 'null' && data.result.obj[i][j][k].colour != null && data.result.obj[i][j][k].colour != ''){
						HTML = HTML	+	 '	 			  <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">颜色</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].colour+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
								}
												if(data.result.obj[i][j][k].fabricString != 'null' && data.result.obj[i][j][k].fabricString != null && data.result.obj[i][j][k].fabricString != ''){
						HTML = HTML	+	 '	 			  <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">成份</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].fabricString+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
													
												if(data.result.obj[i][j][k].dateOfManufacture != 'null' && data.result.obj[i][j][k].dateOfManufacture != null && data.result.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+    '		      		<div>'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">生产日期</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].inspector != 'null' && data.result.obj[i][j][k].inspector != null && data.result.obj[i][j][k].inspector != ''){
						HTML = HTML	+    '		        	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">检测员</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].placeOfOrigin != 'null' && data.result.obj[i][j][k].placeOfOrigin != null && data.result.obj[i][j][k].placeOfOrigin != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产地</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].placeOfOrigin+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].distributor != 'null' && data.result.obj[i][j][k].distributor != null && data.result.obj[i][j][k].distributor != ''){
						HTML = HTML +	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">经销商</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
												if(data.result.obj[i][j][k].location != 'null' && data.result.obj[i][j][k].location != null && data.result.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">地址</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].locationInfo != 'null' && data.result.obj[i][j][k].locationInfo != null && data.result.obj[i][j][k].locationInfo != ''){
						HTML = HTML +	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px"></td>'
									+	 '		           				<td><div style="margin-top:-1px">'+data.result.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'
												}
									+	 '		           		</table>'
									+	 '		           	</div>'
												if(data.result.obj[i][j][k].phone != 'null' && data.result.obj[i][j][k].phone != null && data.result.obj[i][j][k].phone != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">电话</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].phone+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].postalCode != 'null' && data.result.obj[i][j][k].postalCode != null && data.result.obj[i][j][k].postalCode != ''){
						HTML = HTML +	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">邮政编码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
								}
												if(data.result.obj[i][j][k].washingInstructions !='null' && data.result.obj[i][j][k].washingInstructions != null && data.result.obj[i][j][k].washingInstructions != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">洗涤说明</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].washingInstructions+'</td>'
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
				}else if(${id} == 6){//fall合格证 小
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
									+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px" id="haha">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
									+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.result.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.result.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.result.obj[i][j][k].orderQty+'</span></div>'
									+	 '	      	<div style="margin:-274px 0px 0px 40px;">'
												if(data.result.obj[i][j][k].productName != 'null' && data.result.obj[i][j][k].productName != null && data.result.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">产品名称</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].itemNo != 'null' && data.result.obj[i][j][k].itemNo != null && data.result.obj[i][j][k].itemNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      	   		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">货品编号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].itemNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
									/* 			if(data.result.obj[i][j][k].artNo != 'null' && data.result.obj[i][j][k].artNo != null && data.result.obj[i][j][k].artNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">货号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].artNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												} */
												if(data.result.obj[i][j][k].type != 'null' && data.result.obj[i][j][k].type != null && data.result.obj[i][j][k].type != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">号型</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].type+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].internalCode != 'null' && data.result.obj[i][j][k].internalCode != null && data.result.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">内部码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].grade != 'null' && data.result.obj[i][j][k].grade != null && data.result.obj[i][j][k].grade != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">等级</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].productStandard != 'null' && data.result.obj[i][j][k].productStandard != null && data.result.obj[i][j][k].productStandard != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">执行标准</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productStandard+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
												if(data.result.obj[i][j][k].securityCategory != 'null' && data.result.obj[i][j][k].securityCategory != null && data.result.obj[i][j][k].securityCategory != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">安全类别</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].category != 'null' && data.result.obj[i][j][k].category != null && data.result.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.result.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
						
								if(data.result.obj[i][j][k].colour != 'null' && data.result.obj[i][j][k].colour != null && data.result.obj[i][j][k].colour != ''){
						HTML = HTML	+ 	 '				   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">颜色</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].colour+'</td>'
									+	 '		           			</tr>'
									+	 '		         		</table>'	
									+	 '		 			</div>'
								}

												if(data.result.obj[i][j][k].fabricString != 'null' && data.result.obj[i][j][k].fabricString != null && data.result.obj[i][j][k].fabricString != ''){
						HTML = HTML	+	 '	 			  <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">成份</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].fabricString+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}		
												if(data.result.obj[i][j][k].dateOfManufacture != 'null' && data.result.obj[i][j][k].dateOfManufacture != null && data.result.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '	 			  <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">生产日期</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
								}
												if(data.result.obj[i][j][k].inspector != 'null' && data.result.obj[i][j][k].inspector != null && data.result.obj[i][j][k].inspector != ''){
						HTML = HTML	+	 '		        	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">检测员</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].placeOfOrigin != 'null' && data.result.obj[i][j][k].placeOfOrigin != null && data.result.obj[i][j][k].placeOfOrigin != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">产地</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].placeOfOrigin+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].distributor != 'null' && data.result.obj[i][j][k].distributor != null && data.result.obj[i][j][k].distributor != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">经销商</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
												if(data.result.obj[i][j][k].location != 'null' && data.result.obj[i][j][k].location != null && data.result.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">地址</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].locationInfo != 'null' && data.result.obj[i][j][k].locationInfo != null && data.result.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px"></td>'
									+	 '		           				<td><div style="margin-top:-5px">'+data.result.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'				
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		           	</div>'
												if(data.result.obj[i][j][k].phone != 'null' && data.result.obj[i][j][k].phone != null && data.result.obj[i][j][k].phone != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">电话</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].phone+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].postalCode != 'null' && data.result.obj[i][j][k].postalCode != null && data.result.obj[i][j][k].postalCode != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">邮政编码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].washingInstructions != 'null' && data.result.obj[i][j][k].washingInstructions != null && data.result.obj[i][j][k].washingInstructions != ''){
					HTML = HTML		+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">洗涤说明</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].washingInstructions+'</td>'
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
				}else if(${id}==8){//2019合格证小(新)
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									HTML = HTML	+	'<td style="width:310px;height:338.2px;">'
									+	 '		<div style="width:310px;height:338.2px;position:relative;margin-right:10px" id="haha">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-08.png"" style="width:310px;height:338.2px;">'
									+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+data.result.obj[i][j][k].customerName+'</span></div>'
									+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+data.result.obj[i][j][k].smlpc+'</span></div>'
									+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+data.result.obj[i][j][k].orderQty+'</span></div>'
									+	 '	      	<div style="margin:-274px 0px 0px 40px;">'
												if(data.result.obj[i][j][k].productName != 'null' && data.result.obj[i][j][k].productName != null && data.result.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">产品名称</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].itemNo != 'null' && data.result.obj[i][j][k].itemNo != null && data.result.obj[i][j][k].itemNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      	   		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">货品编号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].itemNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].type != 'null' && data.result.obj[i][j][k].type != null && data.result.obj[i][j][k].type != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">号型</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].type+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].internalCode != 'null' && data.result.obj[i][j][k].internalCode != null && data.result.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">内部码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].grade != 'null' && data.result.obj[i][j][k].grade != null && data.result.obj[i][j][k].grade != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">等级</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].productStandard != 'null' && data.result.obj[i][j][k].productStandard != null && data.result.obj[i][j][k].productStandard != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">执行标准</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productStandard+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
						HTML = HTML	+	 '		      	   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		           		<table>'
												if(data.result.obj[i][j][k].securityCategory != 'null' && data.result.obj[i][j][k].securityCategory != null && data.result.obj[i][j][k].securityCategory != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">安全类别</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].category != 'null' && data.result.obj[i][j][k].category != null && data.result.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px"></td>'
									+	 '		           				<td><div style="margin-top:-3px">'+data.result.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
						
								if(data.result.obj[i][j][k].colour != 'null' && data.result.obj[i][j][k].colour != null && data.result.obj[i][j][k].colour != ''){
						HTML = HTML	+ 	 '				   <div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">颜色</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].colour+'</td>'
									+	 '		           			</tr>'
									+	 '		         		</table>'	
									+	 '		 			</div>'
								}
						
								HTML = HTML		+	 '	</div>'
									+	 '		      <div style="margin:-4px 0px 0px 40px;width:600px">'
										for(var l=0;l<data.result.obj[i][j][k].fabricList.length;l++){
									HTML = HTML	+	 '	  <table>'
											for(var m=0;m<data.result.obj[i][j][k].fabricList[l].component.length;m++){
												var name = "";
												if(data.result.obj[i][j][k].fabricList[l].name != 'null' && data.result.obj[i][j][k].fabricList[l].name != null && m == 0){name=data.result.obj[i][j][k].fabricList[l].name }
											HTML = HTML	+	 ' <tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
													+	 '	     	<td class="width_left2" style="width:85px">'+name+'</td>'
													var componentInfo = "";
													for(var n=0;n<data.result.obj[i][j][k].fabricList[l].component[m].length;n++){
														componentInfo = componentInfo + data.result.obj[i][j][k].fabricList[l].component[m][n]+"&nbsp;";
													}
													if(m == 0){
														HTML = HTML	+	 '<td><div style="margin-top:-2px;">'+componentInfo+'</div></td>'
													}else{
														HTML = HTML	+	 '<td><div style="margin-top:-8px;">'+componentInfo+'</div></td>'
													}
													+	 '	    </tr>'
											}
									if(data.result.obj[i][j][k].fabricList[l].remarks != 'null' && data.result.obj[i][j][k].fabricList[l].remarks != null && data.result.obj[i][j][k].fabricList[l].remarks != ''){
						HTML = HTML		+	 ' 		<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '			<td class="width_left2" style="width:85px"></td>'
										+	 '			<td>'
										for(var  m=0;m<data.result.obj[i][j][k].fabricList[l].remarksList.length;m++){
											if(m==0){
									HTML = HTML	+			'<div style="margin-top:-6px;">'+data.result.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
											}else{
									HTML = HTML	+			'<div style="margin-top:-1px;">'+data.result.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
											}
										}
						HTML = HTML		+	 '	    	</td></tr>'
									}
						HTML = HTML		+	 '    </table>'
										}
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:-4px 0px 0px 40px;">'
												if(data.result.obj[i][j][k].dateOfManufacture != 'null' && data.result.obj[i][j][k].dateOfManufacture != null && data.result.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+	 '		        	<div>'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">生产日期</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].inspector != 'null' && data.result.obj[i][j][k].inspector != null && data.result.obj[i][j][k].inspector != ''){
						HTML = HTML	+	 '		        	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">检测员</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].placeOfOrigin != 'null' && data.result.obj[i][j][k].placeOfOrigin != null && data.result.obj[i][j][k].placeOfOrigin != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">产地</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].placeOfOrigin+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].distributor != 'null' && data.result.obj[i][j][k].distributor != null && data.result.obj[i][j][k].distributor != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">经销商</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
												if(data.result.obj[i][j][k].location != 'null' && data.result.obj[i][j][k].location != null && data.result.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">地址</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].locationInfo != 'null' && data.result.obj[i][j][k].locationInfo != null && data.result.obj[i][j][k].locationInfo != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px"></td>'
									+	 '		           				<td><div style="margin-top:-5px">'+data.result.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'				
												}
						HTML = HTML	+	 '		           		</table>'
									+	 '		           	</div>'
												if(data.result.obj[i][j][k].phone != 'null' && data.result.obj[i][j][k].phone != null && data.result.obj[i][j][k].phone != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">电话</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].phone+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].postalCode != 'null' && data.result.obj[i][j][k].postalCode != null && data.result.obj[i][j][k].postalCode != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">邮政编码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].washingInstructions != 'null' && data.result.obj[i][j][k].washingInstructions != null && data.result.obj[i][j][k].washingInstructions != ''){
					HTML = HTML		+	 '		           	<div class="margin_td_top2" style="margin-top:-4px">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="width_left2" style="width:85px">洗涤说明</td>'
									+	 '		           				<td><img alt="" src="${base}/static/images/fileUpload/'+data.result.obj[i][j][k].washingInstructions+'.png" style="width:170px;height:18px;margin-top:4px;"></td>'
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
				}else if(${id}==7){
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									var customerName = "";
									var smlpc = "";
									var orderQty = "";
									if(data.result.obj[i][j][k].customerName != 'null' && data.result.obj[i][j][k].customerName != null){
										customerName = data.result.obj[i][j][k].customerName;
									}
									if(data.result.obj[i][j][k].smlpc != 'null' && data.result.obj[i][j][k].smlpc != null){
										smlpc = data.result.obj[i][j][k].smlpc;
									}
									if(data.result.obj[i][j][k].orderQty != 'null' && data.result.obj[i][j][k].orderQty != null){
										orderQty = data.result.obj[i][j][k].orderQty;
									}
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:20px">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
									+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+customerName+'</span></div>'
									+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+smlpc+'</span></div>'
									+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+orderQty+'</span></div>'
									+	 '	      	<div style="margin:-618px 0px 0px 38px;">'
												if(data.result.obj[i][j][k].productName != 'null' && data.result.obj[i][j][k].productName != null && data.result.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产品名称</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].itemNo != 'null' && data.result.obj[i][j][k].itemNo != null && data.result.obj[i][j][k].itemNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		      	   		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">货品编号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].itemNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].type != 'null' && data.result.obj[i][j][k].type != null && data.result.obj[i][j][k].type != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">号型</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].type+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].internalCode != 'null' && data.result.obj[i][j][k].internalCode != null && data.result.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">内部码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].grade != 'null' && data.result.obj[i][j][k].grade != null && data.result.obj[i][j][k].grade != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">等级</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].productStandard != 'null' && data.result.obj[i][j][k].productStandard != null && data.result.obj[i][j][k].productStandard != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">执行标准</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productStandard+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}

						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
														if(data.result.obj[i][j][k].securityCategory != 'null' && data.result.obj[i][j][k].securityCategory != null && data.result.obj[i][j][k].securityCategory != ''){
						HTML = HTML +	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">安全类别</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
														}
														if(data.result.obj[i][j][k].category != 'null' && data.result.obj[i][j][k].category != null && data.result.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px"></td>'
									+	 '		           				<td><div style="margin-top:0px">'+data.result.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
														}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
									
														if(data.result.obj[i][j][k].colour != 'null' && data.result.obj[i][j][k].colour != null && data.result.obj[i][j][k].colour != ''){
						HTML = HTML	+	 '	 			  <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">颜色</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].colour+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
								}
									
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:0px 0px 0px 38px;width:600px">'
										for(var l=0;l<data.result.obj[i][j][k].fabricList.length;l++){
									HTML = HTML	+	 '	  <table class="margin_td_top">'
											for(var m=0;m<data.result.obj[i][j][k].fabricList[l].component.length;m++){
												var name = "";
												if(data.result.obj[i][j][k].fabricList[l].name != 'null' && data.result.obj[i][j][k].fabricList[l].name != null && m == 0){name=data.result.obj[i][j][k].fabricList[l].name }
											HTML = HTML	+	 ' <tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
													+	 '	     	<td class="margin_td" style="width:72px">'+name+'</td>'
													var componentInfo = "";
													for(var n=0;n<data.result.obj[i][j][k].fabricList[l].component[m].length;n++){
														componentInfo = componentInfo + data.result.obj[i][j][k].fabricList[l].component[m][n] + "&nbsp;";
													}
													HTML = HTML	+	 '<td><div style="margin-top:0px;">'+componentInfo+'</div></td>'
													+	 '	    </tr>'
											}
									if(data.result.obj[i][j][k].fabricList[l].remarks != 'null' && data.result.obj[i][j][k].fabricList[l].remarks != null && data.result.obj[i][j][k].fabricList[l].remarks != ''){
										HTML = HTML		+	 ' 		<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
										+	 '			<td class="margin_td" style="width:72px"></td>'
							HTML = HTML	+	 '			<td>'
												for(var  m=0;m<data.result.obj[i][j][k].fabricList[l].remarksList.length;m++){
													if(m==0){
												HTML = HTML	+			'<div style="margin-top:-1px;">'+data.result.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
													}else{
												HTML = HTML	+			'<div style="margin-top:1px;">'+data.result.obj[i][j][k].fabricList[l].remarksList[m]+'</div>'
													}
												}
							HTML = HTML	+    '			</td></tr>'
									}
									HTML = HTML	+	 '    </table>'
										}
						HTML = HTML	+	 '		      </div>'
									+	 '		      <div style="margin:0px 0px 0px 38px;">'
												if(data.result.obj[i][j][k].dateOfManufacture != 'null' && data.result.obj[i][j][k].dateOfManufacture != null && data.result.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+    '		      		<div>'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">生产日期</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].inspector != 'null' && data.result.obj[i][j][k].inspector != null && data.result.obj[i][j][k].inspector != ''){
						HTML = HTML	+    '		        	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">检测员</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].placeOfOrigin != 'null' && data.result.obj[i][j][k].placeOfOrigin != null && data.result.obj[i][j][k].placeOfOrigin != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产地</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].placeOfOrigin+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].distributor != 'null' && data.result.obj[i][j][k].distributor != null && data.result.obj[i][j][k].distributor != ''){
						HTML = HTML +	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">经销商</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
												if(data.result.obj[i][j][k].location != 'null' && data.result.obj[i][j][k].location != null && data.result.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">地址</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].locationInfo != 'null' && data.result.obj[i][j][k].locationInfo != null && data.result.obj[i][j][k].locationInfo != ''){
						HTML = HTML +	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px"></td>'
									+	 '		           				<td><div style="margin-top:-1px">'+data.result.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'
												}
									+	 '		           		</table>'
									+	 '		           	</div>'
												if(data.result.obj[i][j][k].phone != 'null' && data.result.obj[i][j][k].phone != null && data.result.obj[i][j][k].phone != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">电话</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].phone+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].postalCode != 'null' && data.result.obj[i][j][k].postalCode != null && data.result.obj[i][j][k].postalCode != ''){
						HTML = HTML +	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">邮政编码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
								}
												if(data.result.obj[i][j][k].washingInstructions !='null' && data.result.obj[i][j][k].washingInstructions != null && data.result.obj[i][j][k].washingInstructions != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">洗涤说明</td>'
									+	 '		           				<td><img alt="" src="${base}/static/images/fileUpload/'+data.result.obj[i][j][k].washingInstructions+'.png" style="width:170px;height:18px;margin-top:4px;"></td>'
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
				}else if(${id}==10){//合格证 -成衣（两件套）
					for(var i=0;i<data.result.obj.length;i++){
						HTML = HTML	+'<table style="page-break-before:always">'     	
						for(var j=0;j<data.result.obj[i].length;j++){
							HTML = HTML	 +   '<tr>'
							for(var k=0;k<data.result.obj[i][j].length;k++){
									var customerName = "";
									var smlpc = "";
									var orderQty = "";
									if(data.result.obj[i][j][k].customerName != 'null' && data.result.obj[i][j][k].customerName != null){
										customerName = data.result.obj[i][j][k].customerName;
									}
									if(data.result.obj[i][j][k].smlpc != 'null' && data.result.obj[i][j][k].smlpc != null){
										smlpc = data.result.obj[i][j][k].smlpc;
									}
									if(data.result.obj[i][j][k].orderQty != 'null' && data.result.obj[i][j][k].orderQty != null){
										orderQty = data.result.obj[i][j][k].orderQty;
									}
									HTML = HTML	+	'<td>'
									+	 '		<div style="width:310px;height:703.5px;position:relative;margin-right:20px">'
									+	 '			<img alt="" src="${base}/static/images/fileUpload/initial模板-07.png" style="width:310px;height:703.5px;">'
									+	 '			<div style="position:absolute;left:56px;top:18px;"><span>&nbsp;'+customerName+'</span></div>'
									+	 '			<div style="position:absolute;left:186px;top:18px;"><span>'+smlpc+'</span></div>'
									+	 '			<div style="position:absolute;left:256px;top:18px;"><span>'+orderQty+'</span></div>'
									+	 '	      	<div style="margin:-618px 0px 0px 38px;">'
												if(data.result.obj[i][j][k].productName != 'null' && data.result.obj[i][j][k].productName != null && data.result.obj[i][j][k].productName != ''){
						HTML = HTML	+	 '		      	   <div>'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产品名称</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].productName+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].itemNo != 'null' && data.result.obj[i][j][k].itemNo != null && data.result.obj[i][j][k].itemNo != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		      	   		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">货品编号</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].itemNo+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].type != 'null' && data.result.obj[i][j][k].type != null && data.result.obj[i][j][k].type != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">号型</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].type+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].internalCode != 'null' && data.result.obj[i][j][k].internalCode != null && data.result.obj[i][j][k].internalCode != ''){
						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">内部码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].internalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].grade != 'null' && data.result.obj[i][j][k].grade != null && data.result.obj[i][j][k].grade != ''){
						HTML = HTML +	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">等级</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].grade+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
												if(data.result.obj[i][j][k].productStandardList.length>0){
						HTML = HTML +	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
								for(var l=0;l<data.result.obj[i][j][k].productStandardList.length;l++){
									if(l==0){
										HTML = HTML	+	 '	<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
													+	 '	  <td class="margin_td" style="width:72px">执行标准</td>'
													+	 '	  <td style="letter-spacing: -0.5px;">'+data.result.obj[i][j][k].productStandardList[l]+'</td>'
													+	 '	 </tr>'
									}else{
										HTML = HTML	+	 '	<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
													+	 '	<td class="margin_td" style="width:72px"></td>'
													+	 '	<td style="letter-spacing: -0.5px;">'+data.result.obj[i][j][k].productStandardList[l]+'</td>'
													+	 '	</tr>'
									}
								}

						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
												}

						HTML = HTML	+	 '		      	   <div class="margin_td_top">'
									+	 '		           		<table>'
														if(data.result.obj[i][j][k].securityCategory != 'null' && data.result.obj[i][j][k].securityCategory != null && data.result.obj[i][j][k].securityCategory != ''){
						HTML = HTML +	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">安全类别</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].securityCategory+'</td>'
									+	 '		           			</tr>'
														}
														if(data.result.obj[i][j][k].category != 'null' && data.result.obj[i][j][k].category != null && data.result.obj[i][j][k].category != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px"></td>'
									+	 '		           				<td><div style="margin-top:0px">'+data.result.obj[i][j][k].category+'</div></td>'
									+	 '		           			</tr>'
														}
						HTML = HTML	+	 '		           		</table>'
									+	 '		      	   </div>'
									
												if(data.result.obj[i][j][k].colour != 'null' && data.result.obj[i][j][k].colour != null && data.result.obj[i][j][k].colour != ''){
						HTML = HTML	+	 '	 			  <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">颜色</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].colour+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
								}
												if(data.result.obj[i][j][k].fabricString != 'null' && data.result.obj[i][j][k].fabricString != null && data.result.obj[i][j][k].fabricString != ''){
						HTML = HTML	+	 '	 			  <div class="margin_td_top">'
									+	 '		           		<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">成份</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].fabricString+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		      	   </div>'
												}
													
												if(data.result.obj[i][j][k].dateOfManufacture != 'null' && data.result.obj[i][j][k].dateOfManufacture != null && data.result.obj[i][j][k].dateOfManufacture != ''){
						HTML = HTML	+    '		      		<div>'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">生产日期</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].dateOfManufacture+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'	
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].inspector != 'null' && data.result.obj[i][j][k].inspector != null && data.result.obj[i][j][k].inspector != ''){
						HTML = HTML	+    '		        	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">检测员</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].inspector+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].placeOfOrigin != 'null' && data.result.obj[i][j][k].placeOfOrigin != null && data.result.obj[i][j][k].placeOfOrigin != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">产地</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].placeOfOrigin+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].distributor != 'null' && data.result.obj[i][j][k].distributor != null && data.result.obj[i][j][k].distributor != ''){
						HTML = HTML +	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">经销商</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].distributor+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
												if(data.result.obj[i][j][k].location != 'null' && data.result.obj[i][j][k].location != null && data.result.obj[i][j][k].location != ''){
						HTML = HTML	+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">地址</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].location+'</td>'
									+	 '		           			</tr>'
												}
												if(data.result.obj[i][j][k].locationInfo != 'null' && data.result.obj[i][j][k].locationInfo != null && data.result.obj[i][j][k].locationInfo != ''){
						HTML = HTML +	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px"></td>'
									+	 '		           				<td><div style="margin-top:-1px">'+data.result.obj[i][j][k].locationInfo+'</div></td>'
									+	 '		           			</tr>'
												}
									+	 '		           		</table>'
									+	 '		           	</div>'
												if(data.result.obj[i][j][k].phone != 'null' && data.result.obj[i][j][k].phone != null && data.result.obj[i][j][k].phone != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">电话</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].phone+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
												}
												if(data.result.obj[i][j][k].postalCode != 'null' && data.result.obj[i][j][k].postalCode != null && data.result.obj[i][j][k].postalCode != ''){
						HTML = HTML +	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">邮政编码</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].postalCode+'</td>'
									+	 '		           			</tr>'
									+	 '		           		</table>'
									+	 '		           	</div>'
								}
												if(data.result.obj[i][j][k].washingInstructions !='null' && data.result.obj[i][j][k].washingInstructions != null && data.result.obj[i][j][k].washingInstructions != ''){
						HTML = HTML	+	 '		           	<div class="margin_td_top">'
									+	 '		      			<table>'
									+	 '		           			<tr class="td_top" style="font-size:12px;transform-origin: 0;-webkit-transform: scale(0.95)">'
									+	 '		           				<td class="margin_td" style="width:72px">洗涤说明</td>'
									+	 '		           				<td>'+data.result.obj[i][j][k].washingInstructions+'</td>'
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
					$("#upload_button").text("重新上传");
					$('#upload_button_div').css({'position':'abosolute','top':'40px'})
					var HTML2 = "";
					HTML2 = HTML2  + '<div style="width:400px">文件"<span style=" border-bottom:1px solid red;">'+result.objects.fileName+'</span>"上传完成</div>';
					$("#upload_button1").html(HTML2);
					$("#subBtnDiv").show();
					$("#getPrint").show();
					$("#subBtnDiv").addClass(""+result.objects.fileUrl+"");
					$("#fileName").val(""+result.objects.fileName+"");
					
				} else {
					alert(result.message);
				}
				setTimeout(function() {
					$('#mult-progress').addClass('fadeOut');
				}, 600);
	        },
	        progressall: function (e, data) {
	            var progress = parseInt(data.loaded / data.total * 100, 10);
	            $('#mult-progress [name="percent"]').text(progress + '%');
	            $('#mult-progress .progress-bar').css('width', progress + '%');
	        },
	        fail: function(e, data) {
	        	if (data.result) {
	        		var haha = data.result.obj;
	        		alert(data.result.obj);
	        	} else {
	        		alert("文件上传失败!");
	        	}
	        },
	    
	        
	        processfail: function(e, data) {
	        	$.each(data.files, function (index, file) {
		      		if (file.error) {
		      			alert(file.error);
		      			return false;
		      		}
	      		});
	        }
	    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		
		
	

	
	
});/*--------function  end----------*/
	
	//提交
	$("#subBtn").click(function(){
		$.ajax({
			type:"post",
			url:"${base}/submit-excel-info.html",
			data:{
				fileUrl:$("#subBtnDiv").attr("class"),
				id:${id},
				fileName:$("#fileName").val()
			},
			dataType:"json",
			success:function(data){
				if (data.success) {
					alert("提交成功!");
					window.location="${base}/file-generation.html";
				}else{
					alert("提交失败!");
				}
			}
		})
	})
</script>









