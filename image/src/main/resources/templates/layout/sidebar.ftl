   <div class="sidebar">
      <dl>
        <#list menus as navMenu>
          <#if navMenu.type == 1 || p.hasPermission(navMenu.target + ':access')>
			<dt>${navMenu.name}</dt>
			<!--<dd> <a href="${base}/order/to-orders-querysprice.htm">我要询价</a></dd>
	        <dd ><a href="${base}/order/my-orders.htm">生产中的订单</a></dd>
	        <dd ><a href="${base}/order/my-orders-finished.htm">已完成的订单</a></dd>-->
	        <#if navMenu.subList?has_content>
	        <#list navMenu.subList as sub>
	        <#if navMenu.type == 1 || p.hasPermission(sub.target + ':access')>
	        <dd><a href="${sub.href}">${sub.name}</a></dd>
	        <#if sub.subList?has_content>
	         <#list sub.subList as ls>
	         <#if navMenu.type == 1 || p.hasPermission(ls.target + ':access')>
	         <dd><a href="${ls.href}">
	                  <span>${ls.name}</span>
	                </a></dd>
  	                </#if> 
	              </#list>
	             </#if> 
	        </#if>
	        </#list>
	     	</#if>
       
      
      </#if>
      </#list>
      </dl>
    </div>