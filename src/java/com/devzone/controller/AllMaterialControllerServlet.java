package com.devzone.controller;

import com.devzone.services.MaterialService;
import com.devzone.model.Material;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AllMaterialControllerServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            loadMaterials(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AllMaterialControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
        String action = request.getServletPath();
        
        
        /*
      switch (action){

          case "/insert":
              try {
                  insertMaterial(request,response);
              } catch (Exception e) {
                  e.printStackTrace();
              }
              break;
          case "/edit":
              try {
                  setUpdateMaterial(request,response);
              } catch (Exception e) {
                  e.printStackTrace();
              }
              break;
          case "/update":
              try {
                  updateMaterial(request,response);
              } catch (Exception e) {
                  e.printStackTrace();
              }
              break;
          case "/delete":
              try {
                  deleteMaterial(request,response);
              } catch (SQLException e) {
                  e.printStackTrace();
              }
              break;
          default:
              //list redirect
              try {
                  //loadMaterials(request,response);
              } catch (Exception e) {
                  e.printStackTrace();
              }
              break;
      }
*/
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void loadMaterials(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        //response.sendRedirect(request.getContextPath() + "/Admin/product-customize.jsp");
        request.getRequestDispatcher("/Admin/product-customize.jsp").forward(request,response);

        
    }
    private void insertMaterial(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        Material material = new Material();
        material.setmName(name);
        MaterialService.insertData(material);
        response.sendRedirect("list");
    }
    private void setUpdateMaterial(HttpServletRequest request,HttpServletResponse response) throws Exception{
        int ID = Integer.parseInt(request.getParameter("ID"));
        List<Material> material = MaterialService.selectMaterial(ID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../Admin/product-customize.jsp");
        request.setAttribute("material", material);
        dispatcher.forward(request,response);
    }
    private void updateMaterial(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int id = Integer.parseInt(request.getParameter("ID"));
        String mName = request.getParameter("mName");

        Material material = new Material(id,mName);
        MaterialService.updateData(material);
        response.sendRedirect("list");

    }
    private void deleteMaterial(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String id = request.getParameter("ID");
        MaterialService.deleteData(id);
        response.sendRedirect("list");
    }



}