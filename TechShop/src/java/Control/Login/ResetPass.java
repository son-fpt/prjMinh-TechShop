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


public class ResetPass extends HttpServlet  {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
        request.getRequestDispatcher("frontend/jsp/login/resetPass.jsp").forward(request, response);
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
        AccountDAO dAc = new AccountDAO();
        User existAccount = dAc.getEmail(email);
        if (existAccount != null) {
            SendEmail sendEmail = new SendEmail();

            request.getSession().setAttribute("existAccount", existAccount);
            request.getSession().setAttribute("email", email);
            int numberOfCharactor = 8;
            String randomPass = sendEmail.randomAlphaNumeric(numberOfCharactor);
            request.getSession().setAttribute("randomPass", randomPass);

            String subject = "Forgot Password";
            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Reset password</h3>\n"
                    + "    <div>To make sure this is your personal Gmail. We have sent the code, please enter the code to verify.</div>\n"
                    + "    <div>Enter the code below to authenticate.</div><br/>\n"
                    + "    <div>Pass:"+randomPass+"</div>\n"
                    + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            SendEmail.send(email, subject, message, sendEmail.getUser(), sendEmail.getPass());
            response.sendRedirect("EnterNewPass");
        } else {
            String notExist = "Your email is not exist. Please try again!";
            request.setAttribute("notExist", notExist);
            request.getRequestDispatcher("frontend/jsp/login/resetPass.jsp").forward(request, response);
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
