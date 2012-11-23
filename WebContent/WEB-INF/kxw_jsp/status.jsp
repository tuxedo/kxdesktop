<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
[
<s:iterator id="element" value="status" status="s">
[<s:property value="#element.id" />,'<s:property
		value="#element.name" />']  		
		<s:if test="#s.last==false">
		,
	   </s:if>
</s:iterator>
]