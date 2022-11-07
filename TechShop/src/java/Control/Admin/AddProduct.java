/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Admin;

import DAO.DAOBrand;
import DAO.DAOCategory;
import DAO.DAOProduct;
import DAO.DAOTechnology;
import Model.Account.User;
import Model.Brand.Brand;
import Model.Category.Category;
import Model.Product.Product;
import Model.Technology.Technology;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Administrator
 */
@MultipartConfig
public class AddProduct extends HttpServlet {

    final String addPro = "../frontend/jsp/host/addproduct.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hs = request.getSession();
        User user = (User) hs.getAttribute("account");
        if (user != null && user.getRole().getName().equals("Admin")) {
            DAOCategory cdao = new DAOCategory();
            DAOBrand bdao = new DAOBrand();
            DAOTechnology tdao = new DAOTechnology();
            List<Category> listCategory = cdao.getAll();
            List<Brand> listBrand = bdao.getAll();
            List<Technology> listTech = tdao.getAll();
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("listBrand", listBrand);
            request.setAttribute("listTech", listTech);
            request.setAttribute("account", user);
            request.getRequestDispatcher(addPro).forward(request, response);
        } else {
            response.getWriter().println("Access Denied!");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cate_raw = request.getParameter("cate");
        String brand_raw = request.getParameter("brand");
        String tech_raw = request.getParameter("tech");
        String pid_raw = request.getParameter("pid");
        String pname_raw = request.getParameter("pname");
        String size_raw = request.getParameter("size");
        String price_raw = request.getParameter("price");
        String des_raw = request.getParameter("des");
        Part part = request.getPart("image");
        String photo = uploadPhoto(part);

        int size = Integer.parseInt(size_raw);
        double price = Double.parseDouble(price_raw);

        Category c = new Category();
        c.setId(cate_raw);
        Brand b = new Brand();
        b.setId(brand_raw);
        Technology t = new Technology();
        t.setId(tech_raw);
        Product p = new Product();
        p.setId(pid_raw);
        p.setName(pname_raw);
        p.setCate(c);
        p.setBrand(b);
        p.setTech(t);
        p.setSize(size);
        p.setPrice(price);
        p.setDes(des_raw);
        p.setImage(photo);
        DAOProduct pdao = new DAOProduct();
        pdao.insert(p);
        response.sendRedirect("list");
    }

    private String uploadPhoto(Part part) {

        String fileName, pathWithBuild, pathNoBuild;
        InputStream is1, is2;
        UploadFile uploadFile;

        fileName = part.getSubmittedFileName();

        pathWithBuild = getServletContext().getRealPath("photo");
        pathNoBuild = pathWithBuild.substring(0, pathWithBuild.indexOf("build")) + "web" + File.separator + "photo";

        pathWithBuild += File.separator + fileName;
        pathNoBuild += File.separator + fileName;
        try {
            is1 = part.getInputStream();
            is2 = part.getInputStream();
            uploadFile = new UploadFile();
            uploadFile.uploadFile(is1, pathWithBuild);
            uploadFile.uploadFile(is2, pathNoBuild);
            return "photo" + "/" + fileName;
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return "";
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
