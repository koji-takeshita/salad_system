<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actSys" value="${ForwardConst.ACT_SYSTEM.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdit" value="${ForwardConst.CMD_EDIT.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>システムNo : ${system.sysNo} の詳細ページ</h2>

        <table id="system_list"  border="1">
            <tbody>
                <tr>
                    <th>システム名</th>
                    <td><c:out value="${system.sysName}" /></td>
                </tr>
                <tr>
                    <th>システム開示レベル</th>
                    <td>
                        <c:choose>
                            <c:when test="${system.sysLevel == AttributeConst.SYS_COMMON.getIntegerValue()}">一般</c:when>
                            <c:when test="${system.sysLevel == AttributeConst.SYS_MEMBER.getIntegerValue()}">会員</c:when>
                            <c:when test="${system.sysLevel == AttributeConst.SYS_ADMIN.getIntegerValue()}">管理者</c:when>
                            <c:otherwise>エラー</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>登録者</th>
                    <td><c:out value="${system.inpUserId}" /></td>
                </tr>
                <tr>
                    <th>登録日</th>
                    <fmt:parseDate value="${system.inpDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="inpDay" type="date" />
                    <td><fmt:formatDate value="${inpDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新者</th>
                    <td><c:out value="${system.updUserId}" /></td>
                </tr>
                <tr>
                    <th>更新日</th>
                    <fmt:parseDate value="${system.updDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updDate" type="date" />
                    <td><fmt:formatDate value="${updDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>
        <p><a href="<c:url value='?action=${actSys}&command=${commIdx}' />">一覧に戻る</a></p>
        <p><a href="<c:url value='?action=${actSys}&command=${commEdit}&id=${system.id}' />">このシステムを編集する</a></p>
    </c:param>
</c:import>