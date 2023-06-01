<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actUser" value="${ForwardConst.ACT_USER.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdit" value="${ForwardConst.CMD_EDIT.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>ユーザーID : ${user.userId} の詳細ページ</h2>

        <table id="user_list"  border="1">
            <tbody>
                <tr>
                    <th>ユーザー名</th>
                    <td><c:out value="${user.userName}" /></td>
                </tr>
                <tr>
                    <th>システム開示レベル</th>
                    <td>
                        <c:choose>
                            <c:when test="${user.sysLevel == AttributeConst.SYS_COMMON.getIntegerValue()}">一般</c:when>
                            <c:when test="${user.sysLevel == AttributeConst.SYS_MEMBER.getIntegerValue()}">会員</c:when>
                            <c:when test="${user.sysLevel == AttributeConst.SYS_ADMIN.getIntegerValue()}">管理者</c:when>
                            <c:otherwise>エラー</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>メニュー利用レベル</th>
                    <td>
                        <c:choose>
                            <c:when test="${user.menuLevel == AttributeConst.MENU_REFERENCE.getIntegerValue()}">参照</c:when>
                            <c:when test="${user.menuLevel == AttributeConst.MENU_UPDATE.getIntegerValue()}">更新</c:when>
                            <c:when test="${user.menuLevel == AttributeConst.MENU_ADMIN.getIntegerValue()}">管理</c:when>
                            <c:otherwise>エラー</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>登録者</th>
                    <td><c:out value="${user.inpUserId}" /></td>
                </tr>
                <tr>
                    <th>登録日</th>
                    <fmt:parseDate value="${user.inpDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="inpDay" type="date" />
                    <td><fmt:formatDate value="${inpDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新者</th>
                    <td><c:out value="${user.updUserId}" /></td>
                </tr>
                <tr>
                    <th>更新日</th>
                    <fmt:parseDate value="${user.updDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updDate" type="date" />
                    <td><fmt:formatDate value="${updDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>
        <p><a href="<c:url value='?action=${actUser}&command=${commIdx}' />">一覧に戻る</a></p>
        <p><a href="<c:url value='?action=${actUser}&command=${commEdit}&id=${user.id}' />">このユーザーを編集する</a></p>
    </c:param>
</c:import>