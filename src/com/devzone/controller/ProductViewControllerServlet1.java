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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dulshan
 */
public class ProductViewControllerServlet1 extends HttpServlet {

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
        String action = request.getServletPath();
        log("calling "+action);
            switch (action) {
                
            case "/Home":
                try {
                    //response.sendRedirect(request.getContextPath() + "/Public/index.jsp");
                    loadHomeProduct(request, response);
                } catch (Exception ex) {

                }
                break;
            case "/Products":
                try {
                    //response.sendRedirect(request.getContextPath() + "/Public/index.jsp");
                    loadAllProduct(request, response);
                } catch (Exception ex) {

                }
                break;
                case "/Product":
                try {
                    //response.sendRedirect(request.getContextPath() + "/Public/index.jsp");
                    loadSpecificProduct(request, response);
                } catch (Exception ex) {

                }
                break;
            default:
                //list redirect
                try {
                    error404(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
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
    
 private void loadHomeProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Product> productList = new ArrayList<>();
        ProductService productService = new ProductService();
        productList = productService.loadHomeData();
        try {
            
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/Public/index.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
 private void loadAllProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Product> productList = new ArrayList<>();
        ProductService productService = new ProductService();
        productList = productService.loadData();
        try {
            
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/Public/allProducts.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
 private void loadSpecificProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Product specificProduct = new Product();
        ProductService productService = new ProductService();
        specificProduct = productService.specificProduct(request.getParameter("itemNo"));
        try {
            
            request.setAttribute("specificProduct", specificProduct);
            request.getRequestDispatcher("/Public/product.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    
    private void error404(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/Public/error.jsp");
    }
}
