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
h2{
text-align:center;
}
table.item{
    background-color: azure;
    width: 200;
    border-radius: 9px;
}
.pic{
    float: left;
    width: 200;
    height:200;
}
div.itembox{
    float:left
}
.margin{
margin-left:10%;
margin-right:10%;
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


<div class = "margin">
<h2>GoodsList</h2>


<s:iterator value="#session.ItemInfo" status="st">



<div class="itembox">

    <table>
        <tr>
	       <td><img class ="pic" src='<s:property value='itemImagePath'/>'></td>
     	</tr>
    </table>

    <table class = "item">
	   <tr>
		  <td colspan="2"><s:property value="itemName" /></td>
       </tr>
       <tr>
		  <td> </td>
		  <td align="right"><s:property value="itemPrice" /><span>円</span></td>
		</tr>
		<tr>
		  <td><s:property value="insert_date" /></td>
	   </tr>
		<tr>
			<td> </td>
		  	<td align="right">
		  		<s:form action ="ItemInfoAction">
		  			<s:hidden name ="itemId"/>
		  			<s:submit value = "見る" />
		  		</s:form>
		  	</td>

	   </tr>

    </table>
</div>
</s:iterator>


</div>



</body>
</html>