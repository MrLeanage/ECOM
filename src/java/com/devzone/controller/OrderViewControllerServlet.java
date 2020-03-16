/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devzone.controller;

import com.devzone.model.Order;
import com.devzone.model.Product;
import com.devzone.model.TrackOrder;
import com.devzone.services.OrderService;
import com.devzone.services.ProductService;
import com.devzone.services.TrackOrderService;
import com.devzone.util.utility.UtilityMethod;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dulshan
 */
public class OrderViewControllerServlet extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
            try {

            String action = request.getServletPath();
            switch (action) {
            case "/Order/FormAction":
                
                try {
                     updateOrder(request, response);
                }catch (Exception e) {
                      error404(request,response);
                 }
                
                
                
                break;
                
            case "/Order/OrderInfo":
                try {
                    loadSpecificOrder(request, response);
                } catch (Exception ex) {
                    error404(request,response);
                }
            default:
                //list redirect
                try {
                    loadOrder(request, response);
                } catch (Exception e) {
                    error404(request,response);
                }
                break;
        }

            } catch (Exception e) {
                error404(request,response);
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
	
	

    private void loadOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Order> orderList = new ArrayList<>();
        OrderService orderService = new OrderService();
        orderList = orderService.loadData();
        try {
            //System.out.printf( "%.3f GB\n", size);
            double size = UtilityMethod.getDiskSpaceSize();
            
            request.setAttribute("usage", size);
            request.setAttribute("OrderList", orderList);
            request.getRequestDispatcher("/Admin/index.jsp").forward(request, response);

        } catch (Exception ex) {
            error404(request,response);
        }

    }
    private void loadSpecificOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Order orderData = new Order();
        OrderService orderService = new OrderService();
        Product productdata = new Product();
        ProductService productService = new ProductService();
        TrackOrder trackOrderData = new TrackOrder();
        TrackOrderService trackOrderService = new TrackOrderService();
        
        orderData = orderService.specificOrder(request.getParameter("oID"));
        
        if(!(orderData.getoPID().isEmpty())){
            
            productdata = productService.selectProduct(orderData.getoPID());
            
            trackOrderData = trackOrderService.specificTrackOrder(orderData.getoID());
            
            try {
            double size = UtilityMethod.getDiskSpaceSize();
            request.setAttribute("usage", size);
            request.setAttribute("orderData", orderData);
            request.setAttribute("productData", productdata);
            request.setAttribute("trackOrderData", trackOrderData);
                
            request.getRequestDispatcher("/Admin/orderinfo.jsp").forward(request, response);
        } catch (Exception ex) {
            error404(request,response);
        }
        }
        

    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        boolean orderResult = false;
        boolean trackResult = false;
        OrderService orderService = new OrderService();
        TrackOrderService trackOrderService = new TrackOrderService();
        String oID = request.getParameter("oID");
        try{
            trackResult = trackOrderService.updateDStatus(oID, request.getParameter("tStatus"));
            orderResult = orderService.updateDStatus(oID, request.getParameter("oStatus"));
           
            request.setAttribute("oIDs", oID);
            request.getRequestDispatcher("/Order/OrderInfo?oID="+oID).forward(request, response);
            
            //response.sendRedirect(request.getContextPath() + "/Login");
        }catch(Exception ex){
            error404(request,response);
        }
        
    }
    private void error404(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/Admin/error404.jsp");
    }
    
}
