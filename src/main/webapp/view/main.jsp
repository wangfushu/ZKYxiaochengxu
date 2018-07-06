<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理平台</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="renderer" content="webkit">
	<meta name="description" content="福淑">
	<link rel="shortcut icon" href="<%=basePath%>image/favicon.ico">
 	<link href="<%=basePath%>bootstrap/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>bootstrap/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>bootstrap/css/toastr/toastr.min.css" rel="stylesheet">
    <link href="<%=basePath%>bootstrap/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>bootstrap/css/style.css?v=4.1.0" rel="stylesheet">
  </head>
<body class="fixed-sidebar full-height-layout gray-bg"style="overflow: hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close">
            <i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div>
                    	<span><img alt="管理系统" class="img-circle" height="60" width="60" src="<%=basePath%>image/logo.png"/></span>
                        <h3 class="" style="color: #ffffff">
                           	 管理系统
                        </h3>
                    </div>
                    <div class="dropdown profile-element hidden ">
                        <span><img alt="image" class="img-circle" src="<%=basePath%>image/logo.png"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear">
                            <span class="block m-t-xs"><strong class="font-bold">${username}</strong></span>
                            <span class="text-muted text-xs block">${name}<b class="caret"></b></span>
                             </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a onclick="personal();" href="#">修改头像</a>
                            </li>
                            <li><a onclick="personal();" href="#">个人资料</a>
                            </li>
                            <li><a onclick="personal();" href="#">密码修改</a>
                            </li>
                            <li><a onclick="personal();" href="#">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="<%=basePath%>jlpay/loginout">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element"></div>
                </li>
                <li><a href="#"> <i class="fa fa-home"></i> <span
                        class="nav-label">可视化</span> <span class="fa arrow"></span>
                </a>
                    <ul class="nav nav-second-level">
                        <li>
                        <a id="index001" class="J_menuItem" href="index_v1.html">可视化</a></li>
                    </ul>
                </li>
		<c:forEach items="${menus}" var="menu">
		<li>
			<a href="#">
			<i class="${menu.attributes.icon}"></i>
			<span class="nav-label">${menu.text}</span> 
			<span class="fa arrow"></span>
			</a> 
			<ul class="nav nav-second-level">
			<c:forEach items="${menu.children}" var="cmenu">
				<li>
				<a class="J_menuItem" href="${cmenu.attributes.url}">${cmenu.text}</a>
				</li>
				</c:forEach>
              </ul>
			</li>
		</c:forEach>            
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation"
                 style="margin-bottom: 0">
                <div class="navbar-header">
<!--                     <a class="navbar-minimalize minimalize-styl-2 btn btn-default "
                       href="#" title="收起菜单"><i class="fa fa-bars"></i> </a> -->
                    <form role="search" class="navbar-form-custom"
                          method="post" action="">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …"
                                   class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#"> 
                    <i class="fa fa-envelope"></i>
                        <span class="label label-warning">{{total}}</span>通知
                    </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li v-for="row in rows" class="m-t-xs">
                                <div class="dropdown-messages-box">
                                    <a class="pull-left"> 
                                    <i class="fa fa-server"></i>
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">{{row.before}}</small>
                                        <strong>{{row.sender}}</strong>
                                        {{row.title}} <br>
                                        <small class="text-muted">{{row.updateDate}}</small>
                                    </div>
                                </div>
                                <div class="divider"></div>
                            </li>
                            <li>
                                <div class="text-center link-block">
                                   <!--  <a class="J_menuItem" href="javascript:void();" onclick="alert('加速开发中');">  -->
                                    <i class="fa fa-envelope"></i> <strong onclick="alert('加速开发中');"> 查看所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="hidden-xs"><a onclick="personal()" href="javascript:void();" ><i class="fa fa-id-card"></i> 个人</a></li>
                    <li class="dropdown hidden-xs">
                    <a class="right-sidebar-toggle" aria-expanded="false"> 
                    <i class="fa fa-tasks"></i> 主题
                    </a></li>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft">
                <i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:void();" class="active J_menuTab" data-id="index_v1.html">可视化</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight">
                <i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">
                   	 关闭操作<span class="caret"></span>
                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a></li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
                    <li class="J_tabRefreshr"><a onclick="alert('开发中')">刷新当前选项卡</a></li>
                </ul>
            </div>
            <a href="<%=basePath%>jlpay/loginout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=basePath%>view/chart.jsp" frameborder="0" data-id="index_v1.html"seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">管理平台</div>
        </div>
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">
            <ul class="nav nav-tabs navs-2">
                <li class="active"><a data-toggle="tab" href="#tab-1"> <i class="fa fa-gear"></i> 主题
                </a></li>
                <li class=""><a data-toggle="tab" href="#tab-2"> 通知 </a></li>
            <!--     <li><a data-toggle="tab" href="#tab-3"> 项目进度 </a></li> -->
            </ul>
            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3>
                            <i class="fa fa-comments-o"></i> 主题设置
                        </h3>
                        <small><i class="fa fa-tim"></i>
                            你可以从这里选择和预览主题的布局和样式，这些设置暂时不会被保存在本地，下次打开的时候还是默认样式。
                        </small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title">主题设置</div>
                        <div class="setings-item">
                            <span>收起左侧菜单</span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu"> 
                                    <label class="onoffswitch-label" for="collapsemenu"> 
                                    <span class="onoffswitch-inner"></span> 
                                    <span class="onoffswitch-switch"></span>
                                </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>固定顶部</span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar"> 
                                    <label class="onoffswitch-label" for="fixednavbar"> 
                                    <span class="onoffswitch-inner"></span> 
                                    <span class="onoffswitch-switch"></span>
                                </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span> 固定宽度 </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout"class="onoffswitch-checkbox" id="boxedlayout"> 
                                    <label class="onoffswitch-label" for="boxedlayout"> 
                                    <span class="onoffswitch-inner"></span> 
                                    <span class="onoffswitch-switch"></span>
                                </label>
                                </div>
                            </div>
                        </div>
                        <div class="title">皮肤选择</div>
                        <div class="setings-item default-skin nb">
								<span class="skin-name "> 
								<a href="#" class="s-skin-0">默认皮肤 </a>
								</span>
                        </div>
                        <div class="setings-item blue-skin nb">
								<span class="skin-name "> 
								<a href="#" class="s-skin-1">蓝色主题 </a>
								</span>
                        </div>
                        <div class="setings-item yellow-skin nb">
								<span class="skin-name "> 
								<a href="#" class="s-skin-3">黄色/紫色主题 </a>
								</span>
                        </div>
                    </div>
                </div>
                <div id="tab-2" class="tab-pane">
                    <div class="sidebar-title">
                        <h3>
                            <i class="fa fa-comments-o"></i> 最新通知
                        </h3>
                        <small><i class="fa fa-tim"></i> 您当前有10条未读信息</small>
                    </div>
                </div>
                <div id="tab-3" class="tab-pane">
                    <div class="sidebar-title">
                        <h3>
                            <i class="fa fa-cube"></i> 最新任务
                        </h3>
                        <small><i class="fa fa-tim"></i> 您当前有14个任务，10个已完成</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>bootstrap/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=basePath%>bootstrap/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>bootstrap/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>bootstrap/js/plugins/layer/layer.min.js"></script>
<!-- 自定义js -->
<script src="<%=basePath%>js/app.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=basePath%>js/contabs.js"></script>
<!-- 第三方插件 -->
<script src="<%=basePath%>bootstrap/js/plugins/pace/pace.min.js"></script>
<!-- vue -->
<script type="text/javascript" src="<%=basePath%>js/vue.min.js"></script>
<script type="text/javascript">
var stompClient = null;
var prefix = "<%=basePath%>";
	var wrapper = new Vue({
        el: '#wrapper',
        data: {
            total: '',
            rows: '',
        },
        created: function () {
            this.notify()
        }
    })
function personal(){
	layer.open({
			type : 2,
			title : '个人设置',
			maxmin : true,
			shadeClose : false,
			area : [ '800px', '600px' ],
			content : prefix+'user/personal/'
		});
	}
</script>
</body>
</html>
