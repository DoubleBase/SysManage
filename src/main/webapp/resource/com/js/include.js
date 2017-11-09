includeComCss = function(path){
	document.write("<link rel='stylesheet' type='text/css' href='" + path + "'>");
}
includeComJs = function(path){
	document.write("<script type='text/javascript' src='" + path + "'></script>");
}

includeComCss("resource/superui/ui/global/bootstrap/css/bootstrap.min.css");
includeComCss('resource/superui/plugins/bootstrap-table/bootstrap-table.css');
includeComCss("resource/superui/ui/global/font-awesome/css/font-awesome.css");
includeComCss("resource/superui/adminlte/dist/css/AdminLTE.css");
includeComCss("resource/superui/adminlte/dist/css/skins/_all-skins.css");
includeComCss("resource/superui/min/css/supershopui.common.min.css");
includeComCss('resource/superui/plugins/jstree/dist/themes/default/style.min.css');

includeComJs("resource/superui/ui/global/jQuery/jquery.min.js");
includeComJs("resource/superui/ui/global/bootstrap/js/bootstrap.min.js");
includeComJs('resource/superui/plugins/bootstrap-table/bootstrap-table.js');
includeComJs('resource/superui/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.js');


includeComJs("resource/superui/min/js/supershopui.common.js");
includeComJs('resource/superui/plugins/jstree/dist/jstree.min.js');



includeComJs('resource/com/js/fn.js');
includeComJs('resource/com/js/util.js');
includeComJs('resource/com/js/superui_override.js');