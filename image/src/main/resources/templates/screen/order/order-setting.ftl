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
   	<div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black">确认订单</div></div>
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
<#list cartList as cartList>
      	<input type="hidden" id='itemId' name="itemId" value="${cartList.id}">
</#list>
<input type="hidden" id='deliveryId' name="deliveryId">
<input type="hidden" id='order_payMode' name="payMode" value=3>
<input type="hidden" id='order_invoiceType' name="nvoiceType" value=0>
<input type="hidden" id='order_isNeedInvoice' name="isNeedInvoice" value=0>
<input type="hidden" id='order_isUseCoupon' name="isUseCoupon" value=0>
<input type="hidden" id='order_logisticsType' name="logistics" value=1>
<input type="hidden" id='order_pickUpId' name="pickUpId" value=0>
<input type="hidden" id='order_remark' name="remark" value=''>
<#if shoppingCartForm?exists><input type="hidden" name="shoppingCartForm.itemId" value="${shoppingCartForm.itemId?c}"></#if>
<div class="bjf7 p100">
  <div class="step1">
    <div class="order_info">
      <div class="info_block">
        <div class="info_row">
          <div class="info_title">收货信息</div>
          <div class="info_content">
            <div class="addr_list">
            <div id='addrList'>
              <#list deliveryList as delivery>
              <div class="addr_block<#if delivery.isDefault == 1> border_active</#if>" <#if (delivery_index gt 3)> style="display:none;" </#if> <#if delivery.isDefault == 1>id="defaultId" is_default="1"
				<#else>is_default="0"</#if> name='deliveryList' value='${delivery.id?c}'>
                <div class="outer_border">
                  <div class="inner_border">
                    <div>
                      <div class="addr_header">
                        <div><#if delivery.linkman?string?length &gt; 20>${delivery.linkman[0..20]}...<#else>${delivery.linkman}</#if></div>
                        <div>${delivery.mobileTel}</div>
                        <div class="_default _default_desc">默认</div>
                        <div onClick="javascript: setDefault('${delivery.id?c}',$(this))" class="_default _default_opt" name="${delivery.id?c}">设为默认</div>
                      </div>
                      <div class="addr_middle">
                        <div><span name="province">${delivery.province}</span> <span name="city">${delivery.city}</span> <span name="city">${delivery.district}</span></div>
                        <div><#if delivery.address?string?length &gt; 40>${delivery.address[0..40]}...<#else>${delivery.address}</#if></div>
                      </div>
                      <div class="addr_footer">
                        
                        <div class="addr_opt" name="delivery_addr_del">
                          <div name='delDelivery' value='${delivery.id?c}'>删除</div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              </#list>
			 </div>
              <div class="addr_block<#if deliveryList?size gt 50> hide</#if>" id="new-delivery">
                <div class="outer_border">
                  <div class="inner_border">
                    <div>
                      <div class="addr_opt_add">
                        <div class="addr_opt_add_icon"></div>
                        <div>新增地址</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="clear"></div>
            </div>
            <div class="addr_bottom_opt_bar">
              <div id="showAllAddr" class="opt_with_underline">显示全部地址</div>
            </div>
          </div>
        </div>
        <div class="info_row">
          <div class="info_title info_titleb">支付方式</div>
          <div class="info_content info_contentb">
            <div class="info_btn_group" id='payBtnGroup'>
              <div class="info_btn border_active" value='3'>
                <div class="outer_border">
                  <div class="inner_border">
                    <div>网银支付</div>
                  </div>
                </div>
              </div> 
              <div class="info_btn " value='2'>
                <div class="outer_border">
                  <div class="inner_border">
                    <div>线下支付</div>
                  </div>
                </div>
              </div>
              <div class="info_btn" value='1'>
                <div class="outer_border">
                  <div class="inner_border">
                    <div>支付宝</div>
                  </div>
                </div>
              </div>
              <!-- <div class="info_btn" value='6'>
                <div class="outer_border">
                  <div class="inner_border">
                    <div>余额支付</div>
                  </div>
                </div>
              </div>-->

            </div>
          </div>
          
          
          <div id="imageUpload" class="col-md-5" style="margin-left:-30px;margin-top:20px;width:300px;height:250px;display:none;"> <a href="javascript:;" class="thumbnail fileinput-button">
	            <input id="logoUpload" type="file" title="请选择上传的Logo文件" />
	            <img id="logo" options="size=200x200&bgcolor=#6b7e8c&color=#ffffff&text=支付凭证&fsize=16" class="placeholder" src="" onerror="this.src=placeholder.getData({text: 'Image 404'})" /> </a> 
	      		
	      </div>
	      <input type="hidden" name="imageUrl" />
	      <input type="hidden" name="imageName" />
          <div id="imageDiv" style="width:1000px;color:red;font-size:16px;margin-top:100px;">		</div>
          
        </div>
         <#--
        <div class="info_row">
          <div class="info_title info_titleb">设计网点信息</div>
          <div class="info_content info_contentb">
          	
          </div>
        </div>
            -->
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
              <#--<div class="info_btn" id='logisticsBtn' value='2'>
                <div class="outer_border">
                  <div class="inner_border">
                    <div>网点自提</div>
                  </div>
                </div>
              </div>-->
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
       <#--  <div class="info_row">
          <div class="info_title info_titleb">发票信息</div>
          <div class="info_content info_contentb">
            <div class="info_btn_group" id="invoiceBtnGroup">
              <div class="info_btn border_active" id="no_invoice">
                <div class="outer_border">
                  <div class="inner_border">
                    <div>不开发票</div>
                  </div>
                </div>
              </div>
              <div class="info_btn" id="invoiceBtn">
                <div class="outer_border">
                  <div class="inner_border">
                    <div>普通发票</div>
                  </div>
                </div>
              </div>
              <div class="clear"></div>
            </div>
           <div class="invoice_common hide"  lang="common_invoice" id="invoiceDiv">
              <div class="info_title_small">发票抬头：</div>
              <div class="info_content">
                <div class="info_btn_group" id="common_invoice_type_group">
                  <div class="info_btn info_btn_small border_active" >
                    <div class="outer_border">
                      <div class="inner_border">
                        <div>个人</div>
                      </div>
                    </div>
                  </div>
                  <div class="info_btn info_btn_small" id="unit" >
                    <div class="outer_border">
                      <div class="inner_border">
                        <div>单位</div>
                      </div>
                    </div>
                  </div>
                  <div class="clear"></div>
                </div>
                <div class="invoice_common_addi hide" id='unitName'>
                  <div>单位名称：</div>
                  <div>
                    <input type="text" id='invoiceTitle' name='order.invoiceTitle'/>
                  </div>
                </div>
              </div>
              <p class="remarks"><span>*</span> 我们将在您确认订单后的两个工作日内，为您寄出发票 (如需开增值税发票，请联系客服)</p>
            </div>
          </div>
        </div>
       <div class="info_row">
          <div class="info_title info_titleb">优惠券</div>
          <div class="info_content info_contentb">
            <div class="info_btn_group" id="couponBtnGroup">
              <div class="info_btn border_active" id="no_coupon">
                <div class="outer_border">
                  <div class="inner_border">
                    <div>不使用</div>
                  </div>
                </div>
              </div>
              <div class="info_btn" id="couponBtn">
                <div class="outer_border">
                  <div class="inner_border">
                    <div>使用优惠券</div>
                  </div>
                </div>
              </div>
              <div class="clear"></div>
            </div>
            <div class="invoice_common hide"  id="couponDiv">
              <div class="info_content">
                <div class="invoice_common_addi">
                  <div>优惠券码：</div>
                  <div>
                    <input type="text" id='couponPwd' name='order.couponPwd'/>
                  </div>
                </div>
              </div>
              <p class="remarks" id="couponError"></p>
            </div>
          </div>
        </div>
      </div>-->	
      <div class="invoice_common hide"  lang="common_invoice" id="invoiceDiv">
      		<div id="invoiceDiv_info">
              <div class="info_title_small">
              	公司抬头：<input name="company" type="text">
              	&nbsp;&nbsp;纳税人识别号: <input name="taxId" type="text">
              	&nbsp;&nbsp;开票金额 : <input name="InvoicedAmount" type="text">
              	<span id="span_add"><img src="${base}/static/images/new/add.png" id="img_add" style="float:right;margin-top: 24px;" ></span>
              	</div>
              	
              	<div class="info_title_small">
              	收票人地址：<input name="address" type="text">
              	&nbsp;&nbsp;收票人姓名: <input name="realName" type="text">
              	&nbsp;&nbsp;收票人电话 : <input name="mobilePhone" type="text">
              	</div>
              	</div>
            </div>
      <p class="pline"></p>
      <div class="info_block">
          <div class="info_content">
            <div class="table_content">
              <table  style="width:100%;">
                <tr style="border-bottom:1px dashed #CACACA;height:55px;line-height:55px;">
                  <td style="width:16.2%;"><div>商品名称</div></td>
                  <td style="width:9.1%;"><div>批次号</div></td>
                  <td style="width:13.7%;"><div>商品编号</div></td>
                  <td style="width:7%;"><div>颜色</div></td>
                  <td style="width:9.9%;"><div>号型</div></td>
                  <td style="width:7%;"><div>size</div></td>
                  <td style="width:7%;"><div>币种</div></td>
                  <td style="width:7.8%;"><div>数量</div></td>
                  <td style="width:9.9%;"><div>单价(单位:元)</div></td>
                  <td style="width:12.4%;"><div>总价(单位:元)</div></td>
                </tr>
                <#list infoListList as infoLL>
                	<#list infoLL.infoList as info>
                		<#if info_index == 0>
	                		<tr class="t_content">
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
				             </tr>
                		</#if>
                		<#if info_index != 0>
	                		<tr class="t_content">
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
              <textarea id='remark' placeholder="如有其他问题请填写备注（非必填）"></textarea>
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
                <div class="c_statistics_desc"><span>${totalPrice}</span>元</div>
              </div>
              <!-- <div class="c_statistics_row">
                <div class="c_statistics_label">配送费用：</div>
                <div class="c_statistics_desc"><span class="cb">( 满99包邮 )</span></div>
              </div> -->
              <div class="c_statistics_row">
                <div class="c_statistics_label">应付金额：</div>
                <div class="c_statistics_desc"><span class="f24" id="payAmountSpan">${totalPrice}</span>元</div>
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
<div id="deliveryBox" name="emptyText"  style="display: none;">
  <div class="mb10 f16 b">添加新收货地址</div>
  <input type="hidden" name="delivery.id" value="" />
  <ul id="add_content" class="box-add1-ul1">
    <li >
	  <span class="name p3">收货人：</span>
	  <span class="con">  
		  <input type="hidden" id="deliveryIdBox" value=""/>
	 	  <input type="text" id="linkman"  style="width: 200px;" maxLength="20"/>
	  	  <label name="linkman" class="l cb50 ml5 p3" style="display:none;"></label>
	  </span>
    </li>
    <li >
	  <span class="name p3">收货地址：</span>
  	  <span class="con">
  	  <div  data-toggle="distpicker"   data-autoselect="3" >
	  	<select id="province" data-province="---- 选择省 ----"  style="height: 25px;">
	  	  
		</select>
	  	<select id="city" data-city="---- 选择市 ----"  style="height: 25px;margin-left:5px;">
	   	 
		</select>
		<select id="district" data-district="---- 选择区 ----" style="height: 25px;width:100px;">
	   	  
		</select>
	</div>	
		<input type="text" id="address"  class="mt10" style="width:400px;" maxlength="40"/>
  	  </span>
    </li>
    <li >
 	  <span class="name p3">手机号码：</span>
  	 <span class="con">
	  	  <input type="text" id="mobileTel"  style="width: 200px;"/>
	  	  <label name="mob" class="cb50 ml5 p3"></label>
  	  </span>
    </li>
    <li >
 	  <span class="name p3">固定电话：</span>
	  <span class="con">
		  <input type="text" id="telephone"  style="width: 200px;"/>
	  	  <label name="tel" class="cb50 ml5 p3"></label>
  	  </span>
    </li>
    <li >
  	  <span class="name">&nbsp;</span>
  	  <span class="con">
	  	  <input type="button" name="save" class="btn990" style="padding: 5px 12px 4px; margin-left: 50px" value="保 存" />
	  	  <input type="button" name="cancel" class="btn990 ml10" style="padding: 5px 12px;" value="取 消" />
  	  </span>
    </li>
  </ul>
</div>
<div id="modalDelivery" class="block modal" style=" height:505px;display:none;">
  <form id="deliveryForm">
    <div class="Eject">
      <div id="responseMessageDelivery" style="width:540px;"></div>
      <input type="hidden" name="deliveryInfo.id"/>
      <ul class="E_mr">
        <li>
          <label class="E_wh">收货人：</label>
          <input type="text" class="required" name="deliveryInfo.contacter" style="width:170px;" maxlength="18">
          <span>*</span> </li>
        <li>
          <label class="E_wh">手机号码：</label>
          <input type="text" name="deliveryInfo.mobile" class="required pattern" alt="/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/" style="width:170px;" maxlength="18">
          <span>*</span> </li>
        <li>
          <label class="E_wh">地址：</label>
          <select id="deliveryProvince" name="" class="sl required" style="width:115px;">
            <option value="100005" selected="selected">安徽</option>
            <option value="100001">北京</option>
            <option value="100004">重庆</option>
            <option value="100006">福建</option>
            <option value="100007">广东</option>
            <option value="100008">甘肃</option>
            <option value="100009">广西</option>
            <option value="100010">贵州</option>
            <option value="100011">湖北</option>
            <option value="100012">河北</option>
            <option value="100013">黑龙江</option>
            <option value="100016">河南</option>
            <option value="100014">湖南</option>
            <option value="100015">海南</option>
            <option value="100017">吉林</option>
            <option value="100018">江苏</option>
            <option value="100019">江西</option>
            <option value="100021">内蒙古</option>
            <option value="100022">宁夏</option>
            <option value="100023">青海</option>
            <option value="100024">四川</option>
            <option value="100025">山东</option>
            <option value="100002">上海</option>
            <option value="100026">陕西</option>
            <option value="100027">山西</option>
            <option value="100003">天津</option>
            <option value="100034">台湾</option>
            <option value="100032">香港</option>
            <option value="100028">新疆</option>
            <option value="100029">西藏</option>
            <option value="100030">云南</option>
            <option value="100031">浙江</option>
          </select>
          <select id="deliveryCity" name="" style="width:115px;" class="required">
            <option value="">请选择</option>
            <option value="1">A</option>
            <option value="2">B</option>
          </select>
          <select id="deliveryDistrict" name="" style="width:115px;" class="required">
            <option value="">请选择</option>
            <option value="1">AA</option>
            <option value="2">BB</option>
          </select>
          <span>*</span>
          <input type="hidden" name="deliveryInfo.area" />
        </li>
        <li>
          <label class="E_wh" style="vertical-align: top;"></label>
          <input type="text" name="deliveryInfo.address" placeholder="详细地址" class="required" style="width:340px;" maxlength="64">
          <span>*</span> </li>
      </ul>
      <div class="save"> <a id="saveDelivery" href="javascript:void(0);"><img src="${base}/static/images/new/infosave.png" border="0"/></a> </div>
    </div>
  </form>
</div>
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
			$('#logo').prop('src', result.obj.logo);//回显路径
			$('#logo').css("width","170px");
			$('#logo').css("height","170px");
			$('[name="imageUrl"]').val( result.obj.thumb );//需要保存提交的图片路径
			$('[name="imageName"]').val( result.obj.imgName );//需要保存提交的图片名称
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



	$(function() {		
		<#-- 地址选择-->
		$('#showAllAddr').click(function(){
			$(".addr_block*").attr('style','display:block;');
			$(this).attr('style','display:none;');
		});
		$('#deliveryId').attr('value',$('#defaultId').attr('value'));
		$("[name='deliveryList']").click(function(){
			$("[name='deliveryList']").attr('class','addr_block');
			$(this).attr('class','addr_block border_active');
			$('#deliveryId').attr('value',$(this).attr('value'));
	  	});
	  	$("[name='delDelivery']").click(function(){
	  		$.ajax({
                cache: true,
                type: "POST",
                url: '${base}/logistic-ajax/ajax-invalid-address.html?addressId='+$(this).attr('value'),
                async: false,
                error: function() {
                    alert("系统异常");
                },
                success: function(data) {
                   window.location.reload();
                }
            });
	  	});
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
		<#-- 配送方式-->
		$('#logisticsBtnGroup .info_btn*').click(function(){
			$('#logisticsBtnGroup .info_btn*').attr('class','info_btn');
			$(this).attr('class','info_btn border_active');
			if($(this).attr('id')=='logisticsBtn'){
				$('#logisticsPlace').attr('class','invoice_common');
			}else{
				$('#logisticsPlace').attr('class','invoice_common hide');
			}
			$('#order_logisticsType').attr('value',$(this).attr('value'));
	  	});
	  	<#-- 自提点选择-->
	  	$('#logisticsGroup .info_btn*').click(function(){
			$('#logisticsGroup .info_btn*').attr('class','info_btn info_btn_small');
			$(this).attr('class','info_btn info_btn_small border_active');
			$('#order_pickUpId').attr('value',$(this).attr('value'));
	  	});
		<#-- 发票-->
		$('#invoiceBtnGroup .info_btn*').click(function(){
			$('#invoiceBtnGroup .info_btn*').attr('class','info_btn');
			$(this).attr('class','info_btn border_active');
			if($(this).attr('id')=='invoiceBtn'){
				$('#invoiceDiv').attr('class','invoice_common');
				$('#order_isNeedInvoice').attr('value',1);
			}else{
				$('#invoiceDiv').attr('class','invoice_common hide');
				$('#order_isNeedInvoice').attr('value',0);
			}
	  	});
	  	<#-- 发票抬头选择-->
	  	$('#common_invoice_type_group .info_btn*').click(function(){
			$('#common_invoice_type_group .info_btn*').attr('class','info_btn info_btn_small');
			$(this).attr('class','info_btn info_btn_small border_active');
			if($(this).attr('id')=='unit'){
				$('#unitName').attr('class','invoice_common_addi');
				$('#order_invoiceType').attr('value',1);
			}else{
				$('#unitName').attr('class','invoice_common_addi hide');
				$('#order_invoiceType').attr('value',0);
			}
	  	});
	  	<#-- 备注-->
	  	$('#remark').click(function(){
	  		if($(this).html()=='如有其他问题请填写备注（非必填）'){
	  			$(this).html('');
	  		}
	  	});
	  	<#-- 优惠券-->
	  	$('#couponBtnGroup .info_btn*').click(function(){
			$('#couponBtnGroup .info_btn*').attr('class','info_btn');
			$(this).attr('class','info_btn border_active');
			if($(this).attr('id')=='couponBtn'){
				$('#couponDiv').attr('class','invoice_common');
				$('#order_isUseCoupon').attr('value',1);
			}else{
				$('#couponDiv').attr('class','invoice_common hide');
				$('#order_isUseCoupon').attr('value',0);
			}
	  	});
	  	var couponval=false;
	  	$("#couponPwd").change(function() {
	  		<#--$('#payAmountSpan').html(${order.payAmount}.toFixed(2));-->
			$.post("${base}/order/checkCoupon.htm", {pwd : $("#couponPwd").val(), totalCount : '${order.payAmount}'}, function(data) {
			 	data = $.parseJSON(data);
				if (data.success) {
					couponval=true;
					$("#couponError").html(data.msg);
					var couponpay=(${order.payAmount}-data.coupon).toFixed(2);
					if(couponpay<0){
						couponpay="0.00"
					}
				    $('#payAmountSpan').html(couponpay);
				} else {
					couponval=false;
					$("#couponError").html(data.msg);
				}
			}, "text");	
		});
		
	  	
	  	/** 提交订单 **/
		$("#balance").click(function() {
			if($('#deliveryId').attr('value')==''){
				alert('请选择收货地址');
				return;
			}
	  		if($('#remark').html()!='如有其他问题请填写备注（非必填）'){
	  			$('#order_remark').attr('value',$('#remark').val());
	  		}
	  		if($('#order_payMode').val()==2){//如果支付方式是线下支付
	  			var pingzheng = $('[name="imageUrl"]').val();
	  			if(pingzheng==null || pingzheng == ""){
	  				alert("线下支付提交订单时请上传支付凭证");
	  				return;
	  			}
	  			
	  		}
		 	$("#orderForm").submit(); 
		 	
		});
	
		
		if ($("input[name='order.isNeedInvoice']:checked").val() == '1') {
			if ($("input[name='order.invoiceTitle']").val() == '') {
				alert("请填写正确的发票抬头");
				$("input[name='order.invoiceTitle']").focus();
				return false;
			}else{
			var _list={};
			$("input[name='company']").each(function(i,item){
				_list[i]={'company':item.val(),'taxId':$("input[name='taxId']").eq(i).val(),'InvoicedAmount':$("input[name='InvoicedAmount']").eq(i).val(),'address':$("input[name='address']").eq(i).val(),'realName':$("input[name='realName']").eq(i).val(),'mobilePhone':$("input[name='mobilePhone']").eq(i).val()};
			})	
				
			}
		}
		
		var remark = $("#remark").text();
		$("input[name='order.remark']").val(remark.replace('请输入备注信息', ''));
		
		$("#submitForm").empty();
		<!-- 送货地址业务事件 -->
				<#-- 
		$('#addDeliveryOp').click(function() {
			window.open("${base}/logistic/my-logistic.htm","_blank");
		});
		$('#addDeliveryOp').modal({
			target : '#modalDelivery',
			speed : 750,
			easing : 'easeInOutExpo',
			animation : 'top',
			position: '100px auto',
			overlayClose : true,
			on : 'click'
		});
		
		$('#addDeliveryOp').click(function() {
			clearDeliveryForm();
		});
		
		$("#saveDelivery").click(function( event ) {
		});
		-->
		$('#new-delivery').click(function() {
			$('input[name="delivery.id"]').val( '' );
			$("div[name='emptyText']:text").val('');
			deliverBox();
		});
		$("#province").change(function(e, city, district) {
			var provId = $(this).find('option:selected').attr( 'id' );
			//cascadeCity(provId, city, district);
			$("label[name='address']").text( '' );
		});
	
		<#--$("#city").change(function() {
			$("label[name='address']").text( '' );
			var cityId = $(this).find('option:selected').attr( 'id' );
			cascadeDistrict(cityId);
			
			var price = parseFloat($("#order_price").text());
			if (price < 100) {
				var carr = $(this).find("option:selected").attr('title');
		    	if (carr == '' || carr == undefined) {
		    		carr = '0';
		    	}
		    	$("#carriage").text(parseFloat(carr).toFixed(2));
				$("#total").text((price + parseFloat(carr)).toFixed(2));
			} 
		});-->
		$('input[name="cancel"]').click($.unblockUI);
		
		$('input[name="save"]').click(function() {
			var id = $("#deliveryIdBox").val();
			var linkman = $.trim($("#linkman").val());
			var province = $("#province").val();
			var city = $("#city").val();
			var district = $("#district").val();
			var address = $.trim($("#address").val());
			var telephone = $.trim($("#telephone").val());
			var mobileTel = $.trim($("#mobileTel").val());
			if (linkman == '') {
				$("label[name='linkman']").text( '联系人不能为空' );
				return false;
			}
			if (province == '' || city == ''||district=='' || address == '') {
				$("label[name='address']").text( '请选填正确的收货地址' );
				return false;
			}
			if (telephone == '' && mobileTel == '') {
				$("label[name='tel']").text( '手机或电话号码必须有一个不能为空' );
				return false;
			}
			var tel = /^\d{3,4}-\d{7,8}(-\d{3,4})?$/; 
			var mob = /^0?(13[0-9]|15[0-9]|18[0-9]|14[0-9]|17[0-9])[0-9]{8}$/;
			if (telephone != '') {
				if (!tel.test(telephone)) {
					$("label[name='tel']").text("请输入正确的电话号码(如:021-32612387)");
					return false;
				}
			}
			if (mobileTel != '') {
				if (!mob.test(mobileTel)) {
					$("label[name='mob']").text("请输入正确的手机号码");
					return false;
				}
			}
			if (id == "") {
				var url = "${base}/logistic-ajax/ajax-save-address.html";
				var params = {
					"linkman" : linkman,
					"province" : province,
					"city" : city,
					"district" : district,
					"address" : address,
					"telephone" : telephone,
					"mobileTel" : mobileTel
				};
				$.post(url, params, function(data) {
					data = $.parseJSON(data); 
					if (!data.success) {
						alert('系统异常');
						return false;
					} 
					//默认选择新增地址
					$("[name='deliveryList']").attr('class','addr_block');
					$('#deliveryId').attr('value',data.obj);
					//添加新增地址页面框
					var addhtml="<div class='addr_block border_active' is_default='0' name='deliveryList' value='"+data.obj+"'>"
	                +"<div class='outer_border'><div class='inner_border'><div><div class='addr_header'><div>"+linkman+"</div><div>"+mobileTel+"</div><div class='_default _default_desc'>默认</div>"
	                +"<div onClick='javascript: setDefault(\""+data.obj+"\",$(this))' class='_default _default_opt' name='"+data.obj+"'>设为默认</div></div><div class='addr_middle'>"
	                +"<div><span name='province'>"+province+"</span> <span name='city'>"+city+"</span> <span name='district'>"+district+"</span></div><div>"+address+"</div></div><div class='addr_footer'><div class='addr_opt' name='delivery_addr_edit'>"
	                +"<div >编辑</div></div><div class='addr_opt' name='delivery_addr_del'><div name='delDelivery' value='"+data.obj+"'>删除</div></div></div></div></div></div></div>";
	               	$('#addrList').html($('#addrList').html()+addhtml);
	               	//添加事件
	               	$("[name='deliveryList']").click(function(){
						$("[name='deliveryList']").attr('class','addr_block');
						$(this).attr('class','addr_block border_active');
						$('#deliveryId').attr('value',$(this).attr('value'));
				  	});
	               	$('input[name="cancel"]').click();
				}, "text");
			} else {
				var url = "${base}/logistic-ajax/ajax-update-address.htm";
				var params = {
					"deliver.id" : id,
					"deliver.linkman" : linkman,
					"deliver.province" : province,
					"deliver.city" : city,
					"deliver.district" : district,
					"deliver.address" : address,
					"deliver.telephone" : telephone,
					"deliver.mobileTel" : mobileTel
				};
				$.post(url, params, function(data) {
					if (data != "success") {
						return false;
					}
					$("#orderForm").attr('action', '${base}/order/setting.htm').submit();
				}, "text");
			}
		});
	});
	
	function clearDeliveryForm() {
			$("#deliveryForm")[0].reset();
			$("#deliveryForm #deliveryProvince option:first").attr("selected", true);
			$("#deliveryForm #deliveryProvince").change();
			$("#deliveryForm #responseMessageDelivery").removeClass("faild success").empty();
		}
	function setDefault(id,$this) {	
		$.post("${base}/logistic-ajax/ajax-setIsDefault-address.html", {addressId : id}, function(data) {
			if (data == 'success') {
				var $addrBlock = $this.closest(".addr_block");
				$addrBlock.siblings(".addr_block[is_default='1']").attr("is_default", "0");
				$addrBlock.attr("is_default", "1");		
			} else {
				alert(data);
			}
		}, "text");	
  	}
  	<#--function cascadeCity(provinceId, city, district) {
			$("#city").empty().append("<option value=''>----请选择----</option>" );
			
			if (null == provinceId) {
				return false;
			}
			
			$.get("${base}/logistic/query-city.htm", {provinceId : provinceId}, function(data) {
				if (!data.success) {
					alert(data.message);
					return false;
				}
				$.each(data.object, function(index, c){ 
					$("#city").append("<option id='" + c.id + "' value='" + c.city 
						+ "' title='" + c.carriage + "' " 
						+ ((city != null && city == c.city) ? 'selected' : '') + ">" + c.city + "</option>" );
		    	});
		    	$("#city").trigger('change', district);
		    	
		    	var price = parseFloat($("#order_price").text());
		    	if (price < 100) {
			    	var carr = $("#city").find("option:selected").attr('title');
			    	if (carr == '' || carr == undefined) {
			    		carr = '0';
			    	}
			    	$("#carriage").text(parseFloat(carr).toFixed(2));
					$("#total").text((price + parseFloat(carr)).toFixed(2));
				} 
			});
		}-->
		function deliverBox() {
		$.blockUI({ 
			message: $("#deliveryBox"),
		 	css: {
				fadeIn: 600,
				fadeOut: 400,
				'background': '#fff',
				'border-radius': '5px',
				'-moz-border-radius': '5px',
				'-webkit-border-radius': '5px',
				'-moz-box-shadow': '3px 3px 5px #000',
				'-webkit-box-shadow': '3px 3px 5px #000',
				'box-shadow': '3px 3px 5px #000',
				'padding': '10px',
            	top:  '120px',
            	left: ($(window).width() - 500) /2 + 'px',
            	width: '520px'
    		}
        });
	}
	function cascadeDistrict(cityId, value) {
		if (null == cityId) {
			$("#district").hide();
			return false;
		}
		$.get("${base}/logistic/query-district.htm", {cityId : cityId}, function(data) {
			if (data.success) {
				if (data.object.length < 1) {
					return false;
				} 
				$("#district").show().empty();
				$.each(data.object, function(index, d) { 
					$("#district").append("<option value='" + d.district + "'" + (value != null && value == d.district ? 'selected' : '') + ">" + d.district + "</option>");
		    	});
	    	}
		});
	}

	$("#img_add").on('click',function(){
		$("#invoiceDiv").append($("#invoiceDiv").children().last().clone(true).removeAttr('id'));
		$(this).replaceWith('<img class="img_remove" onclick="removeImg(this)" src="${base}/static/images/link-logo.png" />');	
	})
	function removeImg(img){
		$(img).parent().parent().parent().remove();
	}
	
	</script>