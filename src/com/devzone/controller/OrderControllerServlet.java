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
public class OrderControllerServlet extends HttpServlet {

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
                
            case "/Order":
                try {
                    //response.sendRedirect(request.getContextPath() + "/index.jsp");
                    addOrder(request, response);
                } catch (Exception ex) {

                }
                break;
                case "/Order/ProcessToCheckout":
                try {
                    //response.sendRedirect(request.getContextPath() + "/index.jsp");
                    processToCheckout(request, response);
                } catch (Exception ex) {

                }
                break;
                case "/Order/Check":
                try {
                    //response.sendRedirect(request.getContextPath() + "/Public/index.jsp");
                    error404(request, response);
                } catch (Exception ex) {

                }
                case "/Order/TrackLogin":
                try {
                    //response.sendRedirect(request.getContextPath() + "/Public/index.jsp");
                    trackLogin(request, response);
                } catch (Exception ex) {

                }
                break;
                case "/Order/TrackOrder":
                try {
                    //response.sendRedirect(request.getContextPath() + "/Public/index.jsp");
                    trackOrderValidate(request, response);
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
    private void processToCheckout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Order order = new Order();
        OrderService orderService = new OrderService();
        order.setoPID(request.getParameter("ItemNo"));
        order.setoCName(request.getParameter("Name"));
        order.setoPrice(request.getParameter("Price"));
        order.setoQuantity(request.getParameter("Quantity"));
        order.setoAdAmount(String.valueOf(orderService.advancePayCalculation(Integer.valueOf(request.getParameter("Quantity")),Double.valueOf(request.getParameter("Price")))));
        order.setoStatus(String.valueOf(orderService.totalPayCalculation(Integer.valueOf(request.getParameter("Quantity")),Double.valueOf(request.getParameter("Price")))));
        try {
            
            request.setAttribute("orderInfo", order);
            request.getRequestDispatcher("/Public/checkout.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Order order  = new Order();
        Order resultOrderData = new Order();
        OrderService orderService = new OrderService();
        
        order.setoPID(request.getParameter("ItemNo"));
        order.setoCName(request.getParameter("Name"));
        order.setoCNIC(request.getParameter("NIC"));
        order.setoCPhone(request.getParameter("Phone"));
        order.setoType("Not Customized");
        order.setoDescription("Not Customized");
        order.setoPrice(request.getParameter("Price"));
        order.setoAdAmount(request.getParameter("AdAmount"));
        order.setoQuantity(request.getParameter("Quantity"));
        order.setoStatus("Pending");
        
        Integer lastID = orderService.insertData(order);
        
        try{
            resultOrderData = orderService.specificOrder(UtilityMethod.addPrefix("OIR", String.valueOf(lastID)));
        }catch(Exception ex){
            System.out.println("Exception is:"+ex);
        }
         System.out.println("Order Status:"+resultOrderData.getoStatus());
        if(!(resultOrderData.getoID().equals(null)) || !(resultOrderData.getoID().isEmpty())){
            try {
                Product product = new Product();
                ProductService productService = new ProductService();
                product = productService.specificProduct(request.getParameter("ItemNo"));
                
                TrackOrder trackOrder = new TrackOrder();
                TrackOrderService trackOrderService = new TrackOrderService();
                String tCode = trackOrderService.insertData(UtilityMethod.seperateID(resultOrderData.getoID()));
                trackOrder = trackOrderService.specificTrackOrder(resultOrderData.getoID(), tCode);
                
                request.setAttribute("productInfo", product);
                request.setAttribute("trackInfo", trackOrder);
                request.setAttribute("orderInfo", resultOrderData);
                request.getRequestDispatcher("/Public/orderSuccess.jsp").forward(request, response);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            
           response.sendRedirect(request.getContextPath() + "/Products");
        }

    }
    private void loadSpecificProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Product specificProduct = new Product();
        log("id no :"+request.getParameter("itemNo"));
        ProductService productService = new ProductService();
        specificProduct = productService.specificProduct(request.getParameter("itemNo"));
        try {
            
            request.setAttribute("specificProduct", specificProduct);
            request.getRequestDispatcher("/Public/product.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private void loadSpecificTrackOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Product specificProduct = new Product();
        log("id no :"+request.getParameter("itemNo"));
        ProductService productService = new ProductService();
        specificProduct = productService.specificProduct(request.getParameter("itemNo"));
        try {
            
            request.setAttribute("specificProduct", specificProduct);
            request.getRequestDispatcher("/Public/product.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
     private void trackOrderValidate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        TrackOrderService trackOrderService = new TrackOrderService();
        
        boolean resultVal = false;
        String validOID = null;
        String checkVal = "check";
         
        try{
            //System.out.println("Value :"+UtilityMethod.seperateID("100IP"));
            validOID = String.valueOf(UtilityMethod.seperateID(request.getParameter("OID")));
        }catch(Exception ex){
            checkVal = "failed";
        }
        if(!(request.getParameter("OID").isEmpty()) && !(request.getParameter("TCode").isEmpty())&& (checkVal.equals("check"))){
            resultVal = trackOrderService.trackCodeValidation(request.getParameter("OID"), request.getParameter("TCode"));
            
            if(resultVal){
                
                TrackOrder trackOrderData = new TrackOrder();
                TrackOrderService trackService = new TrackOrderService();
                trackOrderData = trackService.specificTrackOrder(request.getParameter("OID"), request.getParameter("TCode"));
                
                if(!(trackOrderData.gettOID().isEmpty()) || !(trackOrderData.gettOID().equals(null))){
                    Order orderData = new Order();
                    OrderService orderService = new OrderService();
                    
                    orderData = orderService.specificOrder(trackOrderData.gettOID());
                    
                    if(!(orderData.getoID().isEmpty()) || !(orderData.getoID().equals(null))){
                        Product productData = new Product();
                        
                        ProductService productService = new ProductService();
                        
                        productData = productService.specificProduct(orderData.getoPID());
                        
                        request.setAttribute("productInfo", productData);
                        request.setAttribute("orderInfo", orderData);
                        request.setAttribute("trackInfo", trackOrderData);
                        request.setAttribute("uErrorMsg", "hidden");
                        request.getRequestDispatcher("/Public/track.jsp").forward(request, response);
                    }
                }

                response.sendRedirect(request.getContextPath() + "/Order");
            }else{
                log("trackOrder Enters2");
                request.setAttribute("uErrorMsg", "");
                request.getRequestDispatcher("/Public/trackOrderLogin.jsp").forward(request, response);
            }
        }else{
            log("trackOrder Enters4");
                request.setAttribute("uErrorMsg", "");
                request.getRequestDispatcher("/Public/trackOrderLogin.jsp").forward(request, response);
        }
        
    }
    private void error404(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
    private void trackLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("uErrorMsg", "hidden");
        request.getRequestDispatcher("/Public/trackOrderLogin.jsp").forward(request, response);
    }
}
