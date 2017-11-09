var uxfn = {}
uxfn.initLoading = function() {
	var html = "<!-- loading -->"
	html += "<div class='modal fade bs-example-modal-sm' style='height:480px;' id='uxfn_loading' tabindex='-1' role='dialog' aria-labelledby='uxfn_loadingModalLabel' data-backdrop='static'>";
	html += "<div class='modal-dialog modal-sm' role='document'>";
	html += "<div class='modal-content'>";
	html += "<div class='modal-header bg-success'>";
	html += "<h4 class='modal-title' id='uxfn_loadingModalLabel'>进度</h4>";
	html += "</div>";
	html += "<div id='uxfn_loadingText' class='modal-body'>";
	html += "<span class='glyphicon glyphicon-refresh' aria-hidden='true'>1</span>";
	html += "处理中，请稍候。。。";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	$("body").append(html);
}

uxfn.showLoading = function(text) {
	$("#uxfn_loadingText").html("<center>"+text+"</center>");
	$("#uxfn_loadingText").append("<img src='resource/com/images/loading4.gif' />");
	$("#uxfn_loading").modal("show");
}

uxfn.hideLoading = function() {
	$("#uxfn_loading").modal("hide");
}

uxfn.initAlert = function() {
	var html = "<!-- alert -->"
	html += "<div class='modal fade bs-example-modal-sm' style='height:250px;' id='uxfn_alert' tabindex='-1' role='dialog' aria-labelledby='uxfn_alertModalLabel' data-backdrop='static'>";
	html += "<div class='modal-dialog modal-sm' role='document'>";
	html += "<div class='modal-content'>";
	html += "<div class='modal-header bg-primary'>";
	html += "<button type='button' class='close' data-dismiss='modal' aria-label='关闭'>";
	html += "<span aria-hidden='true'>&times;</span>";
	html += "</button>";
	html += "<h4 class='modal-title' id='uxfn_alertModalLabel'>提示</h4>";
	html += "</div>";
	html += "<div id='uxfn_alertText' class='modal-body'>";
	html += "<span class='glyphicon glyphicon-refresh' aria-hidden='true'>1</span>";
	html += "警告！";
	html += "</div>";
	html += "<div class='modal-footer'>";
	html += "<button id='uxfn_alertOk' type='button' class='btn btn-primary' data-dismiss='modal'>确定</button>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	$("body").append(html);
}

uxfn.alert = function(text, callback) {
	$("#uxfn_alertText").html(text);
	$("#uxfn_alert").modal("show");
	if (callback) {
		$("#uxfn_alertOk").off('click').on('click', function() {
			callback(true);
		});
	}
};

uxfn.initConfirm = function() {
	var html = "<!-- alert -->"
	html += "<div class='modal fade bs-example-modal-sm' style='height:250px;' id='uxfn_confirm' tabindex='-1' role='dialog' aria-labelledby='uxfn_confirmModalLabel' data-backdrop='static'>";
	html += "<div class='modal-dialog modal-sm' role='document'>";
	html += "<div class='modal-content'>";
	html += "<div class='modal-header bg-warning'>";
	html += "<button type='button' class='close' data-dismiss='modal' aria-label='关闭'>";
	html += "<span aria-hidden='true'>&times;</span>";
	html += "</button>";
	html += "<h4 class='modal-title' id='uxfn_confirmModalLabel'>确认</h4>";
	html += "</div>";
	html += "<div id='uxfn_confirmText' class='modal-body'>";
	html += "<span class='glyphicon glyphicon-refresh' aria-hidden='true'>1</span>";
	html += "确认！";
	html += "</div>";
	html += "<div class='modal-footer'>";
	html += "<button id='uxfn_confirmOk' type='button' class='btn btn-primary' data-dismiss='modal'>确定</button>";
	html += "<button id='uxfn_confirmNo' type='button' class='btn btn-danger' data-dismiss='modal'>取消</button>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	$("body").append(html);
}

uxfn.confirm = function(text, callback) {
	$("#uxfn_confirmText").html(text);
	$("#uxfn_confirm").modal("show");
	if (callback) {
		$("#uxfn_confirmOk").off('click').on('click', function() {
			callback(true);
		});
		$("#uxfn_confirmNo").off('click').on('click', function() {
			callback(false);
		});
	}
};

uxfn.doPost = function(URL, PARAMS, TARGET) {
	var temp = document.createElement("form");
	temp.action = URL;
	if (TARGET) {
		temp.target = TARGET;
	}
	temp.method = "POST";
	temp.style.display = "none";
	for (var x in PARAMS) {
		var opt = document.createElement("textarea");
		opt.name = x;
		opt.value = PARAMS[x];

		/* replace begin:把opt.value 里面所有的"<br>"替换成空 */
		re = new RegExp("<br>", "g");
		opt.value = opt.value.replace(re, " ");
		/* replace end */

		temp.appendChild(opt);
	}
	document.body.appendChild(temp);
	temp.submit();
	return temp;
}

// 屏蔽浏览器Backspace回退功能
document.onkeydown = function() {
	if (event.keyCode == 8) {
		if (window.event.srcElement.tagName.toUpperCase() == "INPUT" || window.event.srcElement.tagName.toUpperCase() == "TEXTAREA" || window.event.srcElement.tagName.toUpperCase() == "TEXT") {
			if (window.event.srcElement.readOnly || window.event.srcElement.type == "checkbox" || window.event.srcElement.type == "radio") {
				event.keyCode = 0;
				event.returnValue = false;
			}
		} else {
			event.keyCode = 0;
			event.returnValue = false;
		}
	}
}


uxfn.OpenLayer = function(url,title){
	
	var height = (document.body.clientHeight-80);
	
	if(window.screen.height ==768){
		height = 480;
	}
	
	perContent  = layer.open({
		  title : title,
		  type: 2,
		  area: [ (document.body.clientWidth-80)+'px', height +'px'],
		  fixed: false, //不固定
		  anim:3,                    //动画
		  content: url
	 });
	layer.full(perContent);
}
