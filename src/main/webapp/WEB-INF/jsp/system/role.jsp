<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>角色管理</title>
    
    <script src="resource/com/js/include.js"></script>
    <script src="resource/system/js/systoolbar.js"></script>
    <script src="resource/system/js/role.js"></script>

  </head>
  
  <body>
  		<div class="container-fluid" style="padding-top : 20px;">
			<div class="box box-success">
				<div class="box-header">
						<i class="fa fa-list-ul"></i>
						<h3 class="box-title">角色管理</h3>
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
							Modal title
						</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" role="form">
						<div class="form-group">
								<label for="o_roleId" class="col-sm-3 control-label">
									角色ID
								</label>
								<div class="col-sm-9">
									<input type="text" class="form-control notnull" id="o_roleId" placeholder="角色ID（必须为数字）">
								</div>
							</div>
							<div class="form-group">
								<label for="o_roleName" class="col-sm-3 control-label">
									角色名称
								</label>
								<div class="col-sm-9">
									<input type="text" class="form-control notnull" id="o_roleName" placeholder="角色名称">
								</div>
							</div>
							<div class="form-group">
								<label for="o_roleType" class="col-sm-3 control-label">
									角色类型
								</label>
								<div class="col-sm-9">
									<select id="o_roleType" class="form-control notnull" placeholder="角色类型">
		                                <option value="1">有效</option>
		                                <option value="0">无效</option>
		                        	</select>
								</div>
							</div>
							<div class="form-group">
								<label for="o_roleLevel" class="col-sm-3 control-label">
									角色等级
								</label>
								<div class="col-sm-9">
									<select id="o_roleLevel" class="form-control notnull" placeholder="角色等级">
		                                <option value="1">1</option>
		                                <option value="2">2</option>
		                                <option value="3">3</option>
		                                <option value="4">4</option>
		                                <option value="5">5</option>
		                                <option value="6">6</option>
		                                <option value="7">7</option>
		                                <option value="8">8</option>
		                                <option value="9">9</option>
		                                <option value="10">10</option>
		                        	</select>
								</div>
							</div>
							<div class="form-group">
								<label for="o_roleOperatelevel" class="col-sm-3 control-label">
									角色可操作等级
								</label>
								<div class="col-sm-9">
									<select id="o_roleOperatelevel" class="form-control notnull" placeholder="角色可操作等级">
		                                <option value="1">1</option>
		                                <option value="2">2</option>
		                                <option value="3">3</option>
		                                <option value="4">4</option>
		                                <option value="5">5</option>
		                                <option value="6">6</option>
		                                <option value="7">7</option>
		                                <option value="8">8</option>
		                                <option value="9">9</option>
		                                <option value="10">10</option>
		                        	</select>
								</div>
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
		
		<div id="bdMenu" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="MenuModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 id="MenuModalLabel" class="modal-title">
							Modal title
						</h4>

					</div>
					<div class="modal-body">
						<div id="RoleMenutable"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="btn_menu_save">
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
