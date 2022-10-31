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

    private final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

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
            String quantity_raw = request.getParameter("quantity");
            
            quantity_raw = (quantity_raw == null || quantity_raw.length() == 0) ? "1" : quantity_raw;
            int quantity = Integer.parseInt(quantity_raw);
            
            DAOProduct p = new DAOProduct();
            OrderDAO o = new OrderDAO();
            OrderDetailDAO od = new OrderDetailDAO();
            
            Product product = p.getProById(pid);
            Order order = new Order();
            OrderDetail orde = new OrderDetail();
            ArrayList<Order> listOrder = o.getOrderByUser(user.getEmail());
            
            
            if (listOrder.isEmpty()) {
                // set trước một số thuộc tính của order detail để add luôn vào thuộc tính price ở order
                orde.setPid(pid);
                orde.setPrice(product.getPrice());
                orde.setQuantity(quantity);
                double total = orde.getPrice() * orde.getQuantity();
                
                order.setTotalmoney(total);
                order.setMail(user.getEmail());
                order.setStatus(false);
                // add order moi khi list order trống
                o.InsertOrder(order);
                // load lai list order trong trương hop list trống ban dau
                listOrder = o.getOrderByUser(user.getEmail());
                // set id theo order vua them o tren
                orde.setOid(listOrder.get(listOrder.size() - 1).getOid());
                // add order detail 
                od.InsertOD(orde);
            } else {
                for (Order ord : listOrder) {
                    if (!f.format(ord.getDate()).equals(f.format(new Date()))) {
                        order.setMail(user.getEmail());
                        // create new order detail
                        orde.setOid(listOrder.get(listOrder.size() - 1).getOid() + 1);
                        orde.setPid(pid);
                        orde.setPrice(product.getPrice());
                        orde.setQuantity(quantity);
                        double total = orde.getPrice() * orde.getQuantity();
                        order.setTotalmoney(total);
                        order.setStatus(false);
                        o.InsertOrder(order);
                        od.InsertOD(orde);
                        break;
                    } else {
                        // create new order detail
                        orde.setOid(listOrder.get(listOrder.size() - 1).getOid());
                        orde.setPid(pid);
                        orde.setPrice(product.getPrice());
                        orde.setQuantity(quantity);
                        System.out.println(orde.toString());
                        double total = orde.getPrice() * orde.getQuantity();
                        Order getLast = listOrder.get(listOrder.size() - 1);
                        getLast.setTotalmoney(total);
                        o.UpdateTotalprice(getLast.getTotalmoney(), getLast.getOid());
                        od.InsertOD(orde);
                        break;
                    }
                }
            }

            response.sendRedirect("home");
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
