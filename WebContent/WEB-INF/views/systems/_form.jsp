<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>



<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<c:if test="${system.sysNo == null}">
<label for="${AttributeConst.SYS_NO.getValue()}">システムNo</label><br />
<input type="text" name="${AttributeConst.SYS_NO.getValue()}" id="${AttributeConst.SYS_NO.getValue()}" value="${system.sysNo}" />
<br /><br />
</c:if>


<label for="${AttributeConst.SYS_NAME.getValue()}">システム名</label><br />
<input type="text" name="${AttributeConst.SYS_NAME.getValue()}" id="${AttributeConst.SYS_NAME.getValue()}" value="${system.sysName}" />
<br /><br />

<label for="${AttributeConst.SYS_LEVEL.getValue()}">システムレベル</label><br />
<select name="${AttributeConst.SYS_LEVEL.getValue()}" id="${AttributeConst.SYS_LEVEL.getValue()}">
    <option value="${AttributeConst.SYS_COMMON.getIntegerValue()}" <c:if test="${system.sysLevel == AttributeConst.SYS_COMMON.getIntegerValue()}"> selected</c:if>>一般</option>
    <option value="${AttributeConst.SYS_MEMBER.getIntegerValue()}" <c:if test="${system.sysLevel == AttributeConst.SYS_MEMBER.getIntegerValue()}"> selected</c:if>>会員</option>
    <option value="${AttributeConst.SYS_ADMIN.getIntegerValue()}" <c:if test="${system.sysLevel == AttributeConst.SYS_ADMIN.getIntegerValue()}"> selected</c:if>>管理者</option>
</select>
<br /><br />

<input type="hidden" name="${AttributeConst.ID.getValue()}" value="${system.id}" />
<input type="hidden" name="${AttributeConst.USER_ID.getValue()}" value="${system.sysNo}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">更新</button>