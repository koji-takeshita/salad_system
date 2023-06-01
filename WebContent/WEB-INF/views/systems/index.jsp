<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actSys" value="${ForwardConst.ACT_SYSTEM.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />
<c:set var="commShow" value="${ForwardConst.CMD_SHOW.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <a href="<c:url value='?action=${actTop}&command=${commIdx}' />">トップページへ</a>
        <h2>システム管理</h2>

        <table id="system_list"  border="1">
            <tbody>
                <tr>
                    <th>システムNO</th>
                    <th>システム名名</th>
                    <th>システム開示レベル</th>
                    <th>更新日</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="system" items="${systems}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${system.sysNo}" /></td>
                        <td><c:out value="${system.sysName}" /></td>
                        <td>
                            <c:choose>
                                <c:when test="${system.sysLevel == 9}">
                                    管理者
                                </c:when>
                                <c:when test="${system.sysLevel == 1}">
                                    会員
                                </c:when>
                                <c:otherwise>
                                    一般
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <fmt:parseDate value="${system.updDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updDay" type="date" />
                        <td>
                            <fmt:formatDate value="${updDay}" pattern="yyyy-MM-dd HH:mm:ss" />
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${system.delFlg == 0}">
                                    <a href="<c:url value='?action=${actSys}&command=${commShow}&id=${system.id}' />">詳細を見る</a>
                                </c:when>
                                <c:otherwise>
                                    （削除済み）
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${systems_count} 件中　
            <c:choose>
                <c:when test="${systems_count == 0}"> 0 </c:when>
                <c:when test="${page == 1}"> 1 </c:when>
                <c:otherwise>${ 5 + page -1}</c:otherwise>
            </c:choose>
            ～
            <c:choose>
                <c:when test="${page > (systems_count / 5 )}"> ${systems_count} </c:when>
                <c:otherwise>${page * 5}</c:otherwise>
            </c:choose>
            )
            <br />

            <c:forEach var="i" begin="1" end="${((systems_count - 1) / 5) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='?action=${actSys}&command=${commIdx}&page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='?action=${actSys}&command=${commNew}&id=${system.id}' />">システム新規登録画面へ</a></p>

    </c:param>
</c:import>