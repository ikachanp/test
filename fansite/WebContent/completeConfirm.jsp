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
<title>CART</title>
<style type="text/css">
/* ========TAG LAYOUT======== */
h2{
text-align:center;
}
table.item{
    background-color: azure;
    width: 200;
    border-radius: 9px;
}
.pic{
	folat:left;
    width: 100;
    height:100;
}
.box{
	background-color:azure;
	width:70%;

}
.box1{
	float:right;
	font-size:26px;
	background-color:lightgoldenrodyellow;
	margin-top:5px;
	padding:10;
	border-radius: 9px;
}
.botton{
	float:right;
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





            <h1>ECサイト</h1>
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

<div class ="margin">

<h2>以下の商品を購入します</h2>


<s:iterator value="#session.cartDTOList">
<s:property value ="itemName"/>
<span>合計</span><s:property value ="totalPrice"/><span>円</span>
<s:property value = "totalCount"/><span>個</span><br>

</s:iterator><br><br><br>


<script>
var total = 0;

<s:iterator value="session.cartDTOList">
total += parseInt('<s:property value="totalPrice"/>',10);
</s:iterator>

	document.write("合計"+total+"円");
</script><br><br><br>


<s:form action ="CompleteAction">
<s:submit value="確定"/>
	</s:form>
</div>





</body>
</html>