<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator id="city" value="cities" status="status">

	<a href="javascript:"
		onclick="cityOnClick('<s:property value="#city.id" />','<s:property value="#city.name" />')"><s:property
		value="#city.name" /></a>&nbsp;&nbsp;  		
		<s:if test="#status.count % 11==0">
		<br>
		<br>
	</s:if>
</s:iterator>
 