/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devzone.services;


import com.devzone.model.User;
import com.devzone.util.dbConnect.DBConnection;
import com.devzone.util.query.ProductQueries;
import com.devzone.util.query.UserQueries;
import com.devzone.util.utility.DataEncryption;
import com.devzone.util.utility.UtilityMethod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dulshan
 */
public class UserService {
    
    public boolean userValidation(String uID,  String password) {
        boolean resultVal = false;
        User user = new User();
        PreparedStatement psUser = null;
        ResultSet rsLoadUser = null;
        try {
            Connection conn = DBConnection.Connect();
            psUser = conn.prepareStatement(UserQueries.SELECT_DATA_QUERY);
            psUser.setString(1, uID);
            psUser.setString(2, DataEncryption.passwordEncryption(password));
            rsLoadUser = psUser.executeQuery();
            while (rsLoadUser.next()) {
                if(!rsLoadUser.getString(1).equals(null)){
                    resultVal = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rsLoadUser.close();
                psUser.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return resultVal;
    }
    public boolean insertData(User user) throws Exception {
        PreparedStatement psUser = null;
        boolean resultval = false;
        try {
            Connection conn = DBConnection.Connect();
            psUser = conn.prepareStatement(UserQueries.INSERT_DATA_QUERY);

            psUser.setString(1, user.getuID());
            psUser.setString(2, user.getuName());
            psUser.setString(3, DataEncryption.passwordEncryption(user.getuPassword()));
            psUser.setString(4, "Activated");
            
            
            psUser.execute();
            //AlertPopUp.insertSuccesfully("Allowance Scheme");
            resultval = true;

        } catch (SQLException ex) {
            //AlertPopUp.insertionFailed(ex, "Allowance Scheme");
        } finally {
            psUser.close();

        }
        return resultval;
    }
}
