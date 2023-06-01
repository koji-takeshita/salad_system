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

<c:if test="${user.userId == null}">
<label for="${AttributeConst.USER_ID.getValue()}">ユーザーID</label><br />
<input type="text" name="${AttributeConst.USER_ID.getValue()}" id="${AttributeConst.USER_ID.getValue()}" value="${user.userId}" />
<br /><br />
</c:if>


<label for="${AttributeConst.USER_NAME.getValue()}">ユーザー名</label><br />
<input type="text" name="${AttributeConst.USER_NAME.getValue()}" id="${AttributeConst.USER_NAME.getValue()}" value="${user.userName}" />
<br /><br />

<label for="${AttributeConst.USER_PASS.getValue()}">パスワード</label><br />
<input type="password" name="${AttributeConst.USER_PASS.getValue()}" id="${AttributeConst.USER_PASS.getValue()}" />
<br /><br />

<label for="${AttributeConst.SYS_LEVEL.getValue()}">システムレベル</label><br />
<select name="${AttributeConst.SYS_LEVEL.getValue()}" id="${AttributeConst.SYS_LEVEL.getValue()}">
    <option value="${AttributeConst.SYS_COMMON.getIntegerValue()}" <c:if test="${user.sysLevel == AttributeConst.SYS_COMMON.getIntegerValue()}"> selected</c:if>>一般</option>
    <option value="${AttributeConst.SYS_MEMBER.getIntegerValue()}" <c:if test="${user.sysLevel == AttributeConst.SYS_MEMBER.getIntegerValue()}"> selected</c:if>>会員</option>
    <option value="${AttributeConst.SYS_ADMIN.getIntegerValue()}" <c:if test="${user.sysLevel == AttributeConst.SYS_ADMIN.getIntegerValue()}"> selected</c:if>>管理者</option>
</select>
<br /><br />

<label for="${AttributeConst.MENU_LEVEL.getValue()}">メニューレベル</label><br />
<select name="${AttributeConst.MENU_LEVEL.getValue()}" id="${AttributeConst.MENU_LEVEL.getValue()}">
    <option value="${AttributeConst.MENU_REFERENCE.getIntegerValue()}" <c:if test="${user.menuLevel == AttributeConst.MENU_REFERENCE.getIntegerValue()}"> selected</c:if>>参照</option>
    <option value="${AttributeConst.MENU_UPDATE.getIntegerValue()}" <c:if test="${user.menuLevel == AttributeConst.MENU_UPDATE.getIntegerValue()}"> selected</c:if>>更新</option>
    <option value="${AttributeConst.MENU_ADMIN.getIntegerValue()}" <c:if test="${user.menuLevel == AttributeConst.MENU_ADMIN.getIntegerValue()}"> selected</c:if>>管理</option>
</select>
<br /><br />


<input type="hidden" name="${AttributeConst.ID.getValue()}" value="${user.id}" />
<input type="hidden" name="${AttributeConst.USER_ID.getValue()}" value="${user.userId}" />
<input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
<button type="submit">更新</button>