/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devzone.services;

import com.devzone.model.TrackOrder;
import com.devzone.util.dbConnect.DBConnection;
import com.devzone.util.query.TrackOrderQueries;
import com.devzone.util.utility.UtilityMethod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dulshan
 */
public class TrackOrderService {
    public TrackOrder specificTrackOrder(String oID) {
        TrackOrder trackOrderData = new TrackOrder();
        PreparedStatement psTrack = null;
        ResultSet rsLoadTrack = null;
        System.out.println("Oder Id :"+oID);
        try {
            Connection conn = DBConnection.Connect();
            psTrack = conn.prepareStatement(TrackOrderQueries.TRACK_SPECIFIC_DATA_QUERY);
            psTrack.setInt(1, UtilityMethod.seperateID(oID));
            rsLoadTrack = psTrack.executeQuery();
            while (rsLoadTrack.next()) {
                if(!rsLoadTrack.getString(1).equals(null)){
                    trackOrderData.settID(UtilityMethod.addPrefix("TR", rsLoadTrack.getString(1)));
                    trackOrderData.settCode(rsLoadTrack.getString(2));
                    trackOrderData.settOID(UtilityMethod.addPrefix("OIR", rsLoadTrack.getString(3)));
                    trackOrderData.settStatus(rsLoadTrack.getString(9));
                    
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                psTrack.close();
                rsLoadTrack.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        
        return trackOrderData;
    }
    
     public boolean trackCodeValidation(String oID,  String tCode) {
        boolean resultVal = false;
        PreparedStatement psTrack = null;
        ResultSet rsLoadTrack = null;
        try {
            Connection conn = DBConnection.Connect();
            psTrack = conn.prepareStatement(TrackOrderQueries.TRACK_VALIDATE_QUERY);
            psTrack.setInt(1, UtilityMethod.seperateID(oID));
            psTrack.setString(2, tCode);
            rsLoadTrack = psTrack.executeQuery();
            while (rsLoadTrack.next()) {
                if(!rsLoadTrack.getString(1).equals(null)){
                    resultVal = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rsLoadTrack.close();
                psTrack.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return resultVal;
    }
     public boolean updateDStatus(String tOID, String status) throws Exception {
        PreparedStatement psOrder = null;
        boolean resultval = false;
                
        Connection conn = DBConnection.Connect();
        psOrder = conn.prepareStatement(TrackOrderQueries.UPDATE_STATUS_QUERY);
        try {
            psOrder.setString(1, status);
            psOrder.setInt(2, UtilityMethod.seperateID(tOID));
            psOrder.executeUpdate();
            resultval = true;
            //AlertPopUp.insertSuccesfully("Allowance Scheme");
            
        } catch (SQLException ex) {
            System.out.println("ex found"+ex);
            //AlertPopUp.insertionFailed(ex, "Allowance Scheme");
        } finally {
            psOrder.close();

        }
        
        return resultval;
    }
}
