package com.devzone.services;

import com.devzone.model.Material;
import com.devzone.util.dbConnect.DBConnection;
import com.devzone.util.query.MaterialQueries;
import com.devzone.util.query.ProductQueries;
import com.devzone.util.utility.UtilityMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialService {
    private static ArrayList<Material> materialsData;

    public static List<Material> loadData(){
        try {
            Connection conn = DBConnection.Connect();
           // materialsData = FXCollections.observableArrayList();
            ResultSet rsLoadMaterial = conn.createStatement().executeQuery(MaterialQueries.LOAD_DATA_QUERY);

            while (rsLoadMaterial.next()) {
                materialsData.add(new Material(rsLoadMaterial.getInt(1),rsLoadMaterial.getString(2)));
            }
        } catch (SQLException ex) {

        }
        return materialsData;
    }

    public static boolean insertData(Material material) throws  Exception{
        PreparedStatement psMaterial = null;
        boolean resultval = false;
        try {
            Connection conn = DBConnection.Connect();
            psMaterial = conn.prepareStatement(MaterialQueries.INSERT_DATA_QUERY);

            psMaterial.setString(1,material.getmName());
            psMaterial.execute();
            //AlertPopUp.insertSuccesfully("Allowance Scheme");
            resultval = true;

        } catch (SQLException ex) {
            //AlertPopUp.insertionFailed(ex, "Allowance Scheme");
        }
        finally{
            psMaterial.close();

        }
        return resultval;
    }
    public static List<Material> selectMaterial(int ID){
        List<Material> material = null;
        PreparedStatement psMatrial;
        ResultSet rsLoadMaterial;
        try{
            Connection conn = DBConnection.Connect();
            psMatrial = conn.prepareStatement(MaterialQueries.SELECT_DATA_QUERY);
            psMatrial.setInt(1, ID);
            rsLoadMaterial = psMatrial.executeQuery();
            while (rsLoadMaterial.next()){
                material.add(new Material(rsLoadMaterial.getInt(1),rsLoadMaterial.getString(2)));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return material;
    }


    public static boolean updateData(Material material) throws Exception {
        PreparedStatement psMaterial = null;
        boolean resultVal = false;
        try {
            Connection conn = DBConnection.Connect();
            psMaterial = conn.prepareStatement(ProductQueries.UPDATE_DATA_QUERY);
            psMaterial.setString(1,material.getmName());
            psMaterial.setInt(2, material.getmID());
            psMaterial.execute();
            // AlertPopUp.updateSuccesfully("Allowance Scheme");
            resultVal = true;

        } catch (SQLException ex) {
            // AlertPopUp.updateFailed(ex, "Allowance Scheme");

        } finally {
            //psAllowance.close();
        }
        return resultVal;
    }
    public static Boolean deleteData(String itemID ) throws SQLException {
        PreparedStatement psMaterial = null;
        Boolean resultVal = false;
        Connection conn = DBConnection.Connect();
        try{
            psMaterial = conn.prepareStatement(MaterialQueries.DELETE_DATA_QUERY);
            psMaterial.setInt(1, UtilityMethod.seperateID(itemID));
            psMaterial.executeUpdate();
            //AlertPopUp.deleteSuccesfull("Allowance Scheme");
            resultVal = true;

        }catch (SQLException ex) {
            //AlertPopUp.deleteFailed(ex, "Allowance Scheme");
        }finally{
            //psAllowance.close();
        }
        return resultVal;
    }
/*
    public SortedList<Product> searchTable(String searchField){

        //Retreiving all data from database
        ObservableList<Product> productsData = null;

        try {
            Connection conn = DBConnection.Connect();
            productsData = FXCollections.observableArrayList();
            ResultSet rsLoadProduct = conn.createStatement().executeQuery(ProductQueries.LOAD_DATA_QUERY);

            while (rsLoadProduct.next()) {
                productsData.add(new Product(rsLoadProduct.getString(1),rsLoadProduct.getString(2),rsLoadProduct.getString(3),rsLoadProduct.getString(4),rsLoadProduct.getString(5),rsLoadProduct.getString(6),rsLoadProduct.getString(7),rsLoadProduct.getString(8),rsLoadProduct.getString(9)));
            }
        } catch (SQLException ex) {

        }
        //Wrap the ObservableList in a filtered List (initially display all data)
        FilteredList<Product> filteredData = new FilteredList<>(productsData, b -> true);

        searchField.Listener((observable,oldValue,newValue) ->{
            filteredData.setPredicate(allowance -> {
                //if filter text is empty display all data
                if(newValue == null){
                    return true;
                }
                //comparing search text with table columns one by one
                String lowerCaseFilter = newValue.toLowerCase();

                if(allowance.getaID().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaTitle().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaDescription().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    //return if filter matches data
                    return true;
                }else if(allowance.getaType().toLowerCase().indexOf(lowerCaseFilter) !=-1){
                    //return if filter matches data
                    return true;
                }else if(String.valueOf(allowance.getaValue()).toLowerCase().indexOf(lowerCaseFilter) !=-1){
                    //return if filter matches data
                    return true;
                }else{
                    //have no matchings
                    return false;
                }
            });
        });
        //wrapping the FilteredList in a SortedList
        SortedList<Allowance> sortedData = new SortedList<>(filteredData);
        return sortedData;
    }
 */
}
