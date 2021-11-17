<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h1>index.jsp</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Password</th>
			<th>Nickname</th>
			<th>Pass</th>
			<th>Role id</th>
			<th>Creator</th>
			<th>Created date</th>
			<th>Updater</th>
			<th>Last updated date</th>
		</tr>
		<tr>
			<td>${member.id}</td>
			<td>${member.username}</td>
			<td>${member.password}</td>
			<td>${member.nickname}</td>
			<td>${member.pass}</td>
			<td>${member.roleId}</td>
			<td>${member.creator}</td>
			<td>${member.createdDate}</td>
			<td>${member.updater}</td>
			<td>${member.lastUpdatedDate}</td>
		</tr>
	</table>
</body>
</html>
