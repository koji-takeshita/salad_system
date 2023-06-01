<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.AttributeConst" %>
<%@ page import="constants.ForwardConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actUser" value="${ForwardConst.ACT_USER.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commUpd" value="${ForwardConst.CMD_UPDATE.getValue()}" />
<c:set var="commDel" value="${ForwardConst.CMD_DESTROY.getValue()}" />

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>ユーザーID : ${user.userId} のユーザー編集ページ</h2>

        <form method="POST" action="<c:url value='?action=${actUser}&command=${commUpd}' />"
            <c:import url="_form.jsp" />
        </form>


        <p>
            <a href="#" onclick="confirmDestroy();">この従業員情報を削除する</a>
        </p>
        <form method="POST"
            action="<c:url value='?action=${actUser}&command=${commDel}' />">
            <input type="hidden" name="${AttributeConst.ID.getValue()}" value="${user.id}" />
            <input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
        </form>
        <script>
            function confirmDestroy() {
                if (confirm("本当に削除してよろしいですか？")) {
                    document.forms[1].submit();
                }
            }
        </script>



        <p><a href="<c:url value='?action=${actUser}&command=${commIdx}' />">一覧に戻る</a></p>
        <p><a href="<c:url value='?action=${actTop}&command=${commIdx}' />">トップに戻る</a></p>
    </c:param>
</c:import>