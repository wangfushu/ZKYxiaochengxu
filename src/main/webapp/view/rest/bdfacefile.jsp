<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <base href="<%=basePath%>">
    <title>XAI-人脸检测</title>
    <jsp:include page="/common/header.jsp"></jsp:include>
    <jsp:include page="/common/blog_header.jsp"></jsp:include>
	<link rel="stylesheet" href="${ctx }/css/baidu/vendor.style.css">
    <link rel="stylesheet" href="${ctx }/css/baidu/face-detect.style.css">
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?abae9a4744f7b798ef3515bbdcd445fe";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
  </head>
  <body>
   <jsp:include page="/view/blog/index/include_blog_nav.jsp"></jsp:include>
   	<header class="intro-header" style="background-image: url('https://wximage-1251091977.cos.ap-beijing.myqcloud.com/xai/home-bg.jpeg');margin-bottom:-80px;">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>人脸检测<span><img src="${ctx}/image/blog/wcsqrcode.jpg" title="小帅一点资讯小程序专属码" style="width:140px;"/></span></h1>
						<span class="subheading">分析人脸的年龄、颜值等属性 更多体验 微信扫描上图小程序专属码</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Main Content -->
	<form id="formface" enctype="multipart/form-data">
    <div class="tech-section tech-demo" id="tech-demo">
        <div class="ai-container">
            <div class="demo-container clear-float">
                <div class="clear-float">
                    <div class="data-view-container">
                        <div class="data-view" data-label="识别图片" id="demo-result">
                            <div class="canvas-container has-result"><canvas width="592" height="400" data-scale="0.9932432432432432" style="position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%) scale(0.993243);">您的浏览器暂时不支持canvas，请选用现代浏览器！</canvas></div>
                            <div id="result-gallery" style="display: none;">
                                <ul class="gallery-container"><li class="active"><img src=""></li></ul>
                            </div>
                        </div>
                        <div class="demo-data">
                            <label id="demo-photo-upload" class="">
                                <input type="file" name="file" id="fileImage" onchange="faceUp()">选取图片
                            </label>
<!--                             <label id="photo-upload" class="" style="margin-left:20px;">
                                <a href="javascript:void(0)" onclick="faceUp()"  style="text-decoration: none;color: white;">点击上传</a>
                            </label> -->
                        </div>
                        <p class="demo-desc">
                            提示：可支持PNG、JPG、jpeg、BMP图片文件，不支持GIF图片，图片大小不超过2M，长边不超过2048像素，为保证正常识别效果，请保证需要识别部分为图片主体部分。</p>
                    </div>
                    <div class="data-view-container">
                        <div class="data-view" data-label="识别结果" style="height:400px;">
                           <div id="resultFace">
                           </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<jsp:include page="/view/blog/index/include_blog_footer.jsp"></jsp:include>
<script src="${ctx }/js/jquery.min.js"></script>
<script src="${ctx }/js/jquery.form.js"></script>
<!--30478167010202517514011210-->
<script src="${ctx}/js/baidu/vendor.js"></script>
<script src="${ctx}/js/baidu/face-detect.js"></script>
<script> var _trace_page_logid = 3047816701; </script>
<script type="text/javascript">
  function faceUp(){
        	var fileInfo = $("#fileImage").val();
        	if(fileInfo==''){
        		alert("必须选择图片哦");
        		return;
        	}
        	if(fileInfo.indexOf('.PNG')==-1&&fileInfo.indexOf('.png')==-1&&fileInfo.indexOf('.jpg')==-1&&fileInfo.indexOf('.JPG')==-1&&fileInfo.indexOf('.JPEG')==-1&&fileInfo.indexOf('.jpeg')==-1&&fileInfo.indexOf('.bmp')==-1&&fileInfo.indexOf('.BMP')==-1){
        		alert("可支持PNG、JPG、jpeg、BMP图片文件格式");
        		return;
        	}
			var option = {
                url: "${ctx}/rest/face/detect?clientType=web" ,//url
			 	type: "POST",//方法类型
			 	dataType: "json",//预期服务器返回的数据类型
				success : function(result) {
						if(result.code==0){
							var griddata;
							griddata = "<table class='data-view-table'><tr><th>性别</th><td>"+result.gender+"</td></tr><tr><th>颜值</th><td>"+result.beauty+"</td></tr><tr><th>年龄</th><td>"+result.age+"</td></tr><tr><th>表情</th><td>"+result.expression+"</td></tr><tr><th>眼镜</th><td>"+result.glasses+"</td></tr><tr><th>人种</th><td>"+result.raceType+"</td></tr><tr><th>脸型</th><td>"+result.faceShape+"</td></tr></table>";							
							$("#resultFace").html(griddata);
						}else{
							var griddata;
							griddata ="<h1 class='h1msg'>"+result.msg+"</h1>";							
							$("#resultFace").html(griddata);
						}
					}
				};
				$("#formface").ajaxSubmit(option);
			}
</script>
</body>
</html>