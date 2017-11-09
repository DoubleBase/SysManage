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
							<button class="btn btn-success" id="btn_add"><i class="fa fa-plus"></i>&nbsp;添加</button>
							<button class="btn btn-primary" id="btn_edit"><i class="fa fa-pencil"></i>&nbsp;修改</button>
							<button class="btn btn-danger" id="btn_delete"><i class="fa fa-minus"></i>&nbsp;删除</button>
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
								<i class="glyphicon glyphicon-plus"></i>添加功能
							</button>
							<button type="submit" class="btn btn-warning" id="modFun">
								<i class="glyphicon glyphicon-pencil"></i>修改功能
							</button>
							<button type="submit" class="btn btn-danger" id="delFun">
								<i class="glyphicon glyphicon-minus"></i>删除功能
							</button>
							<button type="submit" class="btn btn-inverse" id="roleFun">
								<i class="fa fa-group"></i>绑定角色
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
	
  </body>
</html>
