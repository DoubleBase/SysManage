$(function(){
	
	initTree();
	buildRoleGrid();
	buildFunRoleGrid();
});

buildRoleGrid = function(){
	$('#menuRole_table').bootstrapTable({
		url : 'system_Menu!getMenuRoleByMenuId.do',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		method : 'post',
		queryParams : function(params) {
			return {
				offset : params.offset,
				limit : params.limit,
				sortName : this.sortName,
				sortOrder : this.sortOrder,
				menuId :  curMenu.id 
			};
		},
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 20, 100 ], // 可供选择的每页的行数（*）
		toolbar : "#menuRole_toolbar",
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
			field : 'roleId',
			title : '角色ID',
			visible : false
		}, {
			field : 'roleName',
			title : '角色名称'
		}],
		onDblClickCell : function(field, value, row, $element) {

		},
		onLoadSuccess : function(data){
			for(var i=0;i<data.rows.length;i++){
				if(data.rows[i].checked==1){
					$('#menuRole_table').bootstrapTable("check",i);
				}
			}
		}
	});
};

buildMenuFunGrid = function(){
	$('#table_resource').bootstrapTable({
		url : 'system_Menu!queryFunByMenuId.do',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		method : 'post',
		queryParams : function(params) {
			return {
				offset : params.offset,
				limit : params.limit,
				menuId : curMenu.id
			};
		},
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 20, 100 ], // 可供选择的每页的行数（*）
		clickToSelect : true, // 是否启用点击选中行
		showColumns : true,
		showRefresh : true,
		columns : [ {
			checkbox : true
		},{
			field : 'funId',
			title : '功能ID',
			visible : false
		}, {
			field : 'funName',
			title : '功能名称',
			formatter:function(value, row, index){
				return "<div class='btn "+row.cls+"'><i class='"+row.icon+"'></i>&nbsp;"+value+"</div>";
			}
		}, {
			field : 'icon',
			title : '功能图标',
			visible : false
		}, {
			field : 'qtip',
			title : '提示信息',
			visible : false
		}, {
			field : 'menuId',
			title : '菜单ID',
			visible : false
		}, {
			field : 'orders',
			title : '排序号',
			visible : false
		}, {
			field : 'funtypeId',
			title : '功能类型',
			visible : false
		}, {
			field : 'url',
			title : '功能链接',
			visible : false
		}, {
			field : 'cls',
			title : '按钮样式',
			visible : false
		}],
		onDblClickCell : function(field, value, row, $element) {

		}
	});
}

var curMenu={}; 
var optType = 'add';
var funType = 'add';
var curFun = {};
initFormMenu = function(){
	optType = 'add';
	$('#id').removeAttr("disabled");
	$('#parent').attr("disabled","true");
	$('#id').val('');
	$('#text').val('');
	$('#parent').val(curMenu.original.id);
	$('#icon').val('');
	$('#url').val('');
	$('#targetType').val('');
	$('#sort').val('');
	$('#leaf').val('');
}

loadMenuInfo = function(){
	$('#id').attr("disabled","true");
	$('#parent').attr("disabled","true");
	$('#id').val(curMenu.original.id);
	$('#text').val(curMenu.original.text);
	$('#parent').val(curMenu.original.parent);
	$('#icon').val(curMenu.original.icon);
	$('#url').val(curMenu.original.url);
	$('#targetType').val(curMenu.original.targetType);
	$('#sort').val(curMenu.original.sort);
	$('#leaf').val(curMenu.original.isleaf);
}
initListeners = function(){
	$("#btn_add").on('click',function(){
		if(curMenu!=null){
			initFormMenu();
		}else{
			$.fn.modalAlert("请选择一个父节点","warning");
			return;
		}
		showMenuModal();
	})
	
	$("#btn_edit").on('click',function(){
		if(curMenu==null){
			$.fn.modalAler("请选择一个菜单节点","warning");
			return;
		}
		optType = "edit";
		showMenuModal();
		loadMenuInfo();
	})
	
	$("#btn_delete").on('click',function(){
		deleteMenu();
	})
	
	$("#btnReset").on('click',function(){
		loadMenuInfo();
	})
	
	$("#btnSave").on('click',function(){
		saveMenu();
	})
	
	$("#btn_role").on('click',function(){
		if(curMenu==null){
			$.fn.modalAler("请选择一个要绑定角色的菜单","warning");
			return;
		}
		bindMenuRole();
	})
	
	$("#btn_menurole_save").on('click',function(){
		saveMenuRole();
	})
	
	$("#addFun").on('click',function(){
		initFormFun();
		showFunctionModal();
	})
	$("#editFun").on('click',function(){
		var rows = $("#table_resource").bootstrapTable("getSelections");
		if(rows.length==0){
			$.fn.modalAlert("请选择要编辑的功能","warning");
			return;
		}else if(rows.length>1){
			$.fn.modalAlert("只能选择一个功能进行编辑","warning");
			return;
		}
		curFun = rows[0];
		funType = 'edit';
		loadFunInfo();
		showFunctionModal();
	})
	$("#delFun").on('click',function(){
		deleteFun();
	})
	$("#roleFun").on('click',function(){
		var rows = $("#table_resource").bootstrapTable("getSelections");
		if(rows.length==0){
			$.fn.modalAlert("请选择要绑定角色的功能","warning");
			return;
		}else if(rows.length>1){
			$.fn.modalAlert("只能选择一个功能进行绑定角色","warning");
			return;
		}
		curFun = rows[0];
		bindFunRole();
	})
	
	$("#btn_fun_save").on('click',function(){
		saveMenuFun();
	})
	
	$("#btn_funrole_save").on('click',function(){
		saveFunRole();
	})

}
refreshTree = function(){
	$('#menutree').jstree('refresh');
}

initTree = function(){
	$('#menutree').jstree(
		{
			"core" : {
				"animation" : 0,
				"check_callback" : true,
				"themes" : {
					"stripes" : true
				},
				'data' : {
					'url' : function(node) {
						 return  'system_Menu!getMenuTree.do';
					},
					'data' : function(node) {
						return {
							'id' : node.id
						};
					}
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
			"plugins" : ["search", "state", "types", "wholerow"]
		}).on('changed.jstree', function (e, data) {
			if(data.selected.length>0){
				curMenu = data.instance.get_node(data.selected[0]);
				buildMenuFunGrid();
				$('#table_resource').bootstrapTable('refresh');
			}
		});
		
}

showMenuModal = function(){
	if(optType=='add'){
		$('#id').removeAttr('disabled');
		$("#fnt_ModalLabel").text('添加菜单');
	}else if(optType=='edit'){
		$('#id').attr('disabled',true);
		$("#fnt_ModalLabel").text('修改菜单');
	}
	$('#optInfoModal').modal('show');
}

saveMenu = function(){
	if(checkValid()){
		return false;
	}
	var url = "system_Menu!updateMenu.do";
	if(optType=="add"){
		url = "system_Menu!addMenu.do";
	}else if(optType=="edit"){
		url = "system_Menu!updateMenu.do";
	}
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		url : url,
		type : 'post',
		data : {
			id : $("#id").val(),
			parent : $("#parent").val(),
			text : $("#text").val(),
			url : $("#url").val(),
			icon : $("#icon").val() ,
			targetType : $("#targetType").val(),
			sort : $("#sort").val(),
			isleaf : $("#leaf").val()
		},
		success : function(data) {
			App.unblockUI();
			if(data.success){
				$.fn.modalAlert(data.message,'success',function(){
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
		
	refreshTree();
}

deleteMenu = function(){
	$.fn.modalConfirm("确定要删除该节点吗（不可恢复）？", function(btn){
		if(btn==true){
			App.blockUI({
				boxed : true ,
				message: '处理中，请稍等...'
			});
			$.ajax({
				url : 'system_Menu!deleteMenu.do',
				type : 'post',
				data : {
					id : curMenu.id
				},
				success : function(data) {
					App.unblockUI();
					if(data.success){
						$.fn.modalAlert(data.message,'success');
						refreshTree();
					}else{
						$.fn.modalAlert(data.message,'error');
					}
				},
				error : function(){
					 App.unblockUI();
				}
			});
		}
	});
}

bindMenuRole = function(){
	$("#menuRoleModal").modal('show');
	$("#menuRole_table").bootstrapTable("refresh");
}

saveMenuRole = function(){
	var url = 'system_Menu!saveMenuRole.do';
	var rows = $('#menuRole_table').bootstrapTable('getSelections');
	var roleIds = '';
	for(var i=0;i<rows.length;i++){
		roleIds += rows[i].roleId+",";
	}
	if(roleIds.length>0){
		roleIds = roleIds.substring(0, roleIds.length-1);
	}
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		url : url,
		type : 'post',
		data : {
			menuId : curMenu.id,
			roleIds : roleIds
		},
		success : function(data) {
			App.unblockUI();
			if(data.success){
				$("#menuRoleModal").modal('hide');
				$.fn.modalMsg(data.message,'success');
				$('#menuRole_table').bootstrapTable('refresh');
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

initFormFun = function(){
	funType = 'add';
	$('#o_id').removeAttr("disabled");
	$('#o_id').val('');
	$('#o_text').val('');
	$('#o_icon').val('');
	$('#o_qtip').val('');
	$('#o_url').val('');
	$('#o_orders').val('');
	$('#o_functionTypeId').val('');
	$('#o_cls').val('');
}

loadFunInfo = function(){
	$('#o_id').attr("disabled","true");
	$('#o_id').val(curFun.funId);
	$('#o_text').val(curFun.funName);
	$('#o_icon').val(curFun.icon);
	$('#o_qtip').val(curFun.qtip);
	$('#o_url').val(curFun.url);
	$('#o_orders').val(curFun.orders);
	$('#o_functionTypeId').val(curFun.funtypeId);
	$('#o_cls').val(curFun.cls);
}

refershFun = function(){
	$("#table_resource").bootstrapTable("refresh");
}
showFunctionModal = function(){
	if(funType=='add'){
		$('#o_id').removeAttr('disabled');
		$("#fun_ModalLabel").text('添加功能');
	}else if(funType=='edit'){
		$('#o_id').attr('disabled',true);
		$("#fun_ModalLabel").text('修改功能');
	}
	$('#menuFunModal').modal('show');
}

notNull = function(){
	var isValid = false;
	$(".form-control").each(function(){
		if($(this).hasClass('funNotNull')){
			if($(this).val()==''||$(this).val()=="null"||$(this).val()==null){
				layer.tips($(this).attr('placeholder')+'不能为空!', $(this),{tipsMore: true});
				isValid = true;
				return isValid;
			}
		}
	});
	return isValid;
}

saveMenuFun = function(){
	if(notNull()){
		return;
	}
	var url = "system_Menu!updateMenuFun.do";
	if("add"==funType){
		url = "system_Menu!addMenuFun.do";
	}else if("edit"==funType){
		url = "system_Menu!updateMenuFun.do";
	}
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		type:'post',
		url:url,
		data:{
			funId:$('#o_id').val(),
			funName:$('#o_text').val(),
			icon:$('#o_icon').val(),
			qtip:$('#o_qtip').val(),
			menuId:curMenu.id,
			orders:$('#o_orders').val()==""?0:$('#o_orders').val(),
			funtypeId:$('#o_functionTypeId').val(),
			cls:$('#o_cls').val(),
			url:$('#o_url').val()
		},
		success:function(data){
			 App.unblockUI();
			if(data.success){
				$("#menuFunModal").modal('hide');
				$.fn.modalMsg(data.message,"success");
				refershFun();
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

deleteFun = function(){
	var rows = $("#table_resource").bootstrapTable("getSelections");
	if(rows.length==0){
		$.fn.modalAlert("请选择要删除的功能","warning");
		return;
	}
	var funIds = "";
	for(var i=0;i<rows.length;i++){
		funIds = funIds + rows[i].funId + ",";
	}
	funIds = funIds.substring(0,funIds.length-1);
	$.fn.modalConfirm("确定要删除该功能吗？", function(btn){
		if(btn==true){
			App.blockUI({
				boxed : true ,
				message: '处理中，请稍等...'
			});
			$.ajax({
				url : 'system_Menu!deleteMenuFun.do',
				type : 'post',
				data : {
					funIds : funIds
				},
				success : function(data) {
					App.unblockUI();
					if(data.success){
						$.fn.modalAlert(data.message,'success');
						refershFun();
					}else{
						$.fn.modalAlert(data.message,'error');
					}
				},
				error : function(){
					 App.unblockUI();
					 $.fn.modalAlert("请求失败!",'error');
				}
			});
		}
	});
}

buildFunRoleGrid = function(){
	$('#funRole_table').bootstrapTable({
		url : 'system_Menu!getFunRoleByfunId.do',
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		method : 'post',
		queryParams : function(params) {
			return {
				offset : params.offset,
				limit : params.limit,
				sortName : this.sortName,
				sortOrder : this.sortOrder,
				funId :  curFun.funId 
			};
		},
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 20, 100 ], // 可供选择的每页的行数（*）
		toolbar : "#funRole_toolbar",
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
			field : 'roleId',
			title : '角色ID',
			visible : false
		}, {
			field : 'roleName',
			title : '角色名称'
		}],
		onDblClickCell : function(field, value, row, $element) {

		},
		onLoadSuccess : function(data){
			for(var i=0;i<data.rows.length;i++){
				if(data.rows[i].checked==1){
					$('#funRole_table').bootstrapTable("check",i);
				}
			}
		}
	});
};

bindFunRole = function(){
	$("#funRoleModal").modal('show');
	$('#funRole_table').bootstrapTable("refresh");
}

saveFunRole = function(){
	var rows = $('#funRole_table').bootstrapTable('getSelections');
	var roleIds = '';
	for(var i=0;i<rows.length;i++){
		roleIds += rows[i].roleId+",";
	}
	if(roleIds.length>0){
		roleIds = roleIds.substring(0, roleIds.length-1);
	}
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		url : "system_Menu!saveFunRole.do",
		type : 'post',
		data : {
			funId : curFun.funId,
			roleIds : roleIds
		},
		success : function(data) {
			App.unblockUI();
			if(data.success){
				$("#funRoleModal").modal('hide');
				$.fn.modalMsg(data.message,'success');
				$('#funRole_table').bootstrapTable('refresh');
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