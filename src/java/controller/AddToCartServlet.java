package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
        if (cartList == null) {
            cartList = new ArrayList<>();
            session.setAttribute("cart-list", cartList);
        }

        int id = Integer.parseInt(request.getParameter("id"));
        boolean exist = false;
        for (Cart c : cartList) {
            if (c.getId() == id) {
                exist = true;
                break;
            }
        }

        if (!exist) {
            Cart cm = new Cart();
            cm.setId(id);
            cm.setQuantity(1);
            cartList.add(cm);
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
        }
    }
}
