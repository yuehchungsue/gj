<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import="com.example.demo.vo.dataentity.order1"
    import="com.example.demo.vo.member"%>
 <%
 /*
 1.�^�� session-->p
 2.�T�{-->�q��
 */
 
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
			<%=m.getName() %> �o�O�A���q����
		<tr>
			<td width=100>�ู
			<td><%=p.getDeskno() %>
		<tr>
			<td>���
			<td><%=p.getOrdertime() %>
		<tr>
			<td colspan=2 align=center>
			<a href="/order/order">�^�W�@��</a>
			<a href="/order/finish">�T�w</a>
	</table>

</body>
</html>