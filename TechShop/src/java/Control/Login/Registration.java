/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Login;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.AccountDAO;
import Model.Account.User;


public class Registration extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("frontend/jsp/login/registration.jsp").forward(request, response);
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
        String raw_fullName = request.getParameter("name");
        String raw_email = request.getParameter("email");
        String raw_pass = request.getParameter("password");
        String raw_mobile = request.getParameter("mobile");
        String raw_gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String raw_dob = request.getParameter("dob");

        RegexChecking v = new RegexChecking();
        
        final String registrationJsp = "frontend/jsp/login/registration.jsp";
        //check information of user is validated
        if (v.checkString(raw_fullName) && v.validateEmail(raw_email) && v.validatePass(raw_pass) && v.validateMobile(raw_mobile)) {
            String name = raw_fullName;
            String email = raw_email;
            String pass = raw_pass;
            String mobile = raw_mobile;

            AccountDAO dAc = new AccountDAO();
            //check email is exist
            User accExist = dAc.getAccount(email, pass);

            if (accExist == null) {
                SendEmail sendEmail = new SendEmail();
                //Random code to sendEmail
                int numberOfCharactor = 8;
                String code = sendEmail.randomAlphaNumeric(numberOfCharactor);
                //save code in session
                request.getSession().setAttribute("code", code);
                request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("pass", pass);
                request.getSession().setAttribute("raw_gender", raw_gender);
                request.getSession().setAttribute("mobile", mobile);
                request.getSession().setAttribute("address", address);
                request.getSession().setAttribute("raw_dob", raw_dob);
                request.getSession().setAttribute("name", name);

                String subject = "Authenticate gmail";
                String message = "<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "\n"
                        + "<head>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <h3 style=\"color: blue;\">Thank you for registering and participating in our program.</h3>\n"
                        + "    <div>For your and our safety, we want you to make sure that the email you use to sign up is authenticated.</div>\n"
                        + "    <div>Enter the code below to authenticate.</div><br/>\n"
                        + "    <div>Code: " + code + "</div>\n"
                        + "    <h3 style=\"color: blue;\">Thank you so much!</h3>\n"
                        + "\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>";
                SendEmail.send(email, subject, message, sendEmail.getUser(), sendEmail.getPass());
                response.sendRedirect("verificationRegister");       
            } else {
                String exist = "This account is already exist. Try a new email!";
                request.setAttribute("exist", exist);
                request.getRequestDispatcher(registrationJsp).forward(request, response);
            }
        } else {
            String error = "You need to enter the correct requirements for each subscription.";
            request.setAttribute("error", error);
            request.getRequestDispatcher(registrationJsp).forward(request, response);
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
