<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <ul>
        <li><a href="<c:url value="${pageContext.request.contextPath }/addgeo"/>" target="_blank">Для физ. лиц</a>
        </li>
        <li><a href="<c:url value="${pageContext.request.contextPath }/addgeoyur"/>" target="_blank">Для юр. лиц</a>
        </li>
        <li><a href="<c:url value="${pageContext.request.contextPath }/organizacii"/>" target="_blank">Справочник юр. лиц</a>
        </li>

    </ul>
</nav>