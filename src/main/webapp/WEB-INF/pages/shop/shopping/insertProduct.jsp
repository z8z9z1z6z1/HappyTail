<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend >新增商品</legend> 
	<form:form method="POST" modelAttribute="productBean" enctype='multipart/form-data'>
		<Table >
		<tr>
		 <td>商品名字：<br>&nbsp;</td>
		 <td width='360'><form:input path='name'/><br>&nbsp;
		</tr>
		<tr>
		<td>商品價格：<br>&nbsp;</td>
		<td width='360'><form:input path='price'/><br>&nbsp;
		</tr>
		<tr>
		<td>商品描述：<br>&nbsp;</td>
		<td width='360'><form:input path='descriptrion'/><br>&nbsp;
		</tr>
		<tr>
		<td>商品數量：<br>&nbsp;</td>
		<td width='360'><form:input path='amount'/><br>&nbsp;
		</tr>
		<tr>
		<td>照片：<br>&nbsp;</td>
		<td width='360'><form:input path='productImage' type='file'/><br>&nbsp;
		</tr>
		<tr>
	    <td colspan='2' align='center'><br>&nbsp;
	      <input type='submit'>
        </td>
	   </tr>
		</Table>
	</form:form>
</fieldset>
</body>
</html>