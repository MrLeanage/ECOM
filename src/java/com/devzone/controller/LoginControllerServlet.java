/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devzone.controller;

import com.devzone.model.User;
import com.devzone.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dulshan
 */
public class LoginControllerServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                String action = request.getServletPath();
            log("called from"+ action);
            switch (action){
                case "/Login/New":
                    addUser(request, response);
                    break;
                case "/Login/Validate":
                    userValidate(request, response);
                    break;
                default :
                    response.sendRedirect(request.getContextPath() + "/Admin/login.jsp");
                    break;
            }
            }catch(Exception ex){
                
            }
        }
        
    }
    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void userValidate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        UserService userServices = new UserService();
        boolean resultVal = userServices.userValidation(request.getParameter("uID"), request.getParameter("uPassword"));
        if(resultVal){
            response.sendRedirect(request.getContextPath() + "/Order");
        }else{
            request.setAttribute("uErrorMsg", "User ID or Password Invalid");
            request.getRequestDispatcher("/Login").forward(request, response);
        }
    }
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception{
        log("Called inside");
        UserService userServices = new UserService();
        User user = new User();
        user.setuID(request.getParameter("uID"));
        user.setuName(request.getParameter("uName"));
        user.setuPassword(request.getParameter("uPassword"));
        boolean resultVal = userServices.insertData(user);
        log("result val"+resultVal);
        if(resultVal){
            request.setAttribute("uErrorMsg", "Registration Success Please Login");
            request.getRequestDispatcher("/Login").forward(request, response);
        }else{
            request.setAttribute("uErrorMsg", "User Registration Failed");
            request.getRequestDispatcher("/Login").forward(request, response);
        }
    }

}
