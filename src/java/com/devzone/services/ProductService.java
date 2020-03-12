package com.devzone.services;

import com.devzone.model.Product;
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

public class ProductService {

    private ArrayList<Product> productsData = new ArrayList<Product>();

    public ArrayList<Product> loadData() {
        try {
            Connection conn = DBConnection.Connect();
            ResultSet rsLoadProduct = conn.createStatement().executeQuery(ProductQueries.LOAD_DATA_QUERY);

            while (rsLoadProduct.next()) {
                productsData.add(new Product(rsLoadProduct.getString(1), rsLoadProduct.getString(2), rsLoadProduct.getString(3), rsLoadProduct.getString(4), rsLoadProduct.getString(5), rsLoadProduct.getString(6), rsLoadProduct.getString(7), rsLoadProduct.getString(8), rsLoadProduct.getString(9)));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return productsData;
    }

    public ArrayList<Product> selectProduct(int ID) {

        PreparedStatement psProduct = null;
        ResultSet rsLoadProduct = null;
        try {
            Connection conn = DBConnection.Connect();
            psProduct = conn.prepareStatement(ProductQueries.SELECT_DATA_QUERY);
            psProduct.setInt(1, ID);
            rsLoadProduct = psProduct.executeQuery();
            while (rsLoadProduct.next()) {
                productsData.add(new Product(rsLoadProduct.getString(1), rsLoadProduct.getString(2), rsLoadProduct.getString(3), rsLoadProduct.getString(4), rsLoadProduct.getString(5), rsLoadProduct.getString(6), rsLoadProduct.getString(7), rsLoadProduct.getString(8), rsLoadProduct.getString(9)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                psProduct.close();
                rsLoadProduct.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return productsData;
    }

    public boolean insertData(Product product) throws Exception {
        PreparedStatement psProduct = null;
        boolean resultval = false;
        try {
            Connection conn = DBConnection.Connect();
            psProduct = conn.prepareStatement(ProductQueries.INSERT_DATA_QUERY);

            psProduct.setString(1, product.getpName());
            psProduct.setString(2, product.getpDescription());
            psProduct.setString(3, product.getpDimention());
            psProduct.setString(4, product.getpWeight());
            psProduct.setString(5, product.getpColor());
            psProduct.setString(6, product.getpMaterial());
            psProduct.setString(7, product.getpAvailability());
            psProduct.setString(8, product.getpCustomize());
            psProduct.execute();
            //AlertPopUp.insertSuccesfully("Allowance Scheme");
            resultval = true;

        } catch (SQLException ex) {
            //AlertPopUp.insertionFailed(ex, "Allowance Scheme");
        } finally {
            psProduct.close();

        }
        return resultval;
    }

    public boolean updateData(Product product) throws Exception {
        PreparedStatement psProduct = null;
        boolean resultVal = false;
        try {
            Connection conn = DBConnection.Connect();
            psProduct = conn.prepareStatement(ProductQueries.UPDATE_DATA_QUERY);
            psProduct.setString(1, product.getpName());
            psProduct.setString(2, product.getpDescription());
            psProduct.setString(3, product.getpDimention());
            psProduct.setString(4, product.getpWeight());
            psProduct.setString(5, product.getpColor());
            psProduct.setString(6, product.getpMaterial());
            psProduct.setString(7, product.getpAvailability());
            psProduct.setString(8, product.getpCustomize());
            psProduct.setInt(9, UtilityMethod.seperateID(product.getpID()));
            psProduct.execute();
            // AlertPopUp.updateSuccesfully("Allowance Scheme");
            resultVal = true;

        } catch (SQLException ex) {
            // AlertPopUp.updateFailed(ex, "Allowance Scheme");

        } finally {
            //psAllowance.close();
        }
        return resultVal;
    }

    public Boolean deleteData(String itemID) throws SQLException {
        PreparedStatement psProduct = null;
        Boolean resultVal = false;
        Connection conn = DBConnection.Connect();
        try {
            psProduct = conn.prepareStatement(ProductQueries.DELETE_DATA_QUERY);
            psProduct.setInt(1, UtilityMethod.seperateID(itemID));
            psProduct.executeUpdate();
            //AlertPopUp.deleteSuccesfull("Allowance Scheme");
            resultVal = true;

        } catch (SQLException ex) {
            //AlertPopUp.deleteFailed(ex, "Allowance Scheme");
        } finally {
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
