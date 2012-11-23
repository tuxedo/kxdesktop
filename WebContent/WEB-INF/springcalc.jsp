<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算器</title>
</head>
<body>

<s:property value="calculator.message"/>
<s:form action="springcalc">
  <s:textfield  label="操作数1" name="operand1" />
  <s:textfield  label="操作数2" name="operand2" />
  <s:submit value="计算"/>
</s:form>
</body>
</html>  