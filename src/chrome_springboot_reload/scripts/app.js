$(document).ready(function() {
	
	function ajaxFileUpload(uploadUrl, reloadClassName) {
		$.ajaxFileUpload
		(
			{
				url: uploadUrl, //用于文件上传的服务器端请求地址
				secureuri: false, //是否需要安全协议，一般设置为false
				data : {
                        reloadClassName : reloadClassName
                },
				fileElementId: 'uploadFile', //文件上传域的ID
				dataType: 'json', //返回值类型 一般设置为json
				success: function (data, status)  //服务器成功响应处理函数
				{
					alert(data);
					if (typeof (data.error) != 'undefined') {
						if (data.code != -1) {
							alert(data.error);
						} else {
							alert(data.message);
						}
					}
				},
				error: function (data, status, e)//服务器响应失败处理函数
				{
					// 其实已经上传成功,但是由于跨域会执行到这里
					// alert(e);
				}
			}
		)
	}
	
	$("#upload").click(function(){
		var targetServer = $("#host").val();
		var uploadUrl = targetServer + '/actuator/online-reload/debug-reload-spring';
		var reloadClassName = $("#reloadClassName").val();
		var reloadServerNumber = $("#reloadServerNumber").val();
		for( i = 0; i< reloadServerNumber; i++){
			ajaxFileUpload(uploadUrl, reloadClassName);
		}
		$("#last_doc").append("上传完成,快去看日志吧! <br/>");
	});
	
	function queryLastLoadAuthInfo(host, className){
	    $.getJSON(host+"/actuator/online-reload/debug-last?className="+className, function(data){
		   $("#last_doc").append("时间："+data.timestamp + "<br/>").append("IP："+data.ip + "<br/>");
	   });
	}
	
	$("#query").click(function() {
		queryLastLoadAuthInfo($("#host").val(), $("#className").val());
	});
	
});

  