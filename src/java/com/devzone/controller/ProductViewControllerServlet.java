package com.devzone.controller;


import com.devzone.services.ProductService;
import com.devzone.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductViewControllerServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private ArrayList<Product> productList;
    public ProductViewControllerServlet(){
        ArrayList<Product> productList = ProductService.loadData();
    }
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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String action = null;
        action = request.getParameter("action");
        
            try{
                  loadMaterials(request,response);
              }catch(Exception e){
                  e.printStackTrace();
              }
        /*
        switch (action){

          case "add":
              try {
                  insertMaterial(request,response);
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
                  
              } catch (Exception e) {
                  e.printStackTrace();
              }
              break;
          case "null":
              try{
                  loadMaterials(request,response);
              }catch(Exception e){
                  e.printStackTrace();
              }
              break;
          default:
              //list redirect
              
      }
       */     
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductViewControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
        //response.sendRedirect(request.getContextPath() + "/Admin/product.jsp");
        
        
        
    }
    private void insertMaterial(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
    private void loadMaterials(HttpServletRequest request, HttpServletResponse response) throws Exception{
         
        
        try{
            
            
            
            //request.setAttribute("productList", productList);
            request.getRequestDispatcher("/Admin/product.jsp").forward(request,response);
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        //request.getRequestDispatcher("/Admin/product-customize.jsp").forward(request,response);
    }
}
