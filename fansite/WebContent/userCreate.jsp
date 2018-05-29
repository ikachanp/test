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
<link rel="stylesheet"type="text/css"href="./css/style.css">
<title>新規登録</title>
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

<s:form action="UserCreateConfirmAction">
<s:if test="session.loginFlg">ログインしています</s:if>

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
            <br>

<div class="margin">
    <img  src="./img/userCreate.png">
    <h3>新規ユーザー登録</h3>
<br>




	<s:if test ="sufferFlg">
		<font color=red>ユーザー名が重複してます</font>
	</s:if>
	
	
	
	
	
	<s:if test ="error">
		<font color=red>エラー</font>
	</s:if>
<br>

    <div class="text">
            <br>メールアドレス(ユーザー名になるよ)<br>
            <input type="text" size="" name="username" ><br><br>
			<input type="radio" name="sex" value="1" checked="checked">男
			<input type="radio" name="sex" value="2">女<br><br>

            パスワード(8文字以上16文字以下)<br>
		    <input type="password" size="" name="userpassword" ><br><br>

            <s:submit value="登録"/><br>
        </div>
</div>
</s:form>
</body>
</html>