<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="resp"></div><input type="button" onclick="req();"value="请求"/>
	<script src="assets/js/jquery-3.2.1.js" type="text/javascript"></script><!-- 不要写错标签，src属性依然有用（依然能通过src找到js），但是无法实现scirpt标签的功能 -->
<script>
	function req(){
		$.ajax({
			url:"convert",
			data:"1-hahah",
			type:"POST",
			contentType:"application/haha-straw",
			success: function(data){
				$("#resp").html(data);
			}
		});
	}

</script>
</body>
</html>
