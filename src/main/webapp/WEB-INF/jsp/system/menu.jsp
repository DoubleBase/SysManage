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
						<div class="col-sm-12" id="systoolbar-content"></div>
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
  </body>
</html>
