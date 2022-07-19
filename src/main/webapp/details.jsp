<%@ page import="entities.Product" %><%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 19.07.2022
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <link rel="stylesheet" href="css/details.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
    Product product = (Product) request.getAttribute("product");
%>
<div class="container d-flex justify-content-center">
    <figure class="card card-product-grid card-lg"> <a href="#" class="img-wrap" data-abc="true"> <img src="images/product_img.png" alt="product"></a>
        <div class="info-wrap">
            <div class="row">
                <div class="col-md-9 col-xs-9"> <a href="#" class="title" data-abc="true"><%= product.getName()%></a> <span class="rated">Foods</span> </div>
                <div class="col-md-3 col-xs-3">
                    <div class="rating text-right"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <span class="rated">Rated 4.0/5</span> </div>
                </div>
            </div>
        </div>
        <div class="bottom-wrap-payment">
            <div class="info-wrap">
                <div class="row">
                    <div class="col-md-9 col-xs-9"> <a href="#" class="title" data-abc="true"><%= product.getPrice()%> $</a> <span class="rated">VISA Platinum</span> </div>
                    <div class="col-md-3 col-xs-3">
                        <div class="rating text-right"> <%= product.getDescription()%></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="bottom-wrap"> <a href="bucket.jsp" class="btn btn-primary float-right" data-abc="true"> Buy now </a>
            <div class="price-wrap"> <a href="index.jsp" class="btn btn-warning float-left" data-abc="true"> Cancel </a> </div>
        </div>
    </figure>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
