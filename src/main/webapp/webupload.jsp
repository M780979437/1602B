<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/jslib/webuploader-0.1.5/css/webuploader.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/jslib/jquery-2.1.1.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/jslib/webuploader-0.1.5/dist/webuploader.nolog.min.js" charset="utf-8"></script>
</head>
<body>
<h2>Index</h2>
 <div id="uploader" class="wu-example">
     <!--用来存放文件信息-->
     <div class="filename"></div>
     <div class="state"></div>
     <div class="progress">
         <div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
             <span class="sr-only">40% Complete (success)</span>
         </div>
     </div>
     <div class="btns">
         <div id="picker">选择文件</div>
         <button id="ctlBtn" class="btn btn-default">开始上传</button>
         <button id="pause" class="btn btn-danger">暂停上传</button>
     </div>
 </div>
 
 <script type="text/javascript">
     $(function () {
         var GUID = WebUploader.Base.guid();//一个GUID
         var uploader = WebUploader.create({
             swf: '${pageContext.request.contextPath}/jslib/webuploader-0.1.5/dist/Uploader.swf',
             server: '@Url.Action("Upload")',
             pick: '#picker',
             resize: false,
             chunked: true,//开始分片上传
             chunkSize: 2048000,//每一片的大小
             formData: {
                 guid: GUID //自定义参数，待会儿解释
             }
         });
         uploader.on('fileQueued', function (file) {
             $("#uploader .filename").html("文件名：" + file.name);
             $("#uploader .state").html('等待上传');
         });
         uploader.on('uploadSuccess', function (file, response) {
             $.post('@Url.Action("Merge")', { guid: GUID, fileName: file.name }, function (data) {
                 $list.text('已上传');
             });
         });
         uploader.on('uploadProgress', function (file, percentage) {
             $("#uploader .progress-bar").width(percentage * 100 + '%');
             console.log(percentage);
         });
         uploader.on('uploadSuccess', function () {
             $("#uploader .progress-bar").removeClass('progress-bar-striped').removeClass('active').removeClass('progress-bar-info').addClass('progress-bar-success');
             $("#uploader .state").html("上传成功...");
 
         });
         uploader.on('uploadError', function () {
             $("#uploader .progress-bar").removeClass('progress-bar-striped').removeClass('active').removeClass('progress-bar-info').addClass('progress-bar-danger');
             $("#uploader .state").html("上传失败...");
         });
 
         $("#ctlBtn").click(function () {
             uploader.upload();
             $("#ctlBtn").text("上传");
             $('#ctlBtn').attr('disabled', 'disabled');
             $("#uploader .progress-bar").addClass('progress-bar-striped').addClass('active');
             $("#uploader .state").html("上传中...");
         });
         $('#pause').click(function () {
             uploader.stop(true);
             $('#ctlBtn').removeAttr('disabled');
             $("#ctlBtn").text("继续上传");
             $("#uploader .state").html("暂停中...");
             $("#uploader .progress-bar").removeClass('progress-bar-striped').removeClass('active');
         });
     });
 
 </script>

</body>
</html>