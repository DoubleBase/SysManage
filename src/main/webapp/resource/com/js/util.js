getNotNullValue = function(value){
	if(value==null||value==undefined)
		return "";
	return value;
}

base_valid_is_empty = function(id){
	if($('#'+id).val()=='' || $('#'+id).val().length<=0){
		return true;
	}
	return false;
}

checkValid = function(){
	var isValid = false;
	$(".form-control").each(function(){
		if($(this).hasClass('notnull')){
			if($(this).val()==''||$(this).val()=="null"||$(this).val()==null){
				layer.tips($(this).attr('placeholder')+'不能为空!', $(this),{tipsMore: true});
				isValid = true;
				return isValid;
			}
		}
	});
	return isValid;
}

handleDeleteWithDomId = function(url,param,domid){
	
	var rows = $('#'+domid).bootstrapTable('getSelections');
	if (rows.length == 0) {
		$.fn.modalAlert('请选择一条需要删除的数据！','warning');
		return;
	}
	
	if(param!=undefined){
		param['dataList'] = JSON.stringify(rows);
	}else{
		param = {
			dataList : JSON.stringify(rows)
		};
	}
	
	$.fn.modalConfirm('是否删除该数据？', function(btn){
		
		if(btn==true){
			App.blockUI({
		        boxed: true
		    });
			
			$.ajax({
				url : url,
				type : 'post',
				data : param,
				success : function(data) {
					App.unblockUI();
					$.fn.modalAlert(data.message,'success',function(){
						if (data.success) {
							$('#'+domid).bootstrapTable('refresh');
						}
						$.fn.modalAlert.closeOnCallBack();
					});
					
				}
			});
		}
		
		
	});
}

handleDelete = function(url,param){
	handleDeleteWithDomId(url,param,'table_resource');
}