<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="com.example.demo.vo.dataentity.order1"
    import="com.example.demo.vo.member"%>
 <%
 order1 p=(order1)session.getAttribute("P");
 
 member m=(member)session.getAttribute("M");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<table width=400 align=center border=1>
		<tr>
			<td colspan=2 align=center>
			<%=m.getName() %>訂單完成 , 這是你的訂位詳細資料
		<tr>
			<td width=100>桌號
			<td><%=p.getDeskno() %>
		<tr>
			<td>日期
			<td><%=p.getOrdertime() %>
		<tr>
			<td colspan=2 align=center>
			<a href="/porder/logout">登出</a>
	</table>
</body>
</html>