<#setting classic_compatible=true>

<title>填写订单信息</title>
<link rel="stylesheet" href="${base}/static/css/hycon.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header-step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/step.css" type="text/css" media="screen"/>


<link rel="stylesheet" href="${base}/static/css/sidebar.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/jquery.fileupload.min.css">
<link rel="stylesheet" href="${base}/static/css/localcss/bootstrap.min.css">
<link rel="stylesheet" href="${base}/static/css/localcss/font-awesome.min.css">
<link rel="stylesheet" href="${base}/static/css/localcss/ionicons.min.css">
<link rel="stylesheet" href="${base}/static/css/animate.css">

<link rel="stylesheet" href="${base}/static/css/plugins/jquery.steps.css">
<link rel="stylesheet" href="${base}/static/css/plugins/pace.min.css">

<link rel="stylesheet" href="${base}/static/css/chosen.css">
<link rel="stylesheet" href="${base}/static/css/style.css">
<link rel="stylesheet" href="${base}/static/css/skin.css">



<style>
.Eject{ margin:auto; width:540px; min-height:396px; overflow:hidden; border-radius:5px; position:relative;}
.Eject .success{height:30px; width:540px; position:absolute; background:#94ce02; color:#FFFFFF; text-align:center; line-height:30px; font-size:14px; display: none;}
.Eject .fail{height:30px; width:540px; position:absolute; background:#e74c3c; color:#FFFFFF; text-align:center; line-height:30px; font-size:14px; display: none;}
.Eject label{ font-size:14px; color:#a6a6a6; width:88px; text-align:right; display:inline-block;} 
.Eject ul{ margin:30px 40px 0 40px; } 
.Eject ul li{ margin-bottom:15px;}
.Eject input{ width:120px; border:1px solid #dfdfdf; } 
.Eject select{ width:284px; border:1px solid #dfdfdf; height: 30px;} 
.Eject span{ color:#FF0000;margin-left:5px; font-weight:bold;}
.Eject .save{ background:#fafafa; text-align:center; height:50px; padding-top:20px;}
.block {margin:15px; background:#ffffff; border:1px solid #ebebeb; overflow:hidden;}
.modal {width:530px; height:290px; display:none; border:5px solid #656565; -moz-border-radius: 10px; -webkit-border-radius: 10px; border-radius: 10px;-khtml-border-radius: 10px;}
</style>
<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-10px;"  alt=""/></a></div>
   	<div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black">线下支付重新提交订单</div></div>
    <div class="I_step"><img src="${base}/static/images/new/01_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li class="red">确认订单</li>
        <li>支付订单</li>
        <li>待接单</li>
        <li>生产中</li>
        <li>已完成</li>
      </ul>
    </div>
  </div>
</div>

<input type="hidden" name="_token_" value="${_token_}" />
<form id="orderForm" action="${base}/order/add-order.htm" method="POST">
<input type="hidden" id='orderId' name="orderId" value="${order.id}">

<#if shoppingCartForm?exists><input type="hidden" name="shoppingCartForm.itemId" value="${shoppingCartForm.itemId?c}"></#if>
<div class="bjf7 p100">
  <div class="step1">
    <div class="order_info">
      <div class="info_block">
        <div class="info_row">
          <div class="info_title">收货信息</div>
          

            <ul>
              <li>
                <label>收货人：</label>
                <span>${order.linkman}</span> </li>
              <li>
                <label>电话：</label>
                <span>${order.mobileTel}</span> </li>
                <li>
                <label>收货地址：</label>
                <span>${order.province}${order.city}${order.district}${order.address}</span> </li>
            </ul>

          
          
        </div>
        <div class="info_row">
          <div class="info_title info_titleb">支付方式</div>
          <div class="info_content info_contentb">
            <div class="info_btn_group" id='payBtnGroup'>
              <div class="info_btn border_active" value='2'>
                <div class="outer_border">
                  <div class="inner_border">
                    <div>线下支付</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          
          <div id="imageUpload" class="col-md-5" style="margin-left:-30px;margin-top:20px;width:300px;height:250px;"> <a href="javascript:;" class="thumbnail fileinput-button">
	            <input id="logoUpload" type="file" title="请选择上传的Logo文件" />
	            <img id="logo" options="size=200x200&bgcolor=#6b7e8c&color=#ffffff&text=支付凭证&fsize=16" class="placeholder" src="" onerror="this.src=placeholder.getData({text: 'Image 404'})" /> </a> 
	      		
	      </div>
	      <input type="hidden" name="imageUrl" />
	      <input type="hidden" name="imageName" />
          <div id="imageDiv" style="width:1000px;color:red;font-size:16px;margin-top:100px;">		</div>
          
        </div>

        <div class="info_row">
          <div class="info_title info_titleb">配送方式</div>
          <div class="info_content info_contentb">
            <div class="info_btn_group" id="logisticsBtnGroup">
              <div class="info_btn border_active" value='1'>
                <div class="outer_border">
                  <div class="inner_border">
                    <div>快递物流</div>
                  </div>
                </div>
              </div>

              <div class="clear"></div>
            </div>
            <div class="invoice_common hide"  id='logisticsPlace'>
              <div class="info_title_small"> 自提地点： </div>
              <div class="info_content" id='logisticsGroup'>
                <div class="invoice_addr_list">
                <#list netDeliveryList as netDelivery>
                  <div class="invoice_addr_row">
                    <div class="info_btn_group" >
                    <#if netDelivery_index==0>
                      	<div class="info_btn info_btn_small border_active"  value="${netDelivery.id}">
                    <#else>
                    	<div class="info_btn info_btn_small"  value="${netDelivery.id}">
                   </#if>
                        <div name="taxAddrBtn" class="outer_border">
                          <div class="inner_border">
                            <div lang="btn_desc">${netDelivery.name}</div>
                          </div>
                        </div>
                      </div>
                      <div class="clear"></div>
                    </div>
                    <div class="invoice_addr_detail"><span>${netDelivery.area} ${netDelivery.address}</span> <span>${netDelivery.phone}</span> </div>
                  </div>
                  </#list>
                </div>
              </div>
            </div>
          </div>
        </div>
 

      <p class="pline"></p>
      <div class="info_block">
          <div class="info_content">
            <div class="table_content">
              <table  style="width:100%;">
                <tr style="border-bottom:1px dashed #CACACA;height:55px;line-height:55px;">
                  <td style="width:15.2%;"><div>商品名称</div></td>
                  <td style="width:8.1%;"><div>批次号</div></td>
                  <td style="width:12.7%;"><div>商品编号</div></td>
                  <td style="width:6%;"><div>颜色</div></td>
                  <td style="width:8.9%;"><div>号型</div></td>
                  <td style="width:6%;"><div>size</div></td>
                  <td style="width:6%;"><div>币种</div></td>
                  <td style="width:7.8%;"><div>数量</div></td>
                  <td style="width:9.9%;"><div>单价(单位:元)</div></td>
                  <td style="width:12.4%;"><div>总价(单位:元)</div></td>
                  <td style="width:7%;"><div>操作</div></td>
                </tr>
                              <#list infoList as infoLL>
                	<#list infoLL.infoList as info>
                		<#if info_index == 0>
	                		<tr class="t_content" style="height:35px;line-height:35px;text-align:center;border-bottom:1px solid #CACACA">
				                  <td rowspan="${infoLL.infoList?size}" style="display:table-cell; vertical-align:middle"><div style="width:80%;margin:auto">${info.commodityName}</div></td>
				                  <td rowspan="${infoLL.infoList?size}" style="display:table-cell; vertical-align:middle">${info.batch}</td>
				                  <td>${info.commodityCode}</td>
				                  <td>${info.color}</td>
				                  <td>${info.spec}</td>
				                  <td>${info.size}</td>
				                  <td>${info.currency}</td>
				                  <td>${info.number}</td>
				                  <td>${info.rePrice}</td>
				                  <td>${info.totalPrice}</td>
				                  <td rowspan="${infoLL.infoList?size}" style="display:table-cell; vertical-align:middle">
				                  		<#if userProfile.position == 'OEM'><#if order.payStatus==0><#if info.type==1 || info.type==2 || info.type==4 || info.type==5><div style="color:red;text-decoration:underline;cursor:pointer;" onclick="addImage(${info.itemId})">重新上传↑</div></#if></#if></#if>
				                  		<input id="multupload_${info.itemId}" lang="${info.type}"  type="file" name="file"  style="display:none">
				                  		<#if info.type==1 || info.type==2 || info.type==4 || info.type==5><div><a style="color:red;text-decoration:underline" href="${base}/down-load-file-excel.html?FileUrl=${info.fileUrl}&itemId=${info.itemId}">文件下载↓</a></div></#if>
				                  </td>
				             </tr>
                		</#if>
                		<#if info_index != 0>
	                		<tr class="t_content" style="height:35px;line-height:35px;text-align:center;border-bottom:1px solid #CACACA">
				                  <td>${info.commodityCode}</td>
				                  <td>${info.color}</td>
				                  <td>${info.spec}</td>
				                  <td>${info.size}</td>
				                  <td>${info.currency}</td>
				                  <td>${info.number}</td>
				                  <td>${info.rePrice}</td>
				                  <td>${info.totalPrice}</td>
				             </tr>
                		</#if>
                	</#list>
                	
                </#list>
	            
              </table>
            </div>
            <div class="step2-txt">
              <textarea id='remark' placeholder="如有其他问题请填写备注（非必填）">${order.remark}</textarea>
            </div>
        </div>
      </div>
      <p class="pline"></p>
      <div class="info_block">
        <div class="info_content pt20 pb20">
          <div class="c_statistics">
            <div>
              <div class="c_statistics_row">
                <div class="c_statistics_label">商品金额：</div>
                <div class="c_statistics_desc"><span>${order.totalPrice}</span>元</div>
              </div>
              <!-- <div class="c_statistics_row">
                <div class="c_statistics_label">配送费用：</div>
                <div class="c_statistics_desc"><span class="cb">( 满99包邮 )</span></div>
              </div> -->
              <div class="c_statistics_row">
                <div class="c_statistics_label">应付金额：</div>
                <div class="c_statistics_desc"><span class="f24" id="payAmountSpan">${order.payAmount}</span>元</div>
              </div>
            </div>
          </div>
          <div class="info_btn_group pt20 fr">
            <div class="info_btn common_btn">
              <div id="balance">提交订单</div>
            </div>
            <div class="clear">&nbsp;</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</form>


<script src="${base}/static/js/localjs/jquery-2.2.2.min.js"></script>
<script src="${base}/static/js/distpicker.min.js" type="text/javascript"></script>
<script src="${base}/static/js/jquery.blockUI.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/static/js/moaModal.js" charset="utf-8"></script> 
<script type="text/javascript" src="${base}/static/js/jquery/jquery.easing.1.3.js" charset="utf-8"></script>

<script src="${base}/static/js/fileupload/vendor/jquery.ui.widget.js"></script>
<script src="${base}/static/js/fileupload/jquery.iframe-transport.js"></script>

<script src="${base}/static/js/localjs/bootstrap.min.js"></script>
<script src="${base}/static/js/plugins/pace.min.js"></script>
<script src="${base}/static/js/plugins/metisMenu.min.js"></script>
<script src="${base}/static/js/app.js"></script>

<script src="${base}/static/js/plugins/jquery.steps.min.js"></script>
<script src="${base}/static/js/localjs/bootstrapValidator.js"></script>
<script src="${base}/static/js/inputmask/inputmask/inputmask.min.js"></script>
<script src="${base}/static/js/inputmask/inputmask/jquery.inputmask.bundle.min.js"></script>
<script src="${base}/static/js/inputmask/inputmask/inputmask.phone.extensions.min.js"></script>
<script src="${base}/static/js/inputmask/inputmask/inputmask.extensions.min.js"></script>
<script src="${base}/static/js/localjs/placeholder.min.js"></script>
<script src="${base}/static/js/localjs/bootstrap.min.js"></script>
<script src="${base}/static/js/plugins/metisMenu.min.js"></script>
<script src="${base}/static/js/localjs/chosen.jquery.min.js"></script>
<script src="${base}/static/js/fileupload/vendor/jquery.ui.widget.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-process.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-validate.js"></script>





<script type="text/javascript">


$('#logoUpload').fileupload({
    url: "${base}/image/upload-image",
    paramName: 'file',
    dataType: 'json',
    singleFileUploads: true,
    acceptFileTypes: /\.(jpg|png|jpeg|gif)$/i,
    formData: {param: Math.random() * 1000},
    send : function(e, data) {
    	$('#progress-logo').removeClass('fadeOut').addClass('fadeIn');
    },
    done: function (e, data) {
       var result = data.result;
		if (result.success) {
			$('#logo').prop('src', result.obj.thumb);
			$('#logo').css("width","170px");
			$('#logo').css("height","170px");
			$('[name="imageUrl"]').val( result.obj.thumb );
			$('[name="imageName"]').val( result.obj.imgName );
			var HTMLS = "";
				HTMLS = HTMLS + "文件<span style='text-decoration:underline;'>\""+result.obj.imgName+"\"</span>上传成功";
			$("#imageDiv").html(HTMLS);
		} else {
			alert(result.message);
		}
		setTimeout(function() {
			$('#progress-logo').addClass('fadeOut');
		}, 600);
    },
    progressall: function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10);
        $('#percent').text(progress + '%');
        $('#progress-logo .progress-bar').css(
            'width',
            progress + '%'
        );
    },
    fail: function(e, data) {
    	$('#save').prop('disabled', false);
    	alert("File upload failed.");
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





	  	<#-- 支付方式-->
		$('#payBtnGroup .info_btn*').click(function(){
			$('#payBtnGroup .info_btn*').attr('class','info_btn');
			$(this).attr('class','info_btn border_active');
			$('#order_payMode').attr('value',$(this).attr('value'));
			if($('#order_payMode').val()==2){
				$("#imageUpload").show();
			}else{
				$("#imageUpload").hide();
			}
	  	});



	  	<#-- 备注-->
	  	$('#remark').click(function(){
	  		if($(this).html()=='如有其他问题请填写备注（非必填）'){
	  			$(this).html('');
	  		}
	  	});

		
	  	
	  	/** 提交订单 **/
		$("#balance").click(function() {

	  		if($('#remark').html()!='如有其他问题请填写备注（非必填）'){
	  			$('#order_remark').attr('value',$('#remark').val());
	  		}
	  		
	  		
  			var pingzheng = $('[name="imageUrl"]').val();
  			var imageName = $('[name="imageName"]').val();
  			if(pingzheng==null || pingzheng == ""){
  				alert("线下支付提交订单时请上传支付凭证");
  				return;
  			}

  			$.ajax({
  				type:"post",
                url:"${base}/order/offline-order-update.htm",
                data:{
                    orderId:$("#orderId").val(),
                    imageUrl:pingzheng,
                    remrks:$('#remark').val(),
                    imageName:imageName
              },
              dataType:"json",
              success:function(data){
                  if (data.success) {
                        alert("提交成功");
                        window.location="${base}/order/ongoing-order.html";
                  }
               },error:function(data){
            	   alert("提交失败");
               }
  			})


		 	
		});
	
		
	


	
	</script>