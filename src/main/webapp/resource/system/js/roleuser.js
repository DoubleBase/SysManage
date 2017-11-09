$(function(){
	initListeners();
	buildGrid();
})

initListeners = function(){

	$('#btn_role_save').on('click', function() {
		saveRoleUser();
	});
}

buildGrid = function(){
	$('#table_resource').bootstrapTable({
		url : 'system_RoleUser!getRoleUserByRoleId.do',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		method : 'post',
		queryParams : function(params) {
			return {
				offset : params.offset,
				limit : params.limit,
				sortName : this.sortName,
				sortOrder : this.sortOrder,
				roleId :  roleId 
			};
		},
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 20, 100 ], // 可供选择的每页的行数（*）
		toolbar : "#toolbar",
		clickToSelect : true, // 是否启用点击选中行
		sortName : 'id',
		sortOrder : 'desc',
		// singleSelect:true,
		showColumns : true,
		showRefresh : true,
		columns : [ {
			checkbox : true,
			width : '20'
		},{
			field : 'userId',
			title : '用户ID'
		}, {
			field : 'userName',
			title : '用户名称'
		},{
			field : 'email',
			title : '邮箱'
		}],
		onDblClickCell : function(field, value, row, $element) {

		},
		onLoadSuccess : function(data){
			for(var i=0;i<data.rows.length;i++){
				if(data.rows[i].checked==1){
					$('#table_resource').bootstrapTable("check",i);
				}
			}
		}
	});
}

saveRoleUser = function(){
	var url = 'system_RoleUser!saveRoleUser.do';
	var rows = $('#table_resource').bootstrapTable('getSelections');
	var userIds = '';
	for(var i=0;i<rows.length;i++){
		userIds += rows[i].userId+",";
	}
	if(userIds.length>0){
		userIds = userIds.substring(0, userIds.length-1);
	}
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		url : url,
		type : 'post',
		data : {
			roleId : roleId,
			userIds : userIds
		},
		success : function(data) {
			App.unblockUI();
			if(data.success){
				/*$.fn.modalAlert(data.message,'success',function(){
					$('#table_resource').bootstrapTable('refresh');
					$.fn.modalAlert.closeOnCallBack();
				});*/
				$.fn.modalMsg(data.message,'success');
				$('#table_resource').bootstrapTable('refresh');
			}else{
				$.fn.modalAlert(data.message,'error');
			}
		},
		error : function(error) {
			 App.unblockUI();
			 $.fn.modalAlert('请求失败','error');
		}
	});
}