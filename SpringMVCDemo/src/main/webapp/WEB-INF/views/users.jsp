<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- Include Header -->
<jsp:include page="common/header.jsp">
    <jsp:param name="title" value="User List" />
    <jsp:param name="activeUsers" value="true" />
</jsp:include>

<div class="card shadow">
    <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
        <h4 class="mb-0"><i class="fas fa-users me-2"></i>User List</h4>
        <a href="${pageContext.request.contextPath}/register" class="btn btn-light btn-sm">
            <i class="fas fa-plus me-1"></i>Add User
        </a>
    </div>
    <div class="card-body">
        <c:if test="${empty userList}">
            <div class="alert alert-info" role="alert">
                <i class="fas fa-info-circle me-2"></i>No users registered yet.
            </div>
        </c:if>

        <c:if test="${not empty userList}">
            <div class="table-responsive">
                <table class="table table-hover table-striped">
                    <thead class="table-light">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col"><i class="fas fa-user me-1"></i>Name</th>
                        <th scope="col"><i class="fas fa-envelope me-1"></i>Email</th>
                        <th scope="col"><i class="fas fa-cogs me-1"></i>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user" varStatus="status">
                        <tr>
                            <th scope="row">${status.index + 1}</th>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>
                                <button class="btn btn-sm btn-outline-primary" title="Edit" disabled>
                                    <i class="fas fa-edit"></i>
                                </button>
                                <button class="btn btn-sm btn-outline-danger" title="Delete" disabled>
                                    <i class="fas fa-trash"></i>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="mt-3">
                <p class="text-muted"><i class="fas fa-info-circle me-1"></i>Total Users: ${userList.size()}</p>
            </div>
        </c:if>
    </div>
    <div class="card-footer">
        <a href="${pageContext.request.contextPath}/" class="btn btn-outline-secondary">
            <i class="fas fa-arrow-left me-2"></i>Back to Home
        </a>
    </div>
</div>

<!-- Include Footer -->
<jsp:include page="common/footer.jsp" />

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>User List</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>User List</h1>--%>
<%--<c:if test="${empty userList}">--%>
<%--    <p>No users registered yet.</p>--%>
<%--</c:if>--%>
<%--<c:if test="${not empty userList}">--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>Name</th>--%>
<%--            <th>Email</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${userList}" var="user">--%>
<%--            <tr>--%>
<%--                <td>${user.name}</td>--%>
<%--                <td>${user.email}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</c:if>--%>
<%--<p><a href="${pageContext.request.contextPath}/">Back to Home</a></p>--%>
<%--</body>--%>
<%--</html>--%>