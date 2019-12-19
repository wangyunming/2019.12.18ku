<title>我的购物车</title>
<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header-step.css" type="text/css" media="screen"/>
<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-12px;"  alt=""/></a></div>
    <div class="mainbav-logo"><img src="${base}/static/images/new/cart.png" width="100" height="34"  alt=""/></div>
    <#--<div class="I_step"><img src="${base}/static/images/new/01_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li class="red">确认商品</li>
        <li>支付订单</li>
        <li>上传文件</li>
        <li>等待审核</li>
        <li>等待收货</li>
      </ul>
    </div>-->
  </div>
</div>
    <form id="queryForm" action="shopping-cart.htm" method="POST">
	</form>
<div class="bjf7 p100">
	<form id="setting" action="${base}/order/settingDirect.html" method="POST">
	  <div class="step1">
	    <div class="step1-con">
	      <div class="step1-con-title">
	        <div class="w135">
	         <input type="checkbox" id='selectAll'/>全选</div>
	        <div class="w275">商品信息</div>
	        <div class="w135">商品单价</div>
	        <div class="w120">商品数量</div>
	        <div class="w125">订单总额</div>
	        <div class="w30">操作</div>
	      </div>
	      
	      <#list cartList as item>
	      <div id='shoppingCartSC${item_index}' class="step1-con-info" >
	        <div class="w135 vt">
	          <input type="checkbox" id='selectSC${item_index}'  name='checkboxSC'  value='${item_index}'/>
	          <a  target="_blank" title="${item.commodityName}" >
		     	  <img src="${item.fileUrl}" width="80" height="80"/></a>
		    </div>
	        <div class="w325"><a  target="_blank">  ${item.commodityName}</a></div>
	        <#--<div class="w135">
	        	<#if item.status==1>
	        		需要设计稿
	        	<#else> 
	        		我有设计稿
	        	</#if>
	        </div>-->
	        <#--<div class="w120">${item.sendDate}</div>
	         </div>-->
	        <div class="w145 red">
	       <p style="width:50%"> ${item.rePrice!0}</p>
	       
	        </div>
	        <#if item.type="3">
	        	<div id='ScoreSC${item_index}' class="w165">
		      	<input id='IndexSC${item_index}' type="hidden" value='${item.number!'0'}' name=${(item.stepDiscountList?size)!'0'}/>
		           	<input id='CheckedSC${item_index}' type="hidden"  name='idList'/>
		        	<div class="SQ_w130" style="padding-left:20px;" > 
			          	<span id='minusSC${item_index}' class="cuts" >－</span>
			            <input id='CountSC${item_index}' type="text" name="" placeholder="0" class="delivery" >
			            <span id='addSC${item_index}' class="plus failed">＋</span>
			        </div>    
		        </div>
	        </#if>
	        <#if item.type = "1" || item.type = "2" || item.type = "4" || item.type = "5">
	        	<div id='ScoreSC${item_index}' class="w165">
	        		<input id='CheckedSC${item_index}' type="hidden"  name='idList'/>
		        	<div class="SQ_w130" style="padding-left:55px;" > 
			            ${item.number}
			        </div>    
		        </div>
	        </#if>
	      
	        <div id='PriceSC${item_index}' class="w115">${item.totalPrice!0} 元</div>
	        <div class="w30"><img id='delCartSC${item_index}' class="cur" src="${base}/static/images/new/close.png" width="9" height="8"  alt=""/></div>
	      </div>
	      </#list>
	      <div class="line"></div>
	      <div class="item-action">
	        <div id='checkout' class="botton w200">前往结算</div>
	        <p>合计（不含运费）：<span id='totalPrice'>0.00</span> 元</p>
	      </div>
	    </div>
	  </div>
  	</form>
   <div class="step1-page">
	  <p></p>
	  <div class="page"><div class="page"> <#include "/layout/pagination.ftl"></div> </div>
  </div>
  <div class="step1-integral">
    <div class="home-floor">
	 <#list scoreMallList as scoreMall>
      <div class="floor-diet h350">
        <div class="floor-diet-img"><img src="${static.scoreMall}${scoreMall.pathUrl!}" width="230" height="230"  alt=""/></div>
        <div class="floor-diet-text" name='scoreProduct'>
          <input type="hidden" name="scoreAmount" value="${scoreMall.amount?c!0}"/>	
          <input type="hidden" name="scoreCount" value="${scoreMall.score?c!1000}"/>	
          <input type="hidden" name="scoreId" value="${scoreMall.id?c}"/>	
          <p class="floot-textaa" name='scoreName'>${scoreMall.name!''}</p>
          <p class="integral-red"><span >${scoreMall.score?c!1000} </span><span class="f12 ml3">积分</span></p>
          <#if userType!=1><p class="integral-botton" name='orderButton'><a>立即兑换</a></p></#if>
        </div>
      </div>
     </#list>
    </div>
    <div class="clear"></div>
</div>
<form  id="updateCount" action="${base}/cart/update-cart-count.htm" method="POST">
	
	<input type="hidden" id="shoppingCartForm_id" name="id" value="">
	<input type="hidden"  id="shoppingCartForm_quantity" name="number" value="">
	<input type="hidden"  id="shoppingCartForm_itemId" name="itemId" value="">
	<input type="hidden"  id="shoppingCartForm_insidePrice" name="totalPrice" value="0">
	<input type="hidden"  id="shoppingCartForm_costPirce" name="insideCost" value="0">
</form>

<script src="${base}/static/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${base}/static/js/popup_layer.js"></script>
<script type="text/javascript">
	$(function() {
	
		$("[name='scoreProduct']").each(function() {
			var amount=$(this).children("[name='scoreAmount']").attr("value");
			var scoreCount=($(this).children("[name='scoreCount']")).attr("value");
			var scoreId=($(this).children("[name='scoreId']")).attr("value");
			$(this).children("[name='orderButton']").click(function(){
				if(amount==0){
					alert('礼品已兑换完，请选择其他礼品');
					return;
				}
				<#--if(${user.points} <scoreCount){
					alert('你的积分不足');
					return;
				}-->
			self.location.href = '${base}/scoremall/scoreOrder.htm?scoreId='+scoreId;	
			});
		});
		$("#selectAll").click(function() {
			if(!$(this).attr("checked")){
				$("input[name='checkboxSC']").attr("checked",false);
			}else{
				$("input[name='checkboxSC']").attr("checked",true);
			}
			total();
		});
		
		
		function total() {
			var arrChk=$("input[name='checkboxSC']:checked");
			 var totalprice=0;
	   		<#list cartList as item>
	   			$("#CheckedSC${item_index}").attr('value',null);
    	   </#list>
  			$(arrChk).each(function(){
  				 <#list cartList as item>
		    	  	if(${item_index}==this.value){
		    	  		var price=parseFloat($("#PriceSC${item_index}").html().replace(' 元',''));
		    	  		totalprice=totalprice+price;
		    	  		$("#CheckedSC${item_index}").attr('value','${item.id}');
		    	  	}
		    	  </#list>
    		});
    		$("#totalPrice").html(Number(totalprice).toFixed(3));
		}
	   <#list cartList as item>
			$("#shoppingCartSC${item_index}").click(function() {
				total();
			});
			$("#CountSC${item_index}").attr('placeholder','${item.number!'0'}');
			
			$("#delCartSC${item_index}").click(function() {
					if (confirm('确定要取消购买此商品吗？')) {
						top.location.href = '${base}/cart/remove-item.html?shoppingCartId=${item.id}';
					}
			});
			$("#minusSC${item_index}").click(function() {
				var cartIndex=$("#IndexSC${item_index}").attr('value');
				if(cartIndex==0){
					return;
				}
				cartIndex--;
				var sum=0;
				sum=${item.rePrice}*cartIndex ;
						
						$("#CountSC${item_index}").attr('placeholder',cartIndex);
						$("#PriceSC${item_index}").html(sum.toFixed(3)+'元');
						$("#IndexSC${item_index}").attr('value',cartIndex);
						<#--$("#ScoreSC${item_index}").html(cartIndex);-->
						$("#shoppingCartForm_itemId").val('${item.itemId}');
						$("#shoppingCartForm_quantity").val(cartIndex);
						$("#shoppingCartForm_id").val('${item.id}');
						$("#shoppingCartForm_insidePrice").val(sum.toFixed(3));
						$.ajax({
			                cache: true,
			                type: "POST",
			                url: "${base}/cart/update-cart-count.html",
			                data:$('#updateCount').serialize(),
			                async: false
			            });
					
		
				total();
			});
			$("#CountSC${item_index}").on('change',function(){
				var num= $(this).val();
				var sum=0;
				sum=${item.rePrice}*num ;
				$(this).attr('placeholder',num);
				$("#PriceSC${item_index}").html(sum.toFixed(3)+'元');
						$("#IndexSC${item_index}").attr('value',num);
						$("#shoppingCartForm_itemId").val('${item.itemId}');
						$("#shoppingCartForm_quantity").val(num);
						$("#shoppingCartForm_id").val(${item.id});
						$("#shoppingCartForm_insidePrice").val(sum.toFixed(3));
						$("#shoppingCartForm_costPirce").val("${item.insideCost!'0'}");
						$.ajax({
			                cache: true,
			                type: "POST",
			                url: "${base}/cart/update-cart-count.html",
			                data:$('#updateCount').serialize(),
			                async: false
			            });
				
			
				total();
			})
			
			$("#addSC${item_index}").click(function() {
				var cartIndex=$("#IndexSC${item_index}").attr('value');
				<#--var totalIndex=$("#IndexSC${item_index}").attr('name');
				if(cartIndex>=totalIndex){
					return;
				}-->
				cartIndex++;
				var sum=0;
				sum=${item.rePrice}*cartIndex ;
						$("#CountSC${item_index}").attr('placeholder',cartIndex);
						$("#PriceSC${item_index}").html(sum.toFixed(3)+'元');
						$("#IndexSC${item_index}").attr('value',cartIndex);
						<#--$("#ScoreSC${item_index}").html(cartIndex);-->
						$("#shoppingCartForm_itemId").val('${item.itemId}');
						$("#shoppingCartForm_quantity").val(cartIndex);
						$("#shoppingCartForm_id").val(${item.id});
						$("#shoppingCartForm_insidePrice").val(sum.toFixed(3));
						$("#shoppingCartForm_costPirce").val("${item.insideCost!'0'}");
						$.ajax({
			                cache: true,
			                type: "POST",
			                url: "${base}/cart/update-cart-count.html",
			                data:$('#updateCount').serialize(),
			                async: false
			            });
				
			
				total();
			});
		</#list>
		$('a[name="remove"]').click(function() {
			var id = $(this).attr( 'id' );
			if (confirm('确定要取消购买此商品吗？')) {
				top.location.href = '${base}/cart/remove-item.htm?idList=' + id;
			}
		});
		$("#checkout").click(function() {
			total();
			if($("#totalPrice").html()==0){
				alert('请选择商品');
			}else{
				$("#setting").submit();
			}
		});
	});
	
</script>