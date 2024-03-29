package com.devzone.services;

import com.devzone.model.Order;
import com.devzone.util.dbConnect.DBConnection;
import com.devzone.util.query.OrderQueries;
import com.devzone.util.query.UserQueries;
import com.devzone.util.utility.DataEncryption;
import com.devzone.util.utility.UtilityMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderService {
    private ArrayList<Order> orderData = new ArrayList<Order>();
    public OrderService(){
        
    }
    
    public ArrayList<Order> loadData() {
        try {
            Connection conn = DBConnection.Connect();
            ResultSet rsLoadProduct = conn.createStatement().executeQuery(OrderQueries.LOAD_DATA_QUERY);

            while (rsLoadProduct.next()) {
                orderData.add(new Order(rsLoadProduct.getString(1), rsLoadProduct.getString(2), rsLoadProduct.getString(3), rsLoadProduct.getString(4), rsLoadProduct.getString(5), rsLoadProduct.getString(6), rsLoadProduct.getString(7), rsLoadProduct.getDouble(8), rsLoadProduct.getDouble(9), rsLoadProduct.getInt(10), rsLoadProduct.getString(11)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return orderData;
    }
    public Integer insertData(Order order) throws Exception {
        PreparedStatement psOrder = null;
        Integer resultval = 0;
        ResultSet rs = null;
                
        Connection conn = DBConnection.Connect();
        psOrder = conn.prepareStatement(OrderQueries.INSERT_DATA_QUERY);
        try {
           
            psOrder.setInt(1, UtilityMethod.seperateID(order.getoPID()));
            psOrder.setString(2, order.getoCName());           
            psOrder.setString(3, order.getoCNIC());          
            psOrder.setString(4, order.getoCPhone());        
            psOrder.setString(5, order.getoType());          
            psOrder.setString(6, order.getoDescription());
            psOrder.setDouble(7, order.getoPrice());
            psOrder.setDouble(8, order.getoAdAmount());
            psOrder.setInt(9, order.getoQuantity());
            psOrder.setString(10, order.getoStatus());
            psOrder.execute();
             
            //AlertPopUp.insertSuccesfully("Allowance Scheme");
            rs = conn.createStatement().executeQuery("SELECT MAX(OID) FROM orders");
            while(rs.next()){
                resultval = rs.getInt(1);
            }
        } catch (SQLException ex) {
            //AlertPopUp.insertionFailed(ex, "Allowance Scheme");
        } finally {
            psOrder.close();
            rs.close();

        }
        return resultval;
    }
    public boolean updateDStatus(String oID, String status) throws Exception {
        PreparedStatement psOrder = null;
        boolean resultval = false;
                
        Connection conn = DBConnection.Connect();
        psOrder = conn.prepareStatement(OrderQueries.UPDATE_STATUS_QUERY);
        try {
            psOrder.setString(1, status);
            psOrder.setInt(2, UtilityMethod.seperateID(oID));
            psOrder.execute();
            resultval = true;
            //AlertPopUp.insertSuccesfully("Allowance Scheme");
            
        } catch (SQLException ex) {
            //AlertPopUp.insertionFailed(ex, "Allowance Scheme");
        } finally {
            psOrder.close();

        }
        return resultval;
    }

   public Order specificOrder(String oID) {
        Order orderDataData = new Order();
        PreparedStatement psOrder = null;
        ResultSet rsLoadOrder = null;
        
        try {
            Connection conn = DBConnection.Connect();
            
            psOrder = conn.prepareStatement(OrderQueries.SELECT_DATA_QUERY);
            
            psOrder.setInt(1, UtilityMethod.seperateID(oID));
            rsLoadOrder = psOrder.executeQuery();
            
            
            while (rsLoadOrder.next()) {
                
                orderDataData.setoID(UtilityMethod.addPrefix("OIR", rsLoadOrder.getString(1)));
                orderDataData.setoPID(UtilityMethod.addPrefix("P", rsLoadOrder.getString(2)));
                orderDataData.setoCName(rsLoadOrder.getString(3));
                orderDataData.setoCNIC(rsLoadOrder.getString(4));
                orderDataData.setoCPhone(rsLoadOrder.getString(5));
                orderDataData.setoType(rsLoadOrder.getString(6));
                orderDataData.setoDescription(rsLoadOrder.getString(7));
                orderDataData.setoPrice(rsLoadOrder.getString(8));
                orderDataData.setoAdAmount(String.valueOf(rsLoadOrder.getDouble(9)));
                orderDataData.setoQuantity(rsLoadOrder.getString(10));
                orderDataData.setoStatus(rsLoadOrder.getString(11));
            }
        } catch (SQLException ex) {
        } finally {
            try {
                psOrder.close();
                rsLoadOrder.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
       
        return orderDataData;
    }

    
   public double advancePayCalculation(Integer quantity, Double unitPrice){
       double advancePay = 0;
       if((unitPrice * quantity)<1000){
           advancePay = unitPrice * quantity;
       }else{
           advancePay = ((unitPrice * quantity) / 2);
       }
       return advancePay;
   }
    public double totalPayCalculation(Integer quantity, Double unitPrice){
       return quantity*unitPrice;
   }
}
