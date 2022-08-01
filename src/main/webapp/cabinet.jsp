<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
    <link rel="stylesheet" href="css/cabinet.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="welcome">
    <p><%=session.getAttribute("firstName")%> welcome in you cabinet! We are glad to see you in our store!</p>
    <p>Some information about you:</p>
</div>
<div class="inform">

    <p>Your full name: <%=session.getAttribute("firstName")+" "+session.getAttribute("lastName")%></p>
    <p>Your email: <%=session.getAttribute("email")%></p>
</div>

<div>

    <button class="button-5" role="button"><a href="bucket.jsp">Go to bucket</a></button>


</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
