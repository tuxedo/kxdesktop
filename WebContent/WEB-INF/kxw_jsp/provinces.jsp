<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator id="province" value="provinces" status="status">
	<a href="javascript:"
		onclick="cities('<s:property value="#province.id" />','<s:property value="#province.name" />')"><s:property
		value="#province.name" /></a>&nbsp;&nbsp;  		
		<s:if test="#status.count % 13==0">
		<br>
		<br>
	</s:if>
</s:iterator>
