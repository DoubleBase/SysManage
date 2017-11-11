$(function(){
	
	initListeners();
	
	buildGrid();
})

initRoleObject = function(){
	return {
		roleId :'',
		roleName :'',
		roleType :'',
		roleLevel:'',
		roleOperateLevel :''
	};
}

buildGrid = function(){
	$('#table_resource').bootstrapTable({
		url : 'system_Role!queryRoleList.do',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		method : 'post',
		queryParams : function(params) {
			return {
				offset : params.offset,
				limit : params.limit,
				sortName : this.sortName,
				sortOrder : this.sortOrder
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
		showColumns : true,
		showRefresh : true,
		columns : [ {
			checkbox : true
		},{
			field : 'roleId',
			title : '角色ID'
		}, {
			field : 'roleName',
			title : '角色名称'
		}, {
			field : 'roleType',
			title : '角色类型',
			formatter:yesnoFormatter
		}, {
			field : 'roleLevel',
			title : '角色等级'
		},{
			field : 'roleOperateLevel',
			title : '角色可操作等级',
			width : 40
		}],
		onDblClickCell : function(field, value, row, $element) {

		}
	});
}

function yesnoFormatter(value, row, index) {
    if(value==0){
    	return '无效';
    }else if(value==1){
    	return '有效';
    }
    return value;
}

initListeners = function(){
	$("#btn_add").on('click',function(){
		optRole = "add";
		showOptModal();
	})
	
	$("#btn_edit").on('click',function(){
		optRole = "edit";
		var rows = $('#table_resource').bootstrapTable('getSelections');
		if (rows.length == 0) {
			$.fn.modalAlert('请选择一条需要修改的数据！','warning');
			return;
		}else if(rows.length>1){
			$.fn.modalAlert('只能选择一条数据进行修改！','warning');
			return;
		}
		curUser = rows[0];
		showOptModal();
		$('#o_roleId').val(rows[0].roleId);
		$('#o_roleName').val(rows[0].roleName);
		$('#o_roleType').val(rows[0].roleType);
		$('#o_roleLevel').val(rows[0].roleLevel);
		$('#o_roleOperatelevel').val(rows[0].roleOperateLevel);
	})
	
	$("#btn_delete").on('click',function(){
		deleteRole();
	})
	
	$('#btn_save').on('click',function(){
		saveRole();
	});
	
	$("#btn_menu").on('click',function(){
		bindRoleMenu();
	})
	
	$("#btn_user").on('click',function(){
		bindRoleUser();
	})
	
	$("#btn_menu_save").on('click',function(){
		saveRoleMenu();
	})
}

var optRole = 'add';

var resetRoleId = '';

var curRole = initRoleObject();

showOptModal = function(){
//	loadFormInfo(curRole);
	if('add'==optRole){
		$('#o_roleId').removeAttr('disabled');
		$("#fnt_ModalLabel").text("添加角色");
		
	}else if("edit"==optRole){
		$('#o_roleId').attr('disabled',true);
		$("#fnt_ModalLabel").text("修改角色");
	}
	$("#optInfoModal").modal('show');
}

saveRole = function(){
	
	if(checkValid()){
		return false;
	}
	var roleId = $('#o_userId').val();
	var roleName = $('#o_roleName').val();
	var roleType = $('#o_roleType').val();
	var roleLevel = $('#o_roleLevel').val();
	var roleOperateLevel = $("#o_roleOperatelevel").val();
	
	if(optRole=='add'){
		url='system_Role!addRole.do';
	}else if(optRole=='edit'){
		url='system_Role!updateRole.do';
	}
	if(Number(roleOperateLevel) - Number(roleLevel) >= 0){
		$.fn.modalAlert('角色等级必须大于角色可操作等级！','warning');
		roleLevel = '';
		roleOperateLevel = '';
		return;
	}
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		url : url,
		type : 'post',
		data : {
			roleId : $('#o_roleId').val(),
			roleName : roleName,
			roleType : roleType,
			roleLevel : roleLevel,
			roleOperateLevel : roleOperateLevel
		},
		success : function(data) {
			App.unblockUI();
			if(data.success){
				$.fn.modalAlert(data.message,'success',function(){
					$("#table_resource").bootstrapTable("refresh");
					$('#optInfoModal').modal('hide');
					$.fn.modalAlert.closeOnCallBack();
				});
				
			}else{
				$.fn.modalAlert(data.message,'error');
			}
		},
		error : function() {
			 App.unblockUI();
			 $.fn.modalAlert('请求失败','error');
		}
	});
}

deleteRole = function(){
	handleDelete('system_Role!deleteRole.do');
}

bindRoleUser = function(){
	var rows = $("#table_resource").bootstrapTable("getSelections");
	if(rows.length==0){
		$.fn.modalAlert("请选择一个角色","warning");
		return;
	}else if(rows.length>1){
		$.fn.modalAlert("只能选择一个角色","warning");
		return;
	}
	
	$.fn.modalOpen({
		title:rows[0].roleName+"————绑定用户",
		url:"system_RoleUser!view.do?roleId="+rows[0].roleId,
		callback:function(){
			
		}
	})
}

var roleId;
var selectNode = [];
bindRoleMenu = function(){
	var rows = $("#table_resource").bootstrapTable("getSelections");
	if(rows.length==0){
		$.fn.modalAlert("请选择一需要绑定菜单的角色","warning");
		return;
	}else if(rows.length>1){
		$.fn.modalAlert("只能选择一个绑定菜单的角色","warning");
		return;
	}
	roleId = rows[0].roleId;
	$("#MenuModalLabel").text("绑定菜单");
	$("#bdMenu").modal("show");
	$('#RoleMenutable').data('jstree', false).empty();
	$('#RoleMenutable').jstree({
		"core" : {
			"animation" : 0,
			"check_callback" : true,
			"themes" : {
				"stripes" : true
			},
			'data' : {
				'url':'system_Role!getRoleMenuByRoleId.do?roleId='+rows[0].roleId
			}
		},
		"types" : {
			"root" : {
				"icon": "fa fa-folder icon-state-warning icon-lg",
				"valid_children" : [ "default" ]
			},
			"default" : {
				"valid_children" : [ "default", "file" ]
			},
			"file" : {
				 "icon": "fa fa-file icon-state-warning icon-lg",
				 "valid_children" : []
			}
		},
		"plugins" : ["checkbox","types","wholerow"],
		"checkbox":{
			"cascade":"up+undetermined",
			"three_state": false
		}
	}).on("changed.jstree",function(e,data){
		selectNode = data.selected;
	});
	
}

saveRoleMenu = function(){
	var menuIds = "";
	for(var i=0;i<selectNode.length;i++){
		menuIds = menuIds + selectNode[i] + ",";
	}
	menuIds = menuIds.substring(0,menuIds.length-1);
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		type:'post',
		url:'system_Role!saveRoleMenu.do',
		data:{
			roleId:roleId,
			menuIds:menuIds
		},
		success:function(data){
			 App.unblockUI();
			if(data.success){
				$('#bdMenu').modal('hide');
				$.fn.modalMsg(data.message,"success");
			}else{
				$.fn.modalAlert(data.message,"error");
			}
		},
		error:function(){
			 App.unblockUI();
			$.fn.modalAlert("请求失败!","error");
		}
	})
}
