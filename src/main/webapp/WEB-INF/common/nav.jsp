<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<nav class="sidebar-nav scrollbar-ripe-malinka">
	<ul class="metismenu" id="left_menu">
		<li style="background-color: #8e24aa" class="text-center"><a
			href="javascript:void()"><i class="fas fa-bars cyan-text pr-3" aria-hidden="true"></i>系统菜单
		</a></li>
		<li><a class="has-arrow" href="#" aria-expanded="false"><i class="fas fa-cog red-text pr-3" aria-hidden="true"></i>系统管理</a>
			<ul>
				<li><a href="javascript:void(0)" id="system-log">系统日志</a></li>
				<li><a href="javascript:void(0)" id="system-setting">系统设置</a></li>
				<li><a href="javascript:void(0)" id="system-back">数据库备份</a></li>
				<li><a href="javascript:void(0)" id="system-announcement">系统公告</a></li>
			</ul>
		</li>
		
		<li><a class="has-arrow" href="#" aria-expanded="false"><i class="fas fa-user red-text pr-3" aria-hidden="true"></i>用户管理</a>
			<ul>
				<li><a href="javascript:void(0)" id="member-admin">会员管理</a></li>
				<li><a href="javascript:void(0)" id="user-rule-admin">会员规则管理</a></li>
				<li><a href="javascript:void(0)" id="user-admin">普通用户管理</a></li>
				<li><a href="javascript:void(0)" id="user-admin">消息推送</a></li>
			</ul>
		</li>
		
		<li><a class="has-arrow" href="#" aria-expanded="false"><i class="fas fa-paper-plane red-text pr-3" aria-hidden="true"></i>营销管理</a>
			<ul>
				<li><a href="javascript:void(0)" id="system-log">营销数据图</a></li>
				<li><a href="javascript:void(0)" id="system-setting">活动管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">个性化定制</a></li>
				<li><a href="javascript:void(0)" id="system-back">卡劵管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">礼品管理</a></li>
			</ul>
		</li>
		
		
		<li><a class="has-arrow" href="#" aria-expanded="false"><i class="fas fa-list-alt red-text pr-3" aria-hidden="true"></i>内容管理</a>
			<ul>
				<li><a href="javascript:void(0)" id="system-log">文章管理</a></li>
				<li><a href="javascript:void(0)" id="system-setting">栏目管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">页面布局管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">广告页管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">内容管理数据可视化管理</a></li>
			</ul>
		</li>
		
		<li><a class="has-arrow" href="#" aria-expanded="false"><i class="fas fa-th red-text pr-3" aria-hidden="true"></i>开发者管理</a>
			<ul>
				<li><a href="javascript:void(0)" id="system-log">开发者动态数据可视化</a></li>
				<li><a href="javascript:void(0)" id="system-setting">开发者管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">系统api管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">权限管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">风险管理</a></li>
			</ul>
		</li>
	
		<li><a class="has-arrow" href="#" aria-expanded="false"><i class="fas fa-heart red-text pr-3" aria-hidden="true"></i>CP匹配管理</a>
			<ul>
				<li><a href="javascript:void(0)" id="system-log">好友关系管理</a></li>
				<li><a href="javascript:void(0)" id="system-setting">动态管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">匹配规则管理</a></li>
				<li><a href="javascript:void(0)" id="system-back">CP匹配数据可视化</a></li>
				<li><a href="javascript:void(0)" id="system-back">位置管理</a></li>
			</ul>
		</li>
	</ul>
</nav>

<script type="text/javascript">
	/* 
		动态添加tabs
	 */
	$(function() {
		var item = {'id':'home','name':'控制台','url':'tabhome','closable':false};
		addTab(item);
		$("[href='javascript:void(0)']").click(function() {
			var id = $(this).attr("id");
			var name = $(this).text();
			var item = {'id':id,'name':name,'url':id,'closable':true};
			addTab(item);
		})
	})
	function addTab(tabItem) {
		var id = "tab_seed_" + tabItem.id;
		var container ="tab_container_" + tabItem.id;
		$("li[id^=tab_seed_]").removeClass("active");
		$("div[id^=tab_container_]").removeClass("active").removeClass("show");
		if(!$('#'+id)[0]){
			var li_tab = '<li role="presentation" id="'+id+'" class="nav-item" ><a class="nav-link"  href="#'+container+'" role="tab" data-toggle="tab" aria-controls="'+container+'">'+tabItem.name;
			if(tabItem.closable){
				li_tab = li_tab + '<i class="fas fa-times-circle" tabclose="'+id+'"  onclick="closeTab(this)"></i></a></li> ';
			}
		 	var tabpanel = '<div role="tabpanel" class="tab-pane fade" id="'+container+'" aria-labelledby="'+id+'">'+
		 				
					 	'<div class="d-flex align-items-center" role="status"><strong>Loading...</strong><div class="spinner-border text-secondary ml-auto" role="status" aria-hidden="true"></div></div>'
		 					+
	    				   '</div>';
			$('#myTabEx').append(li_tab);
			$('#myTabContentEx').append(tabpanel);
			$('#'+container).load('/tab/'+tabItem.url,function(response,status,xhr){
				if(status=='error'){//status的值为success和error，如果error则显示一个错误页面
					$(this).html(response);
				}
			});
		}
		$("#"+id).addClass("active").addClass("show");
		$("#"+container).addClass("active").addClass("show");
	}
	function closeTab(item) {
		var val = $(item).attr('tabclose');
		var containerId = "tab_container_" + val.substring(9);
		if ($('#' + containerId).hasClass('active')) {
			$('#' + val).prev().addClass('active').addClass("show");
			$('#' + containerId).prev().addClass('active').addClass("show");
		}
		$("#" + val).remove();
		$("#" + containerId).remove();
	}
</script>


