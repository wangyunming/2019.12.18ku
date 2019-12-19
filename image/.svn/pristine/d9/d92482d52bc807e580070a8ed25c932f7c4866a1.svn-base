<#setting classic_compatible=true>

<#include "layout/site-nav.ftl">
<div>
  <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="<#if csp.photo?has_content>${imgServer}${csp.photo}<#else>${base}/static/img/default_${csp.sex!'M'}_avatar.jpg</#if>" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${csp.name}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> ${csp.dept} </a><br>
          <a href="#"><i class="fa fa-circle text-success"></i> ${csp.position} </a>
        </div>
      </div>
      <!-- /.user panel -->
      
      <div class="sidebar-nav">
        <ul class="sidebar-menu">
          <li class="header"><i class="fa fa-navicon"></i> 导航</li>
          <#list menus as navMenu>
          <#if navMenu.type == 1 || p.hasPermission(navMenu.target + ':access')>
          <li class="treeview <#if navMenu.isActive()>active</#if>">
            <a href="${navMenu.href}">
              <i class="fa ${navMenu.style}"></i>
              <span>${navMenu.name}</span>
              <#if navMenu.subList?has_content>
              <i class="fa fa-angle-left pull-right"></i>
              </#if>
            </a>
            <#if navMenu.subList?has_content>
            <ul class="treeview-menu animated fadeIn">
              <#list navMenu.subList as sub>
              <#if navMenu.type == 1 || p.hasPermission(sub.target + ':access')>
              <li class="<#if sub.isActive()>active</#if>">
                <a href="${sub.href}">
                  <i class="fa fa-caret-right"></i>
                  <span>${sub.name}</span>
                  <#if sub.subList?has_content>
              		<i class="fa fa-angle-left pull-right"></i>
              	  </#if>
                </a>
                <#if sub.subList?has_content>
	            <ul class="treeview-menu animated fadeIn">
	              <#list sub.subList as ls>
	              <#if navMenu.type == 1 || p.hasPermission(ls.target + ':access')>
	              <li class="<#if ls.isActive()>active</#if>">
	                <a href="${ls.href}">
	                  <i class="fa fa-caret-right"></i>
	                  <span>${ls.name}</span>
	                </a>
	              </li>
	              </#if>
	              </#list>
	            </ul>
	            </#if>
              </li>
              </#if>
              </#list>
            </ul>
            </#if>
          </li>
          </#if>
          </#list>
		  <li class="header">--END--</li>
      	</ul>
      </div>
    </section>
    <!-- /.sidebar -->
  </aside>
</div>

