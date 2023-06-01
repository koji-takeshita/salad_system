<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actUser" value="${ForwardConst.ACT_USER.getValue()}" />

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
        <h2>ユーザー管理システム</h2>

        <table id="user_list"  border="1">
            <tbody>
                <tr>
                    <th>ユーザーID</th>
                    <th>ユーザー名</th>
                    <th>システムレベル</th>
                    <th>メニューレベル</th>
                    <th>更新日</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="user" items="${users}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${user.userId}" /></td>
                        <td><c:out value="${user.userName}" /></td>
                        <td>
                            <c:choose>
                                <c:when test="${user.sysLevel == 9}">
                                    管理者
                                </c:when>
                                <c:when test="${user.sysLevel == 1}">
                                    会員
                                </c:when>
                                <c:otherwise>
                                    一般
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${user.menuLevel == 9}">
                                    管理
                                </c:when>
                                <c:when test="${user.menuLevel == 1}">
                                    更新
                                </c:when>
                                <c:otherwise>
                                   一般
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <fmt:parseDate value="${user.updDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updDay" type="date" />
                        <td>
                            <fmt:formatDate value="${updDay}" pattern="yyyy-MM-dd HH:mm:ss" />
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${user.delFlg == 0}">
                                    <a href="<c:url value='?action=${actUser}&command=${commShow}&id=${user.id}' />">詳細を見る</a>
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
            （全 ${users_count} 件中　
            <c:choose>
                <c:when test="${users_count == 0}"> 0 </c:when>
                <c:when test="${page == 1}"> 1 </c:when>
                <c:otherwise>${ 5 + page -1}</c:otherwise>
            </c:choose>
            ～
            <c:choose>
                <c:when test="${page > (users_count / 5 )}"> ${users_count} </c:when>
                <c:otherwise>${page * 5}</c:otherwise>
            </c:choose>
            )
            <br />

            <c:forEach var="i" begin="1" end="${((users_count - 1) / 5) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='?action=${actUser}&command=${commIdx}&page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='?action=${actUser}&command=${commNew}&id=${user.id}' />">ユーザー新規登録画面へ</a></p>

    </c:param>
</c:import>