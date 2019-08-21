<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<button class="btn btn-primary" id="deleteAll" data-toggle="modal"
	data-target="#fullHeightModalTop">
	发布公告<i class="fas fa-allergies"></i>
</button>
<section class="my-1">
	<div class="row">
		<div class="col-lg-5 col-xl-4">
			<div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
				<img class="img-fluid"
					src="https://mdbootstrap.com/img/Photos/Others/images/49.jpg"
					alt="Sample image"> <a>
					<div class="mask rgba-white-slight"></div>
				</a>
			</div>
		</div>
		<div class="col-lg-7 col-xl-8">
			<h3 class="font-weight-bold mb-3">
				<strong>标题</strong>
			</h3>
			<p class="dark-grey-text">内容</p>
			<p>
				by <a class="font-weight-bold">admin</a>, 19/04/2018
			</p>
			<a class="btn btn-primary btn-md">查看更多</a>

		</div>

	</div>
	<hr class="my-5">
	<div class="row">
		<div class="col-lg-5 col-xl-4">
			<div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
				<img class="img-fluid"
					src="https://mdbootstrap.com/img/Photos/Others/images/31.jpg"
					alt="Sample image"> <a>
					<div class="mask rgba-white-slight"></div>
				</a>
			</div>

		</div>
		<div class="col-lg-7 col-xl-8">

			<h3 class="font-weight-bold mb-3">
				<strong>标题</strong>
			</h3>
			<p class="dark-grey-text">内容</p>
			<p>
				by <a class="font-weight-bold">admin</a>, 16/04/2018
			</p>
			<a class="btn btn-primary btn-md">查看更多</a>

		</div>

	</div>
	<hr class="my-5">

	<div class="row">

		<div class="col-lg-5 col-xl-4">

			<div class="view overlay rounded z-depth-1-half mb-lg-0 mb-4">
				<img class="img-fluid"
					src="https://mdbootstrap.com/img/Photos/Others/images/52.jpg"
					alt="Sample image"> <a>
					<div class="mask rgba-white-slight"></div>
				</a>
			</div>

		</div>
		<div class="col-lg-7 col-xl-8">

			<h3 class="font-weight-bold mb-3">
				<strong>标题</strong>
			</h3>
			<p class="dark-grey-text">内容</p>
			<p>
				by <a class="font-weight-bold">admin</a>, 12/04/2018
			</p>
			<a class="btn btn-primary btn-md">查看更多</a>

		</div>
	</div>
	<hr class="my-5">
	<nav>
		<ul class="pagination pg-red">
			<li class="page-item"><a class="page-link" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
			</a></li>
			<li class="page-item active"><a class="page-link">1</a></li>
			<li class="page-item"><a class="page-link">2</a></li>
			<li class="page-item"><a class="page-link">3</a></li>
			<li class="page-item"><a class="page-link">4</a></li>
			<li class="page-item"><a class="page-link">5</a></li>
			<li class="page-item"><a class="page-link" aria-label="Next">
					<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
			</a></li>
		</ul>
	</nav>
</section>


<div class="modal fade top" id="fullHeightModalTop" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-full-height modal-top" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title w-100" id="myModalLabel">发布公告</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container">
					<div class="md-form">
						<input type="search" id="form-autocomplete-4"
							class="form-control mdb-autocomplete"> <label
							for="form-autocomplete-4" class="active">公告标题</label>
					</div>
					<div class="md-form">
						<textarea name="content" id="content"
							class="md-textarea form-control" rows="3"></textarea>
						<label for="editor"></label>
					</div>
				</div>
			</div>
			<div class="modal-footer justify-content-center">
				<button id="messgae-btn-out" type="button" class="btn btn-indigo">发布</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="../../static/js/base.js">

</script>
<script type="text/javascript">
	$(function() {
		CKEDITOR.replace('content', {
			language : 'zh-cn',
			uiColor : '#9AB8F3'
		});
		$('#messgae-btn-out').on('click',function(){
			var content =CKEDITOR.instances.content.getData();
			var title = $('#form-autocomplete-4').val();
			if (content === '' || title === '') {
				_confirm_error("不可为空");
				return ;
			}
			var data = {
                "title":title,
                "content":content,
            }
			$.ajax({
				type:"post",
				url:"/",
                data:JSON.stringify(data),
                contentType:"application/json",
                dataType:"json",
                async:true,
                success:function(data){
					
                },
                error:function(e){
                	
                }
			})
		})
	})
	/* 解决ckeditor 和bootstrap  模态框冲突问题*/
	var $modalElement = this.$element;
	$(document).on('focusin.modal',
			function(e) {
				var $parent = $(e.target.parentNode);
				if ($modalElement[0] !== e.target
						&& !$modalElement.has(e.target).length
						// add whatever conditions you need here:
						&& !$parent.hasClass('cke_dialog_ui_input_select')
						&& !$parent.hasClass('cke_dialog_ui_input_text')) {
					$modalElement.focus()
				}
			})
</script>




