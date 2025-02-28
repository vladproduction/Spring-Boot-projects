<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- Include Header -->
<jsp:include page="common/header.jsp">
    <jsp:param name="title" value="Home" />
    <jsp:param name="activeHome" value="true" />
</jsp:include>

<!-- Hero Section -->
<div class="jumbotron bg-light rounded-3 p-5 mb-4">
    <h1 class="display-4">Welcome to Spring MVC Demo</h1>
    <p class="lead">A simple demonstration of Spring MVC framework structure, controllers, models, and views.</p>
    <hr class="my-4">
    <p>Learn about Spring MVC components and build a simple web application with a clean, modern UI.</p>
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/register" role="button">
        <i class="fas fa-user-plus me-1"></i> Get Started
    </a>
</div>

<!-- Feature Cards -->
<div class="row row-cols-1 row-cols-md-3 g-4 mb-4">
    <!-- Card 1 -->
    <div class="col">
        <div class="card h-100">
            <div class="card-body">
                <h5 class="card-title"><i class="fas fa-server text-primary me-2"></i>DispatcherServlet</h5>
                <p class="card-text">The front controller in Spring MVC that handles all incoming requests and dispatches them to appropriate handlers.</p>
            </div>
            <div class="card-footer">
                <small class="text-muted">Core Spring MVC Component</small>
            </div>
        </div>
    </div>

    <!-- Card 2 -->
    <div class="col">
        <div class="card h-100">
            <div class="card-body">
                <h5 class="card-title"><i class="fas fa-code text-primary me-2"></i>Controllers</h5>
                <p class="card-text">Handle requests, process input data, and return appropriate views with model data.</p>
            </div>
            <div class="card-footer">
                <small class="text-muted">Annotated with @Controller</small>
            </div>
        </div>
    </div>

    <!-- Card 3 -->
    <div class="col">
        <div class="card h-100">
            <div class="card-body">
                <h5 class="card-title"><i class="fas fa-layer-group text-primary me-2"></i>Models & Views</h5>
                <p class="card-text">Pass data from controllers to views and render dynamic content based on that data.</p>
            </div>
            <div class="card-footer">
                <small class="text-muted">Data and Presentation</small>
            </div>
        </div>
    </div>
</div>

<!-- Information Section -->
<div class="row mb-4">
    <div class="col-md-6">
        <h3>About This Demo</h3>
        <p>This application demonstrates the fundamentals of Spring MVC without using Spring Boot. It includes:</p>
        <ul>
            <li>Manual configuration of Spring MVC components</li>
            <li>Working with controllers and request mappings</li>
            <li>Data binding and form handling</li>
            <li>JSP views with JSTL</li>
        </ul>
    </div>
    <div class="col-md-6">
        <h3>Technologies Used</h3>
        <ul class="list-group">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                Java 17
                <span class="badge bg-primary rounded-pill"><i class="fab fa-java"></i></span>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                Spring MVC
                <span class="badge bg-success rounded-pill"><i class="fas fa-leaf"></i></span>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                Jakarta EE
                <span class="badge bg-info rounded-pill"><i class="fas fa-globe"></i></span>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                Bootstrap 5
                <span class="badge bg-secondary rounded-pill"><i class="fab fa-bootstrap"></i></span>
            </li>
        </ul>
    </div>
</div>

<!-- Include Footer -->
<jsp:include page="common/footer.jsp" />

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Spring MVC Demo</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Welcome to Spring MVC Demo</h1>--%>
<%--<p>This is a simple Spring MVC application using Jakarta EE</p>--%>
<%--<p><a href="${pageContext.request.contextPath}/register">Register User</a></p>--%>
<%--<p><a href="${pageContext.request.contextPath}/users">View Users</a></p>--%>
<%--</body>--%>
<%--</html>--%>