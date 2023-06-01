<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actTop" value="${ForwardConst.ACT_TOP.getValue()}" />
<c:set var="actUser" value="${ForwardConst.ACT_USER.getValue()}" />
<c:set var="actSys" value="${ForwardConst.ACT_SYSTEM.getValue()}" />
<c:set var="actRsv" value="${ForwardConst.ACT_RSV.getValue()}" />
<c:set var="actAuth" value="${ForwardConst.ACT_AUTH.getValue()}" />

<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commOut" value="${ForwardConst.CMD_LOGOUT.getValue()}" />
<c:set var="commNew" value="${ForwardConst.CMD_NEW.getValue()}" />

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
    <title><c:out value="サラダシステム" /></title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
    <div id="wrapper">

        <div id="header">
            <div id="header_menu">
                <h1><a href="<c:url value='/?action=${actTop}&command=${commIdx}' />">サラダシステム</a></h1>&nbsp;&nbsp;&nbsp;
            </div>
            <c:if test="${sessionScope.login_user != null}">
                <div id="user_name">
                    <c:out value="${sessionScope.login_user.userName}" />
                    &nbsp;さん&nbsp;が&nbsp;ログインしています&nbsp;&nbsp;&nbsp;
                    <a href="<c:url value='?action=${actAuth}&command=${commOut}' />">ログアウト</a>
                </div>
            </c:if>
        </div>


    <div class="gnavi__wrap">
        <c:if test="${sessionScope.login_user != null}">
            <ul class="gnavi__lists">

                <c:if test="${sessionScope.login_user.menuLevel == AttributeConst.MENU_ADMIN.getIntegerValue()}">
                    <li class="gnavi__list">
                        <a href="<c:url value='?action=${actUser}&command=${commIdx}' />">ユーザー管理</a>
                        <ul class="dropdown__lists">
                            <li class="dropdown__list">
                            <a href="<c:url value='?action=${actUser}&command=${commNew}' />">登録</a>
                            </li>
                        </ul>
                    </li>
                </c:if>

                <c:if test="${sessionScope.login_user.menuLevel == AttributeConst.MENU_ADMIN.getIntegerValue()}">
                    <li class="gnavi__list">
                        <a href="<c:url value='?action=${actSys}&command=${commIdx}' />">システム管理</a>
                        <ul class="dropdown__lists">
                            <li class="dropdown__list">
                            <a href="<c:url value='?action=${actSys}&command=${commNew}' />">登録</a>
                            </li>
                        </ul>
                    </li>
                </c:if>

                <li class="gnavi__list">
                    <a href="<c:url value='?action=${actRsv}&command=${commIdx}' />">予約管理</a>
                    <ul class="dropdown__lists">
                        <li class="dropdown__list">
                            <a href="<c:url value='?action=${actRsv}&command=${commNew}' />">登録</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </c:if>
    </div>



        <div id="content">${param.content}</div>
        <div id="footer">by By bY</div>
    </div>
</body>
</html>