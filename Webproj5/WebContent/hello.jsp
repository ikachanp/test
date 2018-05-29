<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type= "text/css" href= "./css/style.css">
<title>Hello</title>
</head>
<body>
<h1>Hello!!</h1>
<table>
	<tbody>
		<tr>
			<td>USERID</td>
			<td>USERNAME</td>
			<td>PASSWORD</td>
			<td>RESULT</td>
		</tr>

		<s:iterator value="#session.helloStrutsDTOList">
		<tr>
			<th><s:property value="userId"/></th>
			<th><s:property value="userName"/></th>
			<th><s:property value="password"/></th>
			<th><s:property value="result"/></th>
		</tr>
		</s:iterator>
	</tbody>
</table>
</body>
</html>