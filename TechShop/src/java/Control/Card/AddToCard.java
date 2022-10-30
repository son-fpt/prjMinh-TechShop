/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Card;

import DAO.DAOProduct;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import Model.Account.User;
import Model.Order.Order;
import Model.Order.OrderDetail;
import Model.Product.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class AddToCard extends HttpServlet {

    private SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hs = request.getSession();
        User user = (User) hs.getAttribute("account");
        if (user != null && (user.getRole().getName().equals("Guest") || user.getRole().getName().equals("Admin"))) {
            String pid = request.getParameter("id");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            System.out.println(pid);
            System.out.println(quantity);
            DAOProduct p = new DAOProduct();
            OrderDAO o = new OrderDAO();
            OrderDetailDAO od = new OrderDetailDAO();
            Product product = p.getProById(pid);
            // when today is not have any order, create new order and order detail
            ArrayList<Order> listOrder = o.getOrderByUser(user.getEmail());
            for (Order ord : listOrder) {
                if (!f.format(ord.getDate()).equals(f.format(new Date()))) {
                    Order order = new Order();
                    order.setMail(user.getEmail());
                    order.setOid(listOrder.size() + 1);
                    o.InsertOrder(order);
                    // create new order detail
                    OrderDetail orde = new OrderDetail();
                    orde.setOid(order.getOid());
                    orde.setPid(pid);
                    orde.setPrice(product.getPrice());
                    orde.setQuantity(quantity);
                    od.InsertOD(orde);
                    break;
                } else {
                    // create new order detail
                    OrderDetail orde = new OrderDetail();
                    orde.setOid(listOrder.size());
                    orde.setPid(pid);
                    orde.setPrice(product.getPrice());
                    orde.setQuantity(quantity);
                    od.InsertOD(orde);
                    break;
                }
            }
        } else {
            response.getWriter().println("Please login to order!");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
