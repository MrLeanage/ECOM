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

            String action = " ";
            
            switch (action) {
            case "add":
                try {
                    insertProduct(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                try {
                    updateProduct(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
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
        productModel.setpName(request.getParameter("name"));
        productModel.setpDescription(request.getParameter("description"));
        productModel.setpDimention(request.getParameter("dimention"));
        productModel.setpWeight(request.getParameter("weight"));
        productModel.setpColor(request.getParameter("color"));
        productModel.setpMaterial(request.getParameter("material"));
        productModel.setpAvailability(request.getParameter("status"));
        productModel.setpCustomize(request.getParameter("customize"));

        boolean resultval = productService.insertData(productModel);
        if (resultval) {
            response.sendRedirect(request.getContextPath() + "/product.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/Admin/error404.jsp");
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

    private void setUpdateMaterial(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int ID = Integer.parseInt(request.getParameter("ID"));
        ProductService productService = new ProductService();
        ArrayList<Product> product = productService.selectProduct(ID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../Admin/product.jsp");
        request.setAttribute("productEdit", product);
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Product productModel = new Product();

        ProductService productService = new ProductService();
        productModel.setpID(request.getParameter("ID"));
        productModel.setpName(request.getParameter("name"));
        productModel.setpDescription(request.getParameter("description"));
        productModel.setpDimention(request.getParameter("dimention"));
        productModel.setpWeight(request.getParameter("weight"));
        productModel.setpColor(request.getParameter("color"));
        productModel.setpMaterial(request.getParameter("material"));
        productModel.setpAvailability(request.getParameter("status"));
        productModel.setpCustomize(request.getParameter("customize"));

        productService.updateData(productModel);
        response.sendRedirect(request.getContextPath() + "/Admin/product.jsp");

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("ID");
        ProductService productService = new ProductService();
        productService.deleteData(id);
        response.sendRedirect(request.getContextPath() + "/Admin/product.jsp");
    }
}

