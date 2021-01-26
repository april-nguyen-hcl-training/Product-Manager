import com.hcl.domain.DAO;
import com.hcl.domain.Product;
import com.hcl.domain.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowProducts extends HttpServlet {

    DAO<Product> products;

    public ShowProducts() throws IOException{
        products = new ProductDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = products.getAll();
        request.setAttribute("product", new Product());
        request.setAttribute("productList", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

}
