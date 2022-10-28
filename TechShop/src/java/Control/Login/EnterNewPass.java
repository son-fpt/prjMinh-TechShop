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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author chitung
 */
public class EnterNewPass extends HttpServlet {

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
        request.getRequestDispatcher("frontend/jsp/login/PassRetup.jsp").forward(request, response);
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
        String raw_randomPass = request.getParameter("randomPass");
        RegexChecking v = new RegexChecking();
        HttpSession session = request.getSession();
        String randomPass = (String) session.getAttribute("randomPass");
        String newPass = request.getParameter("password");
        String email = (String) session.getAttribute("email");
        String confirmPass = request.getParameter("confirmPassword");
        
        final String jspPath = "frontend/jsp/login/PassRetup.jsp";
        if (raw_randomPass.equals(randomPass)) {
            if (v.validatePass(newPass) && v.validatePass(confirmPass)) {
                if (newPass.equals(confirmPass)) {
                    User a = new User();
                    a.setPassword(newPass);
                    a.setEmail(email);
                    AccountDAO dAc = new AccountDAO();
                    dAc.updatePass(a);
                    
                    
                    //send to home page
                    response.sendRedirect("home");
                } else {
                    String confirmFailed = "New password and confirm password are not the same. Please try again.";
                    request.setAttribute("confirmFailed", confirmFailed);
                    request.getRequestDispatcher(jspPath).forward(request, response);
                }
            } else {
                String error = "You need to enter the correct requirements for each subscription.";
                request.setAttribute("error", error);
                request.getRequestDispatcher(jspPath).forward(request, response);
            }
        } else {
            String notCorrect = "Wrong Code. Try again!";
            request.setAttribute("notCorrect", notCorrect);
            request.getRequestDispatcher(jspPath).forward(request, response);
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
