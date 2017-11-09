
$.fn.modalConfirm = function (content, callBack) {
    layer.confirm(content, {
        icon: "fa-exclamation-circle",
        title: "系统提示",
        btn: ['确认', '取消'],
        btnclass: ['btn btn-primary', 'btn btn-danger']
    }, function () {
        callBack(true);
    	layer.msg('处理中,请稍后...',{time: 100});
    }, function () {
        callBack(false);
    });
}

$.fn.modalAlert = function (content, type ,callBack) {
    var icon = "";
    var iconType = 0;
    if (type == 'success') {
        icon = "fa-check-circle";
        iconType = 1;
    }
    if (type == 'error') {
        icon = "fa-times-circle";
        iconType = 2;
    }
    if (type == 'warning') {
        icon = "fa-exclamation-circle";
        iconType = 3;
    }
    top.layer.alert(content, {
        icon: iconType,
        title: "系统提示",
        btn: ['确认'],
        btnclass: ['btn btn-primary']
    },
    function(){
    	
    	if(callBack){
    		callBack(true);
    	}else{
    		$.fn.modalAlert.closeOnCallBack();
    	}
    	
    });
}

$.fn.modalAlert.closeOnCallBack = function(){
	//模拟窗口关闭点击事件
	top.$("#layui-layer"+top.$(".layui-layer-shade").attr("times")).find('.layui-layer-close').click();
}

$.fn.modalOpen = function (options) {
    /*var defaults = {
        id: null,
        title: '系统窗口',
        width: "100px",
        height: "100px",
        url: null,
        shade: 0,
        btn: ['确认', '关闭'],
        btnclass: ['btn btn-primary', 'btn btn-danger'],
        callBack: null
    };
    var options = $.extend(defaults, options);
    var _width = top.$(window).width() > parseInt(options.width.replace('px', '')) ? options.width : top.$(window).width() + 'px';
    var _height = top.$(window).height() > parseInt(options.height.replace('px', '')) ? options.height : top.$(window).height() + 'px';
    layer.open({
        id: options.id,
        type: 2,
        shade: options.shade,
        title: options.title,
        fix: false,
        area: [_width, _height],
        content: options.url,
        btn: options.btn,
        maxmin:true,
        btnclass: options.btnclass,
        yes: function () {
            options.callBack(options.id)
        }, cancel: function () {
            return true;
        }
    });*/
	var height = (document.body.clientHeight-80);
	
	if(window.screen.height ==768){
		height = 480;
	}
	
	perContent  = layer.open({
		  title : options.title,
		  type: 2,
		  area: [ (document.body.clientWidth-80)+'px', height +'px'],
		  fixed: false, //不固定
		  anim:3,                    //动画
		  content: options.url
	 });
	layer.full(perContent);
}

/**
 * 消息提示框
 * @param {} content	消息内容
 * @param {} type		消息类型
 * example:
 * $.fn.modalMsg("提交成功", "success");
 */
$.fn.modalMsg = function (content, type) {
    var iconType = 0;
    if (type != undefined) {
        var icon = "";
        if (type == 'success') {
            icon = "fa-check-circle";
            iconType = 1;
        }
        if (type == 'error') {
            icon = "fa-times-circle";
            iconType = 2;
        }
        if (type == 'warning') {
            icon = "fa-exclamation-circle";
            iconType = 3;
        }
        top.layer.msg(content, { icon: iconType, time: 2000, shift: 5 });
        top.$(".layui-layer-msg").find('i.' + iconType).parents('.layui-layer-msg').addClass('layui-layer-msg-' + type);
    } else {
        top.layer.msg(content);
    }
}