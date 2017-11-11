<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>用户管理</title>
    
    <script src="resource/com/js/include.js"></script>
    <script src="resource/com/js/md5.js"></script>
    <script src="resource/system/js/systoolbar.js"></script>
    <script src="resource/system/js/user.js"></script>
	
  </head>
  
  <body>
   		<div class="container-fluid" style="padding-top : 20px;">
			<div class="box box-success">
				<div class="box-header">
						<i class="fa fa-list-ul"></i>
						<h3 class="box-title">用户管理</h3>
				</div>
				<div id="toolbar" class="row">
					<div class="col-sm-12" id="systoolbar-content">
					</div>
				</div>
				<div style="display:none;">
					<input type="text" id="menuId" value=${menuId} >
				</div>
				<table id="table_resource"></table>
			</div>
		</div>
		<div id="optInfoModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="fnt_ModalLabel" style="height:500px;">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 id="fnt_ModalLabel" class="modal-title">
							
						</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" role="form">
						<div class="form-group">
								<label for="o_userId" class="col-sm-3 control-label">
									用户ID
								</label>
								<div class="col-sm-9">
									<input type="text" class="form-control notnull" id="o_userId" placeholder="用户ID（必须为数字）">
								</div>
							</div>
							<div class="form-group">
								<label for="o_userName" class="col-sm-3 control-label">
									用户名称
								</label>
								<div class="col-sm-9">
									<input type="text" class="form-control notnull" id="o_userName" placeholder="用户名称">
								</div>
							</div>
							<div class="form-group" id ="pwd">
								<label for="o_password" class="col-sm-3 control-label">
									用户密码
								</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="o_password" placeholder="用户密码">
								</div>
							</div>
							<div class="form-group" id = "rePwd">
								<label for="o_rePassword" class="col-sm-3 control-label">
									确认密码
								</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="o_rePassword" placeholder="确认密码">
								</div>
							</div>
							<div class="form-group">
								<label for="o_email" class="col-sm-3 control-label">
									邮箱
								</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="o_email" placeholder="邮箱">
								</div>
							</div>
							<div class="form-group">
								<label for="o_mobilePhone" class="col-sm-3 control-label">
									手机号码
								</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="o_mobilePhone" placeholder="手机号码">
								</div>
							</div>
							<hr>
							<div style="font-size:14px;">
								<label align="left">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*密码长度不小于6位，且必须同时包含数字和字母。
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*初始密码默认为123456。
								</label>
								<br>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="btn_save">
							<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;保存
						</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp;取消
						</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="resetPwdModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="reset_Label" style="height:500px;">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 id="reset_Label" class="modal-title">
							
						</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="o_pwd" class="col-sm-3 control-label">
									用户密码
								</label>
								<div class="col-sm-9">
									<input type="password" class="form-control notNull" id="o_pwd" placeholder="用户密码">
								</div>
							</div>
							<div class="form-group">
								<label for="o_rePwd" class="col-sm-3 control-label">
									确认密码
								</label>
								<div class="col-sm-9">
									<input type="password" class="form-control notNull" id="o_rePwd" placeholder="确认密码">
								</div>
							</div>
							<hr>
							<div style="font-size:14px;">
								<label align="left">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*密码长度不小于6位
									<br>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*初始密码默认为123456
								</label>
								<br>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="btn_reset">
							<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;保存
						</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp;取消
						</button>
					</div>
				</div>
			</div>
		</div>
  </body>
</html>
