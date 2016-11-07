<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>保存商品</h1>
	<!-- 这里的action对应struts.xml中配置的action,save对应该action相关类中的方法  theme="simple"表示jsp页面的样式不受struts标签影响 -->
	<s:form action="product_save" method="post" namespace="/" theme="simple">
		<table border="1" width="400">
			<tr>
				<td>商品名称</td>
				<td><s:textfield name="pname"></s:textfield></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><s:textfield name="price"></s:textfield></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>