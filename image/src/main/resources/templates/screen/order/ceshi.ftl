<#setting classic_compatible=true>


 <link rel="stylesheet" href="${base}/static/css/sidebar.css" type="text/css" media="screen"/>
 <link rel="stylesheet" href="${base}/static/css/jquery.fileupload.min.css">
<link rel="stylesheet" href="${base}/static/css/new/base.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/new/header-step.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="${base}/static/css/localcss/bootstrap.min.css">
<link rel="stylesheet" href="${base}/static/css/localcss/font-awesome.min.css">
<link rel="stylesheet" href="${base}/static/css/localcss/ionicons.min.css">
<link rel="stylesheet" href="${base}/static/css/animate.css">

<link rel="stylesheet" href="${base}/static/css/plugins/jquery.steps.css">
<link rel="stylesheet" href="${base}/static/css/plugins/pace.min.css">

<link rel="stylesheet" href="${base}/static/css/chosen.css">
<link rel="stylesheet" href="${base}/static/css/style.css">
<link rel="stylesheet" href="${base}/static/css/skin.css">

<div class="mainbav">
  <div class="container">
    <div class="mainbav-logo"><a href="${base}/order/select-order-type.html"><img src="${base}/static/images/new/好印Logo-黑.png" style="margin-top:-12px;"  alt=""/></a></div>
    <div class="mainbav-logo"><div style="font-size:25px;margin-left:60px;color:black"></div></div>
    <!-- <div class="I_step"><img src="${base}/static/images/new/01_03.png" width="600" height="20"  alt=""/>
      <ul>
        <li class="red">我要下单</li>
        <li>支付订单</li>
        <li>上传文件</li>
        <li>等待审核</li>
        <li>等待收货</li>
      </ul>
    </div> -->
  </div>
</div>

<div class="bjf7 p20 of">
  <div class="user of">
		 <#include "/layout/sidebar.ftl">
	    <div class="user-con pb0">
	  		<div class="right_con" style="display: flex;text-align: center;">
	  		
	          	<div class="col-md-5"> <a href="javascript:;" class="thumbnail fileinput-button">
	            <input id="logoUpload" type="file" title="请选择上传的Logo文件" />
	            <img id="logo" options="size=138x138&bgcolor=#6b7e8c&color=#ffffff&text=支付凭证&fsize=16" class="placeholder" src="" onerror="this.src=placeholder.getData({text: 'Image 404'})" /> </a> </div>
	            <input type="hidden" name="logo" />
				
				

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



<script src="${base}/static/js/localjs/jquery-2.2.2.min.js"></script>
<script src="${base}/static/js/localjs/bootstrap.min.js"></script>
<script src="${base}/static/js/plugins/pace.min.js"></script>
<script src="${base}/static/js/plugins/metisMenu.min.js"></script>
<script src="${base}/static/js/app.js"></script>

<script src="${base}/static/js/plugins/jquery.steps.min.js"></script>
<script src="${base}/static/js/localjs/chosen.jquery.min.js"></script>
<script src="${base}/static/js/localjs/bootstrapValidator.js"></script>
<script src="${base}/static/js/inputmask/inputmask/inputmask.min.js"></script>
<script src="${base}/static/js/inputmask/inputmask/jquery.inputmask.bundle.min.js"></script>
<script src="${base}/static/js/inputmask/inputmask/inputmask.phone.extensions.min.js"></script>
<script src="${base}/static/js/inputmask//inputmask/inputmask.extensions.min.js"></script>
<script src="${base}/static/js/localjs/placeholder.min.js"></script>

<script src="${base}/static/js/fileupload/vendor/jquery.ui.widget.js"></script>
<script src="${base}/static/js/fileupload/jquery.iframe-transport.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-process.js"></script>
<script src="${base}/static/js/fileupload/jquery.fileupload-validate.js"></script>

<script src="${base}/static/js/localjs/formValidation.min.js"></script>
<script src="${base}/static/js/localjs/validator/bootstrap.min.js"></script>
<script src="${base}/static/js/localjs/formValidation_zh_CN.js"></script>




<script>

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
			$('[name="logo"]').val( result.obj.logo );
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
	
</script>


