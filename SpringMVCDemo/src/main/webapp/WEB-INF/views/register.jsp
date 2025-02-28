<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- Include Header -->
<jsp:include page="common/header.jsp">
    <jsp:param name="title" value="Register User" />
    <jsp:param name="activeRegister" value="true" />
</jsp:include>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h4 class="mb-0"><i class="fas fa-user-plus me-2"></i>Register New User</h4>
            </div>
            <div class="card-body">
                <form:form method="post" modelAttribute="user" cssClass="needs-validation" novalidate="true">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <div class="input-group">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                            <form:input path="name" id="name" cssClass="form-control" required="true" />
                        </div>
                        <div class="invalid-feedback">
                            Please enter a name.
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <div class="input-group">
                            <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                            <form:input path="email" id="email" cssClass="form-control" type="email" required="true" />
                        </div>
                        <div class="invalid-feedback">
                            Please enter a valid email address.
                        </div>
                    </div>

                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary">
                            <i class="fas fa-save me-2"></i>Register
                        </button>
                        <a href="${pageContext.request.contextPath}/" class="btn btn-outline-secondary">
                            <i class="fas fa-arrow-left me-2"></i>Back to Home
                        </a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<!-- Include Footer -->
<jsp:include page="common/footer.jsp" />

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Register User</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Register User</h1>--%>
<%--<form:form method="post" modelAttribute="user">--%>
<%--    <div>--%>
<%--        <label for="name">Name:</label>--%>
<%--        <form:input path="name" id="name" />--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <label for="email">Email:</label>--%>
<%--        <form:input path="email" id="email" />--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <input type="submit" value="Register">--%>
<%--    </div>--%>
<%--</form:form>--%>
<%--<p><a href="${pageContext.request.contextPath}/">Back to Home</a></p>--%>
<%--</body>--%>
<%--</html>--%>