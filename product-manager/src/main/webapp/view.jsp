<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hcl.domain.Product"%>
<html>
    <head>
        <title>Product Manager</title>
    </head>
    <body>
    <h2>Product Detail</h2>
    <% if(request.getAttribute("productAdded") != null && (boolean)request.getAttribute("productAdded")) { %>
        <p style="color:green;">Product Added!</p>
        <a href="add">Add New Product</a>
    <%}%>
    <%
        Product p = (Product)request.getAttribute("product");
        if(p != null) { %>
        <table border ="1" width="600" align="left">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Date Added</th>
            </tr>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getName()%></td>
                <td><%=String.format("%,.2f",p.getPrice())%></td>
                <td><%=p.getDateAdded()%></td>
            </tr>
        <%}%>
    <form action='view' method='get'>
        <label>Enter Product Id: <input type='number' name='productId' required></input></label>
        <input type='submit' value="View Details"></input>
    </form>
    <% if(request.getAttribute("invalidId") != null && (boolean)request.getAttribute("invalidId")) { %>
        <p style="color:red;">Invalid Product Id. Try Again!</p>
    <%}%>
    <a href="list">See All Products</a>
    </body>
</html>