<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<nav class="navbar navbar-expand-lg navbar-dark secondary-color">
	<a class="navbar-brand" href="#"><strong>love||wall后台管理 </strong></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="nav navbar-nav nav-flex-icons ml-auto">
			<li class="nav-item"><a class="nav-link"><i
					class="fas fa-envelope"></i> <span
					class="clearfix d-none d-sm-inline-block"> 邮件 </span></a></li>
			<li class="nav-item"><a class="nav-link"><i
					class="far fa-comments"> </i> <span
					class="clearfix d-none d-sm-inline-block"> 消息 </span></a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> <i
					class="fas fa-user"></i> <shiro:principal />
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="/logout">登出</a> <a
						class="dropdown-item" href="javascript:" data-toggle="modal"
						data-target="#fullHeightModalRight">设置</a>
				</div></li>
		</ul>
	</div>
</nav>


<div class="modal fade top" id="fullHeightModalRight" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-full-height modal-top" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title w-100" id="myModalLabel">个人设置</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container">
					<div class="m-auto">
						<div class="single-news mb-4">
							<div class="view overlay zoom rounded z-depth-1-half mb-4">
								<img class="mx-auto d-block rounded"
									style="height: 200px; width: 200px"
									src="https://mdbootstrap.com/img/Photos/Others/images/82.jpg"
									alt="Sample image">
								<div class="mask flex-center waves-effect waves-light">
									<p class="white-text">
										<shiro:principal />
									</p>
								</div>
							</div>
							<div class="view overlay rounded z-depth-1-half mb-4">
								<ul class="list-group">
									<li
										class="list-group-item d-flex justify-content-between align-items-center">
										用户名<span> <strong><shiro:principal/></strong> </span><span class="badge badge-primary badge-pill">14</span>
									</li>
									<li
										class="list-group-item d-flex justify-content-between align-items-center">
										登陆次数<span> <strong>20</strong> </span><span
										class="badge badge-primary badge-pill">2</span>
									</li>
									<li
										class="list-group-item d-flex justify-content-between align-items-center">
										邮箱<span> <strong>1056976753@qq.com</strong> </span><span class="badge badge-primary badge-pill">1</span>
									</li>
									<li
										class="list-group-item d-flex justify-content-between align-items-center">
										手机号码<span> <strong>18188175536</strong> </span><span class="badge badge-primary badge-pill">1</span>
									</li>
								</ul>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer justify-content-center">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary">修改信息</button>
			</div>
		</div>
	</div>
</div>
