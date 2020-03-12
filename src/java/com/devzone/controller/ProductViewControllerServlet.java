package com.devzone.controller;


import com.devzone.services.ProductService;
import com.devzone.model.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductViewControllerServlet extends HttpServlet{
   
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try{
                  loadProduct(request,response);
              }catch(Exception ex){
                  ex.printStackTrace();
              }
        
        String action = null;
        action = request.getParameter("action");
        switch (action){

          case "add":
              try {
                  insertProduct(request,response);
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
                  updateProduct(request,response);
              } catch (Exception e) {
                  e.printStackTrace();
              }
              break;
          case "delete":
              try{
                  deleteProduct(request,response);
              } catch(Exception ex){
                  
              }
          default:
              //list redirect
              try{
                  loadProduct(request,response);
              }catch(Exception e){
                  e.printStackTrace();
              }
              break;
      } 
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
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
        if(resultval){
            response.sendRedirect(request.getContextPath() + "product.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "/Admin/error404.jsp");
        }
    }
    private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ArrayList<Product> productList = new ArrayList<>();
        ProductService productService = new ProductService();
        productList = productService.loadData();
        try{
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("../Admin/product.jsp").forward(request,response);
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    private void setUpdateMaterial(HttpServletRequest request,HttpServletResponse response) throws Exception{
        int ID = Integer.parseInt(request.getParameter("ID"));
        ProductService productService = new ProductService();
        ArrayList<Product> product = productService.selectProduct(ID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../Admin/product.jsp");
        request.setAttribute("productEdit", product);
        dispatcher.forward(request,response);
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
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
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String id = request.getParameter("ID");
        ProductService productService = new ProductService();
        productService.deleteData(id);
        response.sendRedirect(request.getContextPath() + "/Admin/product.jsp");
    }
}
