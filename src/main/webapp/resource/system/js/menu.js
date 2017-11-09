$(function(){
	
	initListeners();
	initTree();
})

var curMenu={}; 
var optType = 'add';

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

}
refreshTree = function(){
	$('#menutree').jstree('refresh');
}

initTree = function(){
	//menutree
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
			"plugins" : ["search", "state", "types", "wholerow" ,"dnd"]
		}).on('select_node.jstree', function (e, data) {
			if(data.selected.length>0){
				curMenu = data.instance.get_node(data.selected[0]);
//				loadMenuInfo();
			}
		});
		
	$("#menutree").on('move_node.jstree', function(e,data){
		
		
	})
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