<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${title!''}</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="${base}/default/css/localcss/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="${base}/default/css/localcss/font-awesome.min.css">
<link rel="stylesheet" href="${base}/default/css/localcss/ionicons.min.css">
<link rel="stylesheet" href="${base}/default/css/plugins/pace.min.css">
<link rel="stylesheet" href="${base}/default/css/animate.css">
<link rel="stylesheet" href="${base}/default/css/skin.css">
<link rel="stylesheet" href="${base}/default/css/style.css">
<link href="${base}/default/css/chosen.css" rel="stylesheet">
<link href="${base}/default/css/morris.css" rel="stylesheet">
<style type="text/css">
           .colourOne,.colourTwo,.colourThree,.colourFour,.colourFive{
                width: 12px;
                height: 12px;
                float: left;
                margin-left: 12px;
                margin-right: 12px;
                margin-top: 3px;
            }
            .colourOne{
                background-color: #0B97D4;
            }
            .colourTwo{
                background-color: #FF774F;
            }
            .colourThree{
                background-color: #E16ABE;
            }
            .colourFour{
                background-color: #A8AA23;
            }
            .colourFive{
                background-color: red;
            }
</style>

<!--[if lt IE 9]>
<script src="${base}/default/js/localjs/html5shiv.min.js"></script>
<script src="${base}/default/js/localjs/respond.min.js"></script>
  <![endif]-->
</head>
<body class="skin sidebar-mini">
<div class="wrapper"> <#include "/layout/menu.ftl">
  <div class="content-wrapper">
  
  <section class="content"> 
    <#if companyList?has_content><h2 class="page-header">Customer List  </h2></#if>
    <!---客户列表--->
    <!--<#if companyList?has_content>
    <div class="row">
    <#list companyList as company>
    	<div class="col-lg-4 col-md-3" onclick="location.href='${base}/user/updateUserCustomer.html?id=${company.id}';" style="cursor:pointer;">
        <div class="box box-widget widget-user-2">
          <div class="widget-user-header logo clearfix bg-green">
            <div class="widget-user-image"> <img alt="User Avatar" <#if (company.logo)==""> src="/default/img/user1-128x128.jpg" <#else> src="${imgServer}${(company.logo)!}"</#if> class="img-circle"> </div>
            <h3 class="widget-user-username">${company.name}</h3>
            <h6 class="widget-user-desc small">${company.nameEn}</h6>
          </div>
        </div>
      </div>
    </#list>
    </div>
    </#if>-->
    <!---客户列表--->
    <#if companyList?has_content>
    <div class="row">
      <div class="col-md-12">
        <div class="box box-danger">
          <div class="box-body no-padding">
            <ul class="users-list clearfix">
              <#list companyList as company>
              <li class="user-logo" >
                <img alt="User Avatar" <#if (company.logo)==""> src="/default/img/user1-128x128.jpg" <#else> 
                src="${imgServer}${(company.logo)!}"</#if> class="widget-user-image" data-toggle="tooltip" 
                data-placement="bottom" title="${company.name}"
                onclick="location.href='${base}/user/updateUserCustomer.html?id=${company.id}';" style="cursor:pointer;"> 
              </li>
              </#list>
            </ul>
          </div>
        </div>
      </div>
    </div>
    </#if>

    <!---To-do list--->
	<h2 class="page-header">To-do List</h2>
    <div>
	  <div class="row">
        <div class="col-md-3 col-sm-4 col-xs-6">
          <div class="small-box bg-green">
            <div class="inner">
              <h3><#if count?has_content>${count}<#else>0</#if></h3>
              <p>待处理客户</p>
            </div>
            <div class="icon"> <i class="fa fa-laptop"></i> </div>
            <a class="small-box-footer" href="#">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
          <div class="small-box bg-green">
            <div class="inner">
              <h3>${shipmentCount}</h3>
              <p>三天内待出货</p>
            </div>
            <div class="icon"> <i class="fa fa-cart-arrow-down"></i> </div>
            <a class="small-box-footer" href="${base}/calculateShipmentInThreeDay.html">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
        </div>
        
        <div class="col-md-3 col-sm-4 col-xs-6">
          <div class="small-box bg-green">
            <div class="inner">
              <h3>${applyOutTimeCount}<sup style="font-size: 20px"></sup></h3>
              <p>待申请开票</p>
            </div>
            <div class="icon"> <i class="fa fa-calendar-minus-o"></i> </div>
            <a class="small-box-footer" href="${base}/customer-apply-time-out1.html">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
          <div class="small-box bg-green">
            <div class="inner">
              <h3>${GatheringOutTimeCount}</h3>
              <p>待收款</p>
            </div>
            <div class="icon"> <i class="fa fa-plus-square-o"></i> </div>
            <a class="small-box-footer" href="${base}/customer-statement-gathering-time-out.html">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>${stockStorageTimeOut}</h3>
              <p>SQE质检报告</p>
            </div>
            <div class="icon"> <i class="fa fa-desktop"></i> </div>
            <a class="small-box-footer" href="${base}/stockStorageTimeOut.html">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>${receiptOutTimeCount}</h3>
              <p>待出收货报告</p>
            </div>
            <div class="icon"> <i class="fa fa-calendar-plus-o"></i> </div>
            <a class="small-box-footer" href="${base}/orderReceipOutTimetList.html">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>${statementOutTimeCount}</h3>
              <p>待对账</p>
            </div>
            <div class="icon"> <i class="fa fa-calendar-plus-o"></i> </div>
            <a class="small-box-footer" href="${base}/customer-statement-time-out.html">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>0</h3>
              <p>待付款</p>
            </div>
            <div class="icon"> <i class="fa fa-minus-square-o"></i> </div>
            <a class="small-box-footer" href="#">More info <i class="fa fa-arrow-circle-right"></i></a> </div>
        </div>
      </div>
      <#if post_level gt 0>
      <!---所有待审核事项↓--->
      <h2 class="page-header">所有待审核事项</h2>
      <div class="row">      
        <div class="col-md-12">
          <div class="box box-widget widget-user"> 
            <div class="box-body">
              <div class="row">
                <#if companyTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h3 class="description-header">${companyTol}</h3>
                    <span class="description-text text-green"><a href="${base}/custoAudit.html">客户审核</a></span>
                  </div>
                </div>
                </#if>
                <#if cumOrdTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h3 class="description-header">${cumOrdTol}</h3>
                    <span class="description-text text-green"><a href="${base}/unExamineCO.html">订单审核</a></span>
                  </div>
                </div>
                </#if> 
                <#if zfOrdTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h3 class="description-header">${zfOrdTol}</h3>
                    <span class="description-text text-green"><a href="${base}/order-abolish-list.html">订单作废审核</a></span>
                  </div>
                </div>
                </#if> 
                <#if batchTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${batchTol}</h5>
                    <span class="description-text text-green"><a href="${base}/customer-supplier/supplier-product-wait-list.html">供应商审核</a></span>
                  </div>
                </div>
                </#if>
				<#if supplierTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${supplierTol}</h5>
                    <span class="description-text text-green"><a href="${base}/supplier-manage/supplier-wait.html">筛选供应商审核</a></span>
                  </div>
                </div>
                </#if>
                <#if jgSupplierTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${jgSupplierTol}</h5>
                    <span class="description-text text-green"><a href="${base}/auditing-price.html">供应商价格审核</a></span>
                  </div>
                </div>
                </#if>
                <#if cpgyTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${cpgyTol}</h5>
                    <span class="description-text text-green"><a href="${base}/customer-supplier/go-audit-list.html">产品供应商审核</a></span>
                  </div>
                </div>
                </#if>
                <#if purchTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${purchTol}</h5>
                    <span class="description-text text-green"><a href="${base}/fent-order-examine-list.html">打样订单审核</a></span>
                  </div>
                </div>
                </#if>
                <#if prTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${prTol}</h5>
                    <span class="description-text text-green"><a href="${base}/unExmPurchaseList.html">PR订单审核</a></span>
                  </div>
                </div>
                </#if>
                <#if bmTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block">
                    <h5 class="description-header">${bmTol}</h5>
                    <span class="description-text text-green"><a href="${base}/storageAudit.html">检验处理审核</a></span>
                  </div>
                </div>
                </#if>
                <#if reportTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6 ">
                  <div class="description-block border-right">
                    <h5 class="description-header">${reportTol}</h5>
                    <span class="description-text text-green"><a href="${base}/delivery/check-report-date.html">收货报告审核</a></span>
                  </div>
                </div>
                </#if>
                <#if custTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${custTol}</h5>
                    <span class="description-text text-green"><a href="${base}/statement/customer-statement-wait-check.html">销售对账审核</a></span>
                  </div>
                </div>
                </#if>
                <#if supHadTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${supHadTol}</h5>
                    <span class="description-text text-green"><a href="${base}/statement/statement-check-wait.html">采购对账审核</a></span>
                  </div>
                </div>
                </#if>
                <#if payTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${payTol}</h5>
                    <span class="description-text text-green"><a href="${base}/statement/statement-pay-check-wait.html">申请付款审核</a></span>
                  </div>
                </div>
                </#if>
                <!--新增领料申请审核--start-- -->
                <#if pickingCheckTol != 0 && pickingCheckTol??>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${pickingCheckTol}</h5>
                    <span class="description-text text-green"><a href="${base}/stockmanage/pickingCheckList.html">领料申请审核</a></span>
                  </div>
                </div>
                </#if>
                <!--新增领料申请审核--end-- -->
                
                <!--新增KPI管理审核--start-- -->
                <#if kpiCheckTol != 0 && kpiCheckTol??>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${kpiCheckTol}</h5>
                    <span class="description-text text-green"><a href="${base}/kpi/kpiManagementCheckList.html">KPI管理审核</a></span>
                  </div>
                </div>
                </#if>
                <!--新增KPI管理审核--end-- -->
                
                <!--新增KPI管理审核--start-- -->
                <#if kpiBonusCheckTol != 0 && kpiBonusCheckTol??>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${kpiBonusCheckTol}</h5>
                    <span class="description-text text-green"><a href="${base}/kpi/bonusCheckList.html">奖金计算审核</a></span>
                  </div>
                </div>
                </#if>
                <!--新增KPI管理审核--end-- -->
                
                <!--新项目申请审核--start-- -->
                <#if projectCheckTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${projectCheckTol}</h5>
                    <span class="description-text text-green"><a href="${base}/projectApplyCheckList.html">项目申请审核</a></span>
                  </div>
                </div>
                </#if>
                <!--新项目申请审核--end-- -->
                
                <#if budgetList != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${budgetList}</h5>
                    <span class="description-text text-green"><a href="${base}/budget-sure.html">客户预算审核</a></span>
                  </div>
                </div>
                </#if>
                
                <#-- <#if budgetPredict == 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${budgetPredict}</h5>
                    <span class="description-text text-green"><a href="${base}/budget-predict.html">后三月预算数据</a></span>
                  </div>
                </div>
                </#if> -->
                
                <#if fybxInfo != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${fybxInfo}</h5>
                    <span class="description-text text-green"><a href="${base}/cost/examineList.html">费用报销审核</a></span>
                  </div>
                </div>
                </#if>

				<#if bonusCTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${bonusCTol}</h5>
                    <span class="description-text text-green"><a href="${base}/bonus-company-auth-list.html">奖金分配审核</a></span>
                  </div>
                </div>
                </#if>

				<#if bonusSTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${bonusSTol}</h5>
                    <span class="description-text text-green"><a href="${base}/bonus-sale-auth-list.html">奖金提取审核</a></span>
                  </div>
                </div>
                </#if>
                
                <#if badGathring != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${badGathring}</h5>
                    <span class="description-text text-green"><a href="${base}/statement/customer-statement-gathering-his-bad.html">坏账审核</a></span>
                  </div>
                </div>
                </#if>

				<#if costBudget != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${costBudget}</h5>
                    <span class="description-text text-green"><a href="${base}/cost/cost-budget-check-list.html">费用预算审核</a></span>
                  </div>
                </div>
                </#if>
                
                
                <#if billAdjustment != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${billAdjustment}</h5>
                    <span class="description-text text-green"><a href="${base}/statement/customer-statement-adjustment-check-list.html">开票调整金额审核</a></span>
                  </div>
                </div>
                </#if>

                <#if quoteTol != 0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${quoteTol}</h5>
                    <span class="description-text text-green"><a href="${base}/quotation-check-list.html">报价审核</a></span>
                  </div>
                </div>
                </#if>
               	<#if fentReceiptTol !=0>
                <div class="col-md-2 col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <h5 class="description-header">${fentReceiptTol}</h5>
                    <span class="description-text text-green"><a href="${base}/fent-receipt-exam-list.html">打样处理报告审核</a></span>
                  </div>
                </div>
               	</#if>
              </div>
            </div>
          </div>
        </div>
      </div>  
      </#if>
      

      <!---业绩追踪↓--->
      <h2 class="page-header" style="opacity:0;margin:0px;"><span>Performance Tracking</span> <span style="margin-left:38%">Actual VS Budget</span></h2>  
      <div class="row">
        <#if post_level gt 1>
        <div class="col-md-7" hidden>
          <div class="row">
            <#if post_level gt 3>
	        <div class="col-md-4">
	          <div class="form-group">
	            <select class="form-control chosen-select">
	              <option selected="selected">销售总监</option>
	              <option>Summer</option>
	              <option>Bobo</option>
	              <option>Cici</option>
	            </select>
	          </div>
	        </div>
	        </#if>
			<#if post_level gt 2>
	        <div class="col-md-4">
	          <div class="form-group">
	            <select class="form-control chosen-select">
	              <option selected="selected">销售经理</option>
	              <option>Alaska</option>
	              <option>California</option>
	              <option>Delaware</option>
	              <option>Tennessee</option>
	            </select>
	          </div>
	        </div>
	        </#if>
	        <div class="col-md-4">
	          <div class="form-group">
	            <select class="form-control chosen-select">
	              <option selected="selected">专员</option>
	              <option>Alaska</option>
	              <option>California</option>
	              <option>Delaware</option>
	              <option>Tennessee</option>
	              <option>Texas</option>
	              <option>Washington</option>
	            </select>
	          </div>
	        </div>
	      </div>
	    </div>
	    </#if>
        <section class="col-md-6 connectedSortable">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs pull-right">      
              <li><a name="revenue" href="#revenue-chart" data-toggle="tab">已收款收入</a></li>  
              <li class="active"><a name="order" href="#order-chart" data-toggle="tab">订单收入</a></li>
              <li><a name="delivery" href="#delivery-chart" data-toggle="tab">已出货收入</a></li>  
              <li><a name="invoice" href="#invoice-chart" data-toggle="tab">已开票收入</a></li>
              <li class="pull-left header" onclick="getInfo();"><a><i class="fa fa-inbox"></i > Performance Tracking</a></li>
              
            </ul>
            <div class="tab-content no-padding">
              
              <div class="chart tab-pane " id="revenue-chart" style="position: relative; height: 330px;"></div>
              <div class="chart tab-pane " id="invoice-chart" style="position: relative; height: 330px; "></div>
              <div class="chart tab-pane " id="delivery-chart" style="position: relative; height: 330px; "></div>
              <div class="chart tab-pane active" id="order-chart" style="position: relative; height: 330px; "></div>
            </div>
          </div>
        </section>
        <!---表格↓--->
        <section class="col-lg-6 connectedSortable">
          <!-- <div class="col-md-12">
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">客户业绩列表</h3>
                <div class="box-tools">
                  <ul id="customerPerformancePagin" class="pagination pagination-sm no-margin pull-right">
                    <li><a href="javascript:;" page="1">«</a></li>
                    <li><a href="javascript:;" page="1">1</a></li>
                    <li><a href="javascript:;" page="2">2</a></li>
                    <li><a href="javascript:;" page="2">»</a></li>
                  </ul>
                </div>
              </div>
              <div class="box-body no-padding">
                <table id="customerPerformanceTable" class="table">
                  <thead>
                  	<tr>
                      <th>客户名称</th>
                      <th>订单数</th>
                      <th>金额（元）</th>
                    </tr>
                  </thead>
                  <tbody></tbody>
                </table>
              </div>
            </div>
          </div> -->
          
     <!---Actual VS Budget(实际与预算对比)--->      
      <div class="row">
        <#if post_level gt 1>
        <div class="col-md-7" hidden>
          <div class="row">
            <#if post_level gt 3>
	        <div class="col-md-4">
	          <div class="form-group">
	            <select class="form-control chosen-select">
	              <option selected="selected">销售总监</option>
	              <option>Summer</option>
	              <option>Bobo</option>
	              <option>Cici</option>
	            </select>
	          </div>
	        </div>
	        </#if>
			<#if post_level gt 2>
	        <div class="col-md-4">
	          <div class="form-group">
	            <select class="form-control chosen-select">
	              <option selected="selected">销售经理</option>
	              <option>Alaska</option>
	              <option>California</option>
	              <option>Delaware</option>
	              <option>Tennessee</option>
	            </select>
	          </div>
	        </div>
	        </#if>
	        <div class="col-md-4">
	          <div class="form-group">
	            <select class="form-control chosen-select">
	              <option selected="selected">专员</option>
	              <option>Alaska</option>
	              <option>California</option>
	              <option>Delaware</option>
	              <option>Tennessee</option>
	              <option>Texas</option>
	              <option>Washington</option>
	            </select>
	          </div>
	        </div>
	      </div>
	    </div>
	    </#if>

        <div class="col-lg-12">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs pull-right">
              <!--<li class="active"><a name="inChart" href="#in-chart" data-toggle="tab">收款金额</a></li>-->
              <li class="active"><a name="salesoutChart" href="#salesout-chart" data-toggle="tab">销售收入（开票）</a></li>
              <li class="pull-left header"><i class="fa fa-inbox"></i>业绩</li>
            </ul>
            <div class="tab-content">
              <div class="chart tab-pane active" id="in-chart" style="position: relative; height: 250px;"></div>
              <div class="chart tab-pane " id="salesout-chart" style="position: relative; height: 250px;"></div>
            </div>
            <div class="row pad margin">
              <div class="col-md-4"></div>
              <div class="col-md-4">
                <div class="row">
	              <div class="col-md-4">
	                <div class="progress-group">
	                  <span class="progress-text">目标</span>
	                  <div class="progress sm margin-bottom-none">
	                    <div class="label-blue progress-bar progress-bar-aqua" style="width: 100%;"></div>
	                  </div>
	                </div>
	              </div>
	              <div class="col-md-4">
	              <div class="progress-group">
	                  <span class="progress-text">预测</span>
	                  <div class="progress sm margin-bottom-none">
	                    <div class="label-gray progress-bar progress-bar-aqua" style="width: 100%;"></div>
	                  </div>
	                </div>
	              </div>
	              <div class="col-md-4">
	              <div class="progress-group">
	                  <span class="progress-text">完成</span>
	                  <div class="progress sm margin-bottom-none">
	                    <div class="label-green progress-bar progress-bar-aqua" style="width: 100%;"></div>
	                  </div>
	                </div>
	              </div>
	            </div> 
              </div>
              <div class="col-md-4"></div>
            </div>
            <div class="clearfix"></div>
		  </div> 
        </div>
      </div>
          
        </section>
      </div>




		<#if flag == 1 || flag == 2>
			<h2 class="page-header"><span>Key Performance Data</span> </h2>  
			<div class="row">
			<!---表格↓--->
			<section class="col-lg-12 connectedSortable">
					<div class="box box-widget widget-user">
						<div class="box-body">
							<table class="table" frame=void>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>当月销售<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if actualBillOne.thisMonth=="0"><#else>${actualBillOne.thisMonth}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>当月毛利<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if grossProfitTotalOne.thisMonth=="0"><#else>${grossProfitTotalOne.thisMonth}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>当月费用<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyong.allFee=="0.00"><#else>${feiyong.allFee}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>当月EBIT<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyong.ebt=="0.00"><#else>${feiyong.ebt}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>年度完成</td>
								</tr>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>当月达成率<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if deliverRateOne.thisMonth=="0.00"><#else>${deliverRateOne.thisMonth}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>平均毛利率<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if grossProfitRateOne.thisMonth=="0"><#else>${grossProfitRateOne.thisMonth}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>当月费销比<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyong.feeRadio=="0.00"><#else>${feiyong.feeRadio}%</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>当月EBIT率</td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>DSO</td>
								</tr>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>YTD销售<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500">${actualBillOne.ytd}</span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>YTD毛利<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500">${grossProfitTotalOne.ytd}</span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>YTD费用<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongYTD.allFee="0.00"><#else>${feiyongYTD.allFee}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>YTD EBIT<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongYTD.ebt="0.00"><#else>${feiyongYTD.ebt}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>库销比</td>
								</tr>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFour"></div>YTD达成率<#if deliverRateOne.ytd == "0.00%"><#else><span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500">${deliverRateOne.ytd}</span></#if></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFour"></div>YTD毛利率<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500">${grossProfitRateOne.ytd}</span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFour"></div>YTD费销比<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongYTD.feeRadio=="0.00"><#else>${feiyongYTD.feeRadio}%</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFour"></div>YTD EBIT率</td>
									<td style="border: 1px dashed #D0D0D0"></td>
								</tr>
							</table>							
						</div>	
						<div style="background-color:#00A65A;mrgin-top:-10px;width:50%;height:50px;float:left;text-align:center;line-height:50px;"><span style="font-size:18px;color:#FFFFFF">当月奖金</span></div>	
						<div style="background-color:#F39C12;mrgin-top:-10px;width:50%;height:50px;float:left;text-align:center;line-height:50px;"><span style="font-size:18px;color:#FFFFFF">YTD Bounds</span></div>				
					</div>
					
			</section>
		</div>
		</#if>
		
	<#if flag == 2 || flag == 4>
		<h2 class="page-header"><span>Performance Tracking</span> </h2>  
		<div class="row">
			<!---表格↓--->
			<section class="col-lg-12 connectedSortable">
					<div class="box box-widget widget-user">
						<div class="box-body">
							<table class="table" frame=void>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>当月销售<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if actualBillTeam.thisMonth="0"><#else>${actualBillTeam.thisMonth}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>当月毛利<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if grossProfitTotalTeam.thisMonth="0"><#else>${grossProfitTotalTeam.thisMonth}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>当月费用<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongTeam.allFee="0.00"><#else>${feiyongTeam.allFee}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>当月EBIT<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongTeam.ebt="0.00"><#else>${feiyongTeam.ebt}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourOne"></div>年度完成</td>
								</tr>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>当月达成率<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if deliverRateTeam.thisMonth="0.00"><#else>${deliverRateTeam.thisMonth}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>平均毛利率<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500">${grossProfitRateTeam.thisMonth}</span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>当月费销比<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongTeam.feeRadio="0.00"><#else>${feiyongTeam.feeRadio}%</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>当月EBIT率</td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourTwo"></div>DSO</td>
								</tr>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>YTD销售<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500">${actualBillTeam.ytd}</span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>YTD毛利<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500">${grossProfitTotalTeam.ytd}</span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>YTD费用<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongTeamYTD.allFee="0.00"><#else>${feiyongTeamYTD.allFee}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>YTD EBIT<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongTeamYTD.ebt="0.00"><#else>${feiyongTeamYTD.ebt}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourThree"></div>库销比</td>
								</tr>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFour"></div>YTD达成率<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if deliverRateTeam.ytd="0.00"><#else>${deliverRateTeam.ytd}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFour"></div>YTD毛利率<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500">${grossProfitRateTeam.ytd}</span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFour"></div>YTD费销比<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if feiyongTeamYTD.feeRadio="0.00"><#else>${feiyongTeamYTD.feeRadio}%</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFour"></div>YTD EBIT率</td>
									<td style="border: 1px dashed #D0D0D0"></td>
								</tr>
								<tr>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFive"></div>人均销售<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if perCapitaSales=="0"><#else>${perCapitaSales}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFive"></div>人均毛利<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if perCapitaGrossProfit=="0"><#else>${perCapitaGrossProfit}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFive"></div>人均费用<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if averageCost=="0"><#else>${averageCost}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"><div class="colourFive"></div>人均EBIT<span style="margin-left:20px;color:#77BAE1;font-size:110%;font-weight:500"><#if averageEbt=="0"><#else>${averageEbt}</#if></span></td>
									<td style="border: 1px dashed #D0D0D0"></td>
								</tr>
								
								
					
								<tr>
									<td colspan="5" style="border: 1px dashed #D0D0D0">
										<div style="background-color:#00A65A;mrgin-top:-10px;width:50%;height:50px;float:left;text-align:center;line-height:50px;"><span style="font-size:18px;color:#FFFFFF">当月奖金</span></div>	
										<div style="background-color:#F39C12;mrgin-top:-10px;width:50%;height:50px;float:left;text-align:center;line-height:50px;"><span style="font-size:18px;color:#FFFFFF">YTD Bounds</span></div>													
									</td>	
									
								</tr>
					
					<!-- 		<#if tableUserList?? && tableUserList?size gt 0>
									<tr>
										<td colspan="5" style="border: 1px dashed #D0D0D0"><span style="font-size:160%">Team Bouns</span></td>									
									</tr>
									<#list tableUserList as userList>
										<tr>
											<#list userList as user>
												<td style="border: 1px dashed #D0D0D0">${user.username}</td>
											</#list>
										</tr>
									</#list> 
								</#if>		 -->	
								
								
								
							</table>							
						</div>
<!-- 						<#if flag == 4>	
							<div style="background-color:#00A65A;mrgin-top:-10px;width:50%;height:50px;float:left;text-align:center;line-height:50px;"><span style="font-size:18px;color:#FFFFFF">当月奖金</span></div>	
							<div style="background-color:#F39C12;mrgin-top:-10px;width:50%;height:50px;float:left;text-align:center;line-height:50px;"><span style="font-size:18px;color:#FFFFFF">YTD Bounds</span></div>				
						</#if> -->
					</div>
			</section>
		</div>
	</#if>
		




					<!---供应商业绩--->
<!--       <h2 class="page-header">供应商业绩 </h2>
      <div class="row">
        <div class="col-lg-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">供应商业绩</h3>
              <div class="box-tools">
                <div class="input-group input-group-sm" style="width: 150px;">
                  <input name="table_search" class="form-control pull-right" placeholder="Search" type="text">
                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>
              </div>
            </div>
            /.box-header
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody>
                <tr>
                  <th>供应商</th>
                  <th>及时送货率</th>
                  <th>质量合格率</th>
                  <th>批退率</th>
                  <th>不良率</th>
                  <th>价格水平</th>
                  <th>反应速度</th>
                  <th>评价星级</th>
                </tr>
                <tr>
                  <td>昌鑫隆</td>
                  <td>98%</td>
                  <td>96%</td>
                  <td><span class="label label-success">1%</span></td>
                  <td>0.5%</td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                </tr>
                <tr>
                  <td>好之印</td>
                  <td>80%</td>
                  <td>75%</td>
                  <td><span class="label label-success">5%</span></td>
                  <td>2%</td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a><a href="#"><i class="fa fa-star text-yellow"></i></a><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                </tr>
                <tr>
                  <td>江苏大富</td>
                  <td>79%</td>
                  <td>90%</td>
                  <td><span class="label label-success">3%</span></td>
                  <td>0.5%</td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                  <td><a href="#"><i class="fa fa-star text-yellow"></i></a><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                </tr>
              </tbody></table>
            </div>
          </div>
          
          
        </div>
      </div> -->
      <!---成本--->
 <!---     <h2 class="page-header">成本 </h2>
      <div class="row">
        <#if post_level gt 3>
        <div class="col-md-2">
          <div class="form-group">
            <select class="form-control chosen-select">
              <option selected="selected">销售总监</option>
              <option>Summer</option>
              <option>Bobo</option>
              <option>Cici</option>
            </select>
          </div>
        </div>
        </#if>
		<#if post_level gt 2>
        <div class="col-md-2">
          <div class="form-group">
            <select class="form-control chosen-select">
              <option selected="selected">销售经理</option>
              <option>Alaska</option>
              <option>California</option>
              <option>Delaware</option>
              <option>Tennessee</option>
            </select>
          </div>
        </div>
        </#if>
		<#if post_level gt 1>
        <div class="col-md-2">
          <div class="form-group">
            <select class="form-control chosen-select">
              <option selected="selected">专员</option>
              <option>Alaska</option>
              <option>California</option>
              <option>Delaware</option>
              <option>Tennessee</option>
              <option>Texas</option>
              <option>Washington</option>
            </select>
          </div>
        </div>
        </#if>
        <div class="col-md-2">
          <div class="form-group">
            <select class="form-control chosen-select">
              <option selected="selected">年份、月份选择</option>
              <option>Alaska</option>
              <option>California</option>
              <option>Delaware</option>
              <option>Tennessee</option>
              <option>Texas</option>
              <option>Washington</option>
            </select>
          </div>
        </div>
        <div class="clearfix"></div>
        
        <div class="col-md-12">
          <div class="box box-info">
            <div class="row">
              <div class="col-md-6">
	            <div class="graph-container"> 
	              <div class="caption">直接成本</div>
	              <div class="box-body no-padding chart-responsive">
	                <div class="graph" id="hero-donut" style="position: relative;"></div>
	              </div>  
	            </div> 
	          </div>
	          <div class="col-md-6">
	            <div class="graph-container"> 
	              <div class="caption">间接成本</div>
	              <div class="box-body no-padding chart-responsive">
	                <div class="graph" id="hero-cake" style="position: relative;"></div>
	              </div>
	            </div>  
	          </div>
	        </div>
          </div> 
        </div>
      </div>	--->
	<!--   <div class="clearfix"></div>       -->
      <!---奖金--->
   <!--    <h2 class="page-header">奖金 </h2> -->
  <!--    <div class="row">
        <#if post_level gt 3>
        <div class="col-md-2">
          <div class="form-group">
            <select class="form-control chosen-select">
              <option selected="selected">销售总监</option>
              <option>Summer</option>
              <option>Bobo</option>
              <option>Cici</option>
            </select>
          </div>
        </div>
        </#if>
		<#if post_level gt 2>
        <div class="col-md-2">
          <div class="form-group">
            <select class="form-control chosen-select">
              <option selected="selected">销售经理</option>
              <option>Alaska</option>
              <option>California</option>
              <option>Delaware</option>
              <option>Tennessee</option>
            </select>
          </div>
        </div>
        </#if>
		<#if post_level gt 1>
        <div class="col-md-2">
          <div class="form-group">
            <select class="form-control chosen-select">
              <option selected="selected">专员</option>
              <option>Alaska</option>
              <option>California</option>
              <option>Delaware</option>
              <option>Tennessee</option>
              <option>Texas</option>
              <option>Washington</option>
            </select>
          </div>
        </div>
        </#if>
        <div class="col-md-2">
          <div class="form-group">
            <select class="form-control chosen-select">
              <option selected="selected">年份选择</option>
              <option>Alaska</option>
              <option>California</option>
              <option>Delaware</option>
              <option>Tennessee</option>
              <option>Texas</option>
              <option>Washington</option>
            </select>
          </div>
        </div>
        <div class="col-lg-12">
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">奖金</h3>
            </div>
            <div class="box-body chart-responsive">
              <div class="chart" id="bar-chart" style="height: 300px;"></div>
            </div>
          </div>
        </div>
      </div>  -->
    </div>
  </section>
</div>
</div>
</body>
<script src="${base}/default/js/localjs/jquery-2.2.2.min.js"></script>
<script src="${base}/default/js/localjs/bootstrap.min.js"></script>
<script src="${base}/default/js/plugins/pace.min.js"></script>
<script src="${base}/default/js/plugins/metisMenu.min.js"></script>
<script src="${base}/default/js/localjs/chosen.jquery.min.js"></script>
<script src="${base}/default/js/localjs/raphael.min.js"></script>
<script src="${base}/default/js/morris.min.js"></script>

<script src="${base}/default/js/app.js"></script>
<script>
	$(function() {
		/* 客户业绩列表的展示 */
		var pageNum = 1;
		$(document).on('click', '#customerPerformancePagin a', function(){
			$this = $(this);
			var page = parseInt($this.attr('page'));
			if(pageNum!=page){
				pageNum = page;
				$.getJSON('${base}/cost/customerPerformance.html',{"pageNum":pageNum,'pageSize':8},function(data2){
					$('#customerPerformanceTable > tbody').empty();
					$.each(data2.list, function(i2, item2){
						$('#customerPerformanceTable > tbody').append('<tr><td>'+item2.customerName+'</td><td>'+item2.ordersNum+'</td><td>'+item2.salesSum+'</td></tr>');
					});
					changeCustomerPerformancePagin(data2.total,8,pageNum);
				});
			}
		});
		$.getJSON('${base}/cost/customerPerformance.html',{"pageNum":pageNum,'pageSize':8},function(data){
			if (data != null) {
				pageNum = data.pageNum;
				$.each(data.list, function(i, item){
					$('#customerPerformanceTable > tbody').append('<tr><td>'+item.customerName+'</td><td>'+item.ordersNum+'</td><td>'+item.salesSum+'</td></tr>');
				});
				changeCustomerPerformancePagin(data.total,8,pageNum);
			}
		});
		
		$('.chosen-select').chosen({disable_search_threshold: 10, width:'100%'});
		
		$.get('${base}/cost/performanceTrackingSum.html?type=1',function(data){
		    Morris.Line({
		      element: 'order-chart',
		      resize: true,
		      data: $.parseJSON(data),
		      xkey: 'ym',
		      ykeys: ['sales','profit'],
		      labels: ['sales','profit'],
		      lineColors: ['#3c8dbc','#008B45'],
		      hideHover: 'auto'
		    });
		    getTime('#order-chart',1);
    	});
	    
	    var invoiceChart = function() {
	    	$.get('${base}/cost/performanceTrackingSum.html?type=3',function(data){
			    Morris.Line({
			      element: 'invoice-chart',
			      resize: true,
			      data: $.parseJSON(data),
			      xkey: 'ym',
			      ykeys: ['sales','profit'],
			      labels: ['sales','profit'],
			      lineColors: ['#3c8dbc','#008B45'],
			      hideHover: 'auto'
			    });
		   		getTime('#invoice-chart',3);
	    	});
	    }
	    $('[name="invoice"]').on('mouseup', function() {
	    	setTimeout(invoiceChart, 1);
	    });
	    
	    var revenueChart = function() {
	    	$.get('${base}/cost/performanceTrackingSum.html?type=4',function(data){
			    Morris.Line({
			      element: 'revenue-chart',
			      resize: true,
			      data: $.parseJSON(data),
			      xkey: 'ym',
			      ykeys: ['sales'],
			      labels: ['sales'],
			      lineColors: ['#3c8dbc','#008B45'],
			      hideHover: 'auto'
			    });
		   		getTime('#revenue-chart',4);
	    	});
	    }
	    $('[name="revenue"]').on('mouseup', function() {
	    	setTimeout(revenueChart, 1);
	    });
	    
	    var deliveryChart = function() {
	    	$.get('${base}/cost/performanceTrackingSum.html?type=2',function(data){
			    Morris.Line({
			      element: 'delivery-chart',
			      resize: true,
			      data: $.parseJSON(data),
			      xkey: 'ym',
			      ykeys: ['sales'],
			      labels: ['sales'],
			      lineColors: ['#3c8dbc','#008B45'],
			      hideHover: 'auto'
			    });
			    getTime('#delivery-chart',2);
	    	});
	    }
	    $('[name="delivery"]').on('click', function() {
	    	setTimeout(deliveryChart, 50);
	    	
	    });
	    
	    var orderChart = function() {
	    	$.get('${base}/cost/performanceTrackingSum.html?type=1',function(data){
			    Morris.Line({
			      element: 'order-chart',
			      resize: true,
			      data: $.parseJSON(data),
			      xkey: 'ym',
			      ykeys: ['sales','profit'],
			      labels: ['sales','profit'],
			      lineColors: ['#3c8dbc','#008B45'],
			      hideHover: 'auto'
			    });
			    getTime('#order-chart',1);
	    	});
	    }
	    $('[name="order"]').on('click', function() {
	    	setTimeout(orderChart, 10);
	    });
	    
	    $.get('${base}/budget-tracking-sum.html',function(data){
		    Morris.Area({
		    	element: 'in-chart',
		    	data: $.parseJSON(data),
		    	xkey: 'ym',
		    	ykeys: ['budgetMoney', 'forecastMoney', 'billMoney'],
		    	labels: ['目标', '预测', '完成'],
		    	pointSize: 2,
		    	hideHover: 'auto',
		    	behaveLikeLine: true
	    	});
		    $('#in-chart .morris-hover').click(function(){
		    	window.location="${base}/budget-actual-compare.html";
		    });
	    });
	    
	  $.get('${base}/wages/getJosnDirectCost.html',function(data){
	  	var sc = new Array();
		  $.each($.parseJSON(data),function(i,list){ 
		  	sc[i] = {label:list.label, value:list.value};
		  });
	    Morris.Donut({
		    element: 'hero-donut',
		    data: sc,
		    formatter: function (y) { return y + "%" }
		});
	  });
	  
	  $.get('${base}/wages/getWagesInfoJson.html',function(data){
	      var sc = new Array();
		  $.each($.parseJSON(data),function(i,list){ 
		  	sc[i] = {label:list.label, value:list.value};
		  });
	  	  Morris.Donut({
			  element: 'hero-cake',
			  data: sc,
			  formatter: function (y) { return y + "%" }
		  });
	  });
	  	
	  //BAR CHART
	    var bar = new Morris.Bar({
	      element: 'bar-chart',
	      resize: true,
	      data: [
	        {y: '1月', a: 100, b: 90, c: 120, d: 150},
	        {y: '2月', a: 45, b: 75, c: 100, d: 90},
	        {y: '3月', a: 140, b: 100, c: 135, d: 90},
	        {y: '4月', a: 180, b: 155, c: 115, d: 130},
	        {y: '5月', a: 50, b: 40, c: 90, d: 125},
	        {y: '6月', a: 120, b: 65, c: 88, d: 79},
	        {y: '7月', a: 100, b: 90, c: 120, d: 150},
	        {y: '8月', a: 160, b: 135, c: 100, d: 166},
	        {y: '9月', a: 150, b: 140, c: 165, d: 179},
	        {y: '10月', a: 100, b: 80, c: 85, d: 90},
	        {y: '11月', a: 75, b: 65, c: 120, d: 150},
	        {y: '12月', a: 90, b: 99, c: 100, d: 120}
	      ],
	      barColors: ['#00a65a', '#f56954', '#3c8dbc', '#f39c12'],
	      xkey: 'y',
	      ykeys: ['a', 'b',  'c', 'd'],
	      labels: ['毛利', '成本', '奖金比例', '奖金金额'],
	      hideHover: 'auto'
	    });
	    
	    
	    
	});
	
	function changeCustomerPerformancePagin(pagecount, pagesize, currentpage){
		var counts,pagehtml="";
		if(pagecount%pagesize==0){
			counts = parseInt(pagecount/pagesize);
		}else{
			counts = parseInt(pagecount/pagesize)+1;
		}
		//只有一页内容
		if(pagecount<=pagesize){pagehtml="";}
		//大于一页内容
		if(pagecount>pagesize){
			if(currentpage>1){
				pagehtml+= '<li><a href="javascript:;" page="'+(currentpage-1)+'">上一页</a></li>';
			}
			for(var i=0;i<counts;i++){
				if(i>=(currentpage-5) && i<(currentpage+5)){
					if(i==currentpage-1){
						pagehtml+= '<li class="active"><a href="javascript:;" page="'+(i+1)+'">'+(i+1)+'</a></li>';
					}else{
						pagehtml+= '<li><a href="javascript:;" page="'+(i+1)+'">'+(i+1)+'</a></li>';
					}
				}
			}
			if(currentpage<counts){
				pagehtml+= '<li><a href="javascript:;" page="'+(currentpage+1)+'">下一页</a></li>';
			}
		}
		$("#customerPerformancePagin").html(pagehtml);
	}
	
	function getTime(e,nun){
		$(e + ' .morris-hover').click(function(){
			var ym = $(this).children('div:eq(0)').text();
			window.location="${base}/cost/reportList.html?startTime="+ym+"&type="+nun;
	    });
	}
	
</script>
