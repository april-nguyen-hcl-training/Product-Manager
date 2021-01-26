import com.hcl.domain.DAO;
import com.hcl.domain.Product;
import com.hcl.domain.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowDetails extends HttpServlet {
    DAO<Product> products;

    public ShowDetails() throws IOException{
        products = new ProductDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        Product product = null;
        try {
            Long id = Long.parseLong(productId);
            if (!productId.isEmpty() && validId(id)) {
                product = products.get(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("view.jsp").forward(request,response);
            } else {
                request.setAttribute("invalidId", true);
                request.getRequestDispatcher("view.jsp").include(request,response);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean validId(long id) {
        List<Long> validIds = products.getIds();
        if (validIds.contains(id)) {
            return true;
        } else {
            return false;
        }
    }

}
