<#setting classic_compatible=true>

  
<link rel="stylesheet" href="${base}/static/css/localcss/bootstrap.min.css">
  <!-- Font Awesome -->
<link rel="stylesheet" href="${base}/static/css/localcss/font-awesome.min.css">
<link rel="stylesheet" href="${base}/static/css/localcss/bootstrap-submenu.min.css?v=1">
 
  <link rel="stylesheet" href="${base}/static/css/plugins/pace.min.css">
  <link rel="stylesheet" href="${base}/static/css/animate.css">
  <link rel="stylesheet" href="${base}/static/css/skin.css">
  <link rel="stylesheet" href="${base}/static/css/style.css">
  <link rel="stylesheet" href="${base}/static/css/metisTree.css">
  <link href="${base}/static/css/chosen.css" rel="stylesheet">
  <link rel="stylesheet" href="${base}/static/css/plugins/bootstrap.checkbox.css">
  
  <!--[if lt IE 9]>
<script src="${base}/static/js/localjs/html5shiv.min.js"></script>
<script src="${base}/static/js/localjs/respond.min.js"></script>
  <![endif]-->


<div class="bjf7 p20 of">
 
    	<#include "/layout/sidebar.ftl">
  <div class="user of">
  
	<section class="user-con pb0">
	  <h1> Add User
	    <small>系统用户管理</small>
	  </h1>
	  <ol class="breadcrumb">
	    
	    <li class="active">新增用户</li>
	  </ol>
	</section>
	<section class="right_con">
	  <div class="box box-primary">
	    <div class="box-header with-border">
	      <h3 class="box-title">用户资料</h3>
	    </div>
	    <div class="box-body">
		  <form id="userForm" method="post" class="form-horizontal">
		    <div class="row">
		      <div class="col-md-6">
		        <div class="form-group">
                  <label class="col-md-4 control-label" for="username">用户名：</label>
                  <div class="col-md-8">
                    <input type="text" name="username" placeholder="登录账号" id="username" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="password">登录密码：</label>
                  <div class="col-md-8">
                    <input type="password" name="password" placeholder="登录密码 6-18位字母、数字、符号的组合字符" id="password" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="confirmPassword">确认密码：</label>
                  <div class="col-md-8">
                    <input type="password" name="confirmPassword" placeholder="密码确认" id="confirmPassword" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="position">职位：</label>
                  <div class="col-md-8">
                    <select id="position" name="postList" class="chosen-select form-control" data-placeholder="请选择职位..." >
                   		<option value=""></option>
                   		<option value="10131">OEM</option>
                   		<option value="10132">INITIAL</option>
                    </select>
                    <input type="hidden" name="position">
                    <input type="hidden" name="roleIds">
                  </div>
                  
                </div>
                
                
                
                
                
         
              
              <div class="col-md-11.5">
                <div class="form-group">
                  <label class="col-md-4 control-label" for="name">真实姓名：</label>
                  <div class="col-md-8">
                    <input type="text" name="name" placeholder="用户的真实姓名" id="name" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="sex">性别</label>
                  <div class="col-md-8 checkbox">
                    <input type="radio" name="sex" id="M" value="M" checked>
                    <label for="M">男</label>
                    <input type="radio" name="sex" id="F" value="F">
                    <label for="F" class="col-md-offset-1">女</label>
                  </div>
                 </div> 
               
                
                
                
                
               
                <div class="form-group"></div>
              </div>
            </div>
		  </form>
	    </div>
	    <div class="box-footer">
	      <div class="col-md-3"></div>
          <div class="col-md-6">
            <button type="button" id="cancel" class="btn btn-static"> 取消,返回列表 </button>
      	    <button type="button" id="save" class="btn btn-primary col-md-offset-1">
      	      <i class="fa fa-floppy-o"></i> 保 存
      	    </button>
      	  </div>
	    </div>
	  </div>
	</section>
  </div>
</div>



<script src="${base}/static/js/localjs/jquery-2.2.2.min.js"></script>
<script src="${base}/static/js/localjs/bootstrap.min.js"></script>
<script src="${base}/static/js/plugins/pace.min.js"></script>
<script src="${base}/static/js/plugins/metisMenu.min.js"></script>
<script src="${base}/static/js/app.js"></script>
<script src="${base}/static/js/localjs/chosen.jquery.min.js"></script>
<script src="${base}/static/js/localjs/bootstrapValidator.js"></script>
<script src="${base}/static/js/localjs/bootstrap-datepicker.min.js"></script>
<script src="${base}/static/js/localjs/bootstrap-datepicker.zh-CN.min.js"></script>
<script src="${base}/static/js/localjs/bootstrap-submenu.min.js?v=1"></script>

<script src="${base}/static/js/inputmask/inputmask/inputmask.min.js"></script>
<script src="${base}/static/js/inputmask/inputmask/jquery.inputmask.bundle.min.js"></script>
<script src="${base}/static/js/inputmask/inputmask/inputmask.phone.extensions.min.js"></script>
<script src="${base}/static/js/inputmask/inputmask/inputmask.extensions.min.js"></script>

<script src="/static/js/fileupload/vendor/jquery.ui.widget.js"></script>
<script src="/static/js/fileupload/jquery.iframe-transport.js"></script>
<script src="/static/js/fileupload/jquery.fileupload.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-process.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-validate.js"></script>

<script src="${base}/static/js/localjs/placeholder.min.js"></script>
<script>
	$(function() {
		$('.chosen-select').chosen({disable_search_threshold: 10, width:'100%', max_selected_options: 3});
		$('[data-submenu]').submenupicker();
		});
		
		
		
		
		$('#position').change(function() {
			var roleIds = "";
			var position = "";
			$(this).find('option:selected').each(function() {
				if (roleIds.length > 0) {
					roleIds += ",";
				}
				roleIds += $(this).val();
				
				if (position.length > 0) {
					position += ",";
				}
				position += $(this).text();
			});
			
			$('[name="roleIds"]').val(roleIds);
			$('[name="position"]').val(position);
			
			
		}).trigger('change');
			
			
			
		
		
	        
		
		
		$('#userForm').bootstrapValidator({
			excluded: ':disabled',
        	message: 'This value is not valid',
        	feedbackIcons: {
	            valid: 'fa fa-check',
	            invalid: 'fa fa-times',
	            validating: 'fa fa-refresh'
	        },
        	fields: {
	            'username': {
	                validators: {
	                    notEmpty: { message: 'The name is required and cannot be empty' },
	                    stringLength: {
	                        max: 30,
	                        message: 'The username must be less than 30 characters'
	                    }
	                }
	            },
	            'password': {
	                validators: {
	                    notEmpty: { message: 'The password is required and cannot be empty' },
	                    stringLength: {
	                        min: 6,
	                        max: 20,
	                        message: 'The full password must be between 6 and 20 characters'
	                    },
	                    identical: {
	                        field: 'confirmPassword',
	                        message: 'The password and its confirm are not the same'
	                    }
	                }
	            },
	            'confirmPassword': {
	                validators: {
	                    notEmpty: { message: 'The password is required and cannot be empty' },
	                    identical: {
	                        field: 'password',
	                        message: 'The password and its confirm are not the same'
	                    }
	                }
	            },
	            'position': {
	                validators: {
	                    notEmpty: { message: 'The position is required and cannot be empty' }
	                }
	            },
	            postList: {
	            	validators: {
	            		choice: {
	                        min: 1,
	                        max: 2,
	                        message: 'Please choose 1 - 2 position'
	                    }
	            	}
	            },
	            'name': {
	                validators: {
	                    notEmpty: { message: 'The name is required and cannot be empty' },
	                    stringLength: {
	                        max: 20,
	                        message: 'The name must be less than 20 characters'
	                    }
	                }
	            }
	            
        	}
    	}).find('.chosen-select').chosen().change(function(e) {
        	$('#userForm').data('bootstrapValidator').updateStatus('position', 'NOT_VALIDATED').validateField('position');
        });;
		
		$('#save').click(function() {
			$('#userForm').data('bootstrapValidator').validate();
			if ($('#userForm').data('bootstrapValidator').isValid()) {
				var params = $('#userForm').serialize();
				
				$.post('${base}/user/save', params, function(data) {
					if (!data.success) {
						alert(data.message);
						return false;
					} 
					alert("操作成功!");
					window.location="${base}/user/list.html";
				//	$('#back').submit();
				}, 'json');
			}
		});
		$('#cancel').click(function() {
			window.history.back();
		});
	
</script>
