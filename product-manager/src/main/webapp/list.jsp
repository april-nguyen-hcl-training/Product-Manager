<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hcl.domain.Product"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <title>Product Manager</title>
    </head>
    <body>
    <h3>Product List</h3>
    <%
        List<Product> products = (List<Product>)request.getAttribute("productList");
        if(!products.isEmpty()) { %>
        <table border ="1" width="500" align="left">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <% for(Product p : products) { %>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getName()%></td>
                <td><%=String.format("%,.2f",p.getPrice())%></td>
            </tr>
            <%}%>
        <%}else {%>
            <p style="color:red;">No Products in Database</p>
            <a href="add">Add New Product</a>
        <%}%>

    </body>
</html>
