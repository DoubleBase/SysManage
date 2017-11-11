var DEFAULT_PASSWORD = '123456';

$(function(){
	initListeners();
	buildGrid();
})

initUserObject = function(){
	return {
		userId :'',
		userName :'',
		password :'',
		email:'',
		telephone :'',
		rePassword :'',
		pwd :'',
		rePwd :''
	};
}

buildGrid = function(){
	$('#table_resource').bootstrapTable({
		url : 'system_User!queryUserList.do',
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
		pageSize : 5, // 每页的记录行数（*）
		pageList : [ 5,10, 20, 100 ], // 可供选择的每页的行数（*）
		toolbar : "#toolbar",
		clickToSelect : true, // 是否启用点击选中行
		sortName : 'id',
		sortOrder : 'desc',
		showColumns : true,
		showRefresh : true,
		columns : [ {
			checkbox : true
		},{
			field : 'userId',
			title : '用户ID'
		}, {
			field : 'userName',
			title : '用户名称'
		}, {
			field : 'email',
			title : '邮箱地址'
		}, {
			field : 'telephone',
			title : '联系电话'
		},{
			field : 'reset',
			title : '重置密码',
			formatter:function(value, row, index){
				return "<div class='btn btn-primary' onclick='showRestPwd("+row.userId+")'><i class='fa fa-history'></i></div>";
			},
			width : 40
		}],
		onDblClickCell : function(field, value, row, $element) {

		}
	});
}

showResetPwd = function(){

}

initListeners = function(){
	$("#btn_add").on('click',function(){
		optUser = "add";
		showOptModal();
		$('#o_password').val(DEFAULT_PASSWORD);
		$('#o_rePassword').val(DEFAULT_PASSWORD);
	})
	
	$("#btn_edit").on('click',function(){
		optUser = "edit";
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
		$('#o_userId').val(rows[0].userId);
		$('#o_userName').val(rows[0].userName);
		$('#o_password').val(rows[0].password);
		$('#o_rePassword').val(rows[0].password);
		$('#o_mobilePhone').val(rows[0].telephone);
		$('#o_email').val(rows[0].email);
	})
	
	$("#btn_delete").on('click',function(){
		deleteUser();
	})
	
	$('#btn_save').on('click',function(){
		saveUser();
	});
	
	$("#btn_role").on('click',function(){
		bindUserRole();
	})
	
	$("#btn_reset").on('click',function(){
		resultPwd();
	})
}

var optUser = 'add';

var resetUserId = '';

var curUser = initUserObject();

showOptModal = function(){
//	loadFormInfo(curUser);
	var ui = document.getElementById("pwd");
	var ui_ = document.getElementById("rePwd");
	if('add'==optUser){
		$('#o_userId').removeAttr('disabled');
		$("#fnt_ModalLabel").text("添加用户");
		ui.style.display = "";
		ui_.style.display = "";
		
	}else if("edit"==optUser){
		$('#o_userId').attr('disabled',true);
		$("#fnt_ModalLabel").text("修改用户");
		ui.style.display = "none";
        ui_.style.display = "none";
	}
	$("#optInfoModal").modal('show');
}

saveUser = function(){
	
	if(checkValid()){
		return false;
	}
	var userId = $('#o_userId').val();
	var password = $('#o_password').val();
	var rePassword = $('#o_rePassword').val();
	var mobilePhone = $('#o_mobilePhone').val();
	var email = $("#o_email").val();
	var reg = /^(?![^a-zA-Z]+$)(?!\D+$).{8,}$/;
	var regPhone = /^1[3|4|5|7|8][0-9]\d{4,8}$/;
	var regEmail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	if(mobilePhone.length > 0)
	{
		if(!regPhone.test(mobilePhone))
		{
			$.fn.modalAlert('不是完整的11位手机号或者正确的手机号前七位！');
			return;
		}
	}
	if(email.length > 0){
		if(!regEmail.test(email)){
			$.fn.modalAlert('不是正确的邮箱格式');
			return;
		}
	}
	
	if(optUser=='add')
	{
		if(password != rePassword)
		{
			$.fn.modalAlert('两次密码必须一致！','warning');
			return;
		}
		if(password.length < 6)
		{
			$.fn.modalAlert('密码长度至少为6位！','warning');
			return;
		}
		/*if(!reg.test(password))
		{
			$.fn.modalAlert('密码必须包含数字加字母！');
			return;
		}*/
		url='system_User!addUser.do';
		password = hex_md5(userId+password);
	}
	else if(optUser=='edit')
	{
		url='system_User!updateUser.do';
	}
	
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		url : url,
		type : 'post',
		data : {
			userId : $('#o_userId').val(),
			userName : $('#o_userName').val(),
			password : password,
			telephone : mobilePhone,
			email : email
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

deleteUser = function(){
	handleDelete('system_User!deleteUser.do');
}

bindUserRole = function(){
	var rows = $("#table_resource").bootstrapTable("getSelections");
	if(rows.length==0){
		$.fn.modalAlert("请选择一个用户","warning");
		return;
	}else if(rows.length>1){
		$.fn.modalAlert("只能选择一个用户","warning");
		return;
	}
	
	$.fn.modalOpen({
		title:rows[0].userName+"————绑定角色",
		url:"system_UserRole!view.do?userId="+rows[0].userId,
		callback:function(){
			
		}
	})
}

var resetUserId;
showRestPwd = function(row){
	
	$('#o_pwd').val(DEFAULT_PASSWORD);
	$('#o_rePwd').val(DEFAULT_PASSWORD);
	$("#reset_Label").text('修改用户');
	$('#resetPwdModal').modal('show');
	resetUserId = row;
}

resultPwd = function(){
	
	var pwd = $('#o_pwd').val();
	var repwd = $('#o_rePwd').val();
	if(pwd != repwd){
		$.fn.modalAlert('两次密码必须一致！','warning');
		return;
	}
	if(pwd.length < 6){
		$.fn.modalAlert('密码长度至少为6位！','warning');
		return;
	}
	
	App.blockUI({
		boxed : true ,
		message: '处理中，请稍等...'
	});
	$.ajax({
		url : "system_User!resetPwd.do",		
		type : 'post',
		data : {
			userId : resetUserId,
			password : hex_md5(resetUserId+pwd)
		},
		success : function(data) {
			App.unblockUI();
			if(data.success){
				$.fn.modalMsg(data.message,'success');
				$("#table_resource").bootstrapTable("refresh");
				$('#resetPwdModal').modal('hide');
				$.fn.modalAlert.closeOnCallBack();
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