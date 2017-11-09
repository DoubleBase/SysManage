<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>角色用户绑定</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="resource/com/js/include.js"></script>
<script type="text/javascript">
	var roleId = ${roleId};
</script>
<script src="resource/system/js/roleuser.js"></script>

</head>
<body>
	<div class="container-fluid" style="padding-top : 20px;">
		<!-- Main content -->
	    <section class="content">
	        <div class="row">
               <div class="col-md-12">
                  <div class="box-body" style="padding-bottom:0px;">
                      <div id="toolbar" class="btn-group">
                          <button id="btn_role_save" type="button" class="btn btn-success">
                              <i class="fa fa-save"></i>&nbsp;保存
                          </button>
                      </div>
                      <table id="table_resource"></table>
                  </div>
	    </section>
	</div>
</body>
</html>