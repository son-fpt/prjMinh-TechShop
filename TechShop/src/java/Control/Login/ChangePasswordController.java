/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Login;

import DAO.AccountDAO;

import DAO.UserDAO;
import Model.Account.User;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ChangePasswordController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User account = (User) session.getAttribute("account");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUser(account.getEmail());
            request.setAttribute("user", user);
            request.getRequestDispatcher("frontend/jsp/login/changePassword.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User account = (User) session.getAttribute("account");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUser(account.getEmail());


            request.setAttribute("user", user);

            final String jspPath = "frontend/jsp/login/changePassword.jsp";
            final String errorAttribute = "error";
            AccountDAO accountDAO = new AccountDAO();
            final String password = accountDAO.getPassword(user.getEmail());

            RegexChecking v = new RegexChecking();
            if (request.getParameter("currentPassword").equals(password)) {
                final String newPassword = request.getParameter("newPassword");
                String confirmPassword = request.getParameter("confirmPassword");
                if (v.validatePass(newPassword) && v.validatePass(confirmPassword)) {
                    if (newPassword.equals(password)) {
                        request.setAttribute(errorAttribute, "New password cannot be the same as old password!");
                    } else if (newPassword.equals(confirmPassword)) {
                        accountDAO.changePassword(user.getEmail(), newPassword);
                        request.setAttribute(errorAttribute, "Change password successfully!");
                    } else {
                        request.setAttribute(errorAttribute, "Confirmation password incorrect!");
                    }
                } else {
                    request.setAttribute(errorAttribute, "Please enser new password including uppercase, lowercase, numbers, no whitespace and at least 8 technical characters!");
                }
            } else {
                request.setAttribute(errorAttribute, "The current password is incorrect!");
            }
            request.setAttribute("user", user);
            request.getRequestDispatcher(jspPath).forward(request, response);

        } catch (Exception ex) {
            System.out.println(ex);
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
