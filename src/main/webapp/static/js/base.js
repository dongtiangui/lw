$(function() {
	$('#left_menu').metisMenu();
	var left_height = null;
	var height = document.body.clientHeight;
	left_height = height - $('#footer').height() - $('#header').height();
	$('#left_menu,#main-content').css({
		overflow : 'scroll',
		height : left_height + "px"
	})
});
function _confirm_common(settings, callback) {
    swal({
        text: settings.text,
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: settings.confirmButtonText,
        cancelButtonText: "取消",
        allowOutsideClick: false,
        allowEscapeKey: false,
        animation: false
    }).then(callback);
}

function _confirm_success(meg) {
    swal({
        type: 'success',
        title: meg
    });
}
function _confirm_error(meg) {
    swal({
        type: 'error',
        title: meg
    })
}

function _confirm_info(head,meg) {
	swal({
		title: head,
		  type: 'info',
		  html: meg,
		  showCloseButton: true,
		  showCancelButton: true,
	})
}


// 全局session
$.ajaxSetup({
	complete:function(XMLHttpRequest,sessionStatus){
		var sessionstatus = XMLHttpRequest.getResponseHeader("session-status");
		console.log(sessionstatus);
		if(sessionstatus=="timeout"){
		     $.messager.alert('提示信息', "登录超时！请重新登录！");
		     window.location.href = '/index.jsp';
		} 
    }
});
