<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="action" value="${ForwardConst.ACT_AUTH.getValue()}" />
<c:set var="actUser" value="${ForwardConst.ACT_USER.getValue()}" />
<c:set var="actSys" value="${ForwardConst.ACT_SYSTEM.getValue()}" />
<c:set var="actSet" value="${ForwardConst.ACT_SET.getValue()}" />
<c:set var="actRsv" value="${ForwardConst.ACT_RSV.getValue()}" />
<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />

<c:set var="commSlgn" value="${ForwardConst.CMD_SHOW_LOGIN.getValue()}" />
<c:set var="commlgn" value="${ForwardConst.CMD_LOGIN.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commRsv" value="${ForwardConst.CMD_RSV.getValue()}" />
<c:set var="commTop" value="${ForwardConst.CMD_TOP.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>Topページ</h2>

        <div >
            <c:choose>
                <c:when test="${user == null}"><a href="<c:url value='?action=${action}&command=${commSlgn}' />">ログインページ</a></c:when>
                <c:otherwise><h3>ようこそ &nbsp; <c:out value="${user.userName}" /> &nbsp;さん</h3></c:otherwise>
            </c:choose>
        </div>


        <h3>
            <a href="<c:url value='?action=${actRsv}&command=${commTop}' />">
                空き状況確認システム(ログインなしで閲覧可能)
            </a>
        </h3>
        <h3>
            <a href="<c:url value='?action=${actRsv}&command=${commIdx}' />">
                予約システム(ログインありで閲覧可能)
            </a>
        </h3>
        <h3>
            <a href="<c:url value='?action=${actUser}&command=${commIdx}' />">
                ユーザー管理(管理者限定)
            </a>
        </h3>
        <h3>
            <a href="<c:url value='?action=${actSys}&command=${commIdx}' />">
                システム管理(管理者限定)
            </a>
        </h3>
        <h3>
            <a href="<c:url value='?action=${actSet}&command=${commIdx}' />">
                組み合わせ管理(管理者限定)
            </a>
        </h3>


    </c:param>
</c:import>