<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>User Registration</title>
</head>
<body>
<form action="./createuser.do" method="post">
<table>
	<tr>
		<td>Username </td>
		<td><input type="text" name="userName" value="${userDTO.userName}" /></td>
		<td><form:errors path="userDTO.userName"/></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" /></td>
		<td><form:errors path="userDTO.password"/></td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><input type="text" name="firstName" value="${userDTO.firstName}"/></td>
		<td><form:errors path="userDTO.firstName"/></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="lastName" value="${userDTO.lastName}"/></td>
		<td><form:errors path="userDTO.lastName" /></td>
	</tr>	
	<tr>		
		<td colspan="2"><input type="submit" value="Save" /></td>
	</tr>
</table>
</form>
</body>
</html>