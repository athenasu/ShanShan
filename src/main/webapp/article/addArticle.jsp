<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>addArticleTest</title>
</head>
<body>

	<form action="<%=request.getContextPath() %>/ArticlePictureServlet.do" method=post enctype="multipart/form-data">
	標題<input type="text" name="article_title" id="artTitle">
	內容<input type="text" name="article_content" id="artContent">
	<input type="file" id="upimg" name="article_picture">
	<input type="hidden" name="action" value="add">
	<input type="submit" value="送出">
</form>
</body>
</html>