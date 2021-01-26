import com.hcl.domain.DAO;
import com.hcl.domain.Product;
import com.hcl.domain.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AddProduct extends HttpServlet {
    DAO<Product> products;

    public AddProduct() throws IOException {
        products = new ProductDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("productName");
        String priceInput = request.getParameter("productPrice");
        Double price = Double.parseDouble(priceInput);
        if (price > 0) {
            Product addedProduct = products.add(new Product(
                    null,
                    name,
                    price,
                    new Date()
            ));
            request.setAttribute("product", addedProduct);
            request.setAttribute("productAdded", true);
            request.getRequestDispatcher("view.jsp").forward(request,response);
        } else {
            request.setAttribute("invalidPrice", true);
            request.getRequestDispatcher("add.jsp").include(request,response);
        }

    }

}
