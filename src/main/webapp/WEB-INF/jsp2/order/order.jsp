<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
線上訂位系統
<form action="/order/confirm" method="post">
	<!-- String deskno, String memberno, Date ordertime -->
	桌號 : <input type="text" name="deskno" /><br>
	訂位時間 : <!-- <input type="text" name="ordertime" value="2023-11-05"/><br>--> <input type="date" name="ordertime" /><br>
	<input type="submit" name="確定" /><br>
</form>
</body>
</html>