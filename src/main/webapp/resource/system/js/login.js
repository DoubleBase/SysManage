
$(function(){
	
	$("#userId").val("71497");
	$("#password").val("123456");
	
	$("#login_btn").on('click',function(event){
		event.preventDefault();
		login();
	})

})

showResultMessage = function(message){
	$('#result_info').html(message);
}

formInValid = function(){
	if(base_valid_is_empty('userId')){ 
		showResultMessage('请输入用户名!');
	 	return true;
	}else{
		showResultMessage('&nbsp;');
	}
	
	if(base_valid_is_empty('password')){ 
		showResultMessage('请输入密码!');
	 	return true;
	}else{
		showResultMessage('&nbsp;');
	}
	return false;
}

login = function(){
	if(!formInValid){
		return;
	}
	$.ajax({
		type:'POST',
		url:'system_Login!login.do',
		data:{
			userId:$("#userId").val(),
			password:hex_md5($('#userId').val()+$('#password').val())
		},
		success:function(data){
			if(data.success){
				showResultMessage(data.message);
				if(data.redirectUrl && data.redirectUrl!="null"){
					window.location = data.redirectUrl;
				}else{
					window.location = "system_Frame!view.do";
				}
			}else{
				showResultMessage(data.message);
			}
		}
	})
}