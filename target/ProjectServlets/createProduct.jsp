<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="width: 70%; margin: 30px auto">
    <form onsubmit="handleCreateProduct(event)">
        <div class="mb_3">
            <label for="name" class="form-label">Product Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb_3">
            <label for="description" class="form-label">Description</label>
            <textarea id="description" class="form-control" name="description" rows="3"></textarea>
        </div>
        <div class="mb_3">
            <label for="price" class="form-label">Price in $</label>
            <input type="number" id="price" class="form-control" min="1" name="price">
        </div>
        <input type="submit" class="btn_btn-primary">
    </form>
</div>
<script src="js/form-handler.js"></script>
</body>
</html>
