<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Product Manager</title>
    </head>
    <body>
        <h2>Add Product</h2>
        <form action='' method='post'>
            <label>Enter Product Name: <input type='text' name='productName' required></input></label>
            <label>Enter Product Price: $<input type='number' name='productPrice' step=".01" required></input></label>
            <input type='submit' value="Add"></input>
        </form>

        <% if(request.getAttribute("invalidPrice") != null && (boolean)request.getAttribute("invalidPrice")) { %>
            <p style="color:red;">Price must be greater than 0!</p>
        <%}%>

    </body>
</html>
