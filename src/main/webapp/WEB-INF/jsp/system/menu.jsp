<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>菜单管理</title>
    
    <script src="resource/com/js/include.js"></script>
    <script src="resource/system/js/systoolbar.js"></script>
    <script src="resource/system/js/menu.js"></script>
	
  </head>
  
  <body>
   	<div class="container-fluid" style="padding-top : 20px;">
		<div class="col-md-6">
			<div class="box box-success">
				<div class="box-header">
					<i class="fa fa-list-ul"></i>
					<h3 class="box-title">菜单管理</h3>
				</div>
				<div class="box-body">
					<div id="menutree" class="tree-demo"></div>
				</div>
				<div class="box-footer">
					<div id="toolbar" class="row">
						<div class="col-sm-12" id="systoolbar-content">
						</div>
					</div>
					<div style="display:none;">
						<input type="text" id="menuId" value=${menuId} >
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="box box-info">
				<div class="box-header">
					<i class="fa fa-list-ul"></i>
					<h3 class="box-title">功能信息</h3>
				</div>
				<div class="box-body">
					<div><table id="table_resource"></table></div>
				</div>
				<div class="box-footer">
					<div id="toolbar" class="row">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success" id="addFun">
								<i class="glyphicon glyphicon-plus"></i>&nbsp;添加功能
							</button>
							<button type="submit" class="btn btn-warning" id="editFun">
								<i class="glyphicon glyphicon-pencil"></i>&nbsp;修改功能
							</button>
							<button type="submit" class="btn btn-danger" id="delFun">
								<i class="glyphicon glyphicon-minus"></i>&nbsp;删除功能
							</button>
							<button type="submit" class="btn btn-info" id="roleFun">
								<i class="fa fa-group"></i>&nbsp;绑定角色
							</button>
						</div>
					</div>
				</div>
			</div>
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
				<div>
					<div class="box box-success">
						<div class="box-header">
							<i class="fa fa-cogs"></i>
							<h3 class="box-title">菜单详情</h3>
						</div>
						<form class="form-horizontal">
							<div class="box-body">
								<div class="form-group">
			                        <label for="id" class="col-sm-3 control-label">菜单ID</label>
			                        <div class="col-sm-9">
			                            <input type="text" class="form-control notnull" id="id" placeholder="菜单ID" >
			                        </div>
			                    </div>
								<div class="form-group">
			                        <label for="text" class="col-sm-3 control-label">菜单名称</label>
			                        <div class="col-sm-9">
			                            <input type="text" class="form-control notnull" id="text" placeholder="菜单名称" >
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <label for="parent" class="col-sm-3 control-label">菜单父编号</label>
			                        <div class="col-sm-9">
			                            <input type="text" class="form-control notnull" id="parent" placeholder="菜单父编号" > 
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <label for="icon" class="col-sm-3 control-label">图标</label>
			                        <div class="col-sm-9">
			                            <input type="text" class="form-control" id="icon" placeholder="图标" >
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <label for="url" class="col-sm-3 control-label">菜单链接</label>
			                        <div class="col-sm-9">
			                            <input type="text" class="form-control" id="url" placeholder="菜单链接" >
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <label for="targetType" class="col-sm-3 control-label">目标类型</label>
			                        <div class="col-sm-9">
			                        	<select class="form-control" id="targetType" placeholder="目标类型" >
		                                 	<option value="iframe-tab">iframe-tab</option>
		                            	</select>
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <label for="sort" class="col-sm-3 control-label">排序</label>
			                        <div class="col-sm-9">
			                            <input type="text" class="form-control notnull" id="sort" placeholder="排序" >
			                        </div>
			                    </div>
			                    <div class="form-group">
		                             <label for="leaf" class="col-sm-3 control-label">是否为支节点</label>
		                             <div class="col-sm-9">
		                             <select class="form-control notnull" id="leaf" placeholder="是否为支节点" >
		                                 <option value="1">是</option>
		                                 <option value="0">否</option>
		                             </select>
		                             </div>
			                    </div>
							</div>
						</form>
						<div class="box-footer">
		                    <button type="submit" class="btn btn-default" id="btnReset"><i class="fa fa-refresh"></i>&nbsp;重置</button>
		                    <button type="submit" class="btn btn-info pull-right" id="btnSave"><i class="fa fa-save"></i>&nbsp;保存</button>
		                </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="menuFunModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="fun_ModalLabel" style="height:500px;">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 id="fun_ModalLabel" class="modal-title">
							Modal title
						</h4>
					</div>
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header">
								<i class="fa fa-cogs"></i>
								<h3 class="box-title">功能详情</h3>
							</div>
							<form class="form-horizontal">
								<div class="box-body">
									<div class="form-group">
				                        <label for="o_id" class="col-sm-3 control-label">功能ID</label>
				                        <div class="col-sm-9">
				                            <input type="text" class="form-control funNotNull" id="o_id" placeholder="功能ID" >
				                        </div>
				                    </div>
									<div class="form-group">
				                        <label for="o_text" class="col-sm-3 control-label">功能名称</label>
				                        <div class="col-sm-9">
				                            <input type="text" class="form-control funNotNull" id="o_text" placeholder="功能名称" >
				                        </div>
				                    </div>
				                    <div class="form-group">
				                        <label for="o_icon" class="col-sm-3 control-label">图标样式</label>
				                        <div class="col-sm-9">
				                            <input type="text" class="form-control" id="o_icon" placeholder="图标样式" > 
				                        </div>
				                    </div>
				                    <div class="form-group">
				                        <label for="o_qtip" class="col-sm-3 control-label">提示信息</label>
				                        <div class="col-sm-9">
				                            <input type="text" class="form-control" id="o_qtip" placeholder="提示信息" >
				                        </div>
				                    </div>
				                    <div class="form-group">
				                        <label for="o_url" class="col-sm-3 control-label">菜单链接</label>
				                        <div class="col-sm-9">
				                        	<select class="form-control" id="o_url" placeholder="菜单链接" >
			                                 	<option value="btn_add">添加</option>
			                                 	<option value="btn_edit">修改</option>
			                                 	<option value="btn_delete">删除</option>
			                                 	<option value="btn_role">角色</option>
			                                 	<option value="btn_user">用户</option>
			                                 	<option value="btn_menu">菜单</option>
			                            	</select>
				                        </div>
				                    </div>
				                    <div class="form-group">
				                        <label for="o_orders" class="col-sm-3 control-label">排序号</label>
				                        <div class="col-sm-9">
				                            <input type="text" class="form-control" id="o_orders" placeholder="排序号" >
				                        </div>
				                    </div>
				                    <div class="form-group">
				                        <label for="o_functionTypeId" class="col-sm-3 control-label">功能类型ID</label>
				                        <div class="col-sm-9">
				                        	<select class="form-control funNotNull" id="o_functionTypeId" placeholder="功能类型ID" >
			                                 	<option value="1001">添加</option>
			                                 	<option value="1002">修改</option>
			                                 	<option value="1003">删除</option>
			                                 	<option value="1004">权限</option>
			                            	</select>
				                        </div>
				                    </div>
				                    <div class="form-group">
			                             <label for="o_cls" class="col-sm-3 control-label">按钮样式</label>
			                             <div class="col-sm-9">
			                            	 <select class="form-control" id="o_cls" placeholder="按钮样式" >
			                                 	<option value="btn-success">btn-success</option>
			                                 	<option value="btn-warning">btn-warning</option>
			                                 	<option value="btn-danger">btn-danger</option>
			                                 	<option value="btn-info">btn-info</option>
			                                 	<option value="btn-inverse">btn-inverse</option>
			                                 	<option value="btn-default">btn-default</option>
			                                 	<option value="btn-primary">btn-primary</option>
			                            	</select>
			                             </div>
				                    </div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="btn_fun_save">
							<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;保存
						</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp;取消
						</button>
					</div>
				</div>
			</div>
		</div>
		
	<div id="menuRoleModal" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 id="menu_modalLabel" class="modal-title">
						绑定角色
					</h4>
				</div>
				<div class="box box-success">
					<div class="container-fluid">
				        <div class="row">
			               <div class="col-md-12">
			                  <div class="box-body" style="padding-bottom:5px;">
			                      <div id="menuRole_toolbar" class="btn-group">
			                          <button id="btn_menurole_save" type="button" class="btn btn-success">
			                              <i class="fa fa-save"></i>&nbsp;保存
			                          </button>
			                      </div>
			                      <table id="menuRole_table"></table>
			                  </div>
		                 	</div>
		                </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="funRoleModal" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 id="fun_modalLabel" class="modal-title">
						绑定角色
					</h4>
				</div>
				<div class="box box-success">
					<div class="container-fluid">
				        <div class="row">
			               <div class="col-md-12">
			                  <div class="box-body" style="padding-bottom:5px;">
			                      <div id="funRole_toolbar" class="btn-group">
			                          <button id="btn_funrole_save" type="button" class="btn btn-success">
			                              <i class="fa fa-save"></i>&nbsp;保存
			                          </button>
			                      </div>
			                      <table id="funRole_table"></table>
			                  </div>
		                 	</div>
		                </div>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
