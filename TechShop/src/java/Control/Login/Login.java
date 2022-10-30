/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Login;

import DAO.AccountDAO;
import Model.Account.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class Login extends HttpServlet {

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
        request.getRequestDispatcher("frontend/jsp/login/login.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        AccountDAO aDB = new AccountDAO();
        User account = aDB.getAccount(email, pass);
       
        
        final String jspPath = "home";
        final String loginJsp = "frontend/jsp/login/login.jsp";
        if (account != null) {
            request.getSession().setAttribute("account", account);
            if (account.getRole().getName()== null) {
//                response.sendRedirect(jspPath);
            } else 
            {
                switch (account.getRole().getName()) {
                    case "Admin":
                        response.sendRedirect(jspPath);
                        break;
                    case "Guest":
                        response.sendRedirect(jspPath);
                        break;
                }
            }
        } else {
            String failed = "Login failed. Please check again!";
            request.setAttribute("failed", failed);
            request.getRequestDispatcher(loginJsp).forward(request, response);
        }
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
