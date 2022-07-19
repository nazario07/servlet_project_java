<%@ page import="entities.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%
    Product product = (Product) request.getAttribute("product");
%>
<div class="row row-cols-1 row-cols-sm-3 row-cols-md-4 g-4">
    <div class="col">
        <div class="card shadow-sm">
            <img src="http://localhost:8080/ProjectServlets_war_exploded/images/product_img.png" alt="product">
            <div class="card-body">
                <h3><%= product.getName()%></h3>
                <p class="card-text"><%= product.getDescription()%></p>
                <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                        <button type="button" class="btn btn-sm btn-outline-success">
                            <i class="fa-solid fa-basket-shopping"></i>
                        </button>
                    </div>
                    <span class="text-muted"><%= product.getPrice()%></span>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
