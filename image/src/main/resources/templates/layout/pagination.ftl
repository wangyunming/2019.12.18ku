<#setting classic_compatible=true>

<link href="${base}/static/css/pagination.css" rel="stylesheet" />
<input type="hidden" name="currPage" id="currPage" value="${page.pageNum}">
<input type="hidden" name="pages" id="pages" value="${page.pages}">
<div style="float: left; margin: 10px 0px; border: 1px solid #ccc; padding: 3px 18px;">共有 <label style="color: red;">${page.total}</label> 条数据</div>
<div id="Pagination" class="pagination" ></div>

<script type="text/javascript" src="${base}/static/js/jquery.min.js" charset="UTF-8"></script>
<script src="${base}/static/js/jquery/jquery.pagination.js" charset="UTF-8"></script>
<script type="text/javascript">
	var pages = parseInt($("#pages").val());
	var currPage = parseInt($("#currPage").val());
	
	$("#Pagination").pagination(pages, {
		current_page : currPage > 0 ? currPage - 1 : currPage,
		num_edge_entries : 2,
		num_display_entries : 3,
		callback : function( page ) {
			$("#queryForm").append('<input type="hidden" value="' + (++page) + '" name="pageNum">').submit();
		},
		items_per_page : 1
	});
</script>