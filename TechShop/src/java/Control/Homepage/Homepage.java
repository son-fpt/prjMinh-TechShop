/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Homepage;

import DAO.DAOBrand;
import DAO.DAOCategory;
import DAO.DAOProduct;
import DAO.DAOTechnology;
import Model.Brand.Brand;
import Model.Category.Category;
import Model.Product.Product;
import Model.Technology.Technology;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.function.Predicate;

public class Homepage extends HttpServlet {

    /*
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
        DAOProduct p = new DAOProduct();
        DAOBrand b = new DAOBrand();
        DAOCategory c = new DAOCategory();
        DAOTechnology t = new DAOTechnology();

        List<Product> products;
        List<Brand> brands = b.getAll();
        List<Category> categorys = c.getAll();
        List<Technology> technologys = t.getAll();

        String bid_raw = request.getParameter("bid");
        String cid_raw = request.getParameter("cid");
        String tid_raw = request.getParameter("tid");
        String size_raw = request.getParameter("size");
        
        bid_raw = (bid_raw == null || bid_raw.length() == 0) ? "" : bid_raw;
        cid_raw = (cid_raw == null || cid_raw.length() == 0) ? "" : cid_raw;
        tid_raw = (tid_raw == null || tid_raw.length() == 0) ? "" : tid_raw;
        size_raw = (size_raw == null || size_raw.length() == 0) ? "0" : size_raw;
        String searchContent = request.getParameter("searchContent");
        searchContent = (searchContent == null || searchContent.length() == 0)?"0":searchContent;
        int size = Integer.parseInt(size_raw);
        products = p.searchProduct(bid_raw, cid_raw, tid_raw,searchContent);

        if (size != 0) {
            products.removeIf(s -> (!(s.getSize() == size)));
        }
        
        //paginating
        String pageNow_raw = request.getParameter("page");
        int pageNow;
        if (pageNow_raw == null) {
            pageNow_raw = "1";
        }
        pageNow = Integer.parseInt(pageNow_raw);

        int totalProduct = products.size();

        int productPerPage = 9;
        int totalPage = (totalProduct % productPerPage == 0) ? (totalProduct / productPerPage) : (totalProduct / productPerPage) ;

        int End = productPerPage * pageNow - 1;
        int Start = End + 1 - productPerPage;

        //set attribute
        request.setAttribute("searchContent", searchContent);

        request.setAttribute("page", pageNow);
        request.setAttribute("Start", Start);
        request.setAttribute("End", End);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("bid", bid_raw);
        request.setAttribute("cid", cid_raw);
        request.setAttribute("tid", tid_raw);
        request.setAttribute("products", products);
        request.setAttribute("brands", brands);
        request.setAttribute("categorys", categorys);
        request.setAttribute("technologys", technologys);
        String homePath = "frontend/jsp/homepage/home.jsp";
        request.getRequestDispatcher(homePath).forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
