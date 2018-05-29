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
<title>MYPAGE</title>
<style type="text/css">
/* ========TAG LAYOUT======== */
.box{
	background-color:azure;
	width:70%;

}
.box1{

	font-size:26px;
	background-color:lightgoldenrodyellow;
	margin-top:5px;
	margin-bottom:20;
	padding:10;
	border-radius: 9px;
}

.margin{
margin-left:10%;
margin-right:10%;
}
</style>
</head>
<body>
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


</div>
<div class="margin">
<h2 align="center">購入済み商品リスト</h2><br><br><br>
<s:iterator value="myPageLoginList">

		<span class="box1">
		商品情報
			<s:property value="itemName"/>
			<span>合計</span><s:property value="totalPrice"/><span>円</span>
			<s:property value="totalCount"/><span>個</span>

		</span><br><br>

<br>


</s:iterator>

</div>
</body>
</html>