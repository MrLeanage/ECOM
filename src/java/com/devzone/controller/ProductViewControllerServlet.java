/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devzone.controller;
import com.devzone.model.Product;
import com.devzone.services.ProductService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductViewControllerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
            try {

            String action = request.getServletPath();
                log("Hello"+action);
                    
            switch (action) {
            case "/Product/Add":
                try {
                    insertProduct(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/Product/Edit":
                try {
                    setUpdateProduct(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/Product/Update":
                try {
                    updateProduct(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/Product/Delete":
                try {
                    deleteProduct(request, response);
                } catch (Exception ex) {

                }
            default:
                //list redirect
                try {
                    loadProduct(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
	
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Product productModel = new Product();
        ProductService productService = new ProductService();
        productModel.setpName(request.getParameter("pName"));
        productModel.setpDescription(request.getParameter("pDescription"));
        productModel.setpDimention(request.getParameter("pDimention"));
        productModel.setpWeight(request.getParameter("pWeight"));
        productModel.setpColor(request.getParameter("pColor"));
        productModel.setpMaterial(request.getParameter("pMaterial"));
        productModel.setpAvailability(request.getParameter("pAvailability"));
        productModel.setpCustomize(request.getParameter("pCustomize"));
        boolean resultval = productService.insertData(productModel);
        if (resultval) {
            response.sendRedirect(request.getContextPath() + "/Product");
        } else {
            error404(request, response);
        }
    }

    private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Product> productList = new ArrayList<>();
        ProductService productService = new ProductService();
        productList = productService.loadData();
        try {
            
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/Admin/product.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void setUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ProductService productService = new ProductService();
        
        Product product = new Product();
        product = productService.selectProduct(request.getParameter("actionID"));
        request.setAttribute("pID", product.getpID());
        getServletContext().setAttribute("pName", product.getpName());
        request.setAttribute("pDescription", product.getpDescription());
        request.setAttribute("pDimention", product.getpDimention());
        request.setAttribute("pWeight", product.getpWeight());
        request.setAttribute("pColor", product.getpColor());
        request.setAttribute("pMaterial", product.getpMaterial());
        request.setAttribute("pAvailability", product.getpAvailability());
        request.setAttribute("pCustomize", product.getpCustomize());
        request.setAttribute("pPrice", product.getpPrice());
        request.setAttribute("pImage1", product.getpImage1());
        request.setAttribute("pImage2", product.getpImage2());
        request.setAttribute("pImage3", product.getpImage3());
        request.setAttribute("pCoverProduct", product.getpCoverProduct());
        log("Executed to end"+product.getpName());
        request.getRequestDispatcher("/Product").forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Product productModel = new Product();

        ProductService productService = new ProductService();
        productModel.setpID(request.getParameter("selectionID"));
        productModel.setpName(request.getParameter("pName"));
        productModel.setpDescription(request.getParameter("pDescription"));
        productModel.setpDimention(request.getParameter("pDimention"));
        productModel.setpWeight(request.getParameter("pWeight"));
        productModel.setpColor(request.getParameter("pColor"));
        productModel.setpMaterial(request.getParameter("pMaterial"));
        productModel.setpAvailability(request.getParameter("pAvailability"));
        productModel.setpCustomize(request.getParameter("pCustomize"));
        
        productService.updateData(productModel);
        response.sendRedirect(request.getContextPath() + "/Product");

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        
        System.out.println("this is delete "+request.getParameter("addButton"));
        ProductService productService = new ProductService();
        Boolean resultVal = productService.deleteData(request.getParameter("actionID"));
        if(resultVal){
            response.sendRedirect(request.getContextPath() + "/Product");
        }else{
            response.sendRedirect(request.getContextPath() + "/Admin/error404.jsp");
        }
        
    }
    private void error404(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/Admin/error404.jsp");
    }
}

