<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet"type="text/css"href="">
<title>ヘッダー</title>
<style type="text/css">

</style>
</head>
<body>
<a href="<s:url action="HomeAction"/>">Home</a>
<a href="<s:url action="HomeAction"/>">Mypage</a>
<a href="<s:url action="HomeAction"/>">Cart</a>
<a href="<s:url action="Action"/>">Product</a>
<a href="<s:url action="HomeAction"/>">Login</a>
<a href="<s:url action="HomeAction"/>">Logout</a>
<a href="<s:url action="UserCreateAction"/>">UserCreate</a>
<!-- ///////////////////////検索機能///////////////////////// -->
<s:form action="ProductSearchAction">

	<select name="category">
		<option value="0">0</option>
		<option value="1">1</option>
		<option value="2">2</option>
	</select>

		<span>検索:</span><input type="text" name="search" size="5">
		<s:submit value="検索"/>
</s:form>

<!-- ///////////////////////ここまで///////////////////////// -->


</body>
</html>