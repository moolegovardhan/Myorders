<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>online shopping</title>

<style>
table td {
	font-size: 50px;
	padding: 50px;
}

#demo {
	align: center;
	padding: 80px;
}
a {
    border: 2px solid red;
    border-radius: 10px;
    box-shadow: 0 3px 0 #000;
    padding: 10px;
    text-decoration: none;
    }
</style>
</head>
<body>
	<form action="home" method="post">
		<div id="demo">
			<table>
				<td class="a"><a href="product">Products</a></td>
				<td class="a"><a href="orderview">Orders</a></td>
			</table>
		</div>
	</form>
</body>
</html>