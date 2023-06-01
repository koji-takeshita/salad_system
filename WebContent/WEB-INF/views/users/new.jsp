<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actUser" value="${ForwardConst.ACT_USER.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commCrt" value="${ForwardConst.CMD_CREATE.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>メッセージ新規作成ページ</h2>
        <form method="POST" action="<c:url value='?action=${actUser}&command=${commCrt}' />"
            <c:import url="_form.jsp" />
        </form>
<br></br>
        <a href="<c:url value='?action=${actUser}&command=${commIdx}' />">一覧に戻る</a>
        <br></br>
        <a href="<c:url value='?action=${actTop}&command=${commIdx}' />">トップに戻る</a>



    </c:param>
</c:import>