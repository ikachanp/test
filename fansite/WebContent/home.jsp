
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
<title>HOME</title>
<style type="text/css">
/* ========TAG LAYOUT======== */


img.main{
	max-width:50%;

	margin: 0 auto;
}
table img{
    width: 150px;
    border-radius: 9px;
}
.link{
    margin-left: auto;
    margin-right: auto;
}



</style>
</head>
<body>
<s:if test="session.loginFlg">ログインしています<a href="<s:url action="GoCartAction"/>">カートページ</a></s:if>

    <div class="login">
        <div class="log">
        <s:if test="!session.loginFlg">
        	<a href="<s:url action="LoginAction"/>">
        			Login
        	</a>/
        </s:if>
        <a href="<s:url action="LogoutAction"/>">
        	LogOut
        </a>

        </div><br>

       <div class="create"> <a href="<s:url action="UserCreateAction"/>">GetAccount</a></div>
    </div>




<div class="margin">

            <h1>ここにサイト名</h1>
            <table id="menu">
                <tr>
                	<td><a href="<s:url action="HomeAction"/>">Home</a></td>
                    <td><a href="<s:url action="NewsAction"/>">News</a></td>
                    <td><a href="<s:url action="CharacterAction"/>">About this site</a></td>
                    <td><a href="<s:url action="ItemAction"/>">Goods</a></td>

                    <s:if test="session.loginFlg">
                		<td><a href="<s:url action="MyPageAction"/>">MyPage</a></td>
                	</s:if>
                </tr>
            </table>
            <br><br><br> <br><br><br><br>

       <img class="main" src="./img/rob.gif">

<br><br><br><br><br><br>
    <table class="link">
        <tr>
            <td><img src="./img/dummy1.png"></td>
            <td><img src="./img/dummy2.png"></td>
            <td><img src="./img/dummy3.png"></td>
        </tr>
    </table>
</div>

</body>
</html>