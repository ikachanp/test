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
<title>ITEMINFO</title>
<style type="text/css">
/* ========TAG LAYOUT======== */
h2{
text-align:center;
}
.pic{
	float;right;
	width:500px;
	margin: 0 auto;
}
.itemInfoBox{
	float;right;
	background-color: azure;
    width: 500px;
    border-radius: 9px;
    font-size:25px;
}
.cart{
	text-align:right;
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


<s:iterator value="#session.ItemInfo" status="st">

	<s:if test ="itemId == session.get('itemNumber')">
		<h2><s:property value='itemName'/></h2>
<div class = "margin">
		<img class ="pic" src='<s:property value='itemImagePath'/>'><br><br>

		<div class = "itemInfoBox">

			<br>
			<div>商品説明</div>

			<span>税込</span><s:property value="itemPrice" /><span>円</span>
			<span>在庫</span><s:property value="itemStock" /><span>個</span><br><br>

			<s:form action ="CartAction">
				<s:hidden name="itemId"/>
				<s:hidden name="itemName"/>
				<s:hidden name="itemPrice"/>
				<div class = "cart">
				<span>個数</span><input type ="text" maxlength = "2" size = "1" id="number" name="itemCount"><span>個</span>
					<input type="submit" value="カートに入れる"/>
				</div>
			</s:form>
		</div>

</div>

	</s:if>

</s:iterator>


</body>
</html>