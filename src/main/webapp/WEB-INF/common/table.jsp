<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<button class="btn btn-primary"  id="deleteAll">全选<i class="fas fa-allergies"></i></button>
<button class="btn btn-danger" id="deleteSelect">删除<i class="fas fa-times"></i></button>
<button class="btn btn-default" id="reloadTable">刷新<i class="fas fa-sync-alt"></i></button>
<table id="dtBasicExample" class="table table-hover table-striped"
	cellspacing="0" width="100%">
	<thead>
		<tr>
			<th class="th-sm">userId</th>
			<th class="th-sm">userName</th>
			<th class="th-sm">passWord</th>
			<th class="th-sm">userPhone</th>
			<th class="th-sm">userAge</th>
			<th class="th-sm">userGender</th>
			<th class="th-sm">nowLoginTime</th>
			<th class="th-sm">lastLoginTime</th>
			<th class="th-sm">loginCode</th>
			<th class="th-sm">isMember</th>
		</tr>
	</thead>
</table>

<script type="text/javascript">
var table = $('#dtBasicExample').DataTable({
	ordering: false,  // 关闭排序
    searching: false,  // 关闭插件自带的搜索，我们会自定义搜索
    serverSide: true,  //服务器模式
    Processing: true,  //是否显示“处理中...”
    autoWidth : true,  // 自动宽度
    lengthMenu: [5, 10, 25, 50, 100],  // 分页器的页数
	ajax: {
        url: 'http://localhost:8080/tab/table/ajax',
        type: "POST",
        contentType: 'application/json; charset=UTF-8',
        data: function (d) {
            var str = {
                "draw": d.draw,
                "start": d.start,
                "length": d.length,
                "search": d.search.value
            };
            return JSON.stringify(str);
        },
    },
    columns: [{
        data: "userId"
    }, {
        data: "userName"
    }, {
        data: "passWord"
    }, {
        data: "userPhone"
    }, {
        data: "userAge"
    }, {
        data: "userGender"
    }, {
        data: "nowLoginTime"
    }, {
        data: "lastLoginTime"
    }, {
        data: "loginCode"
    }, {
        data: "isMember"
    }],
    
    language : {
        "lengthMenu" : "_MENU_ 条记录每页",
        "zeroRecords" : "没有找到记录",
        "info" : "总记录数：_TOTAL_",
        "infoEmpty" : "无记录",
        "infoFiltered" : "（从 _MAX_ ）条记录过滤",
        "paginate" : {
            "previous" : "上一页",
            "next" : "下一页"
        }
    }
});
/* 多选 */


$('#dtBasicExample tbody').on( 'click', 'tr', function () {
    $(this).toggleClass('selected');
} );

/**
 * table.ajax.reload(); 刷新
 */
$('#reloadTable').click(function() {
	table.ajax.reload();
})
$('#deleteSelect').click(function() {//删除
    var array = new Array();
    array = table.rows({selected : true}).data().toArray();
    if(array.length==0){//如果一个没有勾选
        swal({    //提示框
            title : "批量删除失败",
            text : "请先勾选需要删除的数据",
            type : "error",
            showConfirmButton : false,
            timer : 2000
        });
    }else{
    swal({
        title : "删除账号",
        text : "<span style='color:#F44336;'>删除操作后该记录将被删除，并且无法恢复</span>",
        type : "info",
        showCancelButton : true,
        confirmButtonColor : "#2196F3",
        confirmButtonText : "确定",
        cancelButtonText : "取消",
        closeOnConfirm : false,
        html : true
    }, function() {
        for (var i = 0; i < array.length; i++) {
            deleteMapPoint(array[i].id)//确定删除，则执行删除函数
        }
    });
    }
})

$('#deleteAll').click(function() {//全选
	
	$('#dtBasicExample tbody tr').toggleClass('selected');
})

function deleteMapPoint(id) {
    $.ajax({
        url : contextPath + "/mapPoint/delete/" + id,
        cache : false,
        dataType : "json",
        success : function(result) {
            if (result.code == 1) {
                swal({
                    title : "删除账号",
                    text : "删除账号成功",
                    type : "success",
                    showConfirmButton : false,
                    timer : 1000
               });
                table.ajax.reload();
            }
        }
	});
}	    
$('.dataTables_length').addClass('bs-select');
</script>

