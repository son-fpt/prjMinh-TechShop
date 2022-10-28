/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Login;

import DAO.AccountDAO;
import Model.Account.Role;
import Model.Account.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;


public class VerificationEmail extends HttpServlet {

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
        request.getRequestDispatcher("frontend/jsp/login/CodeVerify.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        String codeCheck = (String) session.getAttribute("code");
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
        String pass = (String) session.getAttribute("pass");
        String raw_gender = (String) session.getAttribute("raw_gender");
        boolean gender = raw_gender.equals("Male");
        String mobile = (String) session.getAttribute("mobile");
        String address = (String) session.getAttribute("address");
        String raw_dob = (String) session.getAttribute("raw_dob");
        Date dob = Date.valueOf(raw_dob);
        String codeInput = request.getParameter("codeInput");
        
        String codeVerifyJsp = "frontend/jsp/login/CodeVerify.jsp";
        if (codeCheck.equals(codeInput)) {

            AccountDAO dAc = new AccountDAO();

            //insert to user table
            User u = new User();
            u.setEmail(email);
            u.setName(name);
            u.setGender(gender);
            u.setPhone(mobile);
            u.setAddress(address);
            u.setDob(dob);
            u.setPassword(pass);
            Role r = new Role();
            r.setId(3);
            u.setRole(r);

            dAc.insertAccount(u);

            response.sendRedirect("home"); //send to home page
        } else {
            String notCorrect = "Wrong code. Try again!";
            request.setAttribute("notCorrect", notCorrect);
            request.getRequestDispatcher(codeVerifyJsp).forward(request, response);
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
