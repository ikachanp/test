<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
</head>
<body>
<h1>名前とパスワードを入力してください</h1>
<s:form method ="post" action ="LoginAction">
<s:textfield name="username" label="username:"/>
<s:password name="password" label="password:"/>
<s:submit value ="submit"/>
</s:form>
</body>
</html>