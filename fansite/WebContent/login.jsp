
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet"type="text/css"href="./css/style.css">
<title>LOGIN</title>
<style type="text/css">
/* ========TAG LAYOUT======== */


img{
    width: 100%;
    border-radius: 9px;
    position: relative;

}

.margin{
    margin-left: 25%;
    margin-right: 25%;
    background-color: skyblue;
    border-bottom: 2px solid blue;
    border-top:2px solid blue;
    border-radius: 9px;
    padding-left: 20px;
    padding-right:20px;
}
</style>
</head>
<body>
<s:form action="MyPageLoginAction">
    <div class="login">
        <div class="log">
        	<a href="<s:url action="LoginAction"/>">
        		Login
        	</a>/
        <a href="<s:url action="LogoutAction"/>">
        	LogOut
        </a>

        </div><br>

       <div class="create"> <a href="<s:url action="UserCreateAction"/>">GetAccount</a></div>
    </div>






            <h1>ここにサイト名</h1>
            <table id="menu">
                <tr>
                	<td><a href="<s:url action="HomeAction"/>">Home</a></td>
                    <td><a href="<s:url action="NewsAction"/>">News</a></td>
                    <td><a href="<s:url action="CharacterAction"/>">About this site</a></td>
                    <td><a href="<s:url action="ItemAction"/>">Goods</a></td>
                </tr>
            </table><br><br><br>

<div class="margin">
    <img  src="./img/login.png">
    <h3>ログインページ</h3>
<br>


<br>

    <div class="text">
            <br>メールアドレス(ユーザー名)<br>
            <input type="text" size="" name="username" ><br><br>

            パスワード<br>
		    <input type="password" size="" name="userpassword" ><br><br>

            <s:submit value="ログイン"/><br>
        </div>
</div>
</s:form>
</body>
</html>