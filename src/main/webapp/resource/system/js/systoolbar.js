$(function(){
	var contentId = "systoolbar-content";
	var menuId = $("#menuId").val();
	var pageContentBody = $('#' + contentId);
	var url = "system_SysToolbar!getRoleFunctionList.do?menuId=" + menuId;

	App.blockUI({
		target : '#' + contentId,
		boxed : true
	});
	$.get(url, {}, function(res) {
		var btns = getRoleFunctionButtons(res);
		pageContentBody.html(btns);
		
		initListeners();
		
		App.unblockUI('#' + contentId);
	});
})

getRoleFunctionButtons = function(res) {
	var html = '';
	for(var index in res){
		html += '<button id="'+res[index].url+'" class="btn '+res[index].cls+' " type="button"><i class="'+res[index].icon+'"></i>&nbsp'+res[index].funName+'</button> ';
	}
	return html;
}